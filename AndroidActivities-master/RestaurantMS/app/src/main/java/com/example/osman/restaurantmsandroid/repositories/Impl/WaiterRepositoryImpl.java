package com.example.osman.restaurantmsandroid.repositories.Impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.osman.restaurantmsandroid.conf.databases.database.DBConstants;
import com.example.osman.restaurantmsandroid.domain.Waiter;
import com.example.osman.restaurantmsandroid.repositories.WaiterRepository;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Osman on 2016-04-23.
 */
public class WaiterRepositoryImpl extends SQLiteOpenHelper implements WaiterRepository{
    public static final String TABLE_NAME = "waiterTable";
    private SQLiteDatabase db;

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_USERNAME = "userName";
    public static final String COLUMN_PASSWORD = "password";
    public static final String COLUMN_EMPLOYEE_NUMBER = "empNum";
    public static final String COLUMN_EMPLOYEE_NAME = "empName";
    public static final String COLUMN_ADDRESS = "address";
    public static final String COLUMN_TELEPHONE = "telephone";

    // Database creation sql statement
    private static final String DATABASE_CREATE = " CREATE TABLE "
            + TABLE_NAME + "("
            + COLUMN_ID + " INTEGER  PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_USERNAME + " TEXT  NOT NULL , "
            + COLUMN_PASSWORD + " TEXT  NOT NULL , "
            + COLUMN_EMPLOYEE_NUMBER + " TEXT  NOT NULL , "
            + COLUMN_EMPLOYEE_NAME + " TEXT  NOT NULL , "
            + COLUMN_ADDRESS + " TEXT  NOT NULL , "
            + COLUMN_TELEPHONE + " TEXT NOT NULL );";


    public WaiterRepositoryImpl(Context context) {
        super(context, DBConstants.DATABASE_NAME, null, DBConstants.DATABASE_VERSION);
    }

    public void open() throws SQLException {
        db = this.getWritableDatabase();
    }

    public void close() {
        this.close();
    }

    @Override
    public Waiter findById(Long id) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(
                TABLE_NAME,
                new String[]{
                        COLUMN_ID,
                        COLUMN_USERNAME,
                        COLUMN_PASSWORD,
                        COLUMN_EMPLOYEE_NUMBER,
                        COLUMN_EMPLOYEE_NAME,
                        COLUMN_ADDRESS,
                        COLUMN_TELEPHONE},
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(id)},
                null,
                null,
                null,
                null);
        if (cursor.moveToFirst()) {
            final Waiter Person = new Waiter.Builder()
                    .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                    .userName(cursor.getString(cursor.getColumnIndex(COLUMN_USERNAME)))
                    .password(cursor.getString(cursor.getColumnIndex(COLUMN_PASSWORD)))
                    .empNum(cursor.getString(cursor.getColumnIndex(COLUMN_EMPLOYEE_NUMBER)))
                    .empName(cursor.getString(cursor.getColumnIndex(COLUMN_EMPLOYEE_NAME)))
                    .address(cursor.getString(cursor.getColumnIndex(COLUMN_ADDRESS)))
                    .telephone(cursor.getString(cursor.getColumnIndex(COLUMN_TELEPHONE)))
                    .build();
            return Person;
        } else {
            return null;
        }
    }

    @Override
    public Waiter save(Waiter entity) {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_USERNAME, entity.getUserName());
        values.put(COLUMN_PASSWORD, entity.getPassword());
        values.put(COLUMN_EMPLOYEE_NUMBER, entity.getEmpNum());
        values.put(COLUMN_EMPLOYEE_NAME, entity.getEmpName());
        values.put(COLUMN_ADDRESS, entity.getAddress());
        values.put(COLUMN_TELEPHONE, entity.getTelephone());

        long id = db.insertOrThrow(TABLE_NAME, null, values);
        Waiter insertedEntity = new Waiter.Builder()
                .copy(entity)
                .id(new Long(id))
                .build();
        return insertedEntity;
    }

    @Override
    public Waiter update(Waiter entity) {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_USERNAME, entity.getUserName());
        values.put(COLUMN_PASSWORD, entity.getPassword());
        values.put(COLUMN_EMPLOYEE_NUMBER, entity.getEmpNum());
        values.put(COLUMN_EMPLOYEE_NAME, entity.getEmpName());
        values.put(COLUMN_ADDRESS, entity.getAddress());
        values.put(COLUMN_TELEPHONE, entity.getTelephone());

        db.update(
                TABLE_NAME,
                values,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())}
        );
        return entity;
    }

    @Override
    public Waiter delete(Waiter entity) {
        open();
        db.delete(
                TABLE_NAME,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())});
        return entity;
    }

    @Override
    public Set<Waiter> findAll() {
        SQLiteDatabase db = this.getReadableDatabase();
        Set<Waiter> waiters = new HashSet<>();
        open();
        Cursor cursor = db.query(TABLE_NAME, null,null,null,null,null,null);
        if (cursor.moveToFirst()) {
            do {
                final Waiter waiter = new Waiter.Builder()
                        .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                        .userName(cursor.getString(cursor.getColumnIndex(COLUMN_USERNAME)))
                        .password(cursor.getString(cursor.getColumnIndex(COLUMN_PASSWORD)))
                        .empNum(cursor.getString(cursor.getColumnIndex(COLUMN_EMPLOYEE_NUMBER)))
                        .empName(cursor.getString(cursor.getColumnIndex(COLUMN_EMPLOYEE_NAME)))
                        .address(cursor.getString(cursor.getColumnIndex(COLUMN_ADDRESS)))
                        .telephone(cursor.getString(cursor.getColumnIndex(COLUMN_TELEPHONE)))
                        .build();
                waiters.add(waiter);
            } while (cursor.moveToNext());
        }
        return waiters;
    }

    @Override
    public int deleteAll() {
        open();
        int rowsDeleted = db.delete(TABLE_NAME,null,null);
        close();
        return rowsDeleted;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(this.getClass().getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }
}