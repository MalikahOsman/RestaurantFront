package com.example.osman.restaurantmsandroid.services.Impl;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import com.example.osman.restaurantmsandroid.conf.databases.util.App;
import com.example.osman.restaurantmsandroid.conf.databases.util.DomainState;
import com.example.osman.restaurantmsandroid.domain.Chef;
import com.example.osman.restaurantmsandroid.domain.Employee;
import com.example.osman.restaurantmsandroid.factories.ChefFactory;
import com.example.osman.restaurantmsandroid.repositories.ChefRepository;
import com.example.osman.restaurantmsandroid.repositories.Impl.ChefRepositoryImpl;
import com.example.osman.restaurantmsandroid.services.ActivateChefService;
/**
 * Created by Osman on 2016-05-07.
 */
public class ActivateChefImpl extends Chef implements ActivateChefService {
    private final IBinder localBinder = new ActivateServiceLocalBinder();
    Employee employee;
    private ChefRepository repo;

    public ActivateChefImpl() {
    }
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return localBinder;
    }

    public class ActivateServiceLocalBinder extends Binder {
        public ActivateChefImpl getService() {
            return ActivateChefImpl.this;
        }
    }
    @Override
    public String activateChef(String userName, String password, String empName, String empNum, String address, String telephone, Employee employee)
    {
        if (true) {
            Chef chef = ChefFactory.getChefFactory(userName, password, empName, empNum, address, telephone, employee);
            createChef(chef);
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

    private Chef createChef(Chef chef) {
        repo = new ChefRepositoryImpl(App.getAppContext());
        return repo.save(chef);
    }
}
