package com.example.osman.restaurantmsandroid.domain;

import java.io.Serializable;

/**
 * Created by Osman on 2016-04-19.
 */
public class AddressType implements Serializable {
    private Long id;
    private String name;
    private String state;

    public AddressType() {
    }

    public AddressType(Long id, String name, String state) {
        this.id = id;
        this.name = name;
        this.state = state;
    }

    public AddressType(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.state = builder.state;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public static class Builder {
        private Long id;
        private String name;
        private String state;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder state(String state) {
            this.state = state;
            return this;
        }

        public Builder copy(AddressType addressType) {
            this.id = addressType.id;
            this.name = addressType.name;
            this.state = addressType.state;

            return this;
        }

        public AddressType build() {
            return new AddressType(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AddressType that = (AddressType) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        return state != null ? state.equals(that.state) : that.state == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        return result;
    }
}
