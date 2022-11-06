import java.util.Scanner;

public class Controller {

        //main method that will run the game
        //Concio is cringe
        public static void main(String[] args) {

            // Initializes Major Classes
            Farmer objFarmer = new Farmer();
            Visual objVisual = new Visual();
            Board objBoard = new Board ();
            Shop objShop = new Shop();

            Tile objSelectedTile;

            String strSample = "A1";
            String strTemp;

            int[] arrintCoords = new int[2];
            int intDayNum = 1;

            boolean boolTileSelect = true;

            Scanner input = new Scanner(System.in);

            //main gameplay loop
            while (isGameOver(objFarmer.getFltObjectCoins(), objSelectedTile)) {
                objVisual.printFarmerStatus(objFarmer, intDayNum);

                System.out.print("\nSelect tile? (Yes/No) ");
                if (input.nextLine() != "Yes")
                    boolTileSelect = false;

                //loops until the player opts not to select a tile
                while (boolTileSelect) {
                    //lets the player choose a tile to do things on
                    System.out.print("Which Tile? ");
                    strSample = input.nextLine();
                    strTemp = strSample;
                    arrintCoords[1] = objBoard.letterToNumber(strSample.charAt(0));
                    arrintCoords[0] = objBoard.letterToNumber(strSample.charAt(1));

                    System.out.println(arrintCoords[0] + " " + arrintCoords[1]);
                    objSelectedTile = new Tile(arrintCoords[0], arrintCoords[1], Tile.UNPLOWED);
                    objVisual.printTileStatus (objSelectedTile);

                    objVisual.displayOptions(objSelectedTile, objFarmer.getFltObjectCoins());

                    strSample = input.nextLine();

                    //decides which tool to use based on the input
                    switch (strSample) {
                        case "Pickaxe":
                            objFarmer.getObjPickaxe().useTool(objSelectedTile, objFarmer);
                            break;
                        case "Plow":
                            objFarmer.getObjPlow().useTool(objSelectedTile, objFarmer);
                            System.out.println("Tile " + strTemp + "plowed!");
                            break;
                        case "Plant":
                            objVisual.printShopItems(objShop);
                            break;
                        case "Water":
                            objFarmer.getObjWateringCan().useTool(objSelectedTile, objFarmer);
                            System.out.println("Tile " + strTemp + "watered!");
                            break;
                        case "Shovel":
                            objFarmer.getObjShovel().useTool(objSelectedTile, objFarmer);
                            System.out.println("Tile " + strTemp + "shoveled!");
                            break;
                        case "Harvest":
                            if (objSelectedTile.getIntStatus() == Tile.HARVESTABLE) {
                                objFarmer.harvestCrop(objSelectedTile);
                                System.out.println(objSelectedTile.getObjPlant().getStrSeedName() + " harvested!");
                            }
                    }

                    //asks if the player wants to select another tile
                    System.out.print("\nProceed day? (Yes/No) ");
                    if (input.nextLine() != "No")
                        boolTileSelect = false;
                }

                //updates the game
                if (objSelectedTile.getIntStatus() >= Tile.OCCUPIED)
                    objSelectedTile.updateTile();

                intDayNum++;
            }

            input.close();
        }


        /**
        * checkGameOver
        * - This method checks if the conditions for ending the game is met.
        *
        * @param fltMoney The amount of money the player possesses.
        * @param boolHasLiveTiles A boolean that checks if the board has any live tiles.
        * @param fltCheapestSeed The cheapest seed in the game.
        * @param fltShovelCost The cost to use the shovel.
        *
        * @return True if the conditions were met, False otherwise.
        */
        public static boolean isGameOver(float fltMoney,
                                         boolean boolHasLiveTiles,
                                         float fltCheapestSeed,
                                         float fltShovelCost) {

            // If has live tiles but no money to buy the cheapest seed
            if (boolHasLiveTiles &&
                fltMoney < fltCheapestSeed)
                return true;

            // If doesn't have live tiles and doesn't have money to use a Shovel
            else if (!boolHasLiveTiles &&
                     fltMoney < fltShovelCost) {
                return true;
            }

            return false;
        }
}
