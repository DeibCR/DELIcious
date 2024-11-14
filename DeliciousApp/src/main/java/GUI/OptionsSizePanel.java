package GUI;

import com.pluralsight.deliciousPOS.Order;
import com.pluralsight.deliciousPOS.SandwichSize;

import javax.swing.*;

public class OptionsSizePanel extends JPanel {
    private JPanel mainPanel;
    private JComboBox<SandwichSize> comboBoxSize;

    public OptionsSizePanel(Order order) {

        add(comboBoxSize);

        for (SandwichSize size : SandwichSize.values()){
            comboBoxSize.addItem(size);
        }



    }
}
