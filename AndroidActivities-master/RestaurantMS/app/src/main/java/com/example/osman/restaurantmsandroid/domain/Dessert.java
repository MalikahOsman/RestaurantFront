package com.example.osman.restaurantmsandroid.domain;

import java.io.Serializable;

/**
 * Created by Osman on 2016-04-18.
 */
public class Dessert implements Serializable {
    private Long id;
    private String dessertID;
    private String foodItem;
    private Menu menu;

    public Dessert() {
    }

    public Dessert(String dessertID, String foodItem) {
        this.dessertID = dessertID;
        this.foodItem = foodItem;
        this.menu = menu;
    }

    public Long getId() {
        return id;
    }
    public String getDessertID() {
        return dessertID;
    }
    public String getFoodItem() {
        return foodItem;
    }

    public Dessert(Builder builder) {
        this.id = builder.id;
        this.dessertID = builder.dessertID;
        this.foodItem = builder.foodItem;
        this.menu = builder.menu;

    }

    public static class Builder {
        private Long id;
        private String dessertID;
        private String foodItem;
        private Menu menu;

        public Builder id(Long value) {
            this.id = value;
            return this;
        }

        public Builder dessertID(String value) {
            this.dessertID = value;
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


        public Builder copy(Dessert value) {
            this.id = value.id;
            this.dessertID = value.dessertID;
            this.foodItem = value.foodItem;
            this.menu = value.menu;
            return this;
        }

        public Dessert build() {
            return new Dessert(this);

        }


    }


    @Override
    public String toString() {
        return "Dessert{" +
                "dessertID='" + dessertID + '\'' +
                ", foodItem='" + foodItem + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dessert dessert = (Dessert) o;

        if (id != null ? !id.equals(dessert.id) : dessert.id != null) return false;
        if (dessertID != null ? !dessertID.equals(dessert.dessertID) : dessert.dessertID != null)
            return false;
        if (foodItem != null ? !foodItem.equals(dessert.foodItem) : dessert.foodItem != null)
            return false;
        return menu != null ? menu.equals(dessert.menu) : dessert.menu == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (dessertID != null ? dessertID.hashCode() : 0);
        result = 31 * result + (foodItem != null ? foodItem.hashCode() : 0);
        result = 31 * result + (menu != null ? menu.hashCode() : 0);
        return result;
    }
}
