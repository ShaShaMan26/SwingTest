package SwingTest;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {
    private final Dimension SCREEN_DIMENSIONS = Toolkit.getDefaultToolkit().getScreenSize();
    private final Dimension WINDOW_DIMENSIONS = new Dimension(SCREEN_DIMENSIONS.width, SCREEN_DIMENSIONS.height - 45);

    GameWindow() {
        this.setTitle("SwingTest");
        this.setSize(WINDOW_DIMENSIONS);
        this.setLayout(null);
        this.setLocationRelativeTo(null);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void fullscreen() {
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setUndecorated(true);
    }

    public Dimension getWindowDimensions() {
        return WINDOW_DIMENSIONS;
    }
}
