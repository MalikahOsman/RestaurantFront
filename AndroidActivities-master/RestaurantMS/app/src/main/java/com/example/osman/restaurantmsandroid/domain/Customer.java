package com.example.osman.restaurantmsandroid.domain;

import java.io.Serializable;

/**
 * Created by Osman on 2016-04-18.
 */

public class Customer implements Serializable {
    private Long id;
    private String custName;
    private String custNum;

    public Customer() {
    }

    public Customer(Long id, String custName, String custNum) {
        this.id = id;
        this.custName = custName;
        this.custNum = custNum;
    }


    public Long getId() {
        return id;
    }

    public String getCustName() {
        return custName;
    }

    public String getCustNum() {
        return custNum;
    }

    public Customer(Builder builder) {
        this.id = builder.id;
        this.custName = builder.custName;
        this.custNum = builder.custNum;

    }

    public static class Builder {
        private Long id;
        private String custName;
        private String custNum;

        public Builder id(Long value) {
            this.id = value;
            return this;
        }

        public Builder custName(String value) {
            this.custName = value;
            return this;
        }

        public Builder custNum(String value) {
            this.custNum = value;
            return this;
        }



        public Builder copy(Customer value) {
            this.id = value.id;
            this.custName = value.custName;
            this.custNum = value.custNum;
            return this;
        }

        public Customer build() {
            return new Customer(this);

        }


    }



    @Override
    public String toString() {
        return String.format("Id : %d\nCustomer Name :%s\nCustomer Number :%s\nIdNum :%s",id,custName,custNum);
                /*"Customer{" +
                "custName='" + custName + '\'' +
                ", custNum='" + custNum + '\'' +
                '}';*/
    }


    //public String toString()
    //{
      //  return String.format("Id : %d\nName :%s\nSurname :%s\nIdNum :%s",id,name,surName,idNo);
    //}



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        if (id != null ? !id.equals(customer.id) : customer.id != null) return false;
        if (custName != null ? !custName.equals(customer.custName) : customer.custName != null)
            return false;
        return custNum != null ? custNum.equals(customer.custNum) : customer.custNum == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (custName != null ? custName.hashCode() : 0);
        result = 31 * result + (custNum != null ? custNum.hashCode() : 0);
        return result;
    }
}
