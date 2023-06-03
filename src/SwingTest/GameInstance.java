package SwingTest;

import java.awt.*;

public class GameInstance {
    private final Dimension WINDOW_DIMENSIONS = Toolkit.getDefaultToolkit().getScreenSize();
    GameWindow gameWindow = new GameWindow(WINDOW_DIMENSIONS);
    GameBoard gameBoard = new GameBoard(WINDOW_DIMENSIONS);

    GameInstance() {
        gameWindow.add(gameBoard);
        gameWindow.addKeyListener(gameBoard.playerController);
    }

    public void newGame() {
        gameWindow.remove(gameBoard);

        gameBoard = new GameBoard(WINDOW_DIMENSIONS);

        gameWindow.add(gameBoard);
        gameWindow.addKeyListener(gameBoard.playerController);
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
            if (delta >= 1 && gameBoard.running) {
                gameWindow.repaint();
                gameBoard.checkCollisions();
                gameBoard.makeMoves();
                delta--;
            }
        }
    }
}

