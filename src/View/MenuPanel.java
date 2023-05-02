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
 * @version 1.1 5/2/2023
 */

public class MenuPanel extends JPanel implements ActionListener {
    /** Instance Variables */
    JButton startButton, quitButton, resetButton;
    JLabel title, scores;
    JList p1Controls,p2Controls;

    public MenuPanel() {
        /** Set layouts and panels */
        setLayout(new BorderLayout());
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        JPanel scorePanel = new JPanel();
        scorePanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        /** Adding buttons to south panel */
        quitButton = new JButton("Exit");
        quitButton.setPreferredSize(new Dimension(300, 100));
        quitButton.setForeground(Color.red);
        quitButton.setBackground(Color.darkGray);
        quitButton.setFont(new Font("Arial", Font.BOLD, 40));
        quitButton.addActionListener(e -> System.exit(0));

        /** Reset button */
        resetButton = new JButton("Reset Scores");
        resetButton.setPreferredSize(new Dimension(300, 100));
        resetButton.setForeground(Color.white);
        resetButton.setBackground(Color.darkGray);
        resetButton.setFont(new Font("Arial", Font.BOLD, 40));

        /** Start button */
        startButton = new JButton("Play");
        startButton.setPreferredSize(new Dimension(300, 100));
        startButton.setForeground(Color.green);
        startButton.setBackground(Color.darkGray);
        startButton.setFont(new Font("Arial", Font.BOLD, 40));

        /** Score button */
        scores = new JLabel("");
        scores.setForeground(Color.orange);
        scores.setFont(new Font("Arial", Font.BOLD, 35));
        scores.setBorder(new EmptyBorder(0,125,10,0));

        /** Setup p1Controls Display */
        String p1ControlsArr[] = {"Left Paddle Controls:","[W] - UP","[S] - Down","[LSHIFT] - Slow down paddle"};
        p1Controls = new JList(p1ControlsArr);
        p1Controls.setSelectionBackground(Color.darkGray);
        p1Controls.setSelectionForeground(Color.pink);
        p1Controls.setForeground(Color.pink);
        p1Controls.setBackground(Color.darkGray);
        p1Controls.setFont(new Font("Arial", Font.BOLD, 20));
        p1Controls.setBorder(new EmptyBorder(0,125,50,0));

        /** Setup p2Controls Display */
        String p2ControlsArr[] = {"Right Paddle Controls:","[UPARROW] - UP", "[DOWNARROW] - Down", "[RCTRL] - Slow down paddle"};
        p2Controls = new JList(p2ControlsArr);
        p2Controls.setSelectionBackground(Color.darkGray);
        p2Controls.setSelectionForeground(Color.pink);
        p2Controls.setForeground(Color.pink);
        p2Controls.setBackground(Color.darkGray);
        p2Controls.setFont(new Font("Arial", Font.BOLD, 20));
        p2Controls.setBorder(new EmptyBorder(0,275,50,0));

        /** Title label setup */
        title = new JLabel("Welcome To Pong!");
        title.setFont(new Font("Arial", Font.BOLD, 100));
        title.setForeground(Color.white);
        title.setBorder(new EmptyBorder(10,130,10,0));

        /** Adding all the components */
        scorePanel.setBackground(Color.darkGray);
        buttonPanel.add(quitButton);
        buttonPanel.add(resetButton);
        buttonPanel.add(startButton);
        scorePanel.add(scores);
        scorePanel.add(p1Controls);
        scorePanel.add(p2Controls);
        add(scorePanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        buttonPanel.setBackground(Color.DARK_GRAY);
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

    /**
     * Gets scores.
     * @return javax.swing.JLabel, value of scores
     */
    public JLabel getScores() {
        return scores;
    }

    /**
     * Gets quitButton.
     * @return javax.swing.JButton, value of quitButton
     */
    public JButton getQuitButton() {
        return quitButton;
    }

    /**
     * Gets resetButton.
     * @return javax.swing.JButton, value of resetButton
     */
    public JButton getResetButton() {
        return resetButton;
    }
}