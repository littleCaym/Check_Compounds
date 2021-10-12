package com.example.checkcompounds;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static Thread secThread;
    public static ArrayList<GoodOZON> goodOZONArrayList;
    public static ArrayList<GoodAVITO> goodAVITOArrayList;

    private boolean is_parsed = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //todo Делаем меню просмотреть БД и запустить парсер
        //todo Перенести функционал в Listener кнопки Запустить и распараллелить потоки;

        Button btn_showDB = (Button) findViewById(R.id.button_showDB);
        btn_showDB.setOnClickListener(this);

        Button btn_startParse = (Button) findViewById(R.id.button_StartParse);
        btn_startParse.setOnClickListener(this);

        //запускаем активити со списком продуктов

        /*
        init();
        while (!is_parsed){
            Intent intent = new Intent(this, ShowGoodsActivity.class);
            //  intent.putExtra(GOOD_OZON_ARRAYLIST, goodOZONArrayList);
            startActivity(intent);
        }

        */

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



    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button_showDB:
                Toast.makeText(this,"Еще не готово :(", Toast.LENGTH_LONG).show();
                break;
            case R.id.button_StartParse:
                init();
                //Передаем в загрузчик. пока так.

                Intent intent = new Intent(this, SplashActivity.class);
                   //  intent.putExtra(GOOD_OZON_ARRAYLIST, goodOZONArrayList);
                   startActivity(intent);



        }
    }
}