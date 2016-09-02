package com.example.osman.restaurantmsandroid.services;

import com.example.osman.restaurantmsandroid.domain.Employee;

/**
 * Created by Osman on 2016-05-08.
 */
public interface ActivateManagerService {
    String activateManager(String userName, String password, String empName, String empNum, String address, String telephone, Employee employee);

    boolean isAccountActivated();

    boolean deactivateAccount();
}
