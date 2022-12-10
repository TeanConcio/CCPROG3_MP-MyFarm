package Controllers;



import Models.Model;
import Visuals.FarmGUI;
import Visuals.ShopGUI;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import java.awt.event.ActionEvent;



/* ----- ----- ----- Controller ----- ----- ----- */

public class ShopController implements Controller {



    /* ----- ----- Controller Attributes ----- ----- */

    private Model objModel;
    private ShopGUI objShopGUI;
    private FarmGUI objFarmGUI;





    /* ----- ----- Controller Constructor ----- ----- */
    // Takes the Visual and Model as parameters

    public ShopController (Model objModel, ShopGUI objShopGUI, FarmGUI objFarmGUI) {

        // Initialize Visual and Model from parameters
        this.objModel = objModel;
        this.objShopGUI = objShopGUI;
        this.objFarmGUI = objFarmGUI;


        // Update the Visual with the Model
        this.updateView();


        // Add ActionListeners to the buttons
        objShopGUI.setActionCommands();
        objShopGUI.setActionListener(this);


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

        // If a Plant is selected
        if (objModel.getObjSelectedPlant() != null) {

            objShopGUI.setSeedName(objModel.getObjSelectedPlant().getStrSeedName());
            objShopGUI.setCropType(objModel.getObjSelectedPlant().getStrCropType());
            objShopGUI.setHarvestTime("" + objModel.getObjSelectedPlant().getIntHarvestTime());
            objShopGUI.setWaterReq("" + objModel.getObjSelectedPlant().getIntWaterReq(),
                    "" + objModel.getObjSelectedPlant().getIntWaterLimit());
            objShopGUI.setFertilizerReq("" + objModel.getObjSelectedPlant().getIntFertilizerReq(),
                    "" + objModel.getObjSelectedPlant().getIntFertilizerLimit());
            objShopGUI.setRangeProductsProduced("" +
                    objModel.getObjSelectedPlant().getIntMinProductsProduced(),
                    "" + objModel.getObjSelectedPlant().getIntMaxProductsProduced());
            objShopGUI.setSeedCost("" + objModel.getObjSelectedPlant().getFltDiscountSeedCost());
            objShopGUI.setProducePrice("" + objModel.getObjSelectedPlant().getFltIncreasedProducePrice());
            objShopGUI.setHarvestEXP("" + objModel.getObjSelectedPlant().getFltHarvestEXP());
        }

        // If no Plant Selected
        else {

            objShopGUI.setSeedName("");
            objShopGUI.setCropType("");
            objShopGUI.setHarvestTime("");
            objShopGUI.setWaterReq("", "");
            objShopGUI.setFertilizerReq("", "");
            objShopGUI.setRangeProductsProduced("", "");
            objShopGUI.setSeedCost("");
            objShopGUI.setProducePrice("");
            objShopGUI.setHarvestEXP("");
        }
    }



