package com.example.checkcompounds;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DBHelper extends SQLiteOpenHelper {

    public static String GOODS_DATABASE = "GOODS_DATABASE";
    public static String GOODS_AVITO = "GOODS_AVITO";
    public static String GOODS_OZON = "GOODS_OZON";
    public static String ID = "ID";
    public static String DATE_VIEWED = "DATE_VIEWED";

    public DBHelper(Context context) {
        // конструктор суперкласса
        super(context, GOODS_DATABASE, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Таблица товаров на Авито
        db.execSQL("DROP TABLE IF EXISTS "+GOODS_DATABASE+"."+GOODS_AVITO+";");
        db.execSQL("CREATE TABLE "+GOODS_AVITO+"(" +
                ID + " integer primary key autoincrement," +
                GoodAVITO.TITLE + " text," +
                GoodAVITO.PRICE + " float," +
                GoodAVITO.BRAND + " text," +
                GoodAVITO.LINK + " text," +
                GoodAVITO.DATE_UPLOAD + " text," +
                GoodAVITO.DESCRIPTION + " text," +
                GoodAVITO.LOCATION + " text," +
                DBHelper.DATE_VIEWED + " date" +
                ");"
        );

        //Таблица товаров на OZON
        db.execSQL("DROP TABLE IF EXISTS "+GOODS_DATABASE+"."+GOODS_OZON+";");
        db.execSQL("CREATE TABLE "+GOODS_OZON+"(" +
                ID + " integer primary key autoincrement," +
                GoodOZON.TITLE + " text," +
                GoodOZON.PRICE + " float," +
                GoodOZON.PREV_PRICE + " double," +
                GoodOZON.BRAND + " text," +
                GoodOZON.LINK + " text," +
                GoodOZON.DATE_UPLOAD + " text," +
                GoodOZON.DESCRIPTION + " text," +
                GoodOZON.RATING + " text," +
                GoodOZON.RATED_TIMES + " text," +
                DBHelper.DATE_VIEWED + " date" +
                ");"
        );

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }
}
