package com.example.easylearning.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.easylearning.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterUsers extends RecyclerView.Adapter<AdapterUsers.MyHolder>{
    Context context;
    List<ModelUsers> usersList;


    //constructor
    public AdapterUsers(Context context, List<ModelUsers> usersList) {
        this.context = context;
        this.usersList = usersList;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view ;
//        LayoutInflater inflater = LayoutInflater.from(context);
//        view = inflater.inflate(R.layout.row_users,parent,false) ;

        View view = LayoutInflater.from(context).inflate(R.layout.row_users,parent,false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder myHolder, int position) {
        //get data
        String userImage = usersList.get(position).getImage();
        String userName = usersList.get(position).getName();
        String userEmail = usersList.get(position).getEmail();

        // set data
        myHolder.mNameTV.setText(userName);
        myHolder.mEmailTV.setText(userEmail);

        try {
            Picasso.get().load(userImage)
                    .placeholder(R.drawable.ic_default_img_white)
                    .into(myHolder.mAvatarIV);

        }catch (Exception e){

        }

        //Handle item click
        myHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, ""+userEmail, Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return usersList.size();
    }

    //View holder classe
    class  MyHolder extends RecyclerView.ViewHolder{
        ImageView mAvatarIV;
        TextView mNameTV,mEmailTV;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            mAvatarIV = itemView.findViewById(R.id.avatarIvUser);
            mNameTV = itemView.findViewById(R.id.nameTvUser);
            mEmailTV = itemView.findViewById(R.id.emailTvUser);

        }
    }





}
