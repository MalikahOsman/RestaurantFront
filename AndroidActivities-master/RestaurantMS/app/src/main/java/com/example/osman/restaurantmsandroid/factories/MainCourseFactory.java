package com.example.osman.restaurantmsandroid.factories;

import com.example.osman.restaurantmsandroid.domain.MainCourse;
import com.example.osman.restaurantmsandroid.domain.Menu;

/**
 * Created by Osman on 2016-04-27.
 */
public class MainCourseFactory {
    public static MainCourse getMainCourse(String mainID, String foodItem, Menu menu){
        return new MainCourse.Builder()
                .mainID(mainID)
                .foodItem(foodItem)
                .menu(menu)
                .build();

    }
}
