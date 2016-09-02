package com.example.osman.restaurantmsandroid.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Osman on 2016-04-19.
 */
public class EmployeeContact implements Serializable{
    private Long id;
    private String contactTypeId;
    private String contactValue;
    private String status;
    private String date;

    private EmployeeContact(){}

    public Long getId() {
        return id;
    }
    public String getContactTypeId() {
        return contactTypeId;
    }
    public String getContactValue() {
        return contactValue;
    }
    public String getStatus() {
        return status;
    }
    public String getDate() {
        return date;
    }

    public EmployeeContact(Builder builder)
    {
        this.id = builder.id;
        this.contactTypeId= builder.contactTypeId;
        this.contactValue = builder.contactValue;
        this.date = builder.date;

        this.status = builder.status;

    }

    public static class Builder{
        private Long id;
        private String contactTypeId;
        private String contactValue;
        private String status;
        private String date;


        public Builder id(Long value){
            this.id =value;
            return this;
        }

        public Builder date(String value){
            this.date =value;
            return this;
        }

        public Builder contactTypeId(String value){
            this.contactTypeId =value;
            return this;
        }

        public Builder contactValue(String value){
            this.contactValue =value;
            return this;
        }

        public Builder status(String value){
            this.status =value;
            return this;
        }


        public Builder copy(EmployeeContact value){
            this.id = value.id;
            this.contactTypeId= value.contactTypeId;
            this.contactValue=value.contactValue;
            this.date=value.date;
            this.status=value.status;
            return  this;
        }

        public EmployeeContact build(){
            return new EmployeeContact(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmployeeContact that = (EmployeeContact) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (contactTypeId != null ? !contactTypeId.equals(that.contactTypeId) : that.contactTypeId != null)
            return false;
        if (contactValue != null ? !contactValue.equals(that.contactValue) : that.contactValue != null)
            return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        return date != null ? date.equals(that.date) : that.date == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (contactTypeId != null ? contactTypeId.hashCode() : 0);
        result = 31 * result + (contactValue != null ? contactValue.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }
}
