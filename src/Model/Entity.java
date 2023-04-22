package Model;

import java.awt.*;

/**
 * File name: Entity.java
 * Short description: Abstract class to manage entities (position, speed, etc.)
 * IST 242 Assignment: GUI Project
 * @author Luke Hanrahan & Brandon Orlando
 * @version 1.0 3/27/23
 */

public abstract class Entity {
    // Instance Variables -- define your private data
    private int[] coordinates;
    private int velocityX;
    private int velocityY;
    private int[] size;

    private Rectangle bounds;

    public Entity(){
        coordinates = new int[]{50, 50};
        size = new int[]{2,2};
        velocityX = 5;
        velocityY = 5;
        bounds = new Rectangle(50,50, 20, 20);

    }

    public Entity(int[] coordinates, int velocityX, int velocityY, int[] size){
        this.coordinates = coordinates;
        this.velocityX = velocityX;
        this.velocityY = velocityY;
        this.size = size;
        bounds = new Rectangle(coordinates[0], coordinates[1], size[0], size[1]);
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
     * Method to set x coordinate
     * @param x - int, set x coordinate
     */
    public void setXCoordinate(int x){
        coordinates[0] = x;
        bounds.x = x;
    }

    /**
     * Method to set y coordinate
     * @param y - int, set y coordinate
     */
    public void setYCoordinate(int y){
        coordinates[1] = y;
        bounds.y = y;
    }
    /**
     * Method to set velocity.
     *
     * @param velocity float - velocity
     */
    public void setVelocityX(int velocity) {
        this.velocityX = velocity;
    }

    /**
     * Method to set velocityY.
     *
     * @param velocityY float - velocityY
     */
    public void setVelocityY(int velocityY) {
        this.velocityY = velocityY;
    }

    /**
     * Method to set size.
     *
     * @param size int[] - size
     */
    public void setSize(int[] size) {
        this.size = size;
        bounds.width = size[0];
        bounds.height = size[1];
    }

    /**
     * Method to set bounds.
     *
     * @param bounds java.awt.Rectangle - bounds
     */
    public void setBounds(Rectangle bounds) {
        this.bounds = bounds;
    }

    public void setBounds(int x, int y, int w, int h) {
        Rectangle rect = new Rectangle(x, y, w, h);
        this.bounds = rect;
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
     * Method to return x coordinate
     * @return int - x coordinate
     */
    public int getXCoordinate() {
        return coordinates[0];
    }
    /**
     * Method to return Y coordinate
     * @return int - Y coordinate
     */
    public int getYCoordinate() {
        return coordinates[1];
    }

    /**
     * Gets velocity.
     *
     * @return float, value of velocity
     */
    public int getVelocityX() {
        return velocityX;
    }

    /**
     * Gets velocityY.
     *
     * @return float, value of velocityY
     */
    public int getVelocityY() {
        return velocityY;
    }

    /**
     * Gets size.
     *
     * @return int[], value of size
     */
    public int[] getSize() {
        return size;
    }

    /**
     * Gets bounds.
     *
     * @return java.awt.Rectangle, value of bounds
     */
    public Rectangle getBounds() {
        return bounds;
    }
    // Additional methods -- such as for calculation, display

    public String toString() {
        // return data as a String
        return "";
    }

}


