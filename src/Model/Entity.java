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
    private float velocityX, velocityY;
    private int[] size;

    public Entity(){
        coordinates = new int[]{50, 50};
        size = new int[]{2,2};
        velocityX = 5;
        velocityY = 5;

    }

    public Entity(int[] coordinates, float velocityX, float velocityY){
        this.coordinates = coordinates;
        this.velocityX = velocityX;
        this.velocityY = velocityY;
    }

    // Set methods - one set method for each instance variable defined above
    //             - purpose is to pass in a value stored in the private variable



    /**
     * Method to set coordinates.
     *
     * @param coordinates int[] - coordinates
     */
    public void setCoordinates(int[] coordinates) {
        this.coordinates = coordinates;
    }

    /**
     * Method to set velocity.
     *
     * @param velocity float - velocity
     */
    public void setVelocityX(float velocity) {
        this.velocityX = velocity;
    }

    /**
     * Method to set velocityY.
     *
     * @param velocityY float - velocityY
     */
    public void setVelocityY(float velocityY) {
        this.velocityY = velocityY;
    }

    // Get methods - one get method for each instance variable defined above
    //             - purpose is to return the value stored in the private variable

    /**
     * Gets coordinates.
     *
     * @return int[], value of coordinates
     */
    public int[] getCoordinates() {
        return coordinates;
    }

    /**
     * Gets velocity.
     *
     * @return float, value of velocity
     */
    public float getVelocityX() {
        return velocityX;
    }

    /**
     * Gets velocityY.
     *
     * @return float, value of velocityY
     */
    public float getVelocityY() {
        return velocityY;
    }

    // Additional methods -- such as for calculation, display

    public String toString() {
        // return data as a String
        return "";
    }

}


