package com.example.demo.request;

public class ProductRequest {
    private String productName;
    private String productDescription;
    private int productPrice;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public ProductRequest(String productName, String productDescription, int productPrice) {
        this.productName = productName;
        this.productDescription = productDescription;
        this.productPrice = productPrice;


    }

    public String[] getCategoryNames() {
        return null;
    }
}
