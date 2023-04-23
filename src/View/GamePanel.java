package View;
import javax.swing.*;
import java.awt.*;

/**
 * File name: GamePanel.java
 * Short description: Panel to display Pong game
 * IST 242 Assignment: GUI Project
 * @author Luke Hanrahan & Brandon Orlando
 * @version 1.0 3/27/23
 */

public class GamePanel extends JPanel {

    //private JButton startGame;
    private BallComponent ball;
    private PaddleComponent leftPaddle;
    private PaddleComponent rightPaddle;


    public GamePanel() {
        //startGame = new JButton("Start");
        //startGame.addActionListener(this);
        //add(startGame);
        setLayout(null);
        setSize(1200, 800);
        setBackground(Color.darkGray);
        ball = new BallComponent(600,400,20,20);
        leftPaddle = new PaddleComponent(0,0,20,100);
        rightPaddle = new PaddleComponent(0,0,20,100);
        add(ball);
        add(leftPaddle);
        add(rightPaddle);
        leftPaddle.setBounds(50, 350, 20, 100);
        rightPaddle.setBounds(1130, 350, 20, 100);
        ball.setBounds(600,400,20,20);
        validate();
        repaint();
    }

    public GamePanel(BallComponent ball, PaddleComponent leftPaddle, PaddleComponent rightPaddle) {
        this.ball = ball;
        this.leftPaddle = leftPaddle;
        this.rightPaddle = rightPaddle;
    }

    // Method for updating left paddle
    public void loadLeftPaddle(int x, int y, int w, int h){
        leftPaddle.setBounds(x, y, w, h);
        repaint();
    }

    // Method for updating right paddle
    public void loadRightPaddle(int x, int y, int w, int h){
        rightPaddle.setBounds(x, y, w, h);
        repaint();
    }

    public void loadBall(int xCoordinate, int yCoordinate, int width, int height) {
        // Move / Serve the ball
/*        ball.move();

        // Check for collisions with left paddle
        if (leftPaddle.collidesWith(ball)) {
            ball.bounceOffPaddle(leftPaddle);
            System.out.println("Left Paddle Collision");
        }

        // Check for collisions with right paddle
        if (rightPaddle.collidesWith(ball)) {
            ball.bounceOffPaddle(rightPaddle);
            System.out.println("Right Paddle Collision");
        }*/
        ball.setBounds(xCoordinate,yCoordinate,width,height);
        repaint();
    }
    public void loadBall(Rectangle ballBounds) {
        // Move / Serve the ball

        ball.setBounds(ballBounds);
        repaint();
    }

    public BallComponent getBallComponent() {
        return this.ball;
    }
}
