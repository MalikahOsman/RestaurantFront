package com.example.osman.restaurantmsandroid.services;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.test.AndroidTestCase;

import com.example.osman.restaurantmsandroid.conf.databases.util.App;
import com.example.osman.restaurantmsandroid.conf.databases.util.GlobalContext;
import com.example.osman.restaurantmsandroid.domain.Order;
import com.example.osman.restaurantmsandroid.factories.OrderFactory;
import com.example.osman.restaurantmsandroid.services.Impl.AddOrderServiceImpl;

import junit.framework.Assert;

import java.util.Set;

/**
 * Created by Osman on 2016-06-05.
 */
public class AddOrderServiceTest extends AndroidTestCase {

    private AddOrderServiceImpl addOrderService;
    private Boolean isBound;
    private static final String TAG = "ORDER SERVICE TEST";

    @Override
    public void setUp() throws Exception {
        super.setUp();
        Intent intent = new Intent(App.getAppContext(), AddOrderServiceImpl.class);
        GlobalContext.context = this.getContext();
        addOrderService = AddOrderServiceImpl.getInstance();
        App.getAppContext().bindService(intent, connection, Context.BIND_AUTO_CREATE);
    }

    public ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            AddOrderServiceImpl.AddOrderlocalBinder binder =
                    (AddOrderServiceImpl.AddOrderlocalBinder) service;
            addOrderService = binder.getService();
            isBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            isBound = false;
        }
    };



    public void testCreateEntities() throws Exception {
        Order order = OrderFactory
                .getOrder(101,"12/05/2016");
        Order newOrder =  addOrderService.save(order);
        Assert.assertEquals(TAG + " CREATE", newOrder);
        Assert.assertNotNull(newOrder);
    }

    public void testCreateAndFindListOfEntities() throws Exception {
        Order createOrder1 = OrderFactory
                .getOrder(102, "12/06/2016");
        Order createOrder2 = OrderFactory
                .getOrder(103 ,"12/07/2016");
        Order createOrder3 = OrderFactory
                .getOrder(104,"12/08/2016");

        addOrderService.save(createOrder1);
        addOrderService.save(createOrder2);
        addOrderService.save(createOrder3);

        Set<Order> orderSet = addOrderService.findAll();
        Assert.assertTrue(orderSet.size() > 2);
    }

}
