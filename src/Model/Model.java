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

    public Object getGame() {
        return Game;
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


