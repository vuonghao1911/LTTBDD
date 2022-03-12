package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.ListMenuItemView;
import com.example.myapplication.*;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainTest extends AppCompatActivity {
    private List<ListItiem1>  listLanguage;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.idList1);
        listLanguage = new ArrayList<>();
        listLanguage.add(new ListItiem1(1, "Ca Nấu Lẩu","Shop Devan","Chat"));
        listLanguage.add(new ListItiem1(2, "1KG Khô Gà Bơ Tỏi","Shop LDT Food","Chon"));
        listLanguage.add(new ListItiem1(3, "Xe Cần Cẩu Đa Năng","Shop The Gioi Do Choi","Nhap"));
        //  listLanguage.add(new ListItiem1(4, "Đồ Chơi Dạng Mô Hình","Shop The Gioi Do Choi","Nhap"));
        //listLanguage.add(new ListItiem1(5, "Lãnh Đạo Giản Đơn","Shop The Gioi Do Choi","Nhap"));
        //listLanguage.add(new ListItiem1(6, "Hiểu Lòng Con Trẻ","Shop The Gioi Do Choi","Nhap"));
        // listLanguage.add(new ListItiem1(2, "Đắt Nhân Tâm","Shop The Gioi Do Choi","Nhap"));


        ListAdapter_dcap adapter = new ListAdapter_dcap(this, R.layout.list_custom_dcap, listLanguage);
        listView.setAdapter(adapter);

    }
}