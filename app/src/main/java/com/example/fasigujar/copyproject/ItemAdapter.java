package com.example.fasigujar.copyproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by Fasi Gujar on 18-Jun-16.
 */

public class ItemAdapter extends ArrayAdapter {
    List list=new ArrayList();
    public ItemAdapter(Context context, int resource) {
        super(context, resource);
    }
   /* static class DataHandel
    {
        ImageView image;
        TextView title;
        TextView pric;
    }

    @Override
    public void add(Object object) {
        super.add(object);
        list.add(object);
    }

    @Override
    public int getCount() {
        return this.list.size();
    }

    @Override
    public Object getItem(int position) {
        return this.list.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
      View row;
        row=convertView;
        DataHandel handel;
        if (convertView == null)
        {
            LayoutInflater inflater =(LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row =inflater.inflate(R.layout.row_layout,parent, false);
            handel=new DataHandel();
            handel.image= (ImageView)row.findViewById(R.id.Imagee);
            handel.title=(TextView) row.findViewById(R.id.Food_title);
            handel.pric=(TextView)row.findViewById(R.id.Price);
            row.setTag(handel);
        }
        else
        {
            handel=(DataHandel)row.getTag();
        }
        DataProvider dataProvider;
        dataProvider=(DataProvider) this.getItem(position);
        handel.image.setImageResource(dataProvider.getImg_res());
        handel.title.setText(dataProvider.getItem_name());
        handel.pric.setText(dataProvider.getPric_e());

        return row;
    }*/
}
