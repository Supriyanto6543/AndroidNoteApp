package com.app.databku.databaseku;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.app.databku.modal.ModalKu;

import java.util.ArrayList;
import java.util.List;

public class MyDatabaseKu extends SQLiteOpenHelper {

    //DATABASE NAME DAN DATABASE VERSI
    static String DATABASE_NAME = "appdatabaseku";
    static int DATABASE_VERSI = 1;

    //DATABASE TABLE DAN FIELD
    static String DATABASE_TABLE = "table_app";
    static String DB_ID = "app_id";
    static String DB_NAME = "app_name";
    static String DB_ALAMAT = "app_alamat";
    static String DB_PEKERJAAN = "app_pekerjaan";

    static String CREATE_TABLE = "CREATE TABLE " + DATABASE_TABLE + " ( " + DB_ID + " INTEGER PRIMARY KEY, "
            + DB_NAME + " TEXT, "
            + DB_ALAMAT + " TEXT, "
            + DB_PEKERJAAN + " TEXT)";


    public MyDatabaseKu(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSI);
        this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onCreate(db);
    }

    public void tambahData(ModalKu modalKu){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(DB_NAME, modalKu.getName());
        contentValues.put(DB_ALAMAT, modalKu.getAlamat());
        contentValues.put(DB_PEKERJAAN, modalKu.getPekerjaan());

        db.insert(DATABASE_TABLE, null, contentValues);

    }

    public List<ModalKu> tampilkanSemuaUser(){

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.query(DATABASE_TABLE, new String[]{DB_NAME, DB_ALAMAT, DB_PEKERJAAN}, null, null, null, null, DB_ID + " desc");

        List<ModalKu> arrayListku = new ArrayList<>();

        if (cursor.moveToFirst()){

            do {

                ModalKu modalKu = new ModalKu();

                modalKu.setName(cursor.getString(cursor.getColumnIndex(DB_NAME)));
                modalKu.setAlamat(cursor.getString(cursor.getColumnIndex(DB_ALAMAT)));
                modalKu.setPekerjaan(cursor.getString(cursor.getColumnIndex(DB_PEKERJAAN)));

                arrayListku.add(modalKu);

            }while (cursor.moveToNext());

        }

        cursor.close();
        return arrayListku;
    }
}
