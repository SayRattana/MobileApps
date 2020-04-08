package com.example.easylearning.myapps;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.easylearning.IMyActivity.IMyActivity;
import com.example.easylearning.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SuccessfulActivity extends AppCompatActivity implements IMyActivity {
    private TextView mUser;
    private Button btnLogOut;
    private FirebaseAuth firebaseAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_successful);

        /**-->Start of Code Header Toolbar */
            Toolbar toolbar = findViewById(R.id.toolbar);
            toolbar.setTitle("SUCCESSFUL");
            this.setSupportActionBar(toolbar);
        /**<--End of Code Header Toolbar */

            mapUIToProperties();
            setUpAction();

    }

    @Override
    public void mapUIToProperties() {
        firebaseAuth = FirebaseAuth.getInstance();

        mUser = findViewById(R.id.tvmUser);
        btnLogOut =findViewById(R.id.btnsignout);

    }

    @Override
    public void setUpAction() {
       /**Start of Code Button LogOut */
            btnLogOut.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    firebaseAuth.signOut();
                    checkUserStatus();
                    Toast.makeText(SuccessfulActivity.this,
                            "You are Signed out", Toast.LENGTH_SHORT).show();
                }
            });
       /**End of Code Button LogOut */


    }

    //Check user status
    private void checkUserStatus(){
        FirebaseUser user = firebaseAuth.getCurrentUser();
        if(user != null){
            mUser.setText(user.getEmail());

        }else {
            startActivity(new Intent(SuccessfulActivity.this,SignInActivity.class));
            finish();

        }
    }

//    @Override
//    protected void onStart() {
//        checkUserStatus();
//        super.onStart();
//    }


}
