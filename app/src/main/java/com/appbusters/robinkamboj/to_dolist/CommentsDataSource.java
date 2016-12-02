package com.appbusters.robinkamboj.to_dolist;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by robinkamboj on 03/12/16.
 */

//This is our DAO (data access object) class as an interface bw data and ui

public class CommentsDataSource {

    //Database Fields
    private SQLiteDatabase database;
    private  MyDbHelper dbHelper;
    private String[] allColumns= { MyDbHelper.COLUMN_ID, MyDbHelper.COLUMN_COMMENT};

    public  CommentsDataSource(Context context){
        dbHelper= new MyDbHelper(context);
    }

    public void open() throws SQLException{
        database= dbHelper.getWritableDatabase();
    }

    public void close(){
        dbHelper.close();
    }
}
