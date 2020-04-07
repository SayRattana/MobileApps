package com.example.easylearning.myapps;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Adapter;
import android.widget.Toast;

import com.example.easylearning.R;
import com.example.easylearning.model.AdapterUsers;
import com.example.easylearning.model.ModelUsers;
import com.example.easylearning.productcar.HomeActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class UsersActivity extends AppCompatActivity {
RecyclerView recyclerView;
AdapterUsers adapterUsers;
List<ModelUsers> usersList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);

        /**--> Start of block code bottom navigation */
        // Initialize and Assign Variable
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        // Set Home
        bottomNavigationView.setSelectedItemId(R.id.bottom_navi_user);
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

        //init recycler view
        recyclerView = findViewById(R.id.users_recyclerView);
        // set properties
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        //init user list
        usersList = new ArrayList<>();
        
        //get All user
        getAllUsers();



    }

    private void getAllUsers() {
        //get current user
        final FirebaseUser fuser = FirebaseAuth.getInstance().getCurrentUser();

        //get path of database name "Users" Contain users info
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Users");

       //get all data from path
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                usersList.clear();
                for(DataSnapshot ds: dataSnapshot.getChildren()){
                    ModelUsers modelUsers =ds.getValue(ModelUsers.class);

                    //get all users except currently
                    if(!modelUsers.getUid().equals(fuser.getUid())){
                        usersList.add(modelUsers);
                    }

                    //adapter
                    adapterUsers = new AdapterUsers(UsersActivity.this,usersList);
                    //set adapter to recycler view
                    recyclerView.setAdapter(adapterUsers);

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
