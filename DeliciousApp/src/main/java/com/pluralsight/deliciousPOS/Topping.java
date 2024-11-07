package com.pluralsight.deliciousPOS;

public interface Topping {
    String getName();

    double calculatePrice(SandwichSize size);
}
