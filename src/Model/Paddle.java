package Model;
import java.awt.*;

/**
 * File name: Paddle.java
 * Short description: Class to create paddle object
 * IST 242 Assignment: GUI Project
 * @author Luke Hanrahan & Brandon Orlando
 * @version 1.0 4/25/2023
 */

public class Paddle extends Entity{
    /** Instance Variables */
    private int scoringNetPosition;

    /** Constructor */
    public Paddle() {
        super(new int[]{0, 350}, 0, 10, new int[]{20, 100});
        scoringNetPosition = 0;
    }


    /** Set Methods */

    /**
     * Method to set scoringNetPosition.
     * @param scoringNetPosition int - scoringNetPosition
     */
    public void setScoringNetPosition(int scoringNetPosition) {
        this.scoringNetPosition = scoringNetPosition;
    }

    /** Get Methods */

    /**
     * Gets scoringNetPosition.
     * @return int, value of scoringNetPosition
     */
    public int getScoringNetPosition() {
        return scoringNetPosition;
    }


    /** Move paddle based off of velocity then receives direction
     * @param direction
     */
    public void movePaddle(char direction){
        if (direction == 'U'){
            setYCoordinate(getYCoordinate() - getVelocityY());
            if (getYCoordinate() <= 0) setYCoordinate(0);
        }

        if (direction == 'D'){
            setYCoordinate(getYCoordinate() + getVelocityY());
            // 2nd index of size is y coordinate
            if (getYCoordinate() >= (800 - getBounds().height)) setYCoordinate(800 - getBounds().height);
        }
    }

    /** Handle collision with ball between paddles
     * @param ball
     * @return
     */
    public boolean collidesWith(Ball ball) {
        Rectangle paddleBounds = getBounds();
        Rectangle ballBounds = ball.getBounds();

        return paddleBounds.intersects(ballBounds);
    }
}