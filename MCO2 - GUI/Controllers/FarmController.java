package Controllers;



import Models.Board;
import Models.Tile;
import Visuals.FarmGUI;
import Models.Model;
import Visuals.ShopGUI;

import javax.swing.event.DocumentEvent;
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
    }



    public void updateLabels() {

        // Update Farmer Information
        objFarmGUI.setFarmerName("");
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

        // For each Row
        for (int i = 0; i < Board.ROW; i++) {

            // For each Column
            for (int j = 0; j < Board.COLUMN; j++) {

                // Set the Tile Status
                objFarmGUI.setTileButtons(i, j,
                        objModel.getObjBoard().getTileFromCoords(i, j).
                                getTileStatusString(false));
            }
        }
    }





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
                break;

            case "Shovel":
                objModel.getObjFarmer().getObjShovel().useTool(objModel.getObjSelectedTile(),
                        objModel.getObjFarmer());
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
                objModel.getObjFarmer().harvestCrop(objModel.getObjSelectedTile(),
                        fltHarvestProfit);
                break;

            case "Proceed Day":
                objModel.getObjBoard().advanceDay();
                break;

            default:

                String[] arrstrCoords = e.getActionCommand().split(" ");

                objModel.setObjSelectedTile(objModel.getObjBoard().getTileFromCoords(
                        Integer.parseInt(arrstrCoords[0]),
                        Integer.parseInt(arrstrCoords[1])));

                break;
        }

        // Update GUI
        updateView();
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
