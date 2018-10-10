package com.example.alex.wingshooterspocketapplication;

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

public class LoginRegister extends AppCompatActivity {
    //variables for login activity
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

    public void buttonSave (View view)

    {
        File file = new File (path + "/savedFile.txt");
        String [] saveDate = String.valueOf(edtTxtDate.getText()).split(System.getProperty("line.seperator"));
        edtTxtDate.setText("");
        String [] saveName = String.valueOf(edtTxtName.getText()).split(System.getProperty("line.seperator"));
        edtTxtName.setText("");
        String [] saveSurname = String.valueOf(edtTxtSurName.getText()).split(System.getProperty("line.seperator"));
        edtTxtSurName.setText("");
        String [] saveInitials = String.valueOf(edtTxtInitials.getText()).split(System.getProperty("line.seperator"));
        edtTxtInitials.setText("");
        String [] saveID = String.valueOf(edtTextIDNum.getText()).split(System.getProperty("line.seperator"));
        edtTextIDNum.setText("");
        String [] saveEmail = String.valueOf(edtTextEmail.getText()).split(System.getProperty("line.seperator"));
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
}
