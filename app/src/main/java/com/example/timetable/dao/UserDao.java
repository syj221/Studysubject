package com.example.timetable.dao;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;

import androidx.annotation.NonNull;

import com.example.timetable.pojo.Course;
import com.example.timetable.pojo.User;

import java.util.ArrayList;
import java.util.List;

public class UserDao extends SQLiteOpenHelper {
    private final String tableName = "user";
    private SQLiteDatabase db;
    public UserDao(Context context){
        super(context, "db_user", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table user(" +
                "_id integer primary key autoincrement," +
                "userName varchar(50)," +
                "password varchar(50)," +
                "firstName varchar(50), " +
                "lastName varchar(50), " +
                "email varchar(100) " +
                ")";
        db.execSQL(sql);
    }

    public long insert(String nullColumnHack, ContentValues values){
        SQLiteDatabase database = getWritableDatabase();
        long count = database.insert(tableName, nullColumnHack, values);
        database.close();
        return count;
    }

    public long insert(@NonNull User user){
        SQLiteDatabase database = getWritableDatabase();
        ContentValues values = new ContentValues();
        if(!TextUtils.isEmpty(user.getUserName())){
            values.put("userName", user.getUserName());
        }
        if(!TextUtils.isEmpty(user.getPassword())){
            values.put("password", user.getPassword());
        }
        if(!TextUtils.isEmpty(user.getFirstName())) {
            values.put("firstName",user.getFirstName());
        }
        if(!TextUtils.isEmpty(user.getLastName())) {
            values.put("lastName", user.getLastName());
        }
        if(!TextUtils.isEmpty(user.getEmail())) {
            values.put("email", user.getEmail());
        }
        long count = database.insert(tableName, null, values);
        database.close();
        return count;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS user");
        onCreate(db);
    }


    public List<User> getALLDATA(){
        List<User> list = new ArrayList<>();
        SQLiteDatabase database = getWritableDatabase();
        Cursor data = database.query(tableName, null, null, null, null, null, null);
        if(data.getCount() > 0){
            while(data.moveToNext()) {
                User user=new User();
                user.setId(data.getInt(0));
                user.setUserName(data.getString(1));
                user.setPassword(data.getString(2));
                user.setFirstName(data.getString(3));
                user.setLastName(data.getString(4));
                user.setEmail(data.getString(5));
                list.add(user);
            }
        }
        database.close();
        return list;
    }
}
