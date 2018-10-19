package com.example.alex.wingshooterspocketapplication;

import android.app.DownloadManager;
import android.app.VoiceInteractor;
import android.content.Context;
import android.content.Intent;

import android.net.Uri;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class Home_Screen extends AppCompatActivity implements View.OnClickListener
{
    public TextView txtUserLoggedIn;
    public static int otherName;


    public String userName = LogRegMainActivity.userName;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home__screen);

        Button btnNAct = findViewById(R.id.btnNewActivity);
        btnNAct.setOnClickListener(this);

        Button btnHSeasons = findViewById(R.id.btnHuntingSeasons);
        btnHSeasons.setOnClickListener(this);

        Button btnGBID = findViewById(R.id.btnGamebird);
        btnGBID.setOnClickListener(this);

        Button btnMyHunts = findViewById(R.id.btnMyHunts);
        btnMyHunts.setOnClickListener(this);

        Button btnMag = findViewById(R.id.btnMagazine);
        btnMag.setOnClickListener(this);

        Button btnNoti = findViewById(R.id.btnNotification);
        btnNoti.setOnClickListener(this);

        txtUserLoggedIn = findViewById(R.id.txtHomeScreen);
        txtUserLoggedIn.setText("Welcome " + userName);
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.btnNewActivity:
                NewHunt();
                break;

            case R.id.btnHuntingSeasons:
               HSProvinceSelection();
                break;

            case R.id.btnGamebird:
                gamebirdidmain();
                break;

            case R.id.btnMyHunts:
                StartHunt();
                break;

            case R.id.btnMagazine:
               downMag();
                break;

            case  R.id.btnNotification:
                downNot();
                break;
        }

    }

    public void NewHunt ()
    {
        Intent intent = new Intent(this,NewHunt.class);
        startActivity(intent);
        finish();
    }

    public void HSProvinceSelection()
    {
        String URL = "http://www.wingshooters.org.za/.cm4all/iproc.php/HUNTING-SEASONS-2018-May.pdf?cdp=a";
        new DownloadTask(Home_Screen.this, URL);
        otherName = 3;

    }

    public void gamebirdidmain()
    {
        Intent intent = new Intent(this, BirdIDFV.class);
        startActivity(intent);
        finish();
    }

    public void StartHunt()
    {
        Intent intent = new Intent(this, StartHunt.class);
        startActivity(intent);
        finish();
    }

    public void downMag()
    {
        String URL = "http://www.wingshooters.org.za/.cm4all/iproc.php/WINGS-MAG-No4-2017.pdf?cdp=a";
        new DownloadTask(Home_Screen.this, URL);
        otherName = 1;

    }

    public void downNot()
    {
        String URL = "http://www.wingshooters.org.za/.cm4all/iproc.php/SAWingshooters-2018-ShootCalendar-Fin.pdf?cdp=a";
        new DownloadTask(Home_Screen.this, URL);
        otherName = 2;


    }


}
