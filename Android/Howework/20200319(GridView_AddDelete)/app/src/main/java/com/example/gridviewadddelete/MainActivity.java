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
    GridView gridView;
    Button btn_add, btn_remove;
    ImagesAdapter adapter;
    ArrayList<String> list;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    String Pref_Name = "Grid";
    int count = 3;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = (GridView) findViewById(R.id.gridViewItems);
        btn_add = (Button) findViewById(R.id.btnAdd);
        btn_remove = (Button) findViewById(R.id.btnRemove);

        sharedPreferences = getSharedPreferences(Pref_Name, MODE_PRIVATE);
        count = sharedPreferences.getInt("count", 3);

        list = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            list.add("");
        }

        adapter = new ImagesAdapter(this, list);
        gridView.setAdapter(adapter);

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.add("");
                adapter.notifyDataSetChanged();
                gridView.setAdapter(adapter);

                editor = sharedPreferences.edit();
                editor.putInt("count", count + 1);
                editor.apply();

                Toast.makeText(getApplicationContext(), "One Image Added", Toast.LENGTH_SHORT).show();

            }
        });

        btn_remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.remove("");
                adapter.notifyDataSetChanged();
                gridView.setAdapter(adapter);

                editor = sharedPreferences.edit();
                editor.putInt("count", count - 1);
                editor.apply();

                Toast.makeText(getApplicationContext(), "One Image Removed", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
