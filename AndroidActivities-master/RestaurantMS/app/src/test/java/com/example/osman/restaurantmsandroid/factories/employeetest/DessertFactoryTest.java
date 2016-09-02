package com.example.osman.restaurantmsandroid.factories.employeetest;

import com.example.osman.restaurantmsandroid.domain.Dessert;
import com.example.osman.restaurantmsandroid.factories.DessertFactory;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Osman on 2016-04-28.
 */
public class DessertFactoryTest {
    @Test
    public void testCreate() throws Exception {
        Dessert dessert = DessertFactory.getDessert("des01","Cheese cake", null);
        Assert.assertEquals("Cheese cake", dessert.getFoodItem());
    }

    @Test
    public void testUpdate() throws Exception {
        Dessert dessert = DessertFactory.getDessert("des01","Cheese cake", null);
        Dessert newDessert = new Dessert
                .Builder()
                .copy(dessert)
                .foodItem("Carrot cake")
                .build();
        Assert.assertEquals("Carrot cake", newDessert.getFoodItem());

    }
}
