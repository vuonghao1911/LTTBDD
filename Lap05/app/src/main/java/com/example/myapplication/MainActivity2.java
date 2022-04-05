package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {
    private TextView tvTitle;
    private TextView tvSubTitle;
    private TextView price;
    private TextView tvAmount;
    private ImageView imgV;
    private  ImageButton btnMinus;
    private ImageButton btnPlus;
    private  int gia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tvTitle = (TextView) findViewById(R.id.idTitle);
        tvSubTitle = (TextView) findViewById(R.id.idSubTitle);
        price = (TextView) findViewById(R.id.idPrice);
        imgV = (ImageView) findViewById(R.id.idImgDonut);
        tvAmount = (TextView) findViewById(R.id.idAmount);
        btnMinus = (ImageButton) findViewById(R.id.idbtnMinus);
        btnPlus = (ImageButton) findViewById(R.id.idbtnPlus);

        Bundle bundle = getIntent().getExtras();
        tvTitle.setText(bundle.getString("Title"));
        tvSubTitle.setText(bundle.getString("SubTitle"));
        price.setText("$ "+bundle.getInt("Price"));
        imgV.setImageResource(bundle.getInt("Img"));
        gia= bundle.getInt("Price");
        btnPlus.setOnClickListener(this);
        btnMinus.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view==btnPlus){
            int i = Integer.parseInt(tvAmount.getText().toString());
            tvAmount.setText(String.valueOf(i+1));
            price.setText("$ "+gia*(i+1));

        }
        if (view==btnMinus){
            int i = Integer.parseInt(tvAmount.getText().toString());
            if (i==0) {
                Toast.makeText(MainActivity2.this,"Không thể giảm được do số lượng đang là 0",Toast.LENGTH_LONG).show();
            } else
                tvAmount.setText(String.valueOf(i - 1));
            price.setText("$ "+gia*(i-1));
        }
    }
}