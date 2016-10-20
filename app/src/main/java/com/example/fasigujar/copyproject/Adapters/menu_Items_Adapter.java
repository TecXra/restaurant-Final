package com.example.fasigujar.copyproject.Adapters;

import android.app.Activity;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.example.fasigujar.copyproject.AppController;
import com.example.fasigujar.copyproject.Models.menu_Items;
import com.example.fasigujar.copyproject.R;

import java.util.List;

/**
 * Created by Mian Mohsin on 10/17/2016.
 */
public class menu_Items_Adapter extends BaseAdapter {
    private Activity activity;
    private List<menu_Items> menuitemss;
    private LayoutInflater inflaterr;
    ImageLoader imageLoader = AppController.getInstance().getImageLoader();
    public menu_Items_Adapter(Activity activity, List<menu_Items> menuitemss)
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
            convertView= inflaterr.inflate(R.layout.menu_items_singlerow,null);
        if(imageLoader==null)
            imageLoader=AppController.getInstance().getImageLoader();
        NetworkImageView Image = (NetworkImageView) convertView.findViewById(R.id.menu_item_Image);
        TextView name = (TextView) convertView.findViewById(R.id.menu_title);
        menu_Items MenuList = menuitemss.get(position);
        Image.setImageUrl(MenuList.getFilePath(),imageLoader);
        name.setText(MenuList.getName());
        name.setGravity(Gravity.CENTER);


        return convertView;
    }
}
