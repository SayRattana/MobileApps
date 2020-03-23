package com.example.easylearning.myapps;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.InputType;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.easylearning.IMyActivity.IMyActivity;
import com.example.easylearning.MainActivity;
import com.example.easylearning.R;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

public class SignInActivity extends AppCompatActivity implements IMyActivity {

    private EditText etUserEmail, etUserPassword;
    private ImageButton imgbtnShowHidePassword;
    private Boolean isImgbtnshowHidePassword = false;
    private CheckBox cbRemember;
    private Button btnSignIn;
    private Button btnFacebook_Singin,btnGoogle_Signin;

    //private SignInButton btngoogle_signin;              // for google signin button.
    private GoogleSignInClient mgoogleSignInClient;     // for google signin button.
    private String TAG ="SigninActivity";               // for google signin button.
    private int RC_SIGN_IN=1;

    private TextView tvSignUp,tvForgotPassword,tvShowAttempts;
    private ImageView ivSignPlus;
    private FirebaseAuth mFirebaseAuth;                 // for google signin button(have already).
    private FirebaseAuth.AuthStateListener mAuthStateListener;
    private  ProgressDialog progressDialog;
    private int counter=3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

    /**-->Start of Code Header Toolbar */
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("SIGN IN");
        this.setSupportActionBar(toolbar);
    /**<--End of Code Header Toolbar */

