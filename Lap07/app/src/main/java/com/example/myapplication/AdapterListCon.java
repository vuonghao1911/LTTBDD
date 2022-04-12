package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class AdapterListCon extends BaseAdapter {
    private Context context;
    private List<Contact> contacts;
    private  int IdLayout;

    public AdapterListCon() {
    }

    public AdapterListCon(Context context, List<Contact> contacts, int idLayout) {
        this.context = context;
        this.contacts = contacts;
        IdLayout = idLayout;
    }

    @Override
    public int getCount() {
        return contacts.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView  = LayoutInflater.from(parent.getContext()).inflate(IdLayout,parent,false);

        TextView tvList = convertView.findViewById(R.id.idTextCon);

        Contact contact =  contacts.get(position);
        if (contact!=null&& !contacts.isEmpty())
        {
            tvList.setText(contact.getName());
        }

        return convertView;
    }
}
