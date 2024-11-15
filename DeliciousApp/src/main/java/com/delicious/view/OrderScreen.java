package com.delicious.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import com.delicious.model.Order;
import com.delicious.model.Receipt;

public class OrderScreen extends JFrame implements  DrinksPanel.DrinksListener,ChipsPanel.ChipsListener, SandwichOptionsPanel.SandwichOptionsListener, OptionsSizePanel.OptionsSizeListener {
    private JButton sandwichButton;
    private JButton sideButton;
    private JButton drinkButton;
    private JLabel customerName;
    private JPanel dateTime;
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
    private JPanel drinksPanel;
    private Timer timer;



    public OrderScreen() {
        setTitle("Order Screen");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(mainPanel);

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);


        order = new Order();
        orderSummaryTextArea.setEditable(false); //uneditable
        orderSummaryTextArea.setBackground(Color.darkGray);

        totalPriceLabel.setText("Total Price: $0.00"); //a default value for the totalPrice

        startDateTimeUpdater();



        sandwichButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //displaySandwichPanel();
                displaySandwichOptionsPanel();;

            }
        });
        drinkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayDrinksPanel();

            }
        });
        sideButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayChipsPanel();

            }
        });

        checkOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Receipt.saveReceipt(order);
                JOptionPane.showMessageDialog(OrderScreen.this, "Receipt saved successfully!");

                order = new Order(); // reset order
                updateOrderDetails();



            }
        });
        cancelOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                order = new Order(); // reset order
                updateOrderDetails();
                new HomeScreenGUI().setVisible(true);
                dispose();

            }
        });
    }

    // Method that display SandwichPanel in the dynamicPanel


    private void displaySandwichOptionsPanel() {
        if (dynamicPanel == null) {
            System.out.println("Error: dynamicPanel is not initialized.");
            return;
        }

        dynamicPanel.removeAll(); //to remove existing content in  the panel

        SandwichOptionsPanel sandwichOptionsPanel = new SandwichOptionsPanel(order);
        sandwichOptionsPanel.setSandwichOptionsListener(this);
        dynamicPanel.add(sandwichOptionsPanel, BorderLayout.CENTER);



        dynamicPanel.revalidate(); //refresh
        dynamicPanel.repaint();

    }

    private void displayDrinksPanel() {
        if (dynamicPanel == null) {
            System.out.println("Error: dynamicPanel is not initialized.");
            return;
        }

        dynamicPanel.removeAll(); //to remove existing content in  the panel

        DrinksPanel drinksPanel = new DrinksPanel(order);
        drinksPanel.setDrinksListener(this);
        dynamicPanel.add(drinksPanel, BorderLayout.CENTER);

        dynamicPanel.revalidate(); //refresh
        dynamicPanel.repaint();

    }

    private void displayChipsPanel() {
        if (dynamicPanel == null) {
            System.out.println("Error: dynamicPanel is not initialized.");
            return;
        }

        dynamicPanel.removeAll(); //to remove existing content in  the panel

        ChipsPanel chipsPanel = new ChipsPanel(order);
        chipsPanel.setChipsListener(this);
        dynamicPanel.add(chipsPanel, BorderLayout.CENTER);

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

    @Override
    public void onDrinksAdded(){
        updateOrderDetails();
    }

    @Override
    public void onChipsAdded() {
        updateOrderDetails();
    }

    //method that start a timer and updates that time and date
    private void startDateTimeUpdater() {
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern(" MM/dd/yyyy  HH:mm:ss");
                String formattedDateTime = LocalDateTime.now().format(formatter);
                orderDataTime.setText(formattedDateTime);
            }
        });
        timer.start();
    }

    @Override
    public void dispose() {
        // Stop the timer when the frame is closed
        if (timer != null) {
            timer.stop();
        }
        super.dispose();
    }



}

