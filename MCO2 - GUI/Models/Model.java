package Models;

import Models.Plants.Plant;
import Models.Plants.Shop;
import Models.Titles.TitleList;



public class Model {



    /* ----- ----- ----- Model Attributes ----- ----- ----- */

    // Classes
    private TitleList objTitleList;
    private Farmer objFarmer;
    private Board objBoard;
    private Shop objShop;
    private Tile objSelectedTile;
    private Plant objSelectedPlant;

    // Values
    private int intProduceProduced;
    private float fltHarvestProfit;





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

        // If Board has Tiles with Plants
        if (this.objBoard.hasPlantedTiles())
            return false;


        // If has Empty Tiles and no money to buy the cheapest seed
        else if (this.objBoard.hasEmptyTiles() &&
                this.objFarmer.getFltObjectCoins() < this.objShop.getCheapestSeedPrice())
            return true;


        // If doesn't have any Usable Tiles and doesn't have money to use a Shovel
        else if (!this.objBoard.hasEmptyTiles() &&
                this.objFarmer.getFltObjectCoins() < this.objFarmer.getObjShovel().getFltUseCost())
            return true;


        return false;
    }


    /**
     * getProduceProduced
     * - This method returns the amount of produce produced by a harvest.
     *
     * @return Amount of produce produced by a harvest.
     */
    public int getProduceProduced() {

        this.intProduceProduced = this.objSelectedTile.getObjPlant().getProduceQuantity();

        return this.intProduceProduced;
    }



    /**
     * getHarvestProfit
     * - This method returns the total profit of a harvest.
     *
     * @return Total profit of a harvest.
     */
    public float getHarvestProfit() {

        this.fltHarvestProfit = this.objSelectedTile.getObjPlant().computeHarvestProfit(this.intProduceProduced,
                this.objFarmer.getObjCurrentTitle(),
                this.objSelectedTile.getIntTimesWatered(),
                this.objSelectedTile.getIntTimesFertilized());

        return this.fltHarvestProfit;
    }





    /* ----- ----- ----- Getters and Setters ----- ----- ----- */

    public TitleList getObjTitleList() {return objTitleList;}

    public Farmer getObjFarmer() {return objFarmer;}

    public Board getObjBoard() {return objBoard;}

    public Shop getObjShop() {return objShop;}

    public Tile getObjSelectedTile() {return objSelectedTile;}
    public void setObjSelectedTile(Tile objSelectedTile) {this.objSelectedTile = objSelectedTile;}
    
    public Plant getObjSelectedPlant() {return objSelectedPlant;}
    public void setObjSelectedPlant(Plant objSelectedPlant) {this.objSelectedPlant = objSelectedPlant;}

    public int getIntProduceProduced() {return intProduceProduced;}

    public float getFltHarvestProfit() {return fltHarvestProfit;}
}
