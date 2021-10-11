package com.example.checkcompounds;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

public class ShowGoodsActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    //TODO: попробуй без этих ребят
    private static final String OZON = "OZON";
    private static final String AVITO ="Avito";

    ArrayList<GoodOZON> goodOZONArrayList;
    ArrayList<GoodAVITO> goodAVITOArrayList;
    private int selectedSpinnerID = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_goods);
        Intent intent = getIntent();

        /*
        goodOZONArrayList = MainActivity.goodOZONArrayList;
        goodAVITOArrayList = MainActivity.goodAVITOArrayList;
         */

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        // Настраиваем адаптер
        ArrayAdapter<?> adapterSpinner =
                ArrayAdapter.createFromResource(this, R.array.Shops,
                        android.R.layout.simple_spinner_item);
        adapterSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapterSpinner);
        spinner.setOnItemSelectedListener(this);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerViewGoods);
        ShowGoodsAdapter adapter = new ShowGoodsAdapter(this, selectedSpinnerID);
        recyclerView.setAdapter(adapter);


    }

    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
        selectedSpinnerID = (int) id; //TODO: проверь, мб надо long!!!
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerViewGoods);
        ShowGoodsAdapter adapter = new ShowGoodsAdapter(this, selectedSpinnerID);
        recyclerView.setAdapter(adapter);
        // An item was selected. You can retrieve the selected item using
        // parent.getItemAtPosition(pos)
    }

    public void onNothingSelected(AdapterView<?> parent) {
       // selectedSpinnerID = String.valueOf(parent.getItemAtPosition(0));
    }


}