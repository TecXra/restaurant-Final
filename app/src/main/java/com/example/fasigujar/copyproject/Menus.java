package com.example.fasigujar.copyproject;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.fasigujar.copyproject.Adapters.menuAdapter;
import com.example.fasigujar.copyproject.Models.menu_resturant;
import com.example.fasigujar.copyproject.RequestExecuter.Url;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mian Mohsin on 10/9/2016.
 */
public class Menus extends AppCompatActivity {

    private ProgressDialog pDialog;
    private List<menu_resturant> menuList = new ArrayList<>();
    private ListView listView;
    private menuAdapter adapter;
    private  int CatId;
    public String s;
    SharedPreferences prefs;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
        listView = (ListView) findViewById(R.id.listView);
        adapter = new menuAdapter(this, menuList);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                CatId=menuList.get(position).getId();

               // Toast.makeText(Menus.this,"You select " +CatId,Toast.LENGTH_LONG).show();
                Intent intent= new Intent(Menus.this,Menus_Item.class);
                String idd= Integer.toString(CatId);
               // Toast.makeText(Menus.this,idd+"selcted",Toast.LENGTH_SHORT).show();
                intent.putExtra("Id",idd);
                startActivity(intent);
            }
        });


        pDialog = new ProgressDialog(this);
Request();
// Showing progress dialog before making http request

        pDialog.setMessage("Loading…");
        pDialog.show();

    }

    public void Request()
    {

        // Creating volley request obj
        JsonArrayRequest menuReq = new JsonArrayRequest(Request.Method.GET,Url.baseUrl + Url.menuCategory,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        // Log.d(TAG, response.toString());
                        hidePDialog();

// Parsing json
                        for (int i = 0; i < response.length(); i++) {
                            try {

                                JSONObject obj = response.getJSONObject(i);

                                menu_resturant menuu = new menu_resturant();
                                menuu.setFilePath(Url.baseUrl + obj.getString("FilePath"));
                                menuu.setName(obj.getString("Name"));
                                menuu.setId(obj.getInt("Id"));
                                menuu.setAvatarId(obj.getInt("AvatarId"));
                                // worldsBillionaires.setSource(obj.getString("source"));


// adding Billionaire to worldsBillionaires array
                                menuList.add(menuu);

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }

// notifying list adapter about data changes
// so that it shows updated data in ListView
                        adapter.notifyDataSetChanged();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
               // Log.d("Error: ", "Sorry");
             //   Toast.makeText(Menus.this, "error occur network", Toast.LENGTH_LONG).show();
                hidePDialog();
            }
        });

// Adding request to request queue
        AppController.getInstance().addToRequestQueue(menuReq);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        hidePDialog();
    }

    private void hidePDialog() {
        if (pDialog != null) {
            pDialog.dismiss();
            pDialog = null;
        }
    }


    }
