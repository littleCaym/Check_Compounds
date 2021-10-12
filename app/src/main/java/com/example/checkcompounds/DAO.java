package com.example.checkcompounds;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.sql.Date;
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

    public static ArrayList<GoodOZON> getOzonGoods(SQLiteDatabase db){
        ArrayList<GoodOZON> goodOZONArrayList = new ArrayList<>();

        Cursor c = db.query(DBHelper.GOODS_OZON, null, null, null, null, null, DBHelper.DATE_VIEWED);

        if (c.moveToFirst()){
         //   int idColIndex = c.getColumnIndex(DBHelper.ID);
            int titleColIndex = c.getColumnIndex(GoodOZON.TITLE);
            int priceColIndex = c.getColumnIndex(GoodOZON.PRICE);
            int prev_priceColIndex = c.getColumnIndex(GoodOZON.PREV_PRICE);
            int brandColIndex = c.getColumnIndex(GoodOZON.BRAND);
            int linkColIndex = c.getColumnIndex(GoodOZON.LINK);
            int date_uploadColIndex = c.getColumnIndex(GoodOZON.DATE_UPLOAD);
            int descriptionColIndex = c.getColumnIndex(GoodOZON.DESCRIPTION);
            int ratingColIndex = c.getColumnIndex(GoodOZON.RATING);
            int rated_timesIndex = c.getColumnIndex(GoodOZON.RATED_TIMES);
         //   int date_viewvedColIndex = c.getColumnIndex(DBHelper.DATE_VIEWED);

            do {
                GoodOZON gO = new GoodOZON();
                gO.setTitle(c.getString(titleColIndex));
                gO.setPrice(c.getFloat(priceColIndex));
                gO.setPrevPrice(c.getFloat(prev_priceColIndex));
                gO.setBrand(c.getString(brandColIndex));
                gO.setLink(c.getString(linkColIndex));
                gO.setDate_upload(c.getString(date_uploadColIndex));
                gO.setDescription(c.getString(descriptionColIndex));
                gO.setRating(c.getDouble(ratingColIndex));
                gO.setRatedTimes(c.getInt(rated_timesIndex));

                goodOZONArrayList.add(gO);

            } while (c.moveToNext());
        }
        c.close();
        return goodOZONArrayList;
    }

    public static ArrayList<GoodAVITO> getAvitoGoods(SQLiteDatabase db){
        ArrayList<GoodAVITO> goodAVITOArrayList = new ArrayList<>();

        Cursor c = db.query(DBHelper.GOODS_AVITO, null, null, null, null, null, DBHelper.DATE_VIEWED);

        if (c.moveToFirst()){
            //   int idColIndex = c.getColumnIndex(DBHelper.ID);
            int titleColIndex = c.getColumnIndex(GoodAVITO.TITLE);
            int priceColIndex = c.getColumnIndex(GoodAVITO.PRICE);
            int brandColIndex = c.getColumnIndex(GoodAVITO.BRAND);
            int linkColIndex = c.getColumnIndex(GoodAVITO.LINK);
            int date_uploadColIndex = c.getColumnIndex(GoodAVITO.DATE_UPLOAD);
            int descriptionColIndex = c.getColumnIndex(GoodAVITO.DESCRIPTION);
            int locationColIndex = c.getColumnIndex(GoodAVITO.LOCATION);
            //   int date_viewvedColIndex = c.getColumnIndex(DBHelper.DATE_VIEWED);

            do {
                GoodAVITO gA = new GoodAVITO();
                gA.setTitle(c.getString(titleColIndex));
                gA.setPrice(c.getFloat(priceColIndex));
                gA.setBrand(c.getString(brandColIndex));
                gA.setLink(c.getString(linkColIndex));
                gA.setDate_upload(c.getString(date_uploadColIndex));
                gA.setDescription(c.getString(descriptionColIndex));
                gA.setLocation(c.getString(locationColIndex));

                goodAVITOArrayList.add(gA);

            } while (c.moveToNext());
        }
        c.close();
        return goodAVITOArrayList;
    }


    //Берем дату загрузки по первому элементу
    public static java.sql.Date getDateOfLastUpdate(SQLiteDatabase db){
        java.sql.Date date = null;
        ContentValues cv = new ContentValues();
        Cursor c = db.query(DBHelper.GOODS_OZON, null, null, null, null, null, null);
        if (c.moveToLast()){
            date = java.sql.Date.valueOf(
                    c.getString(
                            c.getColumnIndex(
                                    DBHelper.DATE_VIEWED)));
        }
        return date;

    }





}
