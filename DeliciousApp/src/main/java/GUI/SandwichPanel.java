package GUI;

import com.pluralsight.deliciousPOS.BreadType;

import javax.swing.*;
import java.awt.*;

public class SandwichPanel extends JPanel {
    private JPanel mainPanel;
    private JComboBox<BreadType> breadTypeComboBox;
    private JLabel prompt;


    public  SandwichPanel() {
        setLayout(new GridLayout(2, 1));


        breadTypeComboBox = new JComboBox<>();
        prompt = new JLabel("Select Bread Type:");



        for (BreadType bread : BreadType.values()) {
            breadTypeComboBox.addItem(bread);
        }

        add(prompt);
        add(breadTypeComboBox);


    }
    public BreadType getSelectedBreadType() {
        return (BreadType) breadTypeComboBox.getSelectedItem();
    }
}
