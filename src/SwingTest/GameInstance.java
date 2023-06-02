package SwingTest;

import java.awt.*;

public class GameInstance {
    private final Dimension SCREEN_DIMENSIONS = Toolkit.getDefaultToolkit().getScreenSize();
    private final Dimension WINDOW_DIMENSIONS = new Dimension(SCREEN_DIMENSIONS.width, SCREEN_DIMENSIONS.height);

    MetaActionListener metaActionListener = new MetaActionListener();
    GameWindow gameWindow = new GameWindow(WINDOW_DIMENSIONS);
    GameBoard gameBoard = new GameBoard(WINDOW_DIMENSIONS);
    Player player = new Player(WINDOW_DIMENSIONS);
    PlayerController playerController = new PlayerController(player);
    Enemy enemy = new Enemy(WINDOW_DIMENSIONS);
    Collectable currentCollectable;
    ScoreDisplay scoreDisplay;

    private int score;

    GameInstance() {
        gameBoard.add(player);
        gameBoard.add(enemy);
        generateNewCollectable();

        score = 0;
        scoreDisplay = new ScoreDisplay(WINDOW_DIMENSIONS);
        gameBoard.add(scoreDisplay);

        gameWindow.add(gameBoard);

        gameWindow.addKeyListener(metaActionListener);
        gameWindow.addKeyListener(playerController);
    }

    public void collectCollectable() {
        gameBoard.remove(currentCollectable);
        score++;
        scoreDisplay.setScore(score);
    }

    public void generateNewCollectable() {
        currentCollectable = new Collectable(WINDOW_DIMENSIONS);
        gameBoard.add(currentCollectable);
    }

    private boolean colliding(int item1Start, int item1End, int item2Start, int item2End) {
        return (item2Start <= item1Start && item1Start <= item2End) || (item2Start <= item1End && item1End <= item2End);
    }

    public void checkCollisions() {
        // player and collectable collision
        if (colliding(currentCollectable.xPos, currentCollectable.xPos + currentCollectable.COLLECTABLE_WIDTH, player.xPos, player.xPos + player.PLAYER_WIDTH)
                && colliding(currentCollectable.yPos, currentCollectable.yPos + currentCollectable.COLLECTABLE_HEIGHT, player.yPos, player.yPos + player.PLAYER_HEIGHT)) {
            collectCollectable();
            generateNewCollectable();
        }

        // player and enemy collision
        if (colliding(player.xPos, player.xPos + player.PLAYER_WIDTH, enemy.xPos, enemy.xPos + enemy.ENEMY_WIDTH)
                && colliding(player.yPos, player.yPos + player.PLAYER_HEIGHT, enemy.yPos, enemy.yPos + enemy.ENEMY_HEIGHT)) {
            System.exit(1);
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

    public void run() {
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        while (true) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            if (delta >= 1) {
                gameWindow.repaint();
                checkCollisions();
                makeMoves();
                delta--;
            }
        }
    }
}

