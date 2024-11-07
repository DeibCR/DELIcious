package com.pluralsight.deliciousPOS;

public class Chip implements Priceable{
    private String type;
    private double basePrice;

    public Chip(String type, double basePrice) {
        this.type = type;
        this.basePrice = basePrice;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public double calculatePrice() {
        return 0;
    }



}