            mapUIToProperties();
            setUpAction();
            mapbtnGoogleUI();
            //mapbtnFacebook();


    } // This braces for close void onCreate(Bundle savedInstanceState)


    @Override
    public void mapUIToProperties() {
        mFirebaseAuth = FirebaseAuth.getInstance();
        etUserEmail = findViewById(R.id.etUserEmail);
        etUserPassword = findViewById(R.id.etUserPassword);
        imgbtnShowHidePassword = findViewById(R.id.imgbtnShowHidePassword);
        cbRemember = findViewById(R.id.cbRemember);
        btnSignIn = findViewById(R.id.btnSignIn);
        btnFacebook_Singin = findViewById(R.id.btnfacebook_signin);
        btnGoogle_Signin = findViewById(R.id.btngoogle_signin);          // for google signin button.
        tvForgotPassword = findViewById(R.id.tvForgotPassword);
        tvShowAttempts = findViewById(R.id.tvShowAttempts);
        tvSignUp = findViewById(R.id.tvSignUp);
        ivSignPlus= findViewById(R.id.ivSignPlus);
        progressDialog = new ProgressDialog(this);

    }


    @Override
    public void setUpAction() {
        mAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser mFirebaseUser = mFirebaseAuth.getCurrentUser();
                if (mFirebaseUser != null) {
                    Toast.makeText(SignInActivity.this, "You are logged in ", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(SignInActivity.this, SuccessfulActivity.class);
                    startActivity(i);
                } else {
                    Toast.makeText(SignInActivity.this, "Please login ", Toast.LENGTH_SHORT).show();
                }
            }
        };


        /**--> Start of Code Checkbox remember */

            cbRemember.setOnClickListener(v -> {
                if(cbRemember.isChecked()){
                    cbRemember.setTextColor(getColorStateList(R.color.colorPrimaryDark));
                    cbRemember.setButtonTintList(getColorStateList(R.color.colorPrimaryDark));
                }else {
                    cbRemember.setTextColor(getColorStateList(R.color.ColorGray));
                    cbRemember.setButtonTintList(getColorStateList(R.color.ColorGray));
                }
            });
        /**<-- End of Code Checkbox remember */

        /**--> Start of Code Show/Hidden Password */
        imgbtnShowHidePassword.setOnClickListener(v -> {
                isImgbtnshowHidePassword = !isImgbtnshowHidePassword;
            etUserPassword.setInputType(isImgbtnshowHidePassword?
                        InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD :
                        InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        });
        /**<-- End of Code Show/Hidden Password */


        /**--> Start of Code Button SingIn */
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = etUserEmail.getText().toString();
                String pass = etUserPassword.getText().toString();
                if (email.isEmpty()) {
                    etUserEmail.setError("Please enter your email id");
                    etUserEmail.requestFocus();
                } else if (pass.isEmpty()) {
                    etUserPassword.setError("Please enter your password");
                    etUserPassword.requestFocus();
                } else if (email.isEmpty() && pass.isEmpty()) {
                    Toast.makeText(SignInActivity.this, "Field are empty", Toast.LENGTH_SHORT).show();
                } else if (!(email.isEmpty() && pass.isEmpty())) {
                    progressDialog.setMessage("You are subscribe to my channel until you are verified!");
                    progressDialog.show();
                    mFirebaseAuth.signInWithEmailAndPassword(email, pass)
                            .addOnCompleteListener(SignInActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (!task.isSuccessful()) {
                                        Toast.makeText(SignInActivity.this, "SignIn Error, Please SignIn Again !", Toast.LENGTH_SHORT).show();
                                        counter--;
                                        tvShowAttempts.setText("Attempts remaining: " + String.valueOf(counter));
                                        tvShowAttempts.setTextColor(Color.rgb(255,0,0));
                                        progressDialog.dismiss();
                                        if (counter == 0) {
                                            btnSignIn.setEnabled(false);
                                        }
                                    } else {
                                        progressDialog.dismiss();
                                        Intent goToMain = new Intent(SignInActivity.this, MainActivity.class);
                                        startActivity(goToMain);
                                    }
                                }
                            });
                } else {
                    Toast.makeText(SignInActivity.this, "Error Occurred!", Toast.LENGTH_SHORT).show();
                }
            }
        });
      /**<-- End of Code Button SingIn */

      /**--> Start of Code TextView Forgot Password */
        tvForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToReset = new Intent(SignInActivity.this,ResetPasswordActivity.class);
                startActivity(goToReset);
            }
        });
      /**<-- End of Code TextView Forgot Password */

      /**--> Start of Code TextView SignUp*/
        tvSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intSignUp = new Intent(SignInActivity.this, SignUpActivity.class);
                startActivity(intSignUp);
            }
        });
      /**<-- End of Code TextView SignUp*/

      /**--> Start of Code ImageView SignUp (SignPlus) */
        ivSignPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intSignUp = new Intent(SignInActivity.this, SignUpActivity.class);
                startActivity(intSignUp);
            }
        });
      /**<-- End of Code ImageView SignUp (SignPlus) */


      /**--> Start of Code Facebook Sigin Button*/
          btnFacebook_Singin.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {

              }
          });



      /**<-- End of Code Facebook Sigin Button*/



      /**--> Start of Code Google Sigin Button  1/2*/
            GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                    .requestIdToken(getString(R.string.default_web_client_id))
                    .requestEmail()
                    .build();
            mgoogleSignInClient= GoogleSignIn.getClient(this,gso);
            btnGoogle_Signin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    signIn(); // call method singIn.
                }
            });
      /**<-- End of Code Google Sigin Button  1/2*/


    } // This braces for close SetupAction() method.

      /**--> Start of Code Google Sigin Button  2/2*/
        private void signIn(){
            Intent signInInten = mgoogleSignInClient.getSignInIntent();
            startActivityForResult(signInInten,RC_SIGN_IN);
        }
        @Override
        protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
            super.onActivityResult(requestCode, resultCode, data);
            if(requestCode==RC_SIGN_IN){
                Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
                handlesignInResult(task);
            }
        }
        private void handlesignInResult(Task<GoogleSignInAccount> completedTask){
            try{
                GoogleSignInAccount acc =completedTask.getResult(ApiException.class);
                //Toast.makeText(SignInActivity.this,"Signed In Successful",Toast.LENGTH_SHORT).show();
                FirebaseGoogleAuth(acc);
            }
            catch (ApiException e){
               // Toast.makeText(SignInActivity.this,"Sign In Failed",Toast.LENGTH_SHORT).show();
                FirebaseGoogleAuth(null);
            }
        }
        private void FirebaseGoogleAuth(GoogleSignInAccount acct){
            AuthCredential authCredential = GoogleAuthProvider.getCredential(acct.getIdToken(),null);

            progressDialog.setMessage("You are subscribe to my channel until you are verified!");
            progressDialog.show();
            mFirebaseAuth.signInWithCredential(authCredential)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                      //Toast.makeText(SignInActivity.this,"Successful",Toast.LENGTH_SHORT).show();
                        FirebaseUser user = mFirebaseAuth.getCurrentUser();
                        UpdateUI(user);

                        Intent goToMain = new Intent(SignInActivity.this,
                                MainActivity.class);
                        startActivity(goToMain);

                        progressDialog.dismiss();
                    }else {
                        progressDialog.dismiss();
                        Toast.makeText(SignInActivity.this,
                                "Sign In Failed",Toast.LENGTH_SHORT).show();
                        // UpdateUI(null);
                    }
                }
            });
        }
        private void  UpdateUI(FirebaseUser fuser){
                GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(getApplicationContext());

                if(account !=null){
                    String personName= account.getDisplayName();
                    String personGivenName = account.getGivenName();
                    String personFamilyName = account.getFamilyName();
                    String personEmail = account.getEmail();
                    String personId= account.getId();
                    Uri personPhoto = account.getPhotoUrl();
                    Toast.makeText(SignInActivity.this,
                            personName +"\n" + personEmail,Toast.LENGTH_SHORT).show();
                }
            }
    /**<-- End of Code Google Sigin Button  2/2*/

    /**--> Start of Modify Google Sigin Button and Facebook Button*/
        private void mapbtnGoogleUI(){
            String text= "Google";
            SpannableString ss = new  SpannableString(text);
            ForegroundColorSpan fcsBLue = new ForegroundColorSpan(Color.BLUE);
            ForegroundColorSpan fcsRed = new ForegroundColorSpan(Color.RED);
            ForegroundColorSpan fcsOrange = new ForegroundColorSpan(0xFFFFA500);
            ForegroundColorSpan fcsBlue1 = new ForegroundColorSpan(Color.BLUE);
            ForegroundColorSpan fcsDarkGreen = new ForegroundColorSpan(0xFF34A853);
            ForegroundColorSpan fcsRed1 = new ForegroundColorSpan(Color.RED);
            ss.setSpan(fcsBLue,0,1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            ss.setSpan(fcsRed,1,2,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            ss.setSpan(fcsOrange,2,3,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            ss.setSpan(fcsBlue1,3,4, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            ss.setSpan(fcsDarkGreen,4,5, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            ss.setSpan(fcsRed1,5,6,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            btnGoogle_Signin.setText(ss);
            btnGoogle_Signin.setTextSize(16);
        }
        private void mapbtnFacebook(){
            String text= "Facebook";
            SpannableString ss = new  SpannableString(text);
            ForegroundColorSpan fcsBLue = new ForegroundColorSpan(0xFF475993);
            ss.setSpan(fcsBLue,0,8, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            btnFacebook_Singin.setText(ss);
            btnFacebook_Singin.setTextSize(15);
        }
    /**<--End of Modify Google Sigin Button and Facebook Button*/

} //This braces for close public class SignInActivity.
