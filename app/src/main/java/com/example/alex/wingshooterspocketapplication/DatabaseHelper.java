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
    private static String TAG = "DataBaseHelper";
    private static String DB_NAME = "SQLite Database.db";
    //private static String DB_PATH = "/data/data/com.example.alex.wingshooterspocketapplication/databases/";
    private static String DB_PATH = "";

    private SQLiteDatabase mDataBase;
    private final Context mContext;
    private String TABLE_User = "userTable";

    public DatabaseHelper(Context context)
    {
        super(context, DB_NAME, null, 1);

        if (Build.VERSION.SDK_INT >= 17)
        {
            DB_PATH = context.getApplicationInfo().dataDir + "/databases/";
        }
        else
        {
            DB_PATH = context.getApplicationInfo().dataDir + "/databases/";
        }

        this.mContext = context;
    }

    public void createDatabase() throws IOException
   {
       boolean dbExist = checkDatabase();

       if (!dbExist)
       {
           //do nothing as db exists
       }
       else
       {
           this.getReadableDatabase();
           this.close();

           try
           {
               copyDatabase();
               Log.e(TAG, "createDatabase created");
           }
           catch (IOException mIOException)
           {
               throw new Error("Error copying database");
           }
       }
   }

    private boolean checkDatabase()
    {
        File dbFile = new File(DB_PATH + DB_NAME);
        return dbFile.exists();

        /*SQLiteDatabase checkDB = null;

        try
        {
            String myPath = DB_PATH + DB_NAME;
            checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        }
        catch(SQLiteException e)
        {
            //database doesnt exist
        }

        if (checkDB != null)
        {
            checkDB.close();
        }

        return checkDB != null ? true : false;*/
    }

   private void copyDatabase() throws IOException
   {
        InputStream myInput = mContext.getAssets().open(DB_NAME);

        String outFileName = DB_PATH + DB_NAME;
        OutputStream myOutput = new FileOutputStream(outFileName);

        byte[] buffer = new byte[1024];
        int length;

        while ((length = myInput.read(buffer)) > 0)
        {
            myOutput.write(buffer, 0, length);
        }

        myOutput.flush();
        myOutput.close();
        myInput.close();
   }

   public boolean openDatabase() throws SQLException
   {
       //open the Database
       String myPath = DB_PATH + DB_NAME;
       mDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.CREATE_IF_NECESSARY);
       return mDataBase != null;
   }

   @Override
    public synchronized void close()
   {
       if (mDataBase != null)
       {
           mDataBase.close();
       }

       super.close();
   }

   @Override
   public void onCreate(SQLiteDatabase db)
   {
       //blyat
   }

   @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
   {

   }

    public boolean checkLogin (String userPass, String userID)
    {
        String[] columns = {"UserID"};



        SQLiteDatabase db = this.getReadableDatabase();

        String selection = "IDNumber = ? AND Password = ?";

        String[] selectionArgs = {userID, userPass};

        Cursor cursor = db.query(TABLE_User,
                columns,
                selection,
                selectionArgs,
                null,
                null,
                null);

        int cursorCount = cursor.getCount();

        cursor.close();
        db.close();

        if (cursorCount > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean registeredUser (String userID) {
        String check = "NotJoined";
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT IDNumber, DateJoined FROM userTable WHERE IDNumber = ? " +
                "AND DateJoined = ?", new String[]{userID, check});

        if (cursor.equals(true)) {
            return false;
        } else {
            return true;
        }
    }
        /*String table = "userTable";
        String[] columns = {"IDNumber", "DateJoined"};
        String selection = "IDNumber" + "=?";
        String[] selectionArgs = null;
        String groupBy = null;
        String having = null;
        String orderBy = "IDNumber" + " DESC";
        String limit = "1";

        Cursor cursor = db.query(table, columns, selection, selectionArgs, groupBy, having, orderBy, limit);

        if (cursor.equals(false))
        {
            return false;
        }
        else
        {
            return true;
        }


//----------------------------------------------------------------------------------------------------
    /*public DatabaseHelper(Context context)
    {
        super(context, DB_NAME, null, DB_VERSION);

        if (Build.VERSION.SDK_INT >= 17)
        {
            DB_PATH = context.getApplicationInfo().dataDir + "/databases/";
        }
        else
        {
            DB_PATH = "/data/data/" + context.getPackageName() + "/databases/";
        }

        this.mContext = context;

        copyDataBase();

        this.getReadableDatabase();
    }

    public void updateDataBase() throws IOException
    {
        if (mNeedUpdate)
        {
            File dbFile = new File(DB_PATH + DB_NAME);

            if (dbFile.exists())
            {
                dbFile.delete();
            }

            copyDataBase();

            mNeedUpdate = false;
        }
    }

    private boolean checkDataBase()
    {
        File dbFile = new File(DB_PATH + DB_NAME);
        return dbFile.exists();
    }

    private void copyDataBase()
    {
        if (!checkDataBase())
        {
            this.getReadableDatabase();
            this.close();

            try
            {
                copyDBFile();
            }
            catch (IOException mIOException)
            {
                throw new Error("ErrorCopyingDataBase");
            }
        }
    }

    private void copyDBFile() throws IOException
    {
        InputStream mInput = mContext.getAssets().open(DB_NAME);
        //InputStream mInput = mContext.getResources().openRawResource(R.raw.info);
        OutputStream mOutput = new FileOutputStream(DB_PATH + DB_NAME);

        byte[] mBuffer = new byte[1024];
        int mLength;

        while ((mLength = mInput.read(mBuffer)) > 0)
        {
            mOutput.write(mBuffer, 0, mLength);
        }

        mOutput.flush();
        mOutput.close();
        mInput.close();
    }

    public boolean openDataBase() throws SQLException
    {
        mDataBase = SQLiteDatabase.openDatabase(DB_PATH + DB_NAME, null, SQLiteDatabase.CREATE_IF_NECESSARY);
        return mDataBase != null;
    }

    @Override
    public synchronized void close()
    {
        if (mDataBase != null)
        {
            mDataBase.close();
        }

        super.close();
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        //Nothing here as we are not actually creating a database but using a pre-existing database
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        if (newVersion > oldVersion)
        {
            mNeedUpdate = true;
        }
    }

    public boolean checkLogin (String userPass, String userID)
    {
        String[] columns = {"UserID"};

        SQLiteDatabase db = this.getReadableDatabase();

        String selection = "IDNumber = ? AND Password = ?";

        String[] selectionArgs = {userID, userPass};

        Cursor cursor = db.query(TABLE_User,
                columns,
                selection,
                selectionArgs,
                null,
                null,
                null);

        int cursorCount = cursor.getCount();

        cursor.close();
        db.close();

        if (cursorCount > 0)
        {
            return true;
        }
        else
        {
            return false;
        }

        //------------------------------------------------------------------------------------------

        /*Cursor cursor = db.rawQuery("SELECT IDNumber, Password FROM userTable Where IDNumber = ? and " +
                "Password = ?", new String[]{userID, userPass});

        if (cursor.equals(false))
        {
            return false;
        }
        else
        {
            return true;
        }*/

        //------------------------------------------------------------------------------------------

        /*String table = "userTable";
        String[] columns = {"IDNumber","Password"};
        String selection = "IDNumber" + "=?";
        String[] selectionArgs = null;
        String groupBy = null;
        String having = null;
        String orderBy = "Password" + " DESC";
        String limit = "1";

        Cursor cursor = db.query(table, columns, selection, selectionArgs, groupBy, having, orderBy, limit);

        if (cursor.equals(false))
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    public boolean registeredUser (String userID)
    {
        String check = "NotJoined";
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor  = db.rawQuery("SELECT IDNumber, DateJoined FROM userTable WHERE IDNumber = ? " +
                "AND DateJoined = ?", new String[]{userID, check});

        if (cursor.equals(true))
        {
            return false;
        }
        else
        {
            return true;
        }
        /*String table = "userTable";
        String[] columns = {"IDNumber", "DateJoined"};
        String selection = "IDNumber" + "=?";
        String[] selectionArgs = null;
        String groupBy = null;
        String having = null;
        String orderBy = "IDNumber" + " DESC";
        String limit = "1";

        Cursor cursor = db.query(table, columns, selection, selectionArgs, groupBy, having, orderBy, limit);

        if (cursor.equals(false))
        {
            return false;
        }
        else
        {
            return true;
        }
    }*/
}
