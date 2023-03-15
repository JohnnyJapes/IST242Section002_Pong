package View;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/*
 * Filename: MainFrame.java
 * Short description:
 * IST 242 Assignment:
 * @author Luke Hanrahan & Brandon Orlando
 * @version 1.0 3/2/23
 */


public class MainFrame extends JFrame {
    MenuPanel initialPanel;
    public MainFrame () {
        super ("Pong Menu");
        initialPanel = new MenuPanel();
        add(initialPanel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize (1200, 800);
        setResizable(false);
        setVisible(true);
    }
//-------------------------------------------------------------------
}

