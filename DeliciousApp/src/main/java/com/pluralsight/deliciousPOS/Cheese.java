package com.pluralsight.deliciousPOS;

public enum Cheese {
    AMERICAN(0.75, 1.50, 2.25, 0.30, 0.60, 0.90),
    PROVOLONE(0.75, 1.50, 2.25, 0.30, 0.60, 0.90),
    CHEDDAR(0.75, 1.50, 2.25, 0.30, 0.60, 0.90),
    SWISS(0.75, 1.50, 2.25, 0.30, 0.60, 0.90);

    private final double price4Inch;
    private final double price8Inch;
    private final double price12Inch;
    private final double extraPrice4Inch;
    private final double extraPrice8Inch;
    private final double extraPrice12Inch;

    Cheese(double price4Inch, double price8Inch, double price12Inch, double extraPrice4Inch, double extraPrice8Inch, double extraPrice12Inch) {
        this.price4Inch = price4Inch;
        this.price8Inch = price8Inch;
        this.price12Inch = price12Inch;
        this.extraPrice4Inch = extraPrice4Inch;
        this.extraPrice8Inch = extraPrice8Inch;
        this.extraPrice12Inch = extraPrice12Inch;
    }

    public double getPrice(SandwichSize size, boolean isExtra) {
        return switch (size) {
            case FOUR_INCH -> isExtra ? extraPrice4Inch:price4Inch;
            case EIGHT_INCH -> isExtra ? extraPrice8Inch:price8Inch;
            case TWELVE_INCH -> isExtra ? extraPrice12Inch:price12Inch;
            default -> 0.0;
        };
    }


}
