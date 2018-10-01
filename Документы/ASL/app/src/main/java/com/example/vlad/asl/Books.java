package com.example.vlad.asl;

/**
 * Created by Belal on 10/18/2017.
 */


public class Books {
    private int id;
    private String title;
    private double rating;

    public Books(int id, String title, double rating) {
        this.id = id;
        this.title = title;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public double getRating() {
        return rating;
    }
}