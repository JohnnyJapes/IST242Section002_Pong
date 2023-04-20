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

    //private JButton startGame;
    private BallComponent ball;
    private PaddleComponent leftPaddle;
    private PaddleComponent rightPaddle;


    public GamePanel() {
        //startGame = new JButton("Start");
        //startGame.addActionListener(this);
        //add(startGame);
        setLayout(null);
        setBackground(Color.darkGray);
        ball = new BallComponent(600,400,20,20);
        leftPaddle = new PaddleComponent(0,0,20,100);
        rightPaddle = new PaddleComponent(0,0,20,100);
        add(ball);
        add(leftPaddle);
        add(rightPaddle);
        leftPaddle.setBounds(90, 0, 20, 100);
        rightPaddle.setBounds(1090, 0, 20, 100);
        ball.setBounds(600,400,1000,800);
        repaint();
    }

    public GamePanel(BallComponent ball, PaddleComponent leftPaddle, PaddleComponent rightPaddle) {
        this.ball = ball;
        this.leftPaddle = leftPaddle;
        this.rightPaddle = rightPaddle;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        ball.move();

        // Check for collisions with left paddle
        if (leftPaddle.collidesWith(ball)) {
            ball.bounceOffPaddle(leftPaddle);
            System.out.println("Left Paddle Collision");
        }

        // Check for collisions with right paddle
        if (rightPaddle.collidesWith(ball)) {
            ball.bounceOffPaddle(rightPaddle);
            System.out.println("Right Paddle Collision");
        }

        validate();
        repaint();
        ball.paintComponent(g);
        //leftPaddle.paintComponent(g);
        //rightPaddle.paintComponent(g);
    }


    // Method for updating left paddle
    public void loadLeftPaddle(int x, int y, int w, int h){
        //.setAll(x,y,w,h);
        leftPaddle.setBounds(90, y, 20, 100);
        repaint();
    }

    // Method for updating right paddle
    public void loadRightPaddle(int x, int y, int w, int h){
        //leftPaddle.setAll(x,y,w,h);
        rightPaddle.setBounds(1090, y, 20, 100);
        repaint();
    }

    public void loadBall(int xCoordinate, int yCoordinate, int width, int height) {
        ball.setBounds(600,400,20,20);
        repaint();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
    }

    public BallComponent getBallComponent() {
        return this.ball;
    }
}
