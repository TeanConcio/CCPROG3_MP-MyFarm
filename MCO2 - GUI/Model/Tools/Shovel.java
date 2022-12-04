package Model.Tools;

import Model.Farmer;
import Model.Tile;



public class Shovel extends Tool{

    /* ----- ----- ----- Shovel Constructor ----- ----- ----- */

    /**
     * Shovel Constructor
     * - Creates a new Shovel object.
     */
    public Shovel() {

        super(7f, 2f);
    }





    /* ----- ----- ----- Shovel Methods ----- ----- ----- */

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

        // Can be used anytime
        return true;
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

        // If not a Rock or Unplowed
        if (objTile.getIntStatus() != Tile.ROCK &&
                objTile.getIntStatus() != Tile.UNPLOWED)
            // Reset Tile
            objTile.resetTile(Tile.UNPLOWED);
    }
}
