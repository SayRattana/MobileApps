package com.example.gridview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    GridView gridView;
    int[] gridViewImage = {
            R.drawable.ic_food,R.drawable.ic_world,R.drawable.ic_shop,
            R.drawable.ic_topnews,R.drawable.ic_spot,R.drawable.ic_travel,
            R.drawable.ic_work,R.drawable.ic_place,R.drawable.ic_flag
    };

    String[] gridViewText= {"Food","Wold","Shop",
                            "Top News","Spot","Travel",
                            "Work","Place","Falg"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CustomGridView customGridViews = new CustomGridView(MainActivity.this,gridViewImage,gridViewText);
        gridView = findViewById(R.id.gvItems);
        gridView.setAdapter(customGridViews);
    }





    /**--> Start of code for Orientation (Portrait/Landscape) */
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        int orientation = newConfig.orientation;
        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            Toast.makeText(MainActivity.this, "PORTRAIT", Toast.LENGTH_SHORT).show();
        } else if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Toast.makeText(MainActivity.this, "LANDSCAPE", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(MainActivity.this, "other", Toast.LENGTH_SHORT).show();
        }
    }
    /**<-- End of code for Orientation (Portrait/Landscape) */
}
