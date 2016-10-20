package com.example.fasigujar.copyproject;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.fasigujar.copyproject.RequestExecuter.Url;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URL;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    //   private static int splashTime=3000;
    private ProgressDialog pDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Request();

    }

    public void Request() {

        // Creating volley request obj
        JsonArrayRequest menuReq = new JsonArrayRequest(Request.Method.GET, Url.baseUrl + Url.table,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {


                        for (int j = 0; j <= response.length(); j++) {
                            try {

                                JSONObject obj = response.getJSONObject(j);
                                int Id = obj.getInt("Id");
                                String name = obj.getString("Name");
                               // Toast.makeText(MainActivity.this,"table no "+Id,Toast.LENGTH_SHORT).show();
                                Intent i=new Intent(MainActivity.this,Menus.class);
                                startActivity(i);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
                Request();

            }
        });
        AppController.getInstance().addToRequestQueue(menuReq);

        Random r = new Random();
        int i1 = r.nextInt(2-1) + 1;
       // Toast.makeText(this,"ramdom table="+""+i1,Toast.LENGTH_SHORT).show();

        SharedPreferences prefs = getSharedPreferences("data", Context.MODE_PRIVATE);
        String key=Integer.toString(i1);
        SharedPreferences.Editor editor = prefs.edit();
        String b="0";
        String s="0";
        editor.putString("b", b);
        editor.putString("stotal", s);
        editor.putString("key", key);
        editor.commit();





        if(key.equals("N/A"))
        {

            Toast.makeText(this,"no table selected",Toast.LENGTH_SHORT).show();
        }
        else
            Toast.makeText(this,"table"+""+i1+""+"selected",Toast.LENGTH_SHORT).show();
    }

}


