package Model;

/**
 * File name: Ball.java
 * Short description: Class to create ball object
 * IST 242 Assignment: GUI Project
 * @author Luke Hanrahan & Brandon Orlando
 * @version 1.0 3/27/23
 */

public class Ball extends Entity{
    // Instance Variables -- define your private data
    int[] lastKnownCoordinates;

    // Constructors
    public Ball() //no-arg constructor
    {
        super(new int[]{0, 50}, 10, 10, new int[]{10, 10});

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
    public void bounce(int[] field){

    }



    public String toString() {
        // return data as a String
        return "";
    }

}


