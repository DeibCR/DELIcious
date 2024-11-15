package com.delicious.view;

import com.delicious.model.DataLoader;
import com.delicious.model.Meat;
import com.delicious.model.Order;

import javax.swing.*;
import java.awt.*;
import java.util.List;


public class MeatsPanel extends JPanel{

    private final JPanel mainPanel;
    private final JList<Meat> meatsList;
    private MeatsListener meatsListener;

    public  MeatsPanel(Order order){
        setLayout(new BorderLayout());
        mainPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        mainPanel.setBackground(Color.orange);
       meatsList = new JList<>();



        meatsList.setListData(loadMeatData());
        JScrollPane meatScrollPane=new JScrollPane(meatsList);
        meatsList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        meatScrollPane.setPreferredSize(new Dimension(400, 350));


        mainPanel.add(meatScrollPane, BorderLayout.CENTER);
        add(mainPanel, BorderLayout.CENTER);

    }

    public void setMeatListener(MeatsPanel.MeatsListener listener) {
        this.meatsListener = listener;
    }

    public interface MeatsListener {
        void onSandwichAdded();
    }

    private Meat[] loadMeatData() {
        List<Meat> meats = DataLoader.loadMeatData(getClass().getClassLoader().getResource("data/constantDataMeat.csv").getPath());
        System.out.println("Meats loaded for panel: " + meats.size());
        return meats.toArray(new Meat[0]);
    }
    public JList<Meat> getJListMeats() {
        return meatsList;
    }





}
