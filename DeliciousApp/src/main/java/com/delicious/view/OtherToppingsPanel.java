package com.delicious.view;


import com.delicious.model.Order;
import com.delicious.enums.R_Topping;

import javax.swing.*;
import java.awt.*;


public class OtherToppingsPanel extends JPanel {
    private final JPanel mainPanel;
    private final JList<R_Topping> otherToppingsList;
    private OtherToppingsListener otherToppingsListener;

    public  OtherToppingsPanel(Order order){
        setLayout(new BorderLayout());
        mainPanel = new JPanel(new BorderLayout());
        otherToppingsList = new JList<>();



        JScrollPane otherToppingsScrollPane= new JScrollPane(otherToppingsList);
        otherToppingsList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        otherToppingsScrollPane.setPreferredSize(new Dimension(200, 150));
        otherToppingsList.setListData(R_Topping.values());


        mainPanel.add(otherToppingsScrollPane, BorderLayout.CENTER);
        add(mainPanel, BorderLayout.CENTER);

    }

    public void setOtherToppingsListener(OtherToppingsPanel.OtherToppingsListener listener) {
        this.otherToppingsListener = listener;
    }

    public interface OtherToppingsListener {
        void onSandwichAdded();
    }
    public JList<R_Topping> getJListOtherToppings() {
        return otherToppingsList;
    }





}
