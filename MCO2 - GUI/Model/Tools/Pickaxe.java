package Model.Tools;

import Model.Farmer;
import Model.Tile;



public class Pickaxe extends Tool{

    /* ----- ----- ----- Pickaxe Constructor ----- ----- ----- */

    /**
     * Pickaxe Constructor
     * - Creates a new Pickaxe object.
     */
    public Pickaxe() {

        super(50f, 15f);
    }





    /* ----- ----- ----- Pickaxe Methods ----- ----- ----- */

    /**
     * canUseTool
     * - This method checks if the Player can use the tool.
     *
     * @param objTile Tile to use the tool on.
     * @param fltObjectcoins Objectcoins the Player has.
     *
     * @return True if the Player can use the tool, False otherwise.
     */
    @Override
    public boolean canUseTool (Tile objTile,
                               float fltObjectcoins) {

        // If Player has enough Objectcoins
        if (!super.canUseTool(objTile, fltObjectcoins))
            return false;

        // If Tile has a Rock
        if (objTile.getIntStatus() == Tile.ROCK)
            return true;

        return false;
    }



    /**
     * useTool
     * - This method is called when Player uses the tool.
     *
     * @param objTile Tile to use the tool on.
     * @param objPlayer Farmer using the tool.
     */
    @Override
    public void useTool (Tile objTile,
                         Farmer objPlayer) {

        // Use Objectcoins and gain EXP
        super.useTool(objTile, objPlayer);

        // Set Tile to Unplowed
        objTile.setIntStatus(Tile.UNPLOWED);
    }
}
