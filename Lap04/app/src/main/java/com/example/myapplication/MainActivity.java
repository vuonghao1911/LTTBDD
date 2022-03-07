package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.ListMenuItemView;
import com.example.myapplication.*;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<ListItiem1>  listLanguage;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.idList1);
        listLanguage = new ArrayList<>();
        listLanguage.add(new ListItiem1(1, "Lập Trình Java","Chat"));
        listLanguage.add(new ListItiem1(2, "Lập Trình Android","Chat"));
        listLanguage.add(new ListItiem1(3, "Lập Trình JavaFX","Chat"));


          ListAdapter1 adapter = new ListAdapter1(this, R.layout.activity_main2, listLanguage);
        listView.setAdapter(adapter);

    }
}