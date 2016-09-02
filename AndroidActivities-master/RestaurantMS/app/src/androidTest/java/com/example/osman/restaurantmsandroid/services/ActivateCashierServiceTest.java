package com.example.osman.restaurantmsandroid.services;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.test.AndroidTestCase;

import com.example.osman.restaurantmsandroid.conf.databases.util.App;
import com.example.osman.restaurantmsandroid.domain.Employee;
import com.example.osman.restaurantmsandroid.services.Impl.ActivateCashierImpl;

import junit.framework.Assert;

/**
 * Created by Osman on 2016-05-08.
 */
public class ActivateCashierServiceTest extends AndroidTestCase {
    private ActivateCashierImpl activateService;
    private boolean isBound;
    Employee employee;

    public ActivateCashierServiceTest(){}

    @Override
    public void setUp() throws Exception {
        super.setUp();
        Intent intent = new Intent(App.getAppContext(), ActivateCashierImpl.class);
        App.getAppContext().bindService(intent, connection, Context.BIND_AUTO_CREATE);


    }

    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            ActivateCashierImpl.ActivateServiceLocalBinder binder
                    = (ActivateCashierImpl.ActivateServiceLocalBinder) service;
            activateService = binder.getService();
            isBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            isBound = false;

        }
    };

    public void testActivateAccount() throws Exception {
        String activate = activateService.activateCashier("userCashier","cashier01","Lucy", "002", "Woodstock", "0214444444", employee );
        Assert.assertEquals("ACTIVATED", activate);

    }

    public void testIsAccountActivated() throws Exception {
        Boolean activated = activateService.isAccountActivated();
        Assert.assertTrue("ACTIVATED", activated);

    }

    public void testDeactivateAccount() throws Exception {
        Boolean deactivated = activateService.deactivateAccount();
        Assert.assertTrue("ACTIVATED", deactivated);

    }
}

