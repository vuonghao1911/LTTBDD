package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ShoesAdapter  extends BaseAdapter {

    private Context context;
    private List<Shoes> shoesList;
    private  int idLayout;

    public ShoesAdapter(Context context, List<Shoes> shoesList, int idLayout) {
        this.context = context;
        this.shoesList = shoesList;
        this.idLayout = idLayout;
    }

    @Override
    public int getCount() {
        return shoesList.size();
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
        TextView tvTitle = (TextView) view.findViewById(R.id.idTitle);
        ImageView img = view.findViewById(R.id.idImg);


        final  Shoes shoes = shoesList.get(i);
        if(shoesList!=null && !shoesList.isEmpty()){
            tvTitle.setText(shoes.getTitle());

            img.setImageResource(shoes.getImg());
        }


        return view;
    }
}
