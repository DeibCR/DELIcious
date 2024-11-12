package com.pluralsight.deliciousPOS;

public enum Sauce implements Topping {
    MAYO,
    MUSTARD,
    KETCHUP,
    RANCH,
    THOUSAND_ISLANDS,
    VINAIGRETTE;



    @Override
    public String getName() {
        return name().charAt(0) + name().substring(1).toLowerCase().replace("_", " ");
    }

    @Override
    public double calculatePrice(SandwichSize size, boolean isExtra) {
        return 0.0;
    }
}
