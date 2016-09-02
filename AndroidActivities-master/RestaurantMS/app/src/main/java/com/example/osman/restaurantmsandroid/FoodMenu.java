package com.example.osman.restaurantmsandroid;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class FoodMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_menu);


    ListView foodListV;
    SQLiteDatabase sqLiteDatabase;
    //DataBaseHelper dataBaseHelper;

    Cursor cursor;



    /*
    * ListView listView;
    SQLiteDatabase sqLiteDatabase;
    DataBaseHelper dataBaseHelper;
    Cursor cursor;
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_displaycust);
        dataBaseHelper = new DataBaseHelper(this);
        listView = (ListView)findViewById(R.id.listView);
        sqLiteDatabase = dataBaseHelper.getReadableDatabase();
        cursor = dataBaseHelper.getCustomerData(sqLiteDatabase);
    }
    * */
    }
}
