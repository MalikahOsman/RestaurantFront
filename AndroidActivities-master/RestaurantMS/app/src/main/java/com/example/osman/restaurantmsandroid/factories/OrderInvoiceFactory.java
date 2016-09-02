package com.example.osman.restaurantmsandroid.factories;

import com.example.osman.restaurantmsandroid.domain.OrderInvoice;

/**
 * Created by Osman on 2016-04-24.
 */
public class OrderInvoiceFactory {
    public static OrderInvoice getOrderInvoice( String invoiceDate, double orderAmount, String invoiceStatus ){
        return new OrderInvoice.Builder()
                .invoiceDate(invoiceDate)
                .orderAmount(orderAmount)
                .invoiceStatus(invoiceStatus)
                .build();
    }
}
