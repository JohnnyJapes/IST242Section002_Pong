package View;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
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
    // Instance Variables
    JButton startButton, quitButton, resetButton;
    JLabel title, scores, p1Controls, p2Controls;

    public MenuPanel() {
        setLayout(new BorderLayout());
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        JPanel scorePanel = new JPanel();
        scorePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        // Adding buttons to south panel
        quitButton = new JButton("Exit");
        quitButton.setPreferredSize(new Dimension(300, 100));
        quitButton.setForeground(Color.red);
        quitButton.setBackground(Color.darkGray);
        quitButton.setFont(new Font("Arial", Font.BOLD, 40));
        buttonPanel.add(quitButton);
        resetButton = new JButton("Reset Scores");
        resetButton.setPreferredSize(new Dimension(300, 100));
        resetButton.setForeground(Color.white);
        resetButton.setBackground(Color.darkGray);
        resetButton.setFont(new Font("Arial", Font.BOLD, 40));
        buttonPanel.add(resetButton);
        startButton = new JButton("Play");
        startButton.setPreferredSize(new Dimension(300, 100));
        startButton.setForeground(Color.green);
        startButton.setBackground(Color.darkGray);
        startButton.setFont(new Font("Arial", Font.BOLD, 40));
        buttonPanel.add(startButton);
        quitButton.addActionListener(e -> System.exit(0));
        scores = new JLabel("");
        scores.setForeground(Color.orange);
        scores.setFont(new Font("Arial", Font.BOLD, 35));
        scores.setBorder(new EmptyBorder(0,125,100,0));
        p1Controls = new JLabel("Left Paddle: [W] - UP, [S] - Down, [LSHIFT] - Slow down paddle");
        p1Controls.setForeground(Color.pink);
        p1Controls.setFont(new Font("Arial", Font.BOLD, 20));
        p1Controls.setBorder(new EmptyBorder(0,125,50,0));
        p2Controls = new JLabel("Right Paddle: [UPARROW] - UP, [DOWNARROW] - Down, [RCTRL] - Slow down paddle");
        p2Controls.setForeground(Color.pink);
        p2Controls.setFont(new Font("Arial", Font.BOLD, 20));
        p2Controls.setBorder(new EmptyBorder(10,125,0,0));
        scorePanel.setBackground(Color.darkGray);
        scorePanel.add(scores);
        scorePanel.add(p1Controls);
        scorePanel.add(p2Controls);
        add(scorePanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        buttonPanel.setBackground(Color.DARK_GRAY);
        title = new JLabel("Welcome To Pong!");
        title.setFont(new Font("Arial", Font.BOLD, 100));
        title.setForeground(Color.white);
        title.setBorder(new EmptyBorder(10,130,10,0));
        add(title, BorderLayout.NORTH);
        setBackground(Color.DARK_GRAY);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    /**
     * Gets startButton.
     *
     * @return javax.swing.JButton, value of startButton
     */
    public JButton getStartButton() {
        return startButton;
    }

    /**
     * Gets scores.
     *
     * @return javax.swing.JLabel, value of scores
     */
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
}