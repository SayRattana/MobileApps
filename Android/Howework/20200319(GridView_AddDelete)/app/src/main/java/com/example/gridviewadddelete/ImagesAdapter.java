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
    private ArrayList arrayList = new ArrayList<>();

    public ImagesAdapter(Context context, ArrayList arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
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

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.activity_imagetext, null);

        ImageView imageView = convertView.findViewById(R.id.gridItemImages);
        TextView textView = convertView.findViewById(R.id.gridItemLabels);

        int option = ((position+1)%7);
        switch (option) {
            case 0:
                textView.setText("Watch");
                imageView.setImageResource(R.drawable.ic_watch);
                break;

            case 1:
                textView.setText("Android");
                imageView.setImageResource(R.drawable.ic_android);
                break;

            case 2:
                textView.setText("Contact");
                imageView.setImageResource(R.drawable.ic_contact);
                break;

            case 3:
                textView.setText("Gas Station");
                imageView.setImageResource(R.drawable.ic_gasstation);
                break;

            case 4:
                textView.setText("Live TV");
                imageView.setImageResource(R.drawable.ic_livetv);
                break;

            case 5:
                textView.setText("Camera");
                imageView.setImageResource(R.drawable.ic_camera);
                break;

            case 6:
                textView.setText("Music");
                imageView.setImageResource(R.drawable.ic_music);
                break;

            default:
                textView.setText("Android");
                imageView.setImageResource(R.drawable.ic_launcher_background);
            break;
        }

        return convertView;

    }

}