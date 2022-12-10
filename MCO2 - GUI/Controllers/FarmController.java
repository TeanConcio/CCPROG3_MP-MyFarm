package Controllers;



import Models.Board;
import Models.Tile;
import Visuals.FarmGUI;
import Models.Model;
import Visuals.ShopGUI;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import java.awt.*;
import java.awt.event.ActionEvent;



/* ----- ----- ----- Controller ----- ----- ----- */

public class FarmController implements Controller {



    /* ----- ----- Controller Attributes ----- ----- */

    private Model objModel;
    private FarmGUI objFarmGUI;





    /* ----- ----- Controller Constructor ----- ----- */
    // Takes the Visual and Model as parameters

    public FarmController (Model objModel, FarmGUI objFarmGUI) {

        // Initialize Visual and Model from parameters
        this.objFarmGUI = objFarmGUI;
        this.objModel = objModel;


        // Update the Visual with the Model
        this.updateView();


        // Add ActionListeners to the buttons
        objFarmGUI.setActionCommands();
        objFarmGUI.setActionListener(this);


        // Add DocumentListeners to the text fields
        // objGUI.setDocumentListener(this);
    }





    /* ----- ----- Farm GUI Controller Methods ----- ----- */

    public void updateView() {

        // Update Labels
        this.updateLabels();

        // Update Button Enabled
        this.updateEnabledButtons();


        // Check Game Over
        if (this.objModel.isGameOver())
            objFarmGUI.setBoolGameOver(true);
    }



    public void updateLabels() {

        // Update Farmer Information
        objFarmGUI.setFarmerName("Bob");
        objFarmGUI.setFarmerLevelEXP(objModel.getObjFarmer().getFltEXP());
        objFarmGUI.setObjectCoins(objModel.getObjFarmer().getFltObjectCoins());
        objFarmGUI.setFarmerTitle(objModel.getObjFarmer().getObjCurrentTitle().getStrFarmerTitle());

        // Set Day Number
        objFarmGUI.setDayNum(objModel.getObjBoard().getIntDay());

        // Set the Tile Statuses
        this.updateTileButtons();

        // If a Tile is selected
        if (objModel.getObjSelectedTile() != null) {

            // Set Tile Details
            objFarmGUI.setTileStatus(objModel.getObjSelectedTile().getTileStatusString(false));

            // If Tile has a Plant
            if (objModel.getObjSelectedTile().getObjPlant() != null) {

                // Display Plant Details
                objFarmGUI.setTilePlant(objModel.getObjSelectedTile().getObjPlant().getStrSeedName());
                objFarmGUI.setPlantAge("" + objModel.getObjSelectedTile().getIntPlantAge());
                objFarmGUI.setTimesWatered("" + objModel.getObjSelectedTile().getIntTimesWatered());
                objFarmGUI.setTimesFertilized("" + objModel.getObjSelectedTile().getIntTimesFertilized());
            }
            else {

                objFarmGUI.setTilePlant("None");
                objFarmGUI.setPlantAge("");
                objFarmGUI.setTimesWatered("");
                objFarmGUI.setTimesFertilized("");
            }
        }

        // If no Tile Selected
        else {

            objFarmGUI.setTileStatus("");
            objFarmGUI.setTilePlant("");
            objFarmGUI.setPlantAge("");
            objFarmGUI.setTimesWatered("");
            objFarmGUI.setTimesFertilized("");
        }

        // Update the Log
        objFarmGUI.setTaLog();
    }



