package com.example.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyDataBase extends SQLiteOpenHelper {

    public static final String DB_NAME = "Q2_db";
    public static final int DB_VERSION = 1;


//    public static final String DB_TB_NAME = "user";
//    public static final String DB_CLN_ID = "id";
//    public static final String DB_CLN_NAME = "name";
//    public static final String DB_CLN_PASSWORD = "password";
//    public static final String DB_CLN_EMAIL = "email";


    public MyDataBase(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE user (id INTEGER PRIMARY KEY AUTOINCREMENT," + "name TEXT, password TEXT, email TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS user");
        onCreate(sqLiteDatabase);

    }

    public boolean insertUser(User user){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("name",user.getName());
        values.put("password",user.getPassword());
        values.put("email",user.getEmail());

        long re = db.insert("user",null,values);

        if (re==-1){
            return false;
        }else {
            return true;
        }
    }


    public boolean updateUser(User user){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("name",user.getName());
        values.put("password",user.getPassword());
        values.put("email",user.getEmail());

        String args [] = {String.valueOf(user.getId())};

        int re = db.update("user",values,"id=?",args);

        if (re==0){
            return false;
        }else {
            return true;
        }
    }

    public long getUserCount(){
        SQLiteDatabase db = getWritableDatabase();
        return DatabaseUtils.queryNumEntries(db,"user");
    }


    public boolean deleteUser(User user){
        SQLiteDatabase db = getWritableDatabase();

        String args [] = {String.valueOf(user.getId())};

        int re = db.delete("user","id=?",args);

        return re > 0;
    }


    public ArrayList<User> getAllUser (){

        ArrayList<User> users = new ArrayList<>();

        SQLiteDatabase db = getReadableDatabase();

        Cursor c =  db.rawQuery("SELECT * FROM user",null);

        if (c.moveToFirst()){

            do {
                int id = c.getInt(0);
                String name = c.getString(1);
                String password = c.getString(2);
                String email = c.getString(3);

                User u = new User(id,name,password,email);
                users.add(u);

            }while (c.moveToNext());
            c.close();

        }
        return users;
    }


    public ArrayList<User> LogInUser (String email1){

        ArrayList<User> users = new ArrayList<>();

        SQLiteDatabase db = getReadableDatabase();

        Cursor c =  db.rawQuery("SELECT * FROM user WHERE email=?",new String[] {email1});

        if (c.moveToFirst()){


            int id = c.getInt(0);
            String name = c.getString(1);
            String password = c.getString(2);
            String email = c.getString(3);

            User u = new User(id,name,password,email);
            users.add(u);


            c.close();

        }
        return users;
    }


}
