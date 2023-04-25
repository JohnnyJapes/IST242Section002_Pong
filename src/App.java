import Controller.Controller;
import Model.Model;
import View.View;
import View.MainFrame;

/**
 * File name: App.java
 * Short description: Basic MVC
 * IST 242 Assignment: GUI Project
 * @author Luke Hanrahan & Brandon Orlando
 * @version 1.0 4/25/2023
 */

public class App {
//Main method of application
public static void main(String[] args) {
        //Program Description

        //code for this assignment
        Model model = new Model();
        View view = new View();
        Controller controller = new Controller(model,view);
        // MainFrame mFrame = new MainFrame();
        }
}

/* Output
start pThread
Left Paddle Collision
Ball Center: 140
Paddle center: 140
old Velocity: 7.071068
New Velocity 7.821068
Percent X: 1.0
New VelocityX: 11
New VelocityY: 0

Right Paddle Collision
Ball Center: 140
Paddle center: 170
old Velocity: 11.0
New Velocity 11.75
Percent X: 0.4
New VelocityX: -7
New VelocityY: -10

bottom collision
Player Two Score: 1
bottom collision
Left Paddle Collision
Ball Center: 660
Paddle center: 670
old Velocity: 7.071068
New Velocity 7.821068
Percent X: 0.8
New VelocityX: 9
New VelocityY: -2

Right Paddle Collision
Ball Center: 428
Paddle center: 440
old Velocity: 9.219544
New Velocity 9.969544
Percent X: 0.76
New VelocityX: -11
New VelocityY: -3

Left Paddle Collision
Ball Center: 143
Paddle center: 190
old Velocity: 11.401754
New Velocity 12.151754
Percent X: 0.4
New VelocityX: 7
New VelocityY: -10

bottom collision
Player One Score: 1
bottom collision
Left Paddle Collision
Ball Center: 660
Paddle center: 640
old Velocity: 7.071068
New Velocity 7.821068
Percent X: 0.6
New VelocityX: 7
New VelocityY: 4

bottom collision
Player One Score: 2

Process finished with exit code 0
 */
