package com.example.fasigujar.copyproject;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class EditCartActivity extends AppCompatActivity {

    TextView t1;
    String s;
    public String ab,concat,bc,gdb;
    Button b1;
    SharedPreferences prefs;
    String chk[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_cart);


         prefs = getSharedPreferences("data", Context.MODE_PRIVATE);
        concat=prefs.getString("con","N/A");
        bc=prefs.getString("bc","N/A");
        gdb=prefs.getString("gdb","N/A");
        t1= (TextView) findViewById(R.id.textView3);
        b1= (Button) findViewById(R.id.del);

        Intent intent=getIntent();
       s= intent.getStringExtra("s");
        ab=intent.getStringExtra("ab");


        t1.setText(s);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!(concat.isEmpty()) && bc.equals("0") && gdb.equals("0")&&ab.equals("0"))//aaaaa
                {
                    chk= new String[]{};
                    t1.setText(null);
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putString("con", "0");
                    editor.commit();
                    Intent inten = new Intent(EditCartActivity.this,menu_add_cart.class);
                    startActivity(inten);
                }
                else if(concat.equals("0") && !(bc.isEmpty()) && gdb.equals("0")&&ab.equals("0"))
                {
                    chk= new String[]{bc};
                    Intent inten = new Intent(EditCartActivity.this,Menus.class);
                    startActivity(inten);

                }
                else if(!(concat.isEmpty()) && !(bc.isEmpty()) && gdb.equals("0")&&ab.equals("0"))
                {
                    chk= new String[]{bc};
                    t1.setText(null);
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putString("con", "0");
                    editor.commit();
                    Intent inten = new Intent(EditCartActivity.this,Menus.class);
                    startActivity(inten);
                }
                else if(concat.equals("0") && bc.equals("0") && !(gdb.isEmpty()&&ab.equals("0")))
                {
                    chk= new String[]{gdb};
                    Intent inten = new Intent(EditCartActivity.this,Menus.class);
                    startActivity(inten);
                }
                else if(concat.equals("0")&& !(bc.isEmpty()) && !(gdb.isEmpty())&&ab.equals("0"))
                {
                    chk= new String[]{bc,gdb};
                    Intent inten = new Intent(EditCartActivity.this,Menus.class);
                    startActivity(inten);
                }
                else if(!(concat.isEmpty()) && bc.equals("0") && !(gdb.isEmpty())&&ab.equals("0"))
                {
                    chk= new String[]{gdb};
                    t1.setText(null);
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putString("con", "0");
                    editor.commit();
                    Intent inten = new Intent(EditCartActivity.this,Menus.class);
                    startActivity(inten);
                }
                else if(!(concat.isEmpty()) && !(bc.isEmpty()) && !(gdb.isEmpty())&&ab.equals("0"))
                {
                    chk= new String[]{bc,gdb};
                    t1.setText(null);
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putString("con", "0");
                    editor.commit();
                    Intent inten = new Intent(EditCartActivity.this,Menus.class);
                    startActivity(inten);
                }
                else if(concat.equals("0")&&bc.equals("0") &&gdb.equals("0")&&ab.equals("0"))
                {
                    chk= new String[]{};
                    Intent inten = new Intent(EditCartActivity.this,Menus.class);
                    startActivity(inten);
                }
                if(!(concat.isEmpty()) && bc.equals("0") && gdb.equals("0")&&ab.equals("1"))
                {
                    chk= new String[]{concat};
                    Intent inten = new Intent(EditCartActivity.this,Menus.class);
                    startActivity(inten);
                }
                else if(concat.equals("0") && !(bc.isEmpty()) && gdb.equals("0")&&ab.equals("1"))
                {
                    chk= new String[]{bc};
                    Intent inten = new Intent(EditCartActivity.this,Menus.class);
                    startActivity(inten);
                }
                else if(!(concat.isEmpty()) && !(bc.isEmpty()) && gdb.equals("0")&&ab.equals("1"))
                {
                    chk= new String[]{concat};
                    t1.setText(null);
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putString("bc", "0");
                    editor.commit();
                    Intent inten = new Intent(EditCartActivity.this,Menus.class);
                    startActivity(inten);
                }
                else if(concat.equals("0") && bc.equals("0") && !(gdb.isEmpty())&&ab.equals("1"))
                {
                    chk= new String[]{gdb};
                    Intent inten = new Intent(EditCartActivity.this,Menus.class);
                    startActivity(inten);
                }
                else if(concat.equals("0")&& !(bc.isEmpty()) && !(gdb.isEmpty())&&ab.equals("1"))
                {
                    chk= new String[]{gdb};
                    t1.setText(null);
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putString("bc", "0");
                    editor.commit();
                    Intent inten = new Intent(EditCartActivity.this,Menus.class);
                    startActivity(inten);
                }
                else if(!(concat.isEmpty()) && bc.equals("0") && !(gdb.isEmpty())&&ab.equals("1"))
                {
                    chk= new String[]{concat,gdb};
                    Intent inten = new Intent(EditCartActivity.this,Menus.class);
                    startActivity(inten);
                }
                else if(!(concat.isEmpty()) && !(bc.isEmpty()) && !(gdb.isEmpty())&&ab.equals("1"))
                {
                    chk= new String[]{concat,gdb};
                    t1.setText(null);
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putString("bc", "0");
                    editor.commit();
                    Intent inten = new Intent(EditCartActivity.this,Menus.class);
                    startActivity(inten);
                }
                else if(concat.equals("0")&&bc.equals("0") &&gdb.equals("0")&&ab.equals("1"))
                {
                    chk= new String[]{};
                    Intent inten = new Intent(EditCartActivity.this,Menus.class);
                    startActivity(inten);
                }

                if(!(concat.isEmpty()) && bc.equals("0") && gdb.equals("0")&&ab.equals("2"))
                {
                    chk= new String[]{concat};
                    Intent inten = new Intent(EditCartActivity.this,Menus.class);
                    startActivity(inten);
                }
                else if(concat.equals("0") && !(bc.isEmpty()) && gdb.equals("0")&&ab.equals("2"))
                {
                    chk= new String[]{bc};
                    Intent inten = new Intent(EditCartActivity.this,Menus.class);
                    startActivity(inten);
                }
                else if(!(concat.isEmpty()) && !(bc.isEmpty()) && gdb.equals("0")&&ab.equals("2"))
                {
                    chk= new String[]{concat,bc};
                    Intent inten = new Intent(EditCartActivity.this,Menus.class);
                    startActivity(inten);
                }
                else if(concat.equals("0") && bc.equals("0") && !(gdb.isEmpty())&&ab.equals("2"))
                {
                    chk= new String[]{};
                    t1.setText(null);
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putString("gdb", "0");
                    editor.commit();
                    Intent inten = new Intent(EditCartActivity.this,Menus.class);
                    startActivity(inten);
                }
                else if(concat.equals("0")&& !(bc.isEmpty()) && !(gdb.isEmpty())&&ab.equals("2"))
                {
                    chk= new String[]{bc};
                    t1.setText(null);
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putString("gdb", "0");
                    editor.commit();
                    Intent inten = new Intent(EditCartActivity.this,Menus.class);
                    startActivity(inten);
                }
                else if(!(concat.isEmpty()) && bc.equals("0") && !(gdb.isEmpty())&&ab.equals("2"))
                {
                    chk= new String[]{concat};
                    t1.setText(null);
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putString("gdb", "0");
                    editor.commit();
                    Intent inten = new Intent(EditCartActivity.this,Menus.class);
                    startActivity(inten);
                }
                else if(!(concat.isEmpty()) && !(bc.isEmpty()) && !(gdb.isEmpty())&&ab.equals("2"))
                {
                    chk= new String[]{concat,bc};
                    t1.setText(null);
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putString("gdb", "0");
                    editor.commit();
                    Intent inten = new Intent(EditCartActivity.this,Menus.class);
                    startActivity(inten);
                }

                else{
                    t1.setText(null);
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putString("gdb", "0");
                    editor.putString("bc", "0");
                    editor.putString("con", "0");
                    editor.commit();
                    Intent inten = new Intent(EditCartActivity.this,Menus.class);
                    startActivity(inten);
                   // Toast.makeText(EditCartActivity.this,"else hogya chaloo beta",Toast.LENGTH_SHORT).show();
                }


            }
        });

    }
}
