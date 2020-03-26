package com.example.jsonlistview;

import androidx.appcompat.app.AppCompatActivity;
//<!--Auth: SAY Rattana-->
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.jsonlistview.mjson.JSONDownloader;
public class MainActivity extends AppCompatActivity {
    String jsonURL ="https://jsonplaceholder.typicode.com/albums";
    ListView lv;
    Button btnShowJSONListView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv=findViewById(R.id.lv);
        btnShowJSONListView= findViewById(R.id.btnShowListView);

        btnShowJSONListView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new JSONDownloader(MainActivity.this, jsonURL,lv).execute();

            }
        });



    }


}
