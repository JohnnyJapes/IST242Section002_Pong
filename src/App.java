import Controller.Controller;
import Model.Model;
import View.View;

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
/usr/lib/jvm/jdk-17/bin/java -javaagent:/home/luke/ideajava/idea-IC-223.8214.52/lib/idea_rt.jar=46841:/home/luke/ideajava/idea-IC-223.8214.52/bin -Dfile.encoding=UTF-8 -classpath /home/luke/Documents/IST242/Assignments/IST242Section002_Pong/test/production/IST242Section002_Pong App
Player 1: 0
Player 2: 0

start pThread
Top Collision
Player Two Score: 1
Bottom Collision
Player Two Score: 2
Bottom Collision
Left Paddle Collision
Ball Center: 660
Paddle center: 650
old Velocity: 7.071068
New Velocity 7.821068
Percent X: 0.8
New VelocityX: 9
New VelocityY: 2

Bottom Collision
Right Paddle Collision
Ball Center: 690
Paddle center: 700
old Velocity: 9.219544
New Velocity 9.969544
Percent X: 0.8
New VelocityX: -11
New VelocityY: -3

Player Two Score: 3
Bottom Collision
Left Paddle Collision
Ball Center: 645
Paddle center: 700
old Velocity: 7.071068
New Velocity 7.821068
Percent X: 0.4
New VelocityX: 4
New VelocityY: -7

Top Collision
Bottom Collision
Right Paddle Collision
Ball Center: 328
Paddle center: 270
old Velocity: 8.062258
New Velocity 8.812258
Percent X: 0.4
New VelocityX: 5
New VelocityY: 7

Player One Score: 1
Bottom Collision
Player Two Score: 4

Process finished with exit code 0
 */
