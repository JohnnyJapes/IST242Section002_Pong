package View;
import java.awt.*;
import javax.swing.*;

/**
 * File name: MainFrame.java
 * Short description: Frame to contain MenuPanel
 * IST 242 Assignment: GUI Project
 * @author Luke Hanrahan & Brandon Orlando
 * @version 1.0 3/27/23
 */

public class MainFrame extends JFrame {
    MenuPanel initialPanel;
    public MainFrame () {
        super ("Pong Menu");
        initialPanel = new MenuPanel();
        add(initialPanel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize (500, 500);
        setBackground(Color.DARK_GRAY);
        setResizable(false);
        setVisible(true);
    }
}

