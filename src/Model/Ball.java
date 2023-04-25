package Model;

/**
 * File name: Ball.java
 * Short description: Class to create ball object
 * IST 242 Assignment: GUI Project
 * @author Luke Hanrahan & Brandon Orlando
 * @version 1.4 4/25/2023
 */

public class Ball extends Entity {
    // Instance Variables -- define your private data

    // Constructors
    public Ball() {
        super(new int[]{600, 400}, 5, 5, new int[]{20, 20});
    }

    // pass in data to initialize variables
    public Ball(int data) {
    }


    /**
     * Method to move the ball and simultaneously check for collisions with the top and bottom walls
     */
    public void move() {
        // Update x and y coordinates based on current velocity
        int newX = getBounds().x + getVelocityX();
        int newY = getBounds().y + getVelocityY();

        // Check for collision with top or bottom of screen
        if (newY < 0 || newY + getBounds().height > 800) {
            // Reverse y direction and move ball back inside the screen
            setVelocityY(getVelocityY()*-1);
            if (newY < 0) {
                newY = 0;
            } else {
                System.out.println("bottom collision");
                newY = 800 - getHeight();
            }
        }
        setBounds(newX, newY, getWidth(), getHeight());
    }

    /**
     * Method to calculate the new velocity and position of the ball when paddle collision happens
     * @param paddle Paddle - the paddle that was collided with
     */
    public void bounceOffPaddle(Paddle paddle) {
        // Get the center of the paddle and the ball
        int paddleCenterX = paddle.getXCoordinate() + (paddle.getWidth() / 2);
        int paddleCenterY = paddle.getYCoordinate() + (paddle.getHeight() / 2);
        int ballCenterX = getXCoordinate()+ (getWidth() / 2);
        int ballCenterY = getYCoordinate() + (getHeight() / 2);


        // Calculate the direction to bounce the ball
        int directionX = (ballCenterX < paddleCenterX) ? -1 : 1;
        int directionY = (ballCenterY < paddleCenterY) ? -1 : 1;
        System.out.println("Ball Center: " +ballCenterY);
        System.out.println("Paddle center: "+paddleCenterY);



        //find the true velocity of the ball
        float velocity = (float)Math.sqrt(squared(getVelocityX()) + squared(getVelocityY()));
        System.out.println("old Velocity: " +velocity);
        //increase the velocity of the ball so it slowly increases in speed
        velocity += 0.75;
        System.out.println("New Velocity "+velocity);

        // Calculate the new velocity of the ball
        int newVelocityX;  //(Math.abs(getVelocityX())+1) * directionX;
        int newVelocityY; //getVelocityY() * directionY;

        //math to find percentage of new velocity that should be x-axis
        float percentX = (float)(
                ((paddle.getHeight()/2.0) - Math.abs(ballCenterY-paddleCenterY))
                /(paddle.getHeight()/2.0)
        );
        //force positive percentage
        percentX = Math.abs(percentX);
        //enforce a minimum of 40% of the velocity be along the x-axis
        if (percentX < 0.4) percentX = (float)0.4;
        System.out.println("Percent X: "+ percentX);

        //math to determine the exact values for x and y velocity
        double v = (velocity/Math.sqrt(2)) *2.0;

        int possibleX = (int)Math.round(v*percentX);

        newVelocityX = possibleX;
        newVelocityY = (int)Math.round(v - newVelocityX);
        //flip directions based on center values
        newVelocityX *= directionX;
        newVelocityY*= directionY;

        // Update the ball's velocity
        setVelocityX(newVelocityX);
        setVelocityY(newVelocityY);
        System.out.println("New VelocityX: " + getVelocityX());
        System.out.println("New VelocityY: " + getVelocityY());
        //move ball outside of paddle before continuing
        if (directionX > 0) setXCoordinate(paddle.getXCoordinate()+paddle.getBounds().width);
        else setXCoordinate(paddle.getXCoordinate() -1 - getBounds().width);
    }

    /**
     * Method to square a given integer
     * @param i int
     * @return int - i to the power of 2
     */
    public int squared(int i){
        return i*i;
    }
}


