package com.example.alex.wingshooterspocketapplication;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class LogActivity extends AppCompatActivity implements View.OnClickListener
{

    public TextView txtBirdName;
    public TextView txtNumSeenOrShot;
    public TextView txtOtherInfo;
    public Spinner spnBirdAge;
    public Spinner spnSeenORShot;
    public RadioGroup rg;

    public int huntID = NewHunt.huntID;
    //public static String[] logs = new String[10];
    public String radioSelection = "default";
    public static String NewLog;
    public String space = "\n";

    //must have values
    String birdName;
    String ShtORSn;
    String brdAge;
    String numSnORSht;

    //can be empty
    String othrAnimORClaySht;
    String AnimShotORClayTypeSht;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);
        /* Setting up the drop down menu for the bird age*/
        getSupportActionBar().setTitle("Log your Findings");

        txtBirdName = findViewById(R.id.pTxtBirdType);
        txtNumSeenOrShot = findViewById(R.id.pTxtNumSeenorShot);
        txtOtherInfo = findViewById(R.id.edttxtOptionalInfo);
        spnBirdAge = findViewById(R.id.spnAge);
        spnSeenORShot = findViewById(R.id.spnSorS);
        rg = findViewById(R.id.rdbGroup);
        NewLog = "";

        Button btnAddLog = findViewById(R.id.btnNewLog);
        btnAddLog.setOnClickListener(this);

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId)
            {
                switch (checkedId)
                {
                    case R.id.rdbOtherAnimal:
                        radioSelection = "AnimalShot";
                        break;

                    case R.id.rdbClayshoot:
                        radioSelection = "ClayShoot";
                        break;
                }
            }
        });
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.btnNewLog:
                logActivity();
                break;
        }
    }

    private void logActivity()
    {
        birdName = txtBirdName.getText().toString();
        ShtORSn = spnSeenORShot.getSelectedItem().toString();
        brdAge = spnBirdAge.getSelectedItem().toString();
        numSnORSht = txtNumSeenOrShot.getText().toString();

        if (birdName.equals("") || ShtORSn.equals("") || brdAge.equals("") || numSnORSht.equals(""))
        {
            Toast.makeText(getApplicationContext(), "One of the fields is missing, please make sure you entered all relevant information", Toast.LENGTH_LONG).show();
        }
        else
        {
            othrAnimORClaySht = radioSelection;
            AnimShotORClayTypeSht = txtOtherInfo.getText().toString();

            birdName = birdName.replaceAll("\\s+","");
            ShtORSn = ShtORSn.replaceAll("\\s+","");
            brdAge = brdAge.replaceAll("\\s+","");
            numSnORSht = numSnORSht.replaceAll("\\s+","");
            othrAnimORClaySht = othrAnimORClaySht.replaceAll("\\s+", "");
            AnimShotORClayTypeSht = AnimShotORClayTypeSht.replaceFirst("\\s+", "");

            if (othrAnimORClaySht.equals(""))
            {
                othrAnimORClaySht = "noDataGiven";
                NewLog = space + birdName + " " + ShtORSn + " " + brdAge + " " + numSnORSht + space;
            }
            else
            {
                NewLog = space + birdName + " " + ShtORSn + " " + brdAge + " " + numSnORSht + " " + othrAnimORClaySht + " " + AnimShotORClayTypeSht + space;
            }
            if (AnimShotORClayTypeSht.equals(""))
            {
                AnimShotORClayTypeSht = "noDataGiven";
                NewLog = space + birdName + " " + ShtORSn + " " + brdAge + " " + numSnORSht + space;
            }
            else
            {
                NewLog = space + birdName + " " + ShtORSn + " " + brdAge + " " + numSnORSht + " " + othrAnimORClaySht + " " + AnimShotORClayTypeSht + space;
            }
            LogFinalTask();
        }

    }

    private void LogFinalTask()
    {
        DatabaseHelper db = new DatabaseHelper(this);
        boolean result = db.addNewLog(huntID, birdName, ShtORSn, brdAge, numSnORSht, othrAnimORClaySht, AnimShotORClayTypeSht);
        //int count = 0;

        if (result)
        {
            //logs[count] = NewLog;
            Toast.makeText(getApplicationContext(), "New entry into Log is Successful", Toast.LENGTH_LONG).show();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent i = new Intent(LogActivity.this, StartHunt.class);
                    startActivity(i);
                }
            }, 1500);
        }
        else
        {
            Toast.makeText(getApplicationContext(), "New entry into Log is Successful", Toast.LENGTH_LONG).show();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent i = new Intent(LogActivity.this, StartHunt.class);
                    startActivity(i);
                }
            }, 1500);
        }
    }
}
