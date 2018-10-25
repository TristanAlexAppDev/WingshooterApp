package com.example.alex.wingshooterspocketapplication;

import android.app.DownloadManager;
import android.app.VoiceInteractor;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;

import android.net.Uri;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.util.AndroidException;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.github.barteksc.pdfviewer.PDFView;


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

    public PDFView pdfView1;
    public ConstraintLayout viewPdf1;
    public ConstraintLayout butView1;

    public PDFView pdfView2;
    public ConstraintLayout viewPdf2;
    public ConstraintLayout butView2;

    public PDFView pdfView3;
    public ConstraintLayout viewPdf3;
    public ConstraintLayout butView3;



    public String userName = LogRegMainActivity.userName;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home__screen);
        getSupportActionBar().setTitle("Home");

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


        Button btnCPdf1 = findViewById(R.id.closePdf1);
        btnCPdf1.setOnClickListener(this);

        Button btnCPdf2 = findViewById(R.id.closePdf2);
        btnCPdf2.setOnClickListener(this);

        Button btnCPdf3 = findViewById(R.id.closePdf3);
        btnCPdf3.setOnClickListener(this);

        Button btnDmag = findViewById(R.id.btnDMag1);
        btnDmag.setOnClickListener(this);

        Button btnDnot = findViewById(R.id.btnDNot);
        btnDnot.setOnClickListener(this);

        Button btnDSeas = findViewById(R.id.btnDHS);
        btnDSeas.setOnClickListener(this);

        txtUserLoggedIn = findViewById(R.id.txtHomeScreen);
        txtUserLoggedIn.setText("Welcome " + userName);

        pdfView1=findViewById(R.id.pdfv1);
        viewPdf1 = findViewById(R.id.pdView1);
        butView1 = findViewById(R.id.conLayBtn);

        pdfView2=findViewById(R.id.pdfv2);
        viewPdf2 = findViewById(R.id.pdView2);
        butView2= findViewById(R.id.conLayBtn);

        pdfView3=findViewById(R.id.pdfv3);
        viewPdf3 = findViewById(R.id.pdView3);
        butView3 = findViewById(R.id.conLayBtn);



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

            case R.id.closePdf1:
                closepdf();
                break;

            case R.id.closePdf2:
                closepdf();
                break;

            case R.id.closePdf3:
                closepdf();
                break;

            case R.id.btnDMag1:
                dltPdfM();
                break;

            case R.id.btnDNot:
                dltPdfN();
                break;

            case R.id.btnDHS:
                dltPdfHS();
                break;

        }

    }

    public void NewHunt ()
    {
        Intent intent = new Intent(this,NewHunt.class);
        startActivity(intent);

    }


    public void gamebirdidmain()
    {
        Intent intent = new Intent(this, BirdIDFV.class);
        startActivity(intent);

    }

    public void StartHunt()
    {
        Intent intent = new Intent(this, StartHunt.class);
        startActivity(intent);

    }

    public void HSProvinceSelection()
    {
        File fileP = new File("/sdcard/WINGPOCKAPP FILES/WingShootersHuntSeasons.pdf");

        if (fileP.exists()) {
            Uri path3 = Uri.fromFile(fileP);
            pdfView3.fromUri(path3).load();
            viewPdf3.setVisibility(View.VISIBLE);
            butView3.setVisibility(View.INVISIBLE);

        }

        else {
            String URL = "http://www.wingshooters.org.za/.cm4all/iproc.php/HUNTING-SEASONS-2018-May.pdf?cdp=a";
            new DownloadTask(Home_Screen.this, URL);
            otherName = 3;
        }


    }

    public void downMag()
    {
        File file = new File("/sdcard/WINGPOCKAPP FILES/WingShootersMagazine.pdf");

        if (file.exists()) {
            Uri path1 = Uri.fromFile(file);
            pdfView1.fromUri(path1).load();
            viewPdf1.setVisibility(View.VISIBLE);
            butView1.setVisibility(View.INVISIBLE);

        }

        else {
        String URL = "http://www.wingshooters.org.za/.cm4all/iproc.php/WINGS-MAG-No4-2017.pdf?cdp=a";
        new DownloadTask(Home_Screen.this, URL);
        otherName = 2;
        }

    }

    public void downNot()
    {
        File fileN = new File("/sdcard/WINGPOCKAPP FILES/WingShootersNotifications.pdf");

        if (fileN.exists()) {
            Uri path2 = Uri.fromFile(fileN);
            pdfView2.fromUri(path2).load();
            viewPdf2.setVisibility(View.VISIBLE);
            butView2.setVisibility(View.INVISIBLE);

        }

        else {
            String URL = "http://www.wingshooters.org.za/.cm4all/iproc.php/SAWingshooters-2018-ShootCalendar-Fin.pdf?cdp=a";
            new DownloadTask(Home_Screen.this, URL);
            otherName = 1;
        }
    }



    public void closepdf()
    {


        Intent intent = new Intent(this,Home_Screen.class);
        startActivity(intent);

        finish();
    }

    public void dltPdfM()
    {
        Intent intent = new Intent(this,Home_Screen.class);
        startActivity(intent);
        File file = new File("/sdcard/WINGPOCKAPP FILES/WingShootersMagazine.pdf");
        file.delete();
        finish();


    }

    public void dltPdfN()
    {
        Intent intent = new Intent(this,Home_Screen.class);
        startActivity(intent);
        File fileN = new File("/sdcard/WINGPOCKAPP FILES/WingShootersNotifications.pdf");
        fileN.delete();
        finish();


    }

    public void dltPdfHS()
    {
        Intent intent = new Intent(this,Home_Screen.class);
        startActivity(intent);
        File fileP = new File("/sdcard/WINGPOCKAPP FILES/WingShootersHuntSeasons.pdf");
        fileP.delete();
        finish();


    }






}
