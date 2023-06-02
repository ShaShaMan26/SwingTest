package SwingTest;

import javax.swing.*;
import java.awt.*;

public class GameBoard extends JPanel {
    GameBoard(Dimension windowDimensions) {
        this.setSize(windowDimensions);
        this.setBackground(Color.GRAY);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Component component : this.getComponents()) {
            component.paint(g);
        }
    }
}
