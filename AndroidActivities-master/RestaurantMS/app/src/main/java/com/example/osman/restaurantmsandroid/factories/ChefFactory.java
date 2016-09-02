package com.example.osman.restaurantmsandroid.factories;

import com.example.osman.restaurantmsandroid.domain.Chef;
import com.example.osman.restaurantmsandroid.domain.Employee;

/**
 * Created by Osman on 2016-04-19.
 */
public class ChefFactory {
    public static Chef getChefFactory( String userName, String password, String empName, String empNum, String address, String telephone, Employee employee){
        return new Chef.Builder()
                .userName(userName)
                .password(password)
                .empName(empName)
                .empNum(empNum)
                .address(address)
                .telephone(telephone)
                .employee(employee)
                .build();

    }
}
