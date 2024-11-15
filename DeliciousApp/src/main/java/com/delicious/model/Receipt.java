package com.delicious.model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;



public class Receipt {

    public static void saveReceipt(Order order){
        String filename= order.getFormattedReceiptDate().replace(":","").replace("-","")+ ".txt";

        String directoryPath = "receipts";
        File directory = new File(directoryPath);

        // Create the directory if it does not exist
        if (!directory.exists()) {
            directory.mkdirs();
        }

        // File path with directory
        File file = new File(directory, filename);

        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(file));

            writer.write(order.displayOrderDetails());
            writer.newLine();
            writer.write("Total: $" + String.format("%.2f", order.calculateTotal()));
        } catch (IOException e) {
            System.out.println("Error saving receipt: " + e.getMessage());


        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    System.out.println("Error closing BufferedWriter: " + e.getMessage());
                }
            }
        }
    }
}