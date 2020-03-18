package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class SignupActivity extends AppCompatActivity {
    private EditText etEmail, etPassword;
    private Button btnSignUp;
    private TextView tvSignIn;
    private ImageButton imgShowPassword;
    private Boolean isShowHidePassword = false;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
            maptoUI();
            setupAction();
    }




    public void maptoUI() {
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        btnSignUp = findViewById(R.id.btnSignUp);
        tvSignIn = findViewById(R.id.tvSignIn);
        imgShowPassword = findViewById(R.id.imgShowPassword);


    }
    public void setupAction(){
        /**--> Start of Code TextView SingIn */
            tvSignIn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent gotoLogin = new Intent(SignupActivity.this, LoginActivity.class);
                    startActivity(gotoLogin);
                }
            });
        /**<-- End of Code TextView SingIn */



        /**--> Start of Code Show/Hidden Password */
            imgShowPassword.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                  isShowHidePassword = !isShowHidePassword;
                  etPassword.setInputType(isShowHidePassword?
                            InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD :
                            InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                 }
            });
        /**<-- End of Code Show/Hidden Password */



    }

    /**--> Start of code for Orientation (Portrait/Landscape) */
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        int orientation = newConfig.orientation;
        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            Toast.makeText(SignupActivity.this, "PORTRAIT", Toast.LENGTH_SHORT).show();
        } else if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Toast.makeText(SignupActivity.this, "LANDSCAPE", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(SignupActivity.this, "other", Toast.LENGTH_SHORT).show();
        }
    }
    /**<-- End of code for Orientation (Portrait/Landscape) */

}
