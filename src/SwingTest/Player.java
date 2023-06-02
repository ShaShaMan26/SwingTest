package SwingTest;

import java.awt.*;

public class Player extends Component {
    private int xPos;
    private int yPos;
    private final double VELOCITY = 12;
    int xDirection;
    int yDirection;
    private final int PLAYER_HEIGHT = 50;
    private final int PLAYER_WIDTH = 50;


    Player() {
        xPos = 0;
        yPos = 0;
    }

    public void setXDirection(int direction) {
        this.xDirection = direction;
    }
    public void setYDirection(int direction) {
        this.yDirection = direction;
    }

    public void move() {
        xPos += xDirection*VELOCITY;
        yPos += yDirection*VELOCITY;
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.BLACK);
        g.fillRect(xPos, yPos, PLAYER_WIDTH, PLAYER_HEIGHT);
        g.setColor(Color.BLUE);
        g.fillRect(xPos+((PLAYER_WIDTH - (int)(PLAYER_WIDTH * .8)) / 2), yPos+((PLAYER_HEIGHT - (int)(PLAYER_HEIGHT * .8)) / 2), (int)(PLAYER_WIDTH * .8), (int)(PLAYER_HEIGHT * .8));
    }
}
