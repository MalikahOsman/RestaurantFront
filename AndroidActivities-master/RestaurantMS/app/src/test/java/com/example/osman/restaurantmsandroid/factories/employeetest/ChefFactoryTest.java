package com.example.osman.restaurantmsandroid.factories.employeetest;

import com.example.osman.restaurantmsandroid.domain.Chef;
import com.example.osman.restaurantmsandroid.factories.ChefFactory;

import junit.framework.Assert;

import org.junit.Test;

/**
 * Created by Osman on 2016-04-19.
 */
public class ChefFactoryTest {
    @Test
    public void testCreate() throws Exception {
        Chef chef = ChefFactory.getChefFactory("chefGouwa","0021","21","Gouwa","Kensington", "083", null);
        Assert.assertEquals("0021", chef.getPassword());

    }

    @Test
    public void testUpdate() throws Exception {
        Chef chef = ChefFactory.getChefFactory("chefGouwa","0021","21","Gouwa","Kensington", "083", null);
        Chef newChef = new Chef
                .Builder()
                .copy(chef)
                //.userName("chefGouwa")
                .address("Maitland")
                .build();
        Assert.assertEquals("0021", chef.getPassword());
        Assert.assertEquals("Maitland", newChef.getAddress());

    }
}