    public void updateEnabledButtons() {

        // Register Title
        objFarmGUI.setRegisterEnabled(objModel.getObjFarmer().
                canRegisterNextTitle(objModel.getObjTitleList()));


        // Tile Action
        if (objModel.getObjSelectedTile() != null) {

            // Plow
            objFarmGUI.setPlowEnabled(objModel.getObjFarmer().getObjPlow().
                    canUseTool(objModel.getObjSelectedTile(),
                            objModel.getObjFarmer().getFltObjectCoins()));
            // Water
            objFarmGUI.setWaterEnabled(objModel.getObjFarmer().getObjWateringCan().
                    canUseTool(objModel.getObjSelectedTile(),
                            objModel.getObjFarmer().getFltObjectCoins()));
            // Fertilize
            objFarmGUI.setFertilizeEnabled(objModel.getObjFarmer().getObjFertilizer().
                    canUseTool(objModel.getObjSelectedTile(),
                            objModel.getObjFarmer().getFltObjectCoins()));
            // Pickaxe
            objFarmGUI.setPickaxeEnabled(objModel.getObjFarmer().getObjPickaxe().
                    canUseTool(objModel.getObjSelectedTile(),
                            objModel.getObjFarmer().getFltObjectCoins()));
            // Shovel
            objFarmGUI.setShovelEnabled(objModel.getObjFarmer().getObjShovel().
                    canUseTool(objModel.getObjSelectedTile(),
                            objModel.getObjFarmer().getFltObjectCoins()));
            // Plant
            objFarmGUI.setPlantEnabled(objModel.getObjSelectedTile().
                    getIntStatus() == Tile.PLOWED &&
                    objModel.getObjSelectedTile().getObjPlant() == null);

            // Harvest
            objFarmGUI.setHarvestEnabled(objModel.getObjSelectedTile().canHarvest());
        }

        // If no Tile Selected
        else {

            objFarmGUI.setPlowEnabled(false);
            objFarmGUI.setWaterEnabled(false);
            objFarmGUI.setFertilizeEnabled(false);
            objFarmGUI.setPickaxeEnabled(false);
            objFarmGUI.setShovelEnabled(false);
            objFarmGUI.setPlantEnabled(false);
            objFarmGUI.setHarvestEnabled(false);
        }
    }



