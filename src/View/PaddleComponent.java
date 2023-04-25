package View;

/**
 * File name: PaddleComponent.java
 * Short description: Component class to draw paddle
 * IST 242 Assignment: GUI Project
 * @author Luke Hanrahan & Brandon Orlando
 * @version 1.0 4/25/2023
 */
import javax.swing.*;
import java.awt.*;
public class PaddleComponent extends JComponent {
    // Instance Variables -- define your private data
    private int x, y, width, height;

    // Constructors
    public PaddleComponent() //no-arg constructor
    {

    }

    public PaddleComponent(int x, int y, int width, int height) {
        setBounds(x, y, width, height);
    }

    /**
     * Method that paints the paddle
     * @param g the <code>Graphics</code> object to protect
     */
    public void paintComponent(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(0, 0, getBounds().width, getBounds().height);
    }
}


