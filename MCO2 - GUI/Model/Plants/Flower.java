package Model.Plants;

import Model.Titles.FarmerTitle;

public class Flower extends Plant {

    /* ----- ----- ----- Flower Constructor ----- ----- ----- */

    /**
     * Flower Constructor
     * - This constructor creates a Flower object.
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
    public Flower (String strSeedName,
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
    }





    /* ----- ----- ----- Flower Methods ----- ----- ----- */

    /**
     * computeHarvestProfit
     * - Computes the price of the produce based on the base price and the number of products produced.
     *
     * @param intProductsProduced Number of products produced.
     * @param objTitle Title of the farmer.
     *
     * @return The price of the produce.
     */
    @Override
    public float computeHarvestProfit (int intProductsProduced,
                                       FarmerTitle objTitle,
                                       int intTimesWatered,
                                       int intTimesFertilized) {

        // Get Crop Bonus for Flowers
        return super.computeHarvestProfit(intProductsProduced,
                objTitle,
                intTimesWatered,
                intTimesFertilized) * 1.1f;
    }
}
