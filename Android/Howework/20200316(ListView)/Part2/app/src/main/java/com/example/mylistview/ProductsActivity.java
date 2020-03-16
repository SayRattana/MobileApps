package com.example.mylistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.mylistview.models.Product;

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
                "Apple",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQHf8Iiuu2_3m10kH5dUBAzbM2crwDApoah71T0niGrhUhxVKPB"
        ));
        this.products.add(new Product(2,
                "Orange",
                "https://i.pinimg.com/originals/05/79/5a/05795a16b647118ffb6629390e995adb.jpg"
        ));
        this.products.add(new Product(3,
                "Kiwi",
                "https://previews.123rf.com/images/usersam2007/usersam20071709/usersam2007170900006/85631504-front-view-of-half-kiwi-fruit-isolated-on-white-background.jpg"
        ));
        this.products.add(new Product(4,
                "Passion",
                "https://cdn.shopify.com/s/files/1/0038/9405/0868/products/Passiflora_PassionFlower_purplefruit_1024x1024.jpg?v=1565213354"
        ));
        this.products.add(new Product(5,
                "Banana",
                "https://sb-assets.sgp1.cdn.digitaloceanspaces.com/product/main_image/1593/261fe2a9-17ef-450a-8611-ab2bf70fb17a.jpg"
        ));

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
