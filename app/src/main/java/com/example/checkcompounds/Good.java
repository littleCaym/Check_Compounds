package com.example.checkcompounds;

public abstract class Good {
    public static final String TITLE = "TITLE";
    public static final String PRICE = "PRICE";
    public static final String DATE_UPLOAD = "DATE_UPLOAD";
    public static final String LINK = "LINK";
    public static final String BRAND = "BRAND";
    public static String DESCRIPTION = "DESCRIPTION";



    private String title;
    private float price;
    private String date_upload;
    private String link;
    private String brand;
    private String description;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDate_upload() {
        return date_upload;
    }

    public void setDate_upload(String date_upload) {
        this.date_upload = date_upload;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
