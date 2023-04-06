package Controller;
import View.View;
import Model.Model;
import Model.Paddle;
import Model.Ball;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Time;
import java.util.Collection;
import java.util.HashSet;

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
    private HashSet<Integer> currentKeys;

    private boolean game;

    // Constructors
    public Controller(Model m, View v) {
        // initialize default values
        model = m;
        view = v;
        leftPaddle = model.getGame().getLeftPaddle();
        rightPaddle = model.getGame().getRightPaddle();
        ball = model.getGame().getBall();
        currentKeys = new HashSet<>();
        game = true;
/*        BallController b = new BallController(model, view, ball);
        Thread ballThread = new Thread(b);
        ballThread.start();
        while (game){
            primaryLoop();
        }*/
        Thread pR = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    handleMovement();
                    try {
                        Thread.sleep(16);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
        pR.start();


        view.getGf().addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);

                // Check which key was pressed
                int key = e.getKeyCode();
                    System.out.println(key);

                // Move left paddle up when up W is pressed
                if (key == KeyEvent.VK_W) {
                    currentKeys.add(key);
                    System.out.println('U');
//                    leftPaddle.movePaddle('U');
//                    view.getGf().getPlayPanel().loadLeftPaddle(leftPaddle.getXCoordinate(),leftPaddle.getYCoordinate(), leftPaddle.getSize()[0], leftPaddle.getSize()[1]);
                }

                // Move left paddle down when S key is pressed
                if (key == KeyEvent.VK_S) {
                    currentKeys.add(key);
                    System.out.println('D');
//                    leftPaddle.movePaddle('D');
//                    view.getGf().getPlayPanel().loadLeftPaddle(leftPaddle.getXCoordinate(),leftPaddle.getYCoordinate(), leftPaddle.getSize()[0], leftPaddle.getSize()[1]);
                }

                // Move right paddle up when up arrow key is pressed
                if (key == KeyEvent.VK_UP) {
                    currentKeys.add(key);
                    System.out.println("Up Arrow Pressed");
//                    rightPaddle.movePaddle('U');
//                    view.getGf().getPlayPanel().loadRightPaddle(rightPaddle.getXCoordinate(),rightPaddle.getYCoordinate(), rightPaddle.getSize()[0], rightPaddle.getSize()[1]);
                }

                // Move right paddle down when down arrow key is pressed
                if (key == KeyEvent.VK_DOWN) {
                    currentKeys.add(key);
                    System.out.println('D');
//                    rightPaddle.movePaddle('D');
//                    view.getGf().getPlayPanel().loadRightPaddle(rightPaddle.getXCoordinate(),rightPaddle.getYCoordinate(), rightPaddle.getSize()[0], rightPaddle.getSize()[1]);
                }
            }
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                System.out.println("KEY");
            }

            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                currentKeys.remove(e.getKeyCode());
            }
        });
    }

    private void primaryLoop(){
        handleMovement();
        moveBall();
        checkScores();

    }
    private void handleMovement(){
        if (currentKeys.contains(38))
        {
            rightPaddle.movePaddle('U');
            view.getGf().getPlayPanel().loadRightPaddle(rightPaddle.getXCoordinate(),rightPaddle.getYCoordinate(), rightPaddle.getSize()[0], rightPaddle.getSize()[1]);

        }
        //add if statements for other keys
        if (currentKeys.contains(40)){
            rightPaddle.movePaddle('D');
            view.getGf().getPlayPanel().loadRightPaddle(rightPaddle.getXCoordinate(),rightPaddle.getYCoordinate(), rightPaddle.getSize()[0], rightPaddle.getSize()[1]);
        }
        if (currentKeys.contains(87)){
            leftPaddle.movePaddle('U');
            view.getGf().getPlayPanel().loadLeftPaddle(leftPaddle.getXCoordinate(),leftPaddle.getYCoordinate(), leftPaddle.getSize()[0], leftPaddle.getSize()[1]);
        }
        if (currentKeys.contains(KeyEvent.VK_S)){
            leftPaddle.movePaddle('D');
            view.getGf().getPlayPanel().loadLeftPaddle(leftPaddle.getXCoordinate(),leftPaddle.getYCoordinate(), leftPaddle.getSize()[0], leftPaddle.getSize()[1]);
        }
    }
    private void moveBall(){

    }
    private void checkScores(){

    }

}


