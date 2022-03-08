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
        setContentView(R.layout.custom_list_view);
        listView = (ListView) findViewById(R.id.idList2);
        listLanguage = new ArrayList<>();
        listLanguage.add(new ListItiem1(1, "Lập Trình Java","Shop Devan","Chat"));
        listLanguage.add(new ListItiem1(2, "Lập Trình Android","Shop LDT Food","Chon"));
        listLanguage.add(new ListItiem1(3, "Lập Trình JavaFX","Shop The Gioi Do Choi","Nhap"));


          ListAdapter1 adapter = new ListAdapter1(this, R.layout.list_view, listLanguage);
        listView.setAdapter(adapter);

    }
}