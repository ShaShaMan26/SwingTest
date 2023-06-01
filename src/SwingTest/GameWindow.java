package SwingTest;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {
    private final Dimension WINDOW_DIMENSIONS = new Dimension(500, 500);

    GameWindow() {
        this.setTitle("SwingTest");
        this.setSize(WINDOW_DIMENSIONS);
        this.setResizable(false);
        this.setLayout(null);
        this.setLocationRelativeTo(null);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public Dimension getWindowDimensions() {
        return WINDOW_DIMENSIONS;
    }
}
