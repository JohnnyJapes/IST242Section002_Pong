package Model;

/**
 * File name: Model.java
 * Short description: Class to track player scores and write to XML, etc.
 * IST 242 Assignment: GUI Project
 * @author Luke Hanrahan & Brandon Orlando
 * @version 1.0 4/25/2023
 */
public class Model {

    /** Instance Variables */
    private Game Game;

    /** Pass in data to initialize variables */
    public Model() {
        Game = new Game();
    }

    public Game getGame() {
        return Game;
    }
}