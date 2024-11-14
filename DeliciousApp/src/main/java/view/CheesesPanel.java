package view;




import model.DataLoader;
import model.Cheese;
import model.Order;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class CheesesPanel extends JPanel{
    private JPanel mainPanel;
    private JList<Cheese> cheeseList;
    private CheesesListener cheeseListener;

    public  CheesesPanel(Order order){
        setLayout(new BorderLayout());
        mainPanel = new JPanel(new BorderLayout());
        cheeseList = new JList<>();



        cheeseList.setListData(loadCheeseData());
        cheeseList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        JScrollPane breadScrollPane=new JScrollPane(cheeseList);
        breadScrollPane.setPreferredSize(new Dimension(200, 150));


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



