public class Tool {

    /* ----- ----- ----- Tool Attributes ----- ----- ----- */

    private String strToolName;
    private float fltUseCost;
    private float fltEXPGain;





    /* ----- ----- ----- Tool Constructor ----- ----- ----- */

    /**
     * Tool Constructor
     * - Creates a new Tool object.
     * 
     * @param strToolName Name of the Tool.
     * @param fltUseCost Cost to use the Tool.
     * @param fltEXPGain EXP gained from using the Tool.
     */
    public Tool (String strToolName,
                 float fltUseCost,
                 float fltEXPGain) {

        this.strToolName = strToolName;
        this.fltUseCost = fltUseCost;
        this.fltEXPGain = fltEXPGain;
    }





    /* ----- ----- ----- Tool Methods ----- ----- ----- */

    /**
     * canUseTool
     * - This method checks if the Player can use the Tool.
     *
     * @param objTile Tile to use the tool on.
     * @param fltObjectcoins Objectcoins the Player has.
     *
     * @return True if the Player can use the Tool, False otherwise.
     */
    public boolean canUseTool (Tile objTile,
                               float fltObjectcoins) {

        // If Player has not enough Objectcions to use Tool
        if (fltObjectcoins < this.fltUseCost)
            return false;

        // Switch Tool
        switch (this.strToolName) {

            case "Watering Can":
                // If tile has a Plant and hasn't been watered today
                if (objTile.getIntStatus() == Tile.OCCUPIED &&
                        objTile.isBoolWateredToday() == false) {

                    return true;
                }
                break;

            case "Plow":
                // If Tile is Unplowed
                if (objTile.getIntStatus() == Tile.UNPLOWED) {

                    return true;
                }
                break;

            case "Shovel":
                // If Tile is Plowed, Occupied, Harvestable, or is Withered
                if (objTile.getIntStatus() == Tile.OCCUPIED ||
                        objTile.getIntStatus() == Tile.HARVESTABLE ||
                        objTile.getIntStatus() == Tile.WITHERED) {

                    return true;
                }
                break;

            case "Pickaxe":
                // If Tile has a Rock
                if (objTile.getIntStatus() == Tile.ROCK) {

                    return true;
                }
                break;

            case "Fertilizer":
                // If Tile is Plowed AND Player has Fertilizers
                if (objTile.getIntStatus() == Tile.OCCUPIED &&
                        objTile.isBoolFertilizedToday() == false) {

                    return true;
                }
                break;
        }

        return false;
    }

    

    /**
     * useTool
     * - This method is called when Player uses a tool.
     * 
     * @param objTile Tile to use the tool on.
     * @param objPlayer Farmer using the tool.
     */
    public void useTool (Tile objTile,
                         Farmer objPlayer) {

        // If can't use tool
        if (!canUseTool(objTile, objPlayer.getFltObjectCoins()))
            return;

        // Switch Tool Method
        switch (strToolName) {

            case "Watering Can":
                // Increase Tile Water Count
                objTile.setIntTimesWatered(objTile.getIntTimesWatered() + 1);
                objTile.setBoolWateredToday(true);
                break;

            case "Plow":
                // Plow Tile
                objTile.setIntStatus(Tile.PLOWED);
                break;

            case "Shovel":
                // Reset Tile
                objTile.resetTile(Tile.UNPLOWED);
                break;

            case "Pickaxe":
                // Set Tile to Unplowed
                objTile.setIntStatus(Tile.UNPLOWED);
                break;

            case "Fertilizer":
                // Increase Tile Fertilize Count
                objTile.setIntTimesFertilized(objTile.getIntTimesFertilized() + 1);
                objTile.setBoolFertilizedToday(true);
                break;
        }

        // Use Objectcoins
        objPlayer.setFltObjectCoins(objPlayer.getFltObjectCoins() - this.fltUseCost);

        // Gain EXP
        objPlayer.setFltEXP(objPlayer.getFltEXP() + this.fltEXPGain);
    }





    /* ----- ----- ----- Getters and Setters ----- ----- ----- */

    public String getStrToolName() {return strToolName;}
    public void setStrToolName(String strToolName) {this.strToolName = strToolName;}

    public float getFltUseCost() {return fltUseCost;}
    public void setFltUseCost(float fltUseCost) {this.fltUseCost = fltUseCost;}

    public float getFltEXPGain() {return fltEXPGain;}
    public void setFltEXPGain(float fltEXPGain) {this.fltEXPGain = fltEXPGain;}
}
