package ca.nscc;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {

    //Constructor
    public MainWindow() {
        //Configure the window's properties
        this.setBounds(100, 100, 1200, 800);
        this.setResizable(true);
        this.setTitle("Screensaver");

        //Tell the 'X' button to actually close the window when clicked
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Instantiate DrawingPanel object
        DrawingPanel drawingPanel = new DrawingPanel(this.getWidth(), this.getHeight());
        drawingPanel.setBackground(Color.BLACK);
        // add this panel to the frame
        this.add(drawingPanel);
    }



}
