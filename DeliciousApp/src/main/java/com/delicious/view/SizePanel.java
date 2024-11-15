package com.delicious.view;

import com.delicious.model.Order;
import com.delicious.enums.SandwichSize;

import javax.swing.*;
import java.awt.*;

public class SizePanel extends JPanel {
    private final JPanel mainPanel;
    private JComboBox<SandwichSize> comboBoxSize;
    private SizePanel.SizeListener sizeListener;

    public SizePanel(Order order) {
        setLayout(new BorderLayout());
        mainPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        mainPanel.setBackground(Color.orange);
        comboBoxSize = new JComboBox<>();



        for (SandwichSize size : SandwichSize.values()){
            comboBoxSize.addItem(size);
        }


        mainPanel.add(comboBoxSize, BorderLayout.CENTER);
        add(mainPanel, BorderLayout.CENTER);

    }
    public void setSizeListener(SizeListener listener) {
        this.sizeListener = listener;
    }

    public interface SizeListener {
        void onSandwichAdded();
    }
    public JComboBox<SandwichSize> getComboBoxSize() {
        return comboBoxSize;
    }
}
