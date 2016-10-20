package com.example.fasigujar.copyproject;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.fasigujar.copyproject.Adapters.menu_Items_Adapter;
import com.example.fasigujar.copyproject.Models.menu_Items;
import com.example.fasigujar.copyproject.RequestExecuter.Url;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Mian Mohsin on 10/17/2016.
 */
public class Menus_Item extends AppCompatActivity {

    private ProgressDialog pDialog;
    private List<menu_Items> menuList = new ArrayList<>();
    private ListView listVieww;
    private menu_Items_Adapter adapter;
    public int id,CatId;
    private  String Id,s;
    private int jsonlength;
    private String jArraySize;
    SharedPreferences prefs;



    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_items);

        Intent intent= getIntent();
       Id=intent.getStringExtra("Id");
        //Id="1";



        listVieww = (ListView) findViewById(R.id.menuu_Items);
        adapter = new menu_Items_Adapter(Menus_Item.this, menuList);
        listVieww.setAdapter(adapter);
        listVieww.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                CatId=menuList.get(position).getId();

                // Toast.makeText(Menus.this,"You select " +CatId,Toast.LENGTH_LONG).show();
                Intent intent= new Intent(Menus_Item.this,menu_add_cart.class);
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
    HashMap<String, String> params = new HashMap<String, String>();
        params.put("Id", Id);

        JsonArrayRequest menuReq = new JsonArrayRequest(Request.Method.POST,Url.baseeUrl,new JSONObject(params),
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        // Log.d(TAG, response.toString());
                        hidePDialog();

// Parsing json
                        for (int i = 0; i < response.length(); i++) {
                            try {

                                JSONObject obj = response.getJSONObject(i);

                                menu_Items menuu = new menu_Items();
                               menuu.setFilePath(Url.baseUrll + obj.getString("FilePath"));

                                menuu.setName(obj.getString("Name"));
                                menuu.setId(obj.getInt("Id"));
                                menuu.setMenuCatId(obj.getInt("MenuCatId"));

                               JSONArray MenuCategory = obj.getJSONArray("ItemQuantities");
                                //    ArrayList<String> genre = new ArrayList<String>();
                                for (int j = 0; j < MenuCategory.length(); j++) {
                                    //    genre.add((String) genreArry.get(j));
                                    menuu.setName1(MenuCategory.getJSONObject(j).getString("Name"));
                                    menuu.setName2(MenuCategory.getJSONObject(j).getString("UnitPrice"));
                                    String s= MenuCategory.getJSONObject(j).getString("Name");
                                 //   Toast.makeText(Menus_Item.this,"menu naime "+ s,Toast.LENGTH_SHORT).show();
                                    String k= MenuCategory.getJSONObject(j).getString("UnitPrice");
                                //    Toast.makeText(Menus_Item.this,"Une "+k,Toast.LENGTH_SHORT).show();

                                 //   menuu.setFilePath(Url.baseUrl + MenuCategory.getString("FilePath"));
                                }

                                //  menuu.setAvatarId(obj.getInt("AvatarId"));
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




/*
        Response.Listener<String> listener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                hidePDialog();
                //     Toast.makeText(Login_Activity.this, "come in response listerner " + " ", Toast.LENGTH_LONG).show();

                try {
                    JSONArray jsonArray = new JSONArray(response);
                    jsonlength = jsonArray.length();
                    jArraySize = Integer.toString(jsonlength);
                    if (jsonlength == 0)
                    {
                        //textViewSize();
                        Toast.makeText(Menus_Item.this, " Sorry no match found... :(", Toast.LENGTH_SHORT).show();
                    }


                    for (int i = 0; i <= jsonArray.length(); i++)
                    {

                        JSONObject obj = jsonArray.getJSONObject(i);
                        menu_Items menuu = new menu_Items();

                        menuu.setName(obj.getString("Name"));
                        menuu.setId(obj.getInt("Id"));
                        // menuu.setAvatarId(obj.getInt("AvatarId"));

                        JSONObject MenuCategory = obj.getJSONObject("MenuCategory");
                        //    ArrayList<String> genre = new ArrayList<String>();
                        for (int j = 0; j < MenuCategory.length(); j++) {
                            //    genre.add((String) genreArry.get(j));
                            menuu.setFilePath(Url.baseUrl + MenuCategory.getString("FilePath"));
                        }

                        menuList.add(menuu);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                adapter.notifyDataSetChanged();
            }

        };


            Response.ErrorListener errorListener = new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    hidePDialog();
                    Toast.makeText(Menus_Item.this, "Sorry Your request cannot be made due to insufficient network", Toast.LENGTH_LONG).show();
              /*  refresh.setVisibility(View.VISIBLE);
                refresh.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        loginReguest();
                        refresh.setVisibility(View.INVISIBLE);
                    }
                });*/
        /*        }
            };

            menu_items_post loginRequest = new menu_items_post(Id,listener,errorListener);
            RequestQueue queue = Volley.newRequestQueue(Menus_Item.this);
              queue.add(loginRequest);
// Adding request to request queue
            AppController.getInstance().addToRequestQueue(loginRequest);

  */      }

    private void hidePDialog() {
        if (pDialog != null) {
            pDialog.dismiss();
            pDialog = null;
        }
    }
}
