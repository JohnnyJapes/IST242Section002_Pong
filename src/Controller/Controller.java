package Controller;
import View.View;
import Model.Model;

/**
 * File name: Controller.java
 * Short description: Class to pass data throughout the game/app
 * IST 242 Assignment: GUI Project
 * @author Luke Hanrahan & Brandon Orlando
 * @version 1.0 3/27/23
 */

public class Controller {
    // Instance Variables -- define your private data
    private Model model;
    private View view;
    // Constructors
    public Controller(Model m, View v) {
        // initialize default values
        model = m;
        view = v;
    }
    public String toString() {
        // return data as a String
        return "";
    }
}


