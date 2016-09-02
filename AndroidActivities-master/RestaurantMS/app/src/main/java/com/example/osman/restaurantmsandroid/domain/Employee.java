package com.example.osman.restaurantmsandroid.domain;

import java.io.Serializable;

/**
 * Created by Osman on 2016-04-17.
 */

public class Employee implements Serializable{
    private Long id;
    private String empNum;
    private String empName;
    private String address;
    private String telephone;

    //private Role role;

    /*Employee nextStep;

    public void setNextStep(Employee nextStep)
    {
        this.nextStep = nextStep;
    }*/

    //public abstract String handleRequest(int request);

    private Employee()
    {

    }

    public Long getId() {
        return id;
    }
    public String getEmpNum() {
        return empNum;
    }
    public String getEmpName() {
        return empName;
    }
    public String getAddress() {
        return address;
    }
    public String getTelephone() {
        return telephone;
    }


    public Employee(Builder builder) {
        this.id = builder.id;
        this.empNum = builder.empNum;
        this.empName = builder.empName;
        this.address = builder.address;
        this.telephone = builder.telephone;
    }



    public static class Builder
    {
        private Long id;
        private String empNum;
        private String empName;
        private String address;
        private String telephone;

        public Builder id(Long value)
        {
            this.id = value;
            return this;
        }

        public Builder empNum(String value)
        {
            this.empNum = value;
            return this;
        }

        public Builder empName(String value)
        {
            this.empName = value;
            return this;
        }

        public Builder address(String value)
        {
            this.address = value;
            return this;
        }

        public Builder telephone(String value)
        {
            this.telephone = value;
            return this;
        }


        public Builder copy(Employee value) {
            this.id = value.id;
            this.empNum = value.empNum;
            this.empName = value.empName;
            this.address = value.address;
            this.telephone = value.telephone;
            return this;
        }

        public Employee build()
        {
            return new Employee(this);
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (id != null ? !id.equals(employee.id) : employee.id != null) return false;
        if (empNum != null ? !empNum.equals(employee.empNum) : employee.empNum != null)
            return false;
        if (empName != null ? !empName.equals(employee.empName) : employee.empName != null)
            return false;
        if (address != null ? !address.equals(employee.address) : employee.address != null)
            return false;
        return telephone != null ? telephone.equals(employee.telephone) : employee.telephone == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (empNum != null ? empNum.hashCode() : 0);
        result = 31 * result + (empName != null ? empName.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (telephone != null ? telephone.hashCode() : 0);
        return result;
    }
}
