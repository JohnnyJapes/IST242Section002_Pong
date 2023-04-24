package View;/*
 * Filename: NetComponent.java
 * Short description:
 * IST 242 Assignment:
 * @author  Luke Hanrahan
 * @version 2023/04/24
 */


import javax.swing.*;
import java.awt.*;

/**
 * @author Luke Hanrahan
 * @version 1.0 2023/04/24
 */
public class NetComponent extends JComponent {
    // Instance Variables -- define your private data


    // Constructors
    public NetComponent() //no-arg constructor
    {
        setBounds(590, 0, 10, 800);
    }

    public void paintComponent(Graphics g) {
        g.setColor(Color.white);
        for (int i = 0; i < 800; i+=60) {
            g.fillRect(0, i, 10, 40);
        }

    }

}


