package com.example.kiragu.phancyflowers.models;

import org.parceler.Parcel;

/**
 * Created by kiragu on 6/21/17.
 */
@Parcel
public class Product {
    private String name;
    private int photo;

    public Product(String name, int photo) {
        this.name = name;
        this.photo = photo;
    }

//    empty constructor for parceler
    public Product(){}

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
