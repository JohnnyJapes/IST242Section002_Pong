package Model;

/**
 * File name: Ball.java
 * Short description: Class to create ball object
 * IST 242 Assignment: GUI Project
 * @author Luke Hanrahan & Brandon Orlando
 * @version 1.0 3/27/23
 */

public class Ball extends Entity {
    // Instance Variables -- define your private data
    private int[] lastKnownCoordinates;

    // Constructors
    public Ball() {
        super(new int[]{600, 400}, 5, 5, new int[]{10, 10});
    }

    // pass in data to initialize variables
    public Ball(int data) {
    }
}


