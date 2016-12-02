package com.appbusters.robinkamboj.to_dolist;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by robinkamboj on 03/12/16.
 */

public class MyDbHelper extends SQLiteOpenHelper{

    public static final String TABLE_COMMENTS= "comments";

    public static final String COLUMN_ID= "_id";
    public static final String COLUMN_COMMENT= "comment";

    private static final String DATABASE_NAME= "comments.db";
    private static final int DATABASE_VERSION= 1;

    //create table sql statement
    private static final String DATABASE_CREATE= "create table " + TABLE_COMMENTS + "( " + COLUMN_ID + " integer primary key autoincrement, " + COLUMN_COMMENT + "text not null);";

    public MyDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(MyDbHelper.class.getName(), "Upgrading database from version " + oldVersion + " to " + newVersion + " which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_COMMENTS);
        onCreate(db);
    }
}
