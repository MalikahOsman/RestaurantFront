package com.example.osman.restaurantmsandroid.factories;

import com.example.osman.restaurantmsandroid.factories.employeetest.ChefFactoryTest;
import com.example.osman.restaurantmsandroid.factories.employeetest.CustomerFactoryTest;
import com.example.osman.restaurantmsandroid.factories.employeetest.DessertFactoryTest;
import com.example.osman.restaurantmsandroid.factories.employeetest.EmployeeAddressTypeTest;
import com.example.osman.restaurantmsandroid.factories.employeetest.EmployeeTest;
import com.example.osman.restaurantmsandroid.factories.employeetest.MainCourseFactoryTest;
import com.example.osman.restaurantmsandroid.factories.employeetest.ManagerFactoryTest;
import com.example.osman.restaurantmsandroid.factories.employeetest.PosFactoryTest;
import com.example.osman.restaurantmsandroid.factories.employeetest.StarterFactoryTest;
import com.example.osman.restaurantmsandroid.factories.employeetest.WaiterFactoryTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by Osman on 2016-04-19.
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({
        EmployeeAddressTypeTest.class,
        ChefFactoryTest.class,
        ManagerFactoryTest.class,
        PosFactoryTest.class,
        WaiterFactoryTest.class,
        StarterFactoryTest.class,
        MainCourseFactoryTest.class,
        DessertFactoryTest.class,
        CustomerFactoryTest.class,
        EmployeeTest.class})
public class AppUnitTestSuite {

}
