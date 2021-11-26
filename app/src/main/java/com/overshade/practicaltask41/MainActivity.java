package com.overshade.practicaltask41;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.overshade.practicaltask41.ImeControl.ImeControlActivity;
import com.overshade.practicaltask41.List.ListActivity;
import com.overshade.practicaltask41.Pickers.PickersActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button startImeControl = findViewById(R.id.start_ime_control);
        Button startPickers    = findViewById(R.id.start_pickers);
        Button startList       = findViewById(R.id.start_list);

        //Setting buttons click listeners
        startImeControl.setOnClickListener(v ->goTo(ImeControlActivity.class));
        startPickers.setOnClickListener   (v ->goTo(PickersActivity.class));
        startList.setOnClickListener      (v ->goTo(ListActivity.class));

    }

    //Method to create each activity
    private void goTo(Class<? extends Activity> activity) {
        Intent activityIntent = new Intent(this, activity);
        startActivity(activityIntent);
    }

}