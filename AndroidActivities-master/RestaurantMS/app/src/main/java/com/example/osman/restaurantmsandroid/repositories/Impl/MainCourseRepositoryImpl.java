package com.example.osman.restaurantmsandroid.repositories.Impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.osman.restaurantmsandroid.conf.databases.database.DBConstants;
import com.example.osman.restaurantmsandroid.domain.MainCourse;
import com.example.osman.restaurantmsandroid.repositories.MainCourseRepository;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Osman on 2016-04-27.
 */
public class MainCourseRepositoryImpl extends SQLiteOpenHelper implements MainCourseRepository{
    public static final String TABLE_NAME = "dessertTable";
    private SQLiteDatabase db;

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_MAINCOURSE_ID = "mainID";
    public static final String COLUMN_FOOD_ITEM = "foodItem";

    // Database creation sql statement
    private static final String DATABASE_CREATE = " CREATE TABLE "
            + TABLE_NAME + "("
            + COLUMN_ID + " INTEGER  PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_MAINCOURSE_ID + " TEXT  NOT NULL , "
            + COLUMN_FOOD_ITEM + " TEXT NOT NULL );";


    public MainCourseRepositoryImpl(Context context) {
        super(context, DBConstants.DATABASE_NAME, null, DBConstants.DATABASE_VERSION);
    }

    public void open() throws SQLException {
        db = this.getWritableDatabase();
    }

    public void close() {
        this.close();
    }

    @Override
    public MainCourse findById(Long id) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(
                TABLE_NAME,
                new String[]{
                        COLUMN_ID,
                        COLUMN_MAINCOURSE_ID,
                        COLUMN_FOOD_ITEM},
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(id)},
                null,
                null,
                null,
                null);
        if (cursor.moveToFirst()) {
            final MainCourse dessert = new MainCourse.Builder()
                    .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                    .mainID(cursor.getString(cursor.getColumnIndex(COLUMN_MAINCOURSE_ID)))
                    .foodItem(cursor.getString(cursor.getColumnIndex(COLUMN_FOOD_ITEM)))
                    .build();
            return dessert;
        } else {
            return null;
        }
    }

    @Override
    public MainCourse save(MainCourse entity) {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_MAINCOURSE_ID, entity.getMainID());
        values.put(COLUMN_FOOD_ITEM, entity.getFoodItem());

        long id = db.insertOrThrow(TABLE_NAME, null, values);
        MainCourse insertedEntity = new MainCourse.Builder()
                .copy(entity)
                .id(new Long(id))
                .build();
        return insertedEntity;
    }

    @Override
    public MainCourse update(MainCourse entity) {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_MAINCOURSE_ID, entity.getMainID());
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
    public MainCourse delete(MainCourse entity) {
        open();
        db.delete(
                TABLE_NAME,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())});
        return entity;
    }

    @Override
    public Set<MainCourse> findAll() {
        SQLiteDatabase db = this.getReadableDatabase();
        Set<MainCourse> mainCourses = new HashSet<>();
        open();
        Cursor cursor = db.query(TABLE_NAME, null,null,null,null,null,null);
        if (cursor.moveToFirst()) {
            do {
                final MainCourse mainC = new MainCourse.Builder()
                        .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                        .mainID(cursor.getString(cursor.getColumnIndex(COLUMN_MAINCOURSE_ID)))
                        .foodItem(cursor.getString(cursor.getColumnIndex(COLUMN_FOOD_ITEM)))
                        .build();
                mainCourses.add(mainC);
            } while (cursor.moveToNext());
        }
        return mainCourses;
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