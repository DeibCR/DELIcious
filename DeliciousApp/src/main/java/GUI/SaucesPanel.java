package GUI;

import javax.swing.*;

import com.pluralsight.deliciousPOS.Cheese;
import com.pluralsight.deliciousPOS.Order;
import com.pluralsight.deliciousPOS.R_Topping;
import com.pluralsight.deliciousPOS.Sauce;

import java.awt.*;


public class SaucesPanel extends JPanel {
    private JPanel mainPanel;
    private JList<Sauce> saucesList;
    private SaucesListener saucesListener;

    public  SaucesPanel(Order order){
        setLayout(new BorderLayout());
        mainPanel = new JPanel(new BorderLayout());
        saucesList = new JList<>();



        JScrollPane saucesScrollPane= new JScrollPane(saucesList);
        saucesList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        saucesScrollPane.setPreferredSize(new Dimension(200, 150));
        saucesList.setListData(Sauce.values());


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
