package View;
import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class BallComponent extends JComponent {
    private int x, y, width, height;

    public BallComponent(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void setAll(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void paintComponent(Graphics g) {
        g.setColor(Color.white);
        System.out.println(width);
        g.fillRect(x, y, width, height);
    }
}
