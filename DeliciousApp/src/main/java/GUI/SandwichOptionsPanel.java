package GUI;

import com.pluralsight.deliciousPOS.Order;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SandwichOptionsPanel extends JPanel{
    private JPanel mainPanel;
    private JPanel optionsPanel;
    private JPanel dynamicPanel02;
    private JPanel buttonPanel;
    private JButton addSandwichButton;
    private JButton size;
    private JButton cheeses;
    private JButton bread;
    private JButton meats;
    private JButton otherToppings;
    private JButton Sauces;

    private SandwichOptionsListener sandwichOptionsListener;

    public SandwichOptionsPanel(Order order) {
        setLayout(new GridLayout(3,1));
        optionsPanel.setLayout(new GridLayout(0, 2,10,10));
        optionsPanel.add(size).setSize(120,145);
        optionsPanel.add(bread);
        optionsPanel.add(cheeses);
        optionsPanel.add(meats);
        optionsPanel.add(otherToppings);
        optionsPanel.add(Sauces);

        buttonPanel.setLayout(new GridLayout(1,0));
        buttonPanel.add(addSandwichButton);

        dynamicPanel02.setLayout(new GridLayout(1,0));




        add(optionsPanel);
        add(dynamicPanel02);
        add(buttonPanel);
        //add(addSandwichButton);




        size.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        bread.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

    }

    public void setSandwichOptionsListener(SandwichOptionsListener listener) {
        this.sandwichOptionsListener = listener;
    }




    public interface SandwichOptionsListener {
        void onSandwichAdded();
    }

    private void displayOptionsSizePanel() {
        if (dynamicPanel02 == null) {
            System.out.println("Error: dynamicPanel is not initialized.");
            return;
        }

        dynamicPanel02.removeAll(); //to remove existing content in  the panel


        OptionsSizePanel optionsSizePanel=new OptionsSizePanel();

        drinksPanel.setDrinksListener(this);
        dynamicPanel.add(drinksPanel, BorderLayout.CENTER);

        dynamicPanel.revalidate(); //refresh
        dynamicPanel.repaint();

    }


}
