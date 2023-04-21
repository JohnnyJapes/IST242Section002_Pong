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
        int paddleCenterX = paddle.getBounds().x + (paddle.getWidth() / 2);
        int paddleCenterY = paddle.getBounds().y + (paddle.getHeight() / 2);
        int ballCenterX = x + (width / 2);
        int ballCenterY = y + (height / 2);

        // Calculate the direction to bounce the ball
        int directionX = (ballCenterX < paddleCenterX) ? -1 : 1;
        int directionY = (ballCenterY < paddleCenterY) ? -1 : 1;

        // Calculate the new velocity of the ball
        int newVelocityX = velocityX * directionX;
        int newVelocityY = velocityY * directionY;

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
        g.fillRect(0, 0, width, height);
    }
}
