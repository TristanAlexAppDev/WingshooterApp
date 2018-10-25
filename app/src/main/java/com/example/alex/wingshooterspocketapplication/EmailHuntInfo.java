package com.example.alex.wingshooterspocketapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.File;

public class EmailHuntInfo extends AppCompatActivity
{
    public static String userName = LogRegMainActivity.userName;
    public static String userSurname = LogRegMainActivity.lastName;
    public static String userIDNum = LogRegMainActivity.idNum;
    public static String userHuntLog = StartHunt.huntContent;
    public String huntDate = NewHunt.DateofHunt;
    public String ActivityName = NewHunt.huntName;
    public String activityType = NewHunt.activityType;
    public String Location = NewHunt.actLocation;
    public String clubName = NewHunt.actClub;
    public String province = NewHunt.actProvince;
    public String District = NewHunt.actDistrict;
    public String OtherInfo = NewHunt.optionalInfo;

    Button Send;
    EditText mEditText;
    TextView txtView;
    EditText textInput;

    private static final String FILE_NAME = "UserInfo.txt";
    private TextView textView = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sendemail);

        getSupportActionBar().setTitle("Verify");


        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v)
            {

                String emailAddressList[] = {"wingshootersapp@gmail.com"};

                String mycontent ="The Following user has made the following report:"+ "\n" +"\n"
                        + "First name - " + userName+ "\n"
                        + "Surname - " + userSurname + "\n"
                        + "ID Number - " + userIDNum+
                        "\n"+"\n"
                        + "Date - " + huntDate + "\n"
                        + "Activity Name - " + ActivityName + "\n"
                        + "Activity type - " + activityType + "\n"
                        + "Location - " + Location + "\n"
                        + "Club Name - " + clubName + "\n"
                        + "Province - " + province + "\n"
                        + "District - " + District + "\n"
                        + "Other Info - " + OtherInfo + "\n"
                        + "LOGS - " + userHuntLog;

               // String HuntingInfo="HuntingInfo.txt";
                //File filelocation = new File(Environment.getExternalStorageDirectory().getAbsolutePath(),HuntingInfo);
               // Uri path = Uri.fromFile(filelocation);

                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_SUBJECT, "Hunting Information");
                email.setType("plain/text");
                email.putExtra(Intent.EXTRA_EMAIL, emailAddressList);
                email.putExtra(Intent.EXTRA_TEXT, mycontent);
               // email.putExtra(Intent.EXTRA_STREAM,path);
                startActivity(Intent.createChooser(email, "Select Your Email Client:"));
            }
        });
    }
}
