package com.example.checkcompounds;

import android.util.Log;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

/*
Получаем информацию о последних продуктах
*/

public class ParseAVITO {

    public static ArrayList<GoodAVITO> getWeb(String pageAddress){

        ArrayList<GoodAVITO> goodAVITOArrayList = new ArrayList<>();
        try {
            Document doc = Jsoup.connect(pageAddress).get();

            //Получаем карты с товарами (без фото)
            Elements content = doc.getElementsByClass("iva-item-body-R_Q9c");

            //Создаем список

            for (Element e : content){
                GoodAVITO goodAVITO = new GoodAVITO();

                //Названия продуктов(Titles)
                goodAVITO.setTitle(e.
                        select("div[class=iva-item-titleStep-_CxvN]").text());
                Log.d("MyLog", "NAME = "+ e.
                        select("div[class=iva-item-titleStep-_CxvN]").text());
                //Цена продукта
                Log.d("MyLog", "PRICE = "+ e.
                        select("span[class=price-text-E1Y7h text-text-LurtD text-size-s-BxGpL]").text()); //нужно взять только число

               //!!!!
                //Цена может быть не указана или в формате типа 500 р
                String st = e.select("span[class=price-text-E1Y7h text-text-LurtD text-size-s-BxGpL]").text();
                st = st.substring(0, st.length()-2);
                try{
                    goodAVITO.setPrice(Float.valueOf(st));
                } catch (Exception exception){
                    goodAVITO.setPrice(Float.NaN);
                }

                /*
                goodAVITO.setPrice(Float.valueOf (e.
                        select("span[class=price-text-E1Y7h text-text-LurtD text-size-s-BxGpL]").text()));
                */
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
