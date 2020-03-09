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

public class SignUpActivity extends AppCompatActivity {
    EditText etEmail, etPassword;
    Button btnSignUp;
    TextView tvSignIn;
    FirebaseAuth mFirebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        mFirebaseAuth = FirebaseAuth.getInstance();
        etEmail = (EditText)findViewById(R.id.etEmail);
        etPassword = (EditText)findViewById(R.id.etPassword);
        btnSignUp = (Button)findViewById(R.id.btnSignUp);
        tvSignIn =(TextView)findViewById(R.id.tvSignIn);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = etEmail.getText().toString();
                String pass = etPassword.getText().toString();
                if (email.isEmpty()){
                    etEmail.setError("Please enter your email id");
                    etEmail.requestFocus();
                }
                else if (pass.isEmpty()){
                    etPassword.setError("Please enter your password");
                    etPassword.requestFocus();
                }
                else if (email.isEmpty() && pass.isEmpty()){
                    Toast.makeText(SignUpActivity.this, "Field are empty",Toast.LENGTH_SHORT).show();
                }
                else if (!(email.isEmpty() && pass.isEmpty())){
                    mFirebaseAuth.createUserWithEmailAndPassword(email,pass)
                    .addOnCompleteListener(SignUpActivity.this,new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(!task.isSuccessful()){
                                Toast.makeText(SignUpActivity.this, "SignUp Unsuccessful, Please Try Again!",Toast.LENGTH_SHORT).show();
                            }else {
                                startActivity(new Intent(SignUpActivity.this, SuccessfulActivity.class));
                            }
                        }
                    });
                }
                else {
                    Toast.makeText(SignUpActivity.this, "Error Occurred!",Toast.LENGTH_SHORT).show();
                }
            }
        });

       tvSignIn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent i = new Intent(SignUpActivity.this, SignInActivity.class);
               startActivity(i);
           }
       });
    }
}
