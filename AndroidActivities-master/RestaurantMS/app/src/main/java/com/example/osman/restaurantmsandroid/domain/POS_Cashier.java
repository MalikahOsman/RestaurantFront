package com.example.osman.restaurantmsandroid.domain;

import android.content.Intent;
import android.os.IBinder;

import java.io.Serializable;

/**
 * Created by Osman on 2016-04-18.
 */
public abstract class POS_Cashier implements Serializable {
    private Long id;
    private String userName;
    private String password;
    private String empNum;
    private String empName;
    private String address;
    private String telephone;
    private Employee employee;

    public POS_Cashier() {
    }

    public POS_Cashier(Long id, String userName, String password, String empNum, String empName, String address, String telephone, Employee employee) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.empNum = empNum;
        this.empName = empName;
        this.address = address;
        this.telephone = telephone;
        this.employee = employee;

    }

    public Long getId() {
        return id;
    }
    public String getUserName() {
        return userName;
    }
    public String getPassword() {
        return password;
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
    public Employee getEmployee() {
        return employee;
    }

    public String getJobDescription() {
        return "Cashier is responsible for recording all transactions and ensuring accurate stock take";
    }

    public POS_Cashier(Builder builder)
    {
        this.id = builder.id;
        this.userName = builder.userName;
        this.password = builder.password;
        this.empNum = builder.empNum;
        this.empName = builder.empName;
        this.address = builder.address;
        this.telephone = builder.telephone;
        this.employee = builder.employee;
    }

    public abstract IBinder onBind(Intent intent);

    public abstract String activateChef(String userName, String password, String empName, String empNum, String address, String telephone, Employee employee);

    public static class Builder{
        private Long id;
        private String userName;
        private String password;
        private String empNum;
        private String empName;
        private String address;
        private String telephone;
        private Employee employee;


        public Builder id(Long value)
        {
            this.id = value;
            return this;
        }

        public Builder userName(String value)
        {
            this.userName = value;
            return this;
        }

        public Builder password(String value)
        {
            this.password = value;
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

        public Builder employee(Employee value)
        {
            this.employee = value;
            return this;
        }

        public Builder copy(POS_Cashier value)
        {
            this.id = value.id;
            this.userName = value.userName;
            this.password = value.password;
            this.empNum = value.empNum;
            this.empName = value.empName;
            this.address = value.address;
            this.telephone = value.telephone;
            this.employee = value.employee;
            return this;
        }

        public POS_Cashier build() {return new POS_Cashier(this) {
            @Override
            public IBinder onBind(Intent intent) {
                return null;
            }

            @Override
            public String activateChef(String userName, String password, String empName, String empNum, String address, String telephone, Employee employee) {
                return null;
            }
        };}


    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        POS_Cashier that = (POS_Cashier) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (userName != null ? !userName.equals(that.userName) : that.userName != null)
            return false;
        if (password != null ? !password.equals(that.password) : that.password != null)
            return false;
        if (empNum != null ? !empNum.equals(that.empNum) : that.empNum != null) return false;
        if (empName != null ? !empName.equals(that.empName) : that.empName != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (telephone != null ? !telephone.equals(that.telephone) : that.telephone != null)
            return false;
        return employee != null ? employee.equals(that.employee) : that.employee == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (empNum != null ? empNum.hashCode() : 0);
        result = 31 * result + (empName != null ? empName.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (telephone != null ? telephone.hashCode() : 0);
        result = 31 * result + (employee != null ? employee.hashCode() : 0);
        return result;
    }
}
