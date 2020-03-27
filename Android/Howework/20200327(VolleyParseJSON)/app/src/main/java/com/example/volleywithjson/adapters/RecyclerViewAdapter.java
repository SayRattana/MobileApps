package com.example.volleywithjson.adapters;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
                                                //Auth: Say Rattana
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.volleywithjson.R;
import com.example.volleywithjson.model.Anime;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
    private Context mContext ;
    private List<Anime> mData ;
    RequestOptions option;

    public RecyclerViewAdapter(Context mContext, List<Anime> mData) {
        this.mContext = mContext;
        this.mData = mData;

        //Request option for Glide
        option = new RequestOptions().centerCrop()
                .placeholder(R.drawable.loading_shape)
                .error(R.drawable.loading_shape);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        view = inflater.inflate(R.layout.anime_row_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.anime.setText(mData.get(position).getName());
        holder.rating.setText(mData.get(position).getRating());
        holder.categories.setText(mData.get(position).getCategorie());
        holder.studio.setText(mData.get(position).getStudio());

        // load image from the internet using Glide
        Glide.with(mContext).load(mData.get(position)
                .getImage_url()).apply(option)
                .into(holder.imgthumbnail);

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView anime,rating, categories,studio;
        ImageView imgthumbnail;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            anime = itemView.findViewById(R.id.anime);
            rating = itemView.findViewById(R.id.rating);
            categories = itemView.findViewById(R.id.categories);
            studio = itemView.findViewById(R.id.studio);
            imgthumbnail = itemView.findViewById(R.id.thumbnail);

        }
    }





}
