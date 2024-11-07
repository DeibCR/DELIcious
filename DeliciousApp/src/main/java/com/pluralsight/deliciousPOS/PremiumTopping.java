package com.pluralsight.deliciousPOS;

public class PremiumTopping extends Topping{
    private boolean isExtra;

    public PremiumTopping(String name, double price, int quantity) {
        super(name, price, quantity);
        this.isExtra= isExtra;
    }

    public boolean isExtra() {
        return isExtra;
    }

    @Override
    public double calculatePrice() {

        return super.calculatePrice();
    }
}
