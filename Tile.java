public class Tile {

    /* ----- ----- ----- Tile Attributes ----- ----- ----- */

    // Constants
    public static final int ROCK = 0 ;
    public static final int UNPLOWED = 1;
    public static final int PLOWED = 2;
    public static final int OCCUPIED = 3;
    public static final int HARVESTABLE = 4;
    public static final int WITHERED = 5;

    // Attributes
    private int intStatus;
    private int intFertilizedNum;
    private int intWateredNum;
    private boolean boolWateredToday;
    private Plant objPlant;
    private int intPlantAge;





    /* ----- ----- ----- Tile Constructor ----- ----- ----- */
    public Tile (int intStatus) {
        this.intStatus = intStatus;
        this.intFertilizedNum = 0;
        this.intWateredNum = 0;
        this.boolWateredToday = false;
        this.objPlant = null;
        this.intPlantAge = 0;
    }





    /* ----- ----- ----- Tile Methods ----- ----- ----- */

    public void update (String strFarmerTitle) {

        // Reset Watered Today
        boolWateredToday = false;

        // If Tile is Occupied by a Plant
        if (intStatus == OCCUPIED) {

            // Increment Plant Age
            intPlantAge++;
        }


        // Get Crop Harvest Time with Farmer Title Bonus
        int intHarvestTime;
        switch (strFarmerTitle) {

            case "Registered Farmer":
                intHarvestTime = (int)(objPlant.getIntHarvestTime() * 0.95);
                break;

            case "Distinguished Farmer":
                intHarvestTime = (int)(objPlant.getIntHarvestTime() * 0.90);
                break;

            case "Honorable Farmer":
                intHarvestTime = (int)(objPlant.getIntHarvestTime() * 0.85);
                break;

            default:
                intHarvestTime = objPlant.getIntHarvestTime();
                break;
        }

        // If Plant is ready to Harvest
        if (intStatus == OCCUPIED &&
            intPlantAge == intHarvestTime) {

            // Set Tile Status to Harvestable
            intStatus = HARVESTABLE;
        }

        // If Tile is pass harvest time
        if (intStatus == HARVESTABLE &&
            intPlantAge > intHarvestTime) {

            // Set Tile Status to Withered
            intStatus = WITHERED;
        }
    }





    /* ----- ----- ----- Getters and Setters ----- ----- ----- */

    public int getIntStatus() {return intStatus;}
    public void setIntStatus(int intStatus) {this.intStatus = intStatus;}

    public int getIntFertilizedNum() {return intFertilizedNum;}
    public void setIntFertilizedNum(int intFertilizedNum) {this.intFertilizedNum = intFertilizedNum;}

    public int getIntWateredNum() {return intWateredNum;}
    public void setIntWateredNum(int intWateredNum) {this.intWateredNum = intWateredNum;}

    public boolean isBoolWateredToday() {return boolWateredToday;}
    public void setBoolWateredToday(boolean boolWateredToday) {this.boolWateredToday = boolWateredToday;}

    public Plant getObjPlant() {return objPlant;}
    public void setObjPlant(Plant objPlant) {this.objPlant = objPlant;}

    public int getIntPlantAge() {return intPlantAge;}
    public void setIntPlantAge(int intPlantAge) {this.intPlantAge = intPlantAge;}
}
