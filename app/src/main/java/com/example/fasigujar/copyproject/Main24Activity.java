package com.example.fasigujar.copyproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

public class Main24Activity extends AppCompatActivity {
    int pos=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       /* ListView listView=(ListView)findViewById(R.id.listv);
        ViewGroup headerView =(ViewGroup)getLayoutInflater().inflate(R.layout.header,listView,false);
        listView.addHeaderView(headerView);
        String[] items =getResources().getStringArray(R.array.list_items);
        ListAdapter adapter= new com.example.fasigujar.copyproject.ListAdapter(this,R.layout.rowlayout,R.id.txtqun,items);
        listView.setAdapter(adapter);
   */ }
}


