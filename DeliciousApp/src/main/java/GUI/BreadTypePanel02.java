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


    private BreadTypePanel.BreadTypeListener breadTypeListener;

    public BreadTypePanel02(Order order) {
        setLayout(new BorderLayout());
        mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(Color.orange);
        breadType = new JList<>();



        breadType.setListData(loadBreadData());
        breadType.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        JScrollPane breadScrollPane=new JScrollPane(breadType);
        breadScrollPane.setPreferredSize(new Dimension(200, 150));


        mainPanel.add(breadScrollPane, BorderLayout.CENTER);
        add(mainPanel, BorderLayout.CENTER);

    }

    public void setBreadTypeListener(BreadTypePanel.BreadTypeListener listener) {
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



