package com.example.easylearning.productcar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.easylearning.R;
import com.example.easylearning.myapps.AboutActivity;
import com.example.easylearning.myapps.ProfileActivity;
import com.example.easylearning.myapps.SignInActivity;
import com.example.easylearning.myapps.UsersActivity;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

public class ViewActivity extends AppCompatActivity {

    private ImageView imageView;
    EditText carName;
    TextView carID;
    EditText carYear,carCompany,kindOfCar;
    Button btnDelete, btnEdit, btnUpdate;
    boolean isEditUpdate=false;

    DatabaseReference ref,DataRef;
    StorageReference StorageRef;

    boolean isImgageYear =false;
    Uri imageUri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);


        /**--> Start of block code bottom navigation */
        // Initialize and Assign Variable
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        // Set Home
       // bottomNavigationView.setSelectedItemId(R.id.bottom_navi_signout);
        bottomNavigationView.setSelectedItemId(R.id.bottom_navi_signout);
        // Perform ItemSelectListner
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.bottom_navi_profile:
                        startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                }
                switch (item.getItemId()) {
                    case R.id.bottom_navi_home:
                        startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                        overridePendingTransition(0, 0);
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

                switch (item.getItemId()) {
                    case R.id.bottom_navi_signout:
                        startActivity(new Intent(getApplicationContext(), SignInActivity.class));
                        overridePendingTransition(0, 0);
                        Toast.makeText(ViewActivity.this, "You are Signed out", Toast.LENGTH_SHORT).show();
                        return true;
                }

                return false;
            }
        });
        /**--> End of block code bottom navigation */


        imageView = findViewById(R.id.image_single_view_Activity);
        carName = findViewById(R.id.editText_CarName);
        carID = findViewById(R.id.textView_ID);
        carYear = findViewById(R.id.EditText_Year);
        carCompany = findViewById(R.id.editText_CarCompany);
        kindOfCar = findViewById(R.id.editText_KindOfCar);
        btnDelete = findViewById(R.id.btnDelete);
        btnEdit = findViewById(R.id.btnEdit);
        btnUpdate = findViewById(R.id.btnUpdate);


        ref = FirebaseDatabase.getInstance().getReference().child("Car");
        String CarKey = getIntent().getStringExtra("CarKey");
        DataRef = FirebaseDatabase.getInstance().getReference().child("Car").child(CarKey);
        StorageRef = FirebaseStorage.getInstance().getReference().child("CarImage").child(CarKey + ".jpg");

        ref.child(CarKey).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if (dataSnapshot.exists()) {
                    String carID = dataSnapshot.child("ID").getValue().toString();
                    String carYear = dataSnapshot.child("Year").getValue().toString();
                    String carName = dataSnapshot.child("CarName").getValue().toString();
                    String carCompany = dataSnapshot.child("Company").getValue().toString();
                    String KindOfCar= dataSnapshot.child("KindOfCar").getValue().toString();
                    String ImageUrl = dataSnapshot.child("ImageUrl").getValue().toString();



                    ViewActivity.this.carID.setText(carID);
                    ViewActivity.this.carYear.setText(carYear);
                    ViewActivity.this.carName.setText(carName);
                    ViewActivity.this.carCompany.setText(carCompany);
                    ViewActivity.this.kindOfCar.setText(KindOfCar);
                    Picasso.get().load(ImageUrl).into(imageView); // Get image


                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



    /**--> Start of Code Button Edit*/
        btnEdit.setOnClickListener(v ->{
            // isEditUpdate =! isEditUpdate;
            // btnEdit.setText(isEditUpdate? "Update" : "Edit");
            // carYear.setEnabled(isEditUpdate? true :false);
            if(isEditUpdate=true) {
                btnEdit.setVisibility(View.INVISIBLE);
                btnUpdate.setVisibility(View.VISIBLE);

                carYear.setEnabled(true);
                carName.setEnabled(true);
                carName.requestFocus();
                carCompany.setEnabled(true);

                kindOfCar.setEnabled(true);
            }

        });
    /** <-- End of Code Button Edit */


    /**--> Start of Code Button Delete*/
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    //Show confirmation Dialog before Delete
                    new AlertDialog.Builder(ViewActivity.this).
                        setTitle("Delete Image")
                        .setMessage("Are you sure to delete this ?")
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setPositiveButton(R.string.yes, (DialogInterface dialog, int whichButton) -> {

                            //Replace block code you want to delete
                            DataRef.removeValue().addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    StorageRef.delete().addOnSuccessListener(new OnSuccessListener<Void>() {
                                        @Override
                                        public void onSuccess(Void aVoid) {
                                            startActivity(new Intent(getApplicationContext(),HomeActivity.class));
                                            Toast.makeText(ViewActivity.this, "One image is Deleted", Toast.LENGTH_SHORT).show();
                                        }
                                    });
                                }
                            });

                        }).setNegativeButton(R.string.no, null).show();
            }
        });
    /**<-- End of Code Button Delete*/


    /**--> Start of Code Button Update*/
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int imageYear = Integer.parseInt(carYear.getText().toString());
                String imageName = carName.getText().toString();
                String imageCompany = carCompany.getText().toString();
                String KindOfCar = kindOfCar.getText().toString();


                // DataRef.child("Year").setValue(imageYear) // Ok Run
                DataRef.child("Year").setValue(imageYear);
                DataRef.child("CarName").setValue(imageName);
                DataRef.child("Company").setValue(imageCompany);
                DataRef.child("KindOfCar").setValue(KindOfCar)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        startActivity(new Intent(getApplicationContext(),HomeActivity.class));
                        Toast.makeText(ViewActivity.this,
                        "Data Successfully Uploaded!", Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(ViewActivity.this,
                                "" + e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    /**<-- End of Code Button Update*/

    } // This braces for close onCreate method.


}
