package com.example.fasigujar.copyproject;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.fasigujar.copyproject.Models.single_item;

import java.util.ArrayList;
import java.util.List;

public class Cart extends AppCompatActivity {
EditText quantity;
  public   String k,l,prce,concat,bc,gdb;
    Button Cart;
    String number,numbers,numberss;
    int n;
    String [] d;
    Intent i;
    public int Pricee,Pricee1,Pricee2,Quantityy,Quantityy2,Quantityy3,subtotalt,subtotalt1,subtotalt2,totall,total2,total3,total4;
    String s,ks;

    SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        Intent intent= getIntent();
        k= intent.getStringExtra("Id");
         l= intent.getStringExtra("name");
        prce=intent.getStringExtra("price");
        Pricee=Integer.parseInt(prce);

        prefs=getSharedPreferences("data", Context.MODE_PRIVATE);
        s=prefs.getString("stotal","N/A");


        Toast.makeText(this,"Price : "+Pricee,Toast.LENGTH_SHORT).show();


    //    Toast.makeText(this,k,Toast.LENGTH_SHORT).show();
   //     Toast.makeText(this,l,Toast.LENGTH_SHORT).show();


        quantity= (EditText) findViewById(R.id.quantity_amount);
        // number = quantity.getText().toString();
     //    n= Integer.parseInt(number);

        Cart= (Button) findViewById(R.id.cart);
        Cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number = quantity.getText().toString();
                if(number.isEmpty())
                {
                    quantity.setError("please enter quantity");
                }
                else {

                    if (s.equals("0")) {
                        s = "1";
                        SharedPreferences prefs = getSharedPreferences("data", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = prefs.edit();
                        editor.putString("stotal", s);
                        editor.commit();
                        //  number = quantity.getText().toString();
                        Pricee = Integer.parseInt(prce);
                        Quantityy = Integer.parseInt(number);
                        subtotalt = Pricee * Quantityy;
                        totall = subtotalt;
                        editor.putString("total", String.valueOf(totall));
                        editor.commit();
                        Toast.makeText(Cart.this, " Total " + totall, Toast.LENGTH_SHORT).show();
                    } else if (s.equals("1")) {
                        s = "2";
                        SharedPreferences prefs = getSharedPreferences("data", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = prefs.edit();
                        editor.putString("stotal", s);
                        editor.commit();
                        //  number = quantity.getText().toString();
                        String tota = prefs.getString("total", "N/A");
                        totall = Integer.parseInt(tota);
                        Pricee2 = Integer.parseInt(prce);
                        Quantityy2 = Integer.parseInt(number);
                        subtotalt1 = Pricee2 * Quantityy2;
                        total2 = totall + subtotalt1;
                        editor.putString("total", String.valueOf(total2));
                        editor.commit();
                        Toast.makeText(Cart.this, " Total " + total2, Toast.LENGTH_SHORT).show();
                    } else if (s.equals("2"))

                    {
                        s = "3";
                        SharedPreferences prefs = getSharedPreferences("data", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = prefs.edit();
                        editor.putString("stotal", s);
                        editor.commit();
                        //  number = quantity.getText().toString();
                        String tota = prefs.getString("total", "N/A");
                        total2 = Integer.parseInt(tota);
                        Pricee2 = Integer.parseInt(prce);
                        Quantityy3 = Integer.parseInt(number);
                        subtotalt2 = Pricee2 * Quantityy3;
                        total3 = total2 + subtotalt2;
                        String ab = Integer.toString(totall);
                        editor.putString("total", String.valueOf(total3));
                        editor.commit();
                        Toast.makeText(Cart.this, " Total " + total3, Toast.LENGTH_SHORT).show();


                    } else

                    {

                        Toast.makeText(Cart.this, "Cart Over flowed", Toast.LENGTH_SHORT).show();

                    }
                    //     Toast.makeText(Cart.this,"Subtotal"+subtotalt,Toast.LENGTH_SHORT).show();


                    prefs =

                            getSharedPreferences("data", Context.MODE_PRIVATE);

                    String chk = prefs.getString("b", "N/A");
                    SharedPreferences.Editor editor = prefs.edit();
                    if (chk.equals("0"))

                    {
                        chk = "1";
                        concat = l + " " + " " + "Price :" + prce + " " + " " + "Quantity:" + " " + number;
                        bc = "0";
                        gdb = "0";
                      //1  Toast.makeText(Cart.this, concat, Toast.LENGTH_SHORT).show();
                        editor.putString("con", concat);
                        editor.putString("b", chk);
                        editor.putString("bc", bc);
                        editor.putString("gdb", gdb);
                        editor.commit();
                    } else if (chk.equals("1"))

                    {
                        chk = "2";
                        bc = l + " " + " " + "Price :" + prce + " " + " " + "Quantity:" + " " + number;
                        gdb = "0";

                        String concat = prefs.getString("con", "N/A");
                        editor.putString("b", chk);
                        editor.putString("bc", bc);
                       //2 Toast.makeText(Cart.this, concat, Toast.LENGTH_SHORT).show();
                        editor.putString("gdb", gdb);
                        //  editor.putString("bc", bc);

                        editor.commit();
                    } else if (chk.equals("2"))

                    {
                        chk = "3";
                        gdb = l + " " + " " + "Price :" + prce + " " + " " + "Quantity:" + " " + number;
                        String bc = prefs.getString("bc", "N/A");
                        String concat = prefs.getString("con", "N/A");
                     //3   Toast.makeText(Cart.this, gdb, Toast.LENGTH_SHORT).show();
                      //4  Toast.makeText(Cart.this, bc, Toast.LENGTH_SHORT).show();
                      //5  Toast.makeText(Cart.this, concat, Toast.LENGTH_SHORT).show();
                        editor.putString("gdb", gdb);
                        editor.putString("b", chk);
                        editor.commit();
                    } else

                    {

                        editor.putString("chk", "N/A");
                        editor.commit();
                    }


                    // prefs = getSharedPreferences("data", Context.MODE_PRIVATE);

            /* String key=prefs.getString("key","N/A");
             String key2=prefs.getString("key2","N/A");
             String name=prefs.getString("name2","N/A");
             String key3=prefs.getString("key3","N/A");
             String name2=prefs.getString("name3","N/A");
             String key4=prefs.getString("key4","N/A");
             String name3=prefs.getString("name4","N/A");
             Toast.makeText(Cart.this,chk,Toast.LENGTH_SHORT).show();
             Toast.makeText(Cart.this,key2,Toast.LENGTH_SHORT).show();
             Toast.makeText(Cart.this,key3,Toast.LENGTH_SHORT).show();
             Toast.makeText(Cart.this,key4,Toast.LENGTH_SHORT).show();*/
                    Intent i = new Intent(Cart.this, cart_show.class);

                    startActivity(i);

                }
            }
        });
      //
       /* prefs = getSharedPreferences("data", Context.MODE_PRIVATE);

        String key=prefs.getString("key","N/A");
        String key2=prefs.getString("key2","N/A");
        Toast.makeText(Cart.this,key,Toast.LENGTH_SHORT).show();
        Toast.makeText(Cart.this,key2,Toast.LENGTH_SHORT).show();

       if(key.equals("N/A")|| key.equals("400"))
        {

            Intent i = new Intent(SplashActivity.this, MainActivity.class);
            startActivity(i);
            finish();
        }*/


    }
}
