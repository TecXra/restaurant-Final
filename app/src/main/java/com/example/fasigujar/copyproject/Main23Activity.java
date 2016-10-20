package com.example.fasigujar.copyproject;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class Main23Activity extends AppCompatActivity {
    ListView listView;

    int[] item_pic={R.drawable.chknbb,R.drawable.mtnb,R.drawable.ckk,
            R.drawable.mtnk,R.drawable.tika,
            R.drawable.chkn_k,R.drawable.beefk,};
    String[] items_name;
    String[] price;
    ItemAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
     /*   listView=(ListView)findViewById(R.id.list_view);
        items_name = getResources().getStringArray(R.array.items_name);
        price = getResources().getStringArray(R.array.price);
        int i=0;
        adapter = new ItemAdapter(getApplicationContext(),R.layout.row_layout);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int pos, long id) {
                Intent  i =new Intent(getApplicationContext(),Main24Activity.class);
                i.putExtra("Position",pos);
                startActivity(i);

            }
        });
        for (String title: items_name)
        {
            DataProvider dataProvider=new DataProvider(item_pic[i],items_name[i],price[i]);
            adapter.add(dataProvider);
            i++;

        }
        */
    }

}
