package model;

import enums.Chips;

public class Chip implements Priceable {
    private final Chips type= Chips.CHIPS;

    @Override
    public double calculatePrice() {
        return type.getPrice();
    }


}
