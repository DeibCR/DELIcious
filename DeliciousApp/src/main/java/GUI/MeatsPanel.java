package GUI;


import com.pluralsight.deliciousPOS.Cheese;
import com.pluralsight.deliciousPOS.DataLoader;
import com.pluralsight.deliciousPOS.Meat;
import com.pluralsight.deliciousPOS.Order;

import javax.swing.*;
import java.awt.*;
import java.util.List;


public class MeatsPanel extends JPanel{

    private JPanel mainPanel;
    private JList<Meat> meatsList;
    private MeatsListener meatsListener;

    public  MeatsPanel(Order order){
        setLayout(new BorderLayout());
        mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(Color.orange);
       meatsList = new JList<>();



        meatsList.setListData(loadMeatData());
        meatsList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        JScrollPane breadScrollPane=new JScrollPane(meatsList);
        breadScrollPane.setPreferredSize(new Dimension(200, 150));


        mainPanel.add(breadScrollPane, BorderLayout.CENTER);
        add(mainPanel, BorderLayout.CENTER);

    }

    public void setMeatListener(MeatsPanel.MeatsListener listener) {
        this.meatsListener = listener;
    }

    public interface MeatsListener {
        void onSandwichAdded();
    }

    private Meat[] loadMeatData() {
        List<Meat> meats = DataLoader.loadMeatData(getClass().getClassLoader().getResource("constantDataMeat.csv").getPath());
        System.out.println("Meats loaded for panel: " + meats.size());
        return meats.toArray(new Meat[0]);
    }
    public JList<Meat> getJListMeats() {
        return meatsList;
    }





}
