package View;
import javax.swing.*;

/**
 * File name: GameFrame.java
 * Short description: Frame to contain GamePanel
 * IST 242 Assignment: GUI Project
 * @author Luke Hanrahan & Brandon Orlando
 * @version 1.0 3/27/23
 */

public class GameFrame extends JFrame {
    GamePanel playPanel;
    public GameFrame () {
        super ("Pong");
        playPanel = new GamePanel();
        add(playPanel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize (1200, 800);
        setResizable(false);
        setVisible(true);
    }
}
