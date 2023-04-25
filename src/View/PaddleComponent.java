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
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    // Set methods - one set method for each instance variable defined above
    //             - purpose is to pass in a value stored in the private variable
    public void setAll(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public boolean collidesWith(BallComponent ball) {
        Rectangle paddleBounds = getBounds();
        Rectangle ballBounds = ball.getBounds();

        return paddleBounds.intersects(ballBounds);
    }

    public void paintComponent(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(0, 0, getBounds().width, getBounds().height);
    }
}


