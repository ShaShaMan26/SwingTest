package SwingTest;

import java.awt.*;

public class Collectable extends Component {
    private int xPos;
    private int yPos;
    private final int COLLECTABLE_HEIGHT;
    private final int COLLECTABLE_WIDTH;

    Collectable(Dimension windowDimensions) {
        COLLECTABLE_HEIGHT = windowDimensions.height / 15;
        COLLECTABLE_WIDTH = windowDimensions.height / 15;

        this.xPos = (int)(Math.random() * (windowDimensions.width - COLLECTABLE_WIDTH) + 1);
        this.yPos = (int)(Math.random() * (windowDimensions.height - COLLECTABLE_HEIGHT) + 1);
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.ORANGE);
        g.fillRect(xPos, yPos, COLLECTABLE_WIDTH, COLLECTABLE_HEIGHT);
        g.setColor(Color.YELLOW);
        g.fillRect(xPos+((COLLECTABLE_WIDTH - (int)(COLLECTABLE_WIDTH * .7)) / 2), yPos+((COLLECTABLE_HEIGHT - (int)(COLLECTABLE_HEIGHT * .7)) / 2), (int)(COLLECTABLE_WIDTH * .7), (int)(COLLECTABLE_HEIGHT * .7));
    }
}
