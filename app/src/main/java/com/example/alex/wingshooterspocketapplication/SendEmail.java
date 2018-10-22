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

public class SendEmail extends AppCompatActivity implements View.OnClickListener
{
    public static String userName = LogRegMainActivity.userName;
    public static String userSurname = LogRegMainActivity.lastName;
    public static String userIDNum = LogRegMainActivity.idNum;

    Button button;
    EditText mEditText;
    TextView txtView;
    EditText textInput;

    public String testString = "this is a test";
    public static String userDOBs;

<<<<<<< HEAD
=======


>>>>>>> 12dcd044e3dd96949707480bc270c41bd4ea20d8
    public static String userNames;
    public static String userSurnames;
    public static String userIDNums;

    private static final String FILE_NAME = "UserInfo.txt";
    private TextView textView = null;
<<<<<<< HEAD
    String textContent = userDOBs + " " + userNames + " " + userSurnames +" " + userIDNums;
=======
>>>>>>> 12dcd044e3dd96949707480bc270c41bd4ea20d8

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sendemail);

<<<<<<< HEAD
=======

>>>>>>> 12dcd044e3dd96949707480bc270c41bd4ea20d8
        getSupportActionBar().setTitle("Send Information");




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

<<<<<<< HEAD
=======

>>>>>>> 12dcd044e3dd96949707480bc270c41bd4ea20d8
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v)
            {
                String DateOfBirth = userDOBs;
                String FirstName = userNames;
                String Surname = userSurnames;
                String IDNum = userIDNums;
                String emailAddressList[] = {"wingshooterapp@gmail.com"};
<<<<<<< HEAD
                String mycontent = userDOBs + "\n" + FirstName + "\n" + Surname + "\n" + IDNum + "\n" + testString;
=======
                String mycontent = userDOBs + "\n" + FirstName + "\n" + Surname + "\n" + IDNum + "\n" +testString;
>>>>>>> 12dcd044e3dd96949707480bc270c41bd4ea20d8
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




