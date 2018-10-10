package com.example.alex.wingshooterspocketapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Home_Screen extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
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
        Intent intent = new Intent(this, gamebirdidmain.class);
        startActivity(intent);
        finish();
    }

    public void StartHunt()
    {
        Intent intent = new Intent(this, StartHunt.class);
        startActivity(intent);
        finish();
    }
}
