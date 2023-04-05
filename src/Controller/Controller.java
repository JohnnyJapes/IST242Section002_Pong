package Controller;
import View.View;
import Model.Model;
import Model.Paddle;
import Model.Ball;

import java.awt.event.KeyAdapter;
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

    private Ball ball;

    // Constructors
    public Controller(Model m, View v) {
        // initialize default values
        model = m;
        view = v;
        leftPaddle = model.getGame().getLeftPaddle();
        rightPaddle = model.getGame().getRightPaddle();
        ball = model.getGame().getBall();

        view.getGf().addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);

                // Check which key was pressed
                int key = e.getKeyCode();
                    System.out.println(key);

                // Move left paddle up when up W is pressed
                if (key == KeyEvent.VK_W) {
                    leftPaddle.movePaddle('U');
                    System.out.println('U');
                    view.getGf().getPlayPanel().loadLeftPaddle(leftPaddle.getXCoordinate(),leftPaddle.getYCoordinate(), leftPaddle.getSize()[0], leftPaddle.getSize()[1]);
                }

                // Move left paddle down when S key is pressed
                if (key == KeyEvent.VK_S) {
                    leftPaddle.movePaddle('D');
                    System.out.println('D');
                    view.getGf().getPlayPanel().loadLeftPaddle(leftPaddle.getXCoordinate(),leftPaddle.getYCoordinate(), leftPaddle.getSize()[0], leftPaddle.getSize()[1]);
                }

                // Move right paddle down when down arrow key is pressed
                if (key == KeyEvent.VK_UP) {
                    rightPaddle.movePaddle('U');
                    System.out.println('U');
                    view.getGf().getPlayPanel().loadRightPaddle(rightPaddle.getXCoordinate(),rightPaddle.getYCoordinate(), rightPaddle.getSize()[0], rightPaddle.getSize()[1]);
                }

                // Move right paddle down when down arrow key is pressed
                if (key == KeyEvent.VK_DOWN) {
                    rightPaddle.movePaddle('D');
                    System.out.println('D');
                    view.getGf().getPlayPanel().loadRightPaddle(rightPaddle.getXCoordinate(),rightPaddle.getYCoordinate(), rightPaddle.getSize()[0], rightPaddle.getSize()[1]);
                }
            }
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                System.out.println("KEY");
            }
        });
    }
}


