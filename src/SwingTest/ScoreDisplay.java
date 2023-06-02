package SwingTest;

import java.awt.*;

public class ScoreDisplay extends Component {
    int score;
    int xPos;
    int yPos;
    int width;
    int height;

    ScoreDisplay(Dimension windowDimensions) {
        xPos = (windowDimensions.width / 2);
        yPos = 50;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void paint(Graphics g) {
        super.paint(g);

        g.setColor(Color.BLACK);
        g.setFont(new Font("Comic sans", Font.PLAIN, 45));

        int width = g.getFontMetrics().stringWidth(String.valueOf(score));
        g.drawString(String.valueOf(score), xPos - width, yPos);
    }
}
