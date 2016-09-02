package com.example.osman.restaurantmsandroid.repositories.Impl;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.osman.restaurantmsandroid.conf.databases.database.DBConstants;

import com.example.osman.restaurantmsandroid.domain.Order;
import com.example.osman.restaurantmsandroid.repositories.OrderRepository;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Osman on 2016-04-24.
 */
public class OrderRepositoryImpl extends SQLiteOpenHelper implements OrderRepository{
    public static final String TABLE_NAME = "orderTable";
    private SQLiteDatabase db;

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_ORDER_NUMBER = "orderNum";
    public static final String COLUMN_ORDER_DATE = "orderDate";

    // Database creation sql statement
    private static final String DATABASE_CREATE = " CREATE TABLE "
            + TABLE_NAME + "("
            + COLUMN_ID + " INTEGER  PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_ORDER_NUMBER + " TEXT  NOT NULL , "
            + COLUMN_ORDER_DATE + " TEXT NOT NULL );";


    public OrderRepositoryImpl(Context context) {
        super(context, DBConstants.DATABASE_NAME, null, DBConstants.DATABASE_VERSION);
    }

    public void open() throws SQLException {
        db = this.getWritableDatabase();
    }

    public void close() {
        this.close();
    }

    @Override
    public Order findById(Long id) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(
                TABLE_NAME,
                new String[]{
                        COLUMN_ID,
                        COLUMN_ORDER_NUMBER,
                        COLUMN_ORDER_DATE},
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(id)},
                null,
                null,
                null,
                null);
        if (cursor.moveToFirst()) {
            final Order order = new Order.Builder()
                    .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                    .orderNum(cursor.getInt(cursor.getColumnIndex(COLUMN_ORDER_NUMBER)))
                    .orderDate(cursor.getString(cursor.getColumnIndex(COLUMN_ORDER_DATE)))
                    .build();
            return order;
        } else {
            return null;
        }
    }

    @Override
    public Order save(Order entity) {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_ORDER_NUMBER, entity.getOrderNum());
        values.put(COLUMN_ORDER_DATE, entity.getOrderDate());

        long id = db.insertOrThrow(TABLE_NAME, null, values);
        Order insertedEntity = new Order.Builder()
                .copy(entity)
                .id(new Long(id))
                .build();
        return insertedEntity;
    }

    @Override
    public Order update(Order entity) {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_ORDER_NUMBER, entity.getOrderNum());
        values.put(COLUMN_ORDER_DATE, entity.getOrderDate());

        db.update(
                TABLE_NAME,
                values,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())}
        );
        return entity;
    }

    @Override
    public Order delete(Order entity) {
        open();
        db.delete(
                TABLE_NAME,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())});
        return entity;
    }

    @Override
    public Set<Order> findAll() {
        SQLiteDatabase db = this.getReadableDatabase();
        Set<Order> orders = new HashSet<>();
        open();
        Cursor cursor = db.query(TABLE_NAME, null,null,null,null,null,null);
        if (cursor.moveToFirst()) {
            do {
                final Order order = new Order.Builder()
                        .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                        .orderNum(cursor.getInt(cursor.getColumnIndex(COLUMN_ORDER_NUMBER)))
                        .orderDate(cursor.getString(cursor.getColumnIndex(COLUMN_ORDER_DATE)))
                        .build();
                orders.add(order);
            } while (cursor.moveToNext());
        }
        return orders;
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