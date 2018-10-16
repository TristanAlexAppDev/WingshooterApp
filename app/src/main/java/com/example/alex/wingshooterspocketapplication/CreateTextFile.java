package com.example.alex.wingshooterspocketapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.app.Activity;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class CreateTextFile extends Activity {

    private static final String FILE_NAME = "UserInfo.txt";


    public static String userDOB;
    public static String userName;
    public static String userSurname;
    public static String userInitial;
    public static String userIDNum;
    public static String userEmail;

    public static String userDOBs;
    public static String userNames;
    public static String userSurnames;
    public static String userInitials;
    public static String userIDNums;
    public static String userEmails;
    Button button;
    EditText mEditText;
    TextView txtView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createtextfile);
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
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v)
            {
                String DateOfBirth = userDOB;
                String FirstName = userName;
                String Surname = userSurname;
                String Initials = userInitials;
                String IDNum = userIDNum;
                String Email = userEmail;
                String emailAddressList[] = {"markvdburgh@gmail.com"};
                String mycontent = DateOfBirth + "," + FirstName + "," + Surname + "," + Initials + "," + IDNum + "," + Email;
                Intent email = new Intent(Intent.ACTION_SEND);
                email.setType("plain/text");
                email.putExtra(Intent.EXTRA_EMAIL, emailAddressList);
                email.putExtra(Intent.EXTRA_TEXT, mycontent);
                startActivity(Intent.createChooser(email, "Select Sender:"));
            }
        });

        mEditText = findViewById(R.id.edit_text);

    }

    public void save(View v) {
        String text = mEditText.getText().toString();
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

    public void load(View v) {
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

            mEditText.setText(sb.toString());

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

