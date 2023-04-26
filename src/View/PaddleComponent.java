package View;
import javax.swing.*;
import java.awt.*;

/**
 * File name: PaddleComponent.java
 * Short description: Component class to draw paddle
 * IST 242 Assignment: GUI Project
 * @author Luke Hanrahan & Brandon Orlando
 * @version 1.0 4/25/2023
 */

public class PaddleComponent extends JComponent {
    // Constructors

    public PaddleComponent(int x, int y, int width, int height) {
        setBounds(x, y, width, height);
    }

    /**
     * Method that paints the paddle
     * @param g the <code>Graphics</code> object to protect
     */
    public void paintComponent(Graphics g) {
        g.setColor(Color.lightGray);
        g.fillRect(0, 0, getBounds().width, getBounds().height);
    }
}