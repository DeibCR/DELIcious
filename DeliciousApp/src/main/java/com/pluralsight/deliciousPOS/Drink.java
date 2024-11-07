package com.pluralsight.deliciousPOS;

public class Drink implements Priceable {

    private DrinkSize size;
    private String flavor;
    private double basePrice;

    public Drink(DrinkSize size, String flavor, double basePrice) {
        this.size = size;
        this.flavor = flavor;
        this.basePrice = basePrice;
    }

    public DrinkSize getSize() {
        return size;
    }

    public void setSize(DrinkSize size) {
        this.size = size;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    @Override
    public double calculatePrice() {
        return 0;
    }
}
