package com.example.easylearning;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    EditText etUserEmail, etUserPassword;
    Button btnSignIn;
    TextView tvSignUp;
    FirebaseAuth mFirebaseAuth;
    private  FirebaseAuth.AuthStateListener mAuthStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mFirebaseAuth = FirebaseAuth.getInstance();
        etUserEmail = (EditText)findViewById(R.id.etUserEmail);
        etUserPassword = (EditText)findViewById(R.id.etUserPassword);
        btnSignIn = (Button)findViewById(R.id.btnSignIn);
        tvSignUp =(TextView)findViewById(R.id.tvSignUp);

        mAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser mFirebaseUser = mFirebaseAuth.getCurrentUser();
                if (mFirebaseUser != null) {
                    Toast.makeText(LoginActivity.this, "You are logged in ", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(LoginActivity.this, HomeActivity.class);
                    startActivity(i);
                } else {
                    Toast.makeText(LoginActivity.this, "Please login ", Toast.LENGTH_SHORT).show();
                }
            }
        };


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
                     Toast.makeText(LoginActivity.this, "Field are empty", Toast.LENGTH_SHORT).show();
                 } else if (!(email.isEmpty() && pass.isEmpty())) {
                     mFirebaseAuth.signInWithEmailAndPassword(email, pass)
                             .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                                 @Override
                                 public void onComplete(@NonNull Task<AuthResult> task) {
                                     if (!task.isSuccessful()) {
                                         Toast.makeText(LoginActivity.this, "Login Error!, Please Login Again", Toast.LENGTH_SHORT).show();
                                     } else {
                                         Intent intToHome = new Intent(LoginActivity.this, HomeActivity.class);
                                         startActivity(intToHome);
                                     }
                                 }
                             });
                 } else {
                     Toast.makeText(LoginActivity.this, "Error Occurred!", Toast.LENGTH_SHORT).show();
                 }
             }
        });

            tvSignUp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intSignUp = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intSignUp);
                }
            });

//        protected void onStart(){
//            super.onStart();
//            mFirebaseAuth.addAuthStateListener(mAuthStateListener);
//        }
    }
}
