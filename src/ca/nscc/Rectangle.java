package ca.nscc;

import java.awt.*;

public class Rectangle extends Shape {

    public Rectangle(Color color, int xPosition, int yPosition, int width, int height) {

        //Assign param values to properties of the object (calls super's get/set methods)
        this.setShapeColor(color);
        this.setHeight(height);
        this.setWidth(width);
        this.setxPosition(xPosition);
        this.setyPosition(yPosition);
    }

    // Override the drawShape method
    @Override
    public void drawShape(Graphics g) {

        // cast graphics object to Graphics2D object
        Graphics2D g2d = (Graphics2D) g;

        //Get the color from parent and set the color for the shape
        Color mainColor = this.getShapeColor();
        g2d.setColor(mainColor);

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // declare the gradient paint object and draw the rectangle
        GradientPaint gradient = new GradientPaint(this.getxPosition(), this.getyPosition(), mainColor, this.getWidth(),
                this.getHeight(), Color.BLACK);
        g2d.setPaint(gradient);
        g2d.fill3DRect(this.getxPosition(), this.getyPosition(), this.getWidth(), this.getHeight(), true);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
    }

    // Override the moveShape method
    @Override
    public void moveShape() {
        // move to the x and y coordinate as values declared in in parent class
        this.setxPosition(this.getxPosition() + this.getxSpeed());
        this.setyPosition(this.getyPosition() + this.getySpeed());

    }
}
