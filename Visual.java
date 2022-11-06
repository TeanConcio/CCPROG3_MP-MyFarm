public class Visual {

    /**
     * printFarmerStatus
     * - This method displays the status of the player.
     *
     * @param objPlayer The player in question.
     * @param intDay The current day number of the game.
     *
     * @return True if the conditions were met, False otherwise.
     */
     public void printFarmerStatus (Farmer objPlayer, int intDay) {

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
     *
     * @return True if the conditions were met, False otherwise.
     */
    public void printTileStatus (Tile objTile) {

        String strCoordinate;
        String strStatus = " ";
        strCoordinate = Character.toString(numberToLetter(objTile.getIntColCoord()));
        strCoordinate = strCoordinate.concat(Character.toString((char) (objTile.getIntRowCoord() + 1)));
        System.out.println("Tile " + strCoordinate + ":");

        switch (objTile.getIntStatus()){
            case Tile.ROCK:
                strStatus = "Rock";
                break;
            case Tile.UNPLOWED:
                strStatus = "Unplowed";
                break;
            case Tile.PLOWED:
                strStatus = "Plowed";
                break;
            case Tile.OCCUPIED:
                strStatus = "Occupied";
                break;
            case Tile.HARVESTABLE:
                strStatus = "Harvestable";
                break;
            case Tile.WITHERED:
                strStatus = "Withered";
                break;
        }

        System.out.println("Status: " + strStatus);

        if (objTile.getObjPlant() != null) {
            System.out.print("Plant: " + objTile.getObjPlant().getStrSeedName() + " - ");
            System.out.println(objTile.getIntPlantAge());
        }

        System.out.println("Watered " + objTile.getIntTimesWatered() + "times");
        System.out.println("Fertilized " + objTile.getIntTimesFertilized() + "times\n");
    }

    /**
     * displayOptions
     * - This method displays the available things to do on a tile
     *
     * @param objTile The tile in question.
     * @param fltMoney Amount of money currently owned.
     */
    public void displayOptions (Tile objTile, float fltMoney) {

        System.out.println("What will you do to the tile?");

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
                if (fltMoney >= 7)
                    System.out.println("Shovel");
            case Tile.HARVESTABLE:
                System.out.println("Harvest");
            case Tile.WITHERED:
        }

        System.out.println("\n");
    }

    /**
     * printBoard
     * - This method displays the board
     *
     * @param objBoard The board in question.
     */
    public void printBoard (Board objBoard) {

        for (int i = 0; i < objBoard.getIntBoardSize(); i++) {

            for (int j = 0; j < objBoard.getIntBoardSize(); j++) {

                System.out.print(objBoard.getObjTile(i, j).getIntStatus() + " ");
            }

            System.out.println();
        }
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
    public void printEndScreen (Farmer objFarmer, int intDay) {
        System.out.println("Farmer fell to the throes of capitalism in day " + intDay + "\n");

        printStatus(objFarmer, intDay);

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
    public char numberToLetter (int intNumber) {
        return (char) (intNumber + 65);
    }

    /**
     * printShopItems
     * - This method prints all available seeds to plant
     *
     * @param objShop The list of all available seeds.
     */
    public void printShopItems(Shop objShop) {

        System.out.printf("Seeds (%d) :", objShop.intPlantNums);

        for (int i = 0; i < objShop.intPlantNums; i++) {

            System.out.printf("  %d : %s\n", i, objShop.arrobjPlants[i].getStrSeedName());
            System.out.printf("    - Seed Cost : %d\n", objShop.arrobjPlants[i].getFltDiscountedSeedCost());
            System.out.printf("    - Harvest Time : %d\n", objShop.arrobjPlants[i].getIntHarvestTime());
        }
    }
}
