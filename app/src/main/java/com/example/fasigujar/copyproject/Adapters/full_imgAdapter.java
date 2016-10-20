package com.example.fasigujar.copyproject.Adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.fasigujar.copyproject.Menus_Item;
import com.example.fasigujar.copyproject.Models.menu_Items;
import com.example.fasigujar.copyproject.Models.single_item;
import com.example.fasigujar.copyproject.R;

import java.util.List;

/**
 * Created by Mian Mohsin on 10/19/2016.
 */
public class full_imgAdapter extends BaseAdapter {
    private Activity activity;
    private List<single_item> menuitemss;
    private LayoutInflater inflaterr;
    Menus_Item item;
    public full_imgAdapter(Activity activity, List<single_item> menuitemss)
    {
        this.activity=activity;
        this.menuitemss=menuitemss;


    }

    @Override
    public int getCount() {
        return menuitemss.size();
    }

    @Override
    public Object getItem(int position) {
        return menuitemss.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(inflaterr==null)
            inflaterr= (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if(convertView==null)
            convertView = inflaterr.inflate(R.layout.cart_singlerow,null);
        TextView full = (TextView) convertView.findViewById(R.id.full);
        TextView fullPrice = (TextView) convertView.findViewById(R.id.fullPrice);
      //  TextView half = (TextView) convertView.findViewById(R.id.half);
       // TextView halfPrice = (TextView) convertView.findViewById(R.id.halfPrice);
       // TextView quarter = (TextView) convertView.findViewById(R.id.quarter);
       // TextView quarterPrice = (TextView) convertView.findViewById(R.id.quarterPrice);
        single_item MenuList = menuitemss.get(position);
      //  Image.setImageUrl(MenuList.getFilePath(),imageLoader);
        full.setText(MenuList.getName1());
      //  half.setText(MenuList.getName2());
      //  quarter.setText(MenuList.getName3());
       fullPrice.setText(MenuList.getUnitPrice());



        return convertView;
    }
}
