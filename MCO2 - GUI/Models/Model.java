package Models;

import Models.Plants.Shop;
import Models.Titles.TitleList;



public class Model {



    /* ----- ----- ----- Model Attributes ----- ----- ----- */

    private TitleList objTitleList;
    private Farmer objFarmer;
    private Board objBoard;
    private Shop objShop;

    private Tile objSelectedTile;





    /* ----- ----- ----- Model Constructor ----- ----- ----- */

    public Model () {

        this.objTitleList = new TitleList();
        this.objFarmer = new Farmer(objTitleList.getObjTitle(0));
        this.objBoard = new Board ();
        this.objShop = new Shop();

        this.objSelectedTile = null;
    }





    /* ----- ----- ----- Model Methods ----- ----- ----- */

    /**
     * checkGameOver
     * - This method checks if the conditions for ending the game is met.
     *
     * @return True if the conditions were met, False otherwise.
     */
    public boolean isGameOver() {

        // If has live tiles but no money to buy the cheapest seed
        if (this.objBoard.hasLiveTiles() &&
                this.objFarmer.getFltObjectCoins() < this.objShop.getCheapestSeedPrice())
            return true;


            // If doesn't have live tiles and doesn't have money to use a Shovel
        else if (!this.objBoard.hasLiveTiles() &&
                this.objFarmer.getFltObjectCoins() < this.objFarmer.getObjShovel().getFltUseCost()) {
            return true;
        }


        return false;
    }





    /* ----- ----- ----- Getters and Setters ----- ----- ----- */

    public TitleList getObjTitleList() {return objTitleList;}

    public Farmer getObjFarmer() {return objFarmer;}

    public Board getObjBoard() {return objBoard;}

    public Shop getObjShop() {return objShop;}

    public Tile getObjSelectedTile() {return objSelectedTile;}
    public void setObjSelectedTile(Tile objSelectedTile) {this.objSelectedTile = objSelectedTile;}
}