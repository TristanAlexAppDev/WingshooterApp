package com.example.alex.wingshooterspocketapplication;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.sql.SQLException;

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

    public void LoginCheck()
    {
        String userPass;
        String check;
        String userIDnum;
        boolean signedUp = false;
        boolean finalCheck = false;

        userPass = edttxtPassword.getText().toString();
        userIDnum = TxtIDNUMlog.getText().toString();

        DatabaseHelper login = new DatabaseHelper(this);

        try
        {
            login.createDatabase();
        }
        catch (IOException ioe)
        {
            throw new  Error("unable to create database");
        }

        try
        {
            login.openDatabase();
        }
        catch (android.database.SQLException sqle)
        {
            throw sqle;
        }


        if (userPass.matches("") || userIDnum.matches(""))
        {
            Toast.makeText(getApplicationContext(), "Please fill all fields", Toast.LENGTH_LONG).show();
        }
        else
        {
            //backend for admin hardcoded for display purposes
            if (userPass.equals("Admin123") && userIDnum.equals("199"))
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
                signedUp = login.checkLogin(userPass, userIDnum);
                if (!signedUp)
                {
                    Toast.makeText(getApplicationContext(), "You are not a registered user or your password or username is incorrect." +
                            ".", Toast.LENGTH_LONG).show();
                    TxtIDNUMlog.setText("");
                    edttxtPassword.setText("");
                }
                else
                {
                    //check if user is registered

                    finalCheck = login.registeredUser(userIDnum);

                    if (!finalCheck)
                    {
                        Toast.makeText(getApplicationContext(), "User exists, but not registered. Please register before logging in.", Toast.LENGTH_LONG).show();
                        TxtIDNUMlog.setText("");
                        edttxtPassword.setText("");
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
        }
    }


    public void LoginRegister()
    {
        Intent intent = new Intent(this, LoginRegister.class);
        startActivity(intent);
        finish();
    }
}
