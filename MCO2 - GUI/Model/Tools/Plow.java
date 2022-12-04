package Model.Tools;

import Model.Farmer;
import Model.Tile;



public class Plow extends Tool{

    /* ----- ----- ----- Plow Constructor ----- ----- ----- */

    /**
     * Plow Constructor
     * - Creates a new Plow object.
     */
    public Plow() {

        super(0f, 0.5f);
    }





    /* ----- ----- ----- Plow Methods ----- ----- ----- */

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

        // If Tile is Unplowed
        if (objTile.getIntStatus() == Tile.UNPLOWED)
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

        // Plow Tile
        objTile.setIntStatus(Tile.PLOWED);
    }
}
