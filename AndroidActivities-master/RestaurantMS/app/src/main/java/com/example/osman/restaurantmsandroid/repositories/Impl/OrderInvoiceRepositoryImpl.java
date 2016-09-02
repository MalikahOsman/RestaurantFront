package com.example.osman.restaurantmsandroid.repositories.Impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.osman.restaurantmsandroid.conf.databases.database.DBConstants;
import com.example.osman.restaurantmsandroid.domain.OrderInvoice;
import com.example.osman.restaurantmsandroid.repositories.OrderInvoiceRepository;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Osman on 2016-04-24.
 */
public class OrderInvoiceRepositoryImpl extends SQLiteOpenHelper implements OrderInvoiceRepository {
    public static final String TABLE_NAME = "orderInvoiceTable";
    private SQLiteDatabase db;

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_INVOICE_DATE = "invoiceDate";
    public static final String COLUMN_ORDER_AMOUNT = "orderAmount";
    public static final String COLUMN_INVOICE_STATUS = "invoiceStatus";


    // Database creation sql statement
    private static final String DATABASE_CREATE = " CREATE TABLE "
            + TABLE_NAME + "("
            + COLUMN_ID + " INTEGER  PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_INVOICE_DATE + " TEXT  NOT NULL , "
            + COLUMN_ORDER_AMOUNT + " TEXT  NOT NULL , "
            + COLUMN_INVOICE_STATUS + " TEXT NOT NULL );";


    public OrderInvoiceRepositoryImpl(Context context) {
        super(context, DBConstants.DATABASE_NAME, null, DBConstants.DATABASE_VERSION);
    }

    public void open() throws SQLException {
        db = this.getWritableDatabase();
    }

    public void close() {
        this.close();
    }

    @Override
    public OrderInvoice findById(Long id) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(
                TABLE_NAME,
                new String[]{
                        COLUMN_ID,
                        COLUMN_INVOICE_DATE,
                        COLUMN_ORDER_AMOUNT,
                        COLUMN_INVOICE_STATUS},
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(id)},
                null,
                null,
                null,
                null);
        if (cursor.moveToFirst()) {
            final OrderInvoice dessert = new OrderInvoice.Builder()
                    .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                    .invoiceDate(cursor.getString(cursor.getColumnIndex(COLUMN_INVOICE_DATE)))
                    .orderAmount(cursor.getDouble(cursor.getColumnIndex(COLUMN_ORDER_AMOUNT)))
                    .invoiceStatus(cursor.getString(cursor.getColumnIndex(COLUMN_ORDER_AMOUNT)))
                    .build();
            return dessert;
        } else {
            return null;
        }
    }

    @Override
    public OrderInvoice save(OrderInvoice entity) {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_INVOICE_DATE, entity.getInvoiceDate());
        values.put(COLUMN_ORDER_AMOUNT, entity.getOrderAmount());
        values.put(COLUMN_INVOICE_STATUS, entity.getInvoiceStatus());

        long id = db.insertOrThrow(TABLE_NAME, null, values);
        OrderInvoice insertedEntity = new OrderInvoice.Builder()
                .copy(entity)
                .id(new Long(id))
                .build();
        return insertedEntity;
    }

    @Override
    public OrderInvoice update(OrderInvoice entity) {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_INVOICE_DATE, entity.getInvoiceDate());
        values.put(COLUMN_ORDER_AMOUNT, entity.getOrderAmount());
        values.put(COLUMN_INVOICE_STATUS, entity.getInvoiceStatus());
        db.update(
                TABLE_NAME,
                values,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())}
        );
        return entity;
    }

    @Override
    public OrderInvoice delete(OrderInvoice entity) {
        open();
        db.delete(
                TABLE_NAME,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())});
        return entity;
    }

    @Override
    public Set<OrderInvoice> findAll() {
        SQLiteDatabase db = this.getReadableDatabase();
        Set<OrderInvoice> desserts = new HashSet<>();
        open();
        Cursor cursor = db.query(TABLE_NAME, null,null,null,null,null,null);
        if (cursor.moveToFirst()) {
            do {
                final OrderInvoice dessert = new OrderInvoice.Builder()
                        .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                        .invoiceDate(cursor.getString(cursor.getColumnIndex(COLUMN_INVOICE_DATE)))
                        .orderAmount(cursor.getDouble(cursor.getColumnIndex(COLUMN_ORDER_AMOUNT)))
                        .invoiceStatus(cursor.getString(cursor.getColumnIndex(COLUMN_INVOICE_STATUS)))
                        .build();
                desserts.add(dessert);
            } while (cursor.moveToNext());
        }
        return desserts;
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