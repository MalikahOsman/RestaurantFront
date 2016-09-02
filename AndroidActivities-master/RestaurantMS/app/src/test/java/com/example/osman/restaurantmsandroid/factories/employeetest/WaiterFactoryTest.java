package com.example.osman.restaurantmsandroid.factories.employeetest;

import com.example.osman.restaurantmsandroid.domain.Waiter;
import com.example.osman.restaurantmsandroid.factories.WaiterFactory;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Osman on 2016-04-19.
 */
public class WaiterFactoryTest {
    @Test
    public void testCreate() throws Exception {
        Waiter waiter = WaiterFactory.getWaiter("wtrZiyaad","0014","14","Ziyaad","Montague","032", null);
        Assert.assertEquals("0014", waiter.getPassword());
    }

    @Test
    public void testUpdate() throws Exception {
        Waiter waiter = WaiterFactory.getWaiter("wtrZiyaad","0014","14","Ziyaad","Montague","032", null);
        Waiter newWaiter = new Waiter
                .Builder()
                .copy(waiter)
                .userName("wtrZiddy")
                .password("0004")
                .build();
        Assert.assertEquals("0014", waiter.getPassword());
        Assert.assertEquals("wtrZiddy", newWaiter.getUserName());



    }
}
