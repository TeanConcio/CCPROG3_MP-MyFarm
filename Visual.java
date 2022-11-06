public class Visual {

    /**
     * printFarmerStatus
     * - This method displays the status of the player.
     *
     * @param objPlayer The player in question.
     * @param intDay    The current day number of the game.
     * @return True if the conditions were met, False otherwise.
     */
    public void displayFarmerStatus(Farmer objPlayer, int intDay) {

        System.out.println("Day " + intDay + "\n");

        System.out.println("Farmer Stats:");
        System.out.println("Level " + (int) (objPlayer.getFltEXP() / 100));
        System.out.println("Title: " + objPlayer.getObjCurrentTitle().getStrFarmerTitle());
        System.out.println(objPlayer.getFltObjectCoins() + " Object Coins\n");
    }

    /**
     * printTileStatus
     * - This method displays the status of the tile.
     *
     * @param objTile The tile in question.
     * @return True if the conditions were met, False otherwise.
     */
    public void displayTileStatus(Tile objTile) {

        String strCoordinate;
        String strStatus;

        strCoordinate = Character.toString(convertNumberToLetter(objTile.getIntColCoord()));
        strCoordinate = strCoordinate.concat(Integer.toString(objTile.getIntRowCoord() + 1));
        System.out.println("Tile " + strCoordinate + " :");

        System.out.println("Status: " + objTile.getTileStatusString(false));

        if (objTile.getObjPlant() != null) {
            System.out.print("Plant: " + objTile.getObjPlant().getStrSeedName() + " - ");
            System.out.println(objTile.getIntPlantAge() + " days old");
        }

        System.out.println("Watered " + objTile.getIntTimesWatered() + " times");
        System.out.println("Fertilized " + objTile.getIntTimesFertilized() + " times\n");
    }

    /**
     * displayOptions
     * - This method displays the available things to do on a tile
     *
     * @param objTile  The tile in question.
     * @param fltMoney Amount of money currently owned.
     */
    public void displayOptions(Tile objTile, float fltMoney) {

        System.out.println("What will you do to the tile?");
        System.out.println("Options:");

        switch (objTile.getIntStatus()) {
            case Tile.ROCK:
                System.out.println("Pickaxe");
                break;
            case Tile.UNPLOWED:
                System.out.println("Plow");
                break;
            case Tile.PLOWED:
                System.out.println("Plant");
                break;
            case Tile.OCCUPIED:
                System.out.println("Water");
                if (fltMoney >= 10)
                    System.out.println("Fertilize");
                if (fltMoney >= 7)
                    System.out.println("Shovel");
                break;
            case Tile.HARVESTABLE:
                System.out.println("Harvest");
                break;
            case Tile.WITHERED:
                if (fltMoney >= 7)
                    System.out.println("Shovel");
                break;
        }
    }

    /**
     * printBoard
     * - This method displays the board with a chess-like coordinate system.
     *
     * @param objBoard Board to display.
     */
    public void displayBoard(Board objBoard) {

        System.out.println("Farm Board:");
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

    /**
     * printEndScreen
     * - This method displays the status of the farmer along with a special message.
     *
     * @param objFarmer The farmer in question.
     * @param intDay The current day number of the game.
     *
     * @return True if the conditions were met, False otherwise.
     */
    public void displayEndScreen(Farmer objFarmer, int intDay) {
        System.out.println("Farmer fell to the throes of capitalism in day " + intDay + "\n");

        // TODO Fix Comments
        displayFarmerStatus(objFarmer, intDay);

        System.out.println("The farmer gave up, life is meaningless, why even farm.");
        System.out.println("The farmer now plays League of Legends instead.");
        System.out.println("The farmer is now hardstuck in Bronze I. The farmer is at their promos.");
        System.out.println("Spoiler alert, the farmer didn't make it.");
    }

    /**
     * numberToLetter
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
     * printShopItems
     * - This method prints all available seeds to plant
     *
     * @param objShop The list of all available seeds.
     */
    public void printShopItems(Shop objShop) {

        System.out.printf("Seeds (%d) :\n", objShop.getArrObjPlants().size());

        for (int i = 0; i < objShop.getArrObjPlants().size(); i++) {

            System.out.printf("  [%d] : %s\n", i+1, objShop.getObjPlant(i).getStrSeedName());
            System.out.printf("    - Seed Cost : %.2f\n", objShop.getObjPlant(i).getFltDiscountSeedCost());
            System.out.printf("    - Harvest Time : %d\n", objShop.getObjPlant(i).getIntHarvestTime());
            System.out.printf("    - Produce Value : %.2f\n", objShop.getObjPlant(i).getFltIncreasedProducePrice());
        }
    }
}
