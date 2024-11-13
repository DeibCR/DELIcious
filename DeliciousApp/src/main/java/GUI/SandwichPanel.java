package GUI;

import com.pluralsight.deliciousPOS.*;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import javax.swing.JList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.ArrayList;


public class SandwichPanel extends JPanel {
    private JPanel mainPanel;
    private JComboBox<BreadType> breadTypeList;
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
    private JButton yesButton;
    private JButton noButton;
    private JButton addSandwichButton;
    private JLabel prompt7;
    private Order order;
    private JCheckBox extraMeatCheckBox;
    private boolean isToasted = false;
    private SandwichListener sandwichListener;


    public  SandwichPanel(Order order) {
        setLayout(new GridLayout(0, 2));
        setBackground(Color.LIGHT_GRAY);
        //breadTypeComboBox.setBackground(Color.orange);


        BreadType[] breadType = loadBreadData();
        breadTypeList.removeAllItems();
        breadTypeList.setBackground(Color.CYAN);


        for (BreadType type : breadType) {
            breadTypeList.addItem(type);
        }

        meatsList.setListData(loadMeatData());

        meatsList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        JScrollPane meatScrollPane = new JScrollPane(meatsList);


        cheeseList.setListData(loadCheeseData());
        JScrollPane cheeseScrollPane = new JScrollPane(cheeseList);
        cheeseList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);



        DefaultListModel<R_Topping> otherToppingsListModel = new DefaultListModel<>();
        JScrollPane otherToppingsScrollPane= new JScrollPane(otherToppingsList);
        otherToppingsList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        DefaultListModel<Sauce> saucesListModel = new DefaultListModel<>();
        JScrollPane saucesScrollPane= new JScrollPane(saucesList);
        saucesList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);




        for (SandwichSize size : SandwichSize.values()){
            sandwichSizeComboBox.addItem(size);
        }


        otherToppingsList.setListData(R_Topping.values());

        saucesList.setListData(Sauce.values());

        //prompt1.setBackground(Color.ORANGE);
        add(prompt1);
        add(breadTypeList);

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

        add(prompt7);
        add(yesButton);
        add(noButton);
        add(addSandwichButton);




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


        addSandwichButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //Get the selected bread and sandwich sizes
                BreadType selectedBread =(BreadType) breadTypeList.getSelectedItem();
                SandwichSize selectedSize=(SandwichSize) sandwichSizeComboBox.getSelectedItem();

                //this is to make sure that the user select bread and size first, bloking the option of add a sandwich withouth those components
                if (selectedBread == null || selectedSize == null) {
                    JOptionPane.showMessageDialog(SandwichPanel.this, "Please select both bread and sandwich size.");
                    return;
                }

                //Retrieve the selected meats
                List<Meat> selectedMeats = meatsList.getSelectedValuesList();


                //Retrieve the selected meats
                List<Cheese> selectedCheeses = cheeseList.getSelectedValuesList();
                //error testings
                System.out.println("Selected Meats: " + selectedMeats);
                System.out.println("Selected Cheeses: " + selectedCheeses);

                //Retrieve the selected regular toppings
                List<R_Topping> selectedToppings = otherToppingsList.getSelectedValuesList();

                //Retrieve the selected regular toppings
                List<Sauce> selectedSauces = saucesList.getSelectedValuesList();

               //Combine all selected toppings
                List<Topping> allToppings = new ArrayList<>();
                allToppings.addAll(selectedMeats);
                allToppings.addAll(selectedCheeses);
                allToppings.addAll(selectedToppings);
                allToppings.addAll(selectedSauces);

                //create a new sandwich bject and added to the order, and show a confirmation message.
                Sandwich newSandwich = new Sandwich(selectedSize,selectedBread ,allToppings, isToasted );
                order.addSandwich(newSandwich);

                JOptionPane.showMessageDialog(SandwichPanel.this, "Sandwich added to order!");

                if (sandwichListener != null) {
                    sandwichListener.onSandwichAdded();
                }

            }
        });
        yesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isToasted = true;

            }
        });
        noButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isToasted = false;

            }
        });
    }
    public BreadType getSelectedBreadType() {
        return (BreadType) breadTypeList.getSelectedItem();
    }


    public SandwichSize getSelectedSandwichSize() {
        return (SandwichSize) sandwichSizeComboBox.getSelectedItem();
    }

    private void handleMeatSelection() {

        List<Meat> selectedMeats = meatsList.getSelectedValuesList();
        System.out.println("Selected Meats: " + selectedMeats);//debug
        StringBuilder selectedMeatNames = new StringBuilder("Selected Meats: ");

        // to append selected meat names to the string
        for (Meat meat : selectedMeats) {
            selectedMeatNames.append(meat.getName()).append(" ");
        }

        // to show a message dialog with the selected meats
        JOptionPane.showMessageDialog(this, selectedMeatNames.toString(), "Meat Selection", JOptionPane.INFORMATION_MESSAGE);
    }

    public void handleCheeseSelection(){
        List<Cheese> selectedCheese = cheeseList.getSelectedValuesList();
        StringBuilder selectedCheeseNames = new StringBuilder("Selected Cheese: ");


        for (Cheese cheese : selectedCheese) {
            selectedCheeseNames.append(cheese.getName()).append(" ");
        }


        JOptionPane.showMessageDialog(this, selectedCheeseNames.toString(), "Cheese Selection", JOptionPane.INFORMATION_MESSAGE);

    }

    public void handleOtherToppingsSelection(){
        List<R_Topping> selectedOtherToppings= otherToppingsList.getSelectedValuesList();
        StringBuilder selectedOtherToppingsNames = new StringBuilder("Selected Other Toppings: ");

        for (R_Topping rTopping : selectedOtherToppings){
            selectedOtherToppingsNames.append(rTopping.getName()).append("");
        }

        JOptionPane.showMessageDialog(this, selectedOtherToppingsNames.toString(), "Other Toppings Selection", JOptionPane.INFORMATION_MESSAGE);
    }

    public void handleSaucesSelection(){
        List<Sauce> selectedSauces= saucesList.getSelectedValuesList();
        StringBuilder selectedSaucesNames = new StringBuilder("Selected Sauces: ");

        for (Sauce sauce : selectedSauces){
            selectedSaucesNames.append(sauce.getName()).append("");
        }

        JOptionPane.showMessageDialog(this, selectedSaucesNames.toString(), "Other Toppings Selection", JOptionPane.INFORMATION_MESSAGE);

    }


    public boolean isExtraMeatSelected() {
        return extraMeatCheckBox.isSelected();
    }

    public void setSandwichListener(SandwichListener listener) {
        this.sandwichListener = listener;
    }


    public interface SandwichListener {
        void onSandwichAdded();
    }

    private Meat[] loadMeatData() {
        List<Meat> meats = DataLoader.loadMeatData(getClass().getClassLoader().getResource("constantDataMeat.csv").getPath());
        System.out.println("Meats loaded for panel: " + meats.size());
        return meats.toArray(new Meat[0]);
    }

    private Cheese[] loadCheeseData() {
        List<Cheese> cheeses = DataLoader.loadCheeseData(getClass().getClassLoader().getResource("constantDataCheese.csv").getPath());
        System.out.println("Meats loaded for panel: " + cheeses.size());
        return cheeses.toArray(new Cheese[0]);
    }

    private BreadType[] loadBreadData() {

        List<BreadType> breadTypes = DataLoader.loadBreadData(getClass().getClassLoader().getResource("constantDataBreadType.csv").getPath());
        System.out.println("Bread types loaded for panel: " + breadTypes.size());
        return breadTypes.toArray(new BreadType[0]);
    }
}
