package View;


import javax.swing.*;

public class GameFrame extends JFrame {
    GamePanel playPanel;
    public GameFrame () {
        super ("Pong");
        playPanel = new GamePanel();
        add(playPanel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize (1200, 800);
        setResizable(false);
        setVisible(true);
    }
//-------------------------------------------------------------------
}
