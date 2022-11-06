import java.util.Objects;
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

            Scanner input = new Scanner(System.in);

            String strInput;
            String strTileName;
            int intSelectedRow;
            int intSelectedCol;

            Tile objSelectedTile;

            boolean boolTileSelect = true;

            //main gameplay loop
            // While not Game Over
            while (!isGameOver(objFarmer.getFltObjectCoins(),
                    objBoard.hasLiveTiles(),
                    objShop.getCheapestSeedPrice(),
                    objFarmer.getObjShovel().getFltUseCost())) {

                objVisual.displayFarmerStatus(objFarmer, objBoard.getIntDay());
                objVisual.displayBoard(objBoard);

                System.out.print("\nSelect tile? (Yes/No) : ");
                strInput = input.nextLine();
                if (!Objects.equals(strInput, "Yes") && !Objects.equals(strInput, "yes"))
                    boolTileSelect = false;
                else
                    boolTileSelect = true;

                //loops until the player opts not to select a tile
                while (boolTileSelect) {

                    //lets the player choose a tile to do things on
                    System.out.print("Which Tile? (Ex: A1) : ");
                    strInput = input.nextLine();
                    strTileName = strInput.toUpperCase();

                    objSelectedTile = objBoard.getTileFromCoords(strTileName);
                    objVisual.displayTileStatus(objSelectedTile);

                    objVisual.displayOptions(objSelectedTile, objFarmer.getFltObjectCoins());

                    System.out.print("Action : ");
                    strInput = input.nextLine();

                    //decides which tool to use based on the input
                    switch (strInput) {
                        // TODO do encapsulation
                        // TODO check for Watered and Fertilized Today
                        case "Pickaxe":
                            objFarmer.getObjPickaxe().useTool(objSelectedTile, objFarmer);
                            System.out.println("Tile " + strTileName + " rock removed!");
                            break;
                        case "Plow":
                            objFarmer.getObjPlow().useTool(objSelectedTile, objFarmer);
                            System.out.println("Tile " + strTileName + " plowed!");
                            break;
                        case "Plant":
                            objVisual.printShopItems(objShop);
                            System.out.print("Which seed? : ");
                            strInput = input.nextLine();
                            objSelectedTile.plantSeed(objShop.getObjPlant(Integer.parseInt(strInput)-1), objFarmer, objBoard.getArrObjTile());
                            // TODO : Add plant selection input
                            break;
                        case "Water":
                            objFarmer.getObjWateringCan().useTool(objSelectedTile, objFarmer);
                            System.out.println("Tile " + strTileName + " watered!");
                            break;
                        case "Fertilize":
                            objFarmer.getObjFertilizer().useTool(objSelectedTile, objFarmer);
                            System.out.println("Tile " + strTileName + " fertilized!");
                            break;
                        case "Shovel":
                            objFarmer.getObjShovel().useTool(objSelectedTile, objFarmer);
                            System.out.println("Tile " + strTileName + " shoveled!");
                            break;
                        case "Harvest":
                            if (objSelectedTile.getIntStatus() == Tile.HARVESTABLE) {
                                objFarmer.harvestCrop(objSelectedTile);
                                System.out.println(objSelectedTile.getObjPlant().getStrSeedName() + " harvested!");
                            }
                    }

                    //asks if the player wants to select another tile
                    System.out.print("\nProceed day? (Yes/No) ");
                    strInput = input.nextLine();
                    if (!Objects.equals(strInput, "No") && !Objects.equals(strInput, "no"))
                        boolTileSelect = false;
                    else
                        boolTileSelect = true;
                    System.out.println();
                }

                // Advances the day
                objBoard.advanceDay();
            }

            // Game Over
            System.out.println("\nGame Over!");

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
