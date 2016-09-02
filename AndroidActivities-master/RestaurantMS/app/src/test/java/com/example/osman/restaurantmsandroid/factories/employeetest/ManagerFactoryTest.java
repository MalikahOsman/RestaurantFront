package com.example.osman.restaurantmsandroid.factories.employeetest;

import com.example.osman.restaurantmsandroid.domain.RestaurantManager;
import com.example.osman.restaurantmsandroid.factories.ManagerFactory;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Osman on 2016-04-19.
 */
public class ManagerFactoryTest {
    @Test
    public void testCreateManager() throws Exception {
        RestaurantManager manager = ManagerFactory.getManagerFactory("managerMushfeeqah","0012","12","Mushfeeqah","Koeberg","021", null);
        Assert.assertEquals("0012", manager.getPassword());
    }

    @Test
    public void testUpdateManager() throws Exception {
        RestaurantManager waiter = ManagerFactory.getManagerFactory("managerMushfeeqah","0012","12","Mushfeeqah","Koeberg","021", null);
        RestaurantManager newWaiter = new RestaurantManager
                .Builder()
                .copy(waiter)
                .userName("managerYusrah")
                .password("0012")
                .build();
        Assert.assertEquals("0012", newWaiter.getPassword());

    }
}
