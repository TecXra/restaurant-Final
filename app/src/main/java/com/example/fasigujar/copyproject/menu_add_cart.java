package com.example.fasigujar.copyproject;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.LruCache;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.NetworkImageView;
import com.example.fasigujar.copyproject.Adapters.full_imgAdapter;
import com.example.fasigujar.copyproject.Adapters.menu_Items_Adapter;
import com.example.fasigujar.copyproject.Models.menu_Items;
import com.example.fasigujar.copyproject.Models.menu_resturant;
import com.example.fasigujar.copyproject.Models.single_item;
import com.example.fasigujar.copyproject.RequestExecuter.CustomVolleyRequest;
import com.example.fasigujar.copyproject.RequestExecuter.Url;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Mian Mohsin on 10/18/2016.
 */
public class menu_add_cart extends Activity{
    ListView lview;
    private List<single_item> lv= new ArrayList<>();
    Spinner sp;
 //   NetworkImageView niw;
    EditText order;
    ProgressDialog pDialog;
    String urlll;
    String Id;
    String CatId,Item_name,price;
    private full_imgAdapter adapterr;
    String s;
    SharedPreferences prefs;

   // ImageLoader imageLoader = AppController.getInstance().getImageLoader();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_item_fullimage);
        Intent intent= getIntent();
        Id=intent.getStringExtra("Id");





       // sp= (Spinner) findViewById(R.id.spinner);
     //   niw= (NetworkImageView) findViewById(R.id.menu_item_Image);
      //  order= (EditText) findViewById(R.id.editText);
        lview= (ListView) findViewById(R.id.listView2);
        adapterr = new full_imgAdapter(menu_add_cart.this,lv);
        lview.setAdapter(adapterr);

        lview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                CatId=lv.get(position).getQuantityId();
                Item_name=lv.get(position).getName1();
                price=lv.get(position).getUnitPrice();

                // Toast.makeText(Menus.this,"You select " +CatId,Toast.LENGTH_LONG).show();
                Intent intent= new Intent(menu_add_cart.this,Cart.class);
             //   String idd= CatId;
                // Toast.makeText(Menus.this,idd+"selcted",Toast.LENGTH_SHORT).show();
                intent.putExtra("Id",CatId);
                intent.putExtra("name",Item_name);
                intent.putExtra("price",price);
                startActivity(intent);
            }
        });


        pDialog = new ProgressDialog(this);
        Request();

// Showing progress dialog before making http request

        pDialog.setMessage("Loading…");
        pDialog.show();
    }
  /* public void data() {
         String url=urlll;
        imageLoader = CustomVolleyRequest.getInstance(this.getApplicationContext())
                .getImageLoader();
        imageLoader.get(url, ImageLoader.getImageListener(niw,
                R.drawable.beefk, android.R.drawable
                        .ic_dialog_alert));
        niw.setImageUrl(url, imageLoader);
    }
*/

    public void Request()
    {
        HashMap<String, String> params = new HashMap<String, String>();
        params.put("Id",Id);
     //   data();

        JsonArrayRequest menuReq = new JsonArrayRequest(Request.Method.POST, Url.quantity,new JSONObject(params),
                new Response.Listener<JSONArray>()
                {
                    @Override
                    public void onResponse(JSONArray response) {
                        // Log.d(TAG, response.toString());
                        hidePDialog();

// Parsing json
                        for (int i = 0; i < response.length(); i++) {
                            try {

                                JSONObject obj = response.getJSONObject(i);

                                String av = obj.getString("Id");
                            //    Toast.makeText(menu_add_cart.this, "is" + av, Toast.LENGTH_SHORT).show();

                                String a = obj.getString("Name");
                         //       Toast.makeText(menu_add_cart.this, "n" + a, Toast.LENGTH_SHORT).show();

                                int b = obj.getInt("UnitPrice");
                                //   menuu.setUnitPrice(obj.getInt("UnitPrice"));
                       //         Toast.makeText(menu_add_cart.this, "u" + b, Toast.LENGTH_SHORT).show();
                               // int c =obj.getInt("ItemQuantity");
                                single_item menuuss = new single_item();
                                menuuss.setName1(obj.getString("Name"));
                              //  menuuss.setName1(obj.getString("Name"));
                                menuuss.setUnitPrice(obj.getString("UnitPrice"));
                                menuuss.setQuantityId(obj.getString("Id"));

                                //    menuu.setFilePath(Url.baseUrl + obj.getString("FilePath"));
                                //     urlll=Url.baseUrl + obj.getString("FilePath");

                                lv.add(menuuss);


// adding Billionaire to worldsBillionaires array


                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }
                        adapterr.notifyDataSetChanged();
                    }
// notifying list adapter about data changes
// so that it shows updated data in ListView\

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

    private void hidePDialog() {
        if (pDialog != null) {
            pDialog.dismiss();
            pDialog = null;
        }
    }
}
