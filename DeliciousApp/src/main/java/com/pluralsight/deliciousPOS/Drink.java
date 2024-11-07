package com.pluralsight.deliciousPOS;

public class Drink implements Priceable {

    private DrinkSize size;

    public Drink(DrinkSize size){
        this.size=size;
    }

    @Override
    public double calculatePrice() {
        return size.getPrice();
    }
}
