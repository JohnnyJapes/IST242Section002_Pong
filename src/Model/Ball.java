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
    public Ball() //no-arg constructor
    {
        super(new int[]{600, 400}, 5, 5, new int[]{10, 10});

    }

    public Ball(int data) // pass in data to initialize variables
    {
    }

    // Set methods - one set method for each instance variable defined above
    //             - purpose is to pass in a value stored in the private variable

    @Override
    public void setCoordinates(int[] coordinates) {
        lastKnownCoordinates = getCoordinates();
        super.setCoordinates(coordinates);
    }


    // Get methods - one get method for each instance variable defined above
    //             - purpose is to return the value stored in the private variable

    // Additional methods -- such as for calculation, display

    //bounce/rebound logic placeholder, should set next location
    public void bounce(Paddle pad, int x, int y, char hit){

    }

    /**
     * Method to handle ball movement, takes paddles as parameters to keep track of their location
     * @param left - Paddle object, left paddle
     * @param right - Paddle object, right paddle
     * @return int - 0 no score, 1 - left boundary hit, 2 - right boundary hit
     */
    public int moveBall(Paddle left, Paddle right){

        int newX = getXCoordinate() + getVelocityX();
        int newY = getYCoordinate() + getVelocityY();
        boolean vertWalls = false;
        boolean score = false;
        boolean hitPaddleX = false;
        boolean hitPaddleY = false;
        char hit = 'N';
        int hitX = 0;
        int hitY = 0;

        if (newY > 1 && newY < 800 )
        {
            vertWalls = false;

        }

        //if (newX > left.getScoringNetPosition() && newX < right.getScoringNetPosition())
        if (newX > 100 && newX < 1100)
        {
            score = false;
        }
        else score = true;
        //check for right paddle x collision
        for (int i = 1; i <= getVelocityX(); i++)
        {
            int tempX = getXCoordinate() + i;
            if (tempX >  right.getXCoordinate() && tempX < right.getXCoordinate() + right.getSize()[0]) {
                hitPaddleX = true;
                hit = 'R';
                hitX = tempX;
            };
        }
        //check for right paddle y collision
        for (int i = 1; i <= getVelocityY(); i++)
        {
            int tempY = getYCoordinate() + i;
            if (tempY >  right.getYCoordinate() && tempY < right.getYCoordinate() + right.getSize()[1]) {
                hitPaddleY = true;
                hit = 'R';
                hitY = tempY;
            };
        }

        if (hitPaddleX && hitPaddleY) bounce(right, hitX, hitY, hit);
        if (vertWalls) bounce(left, hitX, hitY, 'T');

        if (score) return 1;

        if (!vertWalls && !score)
        {
            setYCoordinate(newY);
            setXCoordinate(newX);
            //System.out.println("move");
        }





        return 0;

    }



    public String toString() {
        // return data as a String
        return "";
    }

}


