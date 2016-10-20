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
import com.example.fasigujar.copyproject.Menus;
import com.example.fasigujar.copyproject.Models.menu_resturant;
import com.example.fasigujar.copyproject.R;

import java.util.List;

/**
 * Created by Mian Mohsin on 10/9/2016.
 */
public class menuAdapter extends BaseAdapter {

    private Activity activity;
    private List<menu_resturant> menuItems;
    private LayoutInflater inflater;
    ImageLoader imageLoader = AppController.getInstance().getImageLoader();

    public menuAdapter(Activity activity, List<menu_resturant> menuItems)
    {
        this.activity=activity;
        this.menuItems=menuItems;

    }

    @Override
    public int getCount() {
        return menuItems.size();
    }

    @Override
    public Object getItem(int position) {
        return menuItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(inflater==null)
        inflater= (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if(convertView==null)
            convertView= inflater.inflate(R.layout.menu_singlerow,null);
        if(imageLoader==null)
            imageLoader=AppController.getInstance().getImageLoader();
        NetworkImageView Image = (NetworkImageView) convertView.findViewById(R.id.menuImage);
        TextView name = (TextView) convertView.findViewById(R.id.menuText);
        menu_resturant MenuList = menuItems.get(position);
        Image.setImageUrl(MenuList.getFilePath(),imageLoader);
        name.setText(MenuList.getName());
        name.setGravity(Gravity.CENTER);


        return convertView;
    }
}
