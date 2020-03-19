package com.example.gridviewadddelete;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;



import java.util.ArrayList;

public class ImagesAdapter extends BaseAdapter {

    private Context context;
    private ArrayList list = new ArrayList<>();

    public ImagesAdapter(Context context, ArrayList list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.activity_imagetext, null);
        TextView textView = (TextView) convertView.findViewById(R.id.gridItemLabels);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.gridItemImages);

        int option = ((position+1)%3);

        switch (option) {
            case 0:
                textView.setText("Windows");
                imageView.setImageResource(R.drawable.windows_logo);
                break;
            case 1:
                textView.setText("Android");
                imageView.setImageResource(R.drawable.android_logo);
                break;
            case 2:
                textView.setText("IOS");
                imageView.setImageResource(R.drawable.ios_logo);
                break;
            default:
                textView.setText("Android");
                imageView.setImageResource(R.drawable.android_logo);
                break;
        }

        return convertView;

    }

}