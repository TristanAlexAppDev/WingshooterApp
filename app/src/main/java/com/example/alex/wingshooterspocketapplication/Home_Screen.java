package com.example.alex.wingshooterspocketapplication;

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
                new NewHunt();
                break;

            case R.id.btnHuntingSeasons:
               new HSProvinceSelection();
                break;

            case R.id.btnGamebird:
                new gamebirdidmain();
                break;

            case R.id.btnMyHunts:
                new StartHunt();
                break;


        }

    }
}
