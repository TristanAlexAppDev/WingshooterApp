package com.example.alex.wingshooterspocketapplication;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.TextView;
import android.app.Activity;

public class CreateTextFile extends Activity {

    // our TextFileHelper
    TextFileHelper TextFileH;

    // where our text file will be created
    String filePath = Environment.getExternalStorageDirectory() + "/MikeDalisayFolder/";

    // name of our text file
    String fileName = "coan_log_file.txt";

    // filePath and fileName combined
    String actualFile = filePath + fileName;

    TextView contentsTextView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createtextfile);

        try {

            // initialize our TextFileHelper here
            TextFileH = new TextFileHelper(CreateTextFile.this);

            // first, make sure the path to your text file is created
            TextFileH.createPath(filePath);

            // so we can show file contents to the user
            contentsTextView = (TextView) findViewById(R.id.contentsTextView);

            // here is the actual button listener
            View.OnClickListener handler = new View.OnClickListener() {

                public void onClick(View v) {

                    // we will use switch statement and just
                    // get the button’s id to make things easier
                    switch (v.getId()) {

                        // when create button was clicked
                        case R.id.createBtn:
                            TextFileH.createTextFile(actualFile);
                            contentsTextView.setText("");
                            break;

                        // when read button was clicked
                        case R.id.readBtn:
                            String contents = TextFileH.readTextFile(actualFile);
                            contentsTextView.setText(contents);
                            break;

                        // when update button was clicked
                        case R.id.updateBtn:
                            TextFileH.updateTextFile(actualFile, "Mike is so handsome!nNew line here!");
                            contentsTextView.setText("");
                            break;

                        // when edit button was clicked
                        case R.id.deleteBtn:
                            TextFileH.deleteTextFile(actualFile);
                            contentsTextView.setText("");
                            break;
                    }
                }
            };

            // we will get the button views and set the listener (handler)
            findViewById(R.id.createBtn).setOnClickListener(handler);
            findViewById(R.id.readBtn).setOnClickListener(handler);
            findViewById(R.id.updateBtn).setOnClickListener(handler);
            findViewById(R.id.deleteBtn).setOnClickListener(handler);

        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

