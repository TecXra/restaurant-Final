package com.example.fasigujar.copyproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by Fasi Gujar on 03-Aug-16.
 */
public class ListAdapter extends ArrayAdapter<String> {
    int vg;
    String[] items_list;
    Context context;

    public ListAdapter(Context context, int vg, int id, String[] items_list) {
        super(context, vg, id, items_list);
        this.context = context;
        this.items_list = items_list;
        this.vg = vg;
    }

    static class ViewHolder {
        public TextView txtQun;
        public TextView txtPrice;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = convertView;
        if (rowView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowView = inflater.inflate(vg, parent, false);
            ViewHolder holder = new ViewHolder();
            holder.txtQun = (TextView) rowView.findViewById(R.id.txtqun);
            holder.txtPrice = (TextView) rowView.findViewById(R.id.txtprice);
            rowView.setTag(holder);
        }
        String[] items = items_list[position].split("__");
        ViewHolder holder = (ViewHolder) rowView.getTag();
        holder.txtQun.setText(items[0]);
        holder.txtPrice.setText(items[1]);
        return rowView;
    }
}