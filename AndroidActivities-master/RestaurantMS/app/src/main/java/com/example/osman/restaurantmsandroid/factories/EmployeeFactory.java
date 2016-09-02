package com.example.osman.restaurantmsandroid.factories;

import com.example.osman.restaurantmsandroid.domain.Employee;

/**
 * Created by Osman on 2016-04-18.
 */
public interface EmployeeFactory {
    Employee createEmployee (String empNum, String empName, String address, String telephone );
}
