package SwingTest;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {

    GameWindow(Dimension windowDimensions) {
        this.setTitle("Block Boy");
        this.setSize(windowDimensions);
        this.setResizable(false);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setUndecorated(true);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
