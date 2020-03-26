package com.example.mylistviewapps;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mylistview.R;

import com.example.mylistviewapps.models.Product;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;

public class ProductAdapter extends BaseAdapter {
    private Context context;
    ArrayList<Product> products;

    public ProductAdapter(Context context, ArrayList<Product> products) {
        this.context = context;
        this.products = products;
    }

    @Override
    public int getCount() {
        //Number of items in the list ?
        return this.products.size();
    }

    @Override
    public Object getItem(int position) {
        return this.products.get(position);
    }

    @Override
    public long getItemId(int position) {
        return this.products.get(position).getProductId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //Interface of item ? use xml
        //we call product_item.xml
        //Read from xml => use inflater function
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View productItem = inflater.inflate(R.layout.item_products, parent, false);
        mapProductToUI(productItem, this.products.get(position), position);
        return productItem;
    }
    private void mapProductToUI(View view, Product product, int position) {
        if(position % 2 == 0) {
            view.setBackgroundColor(0x66FF0000);//red
        } else {
            view.setBackgroundColor(0x6600FF00);//green
        }
        ImageView imageViewProductURL = view.findViewById(R.id.imageViewProductURL);
        Picasso.get().load(product.getProductURL()).into(imageViewProductURL);
        TextView txtProductName = view.findViewById(R.id.txtProductName);
        txtProductName.setText(product.getProductName());
//        ImageView imageViewProductStream = view.findViewById(R.id.imageViewStream);
//        Picasso.get().load(product.getProductURL()).into(imageViewProductStream);
//        ImageView imageViewProductClose = view.findViewById(R.id.imageViewClose);
//        Picasso.get().load(product.getProductURL()).into(imageViewProductClose);



    }
}
