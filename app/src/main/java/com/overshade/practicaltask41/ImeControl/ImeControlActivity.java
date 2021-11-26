package com.overshade.practicaltask41.ImeControl;

import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.overshade.practicaltask41.R;

public class ImeControlActivity extends AppCompatActivity
implements AdapterView.OnItemSelectedListener
{
    //form variables
    private TextView textName;
    private TextView textSurname;
    private TextView textAge;
    private TextView textEmail;
    private TextView textPhone;

    //input variables
    private EditText textInput;
    private Spinner fieldSelector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ime_options);
        textInput     = findViewById(R.id.text_input);
        fieldSelector = findViewById(R.id.field_selector);
        textName      = findViewById(R.id.name);
        textSurname   = findViewById(R.id.surname);
        textAge       = findViewById(R.id.age);
        textEmail     = findViewById(R.id.email);
        textPhone     = findViewById(R.id.phone);

        //Setting values into the field selector spinner
        ArrayAdapter<CharSequence> fsAdapter;
        fsAdapter = ArrayAdapter.createFromResource(
                this,
                R.array.personAttrib,
                R.layout.support_simple_spinner_dropdown_item
        );
        fieldSelector.setAdapter(fsAdapter);
        fieldSelector.setOnItemSelectedListener(this);

        //Making textInput onImeAction listener
        textInput.setOnEditorActionListener((textView, i, keyEvent) -> {

            //Spinner's current selection
            String selection;
            selection = String.valueOf(fieldSelector.getSelectedItem());
            selection = selection.toLowerCase();
            int position = fieldSelector.getSelectedItemPosition();

            //Getting the user's input
            String input = String.valueOf(textInput.getText());
            int visibility = (input.equals("")) ? View.GONE : View.VISIBLE;

            switch (selection) {
                case "name":
                    textName.setText(String.format("Name: %s", input));
                    textName.setVisibility(visibility);
                    fieldSelector.setSelection(position+1);
                    break;
                case "surname":
                    textSurname.setText(String.format("Surname: %s", input));
                    textSurname.setVisibility(visibility);
                    fieldSelector.setSelection(position+1);
                    break;
                case "age":
                    textAge.setText(String.format("Age: %s", input));
                    textAge.setVisibility(visibility);
                    fieldSelector.setSelection(position+1);
                    break;
                case "email":
                    textEmail.setText(String.format("Email: %s", input));
                    textEmail.setVisibility(visibility);
                    fieldSelector.setSelection(position+1);
                    break;
                case "phone":
                    textPhone.setText(String.format("Phone: %s", input));
                    textPhone.setVisibility(visibility);
                    fieldSelector.setSelection(0);
                    break;
            }
            return true;
        });
    }

    //On item selected we change the imeInput and imeOption of our EditText
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        int inputType = InputType.TYPE_CLASS_TEXT;
        int inputFormat = InputType.TYPE_TEXT_FLAG_CAP_SENTENCES;
        int imeOption = EditorInfo.IME_ACTION_NEXT;
        //Getting the selection
        String selection;
        selection = String.valueOf(adapterView.getSelectedItem());
        selection = selection.toLowerCase();
        switch (selection) {
            case "age":
            case "phone":
                inputType = EditorInfo.TYPE_CLASS_NUMBER;
                inputFormat = InputType.TYPE_NUMBER_VARIATION_NORMAL;
                imeOption = EditorInfo.IME_ACTION_NEXT;
                break;
            case "email":
                inputType = EditorInfo.TYPE_TEXT_VARIATION_EMAIL_ADDRESS;
                inputFormat = InputType.TYPE_TEXT_FLAG_AUTO_COMPLETE;
                imeOption = EditorInfo.IME_ACTION_SEND;
        }
        textInput.setText(null);
        textInput.setInputType(inputType | inputFormat);
        textInput.setImeOptions(imeOption);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}