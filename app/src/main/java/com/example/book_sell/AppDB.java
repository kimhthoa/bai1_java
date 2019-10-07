package com.example.book_sell;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class AppDB {
    private DatabaseHelper dbHelper;
    private SQLiteDatabase database;

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
    public AppDB(Context context){
        dbHelper = new DatabaseHelper(context, DATABASE_NAME, null, DATABASE_VERSION);
        database = dbHelper.getWritableDatabase();
        createDefaultNotesIfNeed();
    }
    public void createDefaultNotesIfNeed(){
        int count = getUserCount();
        if (count == 0){
            /**create db_User**/
            db_User db_user1= new db_User("T01", "kimthoa", "happy", "kimthoavolume@gmail.com");
            db_User db_user2 = new db_User("T02", "VoChung", "kenchung", "vochung@gmail.com");
            db_User db_user3 = new db_User("T03", "VietThuan", "thuancho", "gaugau@gmail.com");
            db_User db_user4 = new db_User("T04", "NgocDieu", "diudiu", "diu@gmail.com");
            db_User db_user5 = new db_User("T05", "BinhPhuong", "phuong", "bp@gmail.com");

            /**add User**/
            addUser(db_user1); addUser(db_user2); addUser(db_user3); addUser(db_user4); addUser(db_user5);

            /**create db_UserInfo**/
            db_UserInfo db_userInfo1 = new db_UserInfo("T01", "Nữ", "26/12/1997", "Quảng Bình", "Ăn,Ngủ");
            db_UserInfo db_userInfo2 = new db_UserInfo("T02", "Nữ", "17/07/1998", "Quảng Trị", "Ăn,Ngủ");
            db_UserInfo db_userInfo3 = new db_UserInfo("T03", "Nam", "22/03/1998", "Huế", "Ăn,Ngủ");
            db_UserInfo db_userInfo4 = new db_UserInfo("T04", "Nữ", "25/08/1998", "Quảng Nam", "Ăn,Ngủ");
            db_UserInfo db_userInfo5 = new db_UserInfo("T05", "Nam", "01/11/1998", "Quảng Trị", "Ăn,Ngủ");
            /**add UserInfo**/
            addUserInfo(db_userInfo1); addUserInfo(db_userInfo2); addUserInfo(db_userInfo3);
            addUserInfo(db_userInfo4); addUserInfo(db_userInfo5);
        }
    }
    public int getUserCount(){
        String countQuery = "SELECT  Ma_uer FROM "  + TABLE_USER;
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int count = cursor.getCount();
//        cursor.close();
//        db.close();
        return count;
    }
    public void addUser(db_User db_user){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(TABLE_USER_MAUER, db_user.getMauser());
        values.put(TABLE_USER_USERNAME, db_user.getUsername());
        values.put(TABLE_USER_EMAIL, db_user.getEmail());
        values.put(TABLE_USER_PASSWORD, db_user.getPassword());
        db.insert(TABLE_USER, null, values);
//        db.close();
    }
    public void addUserInfo(db_UserInfo db_userInfo){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(TABLE_USERINFO_MAUSER, db_userInfo.getMauser());
        values.put(TABLE_USERINFO_GIOITINH, db_userInfo.getGioitinh());
        values.put(TABLE_USERINFO_NGAYSINH, db_userInfo.getNgaysinh());
        values.put(TABLE_USERINFO_QUEQUAN, db_userInfo.getQuequan());
        values.put(TABLE_USERINFO_SOTHICH, db_userInfo.getSothich());
        db.insert(TABLE_USERINFO, null, values);
//        db.close();
    }

    public ArrayList<db_User> getTableUser_uername(String nusername){
        ArrayList<db_User> UserList = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_USER + " WHERE User.user_name=\""+nusername+"\"" ;
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        // Duyệt trên con trỏ và thêm vào danh sách;
        if (cursor.moveToFirst()){
            do{
                db_User db_user = new db_User(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3));
                //Thêm vào danh sách;
                UserList.add(db_user);
            }while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return UserList;
    }

    public ArrayList<db_User> getTableUser_email(String nemail){
        ArrayList<db_User> UserList = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_USER + " WHERE User.user_name=\""+nemail+"\"" ;
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        // Duyệt trên con trỏ và thêm vào danh sách;
        if (cursor.moveToFirst()){
            do{
                db_User db_user = new db_User(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3));
                //Thêm vào danh sách;
                UserList.add(db_user);
            }while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return UserList;
    }
//    public ArrayList<db_User> getTableUser11(String nusername, String npassword){
//        ArrayList<db_User> UserList = new ArrayList<>();
//        String selectQuery = "SELECT * FROM " + TABLE_USER;
//        SQLiteDatabase db = dbHelper.getReadableDatabase();
//        Cursor cursor = db.rawQuery(selectQuery, null);
////        db_User db_user = new db_User(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3));
////        UserList.add(db_user);
////         Duyệt trên con trỏ và thêm vào danh sách;
//        while (cursor.moveToNext()) {
//            db_User db_user1 = new db_User(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3));
//            //Thêm vào danh sách;
//            UserList.add(db_user1);
//        }
//        cursor.close();
//        db.close();
//        return UserList;
//    }

}

