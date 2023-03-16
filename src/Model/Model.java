package Model;/*
 * Filename: Model.java
 * Short description:
 * IST 242 Assignment:
 * @author Luke Hanrahan & Brandon Orlando
 * @version 1.0 3/2/23
 */


/**
 * @author Luke Hanrahan & Brandon Orlando
 * @version 1.0 3/2/23
 */
public class Model {

    // Ball
    private Ball ball;

    // Height, Width, and fixed Speed of both players paddles

    int paddlesWidth, paddlesHeight, paddlesSpeed;

    // X & Y of each player's paddles

    int lpPaddleX, lpPaddleY, rpPaddleX, rpPaddleY;

    // Score of each player as well as the score needed to win the game with "highScore" being the overall highest score any has achieved

    int lpScore, rpScore, winScore, highestScore;


    // Instance Variables -- define your private data


    // Constructors
    //no-arg constructor
    public Model()  {
        // initialize default values
        ball = new Ball();
        paddlesWidth = 0;
        paddlesHeight = 0;
        paddlesSpeed = 0;
        lpPaddleX = 0;
        lpPaddleY = 0;
        rpPaddleX = 0;
        rpPaddleY = 0;
        lpScore = 0;
        rpScore = 0;
        winScore = 0;
        highestScore = 0;
    }
    // pass in data to initialize variables
    public Model(int data) {
    }

    // Set methods - one set method for each instance variable defined above
    //             - purpose is to pass in a value stored in the private variable

    // Get methods - one get method for each instance variable defined above
    //             - purpose is to return the value stored in the private variable

    // Additional methods -- such as for calculation, display

    public String toString() {
        // return data as a String
        return "";
    }

}


