package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Paint;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        TextView txt = (TextView) findViewById(R.id.textView4);
        txt.setPaintFlags( Paint.UNDERLINE_TEXT_FLAG);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
}