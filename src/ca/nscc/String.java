package ca.nscc;

import java.awt.*;

// declare a class String, which inherits Shape class properties
public class String extends Shape {

    // Constructor of String class
    public String(Color color, int xPosition, int yPosition, int width, int height) {

        //Assign parameter values to properties of the object (calls super's get/set methods)
        this.setShapeColor(color);
        this.setHeight(height);
        this.setWidth(width);
        this.setxPosition(xPosition);
        this.setyPosition(yPosition);
    }

    // Override the drawShape method of Shape class
    @Override
    public void drawShape(Graphics g) {

        // cast to Graphics2D object
        Graphics2D g2d = (Graphics2D) g;

        // get the color from parent and set the color for the shape
        Color mainColor = this.getShapeColor();
        g2d.setColor(mainColor);

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // display the string
        g2d.drawString("Screensaver", this.getxPosition(), this.getyPosition());

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
    }

    //Override moveShare method of Shape class
    @Override
    public void moveShape() {
        // move to the x and y coordinates as declared in parent class
        this.setxPosition(this.getxPosition() + this.getxSpeed());
        this.setyPosition(this.getyPosition() + this.getySpeed());
    }


}
