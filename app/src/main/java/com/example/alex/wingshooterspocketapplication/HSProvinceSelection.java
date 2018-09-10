package com.example.alex.wingshooterspocketapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

<<<<<<< HEAD
public class HSProvinceSelection extends AppCompatActivity
=======
public class hsprovinceselection extends AppCompatActivity implements View.OnClickListener
>>>>>>> 2a4d1698b731c710dc5d97256b2be9b0d8cd3a47
{
    public static String userChoice;
    //public int infoNum = 0;

    @Override

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hsprovinceselection);

        Button b1 = findViewById(R.id.btnHSHome);
        b1.setOnClickListener(this);

        Button b2 = findViewById(R.id.btnHSFreeState);
        b2.setOnClickListener(this);

        Button b3 = findViewById(R.id.btnHSWesternCape);
        b3.setOnClickListener(this);

        Button b4 = findViewById(R.id.btnHSEasternCape);
        b4.setOnClickListener(this);

        Button b5 = findViewById(R.id.btnHSNatal);
        b5.setOnClickListener(this);

        Button b6 = findViewById(R.id.btnHSLimpopo);
        b6.setOnClickListener(this);

        Button b7 = findViewById(R.id.btnHSNorthernCape);
        b7.setOnClickListener(this);

        Button b8 = findViewById(R.id.btnHSGuateng);
        b8.setOnClickListener(this);

        Button b9 = findViewById(R.id.btnHSNWProvince);
        b9.setOnClickListener(this);

        Button b10 = findViewById(R.id.btnHSMpumalanga);
        b10.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.btnGBHome:
                Intent i = new Intent(getApplicationContext(),Home_Screen.class);
                startActivity(i);
                break;

            case R.id.btnHSFreeState:
                Intent i1 = new Intent(getApplicationContext(),hsprovincedates.class);
                userChoice = "Free State";
                startActivity(i1);
                break;

            case R.id.btnHSWesternCape:
                Intent i9 = new Intent(getApplicationContext(),hsprovincedates.class);
                userChoice = "Western Cape";
                startActivity(i9);
                break;

            case R.id.btnHSEasternCape:
                Intent i3 = new Intent(getApplicationContext(),hsprovincedates.class);
                userChoice = "Eastern Cape";
                startActivity(i3);
                break;

            case R.id.btnHSNatal:
                Intent i4 = new Intent(getApplicationContext(),hsprovincedates.class);
                userChoice = "Kwa-Zulu Natal";
                startActivity(i4);
                break;

            case R.id.btnHSLimpopo:
                Intent i5 = new Intent(getApplicationContext(),hsprovincedates.class);
                userChoice = "Limpopo";
                startActivity(i5);
                break;

            case R.id.btnHSNorthernCape:
                Intent i6 = new Intent(getApplicationContext(),hsprovincedates.class);
                userChoice = "Northern Cape";
                startActivity(i6);
                break;

            case R.id.btnHSGuateng:
                Intent i7 = new Intent(getApplicationContext(),hsprovincedates.class);
                userChoice = "Gauteng";
                startActivity(i7);
                break;

            case R.id.btnHSNWProvince:
                Intent i8 = new Intent(getApplicationContext(),hsprovincedates.class);
                userChoice = "North West";
                startActivity(i8);
                break;

            case R.id.btnHSMpumalanga:
                Intent i10 = new Intent(getApplicationContext(),hsprovincedates.class);
                userChoice = "Mpumalanga";
                startActivity(i10);
                break;
        }
    }
}
