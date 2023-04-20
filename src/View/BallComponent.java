package View;
import javax.swing.*;
import java.awt.*;

public class BallComponent extends JComponent {
    private int x, y, width, height;
    private int velocityX, velocityY;


    public BallComponent(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.velocityX = 5;
        this.velocityY = 5;
        //setBounds(x,y, width, height);
    }

    public void setAll(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        //setBounds(x,y, width, height);
    }

    public void setVelocity(int velocityX, int velocityY) {
        this.velocityX = velocityX;
        this.velocityY = velocityY;
    }



    public void move() {
        // Update x and y coordinates based on current velocity
        x += velocityX;
        y += velocityY;


        // TEMPORARY CODE TO TEST PADDLES MAKING BALL BOUNCE EVERYWHERE
        // Check for collision with left or right side of screen
        if (x < 0 || x + width > getParent().getWidth()) {
            // Reverse x direction and move ball back inside the screen
            velocityX *= -1;
            if (x < 0) {
                x = 0;
            } else {
                x = getParent().getWidth() - width;
            }
        }

        // Check for collision with top or bottom of screen
        if (y < 0 || y + height > getParent().getHeight()) {
            // Reverse y direction and move ball back inside the screen
            velocityY *= -1;
            if (y < 0) {
                y = 0;
            } else {
                y = getParent().getHeight() - height;
            }
        }
        setBounds(x, y, 20, 20);
    }

    public void bounceOffPaddle(PaddleComponent paddle) {
        // Get the center of the paddle and the ball
        int paddleCenterX = paddle.getX() + (paddle.getWidth() / 2);
        int paddleCenterY = paddle.getY() + (paddle.getHeight() / 2);
        int ballCenterX = x + (width / 2);
        int ballCenterY = y + (height / 2);

        // Calculate the distance between the centers of the paddle and the ball
        int dx = Math.abs(ballCenterX - paddleCenterX);
        int dy = Math.abs(ballCenterY - paddleCenterY);

        // If the ball is too far away from the paddle, do nothing
        if (dx > (paddle.getWidth() / 2 + width / 2) || dy > (paddle.getHeight() / 2 + height / 2)) {
            return;
        }

        // Calculate the direction to bounce the ball
        int directionX = (ballCenterX < paddleCenterX) ? -1 : 1;
        int directionY = (ballCenterY < paddleCenterY) ? -1 : 1;

        // Calculate the angle to bounce the ball (based on the distance from the center of the paddle)
        int angleX = dx * 45 / (paddle.getWidth() / 2);
        int angleY = dy * 45 / (paddle.getHeight() / 2);

        // Calculate the new velocity of the ball
        int newVelocityX = (int) (velocityX * Math.cos(Math.toRadians(angleX)) * directionX);
        int newVelocityY = (int) (velocityY * Math.sin(Math.toRadians(angleY)) * directionY);

        // Update the ball's velocity
        setVelocity(newVelocityX, -newVelocityY);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void paintComponent(Graphics g) {
        g.setColor(Color.white);
        //System.out.println(x);
        g.fillRect(0, 0, width, height);
    }
}
