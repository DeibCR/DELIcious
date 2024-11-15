package com.delicious.view;




import com.delicious.model.DataLoader;
import com.delicious.model.Cheese;
import com.delicious.model.Order;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class CheesesPanel extends JPanel{
    private final JPanel mainPanel;
    private final JList<Cheese> cheeseList;
    private CheesesListener cheeseListener;

    public  CheesesPanel(Order order){
        setLayout(new BorderLayout());
        mainPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        cheeseList = new JList<>();



        cheeseList.setListData(loadCheeseData());
        JScrollPane breadScrollPane=new JScrollPane(cheeseList);
        cheeseList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        breadScrollPane.setPreferredSize(new Dimension(400, 350));


        mainPanel.add(breadScrollPane, BorderLayout.CENTER);
        add(mainPanel, BorderLayout.CENTER);

    }

    public void setCheeseListener(CheesesPanel.CheesesListener listener) {
        this.cheeseListener = listener;
    }

    public interface CheesesListener {
        void onSandwichAdded();
    }

    private Cheese[] loadCheeseData() {
        List<Cheese> cheeses = DataLoader.loadCheeseData(getClass().getClassLoader().getResource("data/constantDataCheese.csv").getPath());
        System.out.println("Meats loaded for panel: " + cheeses.size());
        return cheeses.toArray(new Cheese[0]);
    }

    public JList<Cheese> getJListCheese() {
        return cheeseList;
    }

}



