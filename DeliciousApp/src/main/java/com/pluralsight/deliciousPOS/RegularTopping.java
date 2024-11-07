package com.pluralsight.deliciousPOS;

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
    public double calculatePrice(SandwichSize size) {
        return 0.0;
    }
}
