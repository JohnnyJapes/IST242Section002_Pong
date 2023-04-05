package View;
/*
 * Filename: PaddleComponent.java
 * Short description:
 * IST 242 Assignment:
 * @author  Brandon Orlando & Luke Hanrahan
 * @version 3/30/23
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

    public void paintComponent(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(x, y, width, height);
    }
}


