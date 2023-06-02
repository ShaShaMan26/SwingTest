package SwingTest;

public class GameInstance {
    GameWindow gameWindow = new GameWindow();

    GameBoard gameBoard = new GameBoard(gameWindow.getWindowDimensions());

    Player player = new Player();

    PlayerController playerController = new PlayerController(player);

    GameInstance() {
        gameBoard.add(player);
        gameWindow.addKeyListener(playerController);
        gameWindow.add(gameBoard);
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
