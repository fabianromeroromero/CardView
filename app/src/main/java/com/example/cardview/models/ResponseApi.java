package com.example.cardview.models;

import java.util.LinkedList;

public class ResponseApi {
    private LinkedList<Product> products;

    public LinkedList<Product> getProducts() {
        return products;
    }

    public void setProducts(LinkedList<Product> products) {
        this.products = products;
    }
}
