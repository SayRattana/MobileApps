package com.example.easylearning.myapps;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.easylearning.R;
import com.example.easylearning.productcar.HomeActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class AboutActivity extends AppCompatActivity {

    private TextView facebook,youtube;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        /**--> Start of block code bottom navigation */
        // Initialize and Assign Variable
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        // Set Home
        bottomNavigationView.setSelectedItemId(R.id.bottom_navi_about);
        // Perform ItemSelectListner
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.bottom_navi_profile:
                        startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                switch (item.getItemId()){
                    case R.id.bottom_navi_home:
                        startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                }

                switch (item.getItemId()){
                    case R.id.bottom_navi_user:
                        startActivity(new Intent(getApplicationContext(), UsersActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                switch (item.getItemId()){
                    case R.id.bottom_navi_about:
                        return true;
                }


                return false;
            }
        });
        /**--> End of block code bottom navigation */

        facebook = findViewById(R.id.facebook);
        youtube = findViewById(R.id.youtube);


        facebook.setOnClickListener(v -> {
            Intent openFacebook = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/nguyen.duc.hoang.bk"));
            startActivity(openFacebook);
        });

        youtube.setOnClickListener(v -> {
            Intent openYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/channel/UCfjYtjTW69DWMLOOMzFJ5cg"));
            startActivity(openYoutube);
        });


    }
}
