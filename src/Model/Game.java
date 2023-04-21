package Model;

/**
 * File name: Game.java
 * Short description: Class to create game object
 * IST 242 Assignment: GUI Project
 * @author Luke Hanrahan & Brandon Orlando
 * @version 1.0 3/27/23
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
    }

    // Checks if the ball goes off the screen and updates the score accordingly.
    public void checkBallOffScreen() {
        System.out.println("Checking ball");
        if (ball.getXCoordinate() < 0) {
            // Ball went off the left side, player two scores
            p2Score++;
            System.out.println("Player Two Score: " + p2Score);
            //resetPositions();
        } else if (ball.getXCoordinate() > 1200) {
            // Ball went off the right side, player one scores
            p1Score++;
            System.out.println("Player One Score: " + p1Score);
            //resetPositions();
        }
    }

    public void resetPositions() {
        // Reset the ball to the center of the screen
        ball.setXCoordinate(600 - ball.getSize()[0]/2);
        ball.setYCoordinate(400 - ball.getSize()[1]/2);
        ball.setVelocityX(0);
        ball.setVelocityY(0);

        // Reset leftPaddle to its starting position
        leftPaddle.setXCoordinate(50);
        leftPaddle.setYCoordinate(350);

        // Reset rightPaddle to its starting position
        rightPaddle.setXCoordinate(1200 - rightPaddle.getSize()[0] - 50);
        rightPaddle.setYCoordinate(350);
    }

    //clear the point totals of both players
    public void resetPoints() {

    }

    //get methods

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