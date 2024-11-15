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
        sandwiches.add(sandwich);
    }


    public void addDrink(Drink selectedDrink, DrinkSize size) {

        if (selectedDrink != null && size != null) {

            Drink newDrink = new Drink(selectedDrink.getName(), size, selectedDrink.getSmall(), selectedDrink.getMedium(), selectedDrink.getLarge());
            drinks.add(newDrink);
        }
    }


    public void addChip(Chip chip, Chips selectedSize) {
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
            for (Drink drink : drinks) {
                orderSummary.append("- ").append(drink.getDrink())
                        .append("\n");
            }
        }

        if (!chips.isEmpty()) {
            orderSummary.append("\nChips:\n");
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
