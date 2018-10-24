package com.example.alex.wingshooterspocketapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;


public class LoginRegister extends AppCompatActivity implements View.OnClickListener
{
    private String TAG;
    //variables for login activity

    public TextView edtTextIDNum;
    public TextView edtTextEmail;
    public TextView edttxtPass;
    public TextView edttxtPass2;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_register);
        getSupportActionBar().setTitle("Register your Info");

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
        String userID = "ID" + edtTextIDNum.getText().toString();
        String pass1 = edttxtPass.getText().toString();
        String pass2 = edttxtPass2.getText().toString();
        String email = edtTextEmail.getText().toString();
        if (pass1.equals("") || pass2.equals("") || userID.equals("")|| email.equals(""))
        {
            Toast.makeText(getApplicationContext(), "Some fields are missing, please try again", Toast.LENGTH_LONG).show();
            edtTextIDNum.setText("");
            edttxtPass2.setText("");
            edttxtPass.setText("");
            edtTextEmail.setText("");
        }
        else
        {
            if (pass1.matches(pass2))
            {
                searchData(userID, pass1, email);
            }
            else
            {
                Toast.makeText(getApplicationContext(), "Passwords do not match", Toast.LENGTH_LONG).show();
                edttxtPass2.setText("");
                edttxtPass.setText("");
            }
        }
    }

    private void searchData(final String userID, final String pass1, final String email)
    {
        final DatabaseReference fdb = FirebaseDatabase.getInstance().getReference();
        Query query = fdb.child("userTable").orderByChild("IDNumber").equalTo(userID);
        query.addListenerForSingleValueEvent(new ValueEventListener()
        {
            public String TAG;

            @Override
            public void onDataChange(DataSnapshot dataSnapshot)
            {
                if (dataSnapshot.exists())
                {
                    for (DataSnapshot user : dataSnapshot.getChildren())
                    {
                        LoginInfoFirebasedb userLogin = user.getValue(LoginInfoFirebasedb.class);

                        if (userLogin.Password.equals(pass1))
                        {
                            if (userLogin.Email.equals(email))
                            {
                                finallyDone(userID);
                            }
                            else
                            {
                                Toast.makeText(LoginRegister.this, "Emails do not match", Toast.LENGTH_LONG).show();
                                edtTextEmail.setText("");
                            }
                        }
                        else {
                            Toast.makeText(LoginRegister.this, "Password does not match", Toast.LENGTH_LONG).show();
                            edttxtPass.setText("");
                            edttxtPass2.setText("");
                            edtTextEmail.setText("");
                        }
                    }
                }
                else {
                    Toast.makeText(LoginRegister.this, "ID number not found, Please contact Wingshooters", Toast.LENGTH_LONG).show();
                    edtTextEmail.setText("");
                    edttxtPass2.setText("");
                    edttxtPass.setText("");
                    edtTextIDNum.setText("");
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError)
            {
                Log.d(TAG, "Error trying to register profile" + databaseError);
            }
        });
    }

    private void finallyDone(final String userID)
    {
        final DatabaseReference fdb = FirebaseDatabase.getInstance().getReference();
        Query query = fdb.child("userTable").orderByChild("IDNumber").equalTo(userID);
        query.addListenerForSingleValueEvent(new ValueEventListener()
        {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                for (DataSnapshot childsnapshot : dataSnapshot.getChildren())
                {
                    String key = childsnapshot.getKey();

                    try
                    {
                        fdb.child("userTable").child(key).child("certifiedUser").setValue("Yes");
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }

                    Toast.makeText(getApplicationContext(), "Profile created, please login now.", Toast.LENGTH_LONG).show();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Intent i = new Intent(LoginRegister.this, LogRegMainActivity.class);
                            startActivity(i);
                            finish();
                        }
                    }, 1750);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError)
            {
                Log.d(userID, "Unable to check database for " + databaseError);
            }
        });
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