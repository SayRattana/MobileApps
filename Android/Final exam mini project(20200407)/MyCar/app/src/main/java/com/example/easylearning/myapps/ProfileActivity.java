package com.example.easylearning.myapps;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.easylearning.R;
import com.example.easylearning.productcar.HomeActivity;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;


import java.util.HashMap;

import static com.google.firebase.storage.FirebaseStorage.getInstance;

public class ProfileActivity extends AppCompatActivity {

    FirebaseAuth firebaseAuth;
    FirebaseUser user;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    //Storage
    StorageReference storageReference;
    //Path where image user profile and cover will be store
    String storagePath ="Users_Profile_Cover_Imgs/";

    //View from xml
    ImageView avatarIV,coverIV;
    TextView nameTV,emailTV,phoneTV;
    FloatingActionButton fab;

    // Show ProgressDialog
    ProgressDialog progressDialog;

    //Permission constance
    private static final int CAMERA_REQUEST_CODE =100;
    private static final int STORAGE_REQUEST_CODE =200;
    private static final int IMAGE_PICK_GALLERY_CODE =300;
    private static final int IMAGE_PICK_CAMERA_CODE =400;

    //Array of permission to requested
    String cameraPermission[];
    String storagePermission[];


    //Uri of pick image
    Uri imageUri;

    // for checking profile or cover photo
    String profileOrCoverPhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        /**-->Start of Code Header Toolbar */
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("My Profile");
        this.setSupportActionBar(toolbar);
        /**<--End of Code Header Toolbar */

        /**--> Start of block code bottom navigation */
        // Initialize and Assign Variable
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        // Set Home
        bottomNavigationView.setSelectedItemId(R.id.bottom_navi_profile);
        // Perform ItemSelectListner
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.bottom_navi_profile:
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


        // init firebase
        firebaseAuth = FirebaseAuth.getInstance();
        user = firebaseAuth.getCurrentUser();
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference =firebaseDatabase.getReference("Users");
        storageReference = getInstance().getReference();    //firebase storage referent


        //init array of permissions
        cameraPermission = new String[] {Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE};
        storagePermission = new String[] {Manifest.permission.WRITE_EXTERNAL_STORAGE};





        // init View
        avatarIV = findViewById(R.id.avatarIvUser);
        coverIV = findViewById(R.id.coverIV);
        nameTV = findViewById(R.id.nameTvUser);
        emailTV = findViewById(R.id.emailTvUser);
        phoneTV = findViewById(R.id.phoneTV);
        fab = findViewById(R.id.fab);

        progressDialog = new ProgressDialog(this);

