package model;

import enums.SandwichSize;

public class PremiumTopping implements Topping {
    private final Meat meatType;
    private final Cheese cheeseType;
    private final boolean isExtra;


    //Constructor made to create topping objects that are meat
    public PremiumTopping(Meat meatType,  boolean isExtra) {
        this.meatType = meatType;
        this.cheeseType = null;
        this.isExtra = isExtra;
    }


    //Constructor made to create topping objects that are cheese
    public PremiumTopping(Cheese cheeseType, boolean isExtra) {
        this.meatType = null;
        this.cheeseType = cheeseType;
        this.isExtra = isExtra;
    }

    @Override
    public String getName() {
        return (meatType != null) ? meatType.getName() : (cheeseType != null) ? cheeseType.getName() : "";
    }

    @Override
    public double calculatePrice(SandwichSize size, boolean isExtra) {
        if (meatType!=null){
            return meatType.calculatePrice(size,isExtra);
        } else if (cheeseType!=null) {
            return cheeseType.calculatePrice(size,isExtra);
        }
        return 0.0;
    }
}
