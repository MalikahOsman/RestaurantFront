package com.example.osman.restaurantmsandroid.domain;

import java.io.Serializable;

/**
 * Created by Osman on 2016-04-18.
 */
public class Starter implements Serializable {
    private Long id;
    private String starterID;
    private String foodItem;
    private Menu menu;

    public Starter() {
    }

    public Starter(String starterID, String foodItem) {
        this.starterID = starterID;
        this.foodItem = foodItem;
        this.menu = menu;
    }

    public Long getId() {
        return id;
    }
    public String getStarterID() {
        return starterID;
    }
    public String getFoodItem() {
        return foodItem;
    }
    public Starter(Builder builder) {
        this.id = builder.id;
        this.starterID = builder.starterID;
        this.foodItem = builder.foodItem;
        this.menu = builder.menu;
    }

    public static class Builder {
        private Long id;
        private String starterID;
        private String foodItem;
        private Menu menu;

        public Builder id(Long value) {
            this.id = value;
            return this;
        }

        public Builder starterID(String value) {
            this.starterID = value;
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



        public Builder copy(Starter value) {
            this.id = value.id;
            this.starterID = value.starterID;
            this.foodItem = value.foodItem;

            return this;
        }

        public Starter build() {
            return new Starter(this);

        }


    }

    @Override
    public String toString() {
        return "Starter{" +
                "starterID='" + starterID + '\'' +
                ", foodItem='" + foodItem + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Starter starter = (Starter) o;

        if (id != null ? !id.equals(starter.id) : starter.id != null) return false;
        if (starterID != null ? !starterID.equals(starter.starterID) : starter.starterID != null)
            return false;
        if (foodItem != null ? !foodItem.equals(starter.foodItem) : starter.foodItem != null)
            return false;
        return menu != null ? menu.equals(starter.menu) : starter.menu == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (starterID != null ? starterID.hashCode() : 0);
        result = 31 * result + (foodItem != null ? foodItem.hashCode() : 0);
        result = 31 * result + (menu != null ? menu.hashCode() : 0);
        return result;
    }
}
