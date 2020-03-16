package com.example.mylistviewapps.models;

public class Product {
    private Integer productId;
    private String productName;
    private String productURL;
    private String productStream;
    private String productClose;

    public Product(Integer productId, String productName, String productURL, String productStream, String productClose) {
        this.productId = productId;
        this.productName = productName;
        this.productURL = productURL;
        this.productStream = productStream;
        this.productClose = productClose;
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

    public String getProductStream() {
        return productStream;
    }

    public void setProductStream(String productStream) {
        this.productStream = productStream;
    }

    public String getProductClose() {
        return productClose;
    }

    public void setProductClose(String productClose) {
        this.productClose = productClose;
    }
}
