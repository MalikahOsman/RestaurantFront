package com.example.osman.restaurantmsandroid.services.Impl;

import android.app.Service;
import android.os.IBinder;
import android.content.Intent;
import android.os.Binder;
import android.support.annotation.Nullable;

import com.example.osman.restaurantmsandroid.conf.databases.util.App;
import com.example.osman.restaurantmsandroid.conf.databases.util.DomainState;
import com.example.osman.restaurantmsandroid.conf.databases.util.GlobalContext;
import com.example.osman.restaurantmsandroid.domain.Order;
import com.example.osman.restaurantmsandroid.factories.OrderFactory;
import com.example.osman.restaurantmsandroid.repositories.Impl.OrderRepositoryImpl;
import com.example.osman.restaurantmsandroid.repositories.OrderRepository;
import com.example.osman.restaurantmsandroid.services.AddOrderService;

import java.util.Map;
import java.util.Set;

/**
 * Created by Osman on 2016-06-05.
 */
public class AddOrderServiceImpl extends Service implements AddOrderService {

    private final OrderRepository ordersRepository;

    private final IBinder localBinder = new AddOrderlocalBinder();

    private static AddOrderServiceImpl service = null;

    public static AddOrderServiceImpl getInstance(){
        if (service == null)
            service = new AddOrderServiceImpl();
        return service;
    }

    public AddOrderServiceImpl(OrderRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    public AddOrderServiceImpl() {
        ordersRepository = new OrderRepositoryImpl(App.getAppContext());
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return localBinder;
    }

    public class AddOrderlocalBinder extends Binder{
        public AddOrderServiceImpl getService(){
            return AddOrderServiceImpl.getInstance();
        }
    }

    @Override
    public Order findById(Long id) {
        return ordersRepository.findById(id);
    }

    @Override
    public Order save(Order entity) {
        return ordersRepository.save(entity);
    }

    @Override
    public Set<Order> findAll() {
        return ordersRepository.findAll();
    }
}
