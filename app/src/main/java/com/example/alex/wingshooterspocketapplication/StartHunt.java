package com.example.alex.wingshooterspocketapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StartHunt extends AppCompatActivity implements  View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_hunt);
        getSupportActionBar().setTitle("Active Hunt");

        Button btnAdding = findViewById(R.id.BtnAdd);
        btnAdding.setOnClickListener(this);
    }


    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.BtnAdd:
                NewBird();
                break;
        }
    }

    public void NewBird()
    {
        Intent intent = new Intent(this, LogActivity.class);
        startActivity(intent);
        finish();

    }
}
