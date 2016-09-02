package com.example.osman.restaurantmsandroid.repositories.Impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.osman.restaurantmsandroid.conf.databases.database.DBConstants;
import com.example.osman.restaurantmsandroid.domain.Dessert;
import com.example.osman.restaurantmsandroid.repositories.DessertRepository;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Osman on 2016-04-27.
 */
public class DessertRepositoryImpl extends SQLiteOpenHelper implements DessertRepository{
    public static final String TABLE_NAME = "dessertTable";
    private SQLiteDatabase db;

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_DESSERT_ID = "dessertID";
    public static final String COLUMN_FOOD_ITEM = "foodItem";

    // Database creation sql statement
    private static final String DATABASE_CREATE = " CREATE TABLE "
            + TABLE_NAME + "("
            + COLUMN_ID + " INTEGER  PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_DESSERT_ID + " TEXT  NOT NULL , "
            + COLUMN_FOOD_ITEM + " TEXT NOT NULL );";


    public DessertRepositoryImpl(Context context) {
        super(context, DBConstants.DATABASE_NAME, null, DBConstants.DATABASE_VERSION);
    }

    public void open() throws SQLException {
        db = this.getWritableDatabase();
    }

    public void close() {
        this.close();
    }

    @Override
    public Dessert findById(Long id) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(
                TABLE_NAME,
                new String[]{
                        COLUMN_ID,
                        COLUMN_DESSERT_ID,
                        COLUMN_FOOD_ITEM},
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(id)},
                null,
                null,
                null,
                null);
        if (cursor.moveToFirst()) {
            final Dessert dessert = new Dessert.Builder()
                    .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                    .dessertID(cursor.getString(cursor.getColumnIndex(COLUMN_DESSERT_ID)))
                    .foodItem(cursor.getString(cursor.getColumnIndex(COLUMN_FOOD_ITEM)))
                    .build();
            return dessert;
        } else {
            return null;
        }
    }

    @Override
    public Dessert save(Dessert entity) {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_DESSERT_ID, entity.getDessertID());
        values.put(COLUMN_FOOD_ITEM, entity.getFoodItem());

        long id = db.insertOrThrow(TABLE_NAME, null, values);
        Dessert insertedEntity = new Dessert.Builder()
                .copy(entity)
                .id(new Long(id))
                .build();
        return insertedEntity;
    }

    @Override
    public Dessert update(Dessert entity) {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_DESSERT_ID, entity.getDessertID());
        values.put(COLUMN_FOOD_ITEM, entity.getFoodItem());

        db.update(
                TABLE_NAME,
                values,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())}
        );
        return entity;
    }

    @Override
    public Dessert delete(Dessert entity) {
        open();
        db.delete(
                TABLE_NAME,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())});
        return entity;
    }

    @Override
    public Set<Dessert> findAll() {
        SQLiteDatabase db = this.getReadableDatabase();
        Set<Dessert> desserts = new HashSet<>();
        open();
        Cursor cursor = db.query(TABLE_NAME, null,null,null,null,null,null);
        if (cursor.moveToFirst()) {
            do {
                final Dessert dessert = new Dessert.Builder()
                        .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                        .dessertID(cursor.getString(cursor.getColumnIndex(COLUMN_DESSERT_ID)))
                        .foodItem(cursor.getString(cursor.getColumnIndex(COLUMN_FOOD_ITEM)))
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