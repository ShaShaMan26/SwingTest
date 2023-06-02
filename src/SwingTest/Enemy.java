package SwingTest;

import java.awt.*;

public class Enemy extends Component {
    int xPos;
    int yPos;
    int velocity = 10;
    final int MAX_VELOCITY = 15;
    final int MIN_VELOCITY = 8;
    int xDirection;
    int yDirection;
    final int ENEMY_HEIGHT;
    final int ENEMY_WIDTH;
    Enemy(Dimension windowDimensions) {
        ENEMY_HEIGHT = windowDimensions.height / 8;
        ENEMY_WIDTH = windowDimensions.height / 8;

        this.xPos = (int)(Math.random() * (windowDimensions.width - ENEMY_WIDTH) + 1);
        this.yPos = (int)(Math.random() * (windowDimensions.height - ENEMY_HEIGHT) + 1);

        setXDirection(1);
        setYDirection(1);
    }

    public void setRandomVelocity() {
        velocity = MIN_VELOCITY + (int)(Math.random() * (MAX_VELOCITY - MIN_VELOCITY) + 1);
    }

    public void setXDirection(int direction) {
        this.xDirection = direction;
    }
    public void setYDirection(int direction) {
        this.yDirection = direction;
    }

    public void move() {
        xPos += xDirection*velocity;
        yPos += yDirection*velocity;
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.BLACK);
        g.fillOval(xPos, yPos, ENEMY_WIDTH, ENEMY_HEIGHT);
        g.setColor(Color.RED);
        g.fillOval(xPos+((ENEMY_WIDTH - (int)(ENEMY_WIDTH * .85)) / 2), yPos+((ENEMY_HEIGHT - (int)(ENEMY_HEIGHT * .85)) / 2), (int)(ENEMY_WIDTH * .85), (int)(ENEMY_HEIGHT * .85));
    }
}
