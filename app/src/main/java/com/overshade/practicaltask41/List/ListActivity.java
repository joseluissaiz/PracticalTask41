package com.overshade.practicaltask41.List;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.overshade.practicaltask41.R;

import java.util.LinkedHashMap;

public class ListActivity extends AppCompatActivity {
    //List information
    private static final LinkedHashMap<Integer, String> list;
    static {
        list = new LinkedHashMap<>();
        list.put(
                R.drawable.donut_circle,
                "Our super donut is incredible, you need to taste it!"
        );
        list.put(
                R.drawable.icecream_circle,
                "Our super IceCream is incredible, you need to taste it!"
        );
        list.put(
                R.drawable.froyo_circle,
                "Our super Froyo is incredible, you need to taste it!"
        );
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        ListView listView = findViewById(R.id.list_view);

        //Setting list data
        FoodAdapter adapter = new FoodAdapter(this,list);
        listView.setAdapter(adapter);
        System.out.println("------------>->->->"+adapter.getCount());

        //Adding onClickListener for the elements of the list
        listView.setOnItemClickListener((adapterView, view, pos, l) -> {
            String item = (String) list.values().toArray()[pos];
            Toast.makeText(
                    getApplicationContext(),
                    "You selected :"+item,
                    Toast.LENGTH_SHORT
            ).show();
        });

    }
}