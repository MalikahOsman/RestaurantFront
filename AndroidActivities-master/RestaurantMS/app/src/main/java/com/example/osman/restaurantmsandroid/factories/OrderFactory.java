package com.example.osman.restaurantmsandroid.factories;

import com.example.osman.restaurantmsandroid.domain.Order;

/**
 * Created by Osman on 2016-04-24.
 */
public class OrderFactory {
    public static Order getOrder( int orderNum, String orderDate) {
        return new Order.Builder()
                .orderNum(orderNum)
                .orderDate(orderDate)
                .build();
    }


}
