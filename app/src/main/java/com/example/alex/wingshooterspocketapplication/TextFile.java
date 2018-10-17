package com.example.alex.wingshooterspocketapplication;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TextFile extends AppCompatActivity implements View.OnClickListener {

    public static String userDOB;
    public static String userName;
    public static String userSurname;
    public static String userInitial;
    public static String userIDNum;
    public static String userEmail;

    private static final String FILENAME = "userInfo.txt";
    private Button btnSend;
    private EditText editText;
    private FileWriter writer;
    private String emailBody;

    EditText textmsg;
    static final int READ_BLOCK_SIZE = 100;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_textfile);

        textmsg=(EditText)findViewById(R.id.editText1);

      //  btnSend = (Button)findViewById(R.id.button);
        //btnSend.setOnClickListener(this);

        //editText = (EditText)findViewById(R.id.editText);

        //emailBody = "This is email from '" + getString(R.string.app_name ) + "' application. Details you can read here: https://www.hrupin.com/2014/12/send-email-with-text-file-as-attachment-android-sample";


    }
    @Override
    public void onClick(View view){
        File fileToSend = createFileWithContent(editText.getText().toString());

        sendIntentToGmailApp(fileToSend);
    }

    private void sendIntentToGmailApp(File fileToSend) {
        if(fileToSend != null){
            Intent email = new Intent(Intent.ACTION_SEND);
            email.putExtra(Intent.EXTRA_SUBJECT, "Send Text File As Attachment Example");
            email.putExtra(Intent.EXTRA_TEXT, emailBody);
            email.putExtra(Intent.EXTRA_STREAM, Uri.parse("file://" + fileToSend.getAbsoluteFile()));
            email.setType("message/rfc822");
            startActivity(Intent.createChooser(email , "Send Text File"));
        }
    }
    private File createFileWithContent(String content) {
        if(TextUtils.isEmpty(content)){
            content = emailBody;
        }
        File file = null;
        try{
            file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), FILENAME);

            writer = new FileWriter(file);
            writer.write(content);
            writer.close();
            Toast.makeText(getBaseContext(), "Temporarily saved contents in " + file.getPath(), Toast.LENGTH_LONG).show();
        }catch(IOException e){
            Toast.makeText(getBaseContext(), "Unable create temp file. Check logcat for stackTrace", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
        return file;
    }


    // write text to file
    public void WriteBtn(View v) {
        // add-write text into file
        try {
            FileOutputStream fileout=openFileOutput("userInfo.txt", MODE_PRIVATE);
            OutputStreamWriter outputWriter=new OutputStreamWriter(fileout);
            outputWriter.write(textmsg.getText().toString());
            outputWriter.close();

            //display file saved message
            Toast.makeText(getBaseContext(), "File saved successfully!",
                    Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Read text from file
    public void ReadBtn(View v) {
        //reading text from file
        try {
            FileInputStream fileIn=openFileInput("userInfo.txt");
            InputStreamReader InputRead= new InputStreamReader(fileIn);

            char[] inputBuffer= new char[READ_BLOCK_SIZE];
            String s="";
            int charRead;

            while ((charRead=InputRead.read(inputBuffer))>0) {
                // char to string conversion
                String readstring=String.copyValueOf(inputBuffer,0,charRead);
                s +=readstring;
            }
            InputRead.close();
            Toast.makeText(getBaseContext(), s,Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

      /*  public void verifyBtn (View v){
       String filename="userInfo.txt";
        File filelocation = new File(Environment.getExternalStorageDirectory().getAbsolutePath(), filename);
        Uri path = Uri.fromFile(filelocation);
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
// set the type to 'email'
        emailIntent .setType("vnd.android.cursor.dir/email");
        String to[] = {"markvdburgh@gmail.com"};
        emailIntent .putExtra(Intent.EXTRA_EMAIL, to);
// the attachment
        emailIntent .putExtra(Intent.EXTRA_STREAM, path);
// the mail subject
        emailIntent .putExtra(Intent.EXTRA_SUBJECT, "User Information");
        startActivity(Intent.createChooser(emailIntent , "Send email..."));
       } */

   /* public void verifyBtn(String folder_name, String file_name) {
        try {
            File Root= Environment.getExternalStorageDirectory();
            String filelocation=Root.getAbsolutePath() + folder_name + "/" + file_name;
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setType("text/plain");
            String message="File to be shared is " + file_name + ".";
            intent.putExtra(Intent.EXTRA_SUBJECT, "Subject");
            intent.putExtra(Intent.EXTRA_STREAM, Uri.parse( "file://"+filelocation));
            intent.putExtra(Intent.EXTRA_TEXT, message);
            intent.setData(Uri.parse("mailto:xyz@gmail.com"));
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            startActivity(intent);
        } catch(Exception e)  {
            System.out.println("is exception raises during sending mail"+e);
        }
    } */
}
