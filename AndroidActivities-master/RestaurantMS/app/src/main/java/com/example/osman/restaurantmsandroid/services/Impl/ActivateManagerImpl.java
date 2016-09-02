package com.example.osman.restaurantmsandroid.services.Impl;

import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import com.example.osman.restaurantmsandroid.conf.databases.util.App;
import com.example.osman.restaurantmsandroid.conf.databases.util.DomainState;
import com.example.osman.restaurantmsandroid.domain.Employee;
import com.example.osman.restaurantmsandroid.domain.RestaurantManager;
import com.example.osman.restaurantmsandroid.factories.ManagerFactory;
import com.example.osman.restaurantmsandroid.repositories.Impl.ManagerRepositoryImpl;
import com.example.osman.restaurantmsandroid.repositories.ManagerRepository;
import com.example.osman.restaurantmsandroid.services.ActivateManagerService;

/**
 * Created by Osman on 2016-05-08.
 */
public class ActivateManagerImpl extends RestaurantManager implements ActivateManagerService {
    private final IBinder localBinder = new ActivateServiceLocalBinder();
    Employee employee;
    private ManagerRepository repo;

    public ActivateManagerImpl() {
    }
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return localBinder;
    }

    public class ActivateServiceLocalBinder extends Binder {
        public ActivateManagerImpl getService() {
            return ActivateManagerImpl.this;
        }
    }
    @Override
    public String activateManager(String userName, String password, String empName, String empNum, String address, String telephone, Employee employee)
    {
        if (true) {
            RestaurantManager manager = ManagerFactory.getManagerFactory(userName, password, empName, empNum, address, telephone, employee);
            createManager(manager);
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

    private RestaurantManager createManager(RestaurantManager manager) {
        repo = new ManagerRepositoryImpl(App.getAppContext());
        return repo.save(manager);
    }
}

