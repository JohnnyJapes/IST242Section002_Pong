
/*
 * Filename: Controller.java
 * Short description:
 * IST 242 Assignment:
 * @author Luke Hanrahan & Brandon Orlando
 * @version 1.0 3/2/23
 */
package Controller;
import View.View;
import Model.Model;
/**
 * @author Luke Hanrahan & Brandon Orlando
 * @version 1.0 1/26/23
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


