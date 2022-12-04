package Controller;

import Model.*;
import Model.Plants.Shop;
import Model.Titles.TitleList;
import Visuals.Visual;

import java.util.Objects;
import java.util.Scanner;

public class Controller {

        // Main method that will run the game
        public static void main(String[] args) {

            // Initializes Major Classes
            TitleList objTitleList = new TitleList();
            Farmer objFarmer = new Farmer(objTitleList.getObjTitle(0));
            Visual objVisual = new Visual();
            Board objBoard = new Board ();
            Shop objShop = new Shop();

            // Initializes Scanner Class
            Scanner input = new Scanner(System.in);

            // Declares variables
            String strInput;
            String strTileName;
            int intSelectedRow;
            int intSelectedCol;

            //Declares Model.Tile Class
            Tile objSelectedTile;

            // Initializes boolean variable
            boolean boolTileSelect = true;

            // Main gameplay loop
            // While not Game Over
            while (!isGameOver(objFarmer.getFltObjectCoins(),
                               objBoard.hasLiveTiles(),
                               objShop.getCheapestSeedPrice(),
                               objFarmer.getObjShovel().getFltUseCost())) {

                // Prints the day number, farmer stats, and the board
                System.out.println("\n----------- ----------- Day " + objBoard.getIntDay() + " ----------- -----------\n");
                objVisual.displayFarmerStatus(objFarmer);
                objVisual.displayBoard(objBoard);

                // If the Player can Register for next Model.Farmer Title
                if (objFarmer.canRegisterNextTitle(objTitleList)) {

                    // Display next Title Perks and get user input
                    objVisual.displayNextTitlePerks(objTitleList, objFarmer);
                    System.out.print("\nAdvance to next farmer title? (Yes/No) : ");
                    strInput = input.nextLine();

                    // Checks if user inputs yes
                    if (Objects.equals(strInput, "Yes") || Objects.equals(strInput, "yes")) {
                        // Registers next title
                        objFarmer.registerNextTitle(objTitleList, objShop);
                        System.out.println("Advanced to " + objFarmer.getObjCurrentTitle().getStrFarmerTitle());
                    }
                    else System.out.println("Model.Farmer did not advance!");
                }

                // Prompts the player to choose which tile to do actions on
                System.out.print("\nSelect tile? (Yes/No) : ");
                strInput = input.nextLine();
                if (!Objects.equals(strInput, "Yes") && !Objects.equals(strInput, "yes"))
                    boolTileSelect = false;
                else
                    boolTileSelect = true;

                // Loops until the player opts not to select a tile
                while (boolTileSelect) {

                    // Displays the board
                    objVisual.displayBoard(objBoard);

                    // Lets the player choose a tile to do actions on
                    System.out.print("Which Model.Tile? (Ex: A1) : ");
                    strInput = input.nextLine();
                    strTileName = strInput.toUpperCase();

                    // Displays tile stats
                    objSelectedTile = objBoard.getTileFromCoords(strTileName);
                    objVisual.displayTileStatus(objSelectedTile);

                    // Display available actions
                    objVisual.displayActionOptions(objFarmer, objSelectedTile);

                    // Prompts the player to enter a desired action
                    System.out.print("Action : ");
                    strInput = input.nextLine();

                    // Decides which tool to use based on the input, checks if said tool can be used
                    switch (strInput) {

                        case "Pickaxe":
                        case "pickaxe":
                            // If can use Pickaxe on Model.Tile
                            if (objFarmer.getObjPickaxe().canUseTool(objSelectedTile, objFarmer.getFltObjectCoins())) {
                                objFarmer.getObjPickaxe().useTool(objSelectedTile, objFarmer);
                                System.out.println("Model.Tile " + strTileName + " rock removed!");
                            }
                            else
                                System.out.println ("There's a time and place for everything! But not now.");
                            break;

                        case "Plow":
                        case "plow":
                            // If Model.Tile can be Plowed
                            if (objFarmer.getObjPlow().canUseTool(objSelectedTile, objFarmer.getFltObjectCoins())) {
                                objFarmer.getObjPlow().useTool(objSelectedTile, objFarmer);
                                System.out.println("Model.Tile " + strTileName + " plowed!");
                            }
                            else
                                System.out.println ("There's a time and place for everything! But not now.");
                            break;

                        case "Model.Plants.Plant":
                        case "plant":
                            // If Model.Tile can be Planted
                            if (objSelectedTile.getIntStatus() == Tile.PLOWED) {
                                // Displays the shop
                                objVisual.displayShopItems(objFarmer, objShop);
                                // Prompts the player to choose a seed to plant
                                System.out.print("Which Seed Number? : ");
                                strInput = input.nextLine();
                                // If the player has enough money to plant the selected seed
                                if (objFarmer.getFltObjectCoins() >= objShop.getObjPlant(Integer.parseInt(strInput) - 1).getFltDiscountSeedCost()) {
                                    objSelectedTile.plantSeed(objShop.getObjPlant(Integer.parseInt(strInput) - 1),
                                                              objFarmer, objBoard.getArrObjTile());
                                    System.out.println(objSelectedTile.getObjPlant().getStrSeedName() +
                                                       " was planted on Model.Tile " + strTileName + " !");
                                }
                                else
                                    System.out.println("You do not have enough money to plant that seed!");
                            }
                            else
                                System.out.println ("There's a time and place for everything! But not now.");
                            break;

                        case "Water":
                        case "water":
                            // If Model.Tile can be Watered
                            if (objFarmer.getObjWateringCan().canUseTool(objSelectedTile, objFarmer.getFltObjectCoins())) {
                                objFarmer.getObjWateringCan().useTool(objSelectedTile, objFarmer);
                                System.out.println("Model.Tile " + strTileName + " watered!");
                            }
                            else
                                System.out.println ("There's a time and place for everything! But not now.");
                            break;

                        case "Fertilize":
                        case "fertilize":
                            // If Model.Tile can be Fertilized
                            if (objFarmer.getObjFertilizer().canUseTool(objSelectedTile, objFarmer.getFltObjectCoins())) {
                                objFarmer.getObjFertilizer().useTool(objSelectedTile, objFarmer);
                                System.out.println("Model.Tile " + strTileName + " fertilized!");
                            }
                            else
                                System.out.println ("There's a time and place for everything! But not now.");
                            break;

                        case "Shovel":
                        case "shovel":
                            // If Model.Tile can be Shoveled
                            if (objFarmer.getObjShovel().canUseTool(objSelectedTile, objFarmer.getFltObjectCoins())) {

                                System.out.print("Model.Tile " + strTileName + " shoveled!");

                                if (objSelectedTile.getIntStatus() == Tile.ROCK ||
                                        objSelectedTile.getIntStatus() == Tile.UNPLOWED)
                                    System.out.print(" But nothing happened");
                                System.out.println();

                                objFarmer.getObjShovel().useTool(objSelectedTile, objFarmer);
                            }
                            else
                                System.out.println ("There's a time and place for everything! But not now.");
                            break;

                        case "Harvest":
                        case "harvest":
                            // If Model.Tile can be Harvested
                            if (objSelectedTile.getIntStatus() == Tile.HARVESTABLE) {
                                System.out.println(objSelectedTile.getObjPlant().getStrSeedName() + " harvested!");
                                int intProductsProduced = objSelectedTile.getObjPlant().getProduceQuantity();
                                float fltHarvestProfit = objSelectedTile.getObjPlant().computeHarvestProfit(intProductsProduced,
                                        objFarmer.getObjCurrentTitle(), objSelectedTile.getIntTimesWatered(), objSelectedTile.getIntTimesFertilized());
                                System.out.println(objSelectedTile.getObjPlant().getStrSeedName() + " Produced: " + intProductsProduced);
                                System.out.printf("Profit: %.2f\n", fltHarvestProfit);
                                objFarmer.harvestCrop(objSelectedTile, intProductsProduced);
                            }
                            else
                                System.out.println("Model.Tile " + strTileName + " is not ready for harvest!");
                            break;
                        default:
                            System.out.println("Exited Model.Tile " + strTileName + " !");
                            break;
                    }

                    // Asks if the player wants to select another tile
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
            objVisual.displayEndScreen(objFarmer, objBoard.getIntDay());

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
