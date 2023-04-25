package View;
import javax.swing.*;
import java.awt.*;

/**
 * File name: GameFrame.java
 * Short description: Frame to contain GamePanel
 * IST 242 Assignment: GUI Project
 * @author Luke Hanrahan & Brandon Orlando
 * @version 1.0 4/25/2023
 */

public class GameFrame extends JFrame {
    GamePanel playPanel;
    MenuPanel mP;
    public GameFrame () {
        super ("Pong");
        playPanel = new GamePanel();
        mP = new MenuPanel();
        add(mP);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setSize(1200, 800);
        playPanel.setPreferredSize(new Dimension(1200, 800));
        mP.setPreferredSize(new Dimension(1200, 800));
        setResizable(false);
        setVisible(true);
        pack();
    }

    /**
     * Gets playPanel.
     *
     * @return GamePanel, value of playPanel
     */
    public GamePanel getPlayPanel() {
        return playPanel;
    }

    /**
     * Gets mP.
     *
     * @return MenuPanel, value of mP
     */
    public MenuPanel getmP() {
        return mP;
    }

    public void activatePlayPanel(){
        getContentPane().removeAll();
        invalidate();
        add(playPanel);
        revalidate();
        repaint();
    }
}
