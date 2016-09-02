package com.example.osman.restaurantmsandroid.factories.employeetest;

import com.example.osman.restaurantmsandroid.domain.POS_Cashier;
import com.example.osman.restaurantmsandroid.factories.PosFactory;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Osman on 2016-04-19.
 */
public class PosFactoryTest {

    @Test
    public void testCreateCashier() throws Exception {
        POS_Cashier cashier = PosFactory.getPOS_Cashier("posMelanie","0013","13","Melanie","Mowbray","084", null);
        Assert.assertEquals("0013", cashier.getPassword());
    }

    @Test
    public void testUpdateCashier() throws Exception {
        POS_Cashier cashier = PosFactory.getPOS_Cashier("posMelanie","0013","13","Melanie","Mowbray","084", null);
        POS_Cashier newCashier = new POS_Cashier
                .Builder()
                .copy(cashier)
                .telephone("0833")
                .password("0019")
                .build();
        Assert.assertEquals("0019", newCashier.getPassword());
        Assert.assertEquals("0833", newCashier.getTelephone());

        /*Assert.assertEquals("0021", chef.getPassword());
        Assert.assertEquals("Maitland", newChef.getAddress());*/
    }
}
