package com.example.listapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class itemAdapter extends BaseAdapter {
    String []items;
    String []price;
    String []description;
    LayoutInflater mInflater;
    public itemAdapter(Context c, String[]a, String[]b, String []d){
        this.items=a;
        this.price=b;
        this.description=d;
        mInflater=(LayoutInflater)c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return items.length;
    }

    @Override
    public Object getItem(int position) {

        return items[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v= mInflater.inflate(R.layout.my_listview_detail,null);
        TextView nameTextView=(TextView)v.findViewById(R.id.nameTextview);
        TextView descriptionTextView=(TextView)v.findViewById(R.id.descriptionTextView);
        TextView priceTextView = (TextView)v.findViewById(R.id.priceTextView);

        String name=items[position];
        String describ=description[position];
        String prices=price[position];

        nameTextView.setText(name);
        descriptionTextView.setText(describ);
        priceTextView.setText(prices);


        return v;
    }
}