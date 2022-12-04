package Model;

import Model.Plants.Plant;

public class Tile {

    /* ----- ----- ----- Model.Tile Attributes ----- ----- ----- */

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
    private int intTimesFertilized;
    private Plant objPlant;
    private int intPlantAge;





    /* ----- ----- ----- Model.Tile Constructor ----- ----- ----- */

    /**
     * Model.Tile Constructor
     * - This constructor creates a Model.Tile object.
     *
     * @param intRowCoord Row coordinate of the Model.Tile.
     * @param intColCoord Column coordinate of the Model.Tile.
     * @param intStatus Status of the Model.Tile.
     */
    public Tile (int intRowCoord,
                 int intColCoord,
                 int intStatus) {

        this.intRowCoord = intRowCoord;
        this.intColCoord = intColCoord;
        this.intStatus = intStatus;
        this.intTimesWatered = 0;
        this.intTimesFertilized = 0;
        this.objPlant = null;
        this.intPlantAge = 0;
    }





    /* ----- ----- ----- Model.Tile Methods ----- ----- ----- */

    /**
     * resetTile
     * - Resets the Model.Tile to the specified status.
     *
     * @param intStatus Status to reset the Model.Tile to.
     */
    public void resetTile (int intStatus) {

        this.intStatus = intStatus;
        this.intTimesWatered = 0;
        this.intTimesFertilized = 0;
        this.objPlant = null;
        this.intPlantAge = 0;
    }



    /**
     * updateTile
     * - Updates the Model.Tile's Model.Plants.Plant related statuses for advancing days.
     */
    public void updateTile () {

        // If Model.Tile has no Model.Plants.Plant
        if (objPlant == null)
            return;

        // Increment Model.Plants.Plant Age
        intPlantAge++;

        // If Model.Plants.Plant is ready to Harvest
        if (intPlantAge == objPlant.getIntHarvestTime()) {

            // If Model.Plants.Plant's Conditions are Met
            if (intTimesWatered >= objPlant.getIntWaterReq() &&
                    intTimesFertilized >= objPlant.getIntFertilizerReq()) {

                // Set Model.Tile Status to Harvestable
                intStatus = HARVESTABLE;
            }

            // Else Model.Plants.Plant's Conditions are not Met
            else {

                // Reset and Set Model.Tile Status to Withered
                resetTile(WITHERED);
            }
        }

        // If Model.Plants.Plant is pass its Harvest Day
        else if (intPlantAge == objPlant.getIntHarvestTime() + 1) {

            // Reset and Set Model.Tile Status to Withered
            resetTile(WITHERED);
        }
    }



    /**
     * plantSeed
     * - Sets the Model.Tile's Model.Plants.Plant.
     *
     * @param objSeed Model.Plants.Plant to set the Model.Tile's Model.Plants.Plant to.
     * @param objPlayer Player who is planting the Seed.
     * @param arrobjBoard Model.Board the Model.Tile is on.
     */
    public void plantSeed (Plant objSeed,
                           Farmer objPlayer,
                           Tile[][] arrobjBoard) {

        // If Plant cannot be planted on Tile
        if (!objSeed.canPlant(intStatus, objPlayer.getFltObjectCoins(),
                intRowCoord, intColCoord, arrobjBoard))
            return;

        // Set Model.Tile Status to Occupied
        intStatus = Tile.OCCUPIED;

        // Set Model.Plants.Plant
        objPlant = objSeed;

        // Use Objectcoins
        objPlayer.setFltObjectCoins(objPlayer.getFltObjectCoins() - objPlant.getFltDiscountSeedCost());
    }


    /**
     * getTileStatusString
     * - Returns the Model.Tile's Status as a String or Character.
     *
     * @param boolGetCharNotWord True to get the Character, False to get the String.
     */
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

    public int getIntTimesFertilized() {return intTimesFertilized;}
    public void setIntTimesFertilized(int intTimesFertilized) {this.intTimesFertilized = intTimesFertilized;}

    public Plant getObjPlant() {return objPlant;}
    public void setObjPlant(Plant objPlant) {this.objPlant = objPlant;}

    public int getIntPlantAge() {return intPlantAge;}
    public void setIntPlantAge(int intPlantAge) {this.intPlantAge = intPlantAge;}
}
