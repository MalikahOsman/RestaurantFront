package com.example.osman.restaurantmsandroid.domain;

import java.io.Serializable;
import java.util.Date;
/**
 * Created by Osman on 2016-04-18.
 */
public class EmployeeAddress implements Serializable{
    private Long id;
    private String description;
    private String postalCode;
    private String addressTypeId;
    private String date;

    public EmployeeAddress() {
    }

    public Long getId() {
        return id;
    }
    public String getDescription() {
        return description;
    }
    public String getPostalCode() {
        return postalCode;
    }
    public String getAddressTypeId() {
        return addressTypeId;
    }
    public String getDate() {
        return date;
    }

    public EmployeeAddress(Builder builder)
    {
         this.id = builder.id;
        this.description = builder.description;
        this.postalCode = builder.postalCode;
        this.addressTypeId = builder.addressTypeId;
        this.date = builder.date;
    }

    public static class Builder
    {
        private Long id;
        private String description;
        private String postalCode;
        private String addressTypeId;
        private String date;

        public Builder id(Long value){
            this.id =value;
            return this;
        }

        public Builder date(String value){
            this.date =value;
            return this;
        }

        public Builder description(String value){
            this.description =value;
            return this;
        }

        public Builder postalCode(String value){
            this.postalCode =value;
            return this;
        }

        public Builder addressTypeId(String value){
            this.addressTypeId =value;
            return this;
        }

        public Builder copy(EmployeeAddress value){
            this.id = value.id;
            this.description = value.description;
            this.addressTypeId = value.addressTypeId;
            //this.state = value.state;
            this.date = value.date;
            this.postalCode = value.postalCode;
            return  this;
        }

        public EmployeeAddress build(){
            return new EmployeeAddress(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmployeeAddress that = (EmployeeAddress) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null)
            return false;
        if (postalCode != null ? !postalCode.equals(that.postalCode) : that.postalCode != null)
            return false;
        if (addressTypeId != null ? !addressTypeId.equals(that.addressTypeId) : that.addressTypeId != null)
            return false;
        return date != null ? date.equals(that.date) : that.date == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (postalCode != null ? postalCode.hashCode() : 0);
        result = 31 * result + (addressTypeId != null ? addressTypeId.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }
}
