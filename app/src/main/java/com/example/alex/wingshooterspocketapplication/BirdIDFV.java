package com.example.alex.wingshooterspocketapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ViewFlipper;

public class BirdIDFV extends AppCompatActivity
{
        private ViewFlipper gameVF ;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bird_idfv);

        gameVF = findViewById(R.id.FlipBirrds);

    }

    public void previousView(View v)
    {
        gameVF.showPrevious();

    }

    public void startView(View v)
    {
        gameVF.setDisplayedChild(0);
    }

    public void nextView(View v)
    {
        gameVF.showNext();
    }
}
