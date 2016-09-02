package com.example.osman.restaurantmsandroid.factories;

import com.example.osman.restaurantmsandroid.domain.Employee;
import com.example.osman.restaurantmsandroid.domain.Waiter;

/**
 * Created by Osman on 2016-04-19.
 */
public class WaiterFactory {
    public static Waiter getWaiter(String user, String pword, String empNum, String empName, String address, String telephone, Employee employee)
    {
        return new Waiter.Builder()
                .userName(user)
                .password(pword)
                .empNum(empNum)
                .empName(empName)
                .address(address)
                .telephone(telephone)
                .employee(employee)
                .build();
    }
}
