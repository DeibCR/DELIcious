package model;

import enums.DrinkSize;
import model.BreadType;
import model.Cheese;
import model.Drink;
import model.Meat;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class DataLoader {
    public static List<Meat> loadMeatData(String filePath) {
        List<Meat> meats = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;


            while ((line = br.readLine()) != null) {

                if (line.startsWith("name")) continue;

                String[] parts = line.split(",");


                if (parts.length < 7) {
                    System.err.println("Skipping malformed line: " + line);
                    continue;
                }

                try {

                    String name = parts[0].trim();
                    double price4Inch = Double.parseDouble(parts[1].trim());
                    double price8Inch = Double.parseDouble(parts[2].trim());
                    double price12Inch = Double.parseDouble(parts[3].trim());
                    double extraPrice4Inch = Double.parseDouble(parts[4].trim());
                    double extraPrice8Inch = Double.parseDouble(parts[5].trim());
                    double extraPrice12Inch = Double.parseDouble(parts[6].trim());


                    meats.add(new Meat(name, price4Inch, price8Inch, price12Inch, extraPrice4Inch, extraPrice8Inch, extraPrice12Inch));
                } catch (NumberFormatException e) {
                    System.err.println("Skipping line due to number format error: " + line);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading meat data from file: " + filePath);
            e.printStackTrace();
        }

        return meats;
    }

    public static List<Cheese> loadCheeseData(String filePath) {
        List<Cheese> cheeses = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;


            while ((line = br.readLine()) != null) {

                if (line.startsWith("name")) continue;

                String[] parts = line.split(",");


                if (parts.length < 7) {
                    System.err.println("Skipping malformed line: " + line);
                    continue;
                }

                try {

                    String name = parts[0].trim();
                    double price4Inch = Double.parseDouble(parts[1].trim());
                    double price8Inch = Double.parseDouble(parts[2].trim());
                    double price12Inch = Double.parseDouble(parts[3].trim());
                    double extraPrice4Inch = Double.parseDouble(parts[4].trim());
                    double extraPrice8Inch = Double.parseDouble(parts[5].trim());
                    double extraPrice12Inch = Double.parseDouble(parts[6].trim());


                    cheeses.add(new Cheese(name, price4Inch, price8Inch, price12Inch, extraPrice4Inch, extraPrice8Inch, extraPrice12Inch));
                } catch (NumberFormatException e) {
                    System.err.println("Skipping line due to number format error: " + line);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading meat data from file: " + filePath);
            e.printStackTrace();
        }

        return cheeses;
    }

    public static List<BreadType> loadBreadData(String filePath) {
        List<BreadType> breadTypes = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = br.readLine()) != null) {

                if (line.startsWith("name")) continue;

                String[] parts = line.split(",");

                if (parts.length < 4) {
                    System.err.println("Skipping malformed line: " + line);
                    continue;
                }

                try {
                    String name = parts[0].trim();
                    double price4Inch = Double.parseDouble(parts[1].trim());
                    double price8Inch = Double.parseDouble(parts[2].trim());
                    double price12Inch = Double.parseDouble(parts[3].trim());


                    breadTypes.add(new BreadType(name, price4Inch, price8Inch, price12Inch));

                } catch (NumberFormatException e) {
                    System.err.println("Skipping line due to number format error: " + line);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading bread data from file: " + filePath);
            e.printStackTrace();
        }

        return breadTypes;
    }



    public static List<Drink> loadDrinksData(String filePath) {
        List<Drink> drinks = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");


                String name = values[0];
                double small = Double.parseDouble(values[1]);
                double medium = Double.parseDouble(values[2]);
                double large = Double.parseDouble(values[3]);


                Drink drink = new Drink(name, DrinkSize.SMALL, small, medium, large);
                drinks.add(drink);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return drinks;
    }


}
