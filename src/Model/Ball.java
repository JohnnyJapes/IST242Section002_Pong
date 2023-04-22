package Model;

import View.PaddleComponent;

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
        super(new int[]{600, 400}, 5, 5, new int[]{20, 20});
    }

    // pass in data to initialize variables
    public Ball(int data) {
    }


    public void move() {
        // Update x and y coordinates based on current velocity
        int newX = getBounds().x + getVelocityX();
        int newY = getBounds().y + getVelocityY();

        // Check for collision with top or bottom of screen
        if (newY < 0 || newY + getBounds().height > 760) {
            // Reverse y direction and move ball back inside the screen
            setVelocityY(getVelocityY()*-1);
            if (newY < 0) {
                newY = 0;
            } else {
                System.out.println("bottom collision");
                newY = 760 - getBounds().height;
            }
        }
        setBounds(newX, newY, 20, 20);
    }

    public void bounceOffPaddle(Paddle paddle) {
        // Get the center of the paddle and the ball
        int paddleCenterX = paddle.getBounds().x + (paddle.getBounds().width / 2);
        int paddleCenterY = paddle.getBounds().y + (paddle.getBounds().height / 2);
        int ballCenterX = getBounds().x + (getBounds().width / 2);
        int ballCenterY = getBounds().y + (getBounds().height / 2);

        // Calculate the direction to bounce the ball
        int directionX = (ballCenterX < paddleCenterX) ? -1 : 1;
        int directionY = (ballCenterY < paddleCenterY) ? -1 : 1;

        // Calculate the new velocity of the ball
        int newVelocityX = getVelocityX() * directionX;
        int newVelocityY = getVelocityY() * directionY;

        // Update the ball's velocity
        setVelocityX(getVelocityX()*-1);
        setVelocityY(newVelocityY);
    }
}


