public class Tool {

    /* ----- ----- ----- Tool Attributes ----- ----- ----- */

    private String strToolName;
    private int intUseCost;
    private float fltEXPGain;





    /* ----- ----- ----- Tool Constructor ----- ----- ----- */

    /**
     * Tool Constructor
     * - Creates a new Tool object.
     * 
     * @param strToolName Name of the Tool.
     * @param intUseCost Cost to use the Tool.
     * @param fltEXPGain EXP gained from using the Tool.
     */
    public Tool (String strToolName,
                 int intUseCost,
                 float fltEXPGain) {

        this.strToolName = strToolName;
        this.intUseCost = intUseCost;
        this.fltEXPGain = fltEXPGain;
    }





    /* ----- ----- ----- Tool Methods ----- ----- ----- */

    /**
     * useTool
     * - This method is called when Player uses a tool.
     * 
     * @param objTile Tile to use the tool on.
     * @param objPlayer Player using the tool.
     *
     * @return True if the Tool was used, False otherwise.
     */
    public boolean useTool (Tile objTile,
                            Farmer objPlayer) {

        boolean boolToolUsed = false;

        // If Player has not enough Objectcions to use Tool
        if (objPlayer.getIntObjectCoins() < intUseCost)
            return false;

        // Switch Tool Method
        switch (strToolName) {

            case "Watering Can":
                boolToolUsed = useWateringCan(objTile);
                break;

            case "Plow":
                boolToolUsed = usePlow(objTile);
                break;

            case "Shovel":
                boolToolUsed = useShovel(objTile);
                break;

            case "Pickaxe":
                boolToolUsed = usePickaxe(objTile);
                break;

            case "Fertilizer":
                boolToolUsed = useFertilizer(objTile);
                break;
        }

        // If Tool was successfully used
        if (boolToolUsed) {

            // Use Objectcoins
            objPlayer.setIntObjectCoins(objPlayer.getIntObjectCoins() - intUseCost);

            // Gain EXP
            objPlayer.setFltEXP(objPlayer.getFltEXP() + fltEXPGain);
        }

        return boolToolUsed;
    }


    /**
     * useWateringCan
     * - This method is called when Player uses a Watering Can.
     * 
     * @param objTile Tile to use the Watering Can on.
     *                
     * @return True if the Watering Can was used, False otherwise.
     */
    private boolean useWateringCan (Tile objTile) {

        // If tile has a Plant and hasn't been watered today
        if (objTile.getIntStatus() == Tile.OCCUPIED &&
                objTile.isBoolWateredToday() == false) {

            // Water Tile
            objTile.setIntWateredNum(objTile.getIntWateredNum() + 1);
            objTile.setBoolWateredToday(true);

            return true;
        }

        return false;
    }



    /**
     * usePlow
     * - This method is called when Player uses a Plow.
     * 
     * @param objTile Tile to use the Plow on.
     *                
     * @return True if the Plow was used, False otherwise.
     */
    private boolean usePlow (Tile objTile) {

        // If Tile is Unplowed
        if (objTile.getIntStatus() == Tile.UNPLOWED) {

            // Plow Tile
            objTile.setIntStatus(Tile.PLOWED);

            return true;
        }

        return false;
    }



    /**
     * useShovel
     * - This method is called when Player uses a Shovel.
     * 
     * @param objTile Tile to use the Shovel on.
     *                
     * @return True if the Shovel was used, False otherwise.
     */
    private boolean useShovel (Tile objTile) {

        // If Tile is Plowed, Occupied, Harvestable, or is Withered
        if (objTile.getIntStatus() == Tile.UNPLOWED ||
                objTile.getIntStatus() == Tile.OCCUPIED ||
                objTile.getIntStatus() == Tile.HARVESTABLE ||
                objTile.getIntStatus() == Tile.WITHERED) {

            // Reset Tile
            objTile.resetTile(Tile.UNPLOWED);
        }

        // Always true even if nothing happens
        return true;
    }



    /**
     * usePickaxe
     * - This method is called when Player uses a Pickaxe.
     * 
     * @param objTile Tile to use the Pickaxe on.
     *                
     * @return True if the Pickaxe was used, False otherwise.
     */
    private boolean usePickaxe (Tile objTile) {

        // If Tile has a Rock
        if (objTile.getIntStatus() == Tile.ROCK) {

            // Set Tile to Unplowed
            objTile.setIntStatus(Tile.UNPLOWED);

            return true;
        }

        return false;
    }



    /**
     * useFertilizer
     * - This method is called when Player uses a Fertilizer.
     * 
     * @param objTile Tile to use the Fertilizer on.
     *                
     * @return True if the Fertilizer was used, False otherwise.
     */
    private boolean useFertilizer (Tile objTile) {

        // If Tile is Plowed AND Player has Fertilizers
        if (objTile.getIntStatus() == Tile.OCCUPIED &&
                objTile.isBoolFertilizedToday() == false) {

            // Increase Tile Fertilize Count
            objTile.setIntFertilizedNum(objTile.getIntFertilizedNum() + 1);
            objTile.setBoolFertilizedToday(true);

            return true;
        }

        return false;
    }





    /* ----- ----- ----- Getters and Setters ----- ----- ----- */

    public String getStrToolName() {return strToolName;}
    public void setStrToolName(String strToolName) {this.strToolName = strToolName;}

    public int getIntUseCost() {return intUseCost;}
    public void setIntUseCost(int intUseCost) {this.intUseCost = intUseCost;}

    public float getFltEXPGain() {return fltEXPGain;}
    public void setFltEXPGain(float fltEXPGain) {this.fltEXPGain = fltEXPGain;}
}
