package com.example.vendor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdaptor extends BaseAdapter {
    private Context context;
    private ArrayList<Product> myList;
    private LayoutInflater inflater;

    public MyAdaptor(Context c ,ArrayList<Product> list){
        context = c;
        myList = list;
        inflater = LayoutInflater.from(c);
    }

    @Override
    public int getCount() {
        return myList.size();
    }

    @Override
    public Object getItem(int i) {
        return myList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view==null){
            view = inflater.inflate(R.layout.my_layout,viewGroup,false);
        }
        ImageView p_img = view.findViewById(R.id.p_img);
        TextView p_name = view.findViewById(R.id.p_name);
        TextView p_quantity = view.findViewById(R.id.p_quantity);
        TextView p_price = view.findViewById(R.id.p_price);
        p_img.setImageResource(R.drawable.ic_launcher_background);
        p_name.setText(myList.get(i).getName());
        p_quantity.setText(myList.get(i).getQuantity()+"");
        p_price.setText(myList.get(i).getPrice()+"");
        return view;
    }
}



