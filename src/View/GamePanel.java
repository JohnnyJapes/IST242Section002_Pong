package View;
import javax.swing.*;
import java.awt.*;

/**
 * File name: GamePanel.java
 * Short description: Panel to display Pong game
 * IST 242 Assignment: GUI Project
 * @author Luke Hanrahan & Brandon Orlando
 * @version 1.4 4/23/23
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

    /**
     * Method to repaint the left paddle
     * @param x int
     * @param y int
     * @param w int
     * @param h int
     */public void loadLeftPaddle(int x, int y, int w, int h){
        leftPaddle.setBounds(x, y, w, h);
        repaint();
    }

    // Method for updating right paddle

    /**
     * Method to repaint the right paddle
     * @param x int
     * @param y int
     * @param w int
     * @param h int
     */
    public void loadRightPaddle(int x, int y, int w, int h){
        rightPaddle.setBounds(x, y, w, h);
        repaint();
    }

    /**
     * Method to repaint the ball
     * @param xCoordinate int
     * @param yCoordinate int
     * @param width int
     * @param height int
     */
    public void loadBall(int xCoordinate, int yCoordinate, int width, int height) {

        ball.setBounds(xCoordinate,yCoordinate,width,height);
        repaint();
    }

    /**
     * Method to repaint the ball
     * @param ballBounds Rectangle object
     */
    public void loadBall(Rectangle ballBounds) {

        ball.setBounds(ballBounds);
        repaint();
    }

    public BallComponent getBallComponent() {
        return this.ball;
    }
}
