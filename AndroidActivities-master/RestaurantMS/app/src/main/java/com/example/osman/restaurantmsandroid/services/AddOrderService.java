package com.example.osman.restaurantmsandroid.services;

import com.example.osman.restaurantmsandroid.domain.Order;

import java.util.Map;
import java.util.Set;

/**
 * Created by Osman on 2016-06-05.
 */
public interface AddOrderService {
   // String create_order(Map<String, String> values);

    /*boolean isOrderCreated();

    boolean destroyOrder();*/

    Order findById(Long id);

    Order save(Order entity);

    Set<Order> findAll();
}