        Query query = databaseReference.orderByChild("email").equalTo(user.getEmail());
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot.getChildren()){

                    //get date
                    String name = "" + ds.child("name").getValue();
                    String email = "" + ds.child("email").getValue();
                    String phone = "" + ds.child("phone").getValue();
                    String image = "" + ds.child("image").getValue();
                    String cover = "" + ds.child("cover").getValue();

                    //set date
                    nameTV.setText(name);
                    emailTV.setText(email);
                    phoneTV.setText(phone);
                    try {
                        Picasso.get().load(image).into(avatarIV);

                    }catch (Exception e){
                        //if this is any exception while getting image then set default.
                        Picasso.get().load(R.drawable.ic_default_img_white).into(avatarIV);
                    }

                    try {
                        Picasso.get().load(cover).into(coverIV);

                    }catch (Exception e){
                        //if this is any exception while getting image then set default.

                    }

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        //fab button click
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showEditProfileDialog();
            }
        });



    }//This barces for close onCreate method.


    private boolean checkStoragePermission(){
        //Check if storage permission is enabled or not
        //Return true is enable. and return false is not enabled
        boolean result = ContextCompat.checkSelfPermission(this,Manifest.permission.WRITE_EXTERNAL_STORAGE)
                == (PackageManager.PERMISSION_GRANTED);
        return result;
    }

    private void requestStoragePermission(){
       // ActivityCompat.requestPermissions(this,storagePermission,STORAGE_REQUEST_CODE);
        requestPermissions(storagePermission,STORAGE_REQUEST_CODE);
    }

    private boolean checkCameraPermission(){
        //Check if storage permission is enabled or not
        //Return true is enable. and return false is not enabled
        boolean result = ContextCompat.checkSelfPermission(this,Manifest.permission.CAMERA)
                == (PackageManager.PERMISSION_GRANTED);
        boolean result1 = ContextCompat.checkSelfPermission(this,Manifest.permission.WRITE_EXTERNAL_STORAGE)
                == (PackageManager.PERMISSION_GRANTED);
        return result && result1;
    }

    private void requestCameraPermission(){
        //ActivityCompat.requestPermissions(this,cameraPermission,CAMERA_REQUEST_CODE);
        requestPermissions(cameraPermission,CAMERA_REQUEST_CODE);
    }

    private void showEditProfileDialog() {
        //Option to show in dialog
        String options[] = {"Edit Profile Picture","Edit Cover Photo","Edit Name","Edit Phone"};

        //Alert dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(ProfileActivity.this);
        builder.setTitle("Choose Action");

        //Set item to Dialog
        builder.setItems(options, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //handle dialog item click
                if(which == 0){
                    // Edit Profile Click
                    progressDialog.setMessage("Updating Profile Picture");
                    profileOrCoverPhoto = "image"; // changing profile picture, make sure to assign same value.
                    showImagePicDialog();
                }
                else if (which ==1){
                    // Edit Cover Click
                    progressDialog.setMessage("Updating Cover Photo");
                    profileOrCoverPhoto = "cover";
                    showImagePicDialog();
                }
                else if (which ==2){
                    // Edit Name Click
                    progressDialog.setMessage("Updating Name");
                    showNamePhoneUpdateDialog("name");

                }
                else if (which ==3){
                    // Edit Phone Click
                    progressDialog.setMessage("Updating Phone");
                    showNamePhoneUpdateDialog("phone");

                }

            }
        });

        // Create and show
        builder.create().show();

    }

    private void showNamePhoneUpdateDialog(String key) {
        //Custom dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Update "+key); // e.g: Update name or Phone

        //set layout for dialog
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.setPadding(10,10,10,10);

        //Add edittext
        EditText editText = new EditText(this);
        editText.setHint("Enter "+key); //e.g: edit name or phone
        linearLayout.addView(editText);

        builder.setView(linearLayout);
        //Add button in dialog to update
        builder.setPositiveButton("Update", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //input text from Edit text
                String value = editText.getText().toString().trim();
                //validate if user has entered something or not
                if(!TextUtils.isEmpty(value)){
                    progressDialog.show();
                    HashMap<String,Object> result = new HashMap<>();
                    result.put(key,value);

                    databaseReference.child(user.getUid()).updateChildren(result)
                            .addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    progressDialog.dismiss();
                                    Toast.makeText(ProfileActivity.this,
                                            "Updated...", Toast.LENGTH_SHORT).show();

                                }
                            })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    progressDialog.dismiss();
                                    Toast.makeText(ProfileActivity.this,
                                            e.getMessage(), Toast.LENGTH_SHORT).show();

                                }
                            });

                }else {
                    Toast.makeText(ProfileActivity.this,
                            "Please enter "+ key, Toast.LENGTH_SHORT).show();
                }

            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        // Create and show dialog
        builder.create().show();

    }

    private void showImagePicDialog() {
        //Show dialog contain Option camera and Gallery to pick the image
        String options[] = {"Camera","Gallery"};

        //Alert dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(ProfileActivity.this);
        builder.setTitle("Pick Image");

        //Set item to Dialog
        builder.setItems(options, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //handle dialog item click
                if(which == 0){
                    // Camera Click
                    if(!checkCameraPermission()){
                        requestCameraPermission();
                    }else {
                        pickFromCamera();
                    }
                }

                else if (which ==1){
                    // Gallery Click
                    if(!checkStoragePermission()){
                        requestStoragePermission();
                    }else {
                        pickFromGallery();
                    }
                }

            }
        });

        // Create and show
        builder.create().show();


    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case CAMERA_REQUEST_CODE:{
                //Picking from Camera, First check from Camera and Storage permission allow or not
                if(grantResults.length>0){
                    boolean cameraAccepted = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                    boolean writeStorageAccepted = grantResults[1] == PackageManager.PERMISSION_GRANTED;
                        if(cameraAccepted && writeStorageAccepted){
                            //Permission enabled.
                            pickFromCamera();
                        }else {
                            //Permission Denied
                            Toast.makeText(this, "Please enable camera & storage permission"
                                    , Toast.LENGTH_SHORT).show();
                        }
                }
            }
            break;


            case STORAGE_REQUEST_CODE:{
                //Picking from Gallery, First check from  Storage permission allow or not
                if(grantResults.length>0){
                    boolean writeStorageAccepted = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                    if(writeStorageAccepted){
                        //Permission enabled.
                        pickFromGallery();
                    }else {
                        //Permission Denied
                        Toast.makeText(this, "Please enable storage permission"
                                , Toast.LENGTH_SHORT).show();
                    }
                }
            }
            break;

        }
        // super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        //Call after picking image from camera or gallery
        if(resultCode == RESULT_OK){
            if(requestCode==IMAGE_PICK_GALLERY_CODE){
                //image picked from gallery get uri of image
                imageUri = data.getData();

                uploadProfileCoverPhoto(imageUri);

            }
            if(requestCode == IMAGE_PICK_CAMERA_CODE){
                //image picked from camera get uri of image
                uploadProfileCoverPhoto(imageUri);

            }
        }


        super.onActivityResult(requestCode, resultCode, data);
    }

    private void uploadProfileCoverPhoto(Uri uri) {
        progressDialog.show();

        //Path and name of image to be store in firebase storage
        String filePathAndName = storagePath+""+profileOrCoverPhoto+"_"+user.getUid();

        StorageReference storageReference2nd = storageReference.child(filePathAndName);
        storageReference2nd.putFile(uri)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        //image is upload to storage, now get it's uri and store in user database
                        Task<Uri> uriTask = taskSnapshot.getStorage().getDownloadUrl();
                        while (!uriTask.isSuccessful());
                        Uri downloadUri = uriTask.getResult();

                        //Check image is upload or not
                        if(uriTask.isSuccessful()){
                            //image uploaded
                            //Add/upload url in User's Database
                            HashMap<String,Object> results = new HashMap<>();
                            results.put(profileOrCoverPhoto,downloadUri.toString());

                            databaseReference.child(user.getUid()).updateChildren(results)
                                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                                        @Override
                                        public void onSuccess(Void aVoid) {
                                            progressDialog.dismiss();
                                            Toast.makeText(ProfileActivity.this,
                                                    "Image Updated...", Toast.LENGTH_SHORT).show();

                                        }
                                    }).addOnFailureListener(new OnFailureListener() {
                                        @Override
                                        public void onFailure(@NonNull Exception e) {
                                            progressDialog.dismiss();
                                            Toast.makeText(ProfileActivity.this,
                                                    "Error Updating image", Toast.LENGTH_SHORT).show();


                                        }
                                    });

                        }
                        else {
                            progressDialog.dismiss();
                            Toast.makeText(ProfileActivity.this,
                                    "Some error occured", Toast.LENGTH_SHORT).show();
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                progressDialog.dismiss();
                Toast.makeText(ProfileActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void pickFromCamera() {
        //Intent of picking image from device camera
        ContentValues values = new ContentValues();
        values.put(MediaStore.Images.Media.TITLE,"Temp Pic");
        values.put(MediaStore.Images.Media.DESCRIPTION,"Temp Description");

        //input image Uri
        imageUri = this.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,values);

        //Inten to start Camera
        Intent cameraInter = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        cameraInter.putExtra(MediaStore.EXTRA_OUTPUT,imageUri);
        startActivityForResult(cameraInter,IMAGE_PICK_CAMERA_CODE);

    }

    private void pickFromGallery() {
        //Pick from Gallery
        Intent galleryInter = new Intent(Intent.ACTION_PICK);
        galleryInter.setType("image/*");
        startActivityForResult(galleryInter,IMAGE_PICK_GALLERY_CODE);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_profile) {
//            startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
//            overridePendingTransition(0,0);
//            return true;
//        }
//        if(id == R.id.action_signout){
//            startActivity(new Intent(getApplicationContext(), SignInActivity.class));
//            overridePendingTransition(0,0);
//            Toast.makeText(ProfileActivity.this,
//                    "You are Signed out", Toast.LENGTH_SHORT).show();
//            return true;
//        }

        switch (item.getItemId()){
            case R.id.action_home:
                startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                overridePendingTransition(0,0);
                return true;
        }
        switch (item.getItemId()){
            case R.id.action_profile:
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
                Toast.makeText(ProfileActivity.this,
                        "You are Signed out", Toast.LENGTH_SHORT).show();
                return true;
        }


        return false;
    }

}
