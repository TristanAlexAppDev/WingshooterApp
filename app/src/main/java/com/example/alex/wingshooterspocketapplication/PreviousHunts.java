package com.example.alex.wingshooterspocketapplication;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class PreviousHunts extends AppCompatActivity implements View.OnClickListener
{
    public TextView txtDate;
    public String strDate = "";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_previous_hunts);

        Button btnDateGet = findViewById(R.id.btnGetHunts);
        btnDateGet.setOnClickListener(this);

        Button btnHome = findViewById(R.id.btnHuntsHome);
        btnHome.setOnClickListener(this);

        txtDate = findViewById(R.id.txtDateThing);
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.btnGetHunts:
                getDate();
                break;
            case R.id.btnHuntsHome:
                goHome();
                break;
        }
    }

    private void getDate()
    {
        final Calendar c = Calendar.getInstance();
        final int Year = c.get(Calendar.YEAR);
        final int Month = c.get(Calendar.MONTH);
        final int Day = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener()
        {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth)
            {
                String day = String.valueOf(dayOfMonth);
                String Smonth = String.valueOf(month + 1);
                String sYear = String.valueOf(year);

                txtDate.setText(day + "/" + Smonth + "/" + sYear);
                strDate = day + "/" + Smonth + "/" + sYear;
            }
        },Year, Month, Day);
        datePickerDialog.show();

        DatabaseHelper dbHelp = new DatabaseHelper(this);
        int huntID = dbHelp.getHuntIDforPastHunts(strDate);

        if (huntID == 0)
        {
            Toast.makeText(getApplicationContext(), "No Hunts on that day.", Toast.LENGTH_LONG).show();
        }
        else
        {
            LastPart(huntID);
        }
    }

    private void LastPart(int huntID)
    {
        DatabaseHelper dbHelp = new DatabaseHelper(this);
        //Cursor cursor = dbHelp.getPastHuntLogs(huntID);
    }

    private void goHome()
    {
        Intent intent = new Intent(PreviousHunts.this, Home_Screen.class);
        startActivity(intent);
        finish();
    }
}
