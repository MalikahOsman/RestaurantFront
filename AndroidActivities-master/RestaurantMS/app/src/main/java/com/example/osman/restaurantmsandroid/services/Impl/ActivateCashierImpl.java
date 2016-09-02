package com.example.osman.restaurantmsandroid.services.Impl;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.example.osman.restaurantmsandroid.conf.databases.util.App;
import com.example.osman.restaurantmsandroid.conf.databases.util.DomainState;
import com.example.osman.restaurantmsandroid.domain.Employee;
import com.example.osman.restaurantmsandroid.domain.POS_Cashier;
import com.example.osman.restaurantmsandroid.factories.PosFactory;
import com.example.osman.restaurantmsandroid.repositories.Impl.PosRepositoryImpl;
import com.example.osman.restaurantmsandroid.repositories.PosRepository;
import com.example.osman.restaurantmsandroid.services.ActivateCashierService;


/**
 * Created by Osman on 2016-05-08.
 */
public class ActivateCashierImpl extends Service implements ActivateCashierService{

    private final IBinder localBinder = new ActivateServiceLocalBinder();
    PosRepository repo;
    public ActivateCashierImpl() {
    }

    @Override
    public String activateCashier(String userName, String password, String empName, String empNum, String address, String telephone, Employee employee) {
        if (true) {
            POS_Cashier cashier = PosFactory.getPOS_Cashier(userName, password, empName, empNum, address, telephone, employee);
//            createSettings(settings);
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
        int rows = repo.deleteAll();
        return rows > 0;
    }


    @Override
    public IBinder onBind(Intent intent) {
        return localBinder;
    }

    public class ActivateServiceLocalBinder extends Binder {
        public ActivateCashierImpl getService() {
            return ActivateCashierImpl.this;
        }
    }

    private POS_Cashier createCashier(POS_Cashier cashier) {
        repo = new PosRepositoryImpl(App.getAppContext());
        return repo.save(cashier);
    }
}