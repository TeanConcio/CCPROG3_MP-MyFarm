public class Plant {

    /* ----- ----- ----- Plant Attributes ----- ----- ----- */

    public final static int VEGETABLE = 0;
    public final static int FLOWER = 1;
    public final static int FRUIT_TREE = 2;

    private String strSeedName;
    private int intCropType;
    private int intHarvestTime;
    private int intWaterReq;
    private int intWaterLimit;
    private int intFertilizerReq;
    private int intFertilizerLimit;
    private int intHarvestEXP;
    private int intHarvestCost;
    private int intProduceProduced;
    private int intSeedCost;
    private int intBaseProducePrice;





    /* ----- ----- ----- Plant Constructor ----- ----- ----- */

    public Plant (String strSeedName,
                  int intCropType,
                  int intHarvestTime,
                  int intWaterReq,
                  int intWaterLimit,
                  int intFertilizerReq,
                  int intFertilizerLimit,
                  int intHarvestEXP,
                  int intHarvestCost,
                  int intProduceProduced,
                  int intSeedCost,
                  int intBaseProducePrice) {

        this.strSeedName = strSeedName;
        this.intCropType = intCropType;
        this.intHarvestTime = intHarvestTime;
        this.intWaterReq = intWaterReq;
        this.intWaterLimit = intWaterLimit;
        this.intFertilizerReq = intFertilizerReq;
        this.intFertilizerLimit = intFertilizerLimit;
        this.intHarvestEXP = intHarvestEXP;
        this.intHarvestCost = intHarvestCost;
        this.intProduceProduced = intProduceProduced;
        this.intSeedCost = intSeedCost;
        this.intBaseProducePrice = intBaseProducePrice;
    }





    /* ----- ----- ----- Plant Methods ----- ----- ----- */

    public int computeProducePrice (String strFarmerTitle,
                                    int intFarmerLevel,
                                    int intTimesWatered,
                                    int intTimesFertilized) {

        int intTitleBonus;
        float fltWaterBonus;
        float fltFertilizerBonus;
        float fltCropBonus;

        // Get Title Bonus
        switch (strFarmerTitle) {

            case "Registered Farmer":
                intTitleBonus = 2;
                break;

            case "Distinguished Farmer":
                intTitleBonus = 3;
                break;

            case "Honorable Farmer":
                intTitleBonus = 5;
                break;

            default:
                intTitleBonus = 0;
                break;
        }

        // Calculate Water Bonus
        if (intTimesWatered > intWaterLimit)
            fltWaterBonus = intWaterLimit * 0.25f * intBaseProducePrice;
        else
            fltWaterBonus = intTimesWatered * 0.25f * intBaseProducePrice;

        // Calculate Fertilizer Bonus
        if (intTimesFertilized > intFertilizerLimit)
            fltFertilizerBonus = intFertilizerLimit * 0.50f *
                    intBaseProducePrice;
        else
            fltFertilizerBonus = intTimesFertilized * 0.50f *
                    intBaseProducePrice;

        // Calculate Crop Bonus
        if (intCropType == Plant.FLOWER)
            fltCropBonus = 0.05f * (fltWaterBonus + fltFertilizerBonus +
                    intBaseProducePrice);
        else
            fltCropBonus = 0;

        // Calculate Produce Price
        return (int) (intTitleBonus + intFarmerLevel + intBaseProducePrice +
                fltWaterBonus + fltFertilizerBonus + fltCropBonus);
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

    public int getIntHarvestEXP() {return intHarvestEXP;}
    public void setIntHarvestEXP(int intHarvestEXP) {this.intHarvestEXP = intHarvestEXP;}

    public int getIntHarvestCost() {return intHarvestCost;}
    public void setIntHarvestCost(int intHarvestCost) {this.intHarvestCost = intHarvestCost;}

    public int getIntProduceProduced() {return intProduceProduced;}
    public void setIntProduceProduced(int intProduceProduced) {this.intProduceProduced = intProduceProduced;}

    public int getIntSeedCost() {return intSeedCost;}
    public void setIntSeedCost(int intSeedCost) {this.intSeedCost = intSeedCost;}

    public int getIntBaseProducePrice() {return intBaseProducePrice;}
    public void setIntBaseProducePrice(int intBaseProducePrice) {this.intBaseProducePrice = intBaseProducePrice;}
}
