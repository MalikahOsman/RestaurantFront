package com.example.osman.restaurantmsandroid.factories.employeetest;

import com.example.osman.restaurantmsandroid.domain.Customer;
import com.example.osman.restaurantmsandroid.factories.CustomerFactory;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Osman on 2016-04-27.
 */
public class CustomerFactoryTest {
    @Test
    public void testCreateCustomer() throws Exception {
        Customer customer = CustomerFactory.getCustomer("Lacy","153");
        Assert.assertEquals("Lacy", customer.getCustName());

    }

    @Test
    public void testUpdateCustomer() throws Exception {
        Customer customer = CustomerFactory.getCustomer("Lacy","153");
        Customer newCustomer = new Customer
                .Builder()
                .copy(customer)
                .custNum("155")
                .build();
        Assert.assertEquals("155", newCustomer.getCustNum());

    }
}
