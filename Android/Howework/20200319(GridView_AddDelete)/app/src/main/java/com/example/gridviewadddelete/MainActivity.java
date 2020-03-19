package com.example.gridviewadddelete;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private GridView gridViewItems;
    private Button btnAdd, btnRemove;
    private ImagesAdapter adapter;
    private ArrayList<String> arrayList;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private String PrefName = "Grid";
    private int count = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
            mapUIToProperties();
            setUpAction();
    }



    public void mapUIToProperties(){
        gridViewItems = findViewById(R.id.gridViewItems);
        btnAdd =findViewById(R.id.btnAdd);
        btnRemove = findViewById(R.id.btnRemove);


    }

    public void setUpAction(){
        sharedPreferences = getSharedPreferences(PrefName, MODE_PRIVATE);
        count = sharedPreferences.getInt("count", 3);

        arrayList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            arrayList.add("");
        }

        adapter = new ImagesAdapter(this, arrayList);
        gridViewItems.setAdapter(adapter);

        /** Code for Button Add Grid Items*/
        btnAdd.setOnClickListener((View v)->{
            arrayList.add("");
            adapter.notifyDataSetChanged();
            gridViewItems.setAdapter(adapter);
            editor = sharedPreferences.edit();
            editor.putInt("count", count + 1);
            editor.apply();
                Toast.makeText(getApplicationContext(),
                    "Add One Image", Toast.LENGTH_SHORT).show();
        });


        /** Code for Button Remove Grid Items*/
        btnRemove.setOnClickListener((View v)->{
            arrayList.remove("");
            adapter.notifyDataSetChanged();
            gridViewItems.setAdapter(adapter);
            editor = sharedPreferences.edit();
            editor.putInt("count", count - 1);
            editor.apply();
                Toast.makeText(getApplicationContext(),
                    "Image has been Removed", Toast.LENGTH_SHORT).show();
        });

    }



}
