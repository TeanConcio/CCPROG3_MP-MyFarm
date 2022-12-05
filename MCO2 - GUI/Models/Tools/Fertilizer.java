package Models.Tools;

import Models.Farmer;
import Models.Tile;



public class Fertilizer extends Tool{

    /* ----- ----- ----- Fertilizer Constructor ----- ----- ----- */

    /**
     * Fertilizer Constructor
     * - Creates a new Fertilizer object.
     */
    public Fertilizer() {

        super(10f, 4f);
    }





    /* ----- ----- ----- Fertilizer Methods ----- ----- ----- */

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

        // If Tile is Occupied
        if (objTile.getIntStatus() == Tile.OCCUPIED)
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

        // Increase Tile Fertilize Count
        objTile.setIntTimesFertilized(objTile.getIntTimesFertilized() + 1);
    }
}
