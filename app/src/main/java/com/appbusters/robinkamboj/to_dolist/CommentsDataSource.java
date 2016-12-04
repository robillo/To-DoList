package com.appbusters.robinkamboj.to_dolist;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.provider.Settings;

import java.util.ArrayList;
import java.util.List;

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

    public Comment createComment(String comment){
        ContentValues values= new ContentValues();
        values.put(MyDbHelper.COLUMN_COMMENT,comment);
        long insertId= database.insert(MyDbHelper.TABLE_COMMENTS,null,values);
        Cursor cursor= database.query(MyDbHelper.TABLE_COMMENTS,allColumns,MyDbHelper.COLUMN_ID + " = " + insertId,null,null,null,null);
        cursor.moveToFirst();
        Comment newComment= cursorToComment(cursor);
        cursor.close();
        return newComment;
    }

    public void deleteComment(Comment comment){
        long id= comment.getId();
        System.out.println(" Comment deleted with id: " + id);
        database.delete(MyDbHelper.TABLE_COMMENTS,MyDbHelper.COLUMN_ID + " = " + id, null);
    }

    public List<Comment> getAllComments(){
        List<Comment> comments= new ArrayList<Comment>();
        Cursor cursor= database.query(MyDbHelper.TABLE_COMMENTS, allColumns, null, null, null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            Comment comment= cursorToComment(cursor);
        }
        cursor.close();
        return comments;
    }

    private Comment cursorToComment(Cursor cursor){
        Comment comment= new Comment();
        comment.setId(cursor.getLong(0));
        comment.setComment(cursor.getString(1));
        return  comment;
    }
}
