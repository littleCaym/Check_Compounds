package com.example.checkcompounds;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.net.ssl.HttpsURLConnection;

/*
Парсим цену по заранее выбранным продуктам на Озон
Ссылки лежат в Links
 */

public class ParseOZON {

    //Парсинг по запросам

    public static ArrayList<GoodOZON> getWeb(String pageAddress){
        return getTheRestOfElementsFromJSON(pageAddress);
    }

    private static ArrayList<GoodOZON> getTheRestOfElementsFromJSON(String pageAddress){


        ArrayList<GoodOZON> goodOZONArrayList = new ArrayList<>();
        Document doc = null;
        try {

            //Получаем элемент json в виде строки из DOM
            doc = Jsoup.connect(pageAddress).get();
            Elements content = doc.getAllElements();
            Element element = content.select("body > script:nth-child(3)").first(); //берем windows.__NUXT__
            String strJson = element.unwrap().toString(); //Вырезаем текст элемента
            strJson = strJson.substring(27,strJson.length()-2); //Вырезаем json-элемент
            Log.d("MyLog", strJson);

            //Перегоняем в json
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            strJson = gson.fromJson(strJson,String.class);
            Log.d("MyLog", strJson);

            //Теперь нам надо получить инфу по каждому продукту
            JsonObject jsonObject = JsonParser.parseString(strJson).getAsJsonObject();

            JsonObject jProductInfoInJson = jsonObject.getAsJsonObject("state")
                    .getAsJsonObject("trackingPayloads");
            Set<String> listNumOfProduct = jProductInfoInJson.keySet();


            //Запихиваем в классы и массив
            for(String str : listNumOfProduct){
                JsonPrimitive jPrimitiveGood = jProductInfoInJson.getAsJsonPrimitive(str);
                JsonObject jsonObjectGood;
                try{
                    jsonObjectGood = JsonParser.parseString(jPrimitiveGood.getAsString()).getAsJsonObject();
                }catch (Exception exception){
                    continue;
                }

                if (jsonObjectGood.has("type")
                        && jsonObjectGood.has("price")
                        && jsonObjectGood.has("brand")){

                    if (jsonObjectGood.getAsJsonPrimitive("type").getAsString().equals("product")){

                        GoodOZON goodOZON = new GoodOZON();
                       // Log.d("MyLog", jsonObjectGood.toString());
                        goodOZON.setTitle(jsonObjectGood.getAsJsonPrimitive("title").getAsString());
                        goodOZON.setPrevPrice(jsonObjectGood.getAsJsonPrimitive("price").getAsFloat());
                        goodOZON.setPrice(jsonObjectGood.getAsJsonPrimitive("finalPrice").getAsFloat());//TODO: if exist
                        goodOZON.setBrand(jsonObjectGood.getAsJsonPrimitive("brand").getAsString());
                        goodOZON.setRating(jsonObjectGood.getAsJsonPrimitive("rating").getAsDouble());
                        goodOZON.setRatedTimes(jsonObjectGood.getAsJsonPrimitive("countItems").getAsInt());
                        goodOZON.setLink(jsonObjectGood.getAsJsonPrimitive("link").getAsString());

                        goodOZONArrayList.add(goodOZON);
                    }
                }
            }

            //Избавляемся от дубликатов
            goodOZONArrayList = new ArrayList<>(dropDuplicatesInArray(goodOZONArrayList));

            Log.d("MyLog", "srch: " +
                    jsonObject.getAsJsonObject("state")
                    .getAsJsonObject("trackingPayloads")
            );
            Log.d("MyLog", jsonObject.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
        return goodOZONArrayList;
    }

    private static ArrayList<GoodOZON> dropDuplicatesInArray(ArrayList<GoodOZON> inputArrList){
        ArrayList<GoodOZON> uniqueArrList = new ArrayList<>();
        HashSet<String> uniqueTitlesSet = new HashSet<>();
        for (int i = 0; i < inputArrList.size(); i++){
            if (!uniqueTitlesSet.contains(inputArrList.get(i).getTitle())){
                uniqueArrList.add(inputArrList.get(i));
            }
            uniqueTitlesSet.add(inputArrList.get(i).getTitle());
        }
        return uniqueArrList;
    }

}

/*
    private static ArrayList<GoodOZON> getFirstElementsFromDOM(String pageAddress){
        ArrayList<GoodOZON> goodOZONArrayList = new ArrayList<>();

        try {
            Document doc = Jsoup.connect(pageAddress).get();
            Elements content = doc.getElementsByClass("bi1");
            Log.d("MyLog",content.text());

            for (Element e : content){


                GoodOZON goodOZON = new GoodOZON();
                Log.d("MyLog",e.text());
                Log.d("MyLog", "NAME = "+ e.
                        select("span[class=a7y a8a2 a8a6 a8b2 f-tsBodyL bj5]").text());

                Log.d("MyLog", "PRICE = "+ e.
                        select("div[class=_24d4]").text()); //нужно взять только число

                Log.d("MyLog", "-----------------------------------");

                goodOZONArrayList.add(goodOZON);
            }




        } catch (IOException e) {
            e.printStackTrace();
        }

        return goodOZONArrayList;
    }
 */
