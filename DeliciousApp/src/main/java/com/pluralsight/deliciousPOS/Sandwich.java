package com.pluralsight.deliciousPOS;

import java.util.ArrayList;
import java.util.List;

public class Sandwich implements Priceable {
    private SandwichSize size;
    private BreadType breadType;
    private boolean isToasted;
    private List<Topping> toppings;

    public Sandwich(SandwichSize size, BreadType breadType,  boolean isToasted) {
        this.size = size;
        this.breadType = breadType;
        this.isToasted = isToasted;
        this.toppings = new ArrayList<>();
    }

    public void addTopping(Topping topping) {
        toppings.add(topping);
    }


    public void removeTopping(Topping topping) {
        toppings.remove(topping);
    }

    private double getBasePrice(){
        return breadType.getPrice(size);
    }


    @Override
    public double calculatePrice() {
        double totalPrice= getBasePrice();
        for (Topping topping: toppings){
            totalPrice +=topping.calculatePrice(size);
        }
        return totalPrice;
    }

    public SandwichSize getSize() {
        return size;
    }

    public void setSize(SandwichSize size) {
        this.size = size;
    }

    public BreadType getBreadType() {
        return breadType;
    }

    public void setBreadType(BreadType breadType) {
        this.breadType = breadType;
    }

    public List<Topping> getToppings() {
        return toppings;
    }


    public boolean isToasted() {
        return isToasted;
    }

    public void setToasted(boolean toasted) {
        isToasted = toasted;
    }
}
