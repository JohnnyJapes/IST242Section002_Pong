package Model;

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

    public Entity(){
        coordinates = new int[]{50, 50};
        size = new int[]{2,2};
        velocityX = 5;
        velocityY = 5;

    }

    public Entity(int[] coordinates, int velocityX, int velocityY, int[] size){
        this.coordinates = coordinates;
        this.velocityX = velocityX;
        this.velocityY = velocityY;
        this.size = size;
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
    }

    /**
     * Method to set y coordinate
     * @param y - int, set y coordinate
     */
    public void setYCoordinate(int y){
        coordinates[0] = y;
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

    // Additional methods -- such as for calculation, display

    public String toString() {
        // return data as a String
        return "";
    }

}


