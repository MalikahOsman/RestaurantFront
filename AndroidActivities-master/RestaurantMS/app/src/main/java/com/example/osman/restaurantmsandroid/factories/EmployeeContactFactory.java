package com.example.osman.restaurantmsandroid.factories;

import com.example.osman.restaurantmsandroid.domain.EmployeeContact;

/**
 * Created by Osman on 2016-04-27.
 */
public class EmployeeContactFactory {
    public static EmployeeContact getContact(String contactTypeId, String contactValue, String status, String date)
    {
        return new EmployeeContact.Builder()
                .contactTypeId(contactTypeId)
                .contactValue(contactValue)
                .status(status)
                .date(date)
                .build();
    }
}
