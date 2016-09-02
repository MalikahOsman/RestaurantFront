package com.example.osman.restaurantmsandroid.repositories.Impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.osman.restaurantmsandroid.domain.Employee;
import com.example.osman.restaurantmsandroid.repositories.LoginRepository;

import java.util.Set;

/**
 * Created by Osman on 2016-06-07.
 */
public class LoginRepositoryImpl extends SQLiteOpenHelper implements LoginRepository{

    public static final String DATABASE_NAME = "Restaurant.db";
    public static final String TABLE_NAME = "employee";

    public static final String COL_1 = "USER";
    public static final String COL_2 = "PASSWORD";
    public static final String COL_3 = "EMPNUM";
    public static final String COL_4= "EMPNAME";
    public static final String COL_5 = "ADDRESS";
    public static final String COL_6 = "TELEPHONE";

    public LoginRepositoryImpl(Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //db.execSQL("CREATE TABLE " + TABLE_NAME + "( ID INTEGER PRIMARY KEY AUTOINCREMENT, EMAIL,PASSWORD,NAME,SURNAME )");
        db.execSQL("CREATE TABLE user ( ID INTEGER PRIMARY KEY AUTOINCREMENT, USER,PASSWORD,EMPNUM, EMPNAME,ADDRESS, TELEPHONE )");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS employee");
        onCreate(db);
    }

/*//    @Override
    public Object findById(Object o) {
        return null;
    }

  //  @Override
    public Object save(Object entity) {
        return null;
    }



    //@Override
    public Object update(Object entity) {
        return null;
    }

   // @Override
    public Object delete(Object entity) {
        return null;
    }*/

    @Override
    public Employee findById(Long aLong) {
        return null;
    }

    @Override
    public Employee save(Employee entity) {
        return null;
    }

    @Override
    public Employee update(Employee entity) {
        return null;
    }

    @Override
    public Employee delete(Employee entity) {
        return null;
    }

    @Override
    public Set findAll() {
        return null;
    }

    @Override
    public int deleteAll() {
        return 0;
    }

    public boolean insertData(String user, String password, String empnum, String empname, String address, String telephone) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("user", user);
        contentValues.put("password", password);
        contentValues.put("empnum", empnum);
        contentValues.put("empname", empname);
        contentValues.put("address", address);
        contentValues.put("telephone", telephone);
        long result = db.insert("user", null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select *from employee", null);
        return res;
    }
    public Cursor getData(LoginRepositoryImpl login)
    {
        SQLiteDatabase sq = login.getReadableDatabase();
        String[] columns = {"user", "password"};
        Cursor cr = sq.query("employee", columns, null, null, null, null, null);
        return cr;
    }

}
