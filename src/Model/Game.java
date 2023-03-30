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
    // Ball
    private Ball ball;

    private Paddle leftPaddle, rightPaddle;


    // Score of each player as well as the score needed to win the game with "highScore" being the overall highest score any has achieved

    int p1Score, p2Score, highestScore, winScore;
    //Playing field size, [x,y]
    int[] fieldSize;

    // Instance Variables -- define your private data


    // Constructors
    //no-arg constructor
    public Game() {
        // initialize default values
        ball = new Ball();
        leftPaddle = new Paddle();
        rightPaddle = new Paddle();
        fieldSize = new int[]{1200, 800};
        p1Score = 0;
        p2Score = 0;
        winScore = 0;
        highestScore = 0;
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

    /**
     * Gets fieldSize.
     *
     * @return int[], value of size
     */
    public int[] getFieldSize() {
        return fieldSize;
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

    /**
     * Method to set fieldSize.
     *
     * @param size int[] - size
     */
    public void setFieldSize(int[] size) {
        this.fieldSize = size;
    }


    //Methods for Game logic

    public void updatePaddlePosition(int player, char direction) { //handles paddle movement when called by Controller
        Paddle pad;
        switch(player){
            case 1: pad = leftPaddle;
            case 2: pad = rightPaddle;
            default: pad = leftPaddle;
        }
        pad.movePaddle(direction);
    };

    public void updateBallPosition(){} //handles tracking of balls next movement

    public void addPoint(int player) {} //add point to selected player

    public void resetPoints() {} //clear the point totals of both players
}