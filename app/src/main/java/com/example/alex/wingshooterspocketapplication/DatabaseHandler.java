package com.example.alex.wingshooterspocketapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler extends SQLiteOpenHelper
{

    //Database Version
    private static final int DATABASE_VERSION = 1;

    //Database name
    private static final String DATABASE_NAME = "WingShootersDatabase";

    //Table name 1
    private static final String TABLE_NAME1 = "UserInfo";

    //Table name 2
    private static final String TABLE_NAME2 = "BirdInfo";

    public DatabaseHandler(Context context,)
    {
        super(context, , , );
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {

    }
}
