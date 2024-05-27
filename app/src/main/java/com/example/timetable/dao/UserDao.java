package com.example.timetable.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class UserDao extends SQLiteOpenHelper {
    private String tableName = "t_user";

    public UserDao(Context context){
        super(context, "user.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table t_user(" +
                "_id integer primary key autoincrement," +
                "userName varchar(50)," +
                "password varchar(50)," +
                "firstName varchar(50), " +
                "lastName varchar(50), " +
                "email varchar(100), " +
                ")";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
