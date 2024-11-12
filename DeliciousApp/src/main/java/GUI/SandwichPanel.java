package GUI;

import com.pluralsight.deliciousPOS.*;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import javax.swing.JList;
import java.util.List;


public class SandwichPanel extends JPanel {
    private JPanel mainPanel;
    private JComboBox<BreadType> breadTypeComboBox;
    private JLabel prompt1;
    private JComboBox<SandwichSize> sandwichSizeComboBox;
    private JLabel prompt2;
    private JList<Meat> meatsList;
    private JLabel prompt3;
    private JList<Cheese> cheeseList;
    private JLabel prompt4;
    private JLabel prompt5;
    private JList<R_Topping> otherToppingsList;
    private JLabel prompt6;
    private JList<Sauce> saucesList;
    private JButton button1;
    private JButton button2;
    private JCheckBox extraMeatCheckBox;


    public  SandwichPanel() {
        setLayout(new GridLayout(0, 2));


        breadTypeComboBox = new JComboBox<>();
        prompt1 = new JLabel("Select Bread Type:");

        sandwichSizeComboBox=new JComboBox<>();
        prompt2=new JLabel("Bread Size:");

        prompt3 = new JLabel("Select Meats:");
        DefaultListModel<Meat> meatListModel = new DefaultListModel<>();
        meatsList = new JList<>();
        meatsList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        JScrollPane meatScrollPane = new JScrollPane(meatsList);

        prompt4=new JLabel("Select your Cheese:");
        DefaultListModel<Meat> cheeseListModel = new DefaultListModel<>();
        cheeseList=new JList<>();
        JScrollPane cheeseScrollPane = new JScrollPane(cheeseList);

        prompt5=new JLabel("Select other Toppings");
        DefaultListModel<R_Topping> otherToppingsListModel = new DefaultListModel<>();
        otherToppingsList=new JList<>();
        JScrollPane otherToppingsScrollPane= new JScrollPane(otherToppingsList);

        prompt6=new JLabel("Select Sauces");
        DefaultListModel<Sauce> saucesListModel = new DefaultListModel<>();
        saucesList=new JList<>();
        JScrollPane saucesScrollPane= new JScrollPane(saucesList);









        for (BreadType bread : BreadType.values()) {
            breadTypeComboBox.addItem(bread);
        }

        for (SandwichSize size : SandwichSize.values()){
            sandwichSizeComboBox.addItem(size);
        }

        meatsList.setListData(Meat.values());

        cheeseList.setListData(Cheese.values());

        otherToppingsList.setListData(R_Topping.values());

        saucesList.setListData(Sauce.values());

        add(prompt1);
        add(breadTypeComboBox);

        add(prompt2);
        add(sandwichSizeComboBox);

        add(prompt3);
        add(meatScrollPane);

        add(prompt4);
        add(cheeseScrollPane);

        add(prompt5);
        add(otherToppingsScrollPane);

        add(prompt6);
        add(saucesScrollPane);


        meatsList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    handleMeatSelection();
                }

            }
        });
        cheeseList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                handleCheeseSelection();
            }
        });
        otherToppingsList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                handleOtherToppingsSelection();
            }
        });
        saucesList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                handleSaucesSelection();

            }
        });
    }
    public BreadType getSelectedBreadType() {
        return (BreadType) breadTypeComboBox.getSelectedItem();
    }

    public SandwichSize getSelectedSandwichSize() {
        return (SandwichSize) sandwichSizeComboBox.getSelectedItem();
    }

    private void handleMeatSelection() {

        List<Meat> selectedMeats = meatsList.getSelectedValuesList();
        StringBuilder selectedMeatNames = new StringBuilder("Selected Meats: ");

        // Append selected meat names to the string
        for (Meat meat : selectedMeats) {
            selectedMeatNames.append(meat.name()).append(" ");
        }

        // Show a message dialog to show the selected meats
        JOptionPane.showMessageDialog(this, selectedMeatNames.toString(), "Meat Selection", JOptionPane.INFORMATION_MESSAGE);
    }

    public void handleCheeseSelection(){
        List<Cheese> selectedCheese = cheeseList.getSelectedValuesList();
        StringBuilder selectedCheeseNames = new StringBuilder("Selected Cheese: ");

        // Append selected meat names to the string
        for (Cheese cheese : selectedCheese) {
            selectedCheeseNames.append(cheese.name()).append(" ");
        }

        // Show a message dialog to show the selected meats
        JOptionPane.showMessageDialog(this, selectedCheeseNames.toString(), "Cheese Selection", JOptionPane.INFORMATION_MESSAGE);

    }

    public void handleOtherToppingsSelection(){
        List<R_Topping> selectedOtherToppings= otherToppingsList.getSelectedValuesList();
        StringBuilder selectedOtherToppingsNames = new StringBuilder("Selected Other Toppings: ");

        for (R_Topping rTopping : selectedOtherToppings){
            selectedOtherToppingsNames.append(rTopping.name()).append("");
        }

        JOptionPane.showMessageDialog(this, selectedOtherToppingsNames.toString(), "Other Toppings Selection", JOptionPane.INFORMATION_MESSAGE);
    }

    public void handleSaucesSelection(){
        List<Sauce> selectedSauces= saucesList.getSelectedValuesList();
        StringBuilder selectedSaucesNames = new StringBuilder("Selected Sauces: ");

        for (Sauce sauce : selectedSauces){
            selectedSaucesNames.append(sauce.name()).append("");
        }

        JOptionPane.showMessageDialog(this, selectedSaucesNames.toString(), "Other Toppings Selection", JOptionPane.INFORMATION_MESSAGE);

    }

    // Method to check if extra meat option is selected
    public boolean isExtraMeatSelected() {
        return extraMeatCheckBox.isSelected();
    }



}
