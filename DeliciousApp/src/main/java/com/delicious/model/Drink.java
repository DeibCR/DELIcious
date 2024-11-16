package com.delicious.model;

import com.delicious.enums.DrinkSize;

public  class Drink {


    private String name;
    private DrinkSize size;
    private final double small;
    private final double medium;
    private final double large;

    public Drink(String name, DrinkSize size, double small, double medium, double large) {
        this.name = name;
        this.size = size;
        this.small = small;
        this.medium = medium;
        this.large = large;
    }



    public String getName() {
        return name;
    }

    public double calculatePrice() {
        return switch (size) {
            case SMALL -> small;
            case MEDIUM -> medium;
            case LARGE -> large;

        };
    }

    public String getDrink() {

        String description = "Drink Name: " + name +
                "\nSize: " + size +
                "\nTotal Price: $" + String.format("%.2f", calculatePrice());


        return description.toString();
    }



    public void setName(String name) {
        this.name = name;
    }

    public void setSize(DrinkSize size) {
        this.size = size;
    }


    public double getSmall() {
        return small;
    }

    public double getMedium() {
        return medium;
    }

    public double getLarge() {
        return large;
    }

    public String toString() {
        return this.getName();
    }
}
