package Visuals;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class ShopGUI extends JFrame {

    /*----Attributes----*/

    // JLabels
    private JLabel lblSeedName = new JLabel("");
    private JLabel lblCropType = new JLabel("");
    private JLabel lblHarvestTime = new JLabel("");
    private JLabel lblWaterReq = new JLabel("");
    private JLabel lblFertilizerReq = new JLabel("");
    private JLabel lblRangeProductsProduced = new JLabel("");
    private JLabel lblSeedCost = new JLabel("");
    private JLabel lblProducePrice = new JLabel("");
    private JLabel lblHarvestEXP = new JLabel("");



    // JButtons

        // Plants
    private JButton btnTurnip = new JButton("Turnip");
    private JButton btnCarrot = new JButton("Carrot");
    private JButton btnPotato = new JButton("Potato");
    private JButton btnRose = new JButton("Rose");
    private JButton btnTulip = new JButton("Tulip");
    private JButton btnSunflower = new JButton("Sunflower");
    private JButton btnMango = new JButton("Mango");
    private JButton btnApple = new JButton("Apple");

        // Actions
    private JButton btnPlant = new JButton("Plant");
    private JButton btnCancel = new JButton("Cancel");






    /*----Constructor----*/
    public ShopGUI () {
        /* ----- Make JFrame / Window ----- */
        // Set the window background color


        // Set the window size
        setSize(450, 600);

        // Prevent window resizing
        setResizable(false);

        // Set the default close operation
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Set the Layout
        setLayout(new BorderLayout());


        /* ----- Initialize Crop Grid ----- */


        /* ----- Make Components in JFrame ----- */

        makeNorthPanel();
        makeCenterPanel();
        makeSouthPanel();

        /* ----- Set Visibility to True in the end ----- */

        setVisible(true);
    }


    public void makeNorthPanel(){
        JPanel panelNorth = new JPanel();

        panelNorth.setLayout (new GridLayout (3,3));
        panelNorth.setPreferredSize(new Dimension(450, 300));

        Dimension dimPlant = new Dimension (90,90);
        int intGutter = 4;

        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();
        JPanel panel5 = new JPanel();
        JPanel panel6 = new JPanel();
        JPanel panel7 = new JPanel();
        JPanel panel8 = new JPanel();

        btnTurnip.setPreferredSize(dimPlant);
        btnCarrot.setPreferredSize(dimPlant);
        btnPotato.setPreferredSize(dimPlant);
        btnRose.setPreferredSize(dimPlant);
        btnTulip.setPreferredSize(dimPlant);
        btnSunflower.setPreferredSize(dimPlant);
        btnMango.setPreferredSize(dimPlant);
        btnApple.setPreferredSize(dimPlant);

        panel1.setBorder(BorderFactory.createEmptyBorder(intGutter,intGutter,intGutter,intGutter));
        panel2.setBorder(BorderFactory.createEmptyBorder(intGutter,intGutter,intGutter,intGutter));
        panel3.setBorder(BorderFactory.createEmptyBorder(intGutter,intGutter,intGutter,intGutter));
        panel4.setBorder(BorderFactory.createEmptyBorder(intGutter,intGutter,intGutter,intGutter));
        panel5.setBorder(BorderFactory.createEmptyBorder(intGutter,intGutter,intGutter,intGutter));
        panel6.setBorder(BorderFactory.createEmptyBorder(intGutter,intGutter,intGutter,intGutter));
        panel7.setBorder(BorderFactory.createEmptyBorder(intGutter,intGutter,intGutter,intGutter));
        panel8.setBorder(BorderFactory.createEmptyBorder(intGutter,intGutter,intGutter,intGutter));

        panel1.add(btnTurnip);
        panel2.add(btnCarrot);
        panel3.add(btnPotato);
        panel4.add(btnRose);
        panel5.add(btnTulip);
        panel6.add(btnSunflower);
        panel7.add(btnMango);
        panel8.add(btnApple);

        panelNorth.add(panel1);
        panelNorth.add(panel2);
        panelNorth.add(panel3);
        panelNorth.add(panel4);
        panelNorth.add(panel5);
        panelNorth.add(panel6);
        panelNorth.add(panel7);
        panelNorth.add(panel8);

        add(panelNorth, BorderLayout.NORTH);
    }

    public void makeCenterPanel () {
        JPanel panelCenter = new JPanel();

        panelCenter.setLayout (new BorderLayout());

        JPanel panelCenterNorth = new JPanel(); {
            panelCenterNorth.setLayout(new BorderLayout());

            JPanel panelCenterNorthWest = new JPanel(); {
                panelCenterNorthWest.setLayout (new BoxLayout(panelCenterNorthWest,BoxLayout.Y_AXIS));
                panelCenterNorthWest.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

                panelCenterNorthWest.add(lblSeedName);
                panelCenterNorthWest.add(lblCropType);
                panelCenterNorthWest.add(lblHarvestTime);
                panelCenterNorthWest.add(lblWaterReq);
                panelCenterNorthWest.add(lblFertilizerReq);
                panelCenterNorthWest.add(lblRangeProductsProduced);
                panelCenterNorthWest.add(lblSeedCost);
                panelCenterNorthWest.add(lblProducePrice);
                panelCenterNorthWest.add(lblHarvestEXP);
            }
            JPanel panelCenterNorthCenter = new JPanel(); {
                panelCenterNorthCenter.setLayout(new GridBagLayout());
                                panelCenterNorthCenter.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
                JPanel panelCenterNorthCenterCenter = new JPanel(); {
                    panelCenterNorthCenterCenter.setPreferredSize(new Dimension(150,150));
                    panelCenterNorthCenterCenter.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,Color.ORANGE,Color.YELLOW));
                }
                panelCenterNorthCenter.add(panelCenterNorthCenterCenter);
            }

            panelCenterNorth.add(panelCenterNorthCenter, "Center");
            panelCenterNorth.add(panelCenterNorthWest, "West");
        }
        panelCenter.add(panelCenterNorth, "North");
        add(panelCenter,BorderLayout.CENTER);
    }

    public void makeSouthPanel(){
        JPanel panelSouth = new JPanel();
        panelSouth.setLayout(new BorderLayout());
        panelSouth.setBorder(BorderFactory.createEmptyBorder(4,4,4,4));

        JPanel panelSouthWest = new JPanel();
        JPanel panelSouthEast = new JPanel();

        panelSouthWest.add(btnCancel);
        panelSouthEast.add(btnPlant);

        panelSouth.add(panelSouthWest, "West");
        panelSouth.add(panelSouthEast, "East");
        add(panelSouth, BorderLayout.SOUTH);
    }



    /* ----- ----- ----- GUI-element Setting Methods ----- ----- ----- */



    /* ----- ----- Plant Details ----- ----- */

    public void setSeedName(String strSeedName) {

        if (!strSeedName.equals(""))
            this.lblSeedName.setText("Seed Name: " + strSeedName);

        else
            this.lblSeedName.setText("No Plant Selected");
    }

    public void setCropType(String strCropType) {

        if (!strCropType.equals(""))
            this.lblCropType.setText("Crop Type: " + strCropType);

        else
            this.lblCropType.setText("");
    }

    public void setHarvestTime(String strHarvestTime) {

        if (!strHarvestTime.equals(""))
            this.lblHarvestTime.setText("Harvest Time: " + strHarvestTime);

        else
            this.lblHarvestTime.setText("");
    }

    public void setWaterReq(String strWaterReq, String strWaterLimit) {

        if (!strWaterReq.equals("") && !strWaterLimit.equals(""))
            this.lblWaterReq.setText("Water Requirement: " + strWaterReq +
                    " (Bonus Limit: " + strWaterLimit + ")");

        else
            this.lblWaterReq.setText("");
    }

    public void setFertilizerReq(String strFertilizerReq, String strFertilizerLimit) {

        if (!strFertilizerReq.equals("") && !strFertilizerLimit.equals(""))
            this.lblFertilizerReq.setText("Fertilizer Requirement: " + strFertilizerReq +
                    " (Bonus Limit: " + strFertilizerLimit + ")");

        else
            this.lblFertilizerReq.setText("");
    }

    public void setRangeProductsProduced(String strMinProductsProduced, String strMaxProductsProduced) {

        if (!strMinProductsProduced.equals("") && !strMaxProductsProduced.equals(""))
            this.lblRangeProductsProduced.setText("Range Products Produced: " +
                    strMinProductsProduced + " - " + strMaxProductsProduced);

        else
            this.lblRangeProductsProduced.setText("");
    }

    public void setSeedCost(String strSeedCost) {

        if (!strSeedCost.equals(""))
            this.lblSeedCost.setText("Seed Cost: " + strSeedCost);

        else
            this.lblSeedCost.setText("");
    }

    public void setProducePrice(String strCropCost) {

        if (!strCropCost.equals(""))
            this.lblProducePrice.setText("Produce Price: " + strCropCost);

        else
            this.lblProducePrice.setText("");
    }

    public void setHarvestEXP(String strHarvestEXP) {

        if (!strHarvestEXP.equals(""))
            this.lblHarvestEXP.setText("Harvest EXP: " + strHarvestEXP);

        else
            this.lblHarvestEXP.setText("");
    }





    /* ----- ----- ----- GUI-element Setting Methods ----- ----- ----- */

    public void setActionListener (ActionListener listener) {

        // Add an ActionListener to each JButton

        // Plants
        this.btnTurnip.addActionListener(listener);
        this.btnCarrot.addActionListener(listener);
        this.btnPotato.addActionListener(listener);
        this.btnRose.addActionListener(listener);
        this.btnTulip.addActionListener(listener);
        this.btnSunflower.addActionListener(listener);
        this.btnMango.addActionListener(listener);
        this.btnApple.addActionListener(listener);
        
        // Actions
        this.btnPlant.addActionListener(listener);
        this.btnCancel.addActionListener(listener);
    }



    /* ----- ----- Plants ----- ----- */

    public void setTurnipEnabled(boolean boolEnabled) {

        this.btnTurnip.setEnabled(boolEnabled);
    }
    
    public void setCarrotEnabled(boolean boolEnabled) {

        this.btnCarrot.setEnabled(boolEnabled);
    }
    
    public void setPotatoEnabled(boolean boolEnabled) {

        this.btnPotato.setEnabled(boolEnabled);
    }
    
    public void setRoseEnabled(boolean boolEnabled) {

        this.btnRose.setEnabled(boolEnabled);
    }
    
    public void setTulipEnabled(boolean boolEnabled) {

        this.btnTulip.setEnabled(boolEnabled);
    }
    
    public void setSunflowerEnabled(boolean boolEnabled) {

        this.btnSunflower.setEnabled(boolEnabled);
    }
    
    public void setMangoEnabled(boolean boolEnabled) {

        this.btnMango.setEnabled(boolEnabled);
    }
    
    public void setAppleEnabled(boolean boolEnabled) {

        this.btnApple.setEnabled(boolEnabled);
    }



    /* ----- ----- Actions ----- ----- */
    
    public void setPlantEnabled(boolean boolEnabled) {

        this.btnPlant.setEnabled(boolEnabled);
    }
    
    public void setCancelEnabled(boolean boolEnabled) {

        this.btnCancel.setEnabled(boolEnabled);
    }
}
