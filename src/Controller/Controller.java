package Controller;
import View.View;
import Model.Model;
import Model.Paddle;
import Model.Ball;
import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.URL;
import java.util.HashSet;

/**
 * File name: Controller.java
 * Short description: Class to pass data throughout the game/app
 * IST 242 Assignment: GUI Project
 * @author Luke Hanrahan & Brandon Orlando
 * @version 1.4 4/27/2023
 */

public class Controller {
    /**
     * Instance Variables
     */
    private Model model;
    private View view;
    private boolean start;
    private Paddle leftPaddle;
    private Paddle rightPaddle;
    private Ball ball;
    private HashSet<Integer> currentKeys;
    private Clip clip;

    /**
     * Constructor for controller
     * @param m
     * @param v
     */
    public Controller(Model m, View v) {
        // Initialize default values
        model = m;
        view = v;
        leftPaddle = model.getGame().getLeftPaddle();
        rightPaddle = model.getGame().getRightPaddle();
        ball = model.getGame().getBall();
        currentKeys = new HashSet<>();
        loadScores();
        closeWindow();
        addMenuListeners();
        addKeyBindings();
        //create sound clip to call for later use
        try {
            URL url = getClass().getResource("../beep.wav");
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(url);
            clip = AudioSystem.getClip();
            clip.open(audioStream);
        }
        catch(Error| javax.sound.sampled.UnsupportedAudioFileException | java.io.IOException | javax.sound.sampled.LineUnavailableException err){
            System.out.println(err);
        }

        /**
         * Thread handles movement so main thread doesn't get locked up, enables both paddles to move at the same time
         */
        Thread pThread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("start pThread");
                while (true) {
                    if (!start) {
                        handleStart();
                    } else {
                        handleMovement();
                        moveBall();
                        if (model.getGame().checkBallOffScreen()) {
                            view.getGf().getPlayPanel().setScore('l', model.getGame().getP1Score());
                            view.getGf().getPlayPanel().setScore('r', model.getGame().getP2Score());
                            model.getGame().serveBall();
                            try {
                                Thread.sleep(0);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }
                        try {
                            Thread.sleep(16);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        });

        // Call Thread
        pThread.start();
    }

    /** Method that moves paddles based on the currentKeys HashSet */
    private void handleMovement(){
        // if [UP-ARROW]
        if (currentKeys.contains(38) && !currentKeys.contains(KeyEvent.VK_CONTROL)) {
            rightPaddle.setVelocityY(15);
            rightPaddle.movePaddle('U');
            view.getGf().getPlayPanel().loadRightPaddle(rightPaddle.getBounds().x,rightPaddle.getBounds().y, rightPaddle.getBounds().width, rightPaddle.getBounds().height);
        }
        if (currentKeys.contains(38) && currentKeys.contains(KeyEvent.VK_CONTROL)){
            rightPaddle.setVelocityY(7);
            rightPaddle.movePaddle('U');
            view.getGf().getPlayPanel().loadRightPaddle(rightPaddle.getBounds().x,rightPaddle.getBounds().y, rightPaddle.getBounds().width, rightPaddle.getBounds().height);
        }

        // if [DOWN-ARROW]
        if (currentKeys.contains(KeyEvent.VK_DOWN) && !currentKeys.contains(KeyEvent.VK_CONTROL)){
            rightPaddle.setVelocityY(15);
            rightPaddle.movePaddle('D');
            view.getGf().getPlayPanel().loadRightPaddle(rightPaddle.getBounds().x,rightPaddle.getBounds().y, rightPaddle.getBounds().width, rightPaddle.getBounds().height);
        }
        if (currentKeys.contains(KeyEvent.VK_DOWN) && currentKeys.contains(KeyEvent.VK_CONTROL)){
            rightPaddle.setVelocityY(7);
            rightPaddle.movePaddle('D');
            view.getGf().getPlayPanel().loadRightPaddle(rightPaddle.getBounds().x,rightPaddle.getBounds().y, rightPaddle.getBounds().width, rightPaddle.getBounds().height);
        }

        // if [W]
        if (currentKeys.contains(87) && !currentKeys.contains(KeyEvent.VK_SHIFT)){
            leftPaddle.setVelocityY(15);
            leftPaddle.movePaddle('U');
            view.getGf().getPlayPanel().loadLeftPaddle(leftPaddle.getBounds().x, leftPaddle.getBounds().y, leftPaddle.getBounds().width, leftPaddle.getBounds().height);
        }
        if (currentKeys.contains(87) && currentKeys.contains(KeyEvent.VK_SHIFT)){
            leftPaddle.setVelocityY(7);
            leftPaddle.movePaddle('U');
            view.getGf().getPlayPanel().loadLeftPaddle(leftPaddle.getBounds().x, leftPaddle.getBounds().y, leftPaddle.getBounds().width, leftPaddle.getBounds().height);
        }

        // if [S]
        if (currentKeys.contains(KeyEvent.VK_S) && !currentKeys.contains(KeyEvent.VK_SHIFT)){
            leftPaddle.movePaddle('D');
            view.getGf().getPlayPanel().loadLeftPaddle(leftPaddle.getBounds().x,leftPaddle.getBounds().y, leftPaddle.getBounds().width, leftPaddle.getBounds().height);
        }
        if (currentKeys.contains(KeyEvent.VK_S) && currentKeys.contains(KeyEvent.VK_SHIFT)){
            leftPaddle.setVelocityY(7);
            leftPaddle.movePaddle('D');
            view.getGf().getPlayPanel().loadLeftPaddle(leftPaddle.getBounds().x, leftPaddle.getBounds().y, leftPaddle.getBounds().width, leftPaddle.getBounds().height);
        }

        // if [E]
        if (currentKeys.contains(KeyEvent.VK_E)) {
            handleEnd();
        }
    }

    /** Method that handles all ball related movement */
    private void moveBall() {
        ball.move();

        // Check for collisions with left paddle
        if (leftPaddle.collidesWith(ball)) {
            playBeep();
            System.out.println("Left Paddle Collision");
            ball.bounceOffPaddle(leftPaddle);
        }

        // Check for collisions with right paddle
        if (rightPaddle.collidesWith(ball)) {
            playBeep();
            System.out.println("Right Paddle Collision");
            ball.bounceOffPaddle(rightPaddle);
        }
        view.getGf().getPlayPanel().loadBall(ball.getBounds());
    }

    /** Method that listens for the space bar to start the game */
    private void handleStart() {
        if (currentKeys.contains(KeyEvent.VK_SPACE)) {
            System.out.println("START GAME");
            model.getGame().resetPositions();
            model.getGame().serveBall();
            start = true;
            view.getGf().getPlayPanel().getSpace().setText("");
            view.getGf().getPlayPanel().getExit().setText("");
        }
    }

    /** Method that listens for the E to end the game and return to menu */
    private void handleEnd() {
        if (currentKeys.contains(KeyEvent.VK_E)) {
            currentKeys.remove(KeyEvent.VK_E);
            System.out.println("END GAME");
            model.getGame().writeTextToFile("Player 1: " + model.getGame().getP1Score(), "\n", "Player 2: " + model.getGame().getP2Score());
            start = false;
            model.getGame().resetPositions();
            view.getGf().activateMenuPanel();
            loadScores();
        }
    }

    /** Adds all listeners for menu buttons */
    private void addMenuListeners() {
        view.getGf().getmP().getStartButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.getGf().activatePlayPanel();
                view.getGf().getPlayPanel().getSpace().setText("PRESS [SPACE] TO START");
                view.getGf().getPlayPanel().getExit().setText("PRESS [E] TO RETURN TO MENU");
                model.getGame().resetPositions();
                view.getGf().getPlayPanel().loadRightPaddle(rightPaddle.getBounds().x,rightPaddle.getBounds().y, rightPaddle.getBounds().width, rightPaddle.getBounds().height);
                view.getGf().getPlayPanel().loadLeftPaddle(leftPaddle.getBounds().x, leftPaddle.getBounds().y, leftPaddle.getBounds().width, leftPaddle.getBounds().height);
            }
        });
        view.getGf().getmP().getResetButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.getGame().setP1Score(0);
                model.getGame().setP2Score(0);
                try {
                    model.getGame().writeTextToFile("Player 1: " + model.getGame().getP1Score(), "\n", "Player 2: " + model.getGame().getP2Score());
                    loadScores();
                } catch (Error ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }

