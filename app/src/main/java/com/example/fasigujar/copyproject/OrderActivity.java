package com.example.fasigujar.copyproject;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class OrderActivity extends AppCompatActivity {
TextView tv;
    SharedPreferences prefs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        tv= (TextView) findViewById(R.id.price);
        prefs = getSharedPreferences("data", Context.MODE_PRIVATE);

        String chk = prefs.getString("total", "N/A");
        tv.setText("Your Total Bill : "+chk);

    }
}
