package com.example.osman.restaurantmsandroid.factories;

import com.example.osman.restaurantmsandroid.domain.Menu;
import com.example.osman.restaurantmsandroid.domain.Starter;

/**
 * Created by Osman on 2016-04-27.
 */
public class StarterFactory  {
    public static Starter getStarter(String starterID, String foodItem, Menu menu){
        return new Starter.Builder()
                .starterID(starterID)
                .foodItem(foodItem)
                .menu(menu)
                .build();

    }
}
