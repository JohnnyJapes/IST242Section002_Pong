package View;
import javax.swing.*;
import java.awt.*;
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
        setLayout(new BorderLayout());
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        startButton = new JButton("Play Pong");
        startButton.setPreferredSize(new Dimension(300, 100));
        startButton.setForeground(Color.darkGray);
        startButton.setBackground(Color.lightGray);
        buttonPanel.add(startButton);
        quitButton = new JButton("Exit");
        quitButton.setPreferredSize(new Dimension(300, 100));
        quitButton.setForeground(Color.darkGray);
        quitButton.setBackground(Color.lightGray);
        buttonPanel.add(quitButton);
        quitButton.addActionListener(e -> System.exit(0));
        add(buttonPanel, BorderLayout.SOUTH);
        buttonPanel.setBackground(Color.DARK_GRAY);
        title = new JLabel("Welcome To Pong!");
        title.setFont(new Font("Arial", Font.BOLD, 100));
        title.setForeground(Color.white);
        add(title, BorderLayout.NORTH);
        setBackground(Color.DARK_GRAY);
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


