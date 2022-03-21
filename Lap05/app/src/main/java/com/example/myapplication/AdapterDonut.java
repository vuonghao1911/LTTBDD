package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class AdapterDonut extends BaseAdapter {

    private MainActivity context;
    private int idLayout;
    private List<Donut> donutList;

    public AdapterDonut(MainActivity context, int idLayout, List<Donut> donutList) {
        this.context = context;
        this.idLayout = idLayout;
        this.donutList = donutList;
    }

    public AdapterDonut(MainActivity context, int idLayout) {
        this.context = context;
        this.idLayout = idLayout;
    }

    public MainActivity getContext() {
        return context;
    }

    public void setContext(MainActivity context) {
        this.context = context;
    }

    public int getIdLayout() {
        return idLayout;
    }

    public void setIdLayout(int idLayout) {
        this.idLayout = idLayout;
    }

    public List<Donut> getDonutList() {
        return donutList;
    }

    public void setDonutList(List<Donut> donutList) {
        this.donutList = donutList;
    }

    @Override
    public int getCount() {
        if(donutList.size() !=0 && !donutList.isEmpty()){
            return  donutList.size();
        }
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if (view==null){
                view = LayoutInflater.from(viewGroup.getContext()).inflate(idLayout,viewGroup,false);
        }
        TextView tvTitle = (TextView) view.findViewById(R.id.tvTitle);
        TextView tvSubTitle = (TextView) view.findViewById(R.id.tvSubTitle);
        ImageView img = view.findViewById(R.id.imgDonut);
        TextView tvPrice = (TextView) view.findViewById(R.id.tvGia);
        ImageButton ibtPlus = (ImageButton) view.findViewById(R.id.btnPlus);
         final  Donut donut = donutList.get(i);
         if(donutList!=null && !donutList.isEmpty()){
             tvTitle.setText(donut.getTitle());
             tvSubTitle.setText(donut.getSubTitle());
             tvPrice.setText(donut.getPrice());
             img.setImageResource(donut.getImg());
         }

         ibtPlus.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 context.addDonut(i);
             }
         });
        return view;
    }
}
