package com.example.easylearning.myapps;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;

import com.example.easylearning.R;

public class SendMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sendmessage);

        /**-->Start of Code Header Toolbar */
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("SEND MESSAGE");
        this.setSupportActionBar(toolbar);
        /**<--End of Code Header Toolbar */
    }



}
