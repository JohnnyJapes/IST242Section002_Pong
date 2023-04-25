package Model;
import java.awt.*;

/**
 * File name: Entity.java
 * Short description: Abstract class to manage entities (position, speed, etc.)
 * IST 242 Assignment: GUI Project
 * @author Luke Hanrahan & Brandon Orlando
 * @version 1.3 4/25/2023
 */

public abstract class Entity {
    // Instance Variables -- define your private data
    private int velocityX;
    private int velocityY;

    private Rectangle bounds;

    public Entity(){
        velocityX = 5;
        velocityY = 5;
        bounds = new Rectangle(50,50, 20, 20);

    }

    public Entity(int[] coordinates, int velocityX, int velocityY, int[] size){
        this.velocityX = velocityX;
        this.velocityY = velocityY;
        bounds = new Rectangle(coordinates[0], coordinates[1], size[0], size[1]);
    }

    /**
     * Alternate constructor
     * @param x int - x position
     * @param y int - y position
     * @param w int - width of entity
     * @param h int - height of entity
     * @param vX int - velocity on x-axis
     * @param vY int - velocity on y-axis
     */
    public Entity(int x, int y, int w, int h, int vX, int vY){
        this.velocityX = vX;
        this.velocityY = vY;
        bounds = new Rectangle(x, y, w, h);
    }

    // Set methods - one set method for each instance variable defined above
    //             - purpose is to pass in a value stored in the private variable



    /**
     * Method to set coordinates of entity.
     *
     * @param coordinates int[] - coordinates
     */
    public void setCoordinates(int[] coordinates) {
        bounds.x = coordinates[0];
        bounds.y = coordinates[1];
    }

    /**
     * Method to set x coordinate
     * @param x - int, set x coordinate
     */
    public void setXCoordinate(int x){
        bounds.x = x;
    }

    /**
     * Method to set y coordinate
     * @param y - int, set y coordinate
     */
    public void setYCoordinate(int y){
        bounds.y = y;
    }
    /**
     * Method to set velocity of the x axis.
     *
     * @param velocity float - velocity
     */
    public void setVelocityX(int velocity) {
        this.velocityX = velocity;
    }

    /**
     * Method to set velocity of the y axis.
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
        bounds.width = size[0];
        bounds.height = size[1];
    }

    /**
     * Method to set bounds, a Rectangle object
     *
     * @param bounds java.awt.Rectangle - bounds
     */
    public void setBounds(Rectangle bounds) {
        this.bounds = bounds;
    }

    /**
     * Alternate method to set bounds of the entity
     * @param x int - x coordinate
     * @param y int - y coordinate
     * @param w int - width of entity
     * @param h int - height of entity
     */
    public void setBounds(int x, int y, int w, int h) {
        Rectangle rect = new Rectangle(x, y, w, h);
        this.bounds = rect;
    }
    // Get methods - one get method for each instance variable defined above
    //             - purpose is to return the value stored in the private variable

    /**
     * Method to return x coordinate
     * @return int - x coordinate
     */
    public int getXCoordinate() {
        return bounds.x;
    }
    /**
     * Method to return Y coordinate
     * @return int - Y coordinate
     */
    public int getYCoordinate() {
        return bounds.y;
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
     * Gets bounds.
     *
     * @return java.awt.Rectangle, value of bounds
     */
    public Rectangle getBounds() {
        return bounds;
    }

    /**
     * Method to return width of the entity
     * @return int - width
     */
    public int getWidth(){
        return bounds.width;
    }

    /**
     * Method to return height of the entity
     * @return int - height
     */
    public int getHeight(){
        return bounds.height;
    }
    // Additional methods -- such as for calculation, display

    public String toString() {
        // return data as a String
        return "";
    }

}


