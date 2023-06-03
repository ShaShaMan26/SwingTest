package SwingTest;

public class Main {
    public static GameInstance gameInstance = new GameInstance();
    public static void main(String[] args) {

        MetaActionListener metaActionListener = new MetaActionListener(gameInstance);
        gameInstance.gameWindow.addKeyListener(metaActionListener);

        gameInstance.run();
    }
}
