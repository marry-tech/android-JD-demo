package com.example.mytoyshop.utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    private static final String DB_NAME ="test1.db";
    private static final String TB_NAME = "user";
    private SQLiteDatabase db;
    public DBHelper(Context c){
        super(c,DB_NAME,null,2);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        this.db = db;
        String CREATE_TBL = "create table user (_id integer primary "+" key autoincrement,name text,password text,phone text,adress text)";
        db.execSQL(CREATE_TBL);


    }
    public void  insert(ContentValues values){
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TB_NAME,null,values);
        db.close();
    }
    public Cursor query(){
        SQLiteDatabase db = getWritableDatabase();
        Cursor c =db.query(TB_NAME,null,null,null,null,null,null);
        return c;
    }
    public  void del(int id){
        if (db ==null)
            db =getWritableDatabase();
        db.delete(TB_NAME,"_id=?",new String[]{String.valueOf(id)});
    }
    public void close(){
        if (db!=null)
            db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