    public void updateTileButtons() {

        String strTileStatus;

        // For each Row
        for (int i = 0; i < Board.ROW; i++) {

            // For each Column
            for (int j = 0; j < Board.COLUMN; j++) {

                strTileStatus = objModel.getObjBoard().getTileFromCoords(i, j).
                        getTileStatusString(false);


                // Set the Tile Status

                switch (strTileStatus) {

                    case "Rock":
                        objFarmGUI.setTileButtons(i, j, new ImageIcon(getClass().getResource("Assets/Rock.PNG")));
                        break;

                    case "Unplowed":
                        break;

                    case "Plowed":
                        objFarmGUI.setTileButtons(i, j, new ImageIcon(getClass().getResource("Assets/Plowed.PNG")));
                        break;

                    case "Occupied":
                        switch (objModel.getObjBoard().getTileFromCoords(i, j).getObjPlant().getStrSeedName()) {

                            case "Turnip":
                              objFarmGUI.setTileButtons(i, j, new ImageIcon(getClass().getResource("Assets/RootCrop.PNG")));//                                switch (objModel.getObjBoard().getTileFromCoords(i, j).getObjPlant().getIntAge())
//                                    case 0:
//                                    case 1:
                              break;
                            case "Carrot":
                                objFarmGUI.setTileButtons(i, j, new ImageIcon(getClass().getResource("Assets/RootCrop.PNG")));//                                switch (objModel.getObjBoard().getTileFromCoords(i, j).getObjPlant().getIntAge())
//                                    case 0:
//                                    case 1:
//                                    case 2:
                                 break;
                            case "Potato":
                                objFarmGUI.setTileButtons(i, j, new ImageIcon(getClass().getResource("Assets/RootCrop.PNG")));//                                switch (objModel.getObjBoard().getTileFromCoords(i, j).getObjPlant().getIntAge())
//                                    case 0:
//                                    case 1:
//                                    case 2:
//                                    case 3:
//                                    case 4:
//                                    case 5:
                                break;
                            case "Rose":
                                objFarmGUI.setTileButtons(i, j, new ImageIcon(getClass().getResource("Assets/Sapling.PNG")));//                                switch (objModel.getObjBoard().getTileFromCoords(i, j).getObjPlant().getIntAge())
//                                    case 0:
                                break;
                            case "Tulip":
                                objFarmGUI.setTileButtons(i, j, new ImageIcon(getClass().getResource("Assets/Sapling.PNG")));//                                switch (objModel.getObjBoard().getTileFromCoords(i, j).getObjPlant().getIntAge())
//                                    case 0:
//                                    case 1:
                                break;
                            case "Sunflower":
                                objFarmGUI.setTileButtons(i, j, new ImageIcon(getClass().getResource("Assets/Sapling.PNG")));

                                break;
                            case "Mango":
                                objFarmGUI.setTileButtons(i, j, new ImageIcon(getClass().getResource("Assets/Sapling.PNG")));
//                                switch (objModel.getObjBoard().getTileFromCoords(i, j).getObjPlant().getIntAge())
//                                    case 0:
//                                    case 1:
//                                    case 2:
//                                    case 3:
//                                    case 4:
//                                    case 5:
//                                    case 6:
//                                    case 7:
//                                    case 8:
//                                    case 9:
                                 break;
                            case "Apple":
                                objFarmGUI.setTileButtons(i, j, new ImageIcon(getClass().getResource("Assets/Sapling.PNG")));//                                switch (objModel.getObjBoard().getTileFromCoords(i, j).getObjPlant().getIntAge())
//                                    case 0:
//                                    case 1:
//                                    case 2:
//                                    case 3:
//                                    case 4:
//                                    case 5:
//                                    case 6:
//                                    case 7:
//                                    case 8:
//                                    case 9:
                                break;
                        }
                        break;
                    case "Harvestable":
                        switch (objModel.getObjBoard().getTileFromCoords(i, j).getObjPlant().getStrSeedName()) {

                            case "Turnip":
                              objFarmGUI.setTileButtons(i, j, new ImageIcon(getClass().getResource("Assets/Turnip2.PNG")));
                              break;
                            case "Carrot":
                                objFarmGUI.setTileButtons(i, j, new ImageIcon(getClass().getResource("Assets/Carrot3.PNG")));
                                break;
                            case "Potato":
                                objFarmGUI.setTileButtons(i, j, new ImageIcon(getClass().getResource("Assets/Potato5.PNG")));
                                break;
                            case "Rose":
                                objFarmGUI.setTileButtons(i, j, new ImageIcon(getClass().getResource("Assets/Rose1.PNG")));
                                break;
                            case "Sunflower":
                                objFarmGUI.setTileButtons(i, j, new ImageIcon(getClass().getResource("Assets/Sunflower3.PNG")));
                                break;
                            case "Tulip":
                                objFarmGUI.setTileButtons(i, j, new ImageIcon(getClass().getResource("Assets/Tulip1.PNG")));
                                break;
                            case "Mango":
                                objFarmGUI.setTileButtons(i, j, new ImageIcon(getClass().getResource("Assets/MangoTree.PNG")));
                                break;
                            case "Apple":
                                objFarmGUI.setTileButtons(i, j, new ImageIcon(getClass().getResource("Assets/AppleTree.PNG")));
                                break;
                        }
                        break;

                    case "Withered":
                        objFarmGUI.setTileButtons(i, j, new ImageIcon(getClass().getResource("Assets/Withered.PNG")));
                        break;
                }
                //objFarmGUI.setTileButtons(i, j, strTileStatus);


                // Log Harvestable and Withered Plants
                if (strTileStatus.contains("Harvestable")) {

                    objFarmGUI.addLogHarvestable(i, j);
                }
                else if (strTileStatus.contains("Withered")) {

                    objFarmGUI.addLogWithered(i, j);
                }
            }
        }
    }
//    public void updateTile(int n, Tile tile) {
//        String strStatus = tile.toString();
//        int intStatus = tile.getStatus();
//
//        try {
//            if(intStatus == Tile.ISHARVESTABLE) {
//                this.btnlistPlot.get(n).setIcon(new ImageIcon(getClass().getResource("resources/" + strStatus.substring(2) + ".png")));
//            } else if(intStatus == Tile.ISPLANTED) {
//                this.btnlistPlot.get(n).setIcon(new ImageIcon(getClass().getResource("resources/Seed.png")));
//            } else {
//                this.btnlistPlot.get(n).setIcon(new ImageIcon(getClass().getResource("resources/" + strStatus + ".png")));
//            }
//            this.btnlistPlot.get(n).setText("");
//        } catch (Exception e) {
//            this.btnlistPlot.get(n).setText(strStatus);
//        }
//    }




