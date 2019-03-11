package com.example.wakilima2;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Farmers.db";
    public static final String TABLE_NAME = "Animals_calendar";
    public static final String COL_1= "ID";
    public static final String COL_2 = "ANIMAL";
    public static final String COL_3 = "DOB";
    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + "ID INTEGER PRIMARY KEY AUTOINCREMENT, ANIMAL TEXT, DOB DATE ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
    public boolean insertData(String ANIMAL, String DOB){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2,ANIMAL);
        contentValues.put(COL_3,DOB);
        long result = db.insert(TABLE_NAME, null, contentValues);
        if (result==-1)
            return  false;
        else
            return true;


    }
}
