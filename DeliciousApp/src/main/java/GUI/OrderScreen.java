package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import com.pluralsight.deliciousPOS.Order;

public class OrderScreen extends JFrame implements SandwichPanel.SandwichListener{
    private JButton sandwichButton;
    private JButton sideButton;
    private JButton drinkButton;
    private JLabel customerName;
    private JPanel dateTime;
    private JPanel hamburgerButtom;
    private JPanel mainPanel;
    private JPanel dynamicPanel;
    private JScrollPane orderDetailsPanel;
    private JTextArea orderSummaryTextArea;
    private JLabel totalPriceLabel;
    private JButton checkOutButton;
    private JButton cancelOrderButton;
    private JLabel orderDataTime;
    private Order order;

    private JPanel sandwichPanel;

    public OrderScreen() {
        setTitle("Order Screen");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setContentPane(mainPanel);


        order = new Order();
        orderSummaryTextArea.setEditable(false); //uneditable

        totalPriceLabel.setText("Total Price: $0.00"); //a default value for the totalPrice



        sandwichButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displaySandwichPanel();

            }
        });
        drinkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        sideButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    // Method that display SandwichPanel in the dynamicPanel
    private void displaySandwichPanel() {
        if (dynamicPanel == null) {
            System.out.println("Error: dynamicPanel is not initialized.");
            return;
        }

        dynamicPanel.removeAll(); //to remove existing content in  the panel

        SandwichPanel sandwichPanel = new SandwichPanel(order);
        sandwichPanel.setSandwichListener(this);
        dynamicPanel.add(sandwichPanel, BorderLayout.CENTER);
        //sandwichPanel.setBackground(Color.green);



        dynamicPanel.revalidate(); //refresh
        dynamicPanel.repaint();


    }

    private void updateOrderDetails(){
        String orderSummary= order.displayOrderDetails();

        orderSummaryTextArea.setText(orderSummary);

        double total = order.calculateTotal();
        totalPriceLabel.setText(String.format("Total Price: $%.2f", total));

        orderDetailsPanel.revalidate();
        orderDetailsPanel.repaint();
        totalPriceLabel.revalidate();
        totalPriceLabel.repaint();


    }

    @Override
    public void onSandwichAdded(){
        updateOrderDetails();
    }


}

