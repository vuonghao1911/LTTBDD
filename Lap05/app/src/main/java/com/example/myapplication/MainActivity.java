package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener {
    private List<Donut> donutList;
    private ListView listView;
    Button btnDonut;
    Button btnPink;
    Button btnFloat;
    EditText edtSearch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.idList);

        donutList = new ArrayList<>();
        donutList.add(new Donut("Tasty Donut","Spicy tasty donut family","$10.00",R.drawable.donut_yellow_1));
        donutList.add(new Donut("Pink Donut","Spicy tasty donut family","$20.00",R.drawable.tasty_donut_1));
        donutList.add(new Donut("Floating Donut","Spicy tasty donut family","$30.00",R.drawable.green_donut_1));
        donutList.add(new Donut("Custard Donut","Spicy tasty donut family","$15.00",R.drawable.donut_red_1));

        AdapterDonut adapterDonut = new AdapterDonut(this,R.layout.custom_list_donut,donutList);
        AdapterDonut adapterDonutSearch = new AdapterDonut(this,R.layout.custom_list_donut);

         listView.setAdapter(adapterDonut);

         btnDonut = (Button) findViewById(R.id.btnDonut);
         btnFloat = (Button) findViewById(R.id.btnFloating);
         btnPink = (Button) findViewById(R.id.btnPinkDonut);
         edtSearch = (EditText) findViewById(R.id.edText) ;
         btnDonut.setOnClickListener(this);
         btnFloat.setOnClickListener(this);
         btnPink.setOnClickListener(this);

        edtSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                List<Donut> list = new ArrayList<>();
                for (Donut donut: donutList) {
                    if(donut.getTitle().toLowerCase().contains(edtSearch.getText().toString().toLowerCase())){
                        list.add(donut);
                    }
                }
              adapterDonutSearch.setDonutList(list);
                listView.setAdapter(adapterDonutSearch);
            }
        });


    }
    private  void changeColorButton(Button unFocus1 , Button unFocus2){
        unFocus1.setBackgroundColor(Color.rgb(244, 221, 221));
        unFocus1.setTextColor(Color.rgb(119, 108, 108));

        unFocus2.setBackgroundColor(Color.rgb(244, 221, 221));
        unFocus2.setTextColor(Color.rgb(119, 108, 108));
    }

    @Override
    public void onClick(View view) {
        if (view==btnFloat){
            btnFloat.setBackgroundColor(Color.rgb(241, 176, 0));
            changeColorButton(btnDonut,btnPink);
        }
        if (view==btnDonut){
            btnDonut.setBackgroundColor(Color.rgb(241, 176, 0));
            changeColorButton(btnFloat,btnPink);
        }
        if (view==btnPink){
            btnPink.setBackgroundColor(Color.rgb(241, 176, 0));
            changeColorButton(btnFloat,btnDonut);
        }

    }
}