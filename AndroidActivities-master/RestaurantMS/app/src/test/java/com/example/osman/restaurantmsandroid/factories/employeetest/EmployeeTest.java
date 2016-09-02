package com.example.osman.restaurantmsandroid.factories.employeetest;

import com.example.osman.restaurantmsandroid.domain.Employee;
import com.example.osman.restaurantmsandroid.factories.EmployeeFactory;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Osman on 2016-04-18.
 */
public class EmployeeTest {
    private EmployeeFactory factory;

    /*@Before
    public void setUp() throws Exception {
        factory = EmployeeFactoryImpl.getInstance();

    }*/

    /*@Test
    public void testEmployee() throws Exception {
        Assert.assertEquals(factory.createEmployee(),"");
    }*/

    @Test
    public void testEmployee() throws Exception {
        Employee emp = new Employee.Builder()
                .empNum("0016")
                .empName("Malikah")
                .address("54 Montague Cape Town")
                .telephone("0834781551")
                .build();

        Assert.assertEquals(emp.getEmpNum(), "0016");

        Employee newEmployee = new Employee.Builder()
                .copy(emp)
                .empName("Malikah").build();

        Assert.assertEquals(newEmployee.getEmpNum(), "0016");
        Assert.assertEquals(newEmployee.getEmpName(), "Malikah");
    }
}
