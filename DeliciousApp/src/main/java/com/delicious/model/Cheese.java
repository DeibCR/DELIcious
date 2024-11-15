package com.delicious.model;

import com.delicious.enums.SandwichSize;

public class Cheese implements Topping {
    private final String name;
    private final double price4Inch;
    private final double price8Inch;
    private final double price12Inch;
    private final double extraPrice4Inch;
    private final double extraPrice8Inch;
    private final double extraPrice12Inch;

    public Cheese(String name,double price4Inch, double price8Inch, double price12Inch, double extraPrice4Inch, double extraPrice8Inch, double extraPrice12Inch) {
        this.name=name;
        this.price4Inch = price4Inch;
        this.price8Inch = price8Inch;
        this.price12Inch = price12Inch;
        this.extraPrice4Inch = extraPrice4Inch;
        this.extraPrice8Inch = extraPrice8Inch;
        this.extraPrice12Inch = extraPrice12Inch;
    }



    @Override
    public String getName() {
        return name;
    }


    public double calculatePrice(SandwichSize size, boolean isExtra) {
        return switch (size) {
            case FOUR_INCH -> isExtra ? extraPrice4Inch:price4Inch;
            case EIGHT_INCH -> isExtra ? extraPrice8Inch:price8Inch;
            case TWELVE_INCH -> isExtra ? extraPrice12Inch:price12Inch;
        };
    }
    @Override
    public String toString() {
        return this.getName();
    }
}
