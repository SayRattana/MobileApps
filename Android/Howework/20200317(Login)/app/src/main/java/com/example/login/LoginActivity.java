package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {
    private EditText etEmail,etPassword;
    private TextView tvFacebook,tvGoogle;
    private TextView tvSignupNow;
    private ImageButton imgShowPassword;
    private Boolean isShowHidePassword = false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
            mapToUI();
            setupAction();


    }

    public void mapToUI(){
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        tvFacebook = findViewById(R.id.tvFacebook);
        tvGoogle = findViewById(R.id.tvGoogle);
        tvSignupNow = findViewById(R.id.tvSignUpNow);
        imgShowPassword = findViewById(R.id.imgShowPassword);
    }


    public void setupAction(){
    /**click for open Facebook website*/
        tvFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openFacebook = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/"));
                startActivity(openFacebook);
            }
        });


    /** click for open Google website*/
        tvGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openGoogle = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/"));
                startActivity(openGoogle);
            }
        });


    /** click for open Signup Activity*/
        tvSignupNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotoSignup = new Intent(LoginActivity.this,SignupActivity.class);
                startActivity(gotoSignup);
            }
        });


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



}
