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
    private GamePanel gp;

    private Paddle leftPaddle;
    private Paddle rightPaddle;
    // Constructors
    public View() {
        // initialize default values
        mf = new MainFrame();
    }

    public MainFrame getMf() {
        return mf;
    }

    public GamePanel getGp() {
        return gp;
    }


    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw left paddle

        if () {
            g.fillRect(leftPaddle.getX(), leftPaddle.getY(), leftPaddle.getWidth(), leftPaddle.getHeight());
        }

        // Draw right paddle
        else {
            g.fillRect(rightPaddle.getX(), rightPaddle.getY(), rightPaddle.getWidth(), rightPaddle.getHeight());
        }
    }


    // pass in data to initialize variables
    public View(int data) {
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


