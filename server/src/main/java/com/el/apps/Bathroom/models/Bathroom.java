package com.el.apps.Bathroom.models;

import org.springframework.data.annotation.Id;

public class Bathroom {

    @Id
    private String id;
    private String name;
    private double latitude;
    private double longitude;
    private double rating;

    public Bathroom() {}

    public Bathroom(String name) {
        this.name = name;
    }
    
    public Bathroom(String name, double latitude, double longitude, double rating) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Bathroom{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}