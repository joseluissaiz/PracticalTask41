package com.overshade.practicaltask41.Pickers;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import com.overshade.practicaltask41.R;

import java.util.Calendar;
import java.util.Locale;

public class PickersActivity extends AppCompatActivity {
    private final String TAG = "PICKERS_ACTIVITY";
    private TextView textDatetime;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pickers);
        textDatetime = findViewById(R.id.text_datetime);
        Button buttonDate = findViewById(R.id.button_date) ;
        Button buttonTime = findViewById(R.id.button_time) ;
        
        //Setting buttons on click listeners
        buttonDate.setOnClickListener(v -> askDate());
        buttonTime.setOnClickListener(v -> askTime());
    }

    private void askDate() {
        DatePickerFragment datePicker = new DatePickerFragment(textDatetime);
        datePicker.show(getSupportFragmentManager(), TAG);
    }

    private void askTime() {
        TimePickerFragment timePicker = new TimePickerFragment(textDatetime);
        timePicker.show(getSupportFragmentManager(), TAG);
    }

    //Setting date fragment for the dialog input
    public static class DatePickerFragment extends DialogFragment
    implements DatePickerDialog.OnDateSetListener
    {
        private final TextView textResult;

        public DatePickerFragment(TextView resultTextView){
            textResult = resultTextView;
        }

        @NonNull
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);
            DatePickerDialog dialog = new DatePickerDialog(
                    getActivity(), this, year, month, day
            );
            dialog.getDatePicker().setMaxDate(c.getTimeInMillis());
            return  dialog;
        }

        public void onDateSet(DatePicker view, int year, int month, int day) {
            textResult.setText(String.format("%s-%s-%s",month,day,year));
        }
    }

    //Setting time fragment for the dialog input
    public static class TimePickerFragment extends DialogFragment
    implements TimePickerDialog.OnTimeSetListener
    {
        private final TextView textResult;

        public TimePickerFragment(TextView resultTextView){
            textResult = resultTextView;
        }

        @NonNull
        @Override
        public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
            final Calendar c = Calendar.getInstance();
            int hour = c.get(Calendar.HOUR);
            int minutes = c.get(Calendar.MINUTE);
            return new TimePickerDialog(
                    getActivity(), this, hour, minutes, true
            );
        }

        @Override
        public void onTimeSet(TimePicker timePicker, int hour, int minutes) {
            String result = textResult.getText().toString();
            String format = String.format(
                    Locale.US,"%s at %d:%02d",result,hour,minutes
            );
            textResult.setText(format);
        }
    }

}