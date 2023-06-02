package SwingTest;

import java.awt.*;

public class GameInstance {
    private final Dimension SCREEN_DIMENSIONS = Toolkit.getDefaultToolkit().getScreenSize();
    private final Dimension WINDOW_DIMENSIONS = new Dimension(SCREEN_DIMENSIONS.width, SCREEN_DIMENSIONS.height - 45);

    GameWindow gameWindow = new GameWindow(WINDOW_DIMENSIONS);
    GameBoard gameBoard = new GameBoard(WINDOW_DIMENSIONS);
    Player player = new Player(WINDOW_DIMENSIONS);
    PlayerController playerController = new PlayerController(player);
    Collectable currentCollectable;

    private int score = 0;

    GameInstance() {
        gameBoard.add(player);
        generateNewCollectable();
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
            player.move();
            delta--;
        }
    }
}
}