    /** Method Add key bindings using addMotionBind */
    private void addKeyBindings(){
        addMotionBind("UP", KeyEvent.VK_UP);
        addMotionBind("DOWN", KeyEvent.VK_DOWN);
        addMotionBind("W", KeyEvent.VK_W);
        addMotionBind("S", KeyEvent.VK_S);
        addMotionBind("SPACE", KeyEvent.VK_SPACE);
        addMotionBind("E", KeyEvent.VK_E);
        addMotionBind("SHIFT", KeyEvent.VK_SHIFT);
        addMotionBind("CONTROL", KeyEvent.VK_CONTROL);
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

        // Catch key + shift
        view.getGf().getPlayPanel().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(keycode, KeyEvent.SHIFT_DOWN_MASK, false), pressed);
        view.getGf().getPlayPanel().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(keycode, KeyEvent.SHIFT_DOWN_MASK, true), released);

        // Catch key + control
        view.getGf().getPlayPanel().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(keycode, KeyEvent.CTRL_DOWN_MASK, false), pressed);
        view.getGf().getPlayPanel().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(keycode, KeyEvent.CTRL_DOWN_MASK, true), released);

        // Catch key + control + shift
        view.getGf().getPlayPanel().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(keycode, KeyEvent.CTRL_DOWN_MASK + KeyEvent.SHIFT_DOWN_MASK, false), pressed);
        view.getGf().getPlayPanel().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(keycode, KeyEvent.CTRL_DOWN_MASK + KeyEvent.SHIFT_DOWN_MASK, true), released);
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

    /** Method to add listener for closing the window. Save scores on exit */
    private void closeWindow (){
        view.getGf().setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        view.getGf().addWindowListener(new WindowAdapter() {
            /**
             * Invoked when a window is in the process of being closed.
             * The close operation can be overridden at this point.
             * @param e
             */
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                model.getGame().writeTextToFile("Player 1: " + model.getGame().getP1Score(), "\n", "Player 2: " + model.getGame().getP2Score());;
                System.exit(0);
            }
        });
    }

    /** Method to load scores from txt file */
    private void loadScores() {
        try {
            String input = model.getGame().readTextFromFile();
            System.out.println(input);
            String[] lines = input.split("\\r?\\n");
            String[] p1Tokens = lines[0].split(":");
            String[] p2Tokens = lines[1].split(":");
            int p1Score = Integer.parseInt(p1Tokens[1].trim());
            int p2Score = Integer.parseInt(p2Tokens[1].trim());
            model.getGame().setP1Score(p1Score);
            model.getGame().setP2Score(p2Score);
            // Updates view with scores
            view.getGf().getPlayPanel().setScore('l', p1Score);
            view.getGf().getPlayPanel().setScore('r', p2Score);
            view.getGf().getmP().getScores().setText("[P1] Left Paddle: " + p1Score + "                       " + "[P2] Right Paddle: " + p2Score);
        } catch (IOException | NumberFormatException ex) {
            System.out.println("error");
            System.out.println(ex);
            model.getGame().setP1Score(0);
            model.getGame().setP2Score(0);
            model.getGame().writeTextToFile("Player 1: " + model.getGame().getP1Score(), "\n", "Player 2: " + model.getGame().getP2Score());
            // Updates view with scores
            view.getGf().getPlayPanel().setScore('l', model.getGame().getP1Score());
            view.getGf().getPlayPanel().setScore('r', model.getGame().getP2Score());
            view.getGf().getmP().getScores().setText("Player 1: " + model.getGame().getP1Score() + ", " + "Player 2: " + model.getGame().getP2Score());
        }
    }

    /**
     * Method to play simple beep sound
     */
    public void playBeep(){
        try {
            if (clip.isRunning())
                clip.stop();   // Stop the player if it is still running
            clip.setFramePosition(0); // Rewind to the beginning
            clip.start();     // Start playing
        }
            catch(Error err){
            System.out.println(err);
        }
    }
}