package com.delicious.model;

import com.delicious.enums.SandwichSize;

public interface Topping {
    String getName();

    double calculatePrice(SandwichSize size, boolean isExtra);
}
