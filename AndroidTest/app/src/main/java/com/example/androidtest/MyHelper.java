package com.example.androidtest;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyHelper extends SQLiteOpenHelper {
    public MyHelper(Context context){
        super(context,"Test.db",null,3);
    }
    public void onCreate(SQLiteDatabase db){
        db.execSQL("CREATE TABLE info(moneya VARCHAR(30),timea VARCHAR(30),kinda VARCHAR(30),froma VARCHAR(30),remarka VARCHAR(30))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
