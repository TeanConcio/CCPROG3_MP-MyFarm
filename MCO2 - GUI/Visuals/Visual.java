package Visuals;

import Model.Board;
import Model.Farmer;
import Model.Plants.Shop;
import Model.Tile;
import Model.Titles.FarmerTitle;
import Model.Titles.TitleList;

public class Visual {

    /**
     * displayFarmerStatus
     * - This method displays the status of the player.
     *
     * @param objPlayer The player in question.
     */
    public void displayFarmerStatus(Farmer objPlayer) {

        System.out.println("Model.Farmer Stats:");
        System.out.printf("Lv %d (EXP: %.1f)\n", (int) (objPlayer.getFltEXP() / 100), objPlayer.getFltEXP());
        System.out.println("Title: " + objPlayer.getObjCurrentTitle().getStrFarmerTitle());
        System.out.printf("%.2f Object Coins\n", objPlayer.getFltObjectCoins());
    }

    /**
     * displayBoard
     * - This method displays the board with a chess-like coordinate system.
     *
     * @param objBoard Model.Board to display.
     */
    public void displayBoard(Board objBoard) {

        System.out.println("\nFarm Model.Board:");
        System.out.println("      A   B   C   D   E");
        System.out.println("   -----------------------");

        for (int i = 0; i < objBoard.ROW; i++) {

            System.out.printf("%2d | ", (i + 1));

            for (int j = 0; j < objBoard.COLUMN; j++)

                System.out.printf("[%s] ", objBoard.getArrObjTile()[i][j].getTileStatusString(true));

            System.out.printf("| %2d\n", (i + 1));
        }

        System.out.println("      A   B   C   D   E");
        System.out.println("   -----------------------");
    }

    // Display next Model.Farmer Title Details
    public void displayNextTitlePerks(TitleList objTitleList,
                                      Farmer objPlayer) {

        System.out.println("\nYou can advance to the next Model.Farmer Title!\n");

        FarmerTitle objNextTitle = objTitleList.getNextTitle(objPlayer.getObjCurrentTitle());

        System.out.println("Next Title: " + objNextTitle.getStrFarmerTitle());
        System.out.println("\tLevel Requirement: " + (int)(objNextTitle.getFltEXPReq() / 100));
        System.out.printf("\tRegistration Fee: %.2f\n", objNextTitle.getFltRegistrationFee());
        System.out.printf("\tSeed Discount: %.2f\n", objNextTitle.getFltSeedDiscount());
        System.out.printf("\tEarning Bonus: %.2f\n", objNextTitle.getFltEarningBonus());
    }

    /**
     * displayTileStatus
     * - This method displays the status of the tile.
     *
     * @param objTile The tile in question.
     */
    public void displayTileStatus(Tile objTile) {

        String strCoordinate;

        strCoordinate = Character.toString(convertNumberToLetter(objTile.getIntColCoord()));
        strCoordinate = strCoordinate.concat(Integer.toString(objTile.getIntRowCoord() + 1));
        System.out.println("\nModel.Tile " + strCoordinate + " :");

        System.out.println("\tStatus: " + objTile.getTileStatusString(false));

        // If Model.Tile has Model.Plants.Plant
        if (objTile.getObjPlant() != null) {

            System.out.print("\tModel.Plants.Plant: " + objTile.getObjPlant().getStrSeedName() + " - ");
            System.out.println(objTile.getIntPlantAge() + " days old");
            System.out.println("\tDays before Harvest: " +
                              (objTile.getObjPlant().getIntHarvestTime() - objTile.getIntPlantAge()));
            System.out.println("\tWatered " + objTile.getIntTimesWatered() + " times");
            System.out.println("\tFertilized " + objTile.getIntTimesFertilized() + " times");
        }

        System.out.println();
    }

    /**
     * convertNumberToLetter
     * - This method converts an integer to a corresponding character
     *
     * @param intNumber The number being converted.
     *
     * @return The uppercase letter equivalent of the number.
     */
    public char convertNumberToLetter(int intNumber) {
        return (char) (intNumber + 65);
    }

