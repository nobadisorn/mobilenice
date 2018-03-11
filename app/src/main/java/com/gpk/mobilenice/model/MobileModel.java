package com.gpk.mobilenice.model;

import org.parceler.Parcel;

import io.realm.MobileModelRealmProxy;
import io.realm.RealmObject;

/**
 * Created by nobtingtong on 10/3/2018 AD.
 */

@Parcel(implementations = {MobileModelRealmProxy.class}, value = Parcel.Serialization.BEAN, analyze = {MobileModel.class})
public class MobileModel extends RealmObject {
    private int id;
    private String description;
    private String name;
    private String brand;
    private String thumbImageURL;
    private double rating;
    private double price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getThumbImageURL() {
        return thumbImageURL;
    }

    public void setThumbImageURL(String thumbImageURL) {
        this.thumbImageURL = thumbImageURL;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
