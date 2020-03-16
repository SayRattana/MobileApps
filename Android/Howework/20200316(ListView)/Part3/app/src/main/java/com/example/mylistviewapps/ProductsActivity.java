package com.example.mylistviewapps;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.mylistview.R;

import com.example.mylistviewapps.models.Product;


import java.util.ArrayList;

public class ProductsActivity extends AppCompatActivity {
    private ArrayList<Product> products = new ArrayList<>();
    private ListView lvProducts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        lvProducts = findViewById(R.id.lvProducts);
        this.generateFakeData();

    }

    private void generateFakeData() {
        //this data is used for testing
        //in practical project, we must have backend and web service
        this.products.add(new Product(1,
                "Chrome",
                "https://i1.pngguru.com/preview/51/132/975/chrome-icon-el-capitan-yosemite-style-chrosemite-google-chrome-icon.jpg",
                "",
                "" ));

        this.products.add(new Product(2,
                "Gallery",
                "https://lh3.googleusercontent.com/4rkxLpvjH4jTS8w9RAu5kl00mkBstlT0g4-lkm7cSWM1YljNhC30HXK9WSk7nCCZ1mfU",
                "",
                "" ));

        this.products.add(new Product(3,
                "Calculator",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcTNzistxT_koYkfRzfMYIz0oIV-NjbnrQtZkCXphP5w8XazB4r1",
                "",
                "" ));

        this.products.add(new Product(4,
                "Clock",
                "https://www.creativefabrica.com/wp-content/uploads/2018/12/Time-clock-icon-vector-EPS-10-by-Hoeda80-580x386.jpg",
                "",
                "" ));

        this.products.add(new Product(5,
                "Play Store",
                "https://cdn.iconscout.com/icon/free/png-512/play-store-12-729064.png",
                "",
                ""));

        this.products.add(new Product(6,
                "Stack",
                "https://lh3.googleusercontent.com/proxy/2TTbqK2cTAPOpPa7RykQH6IEzVFkDwR6vrlrCCb-MrHDVueflanooww9OLKOq9iS4USTE-8m-iNT4Lo8Zdlh_PIVrd75EnHqaHhTwWWkrH9DLpAPp_KR_-V7uL1cMAWQxiSjEq_bOU6xLUdlSCXJIvU",
                "",
                ""));

        this.products.add(new Product(7,
                "Playo",
                "https://img.apksum.com/0e/com.techmash.playo/3.1.4/icon.png",
                "",
                ""));

        this.products.add(new Product(8,
                "Wynk Music",
                "https://i7.pngguru.com/preview/126/15/578/wynk-music-download-free-music-pakistan-culture.jpg",
                "",
                ""));

        this.products.add(new Product(9,
                "Message",
                "https://www.pngitem.com/pimgs/m/108-1080617_email-png-image-file-blue-message-icon-png.png",
                "",
                ""));


        this.products.add(new Product(10,
                "Facebook",
                "https://cdn1.iconfinder.com/data/icons/social-media-set-for-free/32/facebook-512.png",
                "",
                ""));



        //what's happen when I clicked each Iem?
        lvProducts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Product product = ProductsActivity.this.products.get(position);
                Toast.makeText(ProductsActivity.this, "You clicked :"+product.getProductName(), Toast.LENGTH_LONG)
                        .show();
            }
        });
        //We must create adapter object
        ProductAdapter productAdapter = new ProductAdapter(this, this.products);
        this.lvProducts.setAdapter(productAdapter);
    }
}
