package View;



import Model.Entity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;


/**
 * File name: GamePanel.java
 * Short description: Panel to display Pong game
 * IST 242 Assignment: GUI Project
 * @author Luke Hanrahan & Brandon Orlando
 * @version 1.0 3/27/23
 */

public class GamePanel extends JPanel implements ActionListener {

    //private JButton startGame;
    private BallComponent ball;
    private PaddleComponent lP;
    private PaddleComponent rP;


    public GamePanel() {
        //startGame = new JButton("Start");
        //startGame.addActionListener(this);
        //add(startGame);
        setLayout(null);
        setBackground(Color.darkGray);
        ball = new BallComponent(600,400,20,20);
        lP = new PaddleComponent(0,0,20,100);
        rP = new PaddleComponent(0,0,20,100);
        add(ball);
        add(lP);
        add(rP);
        lP.setBounds(90, 0, 10000, 10000);
        rP.setBounds(1090, 0, 10000, 10000);
        ball.setBounds(0,0,10000,10000);
        repaint();
    }

    // Method for updating left paddle
    public void loadLeftPaddle(int x, int y, int w, int h){
        lP.setAll(x,y,20,100);
        repaint();
    }

    // Method for updating right paddle
    public void loadRightPaddle(int x, int y, int w, int h){
        rP.setAll(x,y,20,100);
        repaint();
    }

    public void loadBall(int x, int y, int w, int h){
        ball.setAll(x,y,w,h);
        repaint();
    }



    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
