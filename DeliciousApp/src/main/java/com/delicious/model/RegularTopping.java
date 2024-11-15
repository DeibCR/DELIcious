package com.delicious.model;

import com.delicious.enums.R_Topping;
import com.delicious.enums.SandwichSize;

public class RegularTopping implements Topping {
    private final R_Topping type;

    public RegularTopping(R_Topping type) {
        this.type = type;
    }

    @Override
    public String getName() {
        return type.name();
    }

    @Override
    public double calculatePrice(SandwichSize size, boolean isExtra) {
        return 0.0;
    }


}