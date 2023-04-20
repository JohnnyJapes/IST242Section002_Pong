package View;

import Model.Paddle;

import java.awt.*;

/**
 * File name: View.java
 * Short description: View to contain frames & panels
 * IST 242 Assignment: GUI Project
 * @author Luke Hanrahan & Brandon Orlando
 * @version 1.0 3/27/23
 */

public class View {
    // Instance Variables -- define your private data
    private MainFrame mf;
    private GameFrame gf;
    private GamePanel gp;

    // Constructors
    public View() {
        //linux force opengl
        System.setProperty("sun.java2d.opengl", "true");
        // initialize default values
        //mf = new MainFrame();
        gf = new GameFrame();
    }

    public MainFrame getMf() {
        return mf;
    }

    public GameFrame getGf() {
        return gf;
    }


    // pass in data to initialize variables
    public View(int data) {
    }
}


