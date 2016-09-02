package com.example.osman.restaurantmsandroid.factories;

import com.example.osman.restaurantmsandroid.domain.Dessert;
import com.example.osman.restaurantmsandroid.domain.Menu;

/**
 * Created by Osman on 2016-04-27.
 */
public class DessertFactory {
    public static Dessert getDessert(String dessertID, String foodItem, Menu menu){
        return new Dessert.Builder()
                .dessertID(dessertID)
                .foodItem(foodItem)
                .menu(menu)
                .build();

    }
}
