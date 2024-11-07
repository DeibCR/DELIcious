package com.pluralsight.deliciousPOS;

public enum Sauce {
    MAYO,
    MUSTARD,
    KETCHUP,
    RANCH,
    THOUSAND_ISLANDS,
    VINAIGRETTE;

    public double getPrice() {
        return 0.0;  // Price will be 0 because  sauces are included in the base price
    }
}
