package com.example.listapp;

// Credit: This program is taken from youtube by Bill Butterfield
//This is for learning purpose only

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView myListView;
    String [] Items;
    String [] Price;
    String []Description;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Resources res = getResources();

        myListView = (ListView) findViewById(R.id.myListView);

        Items = res.getStringArray(R.array.items);
        // myListView.setAdapter(new ArrayAdapter<String>(this,R.layout.my_listview_details, Items));

        Price = res.getStringArray(R.array.price);
        Description = res.getStringArray(R.array.description);

        // REFERENCING itemAdapter
        itemAdapter itemAdapter = new itemAdapter(this, Items, Price, Description);
        // now we have to use it
        myListView.setAdapter(itemAdapter);


        //--------------------------------------------FOR IMAGE------
        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent showDetailActivity = new Intent(getApplicationContext(), detailActivity.class);
                showDetailActivity.putExtra("key", position);
                startActivity(showDetailActivity);

            }

        });
    }
}