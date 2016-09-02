package com.example.osman.restaurantmsandroid.services;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.test.AndroidTestCase;

import com.example.osman.restaurantmsandroid.conf.databases.util.App;
import com.example.osman.restaurantmsandroid.domain.Employee;
import com.example.osman.restaurantmsandroid.services.Impl.ActivateManagerImpl;

import junit.framework.Assert;

/**
 * Created by Osman on 2016-05-08.
 */
public class ActivateManagerServiceTest extends AndroidTestCase {
    private ActivateManagerImpl activateService;
    private boolean isBound;
    Employee employee;

    public ActivateManagerServiceTest(){}

    @Override
    public void setUp() throws Exception {
        super.setUp();
        Intent intent = new Intent(App.getAppContext(), ActivateManagerImpl.class);
        App.getAppContext().bindService(intent, connection, Context.BIND_AUTO_CREATE);


    }

    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            ActivateManagerImpl.ActivateServiceLocalBinder binder
                    = (ActivateManagerImpl.ActivateServiceLocalBinder) service;
            activateService = binder.getService();
            isBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            isBound = false;

        }
    };

    public void testActivateAccount() throws Exception {
        String activate = activateService.activateManager("userManager","Manager01","Severide", "003", "Brooklyn", "0215555555", employee );
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


