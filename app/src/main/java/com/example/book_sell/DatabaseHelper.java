package com.example.book_sell;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Book";

    /*User*/
    public static final String TABLE_USER = "User";
    public static final String TABLE_USER_MAUER = "Ma_uer";
    public static final String TABLE_USER_USERNAME ="user_name";
    public static final String TABLE_USER_EMAIL = "Email";
    public static final String TABLE_USER_PASSWORD = "Password";

    /*UserInfo*/
    public static final String TABLE_USERINFO = "User_info";
    public static final String TABLE_USERINFO_MAUSER = "Ma_user";
    public static final String TABLE_USERINFO_GIOITINH = "Gioi_tinh";
    public static final String TABLE_USERINFO_NGAYSINH = "Ngay_sinh";
    public static final String TABLE_USERINFO_QUEQUAN = "Que_quan";
    public static final String TABLE_USERINFO_SOTHICH = "So_thich";

    /**Query SQL**/
    /*CREATE TABLE User*/
    public static final String CREATE_TABLE_USER = "CREATE TABLE " + TABLE_USER +"(" + TABLE_USER_MAUER + " INTEGER(10)PRIMARY KEY,"
            +TABLE_USER_USERNAME + " NVARCHAR(50) NOT NULL,"
            + TABLE_USER_EMAIL + " NVARCHAR(50) NOT NULL,"
            + TABLE_USER_PASSWORD + " NVARCHAR(50) NOT NULL )";

    /*CREATE TABLE UserInfo*/
    public static final String CREATE_TABLE_USERINFO = "CREATE TABLE " + TABLE_USERINFO + "(" + TABLE_USERINFO_MAUSER + " INTEGER(10)PRIMARY KEY,"
            +TABLE_USERINFO_GIOITINH + " NVARCHAR(50) NOT NULL,"
            + TABLE_USERINFO_NGAYSINH + " NVARCHAR(50) NOT NULL,"
            + TABLE_USERINFO_QUEQUAN + " NVARCHAR(50) NOT NULL, "
            + TABLE_USERINFO_SOTHICH + " NVARCHAR(50) NOT NULL)";

    public Context context;
    public String duongDanDatabase = "";

    public DatabaseHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_USER);
        db.execSQL(CREATE_TABLE_USERINFO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERINFO);
    }
}
