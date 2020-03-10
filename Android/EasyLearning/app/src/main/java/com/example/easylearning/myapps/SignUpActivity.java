package com.example.easylearning.myapps;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.easylearning.IMyActivity.IMyActivity;
import com.example.easylearning.R;
import com.example.easylearning.helpers.Validation;
import com.example.easylearning.helpers.ValidationError;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.errorprone.annotations.IncompatibleModifiers;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.lang.annotation.Annotation;

public class SignUpActivity extends AppCompatActivity implements IMyActivity {
    private EditText etEmail, etPassword;
    private Button btnSignUp;
    private TextView tvSignIn;
    private FirebaseAuth mFirebaseAuth;
    private  ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        mapUIToProperties();
        setUpAction();

    }



    @Override
    public void mapUIToProperties() {
        mFirebaseAuth = FirebaseAuth.getInstance();
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        btnSignUp = findViewById(R.id.btnSignUp);
        tvSignIn =findViewById(R.id.tvSignIn);
        progressDialog = new ProgressDialog(this);


    }


    @Override
    public void setUpAction() {

      /** Start of Code Button SingUp */
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = etEmail.getText().toString();
                String pass = etPassword.getText().toString();

                // For E-mail and Password Fields Are empty.
                if (email.isEmpty()) {
                    etEmail.setError("Please enter your email id");
                    etEmail.requestFocus();
                } if (pass.isEmpty()) {
                    etPassword.setError("Please enter your password");
                    etPassword.requestFocus();
                }  if (email.isEmpty() && pass.isEmpty()) {
                    Toast.makeText(SignUpActivity.this, "Field are empty",
                            Toast.LENGTH_SHORT).show();
                }

                    // For E-mail field incorrect format.
                    ValidationError validationError = Validation.validateEmail(etEmail.getText().toString());
                    if (validationError != null) {
                        Toast.makeText(SignUpActivity.this,
                                validationError.getErrorDetail(),Toast.LENGTH_LONG).show();
                        etEmail.requestFocus();
                        return;
                    }

                    // For Password field  less than 6 characters.
                    validationError = Validation.validatePassword(etPassword.getText().toString());
                   if (validationError != null) {
                        Toast.makeText(SignUpActivity.this,
                                validationError.getErrorDetail(),Toast.LENGTH_LONG).show();
                        etPassword.requestFocus();

                        return;
                    }

                // For E-mail and Password fields are correct.
                else if (!(email.isEmpty() && pass.isEmpty())){
                    progressDialog.setMessage("You are subscribe to my channel until you are verified!");
                    progressDialog.show();
                    mFirebaseAuth.createUserWithEmailAndPassword(email,pass)
                    .addOnCompleteListener(SignUpActivity.this,new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(!task.isSuccessful()){
                                progressDialog.dismiss();
                                Toast.makeText(SignUpActivity.this,
                               "SignUp Unsuccessful,\nE-mail already signin.\nPlease Try Again!",
                               Toast.LENGTH_SHORT).show();

                            }else {
                                progressDialog.dismiss();
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
      /** End of Code Button SingUp */


      /** Start of Code TextView SingIn */
        tvSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SignUpActivity.this, SignInActivity.class);
                startActivity(i);
            }
        });
      /** End of Code TextView SingIn */





    }




}
