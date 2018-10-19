package com.example.alex.wingshooterspocketapplication;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.os.Build;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

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
                "\tAdditionalInfo\tTEXT\n" +
                ");");

        db.execSQL("CREATE TABLE Log (\n" +
                "\tHuntID\tINTEGER NOT NULL,\n" +
                "\tBirdName\tTEXT,\n" +
                "\tNumSeen\tINTEGER,\n" +
                "\tNumShot\tINTEGER,\n" +
                "\tOtherAnimalORclaySHOT\tTEXT,\n" +
                "\tPRIMARY KEY(HuntID)\n" +
                ");");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME1);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME2);
            onCreate(db);
    }
}
