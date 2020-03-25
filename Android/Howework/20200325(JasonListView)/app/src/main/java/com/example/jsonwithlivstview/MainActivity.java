package com.example.jsonwithlivstview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.jsonwithlivstview.mjson.JSONDownloader;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    String jsonURL ="https://jsonplaceholder.typicode.com/users";
    ListView lv;
    Button btnShowJSONListView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       lv=findViewById(R.id.lv);
       btnShowJSONListView= findViewById(R.id.btnShowListView);


       FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new JSONDownloader(MainActivity.this,jsonURL,lv).execute();

            }
        });



        btnShowJSONListView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new JSONDownloader(MainActivity.this,jsonURL,lv).execute();

            }
        });
    }
}
