package com.example.checkcompounds;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Set;

/*
Получаем информацию о последних продуктах
*/

public class ParseAVITO {

    public static ArrayList<GoodAVITO> getWeb(String pageAddress){

        ArrayList<GoodAVITO> goodAVITOArrayList = new ArrayList<>();
        try {
            Document doc = Jsoup.connect(pageAddress).get();
            //Нам надо чтоб прогрузилось все
            //Получаем карты с товарами (без фото)
            String strHtml = doc.outerHtml();
            doc = Parser.parse(strHtml, pageAddress);
            Elements content = doc.getElementsByClass("iva-item-content-UnQQ4");

            //Создаем список

            for (Element e : content){
                GoodAVITO goodAVITO = new GoodAVITO();

                //Название продукта(Title)
                goodAVITO.setTitle(e.
                        select("div[class=iva-item-titleStep-_CxvN]").text());
                Log.d("MyLog", "NAME = "+ e.
                        select("div[class=iva-item-titleStep-_CxvN]").text());


                String strBrand = e.select("div[class=style-title-Vq4l0 text-text-LurtD text-size-s-BxGpL]").text();
                if (strBrand.equals(""))
                    strBrand = e.select("div[class=styles-root-JMoCE text-text-LurtD text-size-s-BxGpL]").text();

                goodAVITO.setBrand(strBrand
                );
                Log.d("MyLog", "BRAND = "+ strBrand
                );


               //!!!!
                //Цена продукта
                Log.d("MyLog", "PRICE = "+ e.
                        select("span[class=price-text-E1Y7h text-text-LurtD text-size-s-BxGpL]").text()); //нужно взять только число
                //Цена может быть не указана или в формате типа 500 р
                String st = e.select("span[class=price-text-E1Y7h text-text-LurtD text-size-s-BxGpL]").text();
                st = st.substring(0, st.length()-2);
                try{
                    goodAVITO.setPrice(Float.valueOf(st));
                } catch (Exception exception){
                    goodAVITO.setPrice(Float.NaN);
                }
                //!!!!

                //Описание продукта
                goodAVITO.setDescription(e.
                        select("div[class=iva-item-descriptionStep-QGE8Y]").text());
                Log.d("MyLog", "DESCRIPTION = "+ e.
                        select("div[class=iva-item-descriptionStep-QGE8Y]").text());
                //Локация
                goodAVITO.setLocation(e.
                        select("div[class=geo-root-H3eWU iva-item-geo-g3iIJ]").text());
                Log.d("MyLog", "LOCATION = "+ e.
                        select("div[class=geo-root-H3eWU iva-item-geo-g3iIJ]").text());
                //Время загрузки объявления
                goodAVITO.setDate_upload(e.
                        select("div[class=iva-item-dateInfoStep-_dkz9]").text());
                Log.d("MyLog", "DATE = "+ e.
                        select("div[class=iva-item-dateInfoStep-_dkz9]").text());
                //Ссылка
                //Добавим вначале https://www.avito.ru/
                goodAVITO.setLink("https://www.avito.ru/"+
                        e.getElementsByTag("a").first().attr("href")
                );
                Log.d("MyLog", "LINK = "+ goodAVITO.getLink());

                Log.d("MyLog", "-----------------------------------");



                goodAVITOArrayList.add(goodAVITO);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

        return goodAVITOArrayList;

    }

    public static ArrayList<GoodAVITO> getWeb2(String pageAddress){

        ArrayList<GoodAVITO> goodAVITOArrayList = new ArrayList<>();
        try {
            Document doc = Jsoup.connect(pageAddress).get();

            //Получаем карты с товарами (без фото)
            Elements content = doc.getElementsByClass("iva-item-content-UnQQ4");

            //Создаем список

            for (Element e : content){
                GoodAVITO goodAVITO = new GoodAVITO();
                //TODO: "Это все лучше паристь из json"

                //Название продукта(Title)
                goodAVITO.setTitle(e.
                        select("div[class=iva-item-titleStep-_CxvN]").text());
                Log.d("MyLog", "NAME = "+ e.
                        select("div[class=iva-item-titleStep-_CxvN]").text());

                goodAVITO.setBrand(e.
                        select("div[class=style-title-Vq4l0 text-text-LurtD text-size-s-BxGpL]").text());
                Log.d("MyLog", "BRAND = "+ e.
                        select("div[class=style-title-Vq4l0 text-text-LurtD text-size-s-BxGpL]").text());

                //!!!!
                //Цена продукта
                Log.d("MyLog", "PRICE = "+ e.
                        select("span[class=price-text-E1Y7h text-text-LurtD text-size-s-BxGpL]").text()); //нужно взять только число
                //Цена может быть не указана или в формате типа 500 р
                String st = e.select("span[class=price-text-E1Y7h text-text-LurtD text-size-s-BxGpL]").text();
                st = st.substring(0, st.length()-2);
                try{
                    goodAVITO.setPrice(Float.valueOf(st));
                } catch (Exception exception){
                    goodAVITO.setPrice(Float.NaN);
                }
                //!!!!

                //Описание продукта
                goodAVITO.setDescription(e.
                        select("div[class=iva-item-descriptionStep-QGE8Y]").text());
                Log.d("MyLog", "DESCRIPTION = "+ e.
                        select("div[class=iva-item-descriptionStep-QGE8Y]").text());
                //Локация
                goodAVITO.setLocation(e.
                        select("div[class=geo-root-H3eWU iva-item-geo-g3iIJ]").text());
                Log.d("MyLog", "LOCATION = "+ e.
                        select("div[class=geo-root-H3eWU iva-item-geo-g3iIJ]").text());
                //Время загрузки объявления
                goodAVITO.setDate_upload(e.
                        select("div[class=iva-item-dateInfoStep-_dkz9]").text());
                Log.d("MyLog", "DATE = "+ e.
                        select("div[class=iva-item-dateInfoStep-_dkz9]").text());
                Log.d("MyLog", "-----------------------------------");

                goodAVITOArrayList.add(goodAVITO);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

        return goodAVITOArrayList;

    }

}
