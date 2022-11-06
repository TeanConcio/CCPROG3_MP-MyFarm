public class Tile {

    /* ----- ----- ----- Tile Attributes ----- ----- ----- */

    // Constants
    public static final int ROCK = 0;
    public static final int UNPLOWED = 1;
    public static final int PLOWED = 2;
    public static final int OCCUPIED = 3;
    public static final int HARVESTABLE = 4;
    public static final int WITHERED = 5;

    // Attributes
    private int intRowCoord;
    private int intColCoord;
    private int intStatus;
    private int intTimesWatered;
    private boolean boolWateredToday;
    private int intTimesFertilized;
    private boolean boolFertilizedToday;
    private Plant objPlant;
    private int intPlantAge;





    /* ----- ----- ----- Tile Constructor ----- ----- ----- */

    /**
     * Tile Constructor
     * - This constructor creates a Tile object.
     *
     * @param intRowCoord Row coordinate of the Tile.
     * @param intColCoord Column coordinate of the Tile.
     * @param intStatus Status of the Tile.
     */
    public Tile (int intRowCoord,
                 int intColCoord,
                 int intStatus) {

        this.intRowCoord = intRowCoord;
        this.intColCoord = intColCoord;
        this.intStatus = intStatus;
        this.intTimesWatered = 0;
        this.boolWateredToday = false;
        this.intTimesFertilized = 0;
        this.boolFertilizedToday = false;
        this.objPlant = null;
        this.intPlantAge = 0;
    }





    /* ----- ----- ----- Tile Methods ----- ----- ----- */

    /**
     * resetTile
     * - Resets the Tile to the specified status.
     *
     * @param intStatus Status to reset the Tile to.
     */
    public void resetTile (int intStatus) {

        this.intStatus = intStatus;
        this.intTimesWatered = 0;
        this.boolWateredToday = false;
        this.intTimesFertilized = 0;
        this.boolFertilizedToday = false;
        this.objPlant = null;
        this.intPlantAge = 0;
    }



    /**
     * updateTile
     * - Updates the Tile's Plant related statuses for advancing days.
     */
    public void updateTile () {

        // Reset Watered and Fertilized Today
        boolWateredToday = false;
        boolFertilizedToday = false;

        // If Tile has no Plant
        if (objPlant == null)
            return;

        // Increment Plant Age
        intPlantAge++;

        // If Plant is ready to Harvest
        if (intPlantAge == objPlant.getIntHarvestTime()) {

            // If Plant's Conditions are Met
            if (intTimesWatered >= objPlant.getIntWaterReq() &&
                    intTimesFertilized >= objPlant.getIntFertilizerReq()) {

                // Set Tile Status to Harvestable
                intStatus = HARVESTABLE;
            }

            // Else Plant's Conditions are not Met
            else {

                // Reset and Set Tile Status to Withered
                resetTile(WITHERED);
            }
        }

        // If Plant is pass its Harvest Day
        else if (intPlantAge == objPlant.getIntHarvestTime() + 1) {

            // Reset and Set Tile Status to Withered
            resetTile(WITHERED);
        }
    }



    /**
     * plantSeed
     * - Sets the Tile's Plant.
     *
     * @param objSeed Plant to set the Tile's Plant to.
     * @param objPlayer Player who is planting the Seed.
     * @param arrobjBoard Board the Tile is on.
     *
     * @return True if Plant was set, False otherwise.
     */
    public boolean plantSeed (Plant objSeed,
                              Farmer objPlayer,
                              Tile[][] arrobjBoard) {

        // If Player has not enough Objectcions to plant Seed
        if (objPlayer.getFltObjectCoins() < objSeed.getFltDiscountSeedCost())
            return false;

        // If Tile is Not Plowed
        if (intStatus != PLOWED)
            return false;
        
        // If Plant is a Tree
        if (objSeed.getIntCropType() == Plant.TREE) {

            // If Tile is at the Edge of the Board
            if (intRowCoord == 0 || intRowCoord == Board.ROW - 1 ||
                    intColCoord == 0 || intColCoord == Board.COLUMN - 1)
                return false;

            // For each Tile in a 3x3 Square
            for (int i = intRowCoord-1; i <= intRowCoord+1; i++) {

                for (int j = intColCoord-1; j <= intColCoord+1; j++) {

                    // If Tile is Not Unplowed or Plowed (Occupied by something)
                    if (arrobjBoard[i][j].getIntStatus() != UNPLOWED &&
                            arrobjBoard[i][j].getIntStatus() != PLOWED)
                        return false;
                }
            }
        }

        // Set Tile Status to Occupied
        intStatus = Tile.OCCUPIED;

        // Set Plant
        objPlant = objSeed;

        // Use Objectcoins
        objPlayer.setFltObjectCoins(objPlayer.getFltObjectCoins() - objPlant.getFltDiscountSeedCost());

        return true;
    }



    public String getTileStatusString(boolean boolGetCharNotWord) {

        switch (intStatus) {

            case ROCK:
                if (boolGetCharNotWord)
                    return "R";
                else
                    return "Rock";

            case UNPLOWED:
                if (boolGetCharNotWord)
                    return "U";
                else
                    return "Unplowed";

            case PLOWED:
                if (boolGetCharNotWord)
                    return "P";
                else
                    return "Plowed";

            case OCCUPIED:
                if (boolGetCharNotWord)
                    return "O";
                else
                    return "Occupied";

            case HARVESTABLE:
                if (boolGetCharNotWord)
                    return "H";
                else
                    return "Harvestable";

            case WITHERED:
                if (boolGetCharNotWord)
                    return "W";
                else
                    return "Withered";
        }

        return "Error";
    }





    /* ----- ----- ----- Getters and Setters ----- ----- ----- */

    public int getIntRowCoord() {return intRowCoord;}
    public void setIntRowCoord(int intRowCoord) {this.intRowCoord = intRowCoord;}

    public int getIntColCoord() {return intColCoord;}
    public void setIntColCoord(int intColCoord) {this.intColCoord = intColCoord;}

    public int getIntStatus() {return intStatus;}
    public void setIntStatus(int intStatus) {this.intStatus = intStatus;}

    public int getIntTimesWatered() {return intTimesWatered;}
    public void setIntTimesWatered(int intTimesWatered) {this.intTimesWatered = intTimesWatered;}

    public boolean isBoolWateredToday() {return boolWateredToday;}
    public void setBoolWateredToday(boolean boolWateredToday) {this.boolWateredToday = boolWateredToday;}

    public int getIntTimesFertilized() {return intTimesFertilized;}
    public void setIntTimesFertilized(int intTimesFertilized) {this.intTimesFertilized = intTimesFertilized;}

    public boolean isBoolFertilizedToday() {return boolFertilizedToday;}
    public void setBoolFertilizedToday(boolean boolFertilizedToday) {this.boolFertilizedToday = boolFertilizedToday;}

    public Plant getObjPlant() {return objPlant;}
    public void setObjPlant(Plant objPlant) {this.objPlant = objPlant;}

    public int getIntPlantAge() {return intPlantAge;}
    public void setIntPlantAge(int intPlantAge) {this.intPlantAge = intPlantAge;}
}
