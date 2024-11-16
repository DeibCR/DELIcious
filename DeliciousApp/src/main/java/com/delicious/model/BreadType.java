package com.delicious.model;

import com.delicious.enums.SandwichSize;

public class BreadType implements Topping {
    private final String name;
    private final double price4Inch;
    private final double price8Inch;
    private final double price12Inch;

    public BreadType(String name,double price4Inch, double price8Inch, double price12Inch) {
        this.name=name;
        this.price4Inch = price4Inch;
        this.price8Inch = price8Inch;
        this.price12Inch = price12Inch;

    }




    @Override
    public String getName() {
        return name;
    }

    /**
     * Calculates the price of the bread based on the sandwich size and whether it's considered "extra".
     * @param size The size of the sandwich (4-inch, 8-inch, or 12-inch)
     * @param isExtra Whether the bread is considered an extra topping (affects price if applicable)
     * @return the calculated price
     */
    @Override
    public double calculatePrice(SandwichSize size, boolean isExtra) {
        return switch (size) {
            case FOUR_INCH -> price4Inch;
            case EIGHT_INCH -> price8Inch;
            case TWELVE_INCH -> price12Inch;
        };


    }
    @Override
    public String toString() {
        return this.getName();
    }

}

