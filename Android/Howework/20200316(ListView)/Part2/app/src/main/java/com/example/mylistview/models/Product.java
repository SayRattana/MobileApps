package com.example.mylistview.models;

public class Product {
    private Integer productId;
    private String productName;
    private String productURL;


    public Product(Integer productId, String productName, String productURL) {
        this.productId = productId;
        this.productName = productName;
        this.productURL = productURL;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductURL() {
        return productURL;
    }

    public void setProductURL(String productURL) {
        this.productURL = productURL;
    }
}
