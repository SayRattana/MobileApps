package com.example.jsongridview;
//<!--Auth: SAY RATTANA-->
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import com.example.jsongridview.mjson.JSONDownloader;

public class MainActivity extends AppCompatActivity {
    String jsonURL ="https://jsonplaceholder.typicode.com/posts";
    GridView gv;
    Button btnShowJSONGridView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       gv =findViewById(R.id.gv);
       btnShowJSONGridView = findViewById(R.id.btnShowGridView);


        btnShowJSONGridView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new JSONDownloader(MainActivity.this,jsonURL, gv).execute();
                gv.setBackgroundColor(Color.parseColor("#d9d5dc"));
               // gv.setVerticalSpacing(100);
               // gv.setGravity(Gravity.CENTER);


            }
        });
    }





}
