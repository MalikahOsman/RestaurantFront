package com.example.osman.restaurantmsandroid.factories;

import com.example.osman.restaurantmsandroid.domain.Employee;
import com.example.osman.restaurantmsandroid.domain.POS_Cashier;

/**
 * Created by Osman on 2016-04-19.
 */
public class PosFactory {
    public static POS_Cashier getPOS_Cashier( String userName, String pword, String empNum, String empName, String address, String telephone, Employee employee )
    {
        return new POS_Cashier.Builder()
                .userName(userName)
                .password(pword)
                .empNum(empNum)
                .empName(empName)
                .address(address)
                .telephone(telephone)
                .employee(employee)
                .build();
    }
}
