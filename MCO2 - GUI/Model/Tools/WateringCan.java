package Model.Tools;

import Model.Farmer;
import Model.Tile;



public class WateringCan extends Tool{

    /* ----- ----- ----- WateringCan Constructor ----- ----- ----- */

    /**
     * WateringCan Constructor
     * - Creates a new Watering Can object.
     */
    public WateringCan() {

        super(0f, 0.5f);
    }





    /* ----- ----- ----- WateringCan Methods ----- ----- ----- */

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

        // If Tile os Occupied
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

        // Increase Tile Water Count
        objTile.setIntTimesWatered(objTile.getIntTimesWatered() + 1);
    }
}
