package View;
/*
 * Filename: View.java
 * Short description:
 * IST 242 Assignment:
 * @author Luke Hanrahan & Brandon Orlando
 * @version 1.0 3/2/23
 */


/**
 * @author Luke Hanrahan & Brandon Orlando
 * @version 1.0 1/26/23
 */
public class View {
    // Instance Variables -- define your private data


    private MainFrame mf;
    private GamePanel gp;
    // Constructors
    public View() {
        // initialize default values
        mf = new MainFrame();
    }

    public MainFrame getMf() {
        return mf;
    }

    public GamePanel getGp() {
        return gp;
    }

    public View(int data) // pass in data to initialize variables
    {
    }

    // Set methods - one set method for each instance variable defined above
    //             - purpose is to pass in a value stored in the private variable

    // Get methods - one get method for each instance variable defined above
    //             - purpose is to return the value stored in the private variable

    // Additional methods -- such as for calculation, display

    public String toString() {
        // return data as a String
        return "";
    }

}


