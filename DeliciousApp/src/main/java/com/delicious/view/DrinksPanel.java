package com.delicious.view;

import com.delicious.model.DataLoader;
import com.delicious.enums.DrinkSize;
import com.delicious.model.Drink;
import com.delicious.model.Order;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class DrinksPanel extends JPanel {



    private static final Color DYNAMIC_PANEL_COLOR = Color.darkGray;
    private static final Color FONT_COLOR = Color.WHITE;
    private static final Font FONT_STYLE = new Font("Arial", Font.PLAIN, 18);
    private JPanel mainPanel;
    private JComboBox<DrinkSize> sizeComboBox;
    private JLabel prompt1;
    private JPanel drinksPanel;
    private JList<Drink> drinksList;
    private JButton addDrinkButton;
    private JPanel buttonPanel;
    private JPanel sizelPanel;
    private DrinksPanel.DrinksListener drinksListener;
    private Order order;

    public DrinksPanel(Order order) {
        setLayout(new BorderLayout());

        sizelPanel.setLayout(new GridLayout(1,0));
        sizelPanel.add(prompt1);
        sizelPanel.add(sizeComboBox);

        for (DrinkSize size: DrinkSize.values()){
            sizeComboBox.addItem(size);
        }


        drinksPanel.setLayout(new GridLayout(1,0));
        drinksList.setListData(loadDrinkData());
        JScrollPane drinksScrollPane=new JScrollPane(drinksList);
        drinksPanel.add(drinksScrollPane);


       // drinksPanel.add(drinksList);

        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 15));
        buttonPanel.setPreferredSize(new Dimension(0, 70)); // Adjust height as needed
        buttonPanel.setBackground(Color.BLACK);
        buttonPanel.add(addDrinkButton);

        add(sizelPanel,BorderLayout.NORTH);
        add(drinksPanel,BorderLayout.CENTER);
        add(buttonPanel,BorderLayout.SOUTH);



        addDrinkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DrinkSize selectedSize=(DrinkSize) sizeComboBox.getSelectedItem();
                if (selectedSize==null){
                    JOptionPane.showMessageDialog(DrinksPanel.this, "Please select drink size.");
                    return;
                }

                List<Drink> selectedDrinkList = drinksList.getSelectedValuesList();
                if (selectedDrinkList.isEmpty()) {
                    JOptionPane.showMessageDialog(DrinksPanel.this, "Please select a drink.");
                    return;
                }


                for (Drink drink : selectedDrinkList) {

                    order.addDrink(drink, selectedSize);
                }

                JOptionPane.showMessageDialog(DrinksPanel.this, "Drinks added to order!");

                if (drinksListener != null) {
                    drinksListener.onDrinksAdded();
                }


            }
        });

        drinksList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                //handleDrinksSelection();
            }
        });

        setStyle(this,DYNAMIC_PANEL_COLOR,FONT_STYLE,FONT_COLOR);
    }

    public DrinkSize getSelectedDrinkSize() {
        return (DrinkSize) sizeComboBox.getSelectedItem();
    }



    public void setDrinksListener(DrinksPanel.DrinksListener listener) {
        this.drinksListener = listener;
    }


    public interface DrinksListener {
        void onDrinksAdded();
    }

    private Drink[] loadDrinkData() {

        List<Drink> drinkTypes = DataLoader.loadDrinksData(getClass().getClassLoader().getResource("data/constantDataDrinks.csv").getPath());
        return drinkTypes.toArray(new Drink[0]);
    }

    private void setStyle(Component component, Color backgroundColor, Font font, Color fontColor) {
        component.setBackground(backgroundColor);
        component.setFont(font);
        if (component instanceof JComponent) {
            ((JComponent) component).setForeground(fontColor);
        }

        if (component instanceof Container) {
            for (Component child : ((Container) component).getComponents()) {
                setStyle(child, backgroundColor, font, fontColor);
            }
        }
    }


}
