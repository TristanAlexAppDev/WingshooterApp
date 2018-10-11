package com.example.alex.wingshooterspocketapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NewHunt extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_hunt);
        setTitle("NEW HUNT");

        Button btnNHunt = findViewById(R.id.btnStart);
        btnNHunt.setOnClickListener(this);

        Button btnSave = findViewById(R.id.btnSave);
        btnSave.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        switch(v.getId())
        {
            case R.id.BtnAdd:
                StartHunt();
                break;

            case R.id.btnSave:
                saveHunt();
                break;
        }
    }

    public void StartHunt()
    {
        Intent intent = new Intent(this, StartHunt.class);
        startActivity(intent);
        finish();
    }

    public void saveHunt()
    {
        Intent intent = new Intent(this, NewHunt.class);
        startActivity(intent);
        finish();
    }
}
