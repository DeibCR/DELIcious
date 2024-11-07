package com.pluralsight.deliciousPOS;

public enum Chips {
    CHIPS(1.50);

    private final double price;

    Chips(double price) {
        this.price = price;
    }

    public double getPrice(){
        return price;
    }
}
