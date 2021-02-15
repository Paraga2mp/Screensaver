package ca.nscc;

import java.awt.*;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;

public class Butterfly extends Shape {

    // constructor
    public Butterfly(Color color, int xPosition, int yPosition, int width, int height) {
        //Assign parameter values to properties of the object (calls super's get/set methods)
        this.setShapeColor(color);
        this.setHeight(height);
        this.setWidth(width);
        this.setxPosition(xPosition);
        this.setyPosition(yPosition);
    }

    // Override the drawShape method of parent class
    @Override
    public void drawShape(Graphics g) {

        // cast to the Graphics2D object
        Graphics2D g2d = (Graphics2D) g;

        Color mainColor = this.getShapeColor();

        // Create an object of General path
        GeneralPath path = new GeneralPath();

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // draw the butterfly shape
        path.moveTo(this.getxPosition(), this.getyPosition());
        path.lineTo(this.getxPosition()+40, this.getyPosition());
        path.lineTo(this.getxPosition(), this.getyPosition()+40);
        path.lineTo(this.getxPosition()-30, this.getyPosition()-10);
        path.lineTo(this.getxPosition()-20, this.getyPosition()+40);
        g2d.fill(path);

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
    }

    // Override the moveShape method of parent class
    @Override
    public void moveShape() {
        // move to the x and y coordinates as declared in parent class
        this.setxPosition(this.getxPosition() + this.getxSpeed());
        this.setyPosition(this.getyPosition() + this.getySpeed());
    }

}
