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

import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.List;

public class ListAdapter1 extends BaseAdapter {
    private Context context;
    private  int idLayout;
    private List<ListItiem1> lists;
    private int positionSelect = -1;

    public ListAdapter1(Context context, int idLayout, List<ListItiem1> lists) {
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

        TextView tvTitle = (TextView) view.findViewById(R.id.tvLanguageName);
        TextView tvSubTitle = (TextView) view.findViewById(R.id.subTitle);
        ImageView imageView = (ImageView) view.findViewById(R.id.logo);
        Button button = (Button) view.findViewById(R.id.button1);
        final LinearLayout constraintLayout= (LinearLayout) view.findViewById(R.id.idLinearLayout);

        final ListItiem1 list= lists.get(i);

        if (lists != null && !lists.isEmpty()){
            tvTitle.setText(list.getTitle());
            button.setText(list.getButton());
            tvSubTitle.setText(list.getSubTitle());
            int idLogo = list.getImg();
            switch (idLogo){
                case 1:
                    imageView.setImageResource(R.drawable.ca_nau_lau);
                    break;
                case 2:
                    imageView.setImageResource(R.drawable.ga_bo_toi);
                    break;
                case 3:
                    imageView.setImageResource(R.drawable.xa_can_cau);
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
