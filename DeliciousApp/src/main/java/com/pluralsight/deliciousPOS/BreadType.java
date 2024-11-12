package com.pluralsight.deliciousPOS;

public enum BreadType {
    WHITE (5.50,7.00,8.50),
    WHEAT(5.50,7.00,8.50),
    RYE(5.50,7.00,8.50),
    WRAP(5.50,7.00,8.50),
    ;



    private final double price4Inch;
    private final double price8Inch;
    private final double price12Inch;

    BreadType(double price4Inch, double price8Inch, double price12Inch) {
        this.price4Inch = price4Inch;
        this.price8Inch = price8Inch;
        this.price12Inch = price12Inch;
    }

    public double getPrice(SandwichSize size){
        return switch (size) {
            case FOUR_INCH -> price4Inch;
            case EIGHT_INCH -> price8Inch;
            case TWELVE_INCH -> price12Inch;
            default -> 0.0;
        };
    }
}

