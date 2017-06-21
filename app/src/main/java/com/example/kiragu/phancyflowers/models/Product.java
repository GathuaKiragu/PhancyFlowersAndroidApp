package com.example.kiragu.phancyflowers.models;

/**
 * Created by kiragu on 6/21/17.
 */

public class Product {
    private String name;
    private int photo;

    public Product(String name, int photo) {
        this.name = name;
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }
}
