package com.delicious.model;

import com.delicious.enums.Chips;

public class Chip  {
    private String name;
    private Chips size;

    private final double small;

    public Chip(String name, Chips size, double small) {
        this.name = name;
        this.size = size;
        this.small = small;
    }

    public String getName() {
        return name;
    }

    public double calculatePrice() {
        return switch(size){
        case SMALL -> small;

    };

    }

    public String getChip() {

        String description = "Chip Name: " + name +
                "\nSize: " + size +
                "\nTotal Price: $" + String.format("%.2f", calculatePrice());


        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSize(Chips size) {
        this.size = size;
    }


    public String toString() {
        return this.getName();
    }

    public double getSmall() {
        return small;
    }




}
