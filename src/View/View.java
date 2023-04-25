package View;

/**
 * File name: View.java
 * Short description: View to contain frames & panels
 * IST 242 Assignment: GUI Project
 * @author Luke Hanrahan & Brandon Orlando
 * @version 1.0 4/25/2023
 */

public class View {
    // Instance Variables -- define your private data
    private GameFrame gf;

    // Constructors
    public View() {
        //linux force opengl
        System.setProperty("sun.java2d.opengl", "true");
        // initialize default values
        //mf = new MainFrame();
        gf = new GameFrame();
    }


    /**
     * Get GameFrame
     * @return GameFrame
     */
    public GameFrame getGf() {
        return gf;
    }


}


