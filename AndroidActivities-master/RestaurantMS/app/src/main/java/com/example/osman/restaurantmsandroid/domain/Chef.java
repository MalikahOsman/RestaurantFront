package com.example.osman.restaurantmsandroid.domain;


import android.content.Intent;
import android.os.IBinder;

import java.io.Serializable;

public abstract class Chef  implements Serializable {
    private Long id;
    private String userName;
    private String password;
    private String empNum;
    private String empName;
    private String address;
    private String telephone;
    private Employee employee;

    public Chef(Long id, String userName, String password, String empNum, String empName, String address, String telephone) {

        this.id = id;
        this.userName = userName;
        this.password = password;
        this.empNum = empNum;
        this.empName = empName;
        this.address = address;
        this.telephone = telephone;
    }

    public Chef(Builder builder) {
        this.id = builder.id;
        this.userName = builder.userName;
        this.password = builder.password;
        this.empNum =  builder.empNum;
        this.empName = builder.empName;
        this.address = builder.address;
        this.telephone = builder.telephone;
        this.employee = builder.employee;
    }

    public Chef() {
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

    public Employee getEmployee(){
        return employee;}

    public abstract IBinder onBind(Intent intent);

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

        public Builder copy(Chef value) {
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

        public Chef build() {return new Chef(this) {
            @Override
            public IBinder onBind(Intent intent) {
                return null;
            }
        };}

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Chef chef = (Chef) o;

        if (id != null ? !id.equals(chef.id) : chef.id != null) return false;
        if (userName != null ? !userName.equals(chef.userName) : chef.userName != null)
            return false;
        if (password != null ? !password.equals(chef.password) : chef.password != null)
            return false;
        if (empNum != null ? !empNum.equals(chef.empNum) : chef.empNum != null) return false;
        if (empName != null ? !empName.equals(chef.empName) : chef.empName != null) return false;
        if (address != null ? !address.equals(chef.address) : chef.address != null) return false;
        return telephone != null ? telephone.equals(chef.telephone) : chef.telephone == null;

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
        return result;
    }
}