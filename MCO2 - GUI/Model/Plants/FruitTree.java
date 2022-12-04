package Model.Plants;

import Model.Board;
import Model.Tile;

public class FruitTree extends Plant {

    /* ----- ----- ----- FruitTree Constructor ----- ----- ----- */

    /**
     * FruitTree Constructor
     * - This constructor creates a Fruit Tree object.
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
    public FruitTree(String strSeedName,
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





    /* ----- ----- ----- FruitTree Methods ----- ----- ----- */

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
        if (!super.canPlant(intStatus, fltObjectcoins, intRowCoord, intColCoord, arrobjBoard))
            return false;


        // Check Tile's neighbors

        // If Tile to plant in is at the Edge of the Board
        if (intRowCoord == 0 || intRowCoord == Board.ROW - 1 ||
                intColCoord == 0 || intColCoord == Board.COLUMN - 1)
            return false;

        // For each Tile in a 3x3 Square
        for (int i = intRowCoord-1; i <= intRowCoord+1; i++) {

            for (int j = intColCoord-1; j <= intColCoord+1; j++) {

                // If Tile is Not Unplowed or Plowed (Occupied by something)
                if (arrobjBoard[i][j].getIntStatus() != Tile.UNPLOWED &&
                        arrobjBoard[i][j].getIntStatus() != Tile.PLOWED)
                    return false;
            }
        }


        return true;
    }
}
