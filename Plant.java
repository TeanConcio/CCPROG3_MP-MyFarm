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
    private int intSeedCost;
    private int intBaseProducePrice;
    private int intHarvestEXP;





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
     * @param intSeedCost Cost of the seed.
     * @param intBaseProducePrice Base price per product produced.
     * @param intHarvestEXP EXP gained from harvesting the crop.
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
                  int intSeedCost,
                  int intBaseProducePrice,
                  int intHarvestEXP) {

        this.strSeedName = strSeedName;
        this.intCropType = intCropType;
        this.intHarvestTime = intHarvestTime;
        this.intWaterReq = intWaterReq;
        this.intWaterLimit = intWaterLimit;
        this.intFertilizerReq = intFertilizerReq;
        this.intFertilizerLimit = intFertilizerLimit;
        this.intMinProductsProduced = intMinProductsProduced;
        this.intMaxProductsProduced = intMaxProductsProduced;
        this.intSeedCost = intSeedCost;
        this.intBaseProducePrice = intBaseProducePrice;
        this.intHarvestEXP = intHarvestEXP;
    }









    /* ----- ----- ----- Plant Methods ----- ----- ----- */

    /**
     * computeProducePrice
     * - Computes the price of the produce based on the base price and the number of products produced.
     *
     * @param intProductsProduced Number of products produced.
     * @param strFarmerTitle Title of the farmer.
     * @param intTimesWatered Number of times the plant was watered.
     * @param intTimesFertilized Number of times the plant was fertilized.
     *
     * @return The price of the produce.
     */
    public int computeProducePrice (int intProductsProduced,
                                    String strFarmerTitle,
                                    int intTimesWatered,
                                    int intTimesFertilized) {

        int intHarvestTotal;
        float fltWaterBonus;
        float fltFertilizerBonus;

        // Get Title Bonus
        switch (strFarmerTitle) {

            case "Registered Farmer":
                intHarvestTotal = intProductsProduced * (intBaseProducePrice + 1);
                break;

            case "Distinguished Farmer":
                intHarvestTotal = intProductsProduced * (intBaseProducePrice + 2);
                break;

            case "Legendary Farmer":
                intHarvestTotal = intProductsProduced * (intBaseProducePrice + 4);
                break;

            default:
                intHarvestTotal = intProductsProduced * intBaseProducePrice;
                break;
        }

        // Calculate Water Bonus
        if (intTimesWatered > intWaterLimit)
            fltWaterBonus = intHarvestTotal * 0.2f * (intWaterLimit - 1);
        else
            fltWaterBonus = intHarvestTotal * 0.2f * (intTimesWatered - 1);

        // Calculate Fertilizer Bonus
        if (intTimesFertilized > intFertilizerLimit)
            fltFertilizerBonus = intHarvestTotal * 0.5f * (intFertilizerLimit - 1);
        else
            fltFertilizerBonus = intHarvestTotal * 0.5f * (intTimesFertilized - 1);

        // Get Crop Bonus for Flowers
        if (intCropType == Plant.FLOWER)
            return (int) ((intHarvestTotal + fltWaterBonus + fltFertilizerBonus) * 1.1);
        else
            return (int) (intHarvestTotal + fltWaterBonus + fltFertilizerBonus);
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

    public int getIntSeedCost() {return intSeedCost;}
    public void setIntSeedCost(int intSeedCost) {this.intSeedCost = intSeedCost;}

    public int getIntBaseProducePrice() {return intBaseProducePrice;}
    public void setIntBaseProducePrice(int intBaseProducePrice) {this.intBaseProducePrice = intBaseProducePrice;}

    public int getIntHarvestEXP() {return intHarvestEXP;}
    public void setIntHarvestEXP(int intHarvestEXP) {this.intHarvestEXP = intHarvestEXP;}
}
