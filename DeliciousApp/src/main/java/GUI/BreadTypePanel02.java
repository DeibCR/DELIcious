package GUI;

import javax.swing.*;
import com.pluralsight.deliciousPOS.BreadType;
import com.pluralsight.deliciousPOS.DataLoader;
import com.pluralsight.deliciousPOS.Order;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class BreadTypePanel02 extends JPanel {
    private JPanel mainPanel;
    private JList<BreadType> breadType;


    private BreadTypePanel02.BreadTypeListener breadTypeListener;

    public BreadTypePanel02(Order order) {
        setLayout(new BorderLayout());
        mainPanel = new JPanel(new BorderLayout());
        breadType = new JList<>();

        BreadType[] breadData = loadBreadData();
        if (breadData.length == 0) {
            System.out.println("Error: No bread types loaded.");
        } else {
            System.out.println("Bread types loaded successfully.");
        }



        breadType.setListData(loadBreadData());
        breadType.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        JScrollPane breadScrollPane=new JScrollPane(breadType);
        breadScrollPane.setPreferredSize(new Dimension(200, 150));


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

        List<BreadType> breadTypes = DataLoader.loadBreadData(getClass().getClassLoader().getResource("constantDataBreadType.csv").getPath());
        System.out.println("Bread types loaded for panel: " + breadTypes.size());
        return breadTypes.toArray(new BreadType[0]);
    }

    public JList<BreadType> getJlistBread() {
        return breadType;
    }
}



