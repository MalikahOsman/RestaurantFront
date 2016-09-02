package com.example.osman.restaurantmsandroid.factories.employeetest;

import com.example.osman.restaurantmsandroid.domain.MainCourse;
import com.example.osman.restaurantmsandroid.factories.MainCourseFactory;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Osman on 2016-04-28.
 */
public class MainCourseFactoryTest {
    @Test
    public void testCreate() throws Exception {
        MainCourse main = MainCourseFactory.getMainCourse("main01","Tikka Chicken", null);
        Assert.assertEquals("Tikka Chicken", main.getFoodItem());
    }

    @Test
    public void testUpdate() throws Exception {
        MainCourse main = MainCourseFactory.getMainCourse("main01","Tikka Chicken", null);
        MainCourse newMain = new MainCourse
                .Builder()
                .copy(main)
                .mainID("main007")
                .build();
        Assert.assertEquals("main007", newMain.getMainID());

    }
}
