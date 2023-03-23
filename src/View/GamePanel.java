package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GamePanel extends JPanel implements ActionListener {

    JButton startGame;
    public GamePanel() {
        startGame = new JButton("Start");
        startGame.addActionListener(this);
        add(startGame);
        setBackground(Color.DARK_GRAY);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
