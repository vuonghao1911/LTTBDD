package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ShoesFragment fragment = new ShoesFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.idFrame,fragment).commit();
    }
}