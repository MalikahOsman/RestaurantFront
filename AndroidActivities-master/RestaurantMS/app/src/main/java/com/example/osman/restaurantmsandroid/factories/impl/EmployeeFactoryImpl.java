package com.example.osman.restaurantmsandroid.factories.impl;

import com.example.osman.restaurantmsandroid.domain.Employee;

/**
 * Created by Osman on 2016-04-18.
 */
public class EmployeeFactoryImpl  {

    private static EmployeeFactoryImpl factory =null;

    private EmployeeFactoryImpl()
    {}

    public static EmployeeFactoryImpl getInstance(){
        if(factory == null)
            factory = new EmployeeFactoryImpl();
        return factory;
    }

    public Employee createEmployee(String empNum, String empName, String address, String telephone) {
        return new Employee.Builder()
                .empNum(empNum)
                .empName(empName)
                .address(address)
                .telephone(telephone)
                .build();
    }

}
