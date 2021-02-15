package ca.nscc;

import java.awt.*;

// declare an abstract class Shape
public abstract class Shape {

    // declare variables
    private Color shapeColor;
    private int height;
    private int width;
    private int xPosition;
    private int yPosition;
    private int xSpeed = 10;  // specifying speed of x axis
    private int ySpeed = 5;    // specifying speed of y axis

    // declare setter and getter methods

    //region "Getters/Setters"
    public Color getShapeColor() {
        return shapeColor;
    }

    public void setShapeColor(Color shapeColor) {
        this.shapeColor = shapeColor;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getxPosition() {
        return xPosition;
    }

    public void setxPosition(int xPosition) {
        this.xPosition = xPosition;
    }

    public int getyPosition() {
        return yPosition;
    }

    public void setyPosition(int yPosition) {
        this.yPosition = yPosition;
    }

    public int getxSpeed() {
        return xSpeed;
    }

    public void setxSpeed(int xSpeed) {
        this.xSpeed = xSpeed;
    }

    public int getySpeed() {
        return ySpeed;
    }

    public void setySpeed(int ySpeed) {
        this.ySpeed = ySpeed;
    }
    //endregion

    // declare an abstract method drawShape, will be implemented by child class
    public abstract void drawShape(Graphics g);

    // declare an abstract method moveShape, will be implemented by child class
    public abstract void moveShape();

}
