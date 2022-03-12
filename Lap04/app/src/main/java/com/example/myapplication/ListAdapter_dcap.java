package com.example.myapplication;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class ListAdapter_dcap extends BaseAdapter {
    private Context context;
    private  int idLayout;
    private List<ListItiem1> lists;
    private int positionSelect = -1;

    public ListAdapter_dcap(Context context, int idLayout, List<ListItiem1> lists) {
        this.context = context;
        this.idLayout = idLayout;
        this.lists = lists;

    }


    @Override
    public int getCount() {
        if (lists.size() !=0 && !lists.isEmpty()){
            return lists.size();
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
            view= LayoutInflater.from(viewGroup.getContext()).inflate(idLayout,viewGroup,false);
        }

        TextView tvTitle = (TextView) view.findViewById(R.id.idText);
        TextView tvTitle1 = (TextView) view.findViewById(R.id.idText1);
        ImageView imageView = (ImageView) view.findViewById(R.id.idImg);
        ImageView imageView1 = (ImageView) view.findViewById(R.id.idImg1);


        final ListItiem1 list= lists.get(i);



        if (lists != null && !lists.isEmpty()){
            int idLogo = list.getImg();
            switch (idLogo){
                case 1:
                    imageView.setImageResource(R.drawable.carbusbtops2_1);
                    tvTitle.setText(list.getTitle());
                    imageView1.setImageResource(R.drawable.daucam_1);
                    tvTitle1.setText(list.getSubTitle());
                    break;
                case 2:
                    imageView.setImageResource(R.drawable.dauchuyendoi_1);
                    tvTitle.setText(list.getTitle());
                    imageView1.setImageResource(R.drawable.dauchuyendoipsps2_1);
                    tvTitle1.setText(list.getSubTitle());
                    break;
                case 3:
                    imageView.setImageResource(R.drawable.daynguon_1);
                    tvTitle.setText(list.getTitle());
                    imageView1.setImageResource(R.drawable.giacchuyen_1);
                    tvTitle1.setText(list.getSubTitle());
                    break;

            }

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, list.getTitle(), Toast.LENGTH_LONG).show();
                    positionSelect = i;
                    notifyDataSetChanged();
                }
            });




        }
        return view;
    }
}
