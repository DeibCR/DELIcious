package com.pluralsight.deliciousPOS;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Sandwich> sandwiches;
    private List<Drink> drinks;
    private List<Chip> chips;
    private double totalPrice;
    private DateTimeFormatter receiptDate;

    public Order() {
        sandwiches = new ArrayList<>();
        drinks = new ArrayList<>();
        chips = new ArrayList<>();

    }

    public void addSandwich(Sandwich sandwich) {
        sandwiches.add(sandwich);
    }


    public void addDrink(Drink drink) {
        drinks.add(drink);
    }


    public void addChip(Chip chip) {
        chips.add(chip);
    }


}
