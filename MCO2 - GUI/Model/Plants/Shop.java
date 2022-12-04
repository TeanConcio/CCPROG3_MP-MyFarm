package Model.Plants;

import Model.Titles.FarmerTitle;

import java.util.ArrayList;

public class Shop {

    /* ----- ----- ----- Model.Plants.Shop Attributes ----- ----- ----- */
    
    private ArrayList<Plant> arrobjPlants = new ArrayList<>();





    /* ----- ----- ----- Model.Plants.Plant Constructor ----- ----- ----- */

    /**
     * Model.Plants.Shop Constructor
     * - This constructor creates a Model.Plants.Shop object. Initializes all available Plants.
     */
    public Shop () {

        // Add Plants

        // Root Crops
        arrobjPlants.add(new RootCrop("Turnip", 2, 1, 2, 0, 1, 1, 2, 5, 6, 5f));
        arrobjPlants.add(new RootCrop("Carrot", 3, 1, 2, 0, 1, 1, 2, 10,9, 7.5f));
        arrobjPlants.add(new RootCrop("Potato", 5, 3, 4, 1, 2, 1, 10, 20, 3, 12.5f));


        // Flowers
        arrobjPlants.add(new Flower("Rose", 1, 1, 2, 0, 1, 1, 1, 5, 5, 2.5f));
        arrobjPlants.add(new Flower("Tulip", 2, 2, 3, 0, 1, 1, 1,10, 9, 5f));
        arrobjPlants.add(new Flower("Sunflower", 3, 2, 3, 1, 2, 1, 1, 20, 19, 7.5f));


        // Trees
        arrobjPlants.add(new FruitTree("Mango", 10, 7, 7, 4, 4, 5, 15, 100, 8, 25f));
        arrobjPlants.add(new FruitTree("Apple", 10, 7, 7, 5, 5, 10, 15, 200, 5, 25f));
    }





    /* ----- ----- ----- Model.Plants.Shop Methods ----- ----- ----- */

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





    /* ----- ----- ----- Model.Plants.Shop Getters and Setters ----- ----- ----- */

    public int getIntPlantNums() {return arrobjPlants.size();}

    public ArrayList<Plant> getArrObjPlants() {return arrobjPlants;}
    public void setArrObjPlants(ArrayList<Plant> arrobjPlants) {this.arrobjPlants = arrobjPlants;}

    public Plant getObjPlant(int intPlantIndex) {return arrobjPlants.get(intPlantIndex);}
    public void setObjPlant(int intPlantIndex, Plant objPlant) {arrobjPlants.set(intPlantIndex, objPlant);}

    public void addObjPlant(Plant objPlant) {arrobjPlants.add(objPlant);}
    public void removeObjPlant(int intPlantIndex) {arrobjPlants.remove(intPlantIndex);}
}
