package com.example.alex.wingshooterspocketapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NewHunt extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_hunt);

        Button btnNHunt = findViewById(R.id.btnStart);
        btnNHunt.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        switch(v.getId())
        {
            case R.id.BtnAdd:
                new StartHunt();
                break;
        }
    }
}
