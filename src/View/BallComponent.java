package View;
import javax.swing.*;
import java.awt.*;

/**
 * File name: BallComponent.java
 * Short description: Component class to draw ball
 * IST 242 Assignment: GUI Project
 * @author Luke Hanrahan & Brandon Orlando
 * @version 1.0 4/25/2023
 */

public class BallComponent extends JComponent {

    // Constructor
    public BallComponent(int x, int y, int width, int height) {
        setBounds(x,y, width, height);
    }

    /**
     * Method to get width from bounds
      * @return int
     */
    public int getWidth() {
        return getBounds().width;
    }

    /**
     * Methodt to get height from bounds
     * @return int
     */
    public int getHeight() {
        return getBounds().height;
    }

    /**
     * Method to paint the ball
     * @param g the <code>Graphics</code> object to protect
     */
    public void paintComponent(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(0, 0, getWidth(), getHeight());
    }
}