package View;
import Model.Model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.*;

/**
 * File name: MenuPanel.java
 * Short description: Panel for the initial menu of the GUI
 * IST 242 Assignment: GUI Project
 * @author Luke Hanrahan & Brandon Orlando
 * @version 1.0 4/25/2023
 */

public class MenuPanel extends JPanel implements ActionListener {
    JButton startButton, quitButton, resetButton;
    JLabel title, scores;
    public MenuPanel() {
        setLayout(new BorderLayout());
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        JPanel scorePanel = new JPanel();
        scorePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        //adding buttons to south panel
        startButton = new JButton("Play Pong");
        startButton.setPreferredSize(new Dimension(300, 100));
        startButton.setForeground(Color.darkGray);
        startButton.setBackground(Color.lightGray);
        buttonPanel.add(startButton);
        resetButton = new JButton("Reset Scores");
        resetButton.setPreferredSize(new Dimension(300, 100));
        resetButton.setForeground(Color.darkGray);
        resetButton.setBackground(Color.lightGray);
        buttonPanel.add(resetButton);
        quitButton = new JButton("Exit");
        quitButton.setPreferredSize(new Dimension(300, 100));
        quitButton.setForeground(Color.darkGray);
        quitButton.setBackground(Color.lightGray);
        buttonPanel.add(quitButton);
        quitButton.addActionListener(e -> System.exit(0));
        scores = new JLabel("");
        scores.setPreferredSize(new Dimension(300, 100));
        scores.setForeground(Color.white);
        scorePanel.setBackground(Color.darkGray);
        scorePanel.add(scores);
        add(scorePanel, BorderLayout.CENTER);
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

    public JLabel getScores() {
        return scores;
    }

    /**
     * Gets quitButton.
     *
     * @return javax.swing.JButton, value of quitButton
     */
    public JButton getQuitButton() {
        return quitButton;
    }

    /**
     * Gets resetButton.
     *
     * @return javax.swing.JButton, value of resetButton
     */
    public JButton getResetButton() {
        return resetButton;
    }

    /**
     * Gets title.
     *
     * @return javax.swing.JLabel, value of title
     */
    public JLabel getTitle() {
        return title;
    }
}


