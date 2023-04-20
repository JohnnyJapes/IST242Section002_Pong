package View;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.*;

/**
 * File name: MenuPanel.java
 * Short description: Panel for the initial menu of the GUI
 * IST 242 Assignment: GUI Project
 * @author Luke Hanrahan & Brandon Orlando
 * @version 1.0 3/27/23
 */

public class MenuPanel extends JPanel implements ActionListener {
        JButton startButton, quitButton;
        JLabel title;
        public MenuPanel() {
            startButton = new JButton("Play Pong");
            //startButton.addActionListener(e -> new GameFrame());
            startButton.setLocation(100, 100);
            startButton.setBounds(100, 100, 100, 100);
            add(startButton);
            quitButton = new JButton("Exit");
            quitButton.addActionListener(e -> System.exit(0));
            add(quitButton);
            title = new JLabel("Welcome To Pong!");
            add(title);
        }

    @Override
    public void actionPerformed(ActionEvent e) {
        }

    /**
     * Gets startButton.
     * @return javax.swing.JButton, value of startButton
     */
    public JButton getStartButton() {
        return startButton;
    }
}


