package Controller;
import View.View;
import Model.Model;
import Model.Paddle;
import Model.Ball;
import View.BallComponent;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    private boolean start;
    private Paddle leftPaddle;
    private Paddle rightPaddle;

    private Ball ball;
    private HashSet<Integer> currentKeys;

    private BallComponent ballComponent;

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
        ballComponent = view.getGf().getPlayPanel().getBallComponent();
        addMenuListeners();
        while(!start) System.out.println("");
        addKeyBindings();



        // Thread handles movement so main thread doesn't get locked up, enables both paddles to move at the same time
        Thread pThread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("start pThread");
                while (true) {
                    handleMovement();
                    moveBall();
                    model.getGame().checkBallOffScreen();
                    view.getGf().getPlayPanel().setScore('l', model.getGame().getP1Score());
                    view.getGf().getPlayPanel().setScore('r', model.getGame().getP2Score());
                    try {
                        Thread.sleep(16);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });

        // Thread handles ball so main thread doesn't get locked up
        Thread bThread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Start moveBall thread");
                while (true) {

                    try {
                        Thread.sleep(16);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
        pThread.start();
        //bThread.start();
        model.getGame().resetPositions();
        model.getGame().serveBall();
    }

    private void primaryLoop(){
        handleMovement();
        moveBall();
        checkScores();
    }
    private void handleMovement(){
        if (currentKeys.contains(38)) {
            rightPaddle.movePaddle('U');
            view.getGf().getPlayPanel().loadRightPaddle(rightPaddle.getBounds().x,rightPaddle.getBounds().y, rightPaddle.getBounds().width, rightPaddle.getBounds().height);
        }
        //add if statements for other keys
        if (currentKeys.contains(40)){
            rightPaddle.movePaddle('D');
            view.getGf().getPlayPanel().loadRightPaddle(rightPaddle.getBounds().x,rightPaddle.getBounds().y, rightPaddle.getBounds().width, rightPaddle.getBounds().height);
        }
        if (currentKeys.contains(87)){
            leftPaddle.movePaddle('U');
            view.getGf().getPlayPanel().loadLeftPaddle(leftPaddle.getBounds().x, leftPaddle.getBounds().y, leftPaddle.getBounds().width, leftPaddle.getBounds().height);
        }
        if (currentKeys.contains(KeyEvent.VK_S)){
            leftPaddle.movePaddle('D');
            view.getGf().getPlayPanel().loadLeftPaddle(leftPaddle.getBounds().x,leftPaddle.getBounds().y, leftPaddle.getBounds().width, leftPaddle.getBounds().height);
        }
    }



    private void moveBall() {
        ball.move();

        // Check for collisions with left paddle
        if (leftPaddle.collidesWith(ball)) {
            System.out.println("Left Paddle Collision");
            ball.bounceOffPaddle(leftPaddle);
            System.out.println(" ");
        }

        // Check for collisions with right paddle
        if (rightPaddle.collidesWith(ball)) {
            System.out.println("Right Paddle Collision");
            ball.bounceOffPaddle(rightPaddle);
            System.out.println(" ");
        }
        view.getGf().getPlayPanel().loadBall(ball.getBounds());
    }
    private void checkScores() {

    }

    private void addMenuListeners() {
        view.getGf().getmP().getStartButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.getGf().activatePlayPanel();
                start = true;
            }
        });

    }

    private void addKeyBindings(){
        addMotionBind("UP", KeyEvent.VK_UP);
        addMotionBind("DOWN", KeyEvent.VK_DOWN);
        addMotionBind("W", KeyEvent.VK_W);
        addMotionBind("S", KeyEvent.VK_S);
    }

    /**
     * Method that adds Keybinds to input/action map
     * @param keyName String - name of the desired key
     * @param keycode int - the keycode of the desired key
     */
    private void addMotionBind(String keyName, int keycode){
        String pressed = "pressed " + keyName;
        String released = "released " + keyName;
        view.getGf().getPlayPanel().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(pressed), pressed);
        view.getGf().getPlayPanel().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(released), released);
        view.getGf().getPlayPanel().getActionMap().put(pressed, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentKeys.add(keycode);
            }
        });
        view.getGf().getPlayPanel().getActionMap().put(released, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentKeys.remove(keycode);
            }
        });
    }
}


