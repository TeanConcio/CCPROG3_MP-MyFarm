package Visuals;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class FarmGUI extends JFrame {


    /* ----- ----- ----- FarmGUI Attributes ----- ----- ----- */

    int intRows;
    int intCols;


    // JPanels

        // Farmer Information
    private JLabel lblFarmerName = new JLabel("");
    private JLabel lblFarmerLevel = new JLabel("");
    private JLabel lblObjectCoins = new JLabel("");
    private JLabel lblFarmerTitle = new JLabel("");

        // Day Number
    private JLabel lblDayNum = new JLabel("");

        // Tile Details
    private JLabel lblTileStatus = new JLabel("");
    private JLabel lblTilePlant = new JLabel("");
    private JLabel lblTilePlantAge = new JLabel("");
    private JLabel lblTimesWatered = new JLabel("");
    private JLabel lblTimesFertilized = new JLabel("");


    // JButtons

        // Crop Grid
    private JButton[][] arrbtnCrops;

        // Farmer Actions
    private JButton btnRegister = new JButton("Register");

        // Tile Actions
    private JButton btnPlow = new JButton("Plow");
    private JButton btnWater = new JButton("Water");
    private JButton btnFertilize = new JButton("Fertilize");
    private JButton btnPickaxe = new JButton("Pickaxe");
    private JButton btnShovel = new JButton("Shovel");
    private JButton btnPlant = new JButton("Plant");
    private JButton btnHarvest = new JButton("Harvest");

        // Advance Day
    private JButton btnProceedDay = new JButton("Proceed Day");


    // JTextArea
    private JTextArea taLog = new JTextArea(5, 80);


    // Text
    private int intProduceProduced;
    private float fltHarvestProfit;





    /* ----- ----- ----- FarmGUI Constructor ----- ----- ----- */

    public FarmGUI(int intRows, int intCols) {


        /* ----- Make JFrame / Window ----- */

        // Set the title
        super("My Farm");

        // Set the window background color
        getContentPane().setBackground(Color.decode("#366500"));

        // Set the window size
        setSize(1200, 700);

        // Prevent window resizing
        setResizable(false);

        // Set the default close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set the Layout
        setLayout(new BorderLayout());

        // Set the number of rows and columns
        this.intRows = intRows;
        this.intCols = intCols;


        /* ----- Initialize Crop Grid ----- */
        this.arrbtnCrops = new JButton[this.intRows][this.intCols];

        for (int i = 0; i < this.intRows; i++) {

            for (int j = 0; j < this.intCols; j++) {

                // Create a new JButton
                this.arrbtnCrops[i][j] = new JButton("");
                this.arrbtnCrops[i][j].setActionCommand(i + " " + j);
            }
        }


        /* ----- Make Components in JFrame ----- */

        this.makeCenterPanel();
        this.makeNorthPanel();
        this.makeSouthPanel();
        this.makeEastPanel();
        this.makeWestPanel();


        /* ----- Set Visibility to True in the end ----- */

        setVisible(true);
    }



    /* ----- ----- ----- GUI-Element Initialization Methods ----- ----- ----- */

    public void makeCenterPanel() {

        // Create a JPanel
        JPanel panelCenter = new JPanel();

        // Explicitly set the Layout
        panelCenter.setLayout(new GridLayout(this.intRows, this.intCols));
        panelCenter.setBackground(Color.GRAY);


        // Create Crop Grid
        for (int i = 0; i < this.intRows; i++) {

            for (int j = 0; j < this.intCols; j++) {

                // Create a new JButton
                this.arrbtnCrops[i][j].setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.black, Color.black));

                // Set the background color
                this.arrbtnCrops[i][j].setBackground(Color.decode("#af7b50"));

                // Add the JButton to the JPanel
                panelCenter.add(this.arrbtnCrops[i][j]);
            }
        }

        // Add the JPanel to the JFrame
        add(panelCenter, BorderLayout.CENTER);
    }

    public void makeEastPanel() {
        int intDim = 55;
        int intGutter = 2;
        JPanel panelEast = new JPanel();

        btnPlow.setPreferredSize(new Dimension (intDim, intDim));
        btnWater.setPreferredSize(new Dimension (intDim, intDim));
        btnFertilize.setPreferredSize(new Dimension (intDim, intDim));
        btnPickaxe.setPreferredSize(new Dimension (intDim, intDim));
        btnShovel.setPreferredSize(new Dimension (intDim, intDim));
        btnPlant.setPreferredSize(new Dimension (intDim, intDim));
        btnHarvest.setPreferredSize(new Dimension (intDim, intDim));

        panelEast.setLayout(new GridLayout(7,0));

        JPanel panelOne = new JPanel();
        JPanel panelTwo = new JPanel();
        JPanel panelThree = new JPanel();
        JPanel panelFour = new JPanel();
        JPanel panelFive = new JPanel();
        JPanel panelSix = new JPanel();
        JPanel panelSeven = new JPanel();

        panelOne.setBorder(BorderFactory.createEmptyBorder(intGutter,intGutter,intGutter,intGutter));
        panelTwo.setBorder(BorderFactory.createEmptyBorder(intGutter,intGutter, intGutter,intGutter));
        panelThree.setBorder(BorderFactory.createEmptyBorder(intGutter,intGutter,intGutter,intGutter));
        panelFour.setBorder(BorderFactory.createEmptyBorder(intGutter,intGutter,intGutter,intGutter));
        panelFive.setBorder(BorderFactory.createEmptyBorder(intGutter,intGutter,intGutter,intGutter));
        panelSix.setBorder(BorderFactory.createEmptyBorder(intGutter,intGutter,intGutter,intGutter));
        panelSeven.setBorder(BorderFactory.createEmptyBorder(intGutter,intGutter,intGutter,intGutter));

        panelOne.add(btnPlow);
        panelTwo.add(btnWater);
        panelThree.add(btnFertilize);
        panelFour.add(btnPickaxe);
        panelFive.add(btnShovel);
        panelSix.add(btnPlant);
        panelSeven.add(btnHarvest);

        panelEast.add(panelOne);
        panelEast.add(panelTwo);
        panelEast.add(panelThree);
        panelEast.add(panelFour);
        panelEast.add(panelFive);
        panelEast.add(panelSix);
        panelEast.add(panelSeven);

        add(panelEast, BorderLayout.EAST);
    }

    public void makeWestPanel() {
            JPanel panelWest = new JPanel();
            panelWest.setLayout(new GridLayout(2,0));

            JPanel panelWestTop = new JPanel(); {
                panelWestTop.setLayout(new GridBagLayout());
                panelWestTop.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
                panelWestTop.setBackground(Color.GRAY);

                JPanel panelWestTopMid = new JPanel(); {
                    panelWestTopMid.setBackground(Color.decode("#af7b50"));
                    panelWestTopMid.setPreferredSize(new Dimension (150, 150));
                    panelWestTopMid.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.black, Color.black));
                }

                panelWestTop.add(panelWestTopMid);
            }

            JPanel panelWestBot = new JPanel(); {
                panelWestBot.setLayout(new BorderLayout());

                JPanel panelWestBotTop = new JPanel(); {
                    panelWestBotTop.setLayout(new GridBagLayout());

                    Font fntFont = new Font ("Comic Sans MS", Font.BOLD, 12);

                    lblTileStatus.setFont (fntFont);
                    lblTilePlant.setFont (fntFont);
                    lblTilePlantAge.setFont (fntFont);
                    lblTimesWatered.setFont (fntFont);
                    lblTimesFertilized.setFont (fntFont);

                    GridBagConstraints gbcConstraints = new GridBagConstraints();
                    gbcConstraints.fill = GridBagConstraints.VERTICAL;

                    gbcConstraints.gridy = 1;
                    panelWestBotTop.add(lblTileStatus,gbcConstraints);
                    gbcConstraints.gridy = 2;
                    panelWestBotTop.add(lblTilePlant,gbcConstraints);
                    gbcConstraints.gridy = 3;
                    panelWestBotTop.add(lblTilePlantAge,gbcConstraints);
                    gbcConstraints.gridy = 4;
                    panelWestBotTop.add(lblTimesWatered,gbcConstraints);
                    gbcConstraints.gridy = 5;
                    panelWestBotTop.add(lblTimesFertilized,gbcConstraints);
                }

                panelWestBot.add(panelWestBotTop, BorderLayout.NORTH);
            }

            panelWest.add(panelWestTop);
            panelWest.add(panelWestBot);
            add(panelWest, BorderLayout.WEST);
        }

    public void makeSouthPanel() {
        JPanel panelSouth = new JPanel();

        panelSouth.setLayout(new BorderLayout());
        panelSouth.setBackground(Color.PINK);

        // Create a JPanel for the Farmer Info
        JPanel panelSouthWest = new JPanel(); {
        //panelNorthWest.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.yellow, Color.black));
            panelSouthWest.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
            panelSouthWest.setBackground(Color.RED);
            panelSouthWest.setLayout(new FlowLayout());

            /* ----- Make Scrollable TextArea "Description" ----- */

            // Initialize the "Description" JTextArea
            // Make JTextArea wrap text
            // Default: false
            this.taLog.setLineWrap(true);
            //this.taLog.setEditable(false);
            this.taLog.setForeground(Color.WHITE);
            this.taLog.setBackground(Color.BLACK);
            this.taLog.setPreferredSize(new Dimension(300,50));

            // Create a JScrollPane and add JTextArea to make it scrollable
            JScrollPane scrollPane = new JScrollPane(this.taLog);

            // Set JScrollPane scrolling method
            // Default: only Horizontal, no Vertical
            scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
            scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

            panelSouthWest.add(scrollPane);
            panelSouthWest.add(this.taLog);
        }

        // Create a JPanel for the Day Number
        JPanel panelSouthCenter = new JPanel(); {
            //panelNorthWest.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.yellow, Color.black));
            //panelNorthCenter.setBorder(BorderFactory.createEmptyBorder(1,200,50,1));
            panelSouthCenter.setBackground(Color.GRAY);
            panelSouthCenter.setLayout(new GridBagLayout());

            btnProceedDay.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
            btnProceedDay.setPreferredSize(new Dimension (300, 50));
            panelSouthCenter.add(btnProceedDay);
        }

        // Add the panels to the North Panel
        panelSouth.add(panelSouthWest, "West");
        panelSouth.add(panelSouthCenter, "Center");

        // Add the North Panel to the JFrame
        add(panelSouth, BorderLayout.SOUTH);
    }

    public void makeNorthPanel() {

        // Create a JPanel
        JPanel panelNorth = new JPanel();

        panelNorth.setLayout(new BorderLayout());
        panelNorth.setBackground(Color.PINK);

        // Create a JPanel for the Farmer Info
        JPanel panelNorthWest = new JPanel(); {
            panelNorthWest.setPreferredSize(new Dimension(900,100));
            panelNorthWest.setBackground(Color.RED);
            panelNorthWest.setLayout(new BorderLayout());

            JPanel panelNorthWestWest = new JPanel(); {
                panelNorthWestWest.setLayout(new GridBagLayout());
                panelNorthWestWest.setPreferredSize(new Dimension(100, 100));
                panelNorthWestWest.setBackground(Color.ORANGE);

                JPanel panelNorthWestWestMid = new JPanel(); {
                    panelNorthWestWestMid.setPreferredSize(new Dimension (99,99));
                    panelNorthWestWestMid.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,Color.ORANGE,Color.PINK));
                }

                panelNorthWestWest.add(panelNorthWestWestMid);
            }

            JPanel panelNorthWestCenter = new JPanel(); {
                panelNorthWestCenter.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
                panelNorthWestCenter.setLayout(new BoxLayout(panelNorthWestCenter, BoxLayout.Y_AXIS));
                panelNorthWestCenter.setBackground(Color.RED);

                this.lblFarmerName.setForeground(Color.WHITE);
                this.lblFarmerName.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
                this.lblFarmerLevel.setForeground(Color.WHITE);
                this.lblFarmerLevel.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
                this.lblObjectCoins.setForeground(Color.WHITE);
                this.lblObjectCoins.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
                this.lblFarmerTitle.setForeground(Color.WHITE);
                this.lblFarmerTitle.setFont(new Font("Comic Sans MS", Font.BOLD, 15));

                panelNorthWestCenter.add(lblFarmerName);
                panelNorthWestCenter.add(lblFarmerLevel);
                panelNorthWestCenter.add(lblObjectCoins);
                panelNorthWestCenter.add(lblFarmerTitle);

            }

            JPanel panelNorthWestEast = new JPanel();
            {
                panelNorthWestEast.setBackground(Color.red);
                panelNorthWestEast.setBorder(BorderFactory.createEmptyBorder(70,5,5,10));
                panelNorthWestEast.setLayout(new BoxLayout(panelNorthWestEast, BoxLayout.Y_AXIS));
                btnRegister.setPreferredSize(new Dimension (100,10));
                panelNorthWestEast.add(btnRegister);
            }

            panelNorthWest.add(panelNorthWestEast, BorderLayout.EAST);
            panelNorthWest.add(panelNorthWestWest, BorderLayout.WEST);
            panelNorthWest.add(panelNorthWestCenter, BorderLayout.CENTER);
        }

        // Create a JPanel for the Day Number
        JPanel panelNorthCenter = new JPanel(); {
            //panelNorthWest.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.yellow, Color.black));
            //panelNorthCenter.setBorder(BorderFactory.createEmptyBorder(1,200,50,1));
            panelNorthCenter.setBackground(Color.PINK);
            panelNorthCenter.setLayout(new GridBagLayout());
            panelNorthCenter.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.ORANGE, Color.YELLOW));

            this.lblDayNum.setForeground(Color.BLACK);
            this.lblDayNum.setFont(new Font("Comic Sans MS", Font.BOLD, 30));

            panelNorthCenter.add(this.lblDayNum);
        }

        // Add the panels to the North Panel
        panelNorth.add(panelNorthWest, "West");
        panelNorth.add(panelNorthCenter, "Center");

        // Add the North Panel to the JFrame
        add(panelNorth, BorderLayout.NORTH);
    }


    /* ----- ----- ----- GUI-element Setting Methods ----- ----- ----- */



    /* ----- ----- Farmer Information ----- ----- */

    public void setFarmerName(String strFarmerName) {

        this.lblFarmerName.setText("Farmer Name" + strFarmerName);
    }

    public void setFarmerLevelEXP(float fltFarmerEXP) {

        this.lblFarmerLevel.setText("Farmer Level: " + (int)(fltFarmerEXP / 100) + " (" + (fltFarmerEXP % 100) + " / 100)");
    }

    public void setObjectCoins(float fltObjectCoins) {

        this.lblObjectCoins.setText("Object Coins: " + fltObjectCoins);
    }

    public void setFarmerTitle(String strFarmerTitle) {

        this.lblFarmerTitle.setText("Farmer Title: " + strFarmerTitle);
    }



    /* ----- ----- Day Number ----- ----- */

    public void setDayNum(int intDayNum) {

        this.lblDayNum.setText("Day " + intDayNum);
    }



    /* ----- ----- Tile Button Statuses ----- ----- */

    public void setTileButtons(int intXIndex,
                               int intYIndex,
                               String strTileStatus) {

        this.arrbtnCrops[intXIndex][intYIndex].setText(strTileStatus);
    }



    /* ----- ----- Tile Details ----- ----- */

    public void setTileStatus(String strTileDetails) {

        if (!strTileDetails.equals(""))
            this.lblTileStatus.setText("Tile Status: " + strTileDetails);

        else
            this.lblTileStatus.setText("No Tile Selected");
    }

    public void setTilePlant(String strTilePlant) {


        if (!strTilePlant.equals(""))
            this.lblTilePlant.setText("Plant: " + strTilePlant);

        else
            this.lblTilePlant.setText("");
    }

    public void setPlantAge(String strPlantAge) {

        if (!strPlantAge.equals(""))
            this.lblTilePlantAge.setText("Plant Age: " + strPlantAge);

        else
            this.lblTilePlantAge.setText("");
    }

    public void setTimesWatered(String strTileWater) {

        if (!strTileWater.equals(""))
            this.lblTimesWatered.setText("Times Watered: " + strTileWater);

        else
            this.lblTimesWatered.setText("");
    }

    public void setTimesFertilized(String strTileFertilizer) {

        if (!strTileFertilizer.equals(""))
            this.lblTimesFertilized.setText("Times Fertilized: " + strTileFertilizer);

        else
            this.lblTimesFertilized.setText("");
    }





    /* ----- ----- ----- GUI-element Setting Methods ----- ----- ----- */

    public void setActionListener (ActionListener listener) {

        // Add an ActionListener to each JButton

            // Register
        this.btnRegister.addActionListener(listener);

            // Tile Actions
        this.btnPlow.addActionListener(listener);
        this.btnWater.addActionListener(listener);
        this.btnFertilize.addActionListener(listener);
        this.btnPickaxe.addActionListener(listener);
        this.btnShovel.addActionListener(listener);
        this.btnPlant.addActionListener(listener);

            // Proceed Day
        this.btnProceedDay.addActionListener(listener);

            // Crop Grid
        for (int i = 0; i < this.intRows; i++) {

            for (int j = 0; j < this.intCols; j++) {

                this.arrbtnCrops[i][j].addActionListener(listener);
            }
        }
    }



    /* ----- ----- Register Title ----- ----- */

    public void setRegisterEnabled(boolean boolEnabled) {

        this.btnRegister.setEnabled(boolEnabled);
    }

    public void setRegisterLabel(String strRegisterLabel) {

        this.btnRegister.setText(strRegisterLabel);
    }



    /* ----- ----- Tile Actions ----- ----- */

    public void setPlowEnabled(boolean boolEnabled) {

        this.btnPlow.setEnabled(boolEnabled);
    }

    public void setWaterEnabled(boolean boolEnabled) {

        this.btnWater.setEnabled(boolEnabled);
    }

    public void setFertilizeEnabled(boolean boolEnabled) {

        this.btnFertilize.setEnabled(boolEnabled);
    }

    public void setPickaxeEnabled(boolean boolEnabled) {

        this.btnPickaxe.setEnabled(boolEnabled);
    }

    public void setShovelEnabled(boolean boolEnabled) {

        this.btnShovel.setEnabled(boolEnabled);
    }

    public void setPlantEnabled(boolean boolEnabled) {

        this.btnPlant.setEnabled(boolEnabled);
    }

    public void setHarvestEnabled(boolean boolEnabled) {

    	this.btnHarvest.setEnabled(boolEnabled);
    }



    /* ----- ----- Advance Day ----- ----- */

    public void setProceedDayEnabled(boolean boolEnabled) {

        this.btnProceedDay.setEnabled(boolEnabled);
    }





    /* ----- ----- ----- Getters and Setters ----- ----- ----- */

    public void setIntProduceProduced(int intProduceProduced) {this.intProduceProduced = intProduceProduced;}

    public void setFltHarvestProfit(float fltHarvestProfit) {this.fltHarvestProfit = fltHarvestProfit;}
}