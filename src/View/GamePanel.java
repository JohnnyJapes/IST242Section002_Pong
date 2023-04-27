package View;
import javax.swing.*;
import java.awt.*;

/**
 * File name: GamePanel.java
 * Short description: Panel to display Pong game
 * IST 242 Assignment: GUI Project
 * @author Luke Hanrahan & Brandon Orlando
 * @version 1.5 4/25/2023
 */

public class GamePanel extends JPanel {

    /** Instance Variables */
    private BallComponent ball;
    private PaddleComponent leftPaddle;
    private PaddleComponent rightPaddle;
    private JLabel scoreBoardP1, scoreBoardP2;
    private JLabel space, exit;
    private NetComponent net;

    public GamePanel() {

        /** Add JLabels for left player score [P1] */
        scoreBoardP1 = new JLabel("0");
        scoreBoardP1.setBounds(465, 5, 125, 75);
        scoreBoardP1.setForeground(Color.orange);
        scoreBoardP1.setFont(new Font(Font.DIALOG, Font.ITALIC, 75));
        scoreBoardP1.setHorizontalAlignment(SwingConstants.CENTER);

        /** Add JLabels for right player score [P2] */
        scoreBoardP2 = new JLabel("0");
        scoreBoardP2.setBounds(610, 5, 125, 75);
        scoreBoardP2.setForeground(Color.orange);
        scoreBoardP2.setFont(new Font(Font.DIALOG, Font.ITALIC, 75));
        scoreBoardP2.setHorizontalAlignment(SwingConstants.CENTER);

        /** Add SpaceBar [SPACE] start text */
        space = new JLabel("PRESS [SPACE] TO START");
        space.setBounds(200, 300, 800, 100);
        space.setForeground(Color.orange);
        space.setFont(new Font(Font.DIALOG, Font.ITALIC, 50));
        space.setHorizontalAlignment(SwingConstants.CENTER);

        /** Adding Exit [E] text */
        exit = new JLabel("PRESS [E] TO RETURN TO MENU");
        exit.setBounds(200, 400, 800, 100);
        exit.setForeground(Color.pink);
        exit.setFont(new Font(Font.DIALOG, Font.ITALIC, 50));
        exit.setHorizontalAlignment(SwingConstants.CENTER);

        /**Net Component */
        net = new NetComponent();
        setLayout(null);
        setSize(1200, 800);
        setBackground(Color.darkGray);

        /** Setting initial bounds of paddles and ball*/
        ball = new BallComponent(590,400,20,20);
        leftPaddle = new PaddleComponent(50,350,20,100);
        rightPaddle = new PaddleComponent(1130,350,20,100);

        /** Add to panel (In correct order) */
        add(space);
        add(exit);
        add(ball);
        add(net);
        add(leftPaddle);
        add(rightPaddle);
        add(scoreBoardP1);
        add(scoreBoardP2);

        /** Ensure panel is up-to-date */
        validate();
        repaint();
    }

    /**
     * Method to repaint the left paddle
     * @param x int
     * @param y int
     * @param w int
     * @param h int
     */
    public void loadLeftPaddle(int x, int y, int w, int h){
        leftPaddle.setBounds(x, y, w, h);
        repaint();
    }

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
     * @param ballBounds Rectangle object
     */
    public void loadBall(Rectangle ballBounds) {
        ball.setBounds(ballBounds);
        repaint();
    }

    /**
     *  Gets BallComponent
     * @return this.ball
     */
    public BallComponent getBallComponent() {
        return this.ball;
    }

    /**
     * Gets ball.
     * @return View.BallComponent, value of ball
     */
    public BallComponent getBall() {
        return ball;
    }

    /**
     * Gets leftPaddle.
     * @return View.PaddleComponent, value of leftPaddle
     */
    public PaddleComponent getLeftPaddle() {
        return leftPaddle;
    }

    /**
     * Gets rightPaddle.
     * @return View.PaddleComponent, value of rightPaddle
     */
    public PaddleComponent getRightPaddle() {
        return rightPaddle;
    }

    /**
     * Gets scoreBoardP1.
     * @return javax.swing.JLabel, value of scoreBoardP1
     */
    public JLabel getScoreBoardP1() {
        return scoreBoardP1;
    }

    /**
     * Gets scoreBoardP2.
     * @return javax.swing.JLabel, value of scoreBoardP2
     */
    public JLabel getScoreBoardP2() {
        return scoreBoardP2;
    }

    /**
     * Gets net.
     * @return View.NetComponent, value of net
     */
    public NetComponent getNet() {
        return net;
    }

    /**
     * Gets space.
     * @return javax.swing.JLabel, value of space
     */
    public JLabel getSpace() {
        return space;
    }

    public JLabel getExit() {
        return exit;
    }

    /**
     * Method to set the score of either player
     * @param p char - input 'l' for the left player, 'r' for the right
     * @param i int - new score
     */
    public void setScore(char p, int i){
        // Left Paddle Player
        if (p == 'l') scoreBoardP1.setText(String.valueOf(i));
        // Right Paddle Player
        else scoreBoardP2.setText(String.valueOf(i));
    }
}