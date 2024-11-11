package com.pluralsight.deliciousPOS;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Sandwich> sandwiches;
    private List<Drink> drinks;
    private List<Chip> chips;

    private DateTimeFormatter receiptDate;

    public Order() {
        sandwiches = new ArrayList<>();
        drinks = new ArrayList<>();
        chips = new ArrayList<>();
        this.receiptDate = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");

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

    public double calculateTotal(){
        double totalPrice=0.0;
        for (Sandwich sandwich: sandwiches){
            totalPrice += sandwich.calculatePrice();
        }
        for (Drink drink: drinks){
            totalPrice += drink.calculatePrice();
        }
        for (Chip chip: chips){
            totalPrice += chip.calculatePrice();
        }
        return totalPrice;

    }

    public String displayOrderDetails(){
        StringBuilder orderSummary= new StringBuilder("Order Summary:\n");


        //display every sandwich with details
        for (int i = 0; i < sandwiches.size(); i++) {
            orderSummary.append("\nSandwich ").append(i + 1).append(":\n")
                    .append(sandwiches.get(i).getSandwich())
                    .append("\n");
        }

        if (!drinks.isEmpty()) {
            orderSummary.append("\nDrinks:\n");
            for (int i = 0; i < drinks.size(); i++) {
                orderSummary.append("- Drinks: $").append(String.format("%.2f", drinks.get(i).calculatePrice()))
                        .append("\n");
            }
        }

        if (!chips.isEmpty()) {
            orderSummary.append("\nChips:\n");
            for (int i = 0; i < chips.size(); i++) {
                orderSummary.append("- Chips: $").append(String.format("%.2f", chips.get(i).calculatePrice()))
                        .append("\n");
            }
        }

        orderSummary.append("\nTotal Price: $").append(String.format("%.2f", calculateTotal()));

        return orderSummary.toString();


    }


}
