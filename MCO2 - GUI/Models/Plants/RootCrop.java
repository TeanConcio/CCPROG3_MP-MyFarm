package Models.Plants;

public class RootCrop extends Plant {

    /* ----- ----- ----- RootCrop Constructor ----- ----- ----- */

    /**
     * RootCrop Constructor
     * - This constructor creates a Root Crop object.
     *
     * @param strSeedName Name of the seed.
     * @param intHarvestTime Time it takes to harvest the crop.
     * @param intWaterReq Amount of water required to harvest the crop.
     * @param intWaterLimit Limit of the crop's Water Bonus.
     * @param intFertilizerReq Amount of fertilizer required to harvest the crop.
     * @param intFertilizerLimit Limit of the crop's Fertilizer Bonus.
     * @param intMinProductsProduced Minimum amount of products produced in harvest.
     * @param intMaxProductsProduced Maximum amount of products produced in harvest.
     * @param fltBaseSeedCost Cost of the seed.
     * @param fltBaseProducePrice Base price per product produced.
     * @param fltHarvestEXP EXP gained from harvesting the crop.
     */
    public RootCrop (String strSeedName,
                   int intHarvestTime,
                   int intWaterReq,
                   int intWaterLimit,
                   int intFertilizerReq,
                   int intFertilizerLimit,
                   int intMinProductsProduced,
                   int intMaxProductsProduced,
                   float fltBaseSeedCost,
                   float fltBaseProducePrice,
                   float fltHarvestEXP) {

        super(strSeedName,
                intHarvestTime,
                intWaterReq,
                intWaterLimit,
                intFertilizerReq,
                intFertilizerLimit,
                intMinProductsProduced,
                intMaxProductsProduced,
                fltBaseSeedCost,
                fltBaseProducePrice,
                fltHarvestEXP);
        
        this.strCropType = "Root Crop";
    }
}
