package com.example.alex.wingshooterspocketapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LogRegMainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_reg_main);

        Button btnLogin = findViewById(R.id.btnLog);
        btnLogin.setOnClickListener(this);

        Button btnRegister = findViewById(R.id.btnReg);
        btnRegister.setOnClickListener(this);
    }



    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.btnLog:
                HomeScreen();
                break;

            case R.id.btnReg:
               LoginRegister();
                break;
        }

    }

    public void HomeScreen()
    {
        Intent intent = new Intent(this, Home_Screen.class);
        startActivity(intent);
        finish();
    }

    public void LoginRegister()
    {
        Intent intent = new Intent(this, LoginRegister.class);
        startActivity(intent);
        finish();
    }
}
