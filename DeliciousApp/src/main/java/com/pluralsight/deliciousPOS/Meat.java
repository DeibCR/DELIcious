package com.pluralsight.deliciousPOS;

public enum Meat {
    STEAK (1.00,2.00,3.00, 0.50, 1.00, 1.50),
    HAM (1.00,2.00,3.00, 0.50, 1.00, 1.50),
    SALAMI (1.00,2.00,3.00, 0.50, 1.00, 1.50),
    ROAST_BEEF (1.00,2.00,3.00, 0.50, 1.00, 1.50),
    CHICKEN (1.00,2.00,3.00, 0.50, 1.00, 1.50),
    BACON (1.00,2.00,3.00, 0.50, 1.00, 1.50),
    ;

    private final double price4Inch;
    private final double price8Inch;
    private final double price12Inch;
    private final double extraPrice4Inch;
    private final double extraPrice8Inch;
    private final double extraPrice12Inch;

    Meat(double price4Inch, double price8Inch, double price12Inch, double extraPrice4Inch, double extraPrice8Inch, double extraPrice12Inch) {
        this.price4Inch = price4Inch;
        this.price8Inch = price8Inch;
        this.price12Inch = price12Inch;
        this.extraPrice4Inch = extraPrice4Inch;
        this.extraPrice8Inch = extraPrice8Inch;
        this.extraPrice12Inch = extraPrice12Inch;
    }

    public double getPrice(SandwichSize size, boolean isExtra){
        return switch (size) {
            case FOUR_INCH -> isExtra ? extraPrice4Inch : price4Inch;
            case EIGHT_INCH -> isExtra ? extraPrice8Inch : price8Inch;
            case TWELVE_INCH -> isExtra ? extraPrice12Inch : price12Inch;
            default -> 0.0;
        };
    }
}
