package com.example.osman.restaurantmsandroid.factories.employeetest;

import com.example.osman.restaurantmsandroid.domain.Starter;
import com.example.osman.restaurantmsandroid.factories.StarterFactory;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Osman on 2016-04-28.
 */
public class StarterFactoryTest {
    @Test
    public void testCreate() throws Exception {
        Starter starter = StarterFactory.getStarter("str02","Samoosa", null);
        Assert.assertEquals("str02", starter.getStarterID());
    }

    @Test
    public void testUpdate() throws Exception {
        Starter starter = StarterFactory.getStarter("str02","Samoosa", null);
        Starter newStarter = new Starter
                .Builder()
                .copy(starter)
                .starterID("str33")
                .build();
        Assert.assertEquals("str33", newStarter.getStarterID());

    }
}
