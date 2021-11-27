package com.overshade.practicaltask41.List;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.overshade.practicaltask41.R;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class FoodAdapter extends ArrayAdapter {
    private final Activity context;
    private final LinkedHashMap<Integer,String> list;

    //Creating a new Adapter to set the info into our ListView
    public FoodAdapter(Activity context, LinkedHashMap<Integer,String> list) {
        super(context, R.layout.list_row, list.keySet().toArray());
        this.context = context;
        this.list = list;
    }

    @SuppressLint("InflateParams")
    @NonNull
    @Override
    public View getView(int pos, @Nullable View cView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View row = cView;

        //Inflating our row view if the convert is null
        if (cView == null) {
            row = inflater.inflate(R.layout.list_row, null, true);
        }
        ImageView imgSrc = row.findViewById(R.id.image);
        TextView description = row.findViewById(R.id.description);

        //Setting the row information
        imgSrc.setImageResource((Integer) list.keySet().toArray()[pos]);
        description.setText((String) list.values().toArray()[pos]);

        return row;
    }
}
