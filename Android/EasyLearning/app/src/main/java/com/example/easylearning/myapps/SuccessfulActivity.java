package com.example.easylearning.myapps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.easylearning.IMyActivity.IMyActivity;
import com.example.easylearning.R;
import com.google.firebase.auth.FirebaseAuth;

public class SuccessfulActivity extends AppCompatActivity implements IMyActivity {
    private Button btnLogOut;
    private FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_successful);

        mapUIToProperties();
        setUpAction();

    }

    @Override
    public void mapUIToProperties() {
        btnLogOut =findViewById(R.id.btnLogout);

    }

    @Override
    public void setUpAction() {
      /**Start of Code Button LogOut */
        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intToSignin = new Intent(SuccessfulActivity.this, SignInActivity.class);
                startActivity(intToSignin);
            }
        });
      /**End of Code Button LogOut */





    }



}
