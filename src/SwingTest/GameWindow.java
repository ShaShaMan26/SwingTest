package SwingTest;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {

    GameWindow(Dimension windowDimensions) {
        this.setTitle("SwingTest");
        this.setSize(windowDimensions);
        this.setLayout(null);
        this.setLocationRelativeTo(null);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void fullscreen() {
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setUndecorated(true);
    }
}
