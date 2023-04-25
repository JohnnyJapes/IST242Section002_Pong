import Controller.Controller;
import Model.Model;
import View.View;
import View.MainFrame;

/**
 * File name: App.java
 * Short description: Basic MVC
 * IST 242 Assignment: GUI Project
 * @author Luke Hanrahan & Brandon Orlando
 * @version 1.0 4/25/2023
 */

public class App {
//Main method of application
public static void main(String[] args) {
        //Program Description

        //code for this assignment
        Model model = new Model();
        View view = new View();
        Controller controller = new Controller(model,view);
        // MainFrame mFrame = new MainFrame();
        }
}
