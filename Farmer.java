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

    private final FarmerTitle objTier0Title = new FarmerTitle(0, "Farmer", 0, 0, 0, 0, 0, 0f);
    private final FarmerTitle objTier1Title = new FarmerTitle(1, "Registered Farmer", 5, 1, 1, 0, 0, 200f);
    private final FarmerTitle objTier2Title = new FarmerTitle(2, "Distinguished Farmer", 10, 2, 2, 1, 0, 300f);
    private final FarmerTitle objTier3Title = new FarmerTitle(3, "Legendary Farmer", 15, 3, 4, 3, 1, 400f);

    /* ----- ----- ----- Farmer Constructor ----- ----- ----- */

    /**
     * Farmer Constructor
     * - Creates a new Farm object.
     */
    public Farmer() {
         objCurrentTitle = objTier0Title;
         fltEXP = 0;
         fltObjectCoins = 100;
    }

    /* ----- ----- ----- Farmer Methods ----- ----- ----- */

    /**
     * harvestCrop
     * - This method is called when the Farmer harvests a crop.
     *
     * @param objTile Tile to harvest the crop from.
     */
    public void harvestCrop (Tile objTile) {
        //adds object coins based on the plant on the tile
        fltObjectCoins += objTile.getObjPlant().computeProducePrice(objTile.getObjPlant().generateProductsProduced(),
                          objCurrentTitle, objTile.getIntTimesWatered(), objTile.getIntTimesFertilized());

        //removes the plant from the tile
        objTile.resetTile(Tile.UNPLOWED);
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
