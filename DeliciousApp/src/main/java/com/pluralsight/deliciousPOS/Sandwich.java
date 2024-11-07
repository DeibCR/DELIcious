package com.pluralsight.deliciousPOS;

import java.util.ArrayList;

public class Sandwich implements Priceable {
    private String size;
    private BreadType breadType;
    private ArrayList<Topping> toppings;
    private boolean isToasted;
    private double basePrice;

    public Sandwich(String size, BreadType breadType, ArrayList<Topping> toppings, boolean isToasted, double basePrice) {
        this.size = size;
        this.breadType = breadType;
        this.toppings = toppings;
        this.isToasted = isToasted;
        this.basePrice = basePrice;
        this.toppings=new ArrayList<>();
    }

    public void addTopping(Topping topping) {
        toppings.add(topping);
    }


    public void removeTopping(Topping topping) {
        toppings.remove(topping);
    }


    @Override
    public double calculatePrice() {
        double totalPrice= basePrice;
        for (Topping topping: toppings){
            totalPrice +=topping.calculatePrice();
        }
        return totalPrice;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public BreadType getBreadType() {
        return breadType;
    }

    public void setBreadType(BreadType breadType) {
        this.breadType = breadType;
    }

    public boolean isToasted() {
        return isToasted;
    }

    public void setToasted(boolean toasted) {
        isToasted = toasted;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }
}
