package Models.Titles;

import java.util.ArrayList;

public class TitleList {

    /* ----- ----- ----- TitleList Attributes ----- ----- ----- */

    private ArrayList<FarmerTitle> arrobjTitles = new ArrayList<>();
    private int intHighestTier;





    /* ----- ----- ----- TitleList Constructor ----- ----- ----- */

    /**
     * TitleList Constructor
     * - This constructor creates a Model.Plants.Shop object. Initializes all available Plants.
     */
    public TitleList() {

        arrobjTitles.add(new FarmerTitle(0, "Farmer", 0, 0, 0, 0, 0, 0f));
        arrobjTitles.add(new FarmerTitle(1, "Registered Farmer", 500, 1, 1, 0, 0, 200f));
        arrobjTitles.add(new FarmerTitle(2, "Distinguished Farmer", 1000, 2, 2, 1, 0, 300f));
        arrobjTitles.add(new FarmerTitle(3, "Legendary Farmer", 1500, 3, 4, 3, 1, 400f));
        
        intHighestTier = arrobjTitles.size() - 1;
    }





    /* ----- ----- ----- TitleList Methods ----- ----- ----- */

    /**
     * getTitle
     * - Returns the title object at the specified index.
     *
     * @param objCurrentTitle Current title of the farmer.
     *
     * @return Title object at the specified index.
     */
    public FarmerTitle getNextTitle (FarmerTitle objCurrentTitle) {

        // If there still are titles to be unlocked
        if (objCurrentTitle.getIntTitleTier() < intHighestTier)
            return arrobjTitles.get(objCurrentTitle.getIntTitleTier() + 1);
        
        else
            return null;
    }





    /* ----- ----- ----- Model.Plants.Shop Getters and Setters ----- ----- ----- */

    public FarmerTitle getObjTitle (int intTitleTier) {return arrobjTitles.get(intTitleTier);}
    public void setObjTitle (int intTitleTier, FarmerTitle objTitle) {arrobjTitles.set(intTitleTier, objTitle);}
    
    public int getIntHighestTier () {return intHighestTier;}
    public void setIntHighestTier (int intHighestTier) {this.intHighestTier = intHighestTier;}
}
