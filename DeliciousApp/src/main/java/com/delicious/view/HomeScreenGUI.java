package com.delicious.view;


import javax.swing.*;
import java.util.Objects;

public class HomeScreenGUI extends JFrame {
    private JPanel mainPanel;
    private JLabel logoIcon;
    private JPanel buttonsPanel;
    private JButton newOrderButton;
    private JButton close;

    public HomeScreenGUI() {
        setTitle("DELI cious");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(mainPanel);


        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);

        ImageIcon icon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/logo01" +
                ".png")));
        setIconImage(icon.getImage());





        newOrderButton.addActionListener(e -> {

            OrderScreen orderScreen= new OrderScreen();
            orderScreen.setVisible(true);
            dispose();


        });
        close.addActionListener(e -> dispose());
    }


}



