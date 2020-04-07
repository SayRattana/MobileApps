package com.example.easylearning.productcar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.easylearning.R;
import com.example.easylearning.myapps.AboutActivity;
import com.example.easylearning.myapps.ProfileActivity;
import com.example.easylearning.myapps.SignInActivity;
import com.example.easylearning.myapps.UsersActivity;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE_IMAGE =101 ;
    private ImageView imageViewAdd;
    private EditText inputImageID,inputImageYear;
    private EditText inputImageName,inputImageCompany;
    protected EditText inputKindOfCar;
    private TextView textViewProgress;
    private ProgressBar progressBar;
    private Button btnUpload;

    Uri imageUri;
    boolean isImageAdded=false;
    boolean isImgageID=false;
    boolean isImageYear =false;
    boolean isImageCompany = false;
    boolean isKindOfCar= false;

    DatabaseReference Dataref;
    StorageReference  StorageRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**--> Start of block code bottom navigation */
            // Initialize and Assign Variable
            BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation_signout);
            // Set Home
            bottomNavigationView.setSelectedItemId(R.id.bottom_navi_signout);
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
                            startActivity(new Intent(getApplicationContext(),HomeActivity.class));
                            overridePendingTransition(0,0);
                            return true;
                    }

                    switch (item.getItemId()){
                        case R.id.bottom_navi_signout:
                            startActivity(new Intent(getApplicationContext(), SignInActivity.class));
                            overridePendingTransition(0,0);
                            Toast.makeText(MainActivity.this, "You are Signed out", Toast.LENGTH_SHORT).show();
                            return true;
                    }

                    return false;
                }
            });
        /**--> End of block code bottom navigation */



        inputImageID=findViewById(R.id.inputImageID);
        inputImageYear = findViewById(R.id.inputImageYear);
        imageViewAdd=findViewById(R.id.imageVIewAdd);
        inputImageName=findViewById(R.id.inputImageName);
        inputImageCompany =findViewById(R.id.inputImageCompany);
        inputKindOfCar = findViewById(R.id.inputKindofCar);
        textViewProgress=findViewById(R.id.textViewProgress);
        progressBar=findViewById(R.id.progressBar);
        btnUpload=findViewById(R.id.btnUpload);



        textViewProgress.setVisibility(View.GONE);
        progressBar.setVisibility(View.GONE);

        Dataref= FirebaseDatabase.getInstance().getReference().child("Car");        // Database
        StorageRef= FirebaseStorage.getInstance().getReference().child("CarImage"); // Image




        imageViewAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(intent,REQUEST_CODE_IMAGE);
            }
        });



        btnUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String imageName = inputImageName.getText().toString();
                final String imageCompany = inputImageCompany.getText().toString();
                final String kindOfCar = inputKindOfCar.getText().toString();
                final String imageID = inputImageID.getText().toString();
                final int imageYear = Integer.parseInt(inputImageYear.getText().toString());

                if ((isImgageID != false || imageID != null) &&
                        (isImageYear != false || imageYear != 0 ) &&
                        (isImageAdded != false || imageName != null &&
                        (isImageCompany != false || imageCompany != null) &&
                                (isKindOfCar != false || kindOfCar !=null))){

                    uploadImage(imageID,imageYear,imageName,imageCompany,kindOfCar);
                }else {
                    Toast.makeText(MainActivity.this, "Upload Error !", Toast.LENGTH_SHORT).show();
                }

            }
        });

    } // This braces for close onCreate method.

    private void uploadImage(final  String imageID, final int imageYear,
                             final String imageName, final String imageCompany,
                             final String kindOfCar) {
        textViewProgress.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.VISIBLE);


       final  String key=Dataref.push().getKey();
        StorageRef.child(key+".jpg")
                .putFile(imageUri)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                StorageRef.child(key +".jpg")
                        .getDownloadUrl()
                        .addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {
                        HashMap hashMap=new HashMap();
                        hashMap.put("ID",imageID);
                        hashMap.put("Year",imageYear);
                        hashMap.put("CarName",imageName);
                        hashMap.put("Company",imageCompany);
                        hashMap.put("KindOfCar",kindOfCar);
                        hashMap.put("ImageUrl",uri.toString());


                        Dataref.child(key).setValue(hashMap)
                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                startActivity(new Intent(getApplicationContext(),HomeActivity.class));
                                Toast.makeText(MainActivity.this,
                                        "Successfully Uploaded", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                });

            }
        }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                double progress=(taskSnapshot.getBytesTransferred()*100)/taskSnapshot.getTotalByteCount();
                progressBar.setProgress((int) progress);
                textViewProgress.setText(progress +" %");
            }
        });



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==REQUEST_CODE_IMAGE && data!=null)
        {
            imageUri=data.getData();
            isImgageID=true;
            isImageYear =true;
            isImageAdded=true;
            isImageCompany=true;
            isKindOfCar=true;
            imageViewAdd.setImageURI(imageUri);
        }
    }
}
