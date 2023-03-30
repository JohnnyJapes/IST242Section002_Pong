package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * File name: GamePanel.java
 * Short description: Panel to display Pong game
 * IST 242 Assignment: GUI Project
 * @author Luke Hanrahan & Brandon Orlando
 * @version 1.0 3/27/23
 */

public class GamePanel extends JPanel implements ActionListener {




    private JButton startGame;
    private PaddleComponent lP;
    public GamePanel() {
        //startGame = new JButton("Start");
        //startGame.addActionListener(this);
        //add(startGame);
        setLayout(null);
        setBackground(Color.white);
        lP = new PaddleComponent(00,0,20,100);
        Insets insets = getInsets();
        add(lP);
        lP.setBounds(0, 00, 1200, 800);
        repaint();

        //repaint();
    }

    public void loadPaddle(int x, int y, int w, int h){
        lP.setAll(x,y,w,h);
        //lP.setBounds(x, y, w, h);
        repaint();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }


    public void paintPaddle(int x, int y, int width, int height) {
        //super.paintComponent(g);
        //g.fillRect(x, y, width, height);
    }

}
