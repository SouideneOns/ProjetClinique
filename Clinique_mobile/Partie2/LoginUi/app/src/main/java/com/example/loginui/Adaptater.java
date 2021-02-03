package com.example.loginui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Adaptater extends BaseAdapter {
    Context context;
    ArrayList<Model> androidData;
    LayoutInflater layoutInflater;
    Model androidModel;

    public Adaptater(Context context, ArrayList<Model> androidData) {
        this.context = context;
        this.androidData = androidData;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return androidData.size();
    }

    @Override
    public Object getItem(int i) {
        return androidData.get(i);
    }

    @Override
    public long getItemId(int i) {
        return androidData.get(i).getId();
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        View rowView = view;
        if (rowView==null) {
            rowView = layoutInflater.inflate(R.layout.row, null, true);
        }
        //link views
        ImageView image = rowView.findViewById(R.id.image);
        TextView name = rowView.findViewById(R.id.name);
        TextView specialty = rowView.findViewById(R.id.specialty);


        androidModel = androidData.get(position);

        image.setImageResource(androidModel.getImage());
        name.setText(androidModel.getName());
        specialty.setText("Maladie : " + androidModel.getMaladie());


        return rowView;
    }
}

