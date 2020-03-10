package com.example.login.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.login.R;
import com.example.login.helper.Validation;
import com.example.login.helper.ValidationError;

public class LoginActivity extends AppCompatActivity implements IMyActivity{
    private EditText etUsername,etPassword;
    private Button btnLogin;
    private TextView tvShow;
    private TextView tvGoToPart3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mapUIToProperties();
        setUpAction();

    }
    @Override
    public void mapUIToProperties(){
        etUsername = findViewById(R.id.etUserName);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        tvShow =findViewById(R.id.tvShow);
        tvGoToPart3 = findViewById(R.id.tvGoToPart3);
    }

    @Override
    public void setUpAction(){
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ValidationError validationError = Validation.validateUsername(etUsername.getText().toString());
                    if (validationError != null) {
                        Toast.makeText(LoginActivity.this,
                                validationError.getErrorDetail(),
                                Toast.LENGTH_LONG)
                                .show();
                        return;
                    }
                    validationError = Validation.validatePassword(etPassword.getText().toString());
                    if (validationError != null) {
                        Toast.makeText(LoginActivity.this,
                                validationError.getErrorDetail(),
                                Toast.LENGTH_LONG)
                                .show();
                        return;
                    }
                    /*
                    Toast.makeText(LoginActivity.this,
                        "Successful Login! "+
                                "\nUsername: "+etUsername.getText().toString()+
                                "\nPassword: "+etPassword.getText().toString(),
                            Toast.LENGTH_LONG).show();
                    */
                    tvShow.setText("Username: "+etUsername.getText().toString()+
                            "\nPassword: "+etPassword.getText().toString());
                    tvShow.setTextColor(Color.rgb(0,0,255));
            }
        });


        tvGoToPart3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToPart3 = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(goToPart3);
            }
        });


    }
}
