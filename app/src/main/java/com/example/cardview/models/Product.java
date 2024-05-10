package com.example.cardview.models;

public class Product {
    private String title;
    private String brand;
    private double price;
    private String thumbnail;
    private float rating;

    public Product() {
    }

    public Product(String title, String brand, double price, String thumbnail, float rating) {
        this.title = title;
        this.brand = brand;
        this.price = price;
        this.thumbnail = thumbnail;
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }
}
