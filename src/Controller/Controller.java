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
        while(!start) System.out.println("wait");
        addKeyBindings();
        serveBall();

        /*
        BallController b = new BallController(model, view, ball);
        Thread ballThread = new Thread(b);
        ballThread.start();
        while (game){
        primaryLoop();
        }*/

        Thread pThread = new Thread(new Runnable() { //thread handles movement so main thread doesn't get locked up, enables both paddles to move at the same time
            @Override
            public void run() {
                System.out.println("start pThread");
                while (true) {
                    handleMovement();
                    try {
                        Thread.sleep(16);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
        Thread bThread = new Thread(new Runnable() { //thread handles ball so main thread doesn't get locked up
            @Override
            public void run() {
                System.out.println("Start moveBall thread");
                while (true) {
                    moveBall();
                    try {
                        Thread.sleep(16);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
        pThread.start();
        bThread.start();
    }

    private void primaryLoop(){
        handleMovement();
        moveBall();
        checkScores();
    }
    private void handleMovement(){
        if (currentKeys.contains(38)) {
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

    public void serveBall() {
        ball.setCoordinates(new int[]{600, 400});
        int randomDirection = Math.random() < 0.5 ? -1 : 1; // Randomly choose left or right direction
        ball.setVelocityX(randomDirection * ball.getVelocityX());
        ball.setVelocityY(Math.random() < 0.5 ? -1 : 1);
    }

    private void moveBall() {
        int moveResult = ball.moveBall(leftPaddle, rightPaddle);
        view.getGf().getPlayPanel().loadBall(ball.getXCoordinate(), ball.getYCoordinate(), ballComponent.getWidth(), ballComponent.getHeight());
        if (moveResult > 0 ){
            serveBall();
            System.out.println("Ball Served");
        }
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


