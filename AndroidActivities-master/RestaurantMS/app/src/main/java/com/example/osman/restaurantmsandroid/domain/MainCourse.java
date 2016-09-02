package com.example.osman.restaurantmsandroid.domain;

import java.io.Serializable;

/**
 * Created by Osman on 2016-04-24.
 */
public class MainCourse implements Serializable {
    private Long id;
    private String mainID;
    private String foodItem;
    private Menu menu;

    public MainCourse() {
    }

    public MainCourse(String mainID, String foodItem) {
        this.mainID = mainID;
        this.foodItem = foodItem;
        this.menu = menu;
    }

    public Long getId() {
        return id;
    }
    public String getMainID() {
        return mainID;
    }
    public String getFoodItem() {
        return foodItem;
    }
    public MainCourse(Builder builder) {
        this.id = builder.id;
        this.mainID = builder.mainID;
        this.foodItem = builder.foodItem;
        this.menu = builder.menu;
    }

    public static class Builder {
        private Long id;
        private String mainID;
        private String foodItem;
        private Menu menu;
        public Builder id(Long value) {
            this.id = value;
            return this;
        }

        public Builder mainID(String value) {
            this.mainID = value;
            return this;
        }

        public Builder foodItem(String value) {
            this.foodItem = value;
            return this;
        }

        public Builder menu(Menu value)
        {
            this.menu = value;
            return this;
        }


        public Builder copy(MainCourse value) {
            this.id = value.id;
            this.mainID = value.mainID;
            this.foodItem = value.foodItem;
            this.menu = value.menu;
            return this;
        }

        public MainCourse build() {
            return new MainCourse(this);

        }


    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MainCourse that = (MainCourse) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (mainID != null ? !mainID.equals(that.mainID) : that.mainID != null) return false;
        if (foodItem != null ? !foodItem.equals(that.foodItem) : that.foodItem != null)
            return false;
        return menu != null ? menu.equals(that.menu) : that.menu == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (mainID != null ? mainID.hashCode() : 0);
        result = 31 * result + (foodItem != null ? foodItem.hashCode() : 0);
        result = 31 * result + (menu != null ? menu.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "MainCourse{" +
                "foodItem='" + foodItem + '\'' +
                ", mainID='" + mainID + '\'' +
                '}';
    }
}

