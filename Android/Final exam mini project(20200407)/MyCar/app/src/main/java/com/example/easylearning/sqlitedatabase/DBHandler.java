package com.example.easylearning.sqlitedatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHandler extends SQLiteOpenHelper {

    public static final String DB_NAME = "Register.db";
    public static final int DB_VERSION = 1;

    public DBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    public DBHandler(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String USER_TABLE = "CREATE TABLE " + User.UserDetails.TABLE_NAME + " ( " +
                User.UserDetails.COL_ID + " INTEGER PRIMARY KEY," +
                User.UserDetails.COL_NAME + " TEXT," +
                User.UserDetails.COL_EMAIL + " TEXT," +
                User.UserDetails.COL_PASS + " TEXT)";
        db.execSQL(USER_TABLE);
    }

    //------------------------------Insert------------------------------------
    public boolean addUser( String name, String email, String pass) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(User.UserDetails.COL_NAME, name);
        values.put(User.UserDetails.COL_EMAIL, email);
        values.put(User.UserDetails.COL_PASS, pass);

        long sid = db.insert(User.UserDetails.TABLE_NAME, null, values);
        if (sid > 0) {
            return true;
        } else {
            return false;

        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
