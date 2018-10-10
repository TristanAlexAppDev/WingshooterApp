package com.example.alex.wingshooterspocketapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class gamebirdid extends AppCompatActivity implements View.OnClickListener {
    @Override

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gamebirdidmain);

        Button b = findViewById(R.id.btnGBHome);
        b.setOnClickListener(this);

        Button b1 = findViewById(R.id.btnDucks);
        b1.setOnClickListener(this);

        Button b2 = findViewById(R.id.btnQuail);
        b2.setOnClickListener(this);

        Button b3 = findViewById(R.id.btnGeese);
        b3.setOnClickListener(this);

        Button b4 = findViewById(R.id.btnFowl);
        b4.setOnClickListener(this);

        Button b5 = findViewById(R.id.btnfranc);
        b5.setOnClickListener(this);

        Button b6 = findViewById(R.id.btnpartridge);
        b6.setOnClickListener(this);

        Button b7 = findViewById(R.id.btnPigeons);
        b7.setOnClickListener(this);

        Button b8 = findViewById(R.id.btnTeal);
        b8.setOnClickListener(this);

        Button b9 = findViewById(R.id.btnsnipe);
        b9.setOnClickListener(this);

        Button b10 = findViewById(R.id.btnGrouse);
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

            case R.id.btnDucks:
                Intent i1 = new Intent();
                startActivity(i1);
                break;

            case R.id.:
                Intent i2 = new Intent();
                startActivity(i2);
                break;

            case R.id.:
                Intent i3 = new Intent();
                startActivity(i3);
                break;

            case R.id.:
                Intent i4 = new Intent();
                startActivity(i4);
                break;

            case R.id.:
                Intent i5 = new Intent();
                startActivity(i5);
                break;

            case R.id.:
                Intent i6 = new Intent();
                startActivity(i6);
                break;

            case R.id.:
                Intent i7 = new Intent();
                startActivity(i7);
                break;

            case R.id.:
                Intent i8 = new Intent();
                startActivity(i8);
                break;

            case R.id.:
                Intent i9 = new Intent();
                startActivity(i9);
                break;

            case R.id.:
                Intent i10 = new Intent();
                startActivity(i10);
                break;
        }
    }
}
