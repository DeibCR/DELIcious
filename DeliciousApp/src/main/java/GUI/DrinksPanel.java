package GUI;

import com.pluralsight.deliciousPOS.*;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class DrinksPanel extends JPanel {
    private JPanel mainPanel;
    private JComboBox<DrinkSize> sizeComboBox;
    private JLabel prompt1;
    private JPanel drinksPanel;
    private JList<Drink> drinksList;
    private JButton addDrinkButton;
    private DrinksPanel.DrinksListener drinksListener;
    private Order order;

    public DrinksPanel(Order order) {
        setLayout(new GridLayout(0, 3));
        setBackground(Color.LIGHT_GRAY);


        for (DrinkSize size: DrinkSize.values()){
            sizeComboBox.addItem(size);
        }

        drinksList.setListData(loadDrinkData());
        JScrollPane drinksScrollPane=new JScrollPane(drinksList);

        add(prompt1);
        add(sizeComboBox);
        add(drinksPanel);
        add(drinksList);
        add(addDrinkButton);


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
                handleDrinksSelection();
            }
        });
    }

    public DrinkSize getSelectedDrinkSize() {
        return (DrinkSize) sizeComboBox.getSelectedItem();
    }

    public void handleDrinksSelection(){
        List<Drink> selectedDrinks= drinksList.getSelectedValuesList();
        StringBuilder selectedDrinksNames = new StringBuilder("Selected Drinks: ");

        for (Drink drink : selectedDrinks){
            selectedDrinksNames.append(drink.getName()).append("");
        }

        JOptionPane.showMessageDialog(this, selectedDrinksNames.toString(), "Other drinks Selection", JOptionPane.INFORMATION_MESSAGE);

    }

    public void setDrinksListener(DrinksPanel.DrinksListener listener) {
        this.drinksListener = listener;
    }


    public interface DrinksListener {
        void onDrinksAdded();
    }

    private Drink[] loadDrinkData() {

        List<Drink> drinkTypes = DataLoader.loadDrinksData(getClass().getClassLoader().getResource("constantDataDrinks.csv").getPath());
        System.out.println("Drinks loaded for panel: " + drinkTypes.size());
        return drinkTypes.toArray(new Drink[0]);
    }


}
