package model;

import enums.SandwichSize;

public interface Topping {
    String getName();

    double calculatePrice(SandwichSize size, boolean isExtra);
}
