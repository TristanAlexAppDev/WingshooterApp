package com.example.alex.wingshooterspocketapplication;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

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
    public TextView txtDateShower;

    public static String huntName;
    public static String DateofHunt;
    public static int huntID;
    public static String optionalInfo;
    public static String activityType;
    public static String actLocation;
    public static String actClub;
    public static String actProvince;
    public static String actDistrict;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_hunt);
        getSupportActionBar().setTitle("New Hunt");

        Button btnNHunt = findViewById(R.id.btnStart);
        btnNHunt.setOnClickListener(this);

        Button btnDelete = findViewById(R.id.btnDelete);
        btnDelete.setOnClickListener(this);

        Button btnDatePick = findViewById(R.id.btnDatePicker);
        btnDatePick.setOnClickListener(this);

        txtActName = findViewById(R.id.txtActivityName);
        txtActivityType = findViewById(R.id.txtActivity);
        //txthuntDate = findViewById(R.id.datebox);
        txtLocation = findViewById(R.id.txtLocation);
        txtDistrict = findViewById(R.id.txtDistrict);
        txtFarmname = findViewById(R.id.txtFarmName);
        txtFarmowner = findViewById(R.id.txtFarmOwner);
        txtCellNum = findViewById(R.id.txtCellNumber);
        txtClub = findViewById(R.id.txtClub);
        txtDateShower = findViewById(R.id.txtDateShower);

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
            case R.id.btnDatePicker:
                DatePick();
                break;
        }
    }

    private void DatePick()
    {
        final Calendar c = Calendar.getInstance();
        final int Year = c.get(Calendar.YEAR);
        final int Month = c.get(Calendar.MONTH);
        final int Day = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener()
        {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth)
            {
                String day = String.valueOf(dayOfMonth);
                String Smonth = String.valueOf(month + 1);
                String sYear = String.valueOf(year);

                txtDateShower.setText(day + "/" + Smonth + "/" + sYear);
            }
            },Year, Month, Day);
        datePickerDialog.show();
    }

    public void StartHunt()
    {
        String actName = txtActName.getText().toString();
        String acttype = txtActivityType.getText().toString();
        String huntLocation = txtLocation.getText().toString();
        String huntProvince = spnProvince.getSelectedItem().toString();
        String huntDist = txtDistrict.getText().toString();
        String club = txtClub.getText().toString();

        if (actName.equals("") || acttype.equals("") || huntLocation.equals("") ||
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
            DateofHunt = txtDateShower.getText().toString();
            huntName = actName;
            activityType = acttype;
            actLocation = huntLocation;
            actClub = club;
            actProvince = huntProvince;
            actDistrict = huntDist;


            if (farmName.equals(""))
            {
                farmName = "FarmNameNotKnown";
            }
            if (farmOwner.equals(""))
            {
                farmOwner = "OwnerNotKnown";
            }
            if (farmCell.equals(""))
            {
                farmCell = "Unknown";
            }

            actName = actName.replaceAll("\\s+","");
            acttype = acttype.replaceAll("\\s+","");
            huntLocation = huntLocation.replaceAll("\\s+","");
            huntProvince = huntProvince.replaceAll("\\s+","");
            huntDist = huntDist.replaceAll("\\s+","");
            club = club.replaceAll("\\s+","");

            optionalInfo = farmName + "-" + farmOwner + "-" + farmCell;

            DatabaseHelper dbHelp = new DatabaseHelper(this);

            boolean complete = dbHelp.insertDataTable1(actName, acttype,
                    DateofHunt, huntLocation, huntProvince, huntDist, club, optionalInfo);

            huntID = dbHelp.getHuntID(DateofHunt);

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
            }
        }
    }

    private void clearFields()
    {
        if (txtActName.getText() == "") {
            txtActName.setText("");
        }
        if (txtActivityType.getText() == "") {
            txtActivityType.setText("");
        }
        if (txthuntDate.getText() == "") {
            txthuntDate.setText("");
        }
        if (txtLocation.getText() == "") {
            txtLocation.setText("");
        }
        if (txtDistrict.getText() == "") {
            txtDistrict.setText("");
        }
        if (txtFarmname.getText() == "") {
            txtFarmname.setText("");
        }
        if (txtFarmowner.getText() == "") {
            txtFarmowner.setText("");
        }
        if (txtCellNum.getText() == "") {
            txtCellNum.setText("");
        }
    }
}