    public void updateEnabledButtons() {

        // Plants
        objShopGUI.setTurnipEnabled(objModel.getObjShop().getPlant("Turnip").
                canPlant(objModel.getObjSelectedTile().getIntStatus(),
                    objModel.getObjFarmer().getFltObjectCoins(),
                    objModel.getObjSelectedTile().getIntRowCoord(),
                    objModel.getObjSelectedTile().getIntColCoord(),
                    objModel.getObjBoard().getArrObjTile()));
        objShopGUI.setCarrotEnabled(objModel.getObjShop().getPlant("Carrot").
                canPlant(objModel.getObjSelectedTile().getIntStatus(),
                    objModel.getObjFarmer().getFltObjectCoins(),
                    objModel.getObjSelectedTile().getIntRowCoord(),
                    objModel.getObjSelectedTile().getIntColCoord(),
                    objModel.getObjBoard().getArrObjTile()));
        objShopGUI.setPotatoEnabled(objModel.getObjShop().getPlant("Potato").
                canPlant(objModel.getObjSelectedTile().getIntStatus(),
                    objModel.getObjFarmer().getFltObjectCoins(),
                    objModel.getObjSelectedTile().getIntRowCoord(),
                    objModel.getObjSelectedTile().getIntColCoord(),
                    objModel.getObjBoard().getArrObjTile()));
        objShopGUI.setRoseEnabled(objModel.getObjShop().getPlant("Rose").
                canPlant(objModel.getObjSelectedTile().getIntStatus(),
                    objModel.getObjFarmer().getFltObjectCoins(),
                    objModel.getObjSelectedTile().getIntRowCoord(),
                    objModel.getObjSelectedTile().getIntColCoord(),
                    objModel.getObjBoard().getArrObjTile()));
        objShopGUI.setTulipEnabled(objModel.getObjShop().getPlant("Tulip").
                canPlant(objModel.getObjSelectedTile().getIntStatus(),
                    objModel.getObjFarmer().getFltObjectCoins(),
                    objModel.getObjSelectedTile().getIntRowCoord(),
                    objModel.getObjSelectedTile().getIntColCoord(),
                    objModel.getObjBoard().getArrObjTile()));
        objShopGUI.setSunflowerEnabled(objModel.getObjShop().getPlant("Sunflower").
                canPlant(objModel.getObjSelectedTile().getIntStatus(),
                    objModel.getObjFarmer().getFltObjectCoins(),
                    objModel.getObjSelectedTile().getIntRowCoord(),
                    objModel.getObjSelectedTile().getIntColCoord(),
                    objModel.getObjBoard().getArrObjTile()));
        objShopGUI.setMangoEnabled(objModel.getObjShop().getPlant("Mango").
                canPlant(objModel.getObjSelectedTile().getIntStatus(),
                    objModel.getObjFarmer().getFltObjectCoins(),
                    objModel.getObjSelectedTile().getIntRowCoord(),
                    objModel.getObjSelectedTile().getIntColCoord(),
                    objModel.getObjBoard().getArrObjTile()));
        objShopGUI.setAppleEnabled(objModel.getObjShop().getPlant("Apple").
                canPlant(objModel.getObjSelectedTile().getIntStatus(),
                    objModel.getObjFarmer().getFltObjectCoins(),
                    objModel.getObjSelectedTile().getIntRowCoord(),
                    objModel.getObjSelectedTile().getIntColCoord(),
                    objModel.getObjBoard().getArrObjTile()));

        // Actions
        objShopGUI.setPlantEnabled(objModel.getObjSelectedPlant() != null);
        objShopGUI.setCancelEnabled(true);
    }





    /* ----- ----- Method Overrides ----- ----- */



    /* ----- ActionListener Methods ----- */

    @Override
    public void actionPerformed(ActionEvent e) {

        // Get the Action Command
        switch (e.getActionCommand()) {

            case "Turnip":
                objModel.setObjSelectedPlant(objModel.getObjShop().
                        getPlant("Turnip"));
                break;

            case "Carrot":
                objModel.setObjSelectedPlant(objModel.getObjShop().
                        getPlant("Carrot"));
                break;

            case "Potato":
                objModel.setObjSelectedPlant(objModel.getObjShop().
                        getPlant("Potato"));
                break;

            case "Rose":
                objModel.setObjSelectedPlant(objModel.getObjShop().
                        getPlant("Rose"));
                break;

            case "Tulip":
                objModel.setObjSelectedPlant(objModel.getObjShop().
                        getPlant("Tulip"));
                break;

            case "Sunflower":
                objModel.setObjSelectedPlant(objModel.getObjShop().
                        getPlant("Sunflower"));
                break;

            case "Mango":
                objModel.setObjSelectedPlant(objModel.getObjShop().
                        getPlant("Mango"));
                break;

            case "Apple":
                objModel.setObjSelectedPlant(objModel.getObjShop().
                        getPlant("Apple"));
                break;

            case "Plant":
                objModel.getObjSelectedTile().plantSeed(objModel.getObjSelectedPlant(),
                        objModel.getObjFarmer(),
                        objModel.getObjBoard().getArrObjTile());
                objShopGUI.dispose();
                objFarmGUI.setEnabled(true);
                objFarmGUI.repaint();
                objFarmGUI.requestFocus();
                break;

            case "Cancel":
                objShopGUI.dispose();
                objFarmGUI.setEnabled(true);
                objFarmGUI.requestFocus();
                break;
        }

        // Update GUI
        this.updateView();
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
