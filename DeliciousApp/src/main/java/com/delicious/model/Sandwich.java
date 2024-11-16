package com.delicious.model;

import com.delicious.enums.SandwichSize;

import java.util.ArrayList;
import java.util.List;

public class Sandwich implements Priceable {
    private SandwichSize size;
    private final BreadType breadType;
    private final boolean isToasted;
    private final List<Topping> toppings;



    public Sandwich(SandwichSize size, BreadType breadType,List<Topping> toppings,  boolean isToasted) {
        this.size = size;
        this.breadType = breadType;
        this.isToasted = isToasted;
        this.toppings = toppings !=null ? toppings: new ArrayList<>();


    }

    /*
    *
    * Methods for future implementation od modify the sandwich, add or remove a topping from
    * a sandwich already created
    *
     */
    public void addTopping(Topping topping) {
        toppings.add(topping);
    }

    public void removeTopping(Topping topping) {
        toppings.remove(topping);
    }


    private double getBasePrice(){
        return breadType.calculatePrice(size,isToasted);
    }


    @Override
    public double calculatePrice() {
        double totalPrice = getBasePrice();

        int meatCount = 0;
        int cheeseCount = 0;


        for (Topping topping : toppings) {
            if (topping instanceof Meat) {
                meatCount++;
            } else if (topping instanceof Cheese) {
                cheeseCount++;
            }

            boolean isExtra = false;
            if (topping instanceof Meat) {
                isExtra = meatCount > 1; // count meat as an extra if 1 meat is already selected

            } else if (topping instanceof Cheese) {
                isExtra = cheeseCount > 1;// count cheese as an extra if 1 meat is already selected
            }

            totalPrice += getToppingPrice(topping, isExtra);
        }

        return totalPrice;
    }

    /**
    *
    *Calculates the price of a topping based on its type and whether it is extra.(helper method)
     *
    * @param topping the topping for the price that is being calculated, must be a meat or cheese
    * @param isExtra a boolean that indicates if the topping is extra
     * @return the price of topping (extra or not, or 0.0 if the topping it is not cheese/meat
     **/

    private double getToppingPrice(Topping topping, boolean isExtra) {
        if (isExtra) {
            if (topping instanceof Meat) {
                return topping.calculatePrice(size, true);
            } else if (topping instanceof Cheese) {
                return topping.calculatePrice(size, true);
            }
        } else {
            if (topping instanceof Meat) {
                return topping.calculatePrice(size, false);
            } else if (topping instanceof Cheese) {
                return topping.calculatePrice(size, false);
            }
        }
        return 0.0;
    }



    public String getSandwich() {
        StringBuilder description = new StringBuilder();

        description.append("Size: ").append(size)
                .append(", Bread Type: ").append(breadType)
                .append(", Toasted: ").append(isToasted ? "Yes" : "No")
                .append("\nToppings:");

        if (toppings.isEmpty()) {
            description.append(" None");
        } else {
            //reset the counts for new sandwiches added
            int meatCount = 0;
            int cheeseCount = 0;


            for (Topping topping : toppings) {
                boolean isExtra = false;

                // to determine if the topping is extra
                if (topping instanceof Meat) {
                    meatCount++;
                    isExtra = meatCount > 1;
                } else if (topping instanceof Cheese) {
                    cheeseCount++;
                    isExtra = cheeseCount > 1;
                }

                // price whether it is extra or not
                double toppingPrice = getToppingPrice(topping, isExtra);
                description.append("\n - ")
                        .append(topping.getName())
                        .append(": $")
                        .append(String.format("%.2f", toppingPrice));
            }
        }

        description.append("\nTotal Price: $").append(String.format("%.2f", calculatePrice()));
        return description.toString();
    }

    public SandwichSize getSize() {
        return size;
    }

    public void setSize(SandwichSize size) {
        this.size = size;
    }


}
