package View;
import javax.swing.*;
import java.awt.*;

/**
 * File name: NetComponent.java
 * Short description: Component to draw simple net graphic
 * IST 242 Assignment: GUI Project
 * @author Luke Hanrahan & Brandon Orlando
 * @version 1.0 4/25/2023
 */

public class NetComponent extends JComponent {
    // Instance Variables -- define your private data


    // Constructors
    public NetComponent() //no-arg constructor
    {
        setBounds(595, 0, 10, 800);
    }

    /**
     * Paints the net
     * @param g the <code>Graphics</code> object to protect
     */
    public void paintComponent(Graphics g) {
        g.setColor(Color.white);
        for (int i = 0; i < 800; i+=60) {
            g.fillRect(0, i, 10, 40);
        }

    }

}


