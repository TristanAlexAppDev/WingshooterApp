package com.example.alex.wingshooterspocketapplication;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper
{

    private static final int DB_VERSION = 1;

    private static final String DB_NAME = "WingShootersLocalDatabase";

    //----------------------------------------------------
    private static final String TABLE_NAME1 = "myHunts";
    //----------------------------------------------------
    private static final String TABLE_NAME2 = "Log";
    //----------------------------------------------------

    SQLiteDatabase db;

    public DatabaseHelper(Context context)
    {
        super(context, DB_NAME, null, DB_VERSION);
        db = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("CREATE TABLE myHunts (\n" +
                "\tHuntID\tINTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,\n" +
                "\tActivityName\tTEXT NOT NULL,\n" +
                "\tActivityType\tTEXT NOT NULL,\n" +
                "\tHuntDate\tDATE NOT NULL,\n" +
                "\tLocation\tTEXT NOT NULL,\n" +
                "\tClub\tTEXT NOT NULL,\n" +
                "\tProvince\tTEXT NOT NULL,\n" +
                "\tDistrict\tTEXT NOT NULL,\n" +
                "\tAdditionalInfo\tTEXT,\n" +
                "FOREIGN KEY (HuntID) REFERENCES Log (HuntID));");

        db.execSQL("CREATE TABLE Log (\n" +
                "\tLogID\tINTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,\n" +
                "\tHuntID\tINTEGER NOT NULL,\n" +
                "\tBirdName\tTEXT NOT NULL,\n" +
                "\tSeenORShot\tTEXT NOT NULL,\n" +
                "\tBirdAge\tTEXT NOT NULL,\n" +
                "\tNumSeenORShot\tTEXT NOT NULL,\n" +
                "\tOtherAnimalShotORClayShoot\tTEXT,\n" +
                "\tAnimalShotNameORTypeClaysShot\tTEXT,\n" +
                "FOREIGN KEY (HuntID) REFERENCES myHunts (HuntID));");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME1);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME2);
            onCreate(db);
    }

    public boolean insertDataTable1(String actName, String acttype, String huntDate, String huntLocation,
                              String huntProvince, String huntDist, String club, String optionalInfo)
    {
        try
        {
            String query = "INSERT INTO myHunts(ActivityName, ActivityType, HuntDate, Location, Club, Province, District, AdditionalInfo)" +
                    " VALUES('" + actName + "','" + acttype + "','" + huntDate + "','" + huntLocation + "','" + club + "','" + huntProvince
                    + "','" + huntDist + "','" + optionalInfo + "')";
            db.execSQL(query);
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }

    public int getHuntID(String huntDate)
    {
        int result;
        String query = "SELECT HuntID FROM myHunts WHERE HuntDate ='" + huntDate + "'";
        Cursor cursor = db.rawQuery(query, null);

        if(cursor.moveToFirst())
        {
            result = cursor.getInt(cursor.getColumnIndex("HuntID"));
        }
        else
        {
            result = 0;
        }
        cursor.close();
        return result;
    }

    public boolean addNewLog(int huntID, String birdName, String shtORSn, String brdAge, String numSnORSht, String othrAnimORClaySht, String animShotORClayTypeSht)
    {
        try
        {
            String query = "INSERT INTO Log(HuntID, BirdName, SeenORShot, BirdAge, NumSeenORShot, OtherAnimalShotORClayShoot, AnimalShotNameORTypeClaysShot)" +
                    " VALUES('" + huntID + "', '" + birdName + "', '" + shtORSn + "', '" + brdAge + "', '" + numSnORSht + "', " +
                    "'" + othrAnimORClaySht + "', '" + animShotORClayTypeSht + "')";
            db.execSQL(query);
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }

    public int getHuntIDforPastHunts(String strDate)
    {
        int result;
        String query = "SELECT HuntID FROM myHunts WHERE HuntDate ='" + strDate + "'";
        Cursor cursor = db.rawQuery(query, null);

        if(cursor.moveToFirst())
        {
            result = cursor.getInt(cursor.getColumnIndex("HuntID"));
        }
        else
        {
            result = 0;
        }
        cursor.close();
        return result;
    }

    public Cursor getPastHuntLogs(int huntID)
    {
        String query = "SELECT BirdName, SeenORShot, BirdAge, NumSeenORShot, OtherAnimalShotORClayShoot, " +
                "AnimalShotNameORTypeClaysShot FROM Log WHERE HuntID = " + "'huntID'";
        Cursor cursor = db.rawQuery(query, null);
        return cursor;
    }
}
