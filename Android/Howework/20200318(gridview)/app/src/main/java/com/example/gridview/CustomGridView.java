package com.example.gridview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomGridView extends BaseAdapter {
    private Context context;
    private final int [] gridViewImage;
    private final String[] gridViewText;

    public CustomGridView(Context context, int[] gridViewImage, String[] gridViewText) {
        this.context = context;
        this.gridViewImage = gridViewImage;
        this.gridViewText = gridViewText;
    }


    @Override
    public int getCount() {
        return gridViewText.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View gridViewLayout;
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if(convertView==null){
            gridViewLayout = new View(context);
            gridViewLayout = inflater.inflate(R.layout.grid_layout,null);
            TextView tvGridTextView = gridViewLayout.findViewById(R.id.tvGridTextView);
            ImageView gvImageView = gridViewLayout.findViewById(R.id.gvImageView);
            tvGridTextView.setText(gridViewText[position]);
            gvImageView.setImageResource(gridViewImage[position]);
        }else {
            gridViewLayout = (View) convertView;
        }
        return gridViewLayout;
    }
}
