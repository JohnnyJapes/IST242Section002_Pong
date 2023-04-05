package Model;

/**
 * File name: Model.java
 * Short description: Class to track player scores and write to XML, etc.
 * IST 242 Assignment: GUI Project
 * @author Luke Hanrahan & Brandon Orlando
 * @version 1.0 3/27/23
 */
public class Model {

    private Game Game;

    // pass in data to initialize variables
    public Model() {
        Game = new Game();
    }

    public Game getGame() {
        return Game;
    }

    public String toString() {
        // return data as a String
        return "";
    }
}