    /**
     * displayOptions
     * - This method displays the available things to do on a tile
     *
     * @param objTile The tile in question.
     */
    public void displayActionOptions(Farmer objPlayer,
                                     Tile objTile) {

        System.out.println("What will you do to the tile?");
        System.out.println("Options:");

        // If can use Pickaxe on Model.Tile
        if (objPlayer.getObjPickaxe().canUseTool(objTile, objPlayer.getFltObjectCoins()))
            System.out.println("\tPickaxe - " + objPlayer.getObjPickaxe().getFltUseCost() + " Object Coins");

        // If Model.Tile can be Plowed
        if (objPlayer.getObjPlow().canUseTool(objTile, objPlayer.getFltObjectCoins()))
            System.out.println("\tPlow");

        // If Model.Tile can be Planted
        if (objTile.getIntStatus() == Tile.PLOWED)
            System.out.println("\tModel.Plants.Plant");

        // If Model.Tile can be Watered
        if (objPlayer.getObjWateringCan().canUseTool(objTile, objPlayer.getFltObjectCoins()))
            System.out.println("\tWater");

        // If Model.Tile can be Fertilized
        if (objPlayer.getObjFertilizer().canUseTool(objTile, objPlayer.getFltObjectCoins()))
            System.out.println("\tFertilize - " + objPlayer.getObjFertilizer().getFltUseCost() + " Object Coins");

        // If Model.Tile is Harvestable
        if (objTile.getIntStatus() == Tile.HARVESTABLE)
            System.out.println("\tHarvest");

        // If can use Shovel on Model.Tile
        if (objPlayer.getObjShovel().canUseTool(objTile, objPlayer.getFltObjectCoins()))
            System.out.println("\tShovel - " + objPlayer.getObjShovel().getFltUseCost() + " Object Coins");
    }

    /**
     * displayShopItems
     * - This method prints all available seeds to plant
     *
     * @param objShop The list of all available seeds.
     */
    public void displayShopItems(Farmer objPlayer,
                                 Shop objShop) {

        System.out.printf("\nAvailable Seeds :\n");

        for (int i = 0; i < objShop.getArrObjPlants().size(); i++) {

            // If Doesn't have enough Object Coins for Model.Plants.Plant
            if (objPlayer.getFltObjectCoins() < objShop.getObjPlant(i).getFltDiscountSeedCost())
                continue;

            // Print Seed Details
            System.out.printf("  [%d] : %s\n", i+1, objShop.getObjPlant(i).getStrSeedName());
            System.out.printf("    - Seed Cost : %.2f\n", objShop.getObjPlant(i).getFltDiscountSeedCost());
            System.out.printf("    - Harvest Time : %d\n", objShop.getObjPlant(i).getIntHarvestTime());
            System.out.printf("    - Produce Value : %.2f\n", objShop.getObjPlant(i).getFltIncreasedProducePrice());
            System.out.printf("    - Water Requirement : %d (%d)\n", objShop.getObjPlant(i).getIntWaterReq(),
                    objShop.getObjPlant(i).getIntWaterLimit());
            System.out.printf("    - Fertilizer Requirement : %d (%d)\n", objShop.getObjPlant(i).getIntFertilizerReq(),
                    objShop.getObjPlant(i).getIntFertilizerLimit());
        }
    }

    /**
     * displayEndScreen
     * - This method displays the status of the farmer along with a special message.
     *
     * @param objFarmer The farmer in question.
     * @param intDay The current day number of the game.
     */
    public void displayEndScreen(Farmer objFarmer,
                                 int intDay) {
        System.out.println("Model.Farmer fell to the throes of capitalism in Day " + intDay + "\n");

        // TODO Fix Comments
        displayFarmerStatus(objFarmer);

        System.out.println("\nThe farmer gave up, life is meaningless, why even farm.");
        System.out.println("The farmer now plays League of Legends instead.");
        System.out.println("The farmer is now hardstuck in Bronze I. The farmer is at their promos.");
        System.out.println("Spoiler alert, the farmer didn't make it.");
    }
}
