package com.example.alex.wingshooterspocketapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.ViewFlipper;

public class BirdIDFV extends AppCompatActivity implements View.OnClickListener
{
        private ViewFlipper gameVF ;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bird_idfv);

        gameVF = findViewById(R.id.FlipBirrds);

        Button btnscrollD = findViewById(R.id.btnScrollDuck);
        btnscrollD.setOnClickListener(this);

        Button btnscrollF = findViewById(R.id.btnScrollFranc);
        btnscrollF.setOnClickListener(this);

        Button btnscrollG = findViewById(R.id.btnScrollGeese);
        btnscrollG.setOnClickListener(this);

        Button btnscrollGr = findViewById(R.id.btnScrollGrouse);
        btnscrollGr.setOnClickListener(this);

        Button btnscrollGu = findViewById(R.id.btnScrollGuinie);
        btnscrollGu.setOnClickListener(this);

        Button btnscrollP = findViewById(R.id.btnScrollPartridge);
        btnscrollP.setOnClickListener(this);

        Button btnscrollPi = findViewById(R.id.btnScrollPigeons);
        btnscrollPi.setOnClickListener(this);

        Button btnscrollQ = findViewById(R.id.btnScrollQuial);
        btnscrollQ.setOnClickListener(this);

        Button btnscrollS = findViewById(R.id.btnScrollSnipe);
        btnscrollS.setOnClickListener(this);

        Button btnscrollT = findViewById(R.id.btnScrollTeal);
        btnscrollT.setOnClickListener(this);

        Button btnHomemain = findViewById(R.id.btnBHome);
        btnHomemain.setOnClickListener(this);
    }

    public void Home()
    {
        Intent intent = new Intent(this, Home_Screen.class);
        startActivity(intent);
        finish();
    }

    public void startView(View v)
    {
        gameVF.setDisplayedChild(0);
    }

    public void nextView(View v)
    {
        gameVF.showNext();
    }

    public void findDuck()
    {
        gameVF.setDisplayedChild(1);
    }

    public void findFranc()
    {
        gameVF.setDisplayedChild(2);
    }

    public void findGeese()
    {
        gameVF.setDisplayedChild(3);
    }

    public void findGrouse()
    {
        gameVF.setDisplayedChild(4);
    }

    public void findGuinie()
    {
        gameVF.setDisplayedChild(5);
    }

    public void findPartridge()
    {
        gameVF.setDisplayedChild(6);
    }

    public void findPigeons()
    {
        gameVF.setDisplayedChild(7);
    }

    public void findQuail()
    {
        gameVF.setDisplayedChild(8);
    }

    public void findSnipe()
    {
        gameVF.setDisplayedChild(9);
    }

    public void findTeal()
    {
        gameVF.setDisplayedChild(10);
    }

    @Override
    public void onClick(View v)
    {
     switch (v.getId())
     {
         case R.id.btnScrollDuck:
             findDuck();
             break;

         case R.id.btnScrollFranc:
             findFranc();
             break;

         case R.id.btnScrollGeese:
             findGeese();
             break;

         case R.id.btnScrollGrouse:
             findGrouse();
             break;

         case R.id.btnScrollGuinie:
             findGuinie();
             break;

         case R.id.btnScrollPartridge:
             findPartridge();
             break;

         case R.id.btnScrollPigeons:
             findPigeons();
             break;

         case R.id.btnScrollQuial:
             findQuail();
             break;

         case R.id.btnScrollSnipe:
             findSnipe();
             break;

         case R.id.btnScrollTeal:
             findTeal();
             break;

         case R.id.btnBHome:
             Home();
             break;
     }

    }
}
