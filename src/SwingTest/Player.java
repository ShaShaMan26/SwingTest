package SwingTest;

import java.awt.*;

public class Player extends Component {
    private int xPos;
    private int yPos;

    Player() {
        xPos = 0;
        yPos = 0;
    }

    public void moveUp() {
        yPos--;
    }
    public void moveDown() {
        yPos++;
    }
    public void moveRight() {
        xPos++;
    }
    public void moveLeft() {
        xPos--;
    }

    public void paint(Graphics g) {
        g.setColor(Color.DARK_GRAY);
        g.fillRect(xPos, yPos, 50, 50);
    }
}
