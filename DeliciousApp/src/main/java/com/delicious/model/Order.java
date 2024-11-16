package com.delicious.model;

import com.delicious.enums.Chips;
import com.delicious.enums.DrinkSize;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;



public class Order {
    private final List<Sandwich> sandwiches;
    private final List<Drink> drinks;
    private final List<Chip> chips;
    private final LocalDateTime receiptDate;

    public Order() {
        sandwiches = new ArrayList<>();
        drinks = new ArrayList<>();
        chips = new ArrayList<>();
        this.receiptDate = LocalDateTime.now();

    }


    public void addSandwich(Sandwich sandwich) {
        if (sandwich != null) {
            sandwiches.add(sandwich);
        }
    }

    public void addDrink(Drink selectedDrink, DrinkSize size) {
        if (selectedDrink != null && size != null) {
                selectedDrink.setSize(size);
                drinks.add(selectedDrink);
        }
    }

    public void addChip(Chip chip, Chips selectedSize) {
        if (chip != null && selectedSize != null) {
             chip.setSize(selectedSize);
             chips.add(chip);
        }
    }

    /**
     * Calculate the total price for objects in list : sandwich,drinks,chips.
     *
     * @return  the total of price of each object
     *
     */
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

    /**
     * Generates a  summary of the order, with sandwiches, drinks, and chips.
     *
     * @return a formatted string with the order details, including all items
     *         in the sandwiches, drinks, and chips respective lists
     */
    public String displayOrderDetails(){
        StringBuilder orderSummary= new StringBuilder("Order Summary:\n");



        for (int i = 0; i < sandwiches.size(); i++) {
            orderSummary.append("\nSandwich ").append(i + 1).append(":\n")
                    .append(sandwiches.get(i).getSandwich())
                    .append("\n");
        }

        if (!drinks.isEmpty()) {
            orderSummary.append("\nDrinks:\n");
            for (Drink drink : drinks) {
                orderSummary.append("- ").append(drink.getDrink())
                        .append("\n");
            }
        }

        if (!chips.isEmpty()) {
            orderSummary.append("\nSide:\n");
            for (Chip chip : chips) {
                orderSummary.append("- ").append(chip.getChip())
                        .append("\n");
            }
        }

        return orderSummary.toString();


    }

    public String getFormattedReceiptDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return receiptDate.format(formatter);
    }

}
