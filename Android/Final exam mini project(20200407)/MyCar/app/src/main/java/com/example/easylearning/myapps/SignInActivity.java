package com.example.easylearning.myapps;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
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
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.easylearning.IMyActivity.IMyActivity;
import com.example.easylearning.IMyActivity.MyActivity;
import com.example.easylearning.R;
import com.example.easylearning.productcar.HomeActivity;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class SignInActivity extends MyActivity implements IMyActivity {

    private EditText etUserEmail, etUserPassword;
    private ImageButton imgbtnShowHidePassword;
    private Boolean isImgbtnshowHidePassword = false;
    private CheckBox cbRemember;
    private Button btnSignIn;
    private Button btnFacebookSignin,btnGoogle_Signin;

              // for google signin button.
    private GoogleSignInClient mgoogleSignInClient;     // for google signin button.
    private String TAG ="SigninActivity";               // for google signin button.
    private int RC_SIGN_IN=1;

    private TextView tvSignUp,tvForgotPassword,tvShowAttempts;
    private ImageView ivSignPlus;
    private FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;
    private  ProgressDialog progressDialog;
    private int counter=3;

    //Shared Preferences
    private SharedPreferences mPrefs;
    private static final String PREFS_NAME ="PrefsFile";


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
            customizeBtnGoogleSignin();
            getPreferencesData();

    } // This braces for close void onCreate(Bundle savedInstanceState)

    private void getPreferencesData() {
        SharedPreferences sp = getSharedPreferences(PREFS_NAME,MODE_PRIVATE);
        if(sp.contains("pref_name")){
            String u = sp.getString("pref_name","not found");
            etUserEmail.setText(u.toString());
        }
        if(sp.contains("pref_pass")){
            String p = sp.getString("pref_pass","not found");
            etUserPassword.setText(p.toString());
        }
        if(sp.contains("pref_check")){
            Boolean b = sp.getBoolean("pref_check",false);
            cbRemember.setChecked(b);
        }

    }


    @Override
    public void mapUIToProperties() {
        mFirebaseAuth = FirebaseAuth.getInstance();
        mPrefs = getSharedPreferences(PREFS_NAME,MODE_PRIVATE);

        etUserEmail = findViewById(R.id.etUserEmail);
        etUserPassword = findViewById(R.id.etUserPassword);
        imgbtnShowHidePassword = findViewById(R.id.imgbtnShowHidePassword);
        cbRemember = findViewById(R.id.cbRemember);

        btnSignIn = findViewById(R.id.btnSignIn);
        btnFacebookSignin = findViewById(R.id.btnfacebook_signin);
        btnGoogle_Signin = findViewById(R.id.btngoogle_signin);          // for google signin button.

        tvForgotPassword = findViewById(R.id.tvForgotPassword);
        tvShowAttempts = findViewById(R.id.tvShowAttempts);
        tvSignUp = findViewById(R.id.tvSignUp);
        ivSignPlus= findViewById(R.id.ivSignPlus);
        progressDialog = new ProgressDialog(this);
       // btnFacebook = findViewById(R.id.login_button);



    }

    @Override
    public void setUpAction() {
        /**--> Start of FirebaseAuth */
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
        /**<-- End of FirebaseAuth */

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

            // Remember Password
            if(cbRemember.isChecked()){
                Boolean iscbRemember = cbRemember.isChecked();
                SharedPreferences.Editor editor = mPrefs.edit();
                editor.putString("pref_name",etUserEmail.getText().toString());
                editor.putString("pref_pass",etUserPassword.getText().toString());
                editor.putBoolean("pref_check",iscbRemember);
                editor.apply();
                //Toast.makeText(SignInActivity.this, "Remember Password", Toast.LENGTH_SHORT).show();
            }else {
                mPrefs.edit().clear().apply();
            }

            if (email.isEmpty()) {
                etUserEmail.setError("Please enter your email id");
                etUserEmail.requestFocus();
            } else if (pass.isEmpty()) {
                etUserPassword.setError("Please enter your password");
                etUserPassword.requestFocus();
            } else if (email.isEmpty() && pass.isEmpty()) {
                Toast.makeText(SignInActivity.this, "Field are empty", Toast.LENGTH_SHORT).show();
            } else if (!(email.isEmpty() && pass.isEmpty())) {
                progressDialog.setMessage("Loading...");
                progressDialog.show();
                mFirebaseAuth.signInWithEmailAndPassword(email, pass)
                        .addOnCompleteListener(SignInActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (!task.isSuccessful()) {
                                    Toast.makeText(SignInActivity.this,
                                    "Authentication failed !", Toast.LENGTH_SHORT).show();
                                    counter--;
                                    tvShowAttempts.setText("Attempts remaining: " + String.valueOf(counter));
                                    //tvShowAttempts.setTextColor(Color.rgb(255,0,0));
                                    tvShowAttempts.setTextColor(0xFFFF0000);
                                    progressDialog.dismiss();
                                    if (counter == 0) {
                                        btnSignIn.setEnabled(false);
                                        btnSignIn.setBackground(getDrawable(R.drawable.border_notsignin));
                                        btnSignIn.setText("Can not Sign In");
                                    }
                                } else {
                                    progressDialog.dismiss();
                                    Intent goToMain = new Intent(SignInActivity.this, HomeActivity.class);
                                    startActivity(goToMain);

                                    etUserEmail.getText().clear();
                                    etUserPassword.getText().clear();
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
            //showRecoverPasswordDialog(); // for call dialog Recovery Password but not use.
        }

        });
        /**<-- End of Code TextView Forgot Password */


        /**--> Start of Code TextView SignUp*/
            tvSignUp.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intSignUp = new Intent(SignInActivity.this, SignUpActivity.class);
            startActivity(intSignUp);
            finish();
        }
        });
        /**<-- End of Code TextView SignUp*/


        /**--> Start of Code ImageView SignUp (SignPlus) */
            ivSignPlus.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intSignUp = new Intent(SignInActivity.this, SignUpActivity.class);
            startActivity(intSignUp);
            finish();
        }
        });
        /**<-- End of Code ImageView SignUp (SignPlus) */




        /**--> Start of Code Facebook Sigin Button */
            btnFacebookSignin.setOnClickListener(v -> {
                Toast.makeText(SignInActivity.this,
                        "Constructionning...",Toast.LENGTH_SHORT).show();
            });



        /**--> End of Code Facebook Sigin Button */





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

    /* for dialog box Recovery password but not use. 05/04/20
        private void showRecoverPasswordDialog() {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Recover Password");

            LinearLayout linearLayout = new LinearLayout(this);
            EditText editTextEmail = new EditText(this);
            editTextEmail.setHint("Email");
            editTextEmail.setInputType(InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);

            editTextEmail.setMinEms(16);


            linearLayout.addView(editTextEmail);
            linearLayout.setPadding(10,10,10,10);

            builder.setView(linearLayout);


                builder.setPositiveButton("Recover", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String email =etUserEmail.getText().toString().trim();
                        beginRecovery(email);

                    }
                });

                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();

                    }
                });


            builder.create().show();

        }

        private void beginRecovery(String email) {
            progressDialog.setMessage("Sending email...");
            progressDialog.show();
            mFirebaseAuth.sendPasswordResetEmail(email)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    progressDialog.dismiss();
                    if(task.isSuccessful()){
                        Toast.makeText(SignInActivity.this,
                                "Email Sent", Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(SignInActivity.this,
                                "Failed...", Toast.LENGTH_SHORT).show();
                    }

                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    progressDialog.dismiss();
                    Toast.makeText(SignInActivity.this,
                            ""+e.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });
        }
    */
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
                progressDialog.setTitle("Connecting to Server");
                progressDialog.setMessage("Loading...");
                progressDialog.show();
                mFirebaseAuth.signInWithCredential(authCredential)
                        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){

                            //If use sign in first time the get and show info from gogle account
                            if(task.getResult().getAdditionalUserInfo().isNewUser()){
                                FirebaseUser user = mFirebaseAuth.getCurrentUser();
                                String email = user.getEmail();
                                String uid = user.getUid();

                                HashMap<Object,String> hashMap = new HashMap<>();
                                hashMap.put("email",email);
                                hashMap.put("uid",uid);
                                hashMap.put("name",""); // Will add later.
                                hashMap.put("phone","");
                                hashMap.put("image","");
                                hashMap.put("cover","");


                                //firebase database instance
                                FirebaseDatabase database = FirebaseDatabase.getInstance();

                                //Path to store user data name "Users"
                                DatabaseReference reference= database.getReference("Users");

                                // Put data within hasmap in database
                                reference.child(uid).setValue(hashMap);

                                //UpdateUI(user);
                            }


                            Intent goToMain = new Intent(SignInActivity.this, HomeActivity.class);
                            startActivity(goToMain);

                            progressDialog.dismiss();
                        }else {
                            progressDialog.dismiss();
                            Toast.makeText(SignInActivity.this,
                                    "Sign In Failed.\nPlease check internet connection!",Toast.LENGTH_SHORT).show();

                        }
                    }
                });
            }
            // for show message
            private void  UpdateUI(FirebaseUser user){
                GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(getApplicationContext());
                if(account !=null){
                    String personName= account.getDisplayName();
                    String personGivenName = account.getGivenName();
                    String personFamilyName = account.getFamilyName();
                    String personEmail = account.getEmail();
                    String personId= account.getId();
                  //  Uri personPhoto = account.getPhotoUrl();
                    Toast.makeText(SignInActivity.this,
                            personName +"\n" + personEmail,Toast.LENGTH_SHORT).show();
                }
            }
        /**<-- End of Code Google Sigin Button  2/2*/



        /**--> Start of Modify Google Sigin Button and Facebook Button*/
            private void customizeBtnGoogleSignin(){
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
            }   // Use.
            private void customizeBtnFacebookSignin(){
                String text= "Facebook";
                SpannableString ss = new  SpannableString(text);
                ForegroundColorSpan fcsBLue = new ForegroundColorSpan(0xFF475993);
                ss.setSpan(fcsBLue,0,8, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                btnFacebookSignin.setText(ss);
                btnFacebookSignin.setTextSize(15);
            }   // Not use.
        /**<--End of Modify Google Sigin Button and Facebook Button*/



} //This braces for close public class SignInActivity.
