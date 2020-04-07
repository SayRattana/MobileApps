package com.example.easylearning.productcar;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.easylearning.R;

class MyViewHolder extends RecyclerView.ViewHolder {
    ImageView imageView;
    TextView textView;

    View v;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        v=itemView;
        imageView=itemView.findViewById(R.id.image_single_view);
        textView=itemView.findViewById(R.id.textView_single_view);



    }
}
