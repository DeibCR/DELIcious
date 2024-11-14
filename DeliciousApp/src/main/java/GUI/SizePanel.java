package GUI;

import com.pluralsight.deliciousPOS.Order;
import com.pluralsight.deliciousPOS.SandwichSize;

import javax.swing.*;
import java.awt.*;

public class SizePanel extends JPanel {
    private JPanel mainPanel;
    private JComboBox<SandwichSize> comboBoxSize;
    private SizePanel.SizeListener sizeListener;

    public SizePanel(Order order) {
        setLayout(new BorderLayout());
        mainPanel = new JPanel(new BorderLayout());
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
