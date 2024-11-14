package model;

import enums.DrinkSize;

public  class Drink  {


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
        switch (size) {
            case SMALL:
                return small;
            case MEDIUM:
                return medium;
            case LARGE:
                return large;
            default:
                return 0.0;
        }
    }

    public String getDrink() {
        StringBuilder description = new StringBuilder();

        description.append("Drink Name: ").append(name)
                .append("\nSize: ").append(size)
                .append("\nTotal Price: $").append(String.format("%.2f", calculatePrice()));


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
