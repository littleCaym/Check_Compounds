package com.example.checkcompounds;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Thread secThread, thirdTread;
    public static ArrayList<GoodOZON> goodOZONArrayList;
    public static ArrayList<GoodAVITO> goodAVITOArrayList;

    private boolean is_parsed = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //запускаем активити со списком продуктов
        init();
        while (!is_parsed){
            Intent intent = new Intent(this, ShowGoodsActivity.class);
            //  intent.putExtra(GOOD_OZON_ARRAYLIST, goodOZONArrayList);
            startActivity(intent);
        }



    }

    private void init(){
        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                    //Результаты поиска на АВИТО по запросам:
                    goodAVITOArrayList = new ArrayList<>();
                    for (String link : Links.getAVITOLinks()){
                        goodAVITOArrayList.addAll(ParseAVITO.getWeb(link));
                    }

                    //Результаты поиска на ОЗОН по запросам:
                    goodOZONArrayList = new ArrayList<>();
                    for (String link : Links.getOZONSearchLinks()){
                        goodOZONArrayList.addAll(ParseOZON.getWeb(link));
                    }

                    is_parsed = true;
                //TODO: сделай отдельный тред для авито
            }
        };

        secThread = new Thread(runnable1);
        secThread.start();

    }
}