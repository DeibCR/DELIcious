package enums;

import model.Topping;

public enum R_Topping implements Topping {
    LETTUCE,
    PEPPERS,
    ONIONS,
    TOMATOES,
    JALAPENOS,
    CUCUMBERS,
    PICKLES,
    GUACAMOLE,
    MUSHROOMS;



    @Override
    public String getName() {
        return name().charAt(0) + name().substring(1).toLowerCase().replace("_", " ");
    }

    @Override
    public double calculatePrice(SandwichSize size, boolean isExtra) {
        return 0.0;
    }
}
