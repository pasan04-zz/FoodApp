package com.google.hangout.myapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

public class SQLiteHelper extends SQLiteOpenHelper {

    //constructor
    public SQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);




    }

    public void queryData(String sql){
            SQLiteDatabase  database =getWritableDatabase();
            database.execSQL(sql);


    }

    //insert the data
    public void insertData(String foodItem,String quantity,String price){

        SQLiteDatabase database = getWritableDatabase();
        //query to insert the record in the database table

        String sql = "INSERT INTO orderFood VALUES (NULL,?,?,?)";

        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();

        statement.bindString(1,foodItem);
        statement.bindString(2,quantity);
        statement.bindString(3,price);

        statement.executeInsert();




    }

    public void deleteData(int id){

            SQLiteDatabase database = getWritableDatabase();
            //query to delete records using id
            String sql = "delete from orderFood where id=?";

            SQLiteStatement statement = database.compileStatement(sql);
            statement.clearBindings();
            statement.bindDouble(1,(double)id);

            statement.execute();
            database.close();


    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
