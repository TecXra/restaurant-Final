package com.example.fasigujar.copyproject;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Mian Mohsin on 10/19/2016.
 */
public class cart_show extends AppCompatActivity{
    ListView listView;
    Button b;
    String chk[];
    Intent intent;
    SharedPreferences prefs;
    Button btn,order;
    public String s,total;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cart_show);



      //  Int IntVariableName=Integer.parseInt(VariableName);

      // total= i.getIntExtra("total",0);
       listView= (ListView) findViewById(R.id.listView3);
        prefs = getSharedPreferences("data", Context.MODE_PRIVATE);

                String concat=prefs.getString("con","N/A");
                String bc=prefs.getString("bc","N/A");
                String gdb=prefs.getString("gdb","N/A");
       if(!(concat.isEmpty()) && bc.equals("0") && gdb.equals("0")) {
           if (concat.equals("0")) {
               SharedPreferences.Editor editor = prefs.edit();
               editor.putString("con", "1");
               editor.putString("bc", "0");
               editor.putString("gdb", "0");
               Toast.makeText(cart_show.this, "System Halt Please Wait", Toast.LENGTH_SHORT).show();
               editor.commit();
           } else {


               chk = new String[]{concat};
       //1    Toast.makeText(cart_show.this, "1", Toast.LENGTH_SHORT).show();


           }
       }
else if(concat.equals("0") && !(bc.isEmpty()) && gdb.equals("0"))
        {
            chk= new String[]{bc};
            Toast.makeText(cart_show.this,"2",Toast.LENGTH_SHORT).show();
        }
       else if(!(concat.isEmpty()) && !(bc.isEmpty()) && gdb.equals("0"))
       {
           chk= new String[]{concat,bc};
           Toast.makeText(cart_show.this,"3",Toast.LENGTH_SHORT).show();
       }
       else if(concat.equals("0") && bc.equals("0") && !(gdb.isEmpty()))
       {
           chk= new String[]{gdb};
           Toast.makeText(cart_show.this,"4",Toast.LENGTH_SHORT).show();
       }
       else if(concat.equals("0")&& !(bc.isEmpty()) && !(gdb.isEmpty()))
       {
           chk= new String[]{bc,gdb};
           Toast.makeText(cart_show.this,"5",Toast.LENGTH_SHORT).show();
       }
       else if(!(concat.isEmpty()) && bc.equals("0") && !(gdb.isEmpty()))
       {
           chk= new String[]{concat,gdb};
           Toast.makeText(cart_show.this,"6",Toast.LENGTH_SHORT).show();
       }
       else if(!(concat.isEmpty()) && !(bc.isEmpty()) && !(gdb.isEmpty()))
       {
           chk= new String[]{concat,bc,gdb};
           Toast.makeText(cart_show.this,"7",Toast.LENGTH_SHORT).show();
       }
        else if(concat.equals("0")&&bc.equals("0") &&gdb.equals("0"))
        {
            chk= new String[]{};
            Toast.makeText(cart_show.this,"8",Toast.LENGTH_SHORT).show();
        }
        else{

           Toast.makeText(cart_show.this,"else hogya chaloo beta",Toast.LENGTH_SHORT).show();
       }
      //  Bundle b=intent.getExtras();
      //  String[] array=b.getStringArray("as");
        ArrayAdapter <String> adapter= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,chk);
listView.setAdapter(adapter);
       /* listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView temp= (TextView) view;
                if(temp.getText()==null)
                {
                    Intent intent = new Intent(cart_show.this,Cart.class);

                    startActivity(intent);
                }
                int abc=position;
                String ab=Integer.toString(abc);

                String s= (String) temp.getText();
                Intent intent = new Intent(cart_show.this,EditCartActivity.class);
                intent.putExtra("ab",ab);
                intent.putExtra("s",s);
                startActivity(intent);
            }
        });*/
        btn= (Button) findViewById(R.id.addItems);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(cart_show.this,Menus.class);

                startActivity(intent);

            }
        });


        order= (Button) findViewById(R.id.order);
        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent= new Intent(cart_show.this,OrderActivity.class);
                intent.putExtra("total",total);
                startActivity(intent);

            }
        });

     /*
        prefs=getSharedPreferences("data", Context.MODE_PRIVATE);

        String key=prefs.getString("key","N/A");
        chk=prefs.getString("b","N/A");
        String key2=prefs.getString("key2","N/A");
        String name=prefs.getString("name2","N/A");
        String key3=prefs.getString("key3","N/A");
        String name2=prefs.getString("name3","N/A");
        String key4=prefs.getString("key4","N/A");
        String name3=prefs.getString("name4","N/A");
        String num1=prefs.getString("num1","N/A");
        String num2=prefs.getString("num2","N/A");
        String num3=prefs.getString("num3","N/A");
        Toast.makeText(this,name,Toast.LENGTH_SHORT).show();
        Toast.makeText(this,num1,Toast.LENGTH_SHORT).show();
        Toast.makeText(this,chk,Toast.LENGTH_SHORT).show();
*/

    }


}
