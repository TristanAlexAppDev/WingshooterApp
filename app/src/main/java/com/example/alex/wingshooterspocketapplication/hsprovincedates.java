package com.example.alex.wingshooterspocketapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class hsprovincedates extends AppCompatActivity
{
    public String choice = hsprovinceselection.userChoice;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hsprovincedates);

        TextView t = findViewById(R.id.txtDatesHead);
        t.setText(choice + " Hunting Dates");
    }
}
