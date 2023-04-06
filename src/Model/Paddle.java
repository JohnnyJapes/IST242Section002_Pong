package Model;

/**
 * File name: Paddle.java
 * Short description: Class to create paddle object
 * IST 242 Assignment: GUI Project
 * @author Luke Hanrahan & Brandon Orlando
 * @version 1.0 3/27/23
 */

public class Paddle extends Entity{
    // Instance Variables -- define your private data

    private int scoringNetPosition;

    // Constructors
    public Paddle() {
        super(new int[]{0, 350}, 1, 5, new int[]{5, 100});

    }


    // pass in data to initialize variables
    public Paddle (int data) {
    }

    // Set methods - one set method for each instance variable defined above
    //             - purpose is to pass in a value stored in the private variable

    /**
     * Method to set scoringNetPosition.
     *
     * @param scoringNetPosition int - scoringNetPosition
     */
    public void setScoringNetPosition(int scoringNetPosition) {
        this.scoringNetPosition = scoringNetPosition;
    }

    // Get methods - one get method for each instance variable defined above
    //             - purpose is to return the value stored in the private variable

    /**
     * Gets scoringNetPosition.
     *
     * @return int, value of scoringNetPosition
     */
    public int getScoringNetPosition() {
        return scoringNetPosition;
    }

    // Additional methods -- such as for calculation, display

    /**
     *
     * @param direction
     */
    public void movePaddle(char direction){
        if (direction == 'U'){
            setYCoordinate(getYCoordinate() - getVelocityY());
            if (getYCoordinate() <= 0) setYCoordinate(0);
            System.out.println("New Y (Up): " + getYCoordinate());
        }

        if (direction == 'D'){
            setYCoordinate(getYCoordinate() + getVelocityY());
            //2nd index of size is y coordinate
            if (getYCoordinate() >= (770 - getSize()[1])) setYCoordinate(770 - getSize()[1]);

        }

        System.out.println("New Y (Down): " + getYCoordinate());
    }
    public String toString() {
        // return data as a String
        return "";
    }

}


