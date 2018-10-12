package com.example.alex.wingshooterspocketapplication;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.sql.Date;

public class SendEmail extends AppCompatActivity implements View.OnClickListener {
    public static String userDOB;
    public static String userName;
    public static String userSurname;
    public static String userInitials;
    public static String userIDNum;
    public static String userEmail;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sendemail);

       /* TextView name1 = (TextView)findViewById(R.id.name1);
        final EditText name = (EditText)findViewById(R.id.name);
        TextView email1 = (TextView)findViewById(R.id.email1);
        final EditText email = (EditText)findViewById(R.id.email);
        TextView date1 =(TextView)findViewById(R.id.date1);
        final EditText date = (EditText)findViewById(R.id.date);
        TextView time1 = (TextView)findViewById(R.id.time1);
        final EditText time = (EditText)findViewById(R.id.time);
        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() */
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                String DateOfBirth = userDOB;
                String FirstName = userName;
                String Surname = userSurname;
                String Initials = userInitials;
                String IDNum = userIDNum;
                String Email = userEmail;
                String emailAddressList[] = {"emailAddress"};
                String mycontent = DateOfBirth + "," + FirstName + "," + Surname + "," + Initials + "," + IDNum + "," + Email;
                Intent email = new Intent(Intent.ACTION_SEND);
                email.setType("plain/text");
                email.putExtra(Intent.EXTRA_EMAIL, emailAddressList);
                email.putExtra(Intent.EXTRA_TEXT, mycontent);
                startActivity(Intent.createChooser(email, "Select Sender:"));
            }
        });
    }

    @Override
    public void onClick(View v) {

    }
}




