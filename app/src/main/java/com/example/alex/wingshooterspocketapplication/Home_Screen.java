package com.example.alex.wingshooterspocketapplication;

import android.app.DownloadManager;
import android.app.VoiceInteractor;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Home_Screen extends AppCompatActivity implements View.OnClickListener
{
    public TextView txtUserLoggedIn;

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


        }

    }

    public void NewHunt()
    {
        Intent intent = new Intent(this,NewHunt.class);
        startActivity(intent);
        finish();
    }

    public void HSProvinceSelection()
    {
        Intent intent = new Intent(this, HSProvinceSelection.class);
        startActivity(intent);
        finish();

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
        DownloadManager magManager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
        DownloadManager.Request magRequest = new DownloadManager.Request(Uri.parse("https://www.sajs.co.za/article/view/3565/4498"));
        magRequest.setDescription("this is the test file needs to change");
        long idDownload = magManager.enqueue(magRequest);
    }
}
