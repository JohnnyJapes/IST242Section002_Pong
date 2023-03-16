package Model;/*
 * Filename: Game.java
 * Short description:
 * IST 242 Assignment:
 * @author Luke Hanrahan & Brandon Orlando
 * @version 1.0 3/2/23
 */


/**
 * @author Luke Hanrahan & Brandon Orlando
 * @version 1.0 3/2/23
 */
public class Game {
    // Instance Variables -- define your private data
    // Ball
    private Ball ball;

    private Paddle leftPaddle, rightPaddle;


    // Score of each player as well as the score needed to win the game with "highScore" being the overall highest score any has achieved

    int p1Score, p2Score, highestScore, winScore;


    // Instance Variables -- define your private data


    // Constructors
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


}