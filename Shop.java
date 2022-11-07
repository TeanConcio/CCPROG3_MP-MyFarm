import java.util.ArrayList;

public class Shop {

    /* ----- ----- ----- Shop Attributes ----- ----- ----- */
    
    private ArrayList<Plant> arrobjPlants = new ArrayList<Plant>();





    /* ----- ----- ----- Plant Constructor ----- ----- ----- */

    /**
     * Shop Constructor
     * - This constructor creates a Shop object. Initializes all available Plants.
     */
    public Shop () {

        arrobjPlants.add(new Plant("Turnip", 0, 2, 1, 2, 0, 1, 1, 2, 5, 6, 5f));
        arrobjPlants.add(new Plant("Carrot", 0, 3, 1, 2, 0, 1, 1, 2, 10,9, 7.5f));
        arrobjPlants.add(new Plant("Rose", 1, 1, 1, 2, 0, 1, 1, 1, 5, 5, 2.5f));
        arrobjPlants.add(new Plant("Tulip", 1, 2, 2, 3, 0, 1, 1, 1,10, 9, 5f));
    }





    /* ----- ----- ----- Shop Methods ----- ----- ----- */

    /**
     * updateShop
     * - Updates the prices of the plants in the shop.
     *
     * @param objFarmerTitle Current Title of the farmer.
     */
    public void updateShop (FarmerTitle objFarmerTitle) {

        for (int i = 0; i < arrobjPlants.size(); i++) {

            arrobjPlants.get(i).updatePricesFromTitle(objFarmerTitle);
        }
    }


    /**
     * getCheapestSeedPrice
     * - Returns the cheapest seed price in the shop.
     * 
     * @return Cheapest seed price in the shop.
     */
    public float getCheapestSeedPrice () {

        float fltCheapestSeedPrice = arrobjPlants.get(0).getFltDiscountSeedCost();

        for (int i = 1; i < arrobjPlants.size(); i++) {

            if (fltCheapestSeedPrice > arrobjPlants.get(i).getFltDiscountSeedCost()) {

                fltCheapestSeedPrice = arrobjPlants.get(i).getFltDiscountSeedCost();
            }
        }

        return fltCheapestSeedPrice;
    }





    /* ----- ----- ----- Shop Getters and Setters ----- ----- ----- */

    public int getIntPlantNums() {return arrobjPlants.size();}

    public ArrayList<Plant> getArrObjPlants() {return arrobjPlants;}
    public void setArrObjPlants(ArrayList<Plant> arrobjPlants) {this.arrobjPlants = arrobjPlants;}

    public Plant getObjPlant(int intPlantIndex) {return arrobjPlants.get(intPlantIndex);}
    public void setObjPlant(int intPlantIndex, Plant objPlant) {arrobjPlants.set(intPlantIndex, objPlant);}

    public void addObjPlant(Plant objPlant) {arrobjPlants.add(objPlant);}
    public void removeObjPlant(int intPlantIndex) {arrobjPlants.remove(intPlantIndex);}
}
