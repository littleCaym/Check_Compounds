package com.example.checkcompounds;

import java.util.function.Predicate;

public class GoodOZON extends Good{

    public static String PREV_PRICE = "PREV_PRICE";
    public static String RATING = "RATING";
    public static String RATED_TIMES = "RATED_TIMES";

  //  private String title;
  //  private float price;
    private float prevPrice;
   // private String description;
   // private String link;
    //private String brand;
    private double rating;
    private int ratedTimes;



    public float getPrevPrice() {
        return prevPrice;
    }

    public void setPrevPrice(float prevPrice) {
        this.prevPrice = prevPrice;
    }


    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public int getRatedTimes() {
        return ratedTimes;
    }

    public void setRatedTimes(int ratedTimes) {
        this.ratedTimes = ratedTimes;
    }
}
