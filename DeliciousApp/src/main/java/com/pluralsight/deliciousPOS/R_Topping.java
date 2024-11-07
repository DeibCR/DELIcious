package com.pluralsight.deliciousPOS;

public enum R_Topping {
    LETTUCE,
    PEPPERS,
    ONIONS,
    TOMATOES,
    JALAPENOS,
    CUCUMBERS,
    PICKLES,
    GUACAMOLE,
    MUSHROOMS;

    public double getPrice() {
        return 0.0;  // Price will be 0 because all the regular topping are included in the base price
    }
}
