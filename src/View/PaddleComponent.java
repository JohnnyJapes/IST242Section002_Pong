package View;/*
 * Filename: PaddleComponent.java
 * Short description:
 * IST 242 Assignment:
 * @author  Luke Hanrahan
 * @version 3/30/23
 */


import javax.swing.*;
import java.awt.*;

/**
 * @author Luke Hanrahan
 * @version 1.0 3/30/23
 */
public class PaddleComponent  extends JComponent {
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
    // Get methods - one get method for each instance variable defined above
    //             - purpose is to return the value stored in the private variable

    // Additional methods -- such as for calculation, display


    public void paintComponent(Graphics g){
        g.setColor(Color.red);
        System.out.println(width);
        g.fillRect(x, y, width, height);




    }

}


