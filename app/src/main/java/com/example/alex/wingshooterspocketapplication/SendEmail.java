package com.example.alex.wingshooterspocketapplication;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.sql.Date;

public class SendEmail extends AppCompatActivity {
    TextView name1;
    EditText name;
    EditText email;
    TextView date1;
    EditText date;
    TextView time1;
    EditText time;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
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
        button.setOnClickListener(new View.OnClickListener() {*/
            @Override
            public void onClick(View view) {
                String myname = name.getText().toString();
                String myemail = email.getText().toString();
                String mydate = date.getText().toString();
                String mytime = time.getText().toString();
                String emailAddressList[] = {"emailAddres"};
                String mycontent = myname + "," + myemail + "," + mydate + ","+ mytime;
                Intent email = new Intent(Intent.ACTION_SEND);
                email.setType("plain/text");
                email.putExtra(Intent.EXTRA_EMAIL, emailAddressList);
                email.putExtra(Intent.EXTRA_TEXT, mycontent);
                startActivity(Intent.createChooser(email, "Select Sender:"));


            }
        });






    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}
