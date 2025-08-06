package com.example.restauranthub;

public class Restaurant {
    private String name;
    private float rating;
    private String specialDish;
    private String phoneNumber;
    private int imageResource;


    public Restaurant(String name, float rating, String specialDish, String phoneNumber, int imageResource) {
        this.name = name;
        this.rating = rating;
        this.specialDish = specialDish;
        this.phoneNumber = phoneNumber;
        this.imageResource = imageResource;
    }


    public String getName() { return name; }
    public float getRating() { return rating; }
    public String getSpecialDish() { return specialDish; }
    public String getPhoneNumber() { return phoneNumber; }
    public int getImageResource() { return imageResource; }
}