package com.example.easylearning.productcar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.example.easylearning.R;
import com.example.easylearning.myapps.AboutActivity;
import com.example.easylearning.myapps.ProfileActivity;
import com.example.easylearning.myapps.SignInActivity;
import com.example.easylearning.myapps.UsersActivity;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.squareup.picasso.Picasso;

public class HomeActivity extends AppCompatActivity {

    EditText inputSearch;
    RecyclerView recyclerView;
    FloatingActionButton floatingbtn;
    FirebaseRecyclerOptions<Car> options;
    FirebaseRecyclerAdapter<Car,MyViewHolder>adapter;
    DatabaseReference Dataref;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Car List");
        this.setSupportActionBar(toolbar);




        /**--> Start of block code bottom navigation */
        // Initialize and Assign Variable
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        // Set Home
        bottomNavigationView.setSelectedItemId(R.id.bottom_navi_home);
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
                        startActivity(new Intent(getApplicationContext(), AboutActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                }


                return false;
            }
        });
    /**--> End of block code bottom navigation */





        Dataref= FirebaseDatabase.getInstance().getReference().child("Car");

        inputSearch=findViewById(R.id.inputSearch);
        recyclerView=findViewById(R.id.recylerView);
        floatingbtn=findViewById(R.id.floatingbtn);


        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setHasFixedSize(true);


        floatingbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // startActivity(new Intent(getApplicationContext(),MainActivity.class));
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        });


        LoadData("");

        inputSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.toString()!=null)
                {
                    LoadData(s.toString());
                }
                else
                {
                    LoadData("");
                }

            }
        });


    }

    private void LoadData(String data) {
        Query query=Dataref.orderByChild("CarName").startAt(data.toUpperCase()).endAt(data+"\uf8ff");
        options=new FirebaseRecyclerOptions.Builder<Car>().setQuery(query,Car.class).build();
        adapter=new FirebaseRecyclerAdapter<Car, MyViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull MyViewHolder holder, final int position, @NonNull Car model) {
            /*  And more properties if you want to show on HomeActivity */
                //  holder.textViewID.setText(model.getiD());

                holder.textView.setText(model.getCarName());
                Picasso.get().load(model.getImageUrl()).into(holder.imageView);
                holder.v.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(HomeActivity.this,ViewActivity.class);
                        intent.putExtra("CarKey",getRef(position).getKey());
                        startActivity(intent);
                    }
                });

            }

            @NonNull
            @Override
            public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.single_view,parent,false);
                return new MyViewHolder(v);
            }
        };
        adapter.startListening();
        recyclerView.setAdapter(adapter);

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
//        int id = item.getItemId();
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_profile) {
//            startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
//            overridePendingTransition(0,0);
//            return true;
//        }
//        if(id == R.id.action_signout){
//            startActivity(new Intent(getApplicationContext(), SignInActivity.class));
//            overridePendingTransition(0,0);
//            Toast.makeText(HomeActivity.this,
//                    "You are Signed out", Toast.LENGTH_SHORT).show();
//            return true;
//        }
        switch (item.getItemId()){
            case R.id.action_home:
                return true;
        }
        switch (item.getItemId()){
            case R.id.action_profile:
                startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
                overridePendingTransition(0,0);
                return true;
        }
        switch (item.getItemId()){
            case R.id.action_about:
                startActivity(new Intent(getApplicationContext(), AboutActivity.class));
                overridePendingTransition(0,0);
                return true;
        }
        switch (item.getItemId()){
            case R.id.action_signout:
                startActivity(new Intent(getApplicationContext(), SignInActivity.class));
                overridePendingTransition(0,0);
                Toast.makeText(HomeActivity.this,
                        "You are Signed out", Toast.LENGTH_SHORT).show();
                return true;
        }

        return false;
    }

}
