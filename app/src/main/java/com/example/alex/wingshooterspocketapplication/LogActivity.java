package com.example.alex.wingshooterspocketapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class LogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);
        /* Setting up the drop down menu for the bird age*/
        setTitle("LOG ACTIVITY");

        Spinner AgeSpin = (Spinner) findViewById(R.id.spnAge);

        ArrayAdapter<String> adaptBAge = new ArrayAdapter<String>(LogActivity.this,android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.Bird_Age));

        adaptBAge.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        AgeSpin.setAdapter(adaptBAge);
        /* drop down menu for seen or shot */

        Spinner SorS = (Spinner) findViewById(R.id.spnSorS);

        ArrayAdapter<String> adaptSorS = new ArrayAdapter<String>(LogActivity.this,android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.SeenShot));

        adaptSorS.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        SorS.setAdapter(adaptSorS);

    }
}
