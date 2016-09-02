package com.example.osman.restaurantmsandroid.repositories.Impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.osman.restaurantmsandroid.conf.databases.database.DBConstants;
import com.example.osman.restaurantmsandroid.domain.Customer;
import com.example.osman.restaurantmsandroid.repositories.CustomerRepository;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Osman on 2016-04-24.
 */
public class CustomerRepositoryImpl extends SQLiteOpenHelper implements CustomerRepository{
    public static final String TABLE_NAME = "customerTable";
    private SQLiteDatabase db;

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_CUSTOMER_NAME = "custName";
    public static final String COLUMN_CUSTOMER_NUMBER = "custNum";

    // Database creation sql statement
    private static final String DATABASE_CREATE = " CREATE TABLE "
            + TABLE_NAME + "("
            + COLUMN_ID + " INTEGER  PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_CUSTOMER_NAME + " TEXT  NOT NULL , "
            + COLUMN_CUSTOMER_NUMBER + " TEXT NOT NULL );";


    public CustomerRepositoryImpl(Context context) {
        super(context, DBConstants.DATABASE_NAME, null, DBConstants.DATABASE_VERSION);
    }

    public void open() throws SQLException {
        db = this.getWritableDatabase();
    }

    public void close() {
        this.close();
    }

    @Override
    public Customer findById(Long id) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(
                TABLE_NAME,
                new String[]{
                        COLUMN_ID,
                        COLUMN_CUSTOMER_NAME,
                        COLUMN_CUSTOMER_NUMBER},
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(id)},
                null,
                null,
                null,
                null);
        if (cursor.moveToFirst()) {
            final Customer customer = new Customer.Builder()
                    .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                    .custName(cursor.getString(cursor.getColumnIndex(COLUMN_CUSTOMER_NAME)))
                    .custNum(cursor.getString(cursor.getColumnIndex(COLUMN_CUSTOMER_NUMBER)))
                    .build();
            return customer;
        } else {
            return null;
        }
    }

    @Override
    public Customer save(Customer entity) {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_CUSTOMER_NAME, entity.getCustName());
        values.put(COLUMN_CUSTOMER_NUMBER, entity.getCustNum());

        long id = db.insertOrThrow(TABLE_NAME, null, values);
        Customer insertedEntity = new Customer.Builder()
                .copy(entity)
                .id(new Long(id))
                .build();
        return insertedEntity;
    }

    @Override
    public Customer update(Customer entity) {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_CUSTOMER_NAME, entity.getCustName());
        values.put(COLUMN_CUSTOMER_NUMBER, entity.getCustNum());

        db.update(
                TABLE_NAME,
                values,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())}
        );
        return entity;
    }

    @Override
    public Customer delete(Customer entity) {
        open();
        db.delete(
                TABLE_NAME,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())});
        return entity;
    }

    @Override
    public Set<Customer> findAll() {
        SQLiteDatabase db = this.getReadableDatabase();
        Set<Customer> restaurantManagers = new HashSet<>();
        open();
        Cursor cursor = db.query(TABLE_NAME, null,null,null,null,null,null);
        if (cursor.moveToFirst()) {
            do {
                final Customer restaurantManager = new Customer.Builder()
                        .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                        .custName(cursor.getString(cursor.getColumnIndex(COLUMN_CUSTOMER_NAME)))
                        .custNum(cursor.getString(cursor.getColumnIndex(COLUMN_CUSTOMER_NUMBER)))
                        .build();
                restaurantManagers.add(restaurantManager);
            } while (cursor.moveToNext());
        }
        return restaurantManagers;
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