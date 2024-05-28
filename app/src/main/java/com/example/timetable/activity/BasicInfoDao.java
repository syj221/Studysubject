package com.example.timetable.activity;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BasicInfoDao extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "timetable.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "basic_info";

    public BasicInfoDao(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + " (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "school TEXT, " +
                "department TEXT, " +
                "enrollmentYear INTEGER)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public long insert(BasicInfo basicInfo) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("school", basicInfo.getSchool());
        values.put("department", basicInfo.getDepartment());
        values.put("enrollmentYear", basicInfo.getEnrollmentYear());
        long result = db.insert(TABLE_NAME, null, values);
        db.close();
        return result;
    }
}