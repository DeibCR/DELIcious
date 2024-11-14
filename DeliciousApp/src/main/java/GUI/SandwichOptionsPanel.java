package GUI;

import com.pluralsight.deliciousPOS.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class SandwichOptionsPanel extends JPanel implements SizePanel.SizeListener, BreadTypePanel02.BreadTypeListener,MeatsPanel.MeatsListener,CheesesPanel.CheesesListener, OtherToppingsPanel.OtherToppingsListener,SaucesPanel.SaucesListener{
    private static final Color DYNAMIC_PANEL_COLOR = Color.darkGray;
    private static final Color FONT_COLOR = Color.WHITE;
    private static final Font FONT_STYLE = new Font("Arial", Font.PLAIN, 18);
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


        setLayout(new BorderLayout());
        optionsPanel.setLayout(new GridLayout(0, 2,10,10));
        optionsPanel.add(size);
        optionsPanel.add(bread);
        optionsPanel.add(cheeses);
        optionsPanel.add(meats);
        optionsPanel.add(otherToppings);
        optionsPanel.add(Sauces);


        //For the addSandwich and toasted Buttons
        buttonPanel.setPreferredSize(new Dimension(0, 55)); // Adjust height as needed
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        toastedButton.setPreferredSize(new Dimension(120, 45));
        addSandwichButton.setPreferredSize(new Dimension(120, 45));
        buttonPanel.add(toastedButton);
        buttonPanel.add(addSandwichButton);



        dynamicPanel02.setLayout(new GridLayout(1, 0));
        dynamicPanel02.setBackground(DYNAMIC_PANEL_COLOR);




        add(optionsPanel, BorderLayout.NORTH);
        add(dynamicPanel02, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
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

                List<Topping> allToppings = new ArrayList<>();

                for (Meat meat : selectedMeats) {
                    allToppings.add(meat);
                }


                for (Cheese cheese : selectedCheeses) {
                    allToppings.add(cheese);
                }

                List<R_Topping> selectedOtherToppings= otherToppingsPanel.getJListOtherToppings().getSelectedValuesList();
                List<Sauce> selectedSauces= saucesPanel.getJListSauces().getSelectedValuesList();


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
        displayPanel(sizePanel=new SizePanel(order));
        sizePanel.setSizeListener(this);
    }

    private void displayBreadTypePanel() {
        displayPanel(breadTypePanel02=new BreadTypePanel02(order));
        breadTypePanel02.setBreadTypeListener(this);
    }

    private void displayMeatsPanel() {
        displayPanel(meatsPanel=new MeatsPanel(order));
        meatsPanel.setMeatListener(this);
    }

    private void displayCheesePanel() {
        displayPanel(cheesesPanel=new CheesesPanel(order));
        cheesesPanel.setCheeseListener(this);
    }

    private void displayOtherOptionsPanel() {
        displayPanel(otherToppingsPanel=new OtherToppingsPanel(order));
        otherToppingsPanel.setOtherToppingsListener(this);
    }

    private void displaySaucesPanel() {
       displayPanel(saucesPanel=new SaucesPanel(order));
        saucesPanel.setSaucesListener(this);
    }

    //Helper method to display panels
    private void displayPanel(JPanel panel) {
        if (dynamicPanel02 == null) {
            System.out.println("Error: dynamicPanel is not initialized.");
            return;
        }

        dynamicPanel02.removeAll();
        setStyle(panel, DYNAMIC_PANEL_COLOR, FONT_STYLE, FONT_COLOR);
        dynamicPanel02.add(panel, BorderLayout.CENTER);
        dynamicPanel02.revalidate();
        dynamicPanel02.repaint();

    }
    //Helper method to apply style recursive
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
