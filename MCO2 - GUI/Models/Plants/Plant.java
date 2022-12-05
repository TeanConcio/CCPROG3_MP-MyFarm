package Models.Plants;

import Models.Tile;
import Models.Titles.FarmerTitle;

public abstract class Plant {

    /* ----- ----- ----- Plant Attributes ----- ----- ----- */

    protected String strSeedName;
    protected int intCropType;
    protected int intHarvestTime;
    protected int intWaterReq;
    protected int intWaterLimit;
    protected int intFertilizerReq;
    protected int intFertilizerLimit;
    protected int intMinProductsProduced;
    protected int intMaxProductsProduced;
    protected float fltBaseSeedCost;
    protected float fltBaseProducePrice;
    protected float fltHarvestEXP;

    protected float fltDiscountSeedCost;
    protected float fltIncreasedProducePrice;





    /* ----- ----- ----- Plant Constructor ----- ----- ----- */

    /**
     * Plant Constructor
     * - This constructor creates a Plant object.
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
    public Plant (String strSeedName,
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

        this.strSeedName = strSeedName;
        this.intHarvestTime = intHarvestTime;
        this.intWaterReq = intWaterReq;
        this.intWaterLimit = intWaterLimit;
        this.intFertilizerReq = intFertilizerReq;
        this.intFertilizerLimit = intFertilizerLimit;
        this.intMinProductsProduced = intMinProductsProduced;
        this.intMaxProductsProduced = intMaxProductsProduced;
        this.fltBaseSeedCost = fltBaseSeedCost;
        this.fltBaseProducePrice = fltBaseProducePrice;
        this.fltHarvestEXP = fltHarvestEXP;

        this.fltDiscountSeedCost = fltBaseSeedCost;
        this.fltIncreasedProducePrice = fltBaseProducePrice;
    }









    /* ----- ----- ----- Plant Methods ----- ----- ----- */

    /**
     * generateRandomProductsProduced
     * - This method generates a random number of products produced in harvest.
     *
     * @return Number of products produced in harvest.
     */
    public int getProduceQuantity() {
        return (int) (Math.random() * (this.intMaxProductsProduced -
                this.intMinProductsProduced + 1) + this.intMinProductsProduced);
    }


    
    /**
     * updatePricesFromTitle
     * - This method updates the prices of the plant based on the Farmer's Title.
     * 
     * @param objTitle Farmer's Title.
     */
    public void updatePricesFromTitle(FarmerTitle objTitle) {

        this.fltDiscountSeedCost = this.fltBaseSeedCost - objTitle.getFltSeedDiscount();

        this.fltIncreasedProducePrice = this.fltBaseProducePrice + objTitle.getFltEarningBonus();
    }



    /**
     * canPlant
     * - This method checks if the Plant can be placed on a Tile.
     *
     * @param intStatus Status of the Tile.
     * @param fltObjectcoins Player's Objectcoins.
     * @param intRowCoord Row coordinate of the Tile.
     * @param intColCoord Column coordinate of the Tile.
     * @param arrobjBoard Board of Tiles.
     *
     * @return True if the Plant can be placed, false otherwise.
     */
    public boolean canPlant(int intStatus,
                            float fltObjectcoins,
                            int intRowCoord,
                            int intColCoord,
                            Tile[][] arrobjBoard) {

        // If Player has enough Objectcoins and Tile is Plowed
        if (fltObjectcoins >= fltDiscountSeedCost && 
                intStatus == Tile.PLOWED)
            return true;
        
        return false;
    }



