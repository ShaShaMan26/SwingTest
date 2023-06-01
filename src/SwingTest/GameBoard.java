package SwingTest;

import javax.swing.*;
import java.awt.*;

public class GameBoard extends JPanel {
    GameBoard(Dimension windowDimensions) {
        this.setSize(windowDimensions);
    }

    public void paintComponent(Graphics g) {
        for (Component component : this.getComponents()) {
            component.paint(g);
        }
    }
}
