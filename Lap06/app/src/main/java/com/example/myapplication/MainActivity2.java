package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity implements  ShoesFragment.listviewlisen {
    ShoesFragment fragment1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

         fragment1 = new ShoesFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.idFrame,fragment1).commit();
    }


    @Override
    public void sendata(Shoes shoes) {
        Bundle bundle =  new Bundle();
        bundle.putInt("img",shoes.getImg());
        bundle.putString("title",shoes.getTitle());
        DetailsShoesFragment fragment = new DetailsShoesFragment();
        fragment.setArguments(bundle);

        getSupportFragmentManager().beginTransaction().remove(fragment1).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.idFrame,fragment).commit();

    }
}