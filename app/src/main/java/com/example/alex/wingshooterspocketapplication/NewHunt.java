package com.example.alex.wingshooterspocketapplication;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class NewHunt extends AppCompatActivity implements View.OnClickListener
{

    public TextView txtActName;
    public TextView txtActivityType;
    public TextView txthuntDate;
    public TextView txtLocation;
    public TextView txtDistrict;
    public TextView txtClub;
    public TextView txtFarmname;
    public TextView txtFarmowner;
    public TextView txtCellNum;
    public Spinner spnProvince;

    public String typeStringThing;
    public static String huntName;
    public static String DateofHunt;
    public static int huntID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_hunt);
        getSupportActionBar().setTitle("New Hunt");

        Button btnNHunt = findViewById(R.id.btnStart);
        btnNHunt.setOnClickListener(this);

        Button btnDelete = findViewById(R.id.btnDelete);
        btnDelete.setOnClickListener(this);

        txtActName = findViewById(R.id.txtActivityName);
        txtActivityType = findViewById(R.id.txtActivity);
        txthuntDate = findViewById(R.id.datebox);
        txtLocation = findViewById(R.id.txtLocation);
        txtDistrict = findViewById(R.id.txtDistrict);
        txtFarmname = findViewById(R.id.txtFarmName);
        txtFarmowner = findViewById(R.id.txtFarmOwner);
        txtCellNum = findViewById(R.id.txtCellNumber);
        txtClub = findViewById(R.id.txtClub);

        spnProvince = findViewById(R.id.spnProvinceSelec);
    }

    @Override
    public void onClick(View v)
    {
        switch(v.getId())
        {
            case R.id.btnStart:
                StartHunt();
                break;

            case R.id.btnDelete:
                clearFields();
                break;
        }
    }

    public void StartHunt()
    {
        String actName = txtActName.getText().toString();
        String acttype = txtActivityType.getText().toString();
        String huntDate = txthuntDate.getText().toString();
        String huntLocation = txtLocation.getText().toString();
        String huntProvince = spnProvince.getSelectedItem().toString();
        String huntDist = txtDistrict.getText().toString();
        String club = txtClub.getText().toString();

        if (actName.equals("") || acttype.equals("") || huntDate.equals("") || huntLocation.equals("") ||
                huntProvince.equals("") || huntDist.equals("") || club.equals(""))
        {
            Toast.makeText(getApplicationContext(), "Not all fields filled out, please fill all fields", Toast.LENGTH_LONG).show();
            clearFields();
        }
        else
        {
            String farmName = txtFarmname.getText().toString();
            String farmOwner = txtFarmowner.getText().toString();
            String farmCell = txtCellNum.getText().toString();
            huntName = actName;
            DateofHunt = huntDate;

            if (farmName.equals(""))
            {
                farmName = "FarmNameNotKnown";
            }
            if (farmOwner.equals(""))
            {
                farmOwner = "OwnerNotKnow";
            }
            if (farmCell.equals(""))
            {
                farmCell = "000-000-0000";
            }

            actName = actName.replaceAll("\\s+","");
            acttype = acttype.replaceAll("\\s+","");
            huntDate = huntDate.replaceAll("\\s+","");
            huntLocation = huntLocation.replaceAll("\\s+","");
            huntProvince = huntProvince.replaceAll("\\s+","");
            huntDist = huntDist.replaceAll("\\s+","");
            club = club.replaceAll("\\s+","");

            String optionalInfo = farmName + "-" + farmOwner + "-" + farmCell;
            typeStringThing = "newhunt";

            DatabaseHelper dbHelp = new DatabaseHelper(this);

            boolean complete = dbHelp.insertDataTable1(typeStringThing, actName, acttype,
                    huntDate, huntLocation, huntProvince, huntDist, optionalInfo, club);

            huntID = dbHelp.getHuntID(huntDate);

            if (complete)
            {
                Toast.makeText(getApplicationContext(), "New hunt saved and started.", Toast.LENGTH_LONG).show();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent i = new Intent(NewHunt.this, StartHunt.class);
                        startActivity(i);
                        finish();
                    }
                }, 1500);
            }
            else {
                Toast.makeText(getApplicationContext(), "There was a problem starting hunt, please try again.", Toast.LENGTH_LONG).show();
                clearFields();
            }
        }
    }

    private void clearFields()
    {
        txtActName.setText("");
        txtActivityType.setText("");
        txthuntDate.setText("");
        txtLocation.setText("");
        txtDistrict.setText("");
        txtFarmname.setText("");
        txtFarmowner.setText("");
        txtCellNum.setText("");
    }
}
