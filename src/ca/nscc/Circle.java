package ca.nscc;

import java.awt.*;

// declare a class Class which inherits Shape class properties
public class Circle extends Shape {

    // constructor of Circle class
    public Circle(Color color, int xPosition, int yPosition, int width, int height) {

        //Assign parameter values to properties of the object (calls super's get/set methods)
        this.setShapeColor(color);
        this.setHeight(height);
        this.setWidth(width);
        this.setxPosition(xPosition);
        this.setyPosition(yPosition);
    }

    // Override drawShape method
    @Override
    public void drawShape(Graphics g) {

        // cast to Graphics2D object
        Graphics2D g2d = (Graphics2D) g;

        // get the color from parent
        Color mainColor = this.getShapeColor();

        // set the ReminderingHint Off
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);


        // define the gradientpaint object
        GradientPaint grad = new GradientPaint(this.getxPosition(), this.getyPosition(), mainColor,
                this.getxPosition()+50, this.getyPosition()+50, mainColor);
        g2d.setPaint(grad);


        // draw the circle
        g2d.fillOval(getxPosition(), getyPosition(), getWidth(), getHeight());

        // set the ReminderingHint Off
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    }

    // Override the moveShape method
    @Override
    public void moveShape() {

        // move to the x and y coordinate as declared in parent class
        this.setxPosition(this.getxPosition() + this.getxSpeed());
        this.setyPosition(this.getyPosition() + this.getySpeed());

    }
}
