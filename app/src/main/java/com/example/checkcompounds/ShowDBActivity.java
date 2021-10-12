package com.example.checkcompounds;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;

public class ShowDBActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private int selectedSpinnerID = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_dbactivity);

        Spinner spinner = (Spinner) findViewById(R.id.spinner_DB);
        // Настраиваем адаптер
        ArrayAdapter<?> adapterSpinner =
                ArrayAdapter.createFromResource(this, R.array.Tables,
                        android.R.layout.simple_spinner_item);
        adapterSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapterSpinner);
        spinner.setOnItemSelectedListener(this);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerViewDB);
        ShowDBAdapter adapter = new ShowDBAdapter(this, selectedSpinnerID);
        recyclerView.setAdapter(adapter);


    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        selectedSpinnerID = (int) l; //TODO: проверь, мб надо long!!!
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerViewDB);
        ShowGoodsAdapter adapter = new ShowGoodsAdapter(this, selectedSpinnerID);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}