    /**
     * computeHarvestProfit
     * - Computes the price of the produce based on the base price and the number of products produced.
     *
     * @param intProductsProduced Number of products produced.
     * @param objTitle Title of the farmer.
     *
     * @return The price of the produce.
     */
    public float computeHarvestProfit (int intProductsProduced,
                                       FarmerTitle objTitle,
                                       int intTimesWatered,
                                       int intTimesFertilized) {

        float fltHarvestTotal;
        int intNewWaterLimit;
        int intNewFertilizerLimit;
        float fltWaterBonus;
        float fltFertilizerBonus;

        
        // Get Title Bonus
        fltHarvestTotal = intProductsProduced * fltIncreasedProducePrice;

        // Calculate Water Bonus
        intNewWaterLimit = intWaterLimit + objTitle.getIntWaterLimInc();
        if (intTimesWatered > intNewWaterLimit)
            fltWaterBonus = fltHarvestTotal * 0.2f * (intNewWaterLimit - 1);
        else
            fltWaterBonus = fltHarvestTotal * 0.2f * (intTimesWatered - 1);

        // Calculate Fertilizer Bonus
        intNewFertilizerLimit = intFertilizerLimit + objTitle.getIntFertLimInc();
        if (intTimesFertilized > intNewFertilizerLimit)
            fltFertilizerBonus = fltHarvestTotal * 0.5f * intNewFertilizerLimit;
        else
            fltFertilizerBonus = fltHarvestTotal * 0.5f * intTimesFertilized;

        
        return (fltHarvestTotal + fltWaterBonus + fltFertilizerBonus);
    }





    /* ----- ----- ----- Plant Getters and Setters ----- ----- ----- */

    public String getStrSeedName() {return strSeedName;}
    public void setStrSeedName(String strSeedName) {this.strSeedName = strSeedName;}

    public int getIntCropType() {return intCropType;}
    public void setIntCropType(int intCropType) {this.intCropType = intCropType;}

    public int getIntHarvestTime() {return intHarvestTime;}
    public void setIntHarvestTime(int intHarvestTime) {this.intHarvestTime = intHarvestTime;}

    public int getIntWaterReq() {return intWaterReq;}
    public void setIntWaterReq(int intWaterReq) {this.intWaterReq = intWaterReq;}

    public int getIntWaterLimit() {return intWaterLimit;}
    public void setIntWaterLimit(int intWaterLimit) {this.intWaterLimit = intWaterLimit;}

    public int getIntFertilizerReq() {return intFertilizerReq;}
    public void setIntFertilizerReq(int intFertilizerReq) {this.intFertilizerReq = intFertilizerReq;}

    public int getIntFertilizerLimit() {return intFertilizerLimit;}
    public void setIntFertilizerLimit(int intFertilizerLimit) {this.intFertilizerLimit = intFertilizerLimit;}

    public int getIntMinProductsProduced() {return intMinProductsProduced;}
    public void setIntMinProductsProduced(int intMinProductsProduced) {this.intMinProductsProduced = intMinProductsProduced;}

    public int getIntMaxProductsProduced() {return intMaxProductsProduced;}
    public void setIntMaxProductsProduced(int intMaxProductsProduced) {this.intMaxProductsProduced = intMaxProductsProduced;}

    public float getFltBaseSeedCost() {return fltBaseSeedCost;}
    public void setFltBaseSeedCost(float fltBaseSeedCost) {this.fltBaseSeedCost = fltBaseSeedCost;}

    public float getFltBaseProducePrice() {return fltBaseProducePrice;}
    public void setFltBaseProducePrice(int fltBaseProducePrice) {this.fltBaseProducePrice = fltBaseProducePrice;}

    public float getFltHarvestEXP() {return fltHarvestEXP;}
    public void setFltHarvestEXP(float fltHarvestEXP) {this.fltHarvestEXP = fltHarvestEXP;}

    public float getFltDiscountSeedCost() {return fltDiscountSeedCost;}
    public void setFltDiscountSeedCost(float fltDiscountSeedCost) {this.fltDiscountSeedCost = fltDiscountSeedCost;}

    public float getFltIncreasedProducePrice() {return fltIncreasedProducePrice;}
    public void setFltIncreasedProducePrice(float fltIncreasedProducePrice) {this.fltIncreasedProducePrice = fltIncreasedProducePrice;}
}
