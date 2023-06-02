package SwingTest;

import java.awt.*;

public class Player extends Component {
    int xPos;
    int yPos;
    final double VELOCITY = 12;
    int xDirection;
    int yDirection;
    final int PLAYER_HEIGHT;
    final int PLAYER_WIDTH;


    Player(Dimension windowDimensions) {
        PLAYER_HEIGHT = windowDimensions.height / 12;
        PLAYER_WIDTH = windowDimensions.height / 12;

        xPos = (windowDimensions.width / 2) - (PLAYER_WIDTH / 2);
        yPos = (windowDimensions.height / 2) - (PLAYER_HEIGHT / 2);
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
