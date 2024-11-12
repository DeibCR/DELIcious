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
    private JButton checkOutButton;
    private JButton orderInfoButton;
    private JButton cancelOrderButton;
    private JLabel customerName;
    private JPanel dateTime;
    private JPanel hamburgerButtom;
    private JPanel mainPanel;
    private JPanel dynamicPanel;
    private JScrollPane orderDetailsPanel;
    private JTextArea orderSummaryTextArea;
    private Order order;

    private JPanel sandwichPanel;

    public OrderScreen() {
        setTitle("Order Screen");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 800);
        setLocationRelativeTo(null);
        setContentPane(mainPanel);


        order = new Order();
        //dynamicPanel.setLayout(new BorderLayout(1, 1));

        //orderSummaryTextArea = new JTextArea();

        orderSummaryTextArea.setEditable(false);
        //orderDetailsPanel = new JScrollPane(orderSummaryTextArea);

        //mainPanel.add(orderDetailsPanel, BorderLayout.EAST);


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

        dynamicPanel.removeAll(); //to remove the content on the panel


        SandwichPanel sandwichPanel = new SandwichPanel(order); //create the panel
        sandwichPanel.setSandwichListener( this);
        dynamicPanel.add(sandwichPanel, BorderLayout.CENTER);  ;


        dynamicPanel.revalidate(); //refresh
        dynamicPanel.repaint();


    }

    private void updateOrderDetails(){
        String orderSummary= order.displayOrderDetails();

        orderSummaryTextArea.setText(orderSummary);

        orderDetailsPanel.revalidate();
        orderDetailsPanel.repaint();


    }

    @Override
    public void onSandwichAdded(){
        updateOrderDetails();
    }


}

