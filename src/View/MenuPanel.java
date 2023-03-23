package View;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.event.*;

public class MenuPanel extends JPanel implements ActionListener {
        JButton startButton, quitButton;
        JLabel title;
        public MenuPanel() {
            startButton = new JButton("Play Pong");
            startButton.addActionListener(e -> new GameFrame());
            startButton.setLocation(100, 100);
            startButton.setBounds(100, 100, 100, 100);
            add(startButton);
            quitButton = new JButton("Exit");
            quitButton.addActionListener(e -> System.exit(0));
            add(quitButton);
            title = new JLabel("Welcome To Pong!");
            add(title);
        }

    @Override
    public void actionPerformed(ActionEvent e) {


        }
    }

