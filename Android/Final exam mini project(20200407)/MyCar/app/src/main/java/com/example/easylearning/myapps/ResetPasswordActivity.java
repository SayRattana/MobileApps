package com.example.easylearning.myapps;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.example.easylearning.IMyActivity.IMyActivity;
import com.example.easylearning.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ResetPasswordActivity extends AppCompatActivity implements IMyActivity {

    private EditText etResetPassword;
    private TextView tvInvalidEmail;
    private Button btnResetPassword;
    private FirebaseAuth firebaseAuth;
    private ImageView btnbacktoolbar;
    private View viewLine;
    private Toolbar toolbar;

    ProgressDialog progressDialog;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resetpassword);

        /**-->Start of Code Header Toolbar */
            toolbar = findViewById(R.id.toolbar);
            toolbar.setTitle("RESET PASSWORD");
            this.setSupportActionBar(toolbar);
        /**<--End of Code Header Toolbar */

            mapUIToProperties();
            setUpAction();


    }

    @Override
    public void mapUIToProperties() {
        firebaseAuth = FirebaseAuth.getInstance();
        etResetPassword = findViewById(R.id.etResetPassword);
        tvInvalidEmail = findViewById(R.id.tvInvalidEmail);
        btnResetPassword = findViewById(R.id.btnResetPassword);
        btnbacktoolbar = findViewById(R.id.btnbacktoolbar);
        viewLine = findViewById(R.id.viewLine);
        progressDialog = new ProgressDialog(this);

    }

    @Override
    public void setUpAction() {
        /**--> Start of Code Button Reset Password */
        btnResetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userEmail = etResetPassword.getText().toString().trim();
                if (userEmail.equals(null) || userEmail.equals("")) {
                    Toast.makeText(ResetPasswordActivity.this,
                            "Please enter your registered email id"
                            , Toast.LENGTH_SHORT).show();
                } else {
                    progressDialog.setMessage("Sending email...");
                    progressDialog.show();
                    firebaseAuth.sendPasswordResetEmail(userEmail)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    progressDialog.dismiss();
                                    if (task.isSuccessful()) {
                                        startActivity(new Intent(ResetPasswordActivity.this, SignInActivity.class));
                                        Toast.makeText(ResetPasswordActivity.this,
                                                "Password Reset Successful.\nPlease check your e-mail !", Toast.LENGTH_LONG).show();
                                        finish();
                                    } else {
                                        progressDialog.dismiss();
                                        Toast.makeText(ResetPasswordActivity.this,
                                                " Error in sending or Invalid email", Toast.LENGTH_SHORT).show();

                                        tvInvalidEmail.setText("E-mail not Register or invalid e-mail,\nPlease try again!");
                                            }
                                }
                            });
                }
            }
        });

        /**<-- End of Code Button Reset Password */

        /**--> Start of Code Button Back*/
            btnbacktoolbar.setOnClickListener(v ->{
               // startActivity(new Intent(ResetPasswordActivity.this, SignInActivity.class));
                startActivity(new Intent(getApplicationContext(), SignInActivity.class));
                finish();
            });

        /**<--> End of Code Button Back*/

    }


    /**--> Start of code for Orientation (Portrait/Landscape) */
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        int orientation = newConfig.orientation;
        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
           // Toast.makeText(ResetPasswordActivity.this, "PORTRAIT", Toast.LENGTH_LONG).show();

        } else if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
           // Toast.makeText(ResetPasswordActivity.this, "LANDSCAPE", Toast.LENGTH_LONG).show();
        }
        else {
           // Toast.makeText(ResetPasswordActivity.this, "other", Toast.LENGTH_LONG).show();

        }
    }
    /**<-- End of code for Orientation (Portrait/Landscape) */






}

