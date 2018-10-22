package com.example.alex.wingshooterspocketapplication;

import android.content.Intent;
import android.os.Environment;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;



public class LoginRegister extends AppCompatActivity implements View.OnClickListener
{
    //variables for login activity

    public TextView edtTextIDNum;
    public TextView edtTextEmail;
    public TextView edttxtPass;
    public TextView edttxtPass2;

/*
    public String UserDOB = MailSenderActivity.userDOB;
    public String UserName = MailSenderActivity.userName;
    public String UserSurname= MailSenderActivity.userSurname;
    public String UserInitials= MailSenderActivity.userInitial;
    public String UserIDNum = MailSenderActivity.userIDNum;
    public String UserEmail= MailSenderActivity.userEmail;
    */


    public String path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/UserInfo";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_register);
        getSupportActionBar().setTitle("Register for App");

        edtTextIDNum = findViewById(R.id.edtTextIDNum);
        edtTextEmail = findViewById(R.id.edtTextEmail);
        edttxtPass = findViewById(R.id.edttxtPass1);
        edttxtPass2 = findViewById(R.id.edttxtPass2);

        Button btnCreateFile = findViewById(R.id.btnCreateReg);
        btnCreateFile.setOnClickListener(this);

        //File dir = new File(path);
        //dir.mkdirs();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnCreateReg:
                InfoCheck();
                break;

        }
    }

    public void InfoCheck()
    {
        String userID = edtTextIDNum.getText().toString();
        if (edttxtPass.equals("") || edttxtPass2.equals("") || edtTextEmail.equals("") || edtTextIDNum.equals(""))
        {
            Toast.makeText(getApplicationContext(), "Some fields are missing, please try again", Toast.LENGTH_LONG).show();
            edtTextIDNum.setText("");
            edttxtPass2.setText("");
            edttxtPass.setText("");
            edtTextEmail.setText("");
        }
        else
        {
            if (edttxtPass.equals(edttxtPass2))
            {


                searchData();
            }
            else
            {
                Toast.makeText(getApplicationContext(), "Passwords do not match", Toast.LENGTH_LONG).show();
                edttxtPass2.setText("");
                edttxtPass.setText("");
            }
        }







        Toast.makeText(getApplicationContext(), "Profile registered for the app, please Login.", Toast.LENGTH_LONG).show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(LoginRegister.this, LogRegMainActivity.class);
                startActivity(i);
                finish();
            }
        }, 1500);
    }
}
/*
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
*/