package com.example.easylearning.myapps;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.easylearning.IMyActivity.IMyActivity;
import com.example.easylearning.R;
import com.example.easylearning.productcar.HomeActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class AboutActivity extends AppCompatActivity implements IMyActivity {

    private TextView facebook,youtube;
    private ImageView imgRattana,imgHay;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        mapUIToProperties();
        setUpAction();

    }

    @Override
    public void mapUIToProperties() {
        facebook = findViewById(R.id.facebook);
        youtube = findViewById(R.id.youtube);
        imgRattana = findViewById(R.id.img_rattana);
        imgHay = findViewById(R.id.img_hay);

    }

    @Override
    public void setUpAction() {
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



        facebook.setOnClickListener(v -> {
            Intent openFacebook = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/nguyen.duc.hoang.bk"));
            startActivity(openFacebook);
        });



        youtube.setOnClickListener(v -> {
            Intent openYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/channel/UCfjYtjTW69DWMLOOMzFJ5cg"));
            startActivity(openYoutube);
        });


        imgRattana.setOnClickListener(v -> {
            showImageRattanaDialog();
        });

        imgHay.setOnClickListener(v -> {
            showImageHayDialog();
        });

    }

    private void showImageRattanaDialog() {        //Custom dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("SAY RATTANA"); // e.g: name

        //set layout for dialog
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.HORIZONTAL);
        linearLayout.setPadding(10,10,10,10);

        //Add Image
        ImageView imageView = new ImageView(this);
        imageView.setImageResource(R.drawable.rattana);

        linearLayout.addView(imageView);
        builder.setView(linearLayout);
        builder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        // Create and show dialog
        builder.create().show();

    }

    private void showImageHayDialog() {        //Custom dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("SENG SENGHAY"); // e.g: name

        //set layout for dialog
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.HORIZONTAL);
        linearLayout.setPadding(10,10,10,10);

        //Add Image
        ImageView imageView = new ImageView(this);
        imageView.setImageResource(R.drawable.hay);

        linearLayout.addView(imageView);
        builder.setView(linearLayout);
        builder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        // Create and show dialog
        builder.create().show();

    }


}
