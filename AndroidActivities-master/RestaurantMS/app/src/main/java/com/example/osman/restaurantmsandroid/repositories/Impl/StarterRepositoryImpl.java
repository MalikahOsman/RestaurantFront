package com.example.osman.restaurantmsandroid.repositories.Impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.osman.restaurantmsandroid.conf.databases.database.DBConstants;
import com.example.osman.restaurantmsandroid.domain.Starter;
import com.example.osman.restaurantmsandroid.repositories.StarterRepository;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Osman on 2016-04-27.
 */
public class StarterRepositoryImpl extends SQLiteOpenHelper implements StarterRepository{
    public static final String TABLE_NAME = "starterTable";
    private SQLiteDatabase db;

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_STARTER_ID = "starterID";
    public static final String COLUMN_FOOD_ITEM = "foodItem";

    // Database creation sql statement
    private static final String DATABASE_CREATE = " CREATE TABLE "
            + TABLE_NAME + "("
            + COLUMN_ID + " INTEGER  PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_STARTER_ID + " TEXT  NOT NULL , "
            + COLUMN_FOOD_ITEM + " TEXT NOT NULL );";


    public StarterRepositoryImpl(Context context) {
        super(context, DBConstants.DATABASE_NAME, null, DBConstants.DATABASE_VERSION);
    }

    public void open() throws SQLException {
        db = this.getWritableDatabase();
    }

    public void close() {
        this.close();
    }

    @Override
    public Starter findById(Long id) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(
                TABLE_NAME,
                new String[]{
                        COLUMN_ID,
                        COLUMN_STARTER_ID,
                        COLUMN_FOOD_ITEM},
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(id)},
                null,
                null,
                null,
                null);
        if (cursor.moveToFirst()) {
            final Starter starter = new Starter.Builder()
                    .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                    .starterID(cursor.getString(cursor.getColumnIndex(COLUMN_STARTER_ID)))
                    .foodItem(cursor.getString(cursor.getColumnIndex(COLUMN_FOOD_ITEM)))
                    .build();
            return starter;
        } else {
            return null;
        }
    }

    @Override
    public Starter save(Starter entity) {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_STARTER_ID, entity.getStarterID());
        values.put(COLUMN_FOOD_ITEM, entity.getFoodItem());

        long id = db.insertOrThrow(TABLE_NAME, null, values);
        Starter insertedEntity = new Starter.Builder()
                .copy(entity)
                .id(new Long(id))
                .build();
        return insertedEntity;
    }

    @Override
    public Starter update(Starter entity) {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_STARTER_ID, entity.getStarterID());
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
    public Starter delete(Starter entity) {
        open();
        db.delete(
                TABLE_NAME,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())});
        return entity;
    }

    @Override
    public Set<Starter> findAll() {
        SQLiteDatabase db = this.getReadableDatabase();
        Set<Starter> starters = new HashSet<>();
        open();
        Cursor cursor = db.query(TABLE_NAME, null,null,null,null,null,null);
        if (cursor.moveToFirst()) {
            do {
                final Starter start = new Starter.Builder()
                        .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                        .starterID(cursor.getString(cursor.getColumnIndex(COLUMN_STARTER_ID)))
                        .foodItem(cursor.getString(cursor.getColumnIndex(COLUMN_FOOD_ITEM)))
                        .build();
                starters.add(start);
            } while (cursor.moveToNext());
        }
        return starters;
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