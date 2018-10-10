package com.example.alex.wingshooterspocketapplication;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class LoginRegister extends AppCompatActivity {

    public TextView edtTxtDate;
    public TextView edtTxtName;
    public TextView edtTxtSurName;
    public TextView edtTxtInitials;
    public TextView edtTextIDNum;
    public TextView edtTextEmail;
    public Button btnSubmit;


public String path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/UserInfo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_register);

        edtTxtDate = (TextView) findViewById(R.id.edtTxtDate);
        edtTxtName = (TextView) findViewById(R.id.edtTxtName);
        edtTxtSurName = (TextView) findViewById(R.id.edtTxtSurName);
        edtTxtInitials = (TextView) findViewById(R.id.edtTxtInitials);
        edtTextIDNum = (TextView) findViewById(R.id.edtTextIDNum);
        edtTextEmail = (TextView) findViewById(R.id.edtTextEmail);
        btnSubmit = (Button) findViewById(R.id.btnSubmit);

        File dir = new File(path);
        dir.mkdirs();
    }

    public void buttonSubmit(View view)
    {
        File file = new File(path + "/SavedData.txt");
        String [] saveDate = String.valueOf(edtTxtDate.getText()).split(System.getProperty("line.seperator"));
        edtTxtDate.setText("");
        String [] saveName = String.valueOf(edtTxtName.getText()).split(System.getProperty("line.seperator"));
        edtTxtName.setText("");
        String [] saveSurname = String.valueOf(edtTxtSurName.getText()).split(System.getProperty("line.seperator"));
        edtTxtSurName.setText("");
        String [] saveInitials = String.valueOf(edtTxtInitials.getText()).split(System.getProperty("line.seperator"));
        edtTxtInitials.setText("");
        String [] saveID = String.valueOf(edtTxtIDNum.getText()).split(System.getProperty("line.seperator"));
        edtTxtIDNum.setText("");
        String [] saveEmail = String.valueOf(edtTxtEmail.getText()).split(System.getProperty("line.seperator"));
        edtTxtEmail.setText("");

        Save (file, saveDate,saveName,saveSurname,saveInitials,saveID,saveEmail);
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
}
