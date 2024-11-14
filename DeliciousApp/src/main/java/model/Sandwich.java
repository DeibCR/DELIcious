package model;

import enums.SandwichSize;

import java.util.ArrayList;
import java.util.List;

public class Sandwich implements Priceable {
    private SandwichSize size;
    private BreadType breadType;
    private boolean isToasted;
    private List<Topping> toppings;
    private int meatCount = 0;
    private int cheeseCount = 0;


    public Sandwich(SandwichSize size, BreadType breadType,List<Topping> toppings,  boolean isToasted) {
        this.size = size;
        this.breadType = breadType;
        this.isToasted = isToasted;
        this.toppings = toppings !=null ? toppings: new ArrayList<>();


    }

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

        // Count meats and cheeses in the toppings list
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

            // Apply the topping price (extra or regular)
            System.out.println("Total Price: $" + totalPrice);
            totalPrice += getToppingPrice(topping, isExtra);
        }

        return totalPrice;
    }



    private double getToppingPrice(Topping topping, boolean isExtra) {
        if (isExtra) {
            if (topping instanceof Meat) {
                return ((Meat) topping).calculatePrice(size, true); // Price for extra meat
            } else if (topping instanceof Cheese) {
                return ((Cheese) topping).calculatePrice(size, true); // Price for extra cheese
            }
        } else {
            if (topping instanceof Meat) {
                return ((Meat) topping).calculatePrice(size, false); // Price for regular meat
            } else if (topping instanceof Cheese) {
                return ((Cheese) topping).calculatePrice(size, false); // Price for regular cheese
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

                // price whether its extra or not
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

    public BreadType getBreadType() {
        return breadType;
    }

    public void setBreadType(BreadType breadType) {
        this.breadType = breadType;
    }

    public List<Topping> getToppings() {
        return toppings;
    }


    public boolean isToasted() {
        return isToasted;
    }

    public void setToasted(boolean toasted) {
        isToasted = toasted;
    }
}
