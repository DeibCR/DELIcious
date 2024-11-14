package GUI;

import com.pluralsight.deliciousPOS.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class SandwichOptionsPanel extends JPanel implements SizePanel.SizeListener, BreadTypePanel.BreadTypeListener,MeatsPanel.MeatsListener,CheesesPanel.CheesesListener, OtherToppingsPanel.OtherToppingsListener,SaucesPanel.SaucesListener{
    private JPanel mainPanel;
    private JPanel optionsPanel;
    private JPanel dynamicPanel02;
    private JPanel buttonPanel;
    private JButton addSandwichButton;
    private JButton size;
    private JButton cheeses;
    private JButton bread;
    private JButton meats;
    private JButton otherToppings;
    private JButton Sauces;
    private JButton toastedButton;
    private Order order;
    private SizePanel sizePanel;
    private BreadTypePanel02 breadTypePanel02;
    private MeatsPanel meatsPanel;
    private CheesesPanel cheesesPanel;
    private OtherToppingsPanel otherToppingsPanel;
    private SaucesPanel saucesPanel;
    private SandwichOptionsListener sandwichOptionsListener;
    private boolean isToasted = false;

    public SandwichOptionsPanel(Order order) {


        setLayout(new GridLayout(3,1));
        optionsPanel.setLayout(new GridLayout(0, 2,10,10));
        optionsPanel.add(size);
        optionsPanel.add(bread);
        optionsPanel.add(cheeses);
        optionsPanel.add(meats);
        optionsPanel.add(otherToppings);
        optionsPanel.add(Sauces);

        buttonPanel.setLayout(new GridLayout(2,0));
        buttonPanel.add(toastedButton).setSize(120,45);
        buttonPanel.add(addSandwichButton);


        dynamicPanel02.setLayout(new GridLayout(1,0));
        dynamicPanel02.setBackground(Color.darkGray);




        add(optionsPanel);
        add(dynamicPanel02);
        add(buttonPanel);
        //add(addSandwichButton);




        size.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayOptionsSizePanel();

            }
        });
        bread.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayBreadTypePanel();

            }
        });

        meats.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayMeatsPanel();

            }
        });
        cheeses.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayCheesePanel();
            }
        });
        otherToppings.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayOtherOptionsPanel();

            }
        });
        Sauces.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displaySaucesPanel();

            }
        });

        addSandwichButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SandwichSize selectedSize = (SandwichSize) sizePanel.getComboBoxSize().getSelectedItem();
                BreadType selectedBread =(BreadType) breadTypePanel02.getJlistBread().getSelectedValue();

                if (selectedBread == null || selectedSize == null) {
                    JOptionPane.showMessageDialog(SandwichOptionsPanel.this, "Please select both bread and sandwich size.");
                    return;
                }

                List<Meat> selectedMeats= meatsPanel.getJListMeats().getSelectedValuesList();
                List<Cheese> selectedCheeses= cheesesPanel.getJListCheese().getSelectedValuesList();

                System.out.println("Selected Meats: " + selectedMeats);
                System.out.println("Selected Cheeses: " + selectedCheeses);

                List<R_Topping> selectedOtherToppings= otherToppingsPanel.getJListOtherToppings().getSelectedValuesList();
                List<Sauce> selectedSauces= saucesPanel.getJListSauces().getSelectedValuesList();

                List<Topping> allToppings = new ArrayList<>();
                allToppings.addAll(selectedMeats);
                allToppings.addAll(selectedCheeses);
                allToppings.addAll(selectedOtherToppings);
                allToppings.addAll(selectedSauces);

                Sandwich newSandwich= new Sandwich(selectedSize,selectedBread,allToppings,isToasted);
                order.addSandwich(newSandwich);

                JOptionPane.showMessageDialog(SandwichOptionsPanel.this, "Sandwich added to order!");

                if (sandwichOptionsListener != null) {
                    sandwichOptionsListener.onSandwichAdded();
                }


            }
        });
        toastedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isToasted = true;

            }
        });
    }

    public void setSandwichOptionsListener(SandwichOptionsListener listener) {
        this.sandwichOptionsListener = listener;
    }

    @Override
    public void onSandwichAdded() {

    }


    public interface SandwichOptionsListener {
        void onSandwichAdded();
    }

    private void displayOptionsSizePanel() {
        if (dynamicPanel02 == null) {
            System.out.println("Error: dynamicPanel is not initialized.");
            return;
        }

        dynamicPanel02.removeAll(); //to remove existing content in  the panel


        sizePanel=new SizePanel(order);
        sizePanel.setSizeListener(this);
        sizePanel.setBackground(Color.darkGray);
        dynamicPanel02.add(sizePanel,BorderLayout.CENTER);

        dynamicPanel02.revalidate();
        dynamicPanel02.repaint();



    }

    private void displayBreadTypePanel() {
        if (dynamicPanel02 == null) {
            System.out.println("Error: dynamicPanel is not initialized.");
            return;
        }

        dynamicPanel02.removeAll(); //to remove existing content in  the panel

        breadTypePanel02=new BreadTypePanel02(order);
        breadTypePanel02.setBreadTypeListener(this);
        breadTypePanel02.setBackground(Color.darkGray);
        dynamicPanel02.add(breadTypePanel02,BorderLayout.CENTER);

        dynamicPanel02.revalidate();
        dynamicPanel02.repaint();



    }

    private void displayMeatsPanel() {
        if (dynamicPanel02 == null) {
            System.out.println("Error: dynamicPanel is not initialized.");
            return;
        }

        dynamicPanel02.removeAll(); //to remove existing content in  the panel

        meatsPanel=new MeatsPanel(order);
        meatsPanel.setMeatListener(this);
        meatsPanel.setBackground(Color.darkGray);
        dynamicPanel02.add(meatsPanel,BorderLayout.CENTER);

        dynamicPanel02.revalidate();
        dynamicPanel02.repaint();

    }

    private void displayCheesePanel() {
        if (dynamicPanel02 == null) {
            System.out.println("Error: dynamicPanel is not initialized.");
            return;
        }

        dynamicPanel02.removeAll(); //to remove existing content in  the panel

        cheesesPanel=new CheesesPanel(order);
        cheesesPanel.setCheeseListener(this);
        cheesesPanel.setBackground(Color.darkGray);
        dynamicPanel02.add(cheesesPanel,BorderLayout.CENTER);

        dynamicPanel02.revalidate();
        dynamicPanel02.repaint();

    }

    private void displayOtherOptionsPanel() {
        if (dynamicPanel02 == null) {
            System.out.println("Error: dynamicPanel is not initialized.");
            return;
        }

        dynamicPanel02.removeAll(); //to remove existing content in  the panel

        otherToppingsPanel=new OtherToppingsPanel(order);
        otherToppingsPanel.setOtherToppingsListener(this);
        otherToppingsPanel.setBackground(Color.darkGray);
        dynamicPanel02.add(otherToppingsPanel,BorderLayout.CENTER);

        dynamicPanel02.revalidate();
        dynamicPanel02.repaint();

    }

    private void displaySaucesPanel() {
        if (dynamicPanel02 == null) {
            System.out.println("Error: dynamicPanel is not initialized.");
            return;
        }

        dynamicPanel02.removeAll(); //to remove existing content in  the panel

        saucesPanel=new SaucesPanel(order);
        saucesPanel.setSaucesListener(this);
        saucesPanel.setBackground(Color.darkGray);
        dynamicPanel02.add(saucesPanel,BorderLayout.CENTER);

        dynamicPanel02.revalidate();
        dynamicPanel02.repaint();

    }




}
