package com.example.alex.wingshooterspocketapplication;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class LogRegMainActivity extends AppCompatActivity implements View.OnClickListener {

    public TextView TxtIDNUMlog;
    public TextView edttxtPassword;
    public Button btnLog;
    public static String userName = "";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_reg_main);

        Button btnLogin = findViewById(R.id.btnLog);
        btnLogin.setOnClickListener(this);

        Button btnRegister = findViewById(R.id.btnReg);
        btnRegister.setOnClickListener(this);

        TxtIDNUMlog = findViewById(R.id.TxtIDNUMlog);
        edttxtPassword = findViewById(R.id.edttxtPassword);
    }



    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.btnLog:
                LoginCheck();
                break;

            case R.id.btnReg:
                LoginRegister();
                break;
        }

    }

    public void LoginCheck() {
        String userPass;
        String check;
        int userIDnum = 0;
        String dateExist = "";

        userPass = edttxtPassword.getText().toString();
        check = TxtIDNUMlog.getText().toString();

        if (userPass.matches("") || check.matches(""))
        {
            Toast.makeText(getApplicationContext(), "Please fill all fields", Toast.LENGTH_LONG).show();
        }
        else
        {
            userIDnum = Integer.parseInt(TxtIDNUMlog.getText().toString());
            //backend for admin hardcoded for display purposes
            if (userPass.equals("Admin123") && userIDnum == 199)
            {
                Toast.makeText(getApplicationContext(), "Welcome Admin", Toast.LENGTH_LONG).show();
                userName = "Admin";
                new Handler().postDelayed(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        Intent i = new Intent(LogRegMainActivity.this, Home_Screen.class);
                        startActivity(i);
                        finish();
                    }
                }, 2000);
            }
            else
            {
                Toast.makeText(getApplicationContext(), "Welcome user", Toast.LENGTH_LONG).show();
                new Handler().postDelayed(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        Intent i = new Intent(LogRegMainActivity.this, Home_Screen.class);
                        startActivity(i);
                        finish();
                    }
                }, 2000);
            }
        }
    }


    public void LoginRegister()
    {
        Intent intent = new Intent(this, LoginRegister.class);
        startActivity(intent);
        finish();
    }
}
