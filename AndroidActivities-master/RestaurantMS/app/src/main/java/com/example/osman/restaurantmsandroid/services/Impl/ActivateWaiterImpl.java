package com.example.osman.restaurantmsandroid.services.Impl;

import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import com.example.osman.restaurantmsandroid.conf.databases.util.App;
import com.example.osman.restaurantmsandroid.conf.databases.util.DomainState;
import com.example.osman.restaurantmsandroid.domain.Employee;
import com.example.osman.restaurantmsandroid.domain.Waiter;
import com.example.osman.restaurantmsandroid.factories.WaiterFactory;
import com.example.osman.restaurantmsandroid.repositories.Impl.WaiterRepositoryImpl;
import com.example.osman.restaurantmsandroid.repositories.WaiterRepository;
import com.example.osman.restaurantmsandroid.services.ActivateWaiterService;

/**
 * Created by Osman on 2016-05-08.
 */
public class ActivateWaiterImpl extends Waiter implements ActivateWaiterService {
    private final IBinder localBinder = new ActivateServiceLocalBinder();
    Employee employee;
    private WaiterRepository repo;

    public ActivateWaiterImpl() {
    }
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return localBinder;
    }

    public class ActivateServiceLocalBinder extends Binder {
        public ActivateWaiterImpl getService() {
            return ActivateWaiterImpl.this;
        }
    }
    @Override
    public String activateWaiter(String userName, String password, String empName, String empNum, String address, String telephone, Employee employee)
    {
        if (true) {
            Waiter waiter = WaiterFactory.getWaiter(userName, password, empName, empNum, address, telephone, employee);
            createWaiter(waiter);
            return DomainState.ACTIVATED.name();
        } else {
            return DomainState.NOTACTIVATED.name();
        }
    }



    @Override
    public boolean isAccountActivated() {
        return repo.findAll().size()>0;
    }

    @Override
    public boolean deactivateAccount() {
        // CAll Intent Services
        int row = repo.deleteAll();
        return row > 0;
    }
    private Waiter createWaiter(Waiter waiter) {
        repo = new WaiterRepositoryImpl(App.getAppContext());
        return repo.save(waiter);
    }
}
