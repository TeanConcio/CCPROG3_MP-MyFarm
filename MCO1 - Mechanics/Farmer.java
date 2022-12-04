public class Farmer {

    /* ----- ----- ----- Farmer Attributes ----- ----- ----- */
    private FarmerTitle objCurrentTitle;
    private float fltEXP;
    private float fltObjectCoins;

    private final Tool objWateringCan = new Tool("Watering Can", 0f, 0.5f);
    private final Tool objPlow = new Tool("Plow", 0f, 0.5f);
    private final Tool objShovel = new Tool("Shovel", 7f, 2f);
    private final Tool objPickaxe = new Tool ("Pickaxe", 50f, 15f);
    private final Tool objFertilizer = new Tool ("Fertilizer", 10f, 4f);





    /* ----- ----- ----- Farmer Constructor ----- ----- ----- */

    /**
     * Farmer Constructor
     * - Creates a new Farm object.
     *
     * @param objCurrentTitle Current FarmerTitle of the Farmer.
     */
    public Farmer(FarmerTitle objCurrentTitle) {
         this.objCurrentTitle = objCurrentTitle;
         this.fltEXP = 0f;
         this.fltObjectCoins = 100f;
    }





    /* ----- ----- ----- Farmer Methods ----- ----- ----- */

    /**
     * harvestCrop
     * - This method is called when the Farmer harvests a crop.
     *
     * @param objTile Tile to harvest the crop from.
     */
    public void harvestCrop (Tile objTile, int intProductsProduced) {

        //adds object coins based on the plant on the tile
        fltObjectCoins += objTile.computeHarvestProfit(intProductsProduced, objCurrentTitle);

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
