package Visuals;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import java.awt.*;

public class FarmGUI extends JFrame {



    /* ----- ----- ----- FarmGUI Attributes ----- ----- ----- */
    private JLabel lblFarmer;

    // JButtons
    //private JButton btnAdd;
    //private JButton btnClear;
    //private JButton btnPrev;
    //private JButton btnNext;

    // JTextFields
    private JTextField tfName;

    // JTextAreas
    //private JTextArea taDesc;



    /* ----- ----- ----- FarmGUI Constructor ----- ----- ----- */

    public FarmGUI(int intRows, int intCols) {


        /* ----- Make JFrame / Window ----- */

        // Set the title
        super("My Farm");

        // Set the window background color
        getContentPane().setBackground(Color.decode("#366500"));

        // Set the window size
        setSize(1050, 700);

        // Prevent window resizing
        setResizable(false);

        // Set the default close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set the Layout
        setLayout(new BorderLayout());


        /* ----- Make Components in JFrame ----- */

        this.makeCenterPanel(intRows, intCols);
        this.makeNorthPanel();
        this.makeSouthPanel();
        this.makeEastPanel();


        /* ----- Set Visibility to True in the end ----- */

        setVisible(true);
    }

    public void makeEastPanel() {
        JPanel panelEast = new JPanel();
        panelEast.setLayout(new BorderLayout());
        panelEast.setBorder(BorderFactory.createEmptyBorder(1,100,1,1));
        add(panelEast, BorderLayout.EAST);
    }

    public void makeSouthPanel() {
        JPanel panelSouth = new JPanel();
        panelSouth.setLayout(new GridLayout(0,2));

        JPanel panelSouthWest = new JPanel(); {
            panelSouthWest.setBackground(Color.GREEN);
        }

        panelSouth.add(panelSouthWest, "West");
        add(panelSouth, BorderLayout.SOUTH);
    }

    public void makeNorthPanel() {

        JPanel panelNorth = new JPanel();

        panelNorth.setLayout(new BorderLayout());
        //panelNorth.setBorder(BorderFactory.createEmptyBorder(1,1,50,1));

        this.lblFarmer = new JLabel("Concio is Cringe");
        this.lblFarmer.setForeground(Color.WHITE);
        this.lblFarmer.setFont(new Font("Comic Sans MS", Font.BOLD, 30));

        /* ----- Add Components to locations ----- */

        // Add the JLabels to the JPanel

        // Add the JPanel to the JFrame
        JPanel panelNorthWest = new JPanel(); {
            //panelNorthWest.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.yellow, Color.black));
            panelNorthWest.setBorder(BorderFactory.createEmptyBorder(1,1,50,500));

            panelNorthWest.setBackground(Color.RED);
            panelNorthWest.setLayout(new FlowLayout());
        }

        panelNorthWest.add(this.lblFarmer);
        this.lblFarmer = new JLabel("Day 69");
        this.lblFarmer.setForeground(Color.BLACK);
        this.lblFarmer.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
        panelNorth.add(panelNorthWest, "West");

        panelNorth.setLayout(new GridBagLayout());
        panelNorth.add(this.lblFarmer, GridBagLayout.CENTER);
        panelNorth.setBackground(Color.PINK);
        add(panelNorth, BorderLayout.NORTH);
    }


    /* ----- ----- ----- GUI-Element Initialization Methods ----- ----- ----- */

    public void makeCenterPanel(int intRows, int intCols) {

        // Create a JPanel
        JPanel panelCenter = new JPanel();

        // Explicitly set the Layout
        panelCenter.setLayout(new GridLayout(intCols, intRows));
        panelCenter.setBackground(Color.GRAY);

        // Declare and initialize a 2D array of JButtons as Cropps
        JButton[][] arrbtnCrops = new JButton[intRows][intCols];

        for (int i = 0; i < intRows; i++) {
            for (int j = 0; j < intCols; j++) {

                // Create a new JButton
                arrbtnCrops[i][j] = new JButton("Concio is Cringe");
                arrbtnCrops[i][j].setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.black, Color.black));


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