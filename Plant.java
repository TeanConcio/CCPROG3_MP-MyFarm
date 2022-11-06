public class Plant {

    /* ----- ----- ----- Plant Attributes ----- ----- ----- */

    public final static int ROOT_CROP = 0;
    public final static int FLOWER = 1;
    public final static int TREE = 2;

    private String strSeedName;
    private int intCropType;
    private int intHarvestTime;
    private int intWaterReq;
    private int intWaterLimit;
    private int intFertilizerReq;
    private int intFertilizerLimit;
    private int intMinProductsProduced;
    private int intMaxProductsProduced;
    private float fltSeedCost;
    private int intBaseProducePrice;
    private float fltHarvestEXP;





    /* ----- ----- ----- Plant Constructor ----- ----- ----- */

    /**
     * Plant Constructor
     * - This constructor creates a Plant object.
     *
     * @param strSeedName Name of the seed.
     * @param intCropType Type of crop.
     * @param intHarvestTime Time it takes to harvest the crop.
     * @param intWaterReq Amount of water required to harvest the crop.
     * @param intWaterLimit Limit of the crop's Water Bonus.
     * @param intFertilizerReq Amount of fertilizer required to harvest the crop.
     * @param intFertilizerLimit Limit of the crop's Fertilizer Bonus.
     * @param intMinProductsProduced Minimum amount of products produced in harvest.
     * @param intMaxProductsProduced Maximum amount of products produced in harvest.
     * @param fltSeedCost Cost of the seed.
     * @param intBaseProducePrice Base price per product produced.
     * @param fltHarvestEXP EXP gained from harvesting the crop.
     */
    public Plant (String strSeedName,
                  int intCropType,
                  int intHarvestTime,
                  int intWaterReq,
                  int intWaterLimit,
                  int intFertilizerReq,
                  int intFertilizerLimit,
                  int intMinProductsProduced,
                  int intMaxProductsProduced,
                  float fltSeedCost,
                  int intBaseProducePrice,
                  float fltHarvestEXP) {

        this.strSeedName = strSeedName;
        this.intCropType = intCropType;
        this.intHarvestTime = intHarvestTime;
        this.intWaterReq = intWaterReq;
        this.intWaterLimit = intWaterLimit;
        this.intFertilizerReq = intFertilizerReq;
        this.intFertilizerLimit = intFertilizerLimit;
        this.intMinProductsProduced = intMinProductsProduced;
        this.intMaxProductsProduced = intMaxProductsProduced;
        this.fltSeedCost = fltSeedCost;
        this.intBaseProducePrice = intBaseProducePrice;
        this.fltHarvestEXP = fltHarvestEXP;
    }









    /* ----- ----- ----- Plant Methods ----- ----- ----- */

    /**
     * generateRandomProductsProduced
     * - This method generates a random number of products produced in harvest.
     *
     * @return Number of products produced in harvest.
     */
    public int generateProductsProduced () {
        return (int) (Math.random() * (this.intMaxProductsProduced -
                this.intMinProductsProduced + 1) + this.intMinProductsProduced);
    }



    /**
     * computeProducePrice
     * - Computes the price of the produce based on the base price and the number of products produced.
     *
     * @param intProductsProduced Number of products produced.
     * @param objTitle Title of the farmer.
     * @param intTimesWatered Number of times the plant was watered.
     * @param intTimesFertilized Number of times the plant was fertilized.
     *
     * @return The price of the produce.
     */
    public float computeProducePrice (int intProductsProduced,
                                      FarmerTitle objTitle,
                                      int intTimesWatered,
                                      int intTimesFertilized) {

        float fltHarvestTotal;
        int intNewWaterLimit;
        int intNewFertilizerLimit;
        float fltWaterBonus;
        float fltFertilizerBonus;

        // Get Title Bonus
        fltHarvestTotal = intProductsProduced * (intBaseProducePrice +
                objTitle.getFltEarningBonus());

        // Calculate Water Bonus
        intNewWaterLimit = this.intWaterLimit + objTitle.getIntWaterLimInc();
        if (intTimesWatered > intNewWaterLimit)
            fltWaterBonus = fltHarvestTotal * 0.2f * (intNewWaterLimit - 1);
        else
            fltWaterBonus = fltHarvestTotal * 0.2f * (intTimesWatered - 1);

        // Calculate Fertilizer Bonus
        intNewFertilizerLimit = this.intFertilizerLimit + objTitle.getIntFertLimInc();
        if (intTimesFertilized > intFertilizerLimit)
            fltFertilizerBonus = fltHarvestTotal * 0.5f * (intNewFertilizerLimit - 1);
        else
            fltFertilizerBonus = fltHarvestTotal * 0.5f * (intTimesFertilized - 1);

        // Get Crop Bonus for Flowers
        if (intCropType == Plant.FLOWER)
            return (fltHarvestTotal + fltWaterBonus + fltFertilizerBonus) * 1.1f;
        else
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

    public float getFltSeedCost() {return fltSeedCost;}
    public void setFltSeedCost(float fltSeedCost) {this.fltSeedCost = fltSeedCost;}

    public int getIntBaseProducePrice() {return intBaseProducePrice;}
    public void setIntBaseProducePrice(int intBaseProducePrice) {this.intBaseProducePrice = intBaseProducePrice;}

    public float getFltHarvestEXP() {return fltHarvestEXP;}
    public void setFltHarvestEXP(float fltHarvestEXP) {this.fltHarvestEXP = fltHarvestEXP;}
}
