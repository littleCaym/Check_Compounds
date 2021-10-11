package com.example.checkcompounds;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.Map;

public class DAO {
    public static final String READ = "READ";
    public static final String INSERT = "INSERT";
    public static final String UPDATE = "UPDATE";
    public static final String DELETE = "DELETE";

    private String table_name;
    private Map<String, String> row;
    private String command;

    public static void addOzonGoods(ArrayList<GoodOZON> goods, SQLiteDatabase db, java.sql.Date date){

        for (GoodOZON g: goods) {
            ContentValues cv = new ContentValues();

            cv.put(GoodOZON.TITLE, g.getTitle());
            cv.put(GoodOZON.BRAND, g.getBrand());
            cv.put(GoodOZON.PRICE, g.getPrice());
            cv.put(GoodOZON.PREV_PRICE, g.getPrevPrice());
            cv.put(GoodOZON.DATE_UPLOAD, g.getDate_upload());
            cv.put(GoodOZON.DESCRIPTION, g.getDescription());
            cv.put(GoodOZON.RATING, g.getRating());
            cv.put(GoodOZON.RATED_TIMES, g.getRatedTimes());
            cv.put(GoodOZON.LINK, g.getLink());

            cv.put(DBHelper.DATE_VIEWED, String.valueOf(date));

            db.insert(DBHelper.GOODS_OZON, null, cv);
        }

    }


    public static void addAvitoGoods(ArrayList<GoodAVITO> goods, SQLiteDatabase db, java.sql.Date date){

        for (GoodAVITO g: goods) {
            ContentValues cv = new ContentValues();

            cv.put(GoodAVITO.TITLE, g.getTitle());
            cv.put(GoodAVITO.BRAND, g.getBrand());
            cv.put(GoodAVITO.PRICE, g.getPrice());
            cv.put(GoodAVITO.DATE_UPLOAD, g.getDate_upload());
            cv.put(GoodAVITO.DESCRIPTION, g.getDescription());
            cv.put(GoodAVITO.LOCATION, g.getLocation());
            cv.put(GoodAVITO.LINK, g.getLink());

            cv.put(DBHelper.DATE_VIEWED, String.valueOf(date));

            db.insert(DBHelper.GOODS_AVITO, null, cv);
        }

    }





}
