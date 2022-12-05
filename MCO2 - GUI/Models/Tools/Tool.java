package Models.Tools;

import Models.Farmer;
import Models.Tile;

public abstract class Tool {

    /* ----- ----- ----- Tool Attributes ----- ----- ----- */

    protected float fltUseCost;
    protected float fltEXPGain;





    /* ----- ----- ----- Tool Constructor ----- ----- ----- */

    /**
     * Tool Constructor
     * - Creates a new Tool object.
     *
     * @param fltUseCost Cost to use the Tool.
     * @param fltEXPGain EXP gained from using the Tool.
     */
    public Tool (float fltUseCost,
                 float fltEXPGain) {

        this.fltUseCost = fltUseCost;
        this.fltEXPGain = fltEXPGain;
    }





    /* ----- ----- ----- Tool Methods ----- ----- ----- */

    /**
     * canUseTool
     * - This method checks if the Player can use the Tool.
     *
     * @param objTile Model.Tile to use the tool on.
     * @param fltObjectcoins Objectcoins the Player has.
     *
     * @return True if the Player can use the Tool, False otherwise.
     */
    public boolean canUseTool (Tile objTile,
                               float fltObjectcoins) {

        // If Player has not enough Objectcions to use Tool
        if (fltObjectcoins < this.fltUseCost)
            return false;

        return true;
    }

    

    /**
     * useTool
     * - This method is called when Player uses a tool.
     * 
     * @param objTile Model.Tile to use the tool on.
     * @param objPlayer Model.Farmer using the tool.
     */
    public void useTool (Tile objTile,
                         Farmer objPlayer) {

        // If can't use tool
        if (!canUseTool(objTile, objPlayer.getFltObjectCoins()))
            return;

        // Use Objectcoins
        objPlayer.setFltObjectCoins(objPlayer.getFltObjectCoins() - this.fltUseCost);

        // Gain EXP
        objPlayer.setFltEXP(objPlayer.getFltEXP() + this.fltEXPGain);
    }





    /* ----- ----- ----- Getters and Setters ----- ----- ----- */

    public float getFltUseCost() {return fltUseCost;}
    public void setFltUseCost(float fltUseCost) {this.fltUseCost = fltUseCost;}

    public float getFltEXPGain() {return fltEXPGain;}
    public void setFltEXPGain(float fltEXPGain) {this.fltEXPGain = fltEXPGain;}
}
