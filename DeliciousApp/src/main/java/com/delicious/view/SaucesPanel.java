package com.delicious.view;

import javax.swing.*;

import com.delicious.model.Order;
import com.delicious.enums.Sauce;

import java.awt.*;


public class SaucesPanel extends JPanel {
    private final JPanel mainPanel;
    private final JList<Sauce> saucesList;
    private SaucesListener saucesListener;

    public  SaucesPanel(Order order){
        setLayout(new BorderLayout());
        mainPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        saucesList = new JList<>();



        JScrollPane saucesScrollPane= new JScrollPane(saucesList);
        saucesList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        saucesList.setListData(Sauce.values());
        saucesScrollPane.setPreferredSize(new Dimension(400, 350));

        mainPanel.add(saucesScrollPane, BorderLayout.CENTER);
        add(mainPanel, BorderLayout.CENTER);

    }

    public void setSaucesListener(SaucesListener listener) {
        this.saucesListener = listener;
    }

    public interface SaucesListener {
        void onSandwichAdded();
    }

    public JList<Sauce> getJListSauces() {
        return saucesList;
    }



}
