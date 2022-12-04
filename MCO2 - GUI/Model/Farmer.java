package Model;

import Model.Plants.Shop;
import Model.Titles.FarmerTitle;
import Model.Titles.TitleList;
import Model.Tools.*;

public class Farmer {

    /* ----- ----- ----- Model.Farmer Attributes ----- ----- ----- */
    private FarmerTitle objCurrentTitle;
    private float fltEXP;
    private float fltObjectCoins;

    private final Tool objWateringCan = new WateringCan();
    private final Tool objPlow = new Plow();
    private final Tool objShovel = new Shovel();
    private final Tool objPickaxe = new Pickaxe();
    private final Tool objFertilizer = new Fertilizer();





    /* ----- ----- ----- Model.Farmer Constructor ----- ----- ----- */

    /**
     * Model.Farmer Constructor
     * - Creates a new Farm object.
     *
     * @param objCurrentTitle Current Model.Titles.FarmerTitle of the Model.Farmer.
     */
    public Farmer(FarmerTitle objCurrentTitle) {
         this.objCurrentTitle = objCurrentTitle;
         this.fltEXP = 0f;
         this.fltObjectCoins = 100f;
    }





    /* ----- ----- ----- Model.Farmer Methods ----- ----- ----- */

    /**
     * harvestCrop
     * - This method is called when the Model.Farmer harvests a crop.
     *
     * @param objTile Model.Tile to harvest the crop from.
     */
    public void harvestCrop (Tile objTile,
                             float fltHarvestProfit) {

        //adds object coins based on the plant on the tile
        fltObjectCoins += fltHarvestProfit;

        //adds exp based on the plant on the tile
        fltEXP += objTile.getObjPlant().getFltHarvestEXP();

        //removes the plant from the tile
        objTile.resetTile(Tile.UNPLOWED);
    }



    /**
     * canRegisterNextTitle
     * - Returns true if the farmer can register for the next title.
     *
     * @param objTitleList List of Titles object.
     *
     * @return True if the farmer can register for the next title. False otherwise.
     */
    public boolean canRegisterNextTitle (TitleList objTitleList) {

        FarmerTitle objNextTitle = objTitleList.getNextTitle(this.objCurrentTitle);

        // If the next title is null, then the farmer has reached the max title
        if (objNextTitle == null)
            return false;

        // If the player has enough Objectcoins and EXP to register the next title
        if (this.getFltEXP() >= objNextTitle.getFltEXPReq() &&
                this.getFltObjectCoins() >= objNextTitle.getFltRegistrationFee())
            return true;

        return false;
    }



    /**
     * registerNextTitle
     * - Registers the next title for the farmer.
     *
     * @param objTitleList List of Titles object.
     */
    public void registerNextTitle (TitleList objTitleList, Shop objShop) {

        // If the player cannot register the next title
        if (!canRegisterNextTitle(objTitleList))
            return;

        // Decrease Objectcoins
        this.setFltObjectCoins(this.getFltObjectCoins() - objTitleList.getNextTitle(this.objCurrentTitle).getFltRegistrationFee());

        // Register the next title
        this.objCurrentTitle = objTitleList.getNextTitle(objCurrentTitle);

        // Update the shop prices
        objShop.updateShop(this.getObjCurrentTitle());
    }





    /* ----- ----- ----- Getters and Setters ----- ----- ----- */

    public FarmerTitle getObjCurrentTitle() {return objCurrentTitle;}
    public void setObjCurrentTitle(FarmerTitle objCurrentTitle) {this.objCurrentTitle = objCurrentTitle;}

    public float getFltEXP() {return fltEXP;}
    public void setFltEXP(float fltEXP) {this.fltEXP = fltEXP;}

    public float getFltObjectCoins() {return fltObjectCoins;}
    public void setFltObjectCoins(float fltObjectCoins) {this.fltObjectCoins = fltObjectCoins;}

    public Tool getObjWateringCan() {return objWateringCan;}

    public Tool getObjPlow() {return objPlow;}

    public Tool getObjShovel() {return objShovel;}

    public Tool getObjPickaxe() {return objPickaxe;}

    public Tool getObjFertilizer() {return objFertilizer;}
}
