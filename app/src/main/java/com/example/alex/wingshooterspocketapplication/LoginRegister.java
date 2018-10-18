package com.example.alex.wingshooterspocketapplication;

import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class LoginRegister extends AppCompatActivity implements View.OnClickListener {
    //variables for login activity
    public TextView edtTxtDate;
    public TextView edtTxtName;
    public TextView edtTxtSurName;
    public TextView edtTxtInitial;
    public TextView edtTextIDNum;
    public TextView edtTextEmail;
    public TextView txtLoad;
    public Button btnSave;
    public Button btnLoad;


    public String Date = SendEmail.userDOBs;
    public String Name =SendEmail.userNames;
    public String Surname= SendEmail.userSurnames;
    public String Initials= SendEmail.userInitials;
    public String IDNum = SendEmail.userIDNums;
    public String Email= SendEmail.userEmails;

    public String UserDOB = TextFile.userDOB;
    public String UserName = TextFile.userName;
    public String UserSurname= TextFile.userSurname;
    public String UserInitials= TextFile.userInitial;
    public String UserIDNum = TextFile.userIDNum;
    public String UserEmail= TextFile.userEmail;




    public String path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/UserInfo";


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_register);

        edtTxtDate = findViewById(R.id.edtTxtDate);
        edtTxtName = findViewById(R.id.edtTxtName);
        edtTxtSurName = findViewById(R.id.edtTxtSurName);
        edtTxtInitial = findViewById(R.id.edtTxtInitials);
        edtTextIDNum = findViewById(R.id.edtTextIDNum);
        edtTextEmail = findViewById(R.id.edtTextEmail);

        btnSave = findViewById(R.id.btnSave);




        Date = edtTxtDate.getText().toString();
        Name = edtTxtName.getText().toString();
        Surname = edtTxtSurName.getText().toString();
        Initials = edtTxtInitial.getText().toString();
        IDNum = edtTextIDNum.getText().toString();
        Email = edtTextEmail.getText().toString();

        UserDOB = edtTxtDate.getText().toString();
        UserName = edtTxtName.getText().toString();
        UserSurname = edtTxtSurName.getText().toString();
        UserInitials = edtTxtInitial.getText().toString();
        UserIDNum = edtTextIDNum.getText().toString();
        UserEmail = edtTextEmail.getText().toString();



        Button btnCreateFile = findViewById(R.id.btnCreateFile);
        btnCreateFile.setOnClickListener(this);

        File dir = new File(path);
        dir.mkdirs();
    }

    public void buttonbtnSave (View view)

    {
        File file = new File (path + "/savedFile.txt");
        String [] saveDate = String.valueOf(edtTxtDate.getText()).split(System.getProperty("line.separator"));
        edtTxtDate.setText("");
        String [] saveName = String.valueOf(edtTxtName.getText()).split(System.getProperty("line.separator"));
        edtTxtName.setText("");
        String [] saveSurname = String.valueOf(edtTxtSurName.getText()).split(System.getProperty("line.separator"));
        edtTxtSurName.setText("");
        String [] saveInitials = String.valueOf(edtTxtInitial.getText()).split(System.getProperty("line.separator"));
        edtTxtInitial.setText("");
        String [] saveID = String.valueOf(edtTextIDNum.getText()).split(System.getProperty("line.separator"));
        edtTextIDNum.setText("");
        String [] saveEmail = String.valueOf(edtTextEmail.getText()).split(System.getProperty("line.separator"));
        edtTextEmail.setText("");

        Toast.makeText(getApplicationContext(), "Saved", Toast.LENGTH_LONG).show();

        Save (file, saveDate);
        Save (file, saveName);
        Save (file, saveSurname);
        Save (file, saveInitials);
        Save (file, saveID);
        Save (file, saveEmail);
    }


    public void buttonLoad(View view)
    {
        File file = new File(path + "/SavedFile.txt");
        String [] loadText = Load(file);

        String finalString = "";

        for (int i = 0; i < loadText.length; i++)
        {
            finalString += loadText[i] + System.getProperty("line.separator");
        }

        txtLoad.setText(finalString);
    }
    public static void Save(File file, String[] data)
    {
        FileOutputStream fos = null;
        try
        {
            fos = new FileOutputStream(file);
        }
        catch (FileNotFoundException e) {e.printStackTrace();}
        try
        {
            try
            {
                for (int i = 0; i<data.length; i++)
                {
                    fos.write(data[i].getBytes());
                    if (i < data.length-1)
                    {
                        fos.write("\n".getBytes());
                    }
                }
            }
            catch (IOException e) {e.printStackTrace();}
        }
        finally
        {
            try
            {
                fos.close();
            }
            catch (IOException e) {e.printStackTrace();}
        }
    }
    public static String[] Load(File file)
    {
        FileInputStream fis = null;
        try
        {
            fis = new FileInputStream(file);
        }
        catch (FileNotFoundException e) {e.printStackTrace();}
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);

        String test;
        int anzahl=0;
        try
        {
            while ((test=br.readLine()) != null)
            {
                anzahl++;
            }
        }
        catch (IOException e) {e.printStackTrace();}

        try
        {
            fis.getChannel().position(0);
        }
        catch (IOException e) {e.printStackTrace();}

        String[] array = new String[anzahl];

        String line;
        int i = 0;
        try
        {
            while((line=br.readLine())!=null)
            {
                array[i] = line;
                i++;
            }
        }
        catch (IOException e) {e.printStackTrace();}
        return array;
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnCreateFile:
                MailSenderActivity();
                break;

        }
    }
    public void MailSenderActivity() {
        Intent intent = new Intent(this, TextFile.class);
        startActivity(intent);
        finish();





    }


}