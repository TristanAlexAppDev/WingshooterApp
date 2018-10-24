package com.example.alex.wingshooterspocketapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Arrays;


public class StartHunt extends AppCompatActivity implements  View.OnClickListener
{
    public int huntID = NewHunt.huntID;
    public String hunt = NewHunt.huntName;
    public String huntDate = NewHunt.DateofHunt;
    public static String huntContent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_hunt);
        getSupportActionBar().setTitle("Active Hunt");


        Button btnAdding = findViewById(R.id.BtnAdd);
        Button btnSubmit = findViewById(R.id.btnSubmit);
        btnAdding.setOnClickListener(this);
        btnSubmit.setOnClickListener(this);

        TextView txtHeader = findViewById(R.id.txtActivityName);
        txtHeader.setText("Activity name: " + hunt);
        TextView txtLog1 = findViewById(R.id.txtReport1);
        if (LogActivity.NewLog == null)
        {
            txtLog1.setText("");
            huntContent = "";
        }
        else
        {
            huntContent = huntContent + "/NEXT_LOG/" + LogActivity.NewLog;
            txtLog1.setText(huntContent);
        }
    }


    @Override
    public void onClick(View v)
    {

        switch (v.getId())
        {
            case R.id.BtnAdd:
                NewHuntThing();
                break;
            case R.id.btnSubmit:
                EmailHuntInfo();
                break;
        }
    }

    public void NewHuntThing()
    {
        Intent intent = new Intent(this, LogActivity.class);
        startActivity(intent);
    }

    public void EmailHuntInfo()
    {
        Intent intent = new Intent(this,EmailHuntInfo.class);
        startActivity(intent);
        finish();
    }
}
