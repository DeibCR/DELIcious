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



        sandwichButton.addActionListener(e -> {
            //displaySandwichPanel();
            displaySandwichOptionsPanel();

        });
        drinkButton.addActionListener(e -> displayDrinksPanel());
        sideButton.addActionListener(e -> displayChipsPanel());

        checkOutButton.addActionListener(e -> {
            Receipt.saveReceipt(order);
            JOptionPane.showMessageDialog(OrderScreen.this, "Receipt saved successfully!");

            order = new Order(); // reset order
            updateOrderDetails();



        });
        cancelOrderButton.addActionListener(e -> {
            order = new Order(); // reset order
            updateOrderDetails();
            new HomeScreenGUI().setVisible(true);
            dispose();

        });
    }

    // Methods that display SandwichPanel in the dynamicPanel

    private void displayPanel(JPanel panel) {
        if (dynamicPanel == null) {
            System.out.println("Error: dynamicPanel is not initialized.");
            return;
        }

        dynamicPanel.removeAll();
        dynamicPanel.add(panel, BorderLayout.CENTER);
        dynamicPanel.revalidate();
        dynamicPanel.repaint();
    }


    private void displaySandwichOptionsPanel() {
        SandwichOptionsPanel sandwichOptionsPanel = new SandwichOptionsPanel(order);
        sandwichOptionsPanel.setSandwichOptionsListener(this);
        displayPanel(sandwichOptionsPanel);
    }

    private void displayDrinksPanel() {
        DrinksPanel drinksPanel = new DrinksPanel(order);
        drinksPanel.setDrinksListener(this);
        displayPanel(drinksPanel);
    }

    private void displayChipsPanel() {
        ChipsPanel chipsPanel = new ChipsPanel(order);
        chipsPanel.setChipsListener(this);
        displayPanel(chipsPanel);
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
        timer = new Timer(1000, e -> {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(" MM/dd/yyyy  HH:mm:ss");
            String formattedDateTime = LocalDateTime.now().format(formatter);
            orderDataTime.setText(formattedDateTime);
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

