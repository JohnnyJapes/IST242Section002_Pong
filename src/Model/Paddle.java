package Model;/*
 * Filename: Model.java
 * Short description:
 * IST 242 Assignment:
 * @author Luke Hanrahan & Brandon Orlando
 * @version 1.0 3/2/23
 */


/**
 * @author Luke Hanrahan & Brandon Orlando
 * @version 1.0 1/26/23
 */
public class Paddle extends Entity{
    // Instance Variables -- define your private data
    int height, width;

    // Constructors
    public Paddle() //no-arg constructor
    {
        super(new int[]{0, 50}, 10);
        height = 40;
        width = 10;
    }

    public Paddle(int data) // pass in data to initialize variables
    {
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


