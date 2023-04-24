package View;
import javax.swing.*;
import java.awt.*;

/**
 * File name: GamePanel.java
 * Short description: Panel to display Pong game
 * IST 242 Assignment: GUI Project
 * @author Luke Hanrahan & Brandon Orlando
 * @version 1.5 4/24/23
 */

public class GamePanel extends JPanel {

    //private JButton startGame;
    private BallComponent ball;
    private PaddleComponent leftPaddle;
    private PaddleComponent rightPaddle;
    private JLabel scoreBoardP1, scoreBoardP2;
    private NetComponent net;

    public GamePanel() {
        //startGame = new JButton("Start");
        //startGame.addActionListener(this);
        //add(startGame);
        scoreBoardP1 = new JLabel("0");
        scoreBoardP1.setBounds(505, 5, 90, 40);
        scoreBoardP1.setForeground(Color.white);
        scoreBoardP1.setFont(new Font(Font.SERIF, Font.BOLD, 50));
        scoreBoardP1.setHorizontalAlignment(SwingConstants.CENTER);

        scoreBoardP2 = new JLabel("0");
        scoreBoardP2.setBounds(605, 5, 90, 40);
        scoreBoardP2.setForeground(Color.white);
        scoreBoardP2.setFont(new Font(Font.SERIF, Font.BOLD, 50));
        scoreBoardP2.setHorizontalAlignment(SwingConstants.CENTER);

        net = new NetComponent();
        setLayout(null);
        setSize(1200, 800);
        setBackground(Color.darkGray);
        ball = new BallComponent(600,400,20,20);
        leftPaddle = new PaddleComponent(0,0,20,100);
        rightPaddle = new PaddleComponent(0,0,20,100);
        add(ball);
        add(leftPaddle);
        add(rightPaddle);
        add(scoreBoardP1);
        add(scoreBoardP2);
        add(net);
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

    /**
     * Gets ball.
     *
     * @return View.BallComponent, value of ball
     */
    public BallComponent getBall() {
        return ball;
    }

    /**
     * Gets leftPaddle.
     *
     * @return View.PaddleComponent, value of leftPaddle
     */
    public PaddleComponent getLeftPaddle() {
        return leftPaddle;
    }

    /**
     * Gets rightPaddle.
     *
     * @return View.PaddleComponent, value of rightPaddle
     */
    public PaddleComponent getRightPaddle() {
        return rightPaddle;
    }

    /**
     * Gets scoreBoardP1.
     *
     * @return javax.swing.JLabel, value of scoreBoardP1
     */
    public JLabel getScoreBoardP1() {
        return scoreBoardP1;
    }

    /**
     * Gets scoreBoardP2.
     *
     * @return javax.swing.JLabel, value of scoreBoardP2
     */
    public JLabel getScoreBoardP2() {
        return scoreBoardP2;
    }

    /**
     * Gets net.
     *
     * @return View.NetComponent, value of net
     */
    public NetComponent getNet() {
        return net;
    }

    //set score

    /**
     * Method to set the score of either player
     * @param p char - input 'l' for the left player, 'r' for the right
     * @param i int - new score
     */
    public void setScore(char p, int i){
        if (p == 'l') scoreBoardP1.setText(String.valueOf(i));
        else scoreBoardP2.setText(String.valueOf(i));
    }
}
