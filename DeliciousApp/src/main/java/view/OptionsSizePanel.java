package view;

import model.Order;
import enums.SandwichSize;

import javax.swing.*;

public class OptionsSizePanel extends JPanel {
    private JPanel mainPanel;
    private JComboBox<SandwichSize> comboBoxSize;
    private OptionsSizeListener optionsSizeListener;

    public OptionsSizePanel(Order order) {


        add(comboBoxSize);

        for (SandwichSize size : SandwichSize.values()){
            comboBoxSize.addItem(size);
        }



    }
    public JComboBox<SandwichSize> getComboBoxSize() {
        return comboBoxSize;
    }

    public void setOptionsSizeListener(OptionsSizeListener listener) {
        this.optionsSizeListener = listener;
    }

    public interface OptionsSizeListener {
        void onSandwichAdded();
    }
}
