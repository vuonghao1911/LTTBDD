package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class AdapterDonut extends BaseAdapter {

    private Context context;
    private int idLayout;
    private List<Donut> donutList;

    public AdapterDonut(Context context, int idLayout, List<Donut> donutList) {
        this.context = context;
        this.idLayout = idLayout;
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
         final  Donut donut = donutList.get(i);
         if(donutList!=null && !donutList.isEmpty()){
             tvTitle.setText(donut.getTitle());
             tvSubTitle.setText(donut.getSubTitle());
             tvPrice.setText(donut.getPrice());
             img.setImageResource(donut.getImg());
         }

        return view;
    }
}
