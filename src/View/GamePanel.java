package View;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * File name: GamePanel.java
 * Short description: Panel to display Pong game
 * IST 242 Assignment: GUI Project
 * @author Luke Hanrahan & Brandon Orlando
 * @version 1.0 3/27/23
 */

public class GamePanel extends JPanel implements ActionListener {

    JButton startGame;
    public GamePanel() {
        startGame = new JButton("Start");
        startGame.addActionListener(this);
        add(startGame);
        setBackground(Color.DARK_GRAY);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    public void arrowKeysClicked() {
        
    }

    public void characterKeysClicked() {

    }

}
