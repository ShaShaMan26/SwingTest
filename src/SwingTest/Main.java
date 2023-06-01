package SwingTest;

import java.awt.*;

public class Main {
    public static void main(String[] args) {

        GameWindow gameWindow = new GameWindow();

        GameBoard gameBoard = new GameBoard(gameWindow.getWindowDimensions());

        Player player = new Player();
        gameBoard.add(player);

        PlayerController playerController = new PlayerController(player);
        gameWindow.addKeyListener(playerController);

        gameWindow.add(gameBoard);
        gameWindow.repaint();

        while (true) {
            gameWindow.repaint();
        }
    }
}
