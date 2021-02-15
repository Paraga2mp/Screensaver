package ca.nscc;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;


import javax.swing.*;

public class DrawingPanel extends JPanel {

    // declare the timer object by specifying delay
    private Timer timer = new Timer(100, new TimerAction());
    private int speedModifier = 0;

    //Make an array of random colors.
    Color[] colors = new Color[] {Color.RED, Color.GREEN, Color.MAGENTA, Color.YELLOW, Color.ORANGE,Color.BLUE,
                                    Color.WHITE, Color.CYAN, Color.PINK};

    //Array to hold shape objects
    private ArrayList<Shape> shapes;
    // Create a random class object
    Random rand = new Random();

    // constructor, get its panel size
    public DrawingPanel(int pWidth, int pHeight) {
        // set dimensions
        this.setBounds(0,0,pWidth, pHeight);

        shapes = new ArrayList<Shape>();

      // define mouse listener
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // get the x and y coordinate of mouse click
                int mouseX = e.getX();
                int mouseY = e.getY();
                int randomNumber;
                randomNumber = rand.nextInt((4-0)+1);

                // add random shape to the shapes array
                if(randomNumber == 1) {
                    shapes.add(new Circle(getRandomColor(), mouseX, mouseY, getRandomWidth(), getRandomHeight()));
                }
                else if(randomNumber == 2){
                    shapes.add(new Rectangle(getRandomColor(), mouseX, mouseY, getRandomWidth(), getRandomHeight()));
                }
                else if(randomNumber == 3){
                    shapes.add(new String(getRandomColor(), mouseX, mouseY, getRandomWidth(), getRandomHeight()));
                }
                else if(randomNumber == 4){
                    shapes.add(new Butterfly(getRandomColor(), mouseX, mouseY, getRandomWidth(), getRandomHeight()));
                }
                // starts timer object
                timer.start();
                repaint();
            }
        });
    }

    //Get a random color from array.
    private Color getRandomColor() {
        Random rand = new Random();
        return colors[rand.nextInt(colors.length)];
    }
    //Get a random width
    private int getRandomWidth() {
        Random rand = new Random();
        return rand.nextInt(50) + 20;
    }
    //Get a random height
    private int getRandomHeight() {
        Random rand = new Random();
        return rand.nextInt(50) + 20;
    }

    @Override
    public void paintComponent(Graphics g) {
        // Ask the parent JPanel to redraw
        super.paintComponent(g);

                if(timer.isRunning()) {
                    // if timer is running, draw the shapes
                    for (Shape sha : shapes) {
                        sha.drawShape(g);
                    }
                }
    }


    // declare moveAllShapes method
    public void moveAllShapes() {

        for (Shape sh: shapes) {
            sh.moveShape();

            // detect collision
            collisionDetection();

            // check each shape to see if it hit a wall
            checkForWallHit(sh);
        }

        // After the move, tell the panel to repaint
        this.repaint();
    }

    // declare collisionDetect method
    public void collisionDetection(){

        for(int i = 0; i < shapes.size() - 1; i++){
            Shape getShape1 = shapes.get(i);

            // Create a rectangle object the same location and of same size of an array object
            java.awt.Rectangle rect1 = new java.awt.Rectangle(getShape1.getxPosition(), getShape1.getyPosition(),
                    getShape1.getWidth(), getShape1.getHeight());

            for(int j = i+1; j < shapes.size(); j++) {
                Shape getShape2 = shapes.get(j);

                // Create a rectangle object the same location of same size of next array object
                java.awt.Rectangle rect2 = new java.awt.Rectangle(getShape2.getxPosition(), getShape2.getyPosition(),
                        getShape2.getWidth(), getShape2.getHeight());
                // Compare and if these objects intersect, swap the color
                if (rect1.intersects(rect2)) {

                    Color tempColor = getShape1.getShapeColor();
                    getShape1.setShapeColor(getShape2.getShapeColor());
                    getShape2.setShapeColor(tempColor);
                }
            }
        }
    }

    // declare checkForWallHit method
    public void checkForWallHit(Shape currShape) {
        // Check each shape's x and y position and compare with panel's x and y coordinates
        if ((currShape.getxPosition() + currShape.getWidth()) >= this.getWidth() ||
                (currShape.getyPosition() + currShape.getHeight()) >= this.getHeight() ) {
            //if true, multiply by -1 to reverse the direction
            currShape.setxSpeed(currShape.getxSpeed() * -1);
            currShape.setySpeed(currShape.getySpeed() * -1);
        }
        // if the shape hits the left edge
        else if (currShape.getxPosition() < 0 ) {
            //reverse the direction
            currShape.setxSpeed(currShape.getxSpeed() * -1);
        }
        // if the shape hits the y edge
        else if (currShape.getyPosition() < 0 ) {
            // reverse the direction
            currShape.setySpeed(currShape.getySpeed() * -1);
        }
    }

    private class TimerAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            //Whenever the timer fires a tick event, moveAllShapes() method is called.
            moveAllShapes();
        }
    }

}
