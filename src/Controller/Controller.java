package Controller;
import View.View;
import Model.Model;
import Model.Paddle;
import java.awt.event.KeyEvent;

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
    private Paddle leftPaddle;
    private Paddle rightPaddle;

    // Constructors
    public Controller(Model m, View v) {
        // initialize default values
        model = m;
        view = v;
        leftPaddle = model.getGame().getLeftPaddle();
        rightPaddle = model.getGame().getRightPaddle();
    }

    public void keyPressed(KeyEvent e) {
        // Check which key was pressed
        int key = e.getKeyCode();

        // Move left paddle up when up arrow key is pressed
        if (key == KeyEvent.VK_UP) {
            leftPaddle.movePaddle('U');
            view.getGp().paintPaddle(leftPaddle.getXCoordinate(),leftPaddle.getYCoordinate(), leftPaddle.getSize()[0], leftPaddle.getSize()[1]);
        }

        // Move left paddle down when down arrow key is pressed
        if (key == KeyEvent.VK_DOWN) {
            leftPaddle.movePaddle('D');
            view.getGp().paintPaddle(leftPaddle.getXCoordinate(),leftPaddle.getYCoordinate(), leftPaddle.getSize()[0], leftPaddle.getSize()[1]);

        }

        // Move right paddle up when W key is pressed
        if (key == KeyEvent.VK_W) {
            rightPaddle.movePaddle('U');
            view.getGp().paintPaddle(rightPaddle.getXCoordinate(),rightPaddle.getYCoordinate(), rightPaddle.getSize()[0], rightPaddle.getSize()[1]);

        }

        // Move right paddle down when S key is pressed
        if (key == KeyEvent.VK_S) {
            rightPaddle.movePaddle('D');
            view.getGp().paintPaddle(rightPaddle.getXCoordinate(),rightPaddle.getYCoordinate(), rightPaddle.getSize()[0], rightPaddle.getSize()[1]);
        }
    }


    public String toString() {
        // return data as a String
        return "";
    }
}


