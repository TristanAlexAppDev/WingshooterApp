package com.example.alex.wingshooterspocketapplication;

import android.os.Bundle;

import android.app.Activity;

import android.os.Environment;
import android.util.Log;

import android.view.Menu;

import android.view.View;

import android.widget.Button;

import android.widget.Toast;


public class MailSenderActivity extends Activity {

    public static String userDOB;
    public static String userName;
    public static String userSurname;
    public static String userInitial;
    public static String userIDNum;
    public static String userEmail;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mailsenderactivity);

        final Button send = (Button) this.findViewById(R.id.send);
        send.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                try {
                    GMailSender sender = new GMailSender("wingshooterapp@gmail.com", "WingShooterAdmin2018");
                    sender.sendMail("This is Subject",
                            "This is Body",
                            "wingshooterapp@gmail.com",
                            "markvdburgh@gmail.com");
                } catch (Exception e) {
                    Log.e("SendMail", e.getMessage(), e);
                }

            }
        });

    }
}









/*

public class MailSenderActivity extends Activity {

    Button send;

    public static String userDOB;
    public static String userName;
    public static String userSurname;
    public static String userInitial;
    public static String userIDNum;
    public static String userEmail;


    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_mailsenderactivity);



        send = (Button) findViewById(R.id.send);

        send.setOnClickListener(new View.OnClickListener() {



            public void onClick(View v) {

                // TODO Auto-generated method stub

                new Thread(new Runnable() {

                    public void run() {

                        try {

                            GMailSender sender = new GMailSender(

                                    "wingshooterapp@gmail.com",

                                    "WingShooterAdmin2018");



                            //sender.addAttachment(Environment.getExternalStorageDirectory().getPath()+"/image.jpg");

                            sender.sendMail("Test mail", "This mail has been sent from android app along with attachment " + userDOB,

                                    "wingshooterapp@gmail.com",

                                    "markvdburgh@gmail.com");









                        } catch (Exception e) {

                            Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_LONG).show();



                        }

                    }

                }).start();

            }

        });



    }



}
*/
