package com.example.osman.restaurantmsandroid.factories;

import com.example.osman.restaurantmsandroid.domain.EmployeeAddress;

import java.util.Date;

/**
 * Created by Osman on 2016-04-18.
 */
public class EmployeeAddressFactory {
    public static EmployeeAddress getAddress(String description, String postalcode, String address,  String date)
    {
        return new EmployeeAddress.Builder()
                .description(description)
                .addressTypeId(address)
                .postalCode(postalcode)
                .date(date)
                .build();

    }
}
