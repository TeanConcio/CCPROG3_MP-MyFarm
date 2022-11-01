public class Tool {

    /* ----- ----- ----- Tool Attributes ----- ----- ----- */

    private String strToolName;
    private int intUseCost;
    private int intEXPGain;





    /* ----- ----- ----- Tool Constructor ----- ----- ----- */

    public Tool (String strToolName, int intUseCost, int intEXPGain) {

        this.strToolName = strToolName;
        this.intUseCost = intUseCost;
        this.intEXPGain = intEXPGain;
    }





    /* ----- ----- ----- Tool Methods ----- ----- ----- */

    public boolean useTool (Tile objTile,  Farmer objPlayer) {

        switch (strToolName) {

            case "Watering Can":
                return useWateringCan(objTile, objPlayer);

            case "Plow":
                return usePlow(objTile, objPlayer);

            case "Shovel":
                return useShovel(objTile, objPlayer);

            case "Pickaxe":
                return usePickaxe(objTile, objPlayer);

            case "Fertilizer":
                return useFertilizer(objTile, objPlayer);
        }

        return false;
    }



    private boolean useWateringCan (Tile objTile, Farmer objPlayer) {

        // If tile has a Plant and hasn't been watered today
        if (objTile.getIntStatus() == Tile.OCCUPIED &&
                objTile.isBoolWateredToday() == false) {

            // Water Tile
            objTile.setIntWateredNum(objTile.getIntWateredNum() + 1);
            objTile.setBoolWateredToday(true);

            // Gain EXP
            // objPlayer.setIntEXP(objPlayer.getIntEXP() + intEXPGain);

            return true;
        }

        return false;
    }



    private boolean usePlow (Tile objTile, Farmer objPlayer) {

        if (objTile.getIntStatus() == Tile.UNPLOWED) {

            // Plow Tile
            objTile.setIntStatus(Tile.PLOWED);

            // Gain EXP
            // objPlayer.setIntEXP(objPlayer.getIntEXP() + intEXPGain);

            return true;
        }

        return false;
    }



    private boolean useShovel (Tile objTile, Farmer objPlayer) {

        // If Player has enough Objectcoins
        if (objPlayer.getIntObjectCoins() >= intUseCost) {

            // Reset Tile
            objTile = new Tile(Tile.UNPLOWED);

            // Use Objectcoins
            // objPlayer.setIntObjectCoins(objPlayer.getIntObjectCoins() - intUseCost);

            // Gain EXP
            // objPlayer.setIntEXP(objPlayer.getIntEXP() + intEXPGain);

            return true;
        }

        return false;
    }



    private boolean usePickaxe (Tile objTile, Farmer objPlayer) {

        // If Tile has a Rock
        if (objTile.getIntStatus() == Tile.ROCK) {

            // Set Tile to Unplowed
            objTile.setIntStatus(Tile.UNPLOWED);

            // Use Objectcoins
            // objPlayer.setIntObjectCoins(objPlayer.getIntObjectCoins() - intUseCost);

            // Gain EXP
            // objPlayer.setIntEXP(objPlayer.getIntEXP() + intEXPGain);

            return true;
        }

        return false;
    }



    private boolean useFertilizer (Tile objTile, Farmer objPlayer) {

        // If Tile is Plowed AND Player has Fertilizers
        if (objTile.getIntStatus() == Tile.PLOWED &&
                objPlayer.getIntFertilizerCount() > 0) {

            // Increase Fertilize Count
            objTile.setIntFertilizedNum(objTile.getIntFertilizedNum() + 1);

            // Decrement Farmer's Fertilizer Count
            // objPlayer.setIntFertilizerCount(objPlayer.getIntFertilizerCount() - 1);

            return true;
        }

        return false;
    }





    /* ----- ----- ----- Getters and Setters ----- ----- ----- */

    public String getStrToolName() {return strToolName;}
    public void setStrToolName(String strToolName) {this.strToolName = strToolName;}

    public int getIntUseCost() {return intUseCost;}
    public void setIntUseCost(int intUseCost) {this.intUseCost = intUseCost;}

    public int getIntEXPGain() {return intEXPGain;}
    public void setIntEXPGain(int intEXPGain) {this.intEXPGain = intEXPGain;}
}
