package com.google.hangout.myapp.sqlite.database.utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "UserDB.db";
    public static final String TABLE_NAME = "user_table";
    public static final String COL_1 = "ID"; //
    public static final String COL_2 = "NAME";
    public static final String COL_3 = "ADDRESS";
    public static final String COL_4 = "NOTICES";
    public static final String COL_5 = "TYPE";
    public static final String COL_6 = "QUANTITY"; //
    public static final String COL_7 = "PRICE"; //
    public static final String COL_8 = "TELE";




    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,ADDRESS TEXT,NOTICES TEXT,TYPE TEXT,QUANTITY TEXT,PRICE TEXT,TELE TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }

    public boolean insertData(String name, String address, String notices,String type,String quantity,String price,String tele) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, name);
        contentValues.put(COL_3, address);
        contentValues.put(COL_4, notices);
        contentValues.put(COL_5,type);
        contentValues.put(COL_6,quantity);
        contentValues.put(COL_7,price);
        contentValues.put(COL_8,tele);
        long result = db.insert(TABLE_NAME, null, contentValues);

        if (result == -1)
            return false;
        else
            return true;

    }



    public Cursor getAllData() {

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + TABLE_NAME, null);
        return res;


    }

    public boolean updateData(String id,String name, String address, String notices) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(id, COL_1);
        contentValues.put(COL_2, name);
        contentValues.put(COL_3, address);
        contentValues.put(COL_4, notices);
        db.update(TABLE_NAME, contentValues, "ID =?", new String[]{id});
        return true;
    }

    public int deleteData(String id){

        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME,"ID = ?",new String[]{id});

    }


    /*public int getLastAddedRowId() {
        SQLiteDatabase db = this.getReadableDatabase();
            String queryLastRowInserted = "select last_insert_rowid()";

            final Cursor cursor = db.rawQuery(queryLastRowInserted, null);
            int _idLastInsertedRow = 0;
            if (cursor != null) {
                try {
                    if (cursor.moveToFirst()) {
                        _idLastInsertedRow = cursor.getInt(0);
                    }
                } finally {
                    cursor.close();
                }
            }

            return _idLastInsertedRow;


    }*/
}
