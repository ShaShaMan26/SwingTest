package SwingTest;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PlayerController implements KeyListener {
    private Player player;
    private char previousInput;

    PlayerController(Player player) {
        this.player = player;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyChar()) {
            case 'w':
                player.setYDirection(-1);
                previousInput = 'w';
                break;
            case 'a':
                player.setXDirection(-1);
                previousInput = 'a';
                break;
            case 's':
                player.setYDirection(1);
                previousInput = 's';
                break;
            case 'd':
                player.setXDirection(1);
                previousInput = 'd';
                break;
            default:
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyChar()) {
            case 'w':
                if (previousInput != 's') {
                    player.setYDirection(0);
                }
                break;
            case 'a':
                if (previousInput != 'd') {
                    player.setXDirection(0);
                }
                break;
            case 's':
                if (previousInput != 'w') {
                    player.setYDirection(0);
                }
                break;
            case 'd':
                if (previousInput != 'a') {
                    player.setXDirection(0);
                }
                break;
            default:
                break;
        }
    }
}
