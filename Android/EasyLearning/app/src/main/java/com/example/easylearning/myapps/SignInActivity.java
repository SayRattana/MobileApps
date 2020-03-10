package com.example.easylearning.myapps;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.easylearning.IMyActivity.IMyActivity;
import com.example.easylearning.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignInActivity extends AppCompatActivity implements IMyActivity {

    private EditText etUserEmail, etUserPassword;
    private Button btnSignIn;
    private TextView tvSignUp,tvForgotPassword;
    private FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        mapUIToProperties();
        setUpAction();
    }


    @Override
    public void mapUIToProperties() {
        mFirebaseAuth = FirebaseAuth.getInstance();
        etUserEmail = findViewById(R.id.etUserEmail);
        etUserPassword = findViewById(R.id.etUserPassword);
        btnSignIn = findViewById(R.id.btnSignIn);
        tvForgotPassword = findViewById(R.id.tvForgotPassword);
        tvSignUp =findViewById(R.id.tvSignUp);

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
                    mFirebaseAuth.signInWithEmailAndPassword(email, pass)
                            .addOnCompleteListener(SignInActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (!task.isSuccessful()) {
                                        Toast.makeText(SignInActivity.this, "Login Error!, Please Login Again", Toast.LENGTH_SHORT).show();
                                    } else {
                                        Intent intToHome = new Intent(SignInActivity.this, SuccessfulActivity.class);
                                        startActivity(intToHome);
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



    }











}
