package com.example.alex.wingshooterspocketapplication;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Date;

public class SendEmail extends AppCompatActivity implements View.OnClickListener {
    public static String userName;
    public static String userSurname;
    public static String userIDNum;

    Button button;
    EditText mEditText;
    TextView txtView;
    EditText textInput;
<<<<<<< HEAD
    public String testString = "this is a test";
    public static String userDOBs;
=======

>>>>>>> a0e8f2f6f2f33a17e9033404da6a9f7735904f24
    public static String userNames;
    public static String userSurnames;
    public static String userIDNums;

    private static final String FILE_NAME = "UserInfo.txt";
    private TextView textView = null;
    String textContent = userDOBs +" " + userNames + " " + userSurnames +" "+ userInitials+ " " + userIDNums + " " + userEmails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sendemail);

<<<<<<< HEAD
        getSupportActionBar().setTitle("Send Information");
=======



        //String textContent = userDOBs +" " + userNames + " " + userSurnames +" "+ userInitials+ " " + userIDNums + " " + userEmails;
        //EditText editText = (EditText) findViewById(R.id.editText);
       // editText.setText("User details" + "\n" + "Date of Birth - "+userDOBs+ "\n" + "First Name - " + userNames + "\n" + "Surname - " + userSurnames + "\n" + "Initials - " + userInitials + "\n" + "ID Number - " + userIDNums + "\n" + "Email - "+userEmails);
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

>>>>>>> a0e8f2f6f2f33a17e9033404da6a9f7735904f24
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v)
            {
                String DateOfBirth = userDOBs;
                String FirstName = userNames;
                String Surname = userSurnames;
                String Initials = userInitials;
                String IDNum = userIDNums;
                String Email = userEmails;
                String emailAddressList[] = {"wingshooterapp@gmail.com"};
                String mycontent = userDOBs + "\n" + FirstName + "\n" + Surname + "\n" + Initials + "\n" + IDNum + "\n" + Email +"\n" + testString;
                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_SUBJECT, "Hunting Information");
                email.setType("plain/text");
                email.putExtra(Intent.EXTRA_EMAIL, emailAddressList);
                email.putExtra(Intent.EXTRA_TEXT, mycontent);
                startActivity(Intent.createChooser(email, "Select Your Email Client:"));
            }
        });
    }

    @Override
    public void onClick(View v) {
        textInput = findViewById(R.id.edit_text);
        //textInput.setText(textContent);
    }
    public void button_save(View v) {
        String text = textInput.getText().toString();
        FileOutputStream fos = null;


        try {
            fos = openFileOutput(FILE_NAME, MODE_PRIVATE);
            fos.write(text.getBytes());

            //txtView.getText().clear();
            Toast.makeText(this, "Saved to " + getFilesDir() + "/" + FILE_NAME,
                    Toast.LENGTH_LONG).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void button_load(View v) {
        FileInputStream fis = null;

        try {
            fis = openFileInput(FILE_NAME);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String text;

            while ((text = br.readLine()) != null) {
                sb.append(text).append("\n");
            }

            textInput.setText(sb.toString());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}




