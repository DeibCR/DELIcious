package com.delicious.view;

import com.delicious.enums.Chips;
import com.delicious.model.Chip;
import com.delicious.model.DataLoader;
import com.delicious.model.Order;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ChipsPanel extends JPanel {

    private static final Color DYNAMIC_PANEL_COLOR = Color.darkGray;
    private static final Color FONT_COLOR = Color.WHITE;
    private static final Font FONT_STYLE = new Font("Arial", Font.PLAIN, 18);
    private JPanel mainPanel;
    private JPanel sizePanel;
    private JPanel chipsPanel;
    private JPanel buttonPanel;
    private JList<Chip> chipsList;
    private JButton addChipsButton;
    private JLabel prompt1;
    private JComboBox sizeComboBox;
    private ChipsPanel.ChipsListener chipsListener;

    public ChipsPanel(Order order) {
        setLayout(new BorderLayout());

        sizePanel.setLayout(new GridLayout(1,0));
        sizePanel.add(prompt1);
        sizePanel.add(sizeComboBox);

        for (Chips chips: Chips.values()){
            sizeComboBox.addItem(chips);
        }


        chipsPanel.setLayout(new GridLayout(1,0));
        chipsList.setListData(loadChipData());
        JScrollPane chipScrollPane=new JScrollPane(chipsList);
        chipsPanel.add(chipScrollPane);

        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 15));
        buttonPanel.setPreferredSize(new Dimension(0, 70)); // Adjust height as needed
        buttonPanel.setBackground(Color.BLACK);
        buttonPanel.add(addChipsButton);

        add(sizePanel,BorderLayout.NORTH);
        add(chipsPanel,BorderLayout.CENTER);
        add(buttonPanel,BorderLayout.SOUTH);

        addChipsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Chips selectedSize=(Chips) sizeComboBox.getSelectedItem();
                if (selectedSize==null){
                    JOptionPane.showMessageDialog(ChipsPanel.this, "Please select chip size.");
                    return;
                }

                List<Chip> selectedChipList =chipsList.getSelectedValuesList();
                if (selectedChipList.isEmpty()) {
                    JOptionPane.showMessageDialog(ChipsPanel.this, "Please select a chip.");
                    return;
                }

                for (Chip chip: selectedChipList){
                    order.addChip(chip,selectedSize);
                }

                JOptionPane.showMessageDialog(ChipsPanel.this, "Chips added to order!");

                if (chipsListener != null) {
                    chipsListener.onChipsAdded();
                }

            }
        });

        setStyle(this,DYNAMIC_PANEL_COLOR,FONT_STYLE,FONT_COLOR);
    }
    public void setChipsListener(ChipsPanel.ChipsListener listener) {
        this.chipsListener = listener;
    }


    public interface ChipsListener {
        void onChipsAdded();
    }

    private Chip[] loadChipData() {

        List<Chip> chipsTypes = DataLoader.loadChipData(getClass().getClassLoader().getResource("data/constantDataChip.csv").getPath());
        return chipsTypes.toArray(new Chip[0]);
    }

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
