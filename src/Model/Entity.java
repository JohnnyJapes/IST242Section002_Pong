package Model;

/*
 * File name: Entity.java
 * Short description: Entity class, abstract super class
 * IST 242 Assignment: GUI Project
 *
 * @author Luke Hanrahan & Brandon Orlando
 * @version 1.0 3/2/23
 */


import java.sql.Array;

/**
 * @author Luke Hanrahan & Brandon Orlando
 * @version 1.0 3/2/23
 */
public abstract class Entity {
    // Instance Variables -- define your private data
    private int[] coordinates;
    private float velocity;

    public Entity(){
        coordinates = new int[]{50, 50};
        velocity = 5;

    }

    public Entity(int[] coordinates, float velocity){
        this.coordinates = coordinates;
        this.velocity = velocity;
    }

    // Set methods - one set method for each instance variable defined above
    //             - purpose is to pass in a value stored in the private variable

    public int[] getCoordinates() {
        return coordinates;
    }

    // Get methods - one get method for each instance variable defined above
    //             - purpose is to return the value stored in the private variable

    // Additional methods -- such as for calculation, display

    public String toString() {
        // return data as a String
        return "";
    }

}


