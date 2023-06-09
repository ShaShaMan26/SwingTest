package SwingTest;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MetaActionListener implements KeyListener {
    GameInstance gameInstance;

    MetaActionListener(GameInstance gameInstance) {
        this.gameInstance = gameInstance;
    }
    @Override
    public void keyTyped(KeyEvent e) {
        switch (e.getKeyChar()) {
            case 27:
                System.exit(0);
                break;
            case 'r':
                gameInstance.newGame();
                gameInstance.gameBoard.running = true;
                break;
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
