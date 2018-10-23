package com.example.alex.wingshooterspocketapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class EmailHuntInfo extends AppCompatActivity {




    public static String userName = LogRegMainActivity.userName;
    public static String userSurname = LogRegMainActivity.lastName;
    public static String userIDNum = LogRegMainActivity.idNum;

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

                String emailAddressList[] = {"wingshooterapp@gmail.com"};

                String mycontent ="The Following user has made the following report:"+ "\n"
                        + "First name - " + "First name goes here"+ "\n"
                        + "Surname - " + "Surname goes here" + "\n"
                        + "ID Number - " + " ID Number goes here"+
                        "\n"+"\n"
                        +"Reports go here";

                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_SUBJECT, "Hunting Information");
                email.setType("plain/text");
                email.putExtra(Intent.EXTRA_EMAIL, emailAddressList);
                email.putExtra(Intent.EXTRA_TEXT, mycontent);
                startActivity(Intent.createChooser(email, "Select Your Email Client:"));
            }
        });
    }
}