    /* ----- ----- Method Overrides ----- ----- */



    /* ----- ActionListener Methods ----- */

    @Override
    public void actionPerformed(ActionEvent e) {

        // Get the Action Command
        switch (e.getActionCommand()) {

            case "Register":
                objModel.getObjFarmer().registerNextTitle(objModel.getObjTitleList(),
                        objModel.getObjShop());
                // If reached Max Title
                if (objModel.getObjTitleList().getNextTitle(objModel.getObjFarmer().getObjCurrentTitle()) == null)
                    objFarmGUI.setRegisterLabel("MAXED");
                break;

            case "Plow":
                objModel.getObjFarmer().getObjPlow().useTool(objModel.getObjSelectedTile(),
                        objModel.getObjFarmer());
                break;

            case "Water":
                objModel.getObjFarmer().getObjWateringCan().useTool(objModel.getObjSelectedTile(),
                        objModel.getObjFarmer());
                break;

            case "Fertilize":
                objModel.getObjFarmer().getObjFertilizer().useTool(objModel.getObjSelectedTile(),
                        objModel.getObjFarmer());
                break;

            case "Pickaxe":
                objModel.getObjFarmer().getObjPickaxe().useTool(objModel.getObjSelectedTile(),
                        objModel.getObjFarmer());
                objFarmGUI.setTileButtons(objModel.getObjSelectedTile().getIntRowCoord(),
                        objModel.getObjSelectedTile().getIntColCoord(), null);
                break;

            case "Shovel":
                objModel.getObjFarmer().getObjShovel().useTool(objModel.getObjSelectedTile(),
                        objModel.getObjFarmer());
                objFarmGUI.setTileButtons(objModel.getObjSelectedTile().getIntRowCoord(),
                        objModel.getObjSelectedTile().getIntColCoord(), null);
                break;

            case "Plant":
                objFarmGUI.setEnabled(false);

                new ShopController(this.objModel, new ShopGUI(), objFarmGUI);

                break;

            case "Harvest":
                int intProduceProduced = objModel.getObjSelectedTile().
                        getObjPlant().getProduceQuantity();
                objFarmGUI.setIntProduceProduced(intProduceProduced);

                float fltHarvestProfit = objModel.getObjSelectedTile().
                        getObjPlant().computeHarvestProfit(intProduceProduced,
                                objModel.getObjFarmer().getObjCurrentTitle(),
                                objModel.getObjSelectedTile().getIntTimesWatered(),
                                objModel.getObjSelectedTile().getIntTimesFertilized());
                objFarmGUI.setFltHarvestProfit(fltHarvestProfit);

                objFarmGUI.addLogHarvestProfit(intProduceProduced,
                        objModel.getObjSelectedTile().getObjPlant().getStrSeedName(),
                        fltHarvestProfit, objModel.getObjSelectedTile().getIntRowCoord(),
                        objModel.getObjSelectedTile().getIntColCoord());
                objModel.getObjFarmer().harvestCrop(objModel.getObjSelectedTile(),
                        fltHarvestProfit);

                objFarmGUI.setTileButtons(objModel.getObjSelectedTile().getIntRowCoord(),
                        objModel.getObjSelectedTile().getIntColCoord(), null);
                break;

            case "Proceed Day":
                objModel.getObjBoard().advanceDay();
                break;

            default:
                String[] arrstrCoords = e.getActionCommand().split(", ");

                objModel.setObjSelectedTile(objModel.getObjBoard().getTileFromCoords(
                        Integer.parseInt(arrstrCoords[0]),
                        Integer.parseInt(arrstrCoords[1])));

                break;
        }

        // Update GUI
        this.updateView();
        objFarmGUI.repaint();
    }



    /* ----- DocumentListener Methods ----- */

    @Override
    public void insertUpdate(DocumentEvent e) {

    }

    @Override
    public void removeUpdate(DocumentEvent e) {

    }

    @Override
    public void changedUpdate(DocumentEvent e) {

    }
}
