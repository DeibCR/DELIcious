package GUI;

import javax.swing.*;

public class OrderScreen extends JFrame{
    private JButton sandwichButton;
    private JButton sideButton;
    private JButton drinkButton;
    private JButton checkOutButton;
    private JButton orderInfoButton;
    private JButton cancelOrderButton;
    private JLabel customerName;
    private JPanel dateTime;
    private JPanel hamburgerButtom;
    private JPanel orderDetails;
    private JPanel mainPanel;

    public OrderScreen() {
        setTitle("Order Screen");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 1000);
        setLocationRelativeTo(null);
        setContentPane(mainPanel);


    }


}
