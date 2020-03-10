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
import com.google.firebase.auth.FirebaseAuth;

public class ResetPasswordActivity extends AppCompatActivity implements IMyActivity {

    private EditText etResetPassword;
    private TextView tvInvalidEmail;
    private Button btnResetPassword;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resetpassword);

        mapUIToProperties();
        setUpAction();


    }


    @Override
    public void mapUIToProperties() {
        firebaseAuth = FirebaseAuth.getInstance();
        etResetPassword = findViewById(R.id.etResetPassword);
        tvInvalidEmail = findViewById(R.id.tvInvalidEmail);
        btnResetPassword = findViewById(R.id.btnResetPassword);

    }

    @Override
    public void setUpAction() {
       /**--> Start of Code Button Reset Password */
        btnResetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userEmail = etResetPassword.getText().toString().trim();
                if(userEmail.equals(null)|| userEmail.equals("")){
                    Toast.makeText(ResetPasswordActivity.this,"Please enter your registered email id"
                            ,Toast.LENGTH_SHORT).show();
                }else {
                    firebaseAuth.sendPasswordResetEmail(userEmail).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                    if(task.isSuccessful()){
                        Toast.makeText(ResetPasswordActivity.this,"Password reset email sent!",Toast.LENGTH_SHORT).show();
                        finish();
                        startActivity(new Intent(ResetPasswordActivity.this, SignInActivity.class));
                    }else {

                        Toast.makeText(ResetPasswordActivity.this," Error in sending or Invalid email",Toast.LENGTH_SHORT).show();
                        tvInvalidEmail.setText("Invalid e-mail, Please try again!");
                        // finish(); // if have problem, Please close this line code Finish().
                    }
                        }
                    });
                }
            }
        });

       /**<-- End of Code Button Reset Password */






    }




}
