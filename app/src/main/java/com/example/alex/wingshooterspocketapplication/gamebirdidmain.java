package com.example.alex.wingshooterspocketapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
//import android.view.Window;
import android.widget.Button;

import android.widget.Button;

public class gamebirdidmain extends AppCompatActivity implements View.OnClickListener
{

    @Override

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        //YOU KNOW HERS IS BIGGER THAN YOURS MASTER ALEX...
        /*requestWindowFeature(Window.FEATURE_NO_TITLE);*/
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

        Button PartridgeScreen = findViewById(R.id.btnreturnPart);
        PartridgeScreen.setOnClickListener(this);

        Button btnRetDuck = findViewById(R.id.btnReturnDuck);
        btnRetDuck.setOnClickListener(this);

        Button btnRetFranc = findViewById(R.id.btnReturnFranc);
        btnRetFranc.setOnClickListener(this);

        Button btnRetGees = findViewById(R.id.btnReturnGeese);
        btnRetGees.setOnClickListener(this);

        Button btnRetGro = findViewById(R.id.btnReturnGrouse);
        btnRetGro.setOnClickListener(this);

        Button btnRetGF = findViewById(R.id.btnReturnGuine);
        btnRetGF.setOnClickListener(this);

        Button btnRetPart = findViewById(R.id.btnReturnPartridge);
        btnRetPart.setOnClickListener(this);

        Button btnRetPig = findViewById(R.id.btnReturnPigeon);
        btnRetPig.setOnClickListener(this);

        Button btnRetQua = findViewById(R.id.btnReturnQuail);
        btnRetQua.setOnClickListener(this);

        Button btnRetSnipe = findViewById(R.id.btnReturnSnipe);
        btnRetSnipe.setOnClickListener(this);

        Button btnRetTeal = findViewById(R.id.btnReturnTeal);
        btnRetTeal.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            //-------------Code for buttons on this screen-------------------------
            case R.id.btnGBHome:
                Intent i = new Intent(this, Home_Screen.class);
                startActivity(i);
                finish();
                break;

            case R.id.btnDucks:
                setContentView(R.layout.idduck);
                /*Intent i1 = new Intent(setContentView(););
                startActivity(i1);*/
                break;

            case R.id.btnQuail:
                setContentView(R.layout.idquail);
                break;

            case R.id.btnGeese:
                setContentView(R.layout.idgeese);
                break;

            case R.id.btnFowl:
                setContentView(R.layout.idguiniefowl);
                break;

            case R.id.btnfranc:
                setContentView(R.layout.idfrancolin);
                break;

            case R.id.btnpartridge:
                setContentView(R.layout.idpartridge);
                break;

            case R.id.btnPigeons:
                setContentView(R.layout.idpigeons);
                break;

            case R.id.btnTeal:
                setContentView(R.layout.idteal);
                break;

            case R.id.btnsnipe:
                setContentView(R.layout.idsnipe);
                break;

            case R.id.btnGrouse:
                setContentView(R.layout.idgrouse);
                break;

                //---------------Other buttons code-----------------/
            case R.id.btnReturnDuck:
                setContentView(R.layout.gamebirdidmain);
                finish();
                break;

            case R.id.btnReturnFranc:
                setContentView(R.layout.gamebirdidmain);
                finish();
                break;

            case R.id.btnReturnGeese:
                setContentView(R.layout.gamebirdidmain);
                finish();
                break;

            case R.id.btnReturnGrouse:
                setContentView(R.layout.gamebirdidmain);
                finish();
                break;

            case R.id.btnReturnGuine:
                setContentView(R.layout.gamebirdidmain);
                finish();
                break;

            case R.id.btnReturnPartridge:
                setContentView(R.layout.gamebirdidmain);
                finish();
                break;

            case R.id.btnReturnPigeon:
                setContentView(R.layout.gamebirdidmain);
                finish();
                break;

            case R.id.btnReturnQuail:
                setContentView(R.layout.gamebirdidmain);
                finish();
                break;

            case R.id.btnReturnSnipe:
                setContentView(R.layout.gamebirdidmain);
                finish();
                break;

            case R.id.btnReturnTeal:
                setContentView(R.layout.gamebirdidmain);
                finish();
                break;


        }
    }

    public void showDuck()
    {
        setContentView(R.layout.gamebirdidmain);

    }
}
