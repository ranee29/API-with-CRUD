package com.in28minutes.springboot.myfirstwebapp.products;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class products {
    @Id
    @GeneratedValue
    private int productId;
    private String productName;
    private double price;
    private int quantity;


    public products(){

    }

    public products(int productId, String productName, double price, int quantity) {
        super();
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;

    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }



    @Override
    public String toString() {
        return "products{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }

}
