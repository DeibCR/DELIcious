import com.delicious.view.HomeScreenGUI;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                HomeScreenGUI homeScreenGUI = new HomeScreenGUI();
                homeScreenGUI.setVisible(true);
            }
        });
    }

}