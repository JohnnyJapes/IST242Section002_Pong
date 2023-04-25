package Model;
import java.io.*;

/**
 * File name: Game.java
 * Short description: Class to create game object
 * IST 242 Assignment: GUI Project
 * @author Luke Hanrahan & Brandon Orlando
 * @version 1.0 4/25/2023
 */

public class Game {
    // Instance Variables -- define your private data
    private Ball ball;
    private Paddle leftPaddle, rightPaddle;
    private int p1Score, p2Score, highestScore, winScore;

    //no-arg constructor
    public Game() {
        // initialize default values
        ball = new Ball();
        leftPaddle = new Paddle();
        rightPaddle = new Paddle();
        p1Score = 0;
        p2Score = 0;
        winScore = 0;
        highestScore = 0;
        resetPositions();
    }

    // Checks if the ball goes off the screen and updates the score accordingly.

    /**
     * Method to check if the ball goes off screen and update scores accordingly
     * @return boolean - true if score happened, otherwise false
     */
    public boolean checkBallOffScreen() {
        //System.out.println("Checking ball");
        if (ball.getXCoordinate() < -20) {
            // Ball went off the left side, player two scores
            p2Score++;
            System.out.println("Player Two Score: " + p2Score);
            return true;
        } else if (ball.getXCoordinate() > 1200) {
            // Ball went off the right side, player one scores
            p1Score++;
            System.out.println("Player One Score: " + p1Score);
            return true;
        }
        return false;
    }

    public void resetPositions() {
        // Reset the ball to the center of the screen
        ball.setXCoordinate(600 - ball.getBounds().width/2);
        ball.setYCoordinate(400 - ball.getBounds().height/2);
        ball.setVelocityX(0);
        ball.setVelocityY(0);

        // Reset leftPaddle to its starting position
        leftPaddle.setXCoordinate(50);
        leftPaddle.setYCoordinate(350);

        // Reset rightPaddle to its starting position
        rightPaddle.setXCoordinate(1200 - rightPaddle.getBounds().width - 50);
        rightPaddle.setYCoordinate(350);
    }

    //clear the point totals of both players
    public void resetPoints() {

    }

    public void serveBall (){
        //resetPositions();
        // Reset the ball to the center of the screen
        ball.setXCoordinate(600 - ball.getBounds().width/2);
        ball.setYCoordinate(400 - ball.getBounds().height/2);
        ball.setVelocityX(0);
        ball.setVelocityY(0);
        int randomDirection = Math.random() < 0.5 ? -1 : 1; // Randomly choose left or right direction
        ball.setVelocityX(randomDirection * 5);
        ball.setVelocityY(Math.random() < 0.5 ? -5 : 5);
    }

    public void writeTextToFile(String p1, String space,String p2) {
        try {
            FileWriter writer = new FileWriter("Rally.txt");
            writer.write(p1);
            writer.write(space);
            writer.write(p2);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String readTextFromFile() throws IOException {
        File file = new File("Rally.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        StringBuilder stringBuilder = new StringBuilder();
        String scores;
        while ((scores = reader.readLine()) != null) {
            stringBuilder.append(scores);
            stringBuilder.append(System.lineSeparator());
        }
        reader.close();
        return stringBuilder.toString();
    }

    /**
     * Gets ball.
     *
     * @return Model.Ball, value of ball
     */
    public Ball getBall() {
        return ball;
    }

    /**
     * Gets leftPaddle.
     *
     * @return Model.Paddle, value of leftPaddle
     */
    public Paddle getLeftPaddle() {
        return leftPaddle;
    }

    /**
     * Gets rightPaddle.
     *
     * @return Model.Paddle, value of rightPaddle
     */
    public Paddle getRightPaddle() {
        return rightPaddle;
    }

    /**
     * Gets p1Score.
     *
     * @return int, value of p1Score
     */
    public int getP1Score() {
        return p1Score;
    }

    /**
     * Gets p2Score.
     *
     * @return int, value of p2Score
     */
    public int getP2Score() {
        return p2Score;
    }

    /**
     * Gets highestScore.
     *
     * @return int, value of highestScore
     */
    public int getHighestScore() {
        return highestScore;
    }

    /**
     * Gets winScore.
     *
     * @return int, value of winScore
     */
    public int getWinScore() {
        return winScore;
    }

    //Set Methods
    /**
     * Method to set ball.
     *
     * @param ball Model.Ball - ball
     */
    public void setBall(Ball ball) {
        this.ball = ball;
    }

    /**
     * Method to set leftPaddle.
     *
     * @param leftPaddle Model.Paddle - leftPaddle
     */
    public void setLeftPaddle(Paddle leftPaddle) {
        this.leftPaddle = leftPaddle;
    }

    /**
     * Method to set rightPaddle.
     *
     * @param rightPaddle Model.Paddle - rightPaddle
     */
    public void setRightPaddle(Paddle rightPaddle) {
        this.rightPaddle = rightPaddle;
    }

    /**
     * Method to set p1Score.
     *
     * @param p1Score int - p1Score
     */
    public void setP1Score(int p1Score) {
        this.p1Score = p1Score;
    }

    /**
     * Method to set p2Score.
     *
     * @param p2Score int - p2Score
     */
    public void setP2Score(int p2Score) {
        this.p2Score = p2Score;
    }

    /**
     * Method to set highestScore.
     *
     * @param highestScore int - highestScore
     */
    public void setHighestScore(int highestScore) {
        this.highestScore = highestScore;
    }

    /**
     * Method to set winScore.
     *
     * @param winScore int - winScore
     */
    public void setWinScore(int winScore) {
        this.winScore = winScore;
    }
}