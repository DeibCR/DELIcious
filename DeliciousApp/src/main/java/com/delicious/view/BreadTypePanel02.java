package com.delicious.view;

import javax.swing.*;
import com.delicious.model.BreadType;
import com.delicious.model.DataLoader;
import com.delicious.model.Order;
import java.awt.*;
import java.util.List;

public class BreadTypePanel02 extends JPanel {
    private final JPanel mainPanel;
    private final JList<BreadType> breadType;


    private BreadTypePanel02.BreadTypeListener breadTypeListener;

    public BreadTypePanel02(Order order) {
        setLayout(new BorderLayout());
        mainPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        breadType = new JList<>();


        breadType.setListData(loadBreadData());
        JScrollPane breadScrollPane=new JScrollPane(breadType);
        breadType.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        breadScrollPane.setPreferredSize(new Dimension(400, 350));



        mainPanel.add(breadScrollPane, BorderLayout.CENTER);
        add(mainPanel, BorderLayout.CENTER);

    }

    public void setBreadTypeListener(BreadTypePanel02.BreadTypeListener listener) {
        this.breadTypeListener = listener;
    }

    public interface BreadTypeListener {
        void onSandwichAdded();
    }

    private BreadType[] loadBreadData() {

        List<BreadType> breadTypes = DataLoader.loadBreadData(getClass().getClassLoader().getResource("data/constantDataBreadType.csv").getPath());
        System.out.println("Bread types loaded for panel: " + breadTypes.size());
        return breadTypes.toArray(new BreadType[0]);
    }

    public JList<BreadType> getJlistBread() {
        return breadType;
    }
}



