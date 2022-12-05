package Visuals;

import javax.swing.*;
import java.awt.*;

public class FarmGUI extends JFrame {



    /* ----- ----- ----- FarmGUI Attributes ----- ----- ----- */





    /* ----- ----- ----- FarmGUI Constructor ----- ----- ----- */

    public FarmGUI(int intRows, int intCols) {


        /* ----- Make JFrame / Window ----- */

        // Set the title
        super("My Farm");

        // Set the window background color
        getContentPane().setBackground(Color.decode("#366500"));

        // Set the window size
        setSize(700, 700);

        // Prevent window resizing
        setResizable(false);

        // Set the default close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set the Layout
        setLayout(new BorderLayout());


        /* ----- Make Components in JFrame ----- */

        this.makeCropGrid(intRows, intCols);


        /* ----- Set Visibility to True in the end ----- */

        setVisible(true);
    }





    /* ----- ----- ----- GUI-Element Initialization Methods ----- ----- ----- */

    public void makeCropGrid(int intRows, int intCols) {

        // Create a JPanel
        JPanel panelCenter = new JPanel();

        // Explicitly set the Layout
        panelCenter.setLayout(new GridLayout(intRows, intCols));



        // Declare and initialize a 2D array of JButtons as Cropps
        JButton[][] arrbtnCrops = new JButton[intRows][intCols];

        for (int i = 0; i < intRows; i++) {
            for (int j = 0; j < intCols; j++) {

                // Create a new JButton
                arrbtnCrops[i][j] = new JButton((i+1) + " x " + (j+1));

                // Set the background color
                arrbtnCrops[i][j].setBackground(Color.decode("#af7b50"));

                // Add the JButton to the JPanel
                panelCenter.add(arrbtnCrops[i][j]);
            }
        }


        // Add the JPanel to the JFrame
        add(panelCenter, BorderLayout.CENTER);
    }
}
