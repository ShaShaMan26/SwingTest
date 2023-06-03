package SwingTest;

import javax.swing.*;
import java.awt.*;

public class GameBoard extends JPanel {
    private final Dimension WINDOW_DIMENSIONS = Toolkit.getDefaultToolkit().getScreenSize();
    private int score = 0;
    boolean running = true;

    Player player = new Player(WINDOW_DIMENSIONS);
    PlayerController playerController = new PlayerController(player);
    Enemy enemy = new Enemy(WINDOW_DIMENSIONS);
    Collectable collectable = new Collectable(WINDOW_DIMENSIONS);
    ScoreDisplay scoreDisplay = new ScoreDisplay(WINDOW_DIMENSIONS);

    GameBoard(Dimension windowDimensions) {
        this.setSize(windowDimensions);
        this.setBackground(Color.GRAY);

        this.add(collectable);
        this.add(player);
        this.add(enemy);
        this.add(scoreDisplay);
    }

    public void collectCollectable() {
        score++;
        scoreDisplay.setScore(score);
        collectable.setRandomPos(WINDOW_DIMENSIONS);
    }

    private boolean colliding(int item1Start, int item1End, int item2Start, int item2End) {
        return (item2Start <= item1Start && item1Start <= item2End) || (item2Start <= item1End && item1End <= item2End);
    }

    public void checkCollisions() {
        // player and collectable collision
        if (colliding(collectable.xPos, collectable.xPos + collectable.COLLECTABLE_WIDTH, player.xPos, player.xPos + player.PLAYER_WIDTH)
                && colliding(collectable.yPos, collectable.yPos + collectable.COLLECTABLE_HEIGHT, player.yPos, player.yPos + player.PLAYER_HEIGHT)) {
            collectCollectable();
        }

        // player and enemy collision
        if (colliding(player.xPos, player.xPos + player.PLAYER_WIDTH, enemy.xPos, enemy.xPos + enemy.ENEMY_WIDTH)
                && colliding(player.yPos, player.yPos + player.PLAYER_HEIGHT, enemy.yPos, enemy.yPos + enemy.ENEMY_HEIGHT)) {
            running = false;
        }

        // player and window bounds collision
        int nextXPos = (int)(player.xDirection*player.VELOCITY + player.xPos);
        if (nextXPos < 0 || nextXPos + player.PLAYER_WIDTH > WINDOW_DIMENSIONS.width) {
            player.setXDirection(0);
        }
        int nextYPos = (int)(player.yDirection*player.VELOCITY + player.yPos);
        if (nextYPos < 0 || nextYPos + player.PLAYER_HEIGHT > WINDOW_DIMENSIONS.height) {
            player.setYDirection(0);
        }

        // enemy and window bounds collision
        nextXPos = (int)(enemy.xDirection*enemy.velocity + enemy.xPos);
        if (nextXPos < 0) {
            enemy.setXDirection(1);
            enemy.setRandomVelocity();
        } else if (nextXPos + enemy.ENEMY_WIDTH > WINDOW_DIMENSIONS.width) {
            enemy.setXDirection(-1);
            enemy.setRandomVelocity();
        }
        nextYPos = (int)(enemy.yDirection*enemy.velocity + enemy.yPos);
        if (nextYPos < 0) {
            enemy.setYDirection(1);
            enemy.setRandomVelocity();
        } else if (nextYPos + enemy.ENEMY_HEIGHT > WINDOW_DIMENSIONS.height) {
            enemy.setYDirection(-1);
            enemy.setRandomVelocity();
        }
    }

    public void makeMoves() {
        player.move();
        enemy.move();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Component component : this.getComponents()) {
            component.paint(g);
        }
    }
}
