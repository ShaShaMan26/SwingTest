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
    Collectable currentCollectable;

    private int score = 0;

    GameInstance() {
        gameBoard.add(player);
        generateNewCollectable();
        gameWindow.addKeyListener(metaActionListener);
        gameWindow.addKeyListener(playerController);
        gameWindow.add(gameBoard);
    }

    public void collectCollectable() {
        gameBoard.remove(currentCollectable);
        score++;
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

        // player and window bounds
        int nextXPos = (int)(player.xDirection*player.VELOCITY + player.xPos);
        if (nextXPos < 0 || nextXPos + player.PLAYER_WIDTH > WINDOW_DIMENSIONS.width) {
            player.setXDirection(0);
        }
        int nextYPos = (int)(player.yDirection*player.VELOCITY + player.yPos);
        if (nextYPos < 0 || nextYPos + player.PLAYER_HEIGHT > WINDOW_DIMENSIONS.height) {
            player.setYDirection(0);
        }
    }

    public void run() {
    long lastTime = System.nanoTime();
    double amountOfTicks = 60.0;
    double ns = 1000000000 / amountOfTicks;
    double delta = 0;
    while(true) {
        long now = System.nanoTime();
        delta += (now -lastTime)/ns;
        lastTime = now;
        if(delta >= 1) {
            gameWindow.repaint();
            checkCollisions();
            player.move();
            delta--;
        }
    }
}
}
