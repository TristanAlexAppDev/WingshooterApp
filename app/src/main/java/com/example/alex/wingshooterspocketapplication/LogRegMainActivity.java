package com.example.alex.wingshooterspocketapplication;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class LogRegMainActivity extends AppCompatActivity implements View.OnClickListener {

    public TextView TxtIDNUMlog;
    public TextView edttxtPassword;
    public Button btnLog;
    public static String userName = "";
    public static String idNum = "";
    public static String lastName = "";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_reg_main);
        getSupportActionBar().setTitle("Welcome");

        Button btnLogin = findViewById(R.id.btnLog);
        btnLogin.setOnClickListener(this);

        Button btnRegister = findViewById(R.id.btnReg);
        btnRegister.setOnClickListener(this);

        TxtIDNUMlog = findViewById(R.id.TxtIDNUMlog);
        edttxtPassword = findViewById(R.id.edttxtPassword);

        DatabaseHelper databaseHelper = new DatabaseHelper(this);

        int check = ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (check == PackageManager.PERMISSION_GRANTED)
        {
            //idi nahui
        }
        else
        {
            requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1024);
        }
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
        String userIDnum;


        userPass = edttxtPassword.getText().toString().trim();
        userIDnum = "ID" + TxtIDNUMlog.getText().toString().trim();

        if (userPass.matches("") || userIDnum.matches(""))
        {
            Toast.makeText(getApplicationContext(), "Please fill all fields", Toast.LENGTH_LONG).show();
        }
        else
        {
            //backend for admin hardcoded for display purposes
            if (userPass.equals("Admin123") && userIDnum.equals("ID199999"))
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
                }, 1750);
            }
            else{
                DataLogin(userPass, userIDnum);
            }
        }
    }

    private void DataLogin(final String userPass, final String userIDnum)
    {
        DatabaseReference fdb = FirebaseDatabase.getInstance().getReference();
        Query query = fdb.child("userTable").orderByChild("IDNumber").equalTo(userIDnum);
        query.addListenerForSingleValueEvent(new ValueEventListener()
        {
            public String TAG;

            @Override
            public void onDataChange(DataSnapshot dataSnapshot)
            {
                if (dataSnapshot.exists())
                {
                    for (DataSnapshot user : dataSnapshot.getChildren())
                    {

                        LoginInfoFirebasedb userLogin = user.getValue(LoginInfoFirebasedb.class);

                        if (userLogin.Password.equals(userPass))
                        {
                            if (userLogin.certifiedUser.isEmpty())
                            {
                                Toast.makeText(LogRegMainActivity.this, "User not registered, please register first.", Toast.LENGTH_LONG).show();
                                TxtIDNUMlog.setText("");
                                edttxtPassword.setText("");
                            }
                            else
                            {
                               idNum = userLogin.IDNumber;
                               userName = userLogin.Name;
                               lastName = userLogin.Surname;
                               Toast.makeText(getApplicationContext(), "Welcome " + userName, Toast.LENGTH_LONG).show();
                               new Handler().postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                            Intent i = new Intent(LogRegMainActivity.this, Home_Screen.class);
                                            startActivity(i);
                                            finish();
                                        }
                                    }, 1750);
                            }
                        }
                        else
                            {
                            Toast.makeText(LogRegMainActivity.this, "Password is incorrect", Toast.LENGTH_LONG).show();
                            edttxtPassword.setText("");
                        }
                    }
                }
                else {
                    Toast.makeText(LogRegMainActivity.this, "User not found", Toast.LENGTH_LONG).show();
                    TxtIDNUMlog.setText("");
                    edttxtPassword.setText("");
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError)
            {
                Log.d(TAG, "Error trying to log in for " + userIDnum + " " + databaseError);
            }
        });
    }

    public void LoginRegister()
    {
        Intent intent = new Intent(this, LoginRegister.class);
        startActivity(intent);
        finish();
    }
}

//Previously tested code that did not work with sqlite database and firebase database
//--------------------------------------------------------------------

        /*DatabaseReference fdb = FirebaseDatabase.getInstance().getReference();

        Query query = fdb.child("userTable").orderByChild("IDNumber").equalTo(userIDnum);
        query.addListenerForSingleValueEvent(new ValueEventListener()
        {
            public String TAG;

            @Override
            public void onDataChange(DataSnapshot dataSnapshot)
            {
                List<LoginInfoFirebasedb> userList = new ArrayList<LoginInfoFirebasedb>();
                for (DataSnapshot user : dataSnapshot.getChildren())
                {
                    userList.add(dataSnapshot.getValue(LoginInfoFirebasedb.class));
                }
                Log.d(TAG, "no user found of that name " + userList.size());
            }

            @Override
            public void onCancelled(DatabaseError databaseError)
            {
                Log.d(TAG, "Error trying to log in for " + userIDnum + " " + databaseError);
            }
        });*/
        /*boolean signedUp;
        boolean finalCheck;

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
        }*/


