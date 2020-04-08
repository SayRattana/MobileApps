package com.example.easylearning.myapps;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.easylearning.IMyActivity.IMyActivity;
import com.example.easylearning.R;
import com.example.easylearning.helpers.Validation;
import com.example.easylearning.helpers.ValidationError;
import com.example.easylearning.sqlitedatabase.DBHandler;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.regex.Pattern;

public class SignUpActivity extends AppCompatActivity implements IMyActivity {

    private EditText etUserName, etEmail, etPassword;
    private ImageButton imgbtnShowHidePassword;
    private Boolean isImgbtnshowHidePassword = false;
    private Button btnSignUp;
    private TextView tvSignIn;


    private FirebaseAuth mFirebaseAuth;
    private ProgressDialog progressDialog;

    DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        /**-->Start of Code Header Toolbar */
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("SIGN UP");
        this.setSupportActionBar(toolbar);
        /**<--End of Code Header Toolbar */

        mapUIToProperties();
        setUpAction();

    }


    @Override
    public void mapUIToProperties() {
        mFirebaseAuth = FirebaseAuth.getInstance();
        etUserName = findViewById(R.id.etUserName);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        imgbtnShowHidePassword = findViewById(R.id.imgbtnShowHidePassword);
        btnSignUp = findViewById(R.id.btnSignUp);
        tvSignIn = findViewById(R.id.tvSignIn);
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Signup new  User...");
        dbHandler = new DBHandler(this); // for SQLite


    }


    @Override
    public void setUpAction() {

        /**--> Start of Code Show/Hidden Password */
        imgbtnShowHidePassword.setOnClickListener(v -> {
            isImgbtnshowHidePassword = !isImgbtnshowHidePassword;
            etPassword.setInputType(isImgbtnshowHidePassword ?
                    InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD :
                    InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        });
        /**<-- End of Code Show/Hidden Password */


        /** Start of Code Button SingUp */
            btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = etUserName.getText().toString();
                String email = etEmail.getText().toString();
                String pass = etPassword.getText().toString();



                // For Username, E-mail and Password All Fields Are Empty.
                if (user.isEmpty()) {
                    etUserName.setError("Please enter your name");
                    etUserName.requestFocus();
                }
                if (email.isEmpty()) {
                    etEmail.setError("Please enter your email id");
                    etEmail.requestFocus();
                }
                if (pass.isEmpty()) {
                    etPassword.setError("Please enter your password");
                    etPassword.requestFocus();
                }
                if (email.isEmpty() && pass.isEmpty() && user.isEmpty()) {
                    Toast.makeText(SignUpActivity.this, "All Fields Are Empty",
                            Toast.LENGTH_SHORT).show();
                }

                // For Username field  less than 2 characters.
                ValidationError validationError = Validation.validateUsername(etUserName.getText().toString());
                if (validationError != null) {
                    Toast.makeText(SignUpActivity.this,
                            validationError.getErrorDetail(), Toast.LENGTH_SHORT).show();
                    etUserName.requestFocus();
                    return;
                }

                // For E-mail field incorrect format.
                validationError = Validation.validateEmail(etEmail.getText().toString());
                if (validationError != null) {
                    Toast.makeText(SignUpActivity.this,
                            validationError.getErrorDetail(), Toast.LENGTH_SHORT).show();
                    etEmail.requestFocus();
                    return;
                }

                // For Password field  less than 6 characters.
                validationError = Validation.validatePassword(etPassword.getText().toString());
                if (validationError != null) {
                    Toast.makeText(SignUpActivity.this,
                            validationError.getErrorDetail(), Toast.LENGTH_SHORT).show();
                    etPassword.requestFocus();
                    return;
                }

                // For E-mail and Password fields are Correct.
                else if (!(email.isEmpty() && pass.isEmpty())) {
                    registerUser(email,pass);

                }

                // call method SQLite
                addDataToSQLite();
            }
        });
        /** End of Code Button SingUp */





        /** Start of Code TextView SingIn */
        tvSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backtoSignin = new Intent(SignUpActivity.this, SignInActivity.class);
                startActivity(backtoSignin);
                finish();//add new 05/04/20
            }
        });
        /** End of Code TextView SingIn */


    }

    private void registerUser(String email, String pass) {
        progressDialog.show();
        mFirebaseAuth.createUserWithEmailAndPassword(email, pass)
                .addOnCompleteListener(SignUpActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            progressDialog.dismiss();
                            FirebaseUser user =mFirebaseAuth.getCurrentUser();

                            //Get email and uid from auth
                            String email = user.getEmail();
                            String uid = user.getUid();


                            // When user is sign up /register store user info in firebase realtime database too.
                            HashMap<Object,String>  hashMap = new HashMap<>();

                            //put info from Hasmap
                            hashMap.put("email",email);
                            hashMap.put("uid",uid);
                            hashMap.put("name","");
                            hashMap.put("phone","");    // Will add later.
                            hashMap.put("image","");
                            hashMap.put("cover","");


                            //firebase database instance
                            FirebaseDatabase database = FirebaseDatabase.getInstance();

                            //Path to store user data name "Users"
                            DatabaseReference reference= database.getReference("Users");

                            // Put data within hasmap in database
                            reference.child(uid).setValue(hashMap);


                            Toast.makeText(SignUpActivity.this,
                                    "You are Success signed in ", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(SignUpActivity.this, SuccessfulActivity.class));
                            finish();
                        } else {
                            progressDialog.dismiss();
                            Toast.makeText(SignUpActivity.this,
                                    "SignUp Failed !, Please Try Again!",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(SignUpActivity.this,
                                ""+e.getMessage(),
                                Toast.LENGTH_SHORT).show();
                    }
        });

    }


    private void addDataToSQLite(){
            String user = etUserName.getText().toString();
            String email = etEmail.getText().toString();
            String pass = etPassword.getText().toString();

            boolean status = dbHandler.addUser(user, email, pass);
            if (status) {
                Toast.makeText(SignUpActivity.this, "SQLite Register Successfully", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(SignUpActivity.this, "Error !", Toast.LENGTH_SHORT).show();
            }
        }

    @Override
    public void onBackPressed() {
        Toast.makeText(this, "Please press Already....? for back ", Toast.LENGTH_SHORT).show();
        return;
    }

    }







