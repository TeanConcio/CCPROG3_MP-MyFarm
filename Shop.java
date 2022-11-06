import java.util.ArrayList;

public class Shop {

    /* ----- ----- ----- Shop Attributes ----- ----- ----- */

    private int intPlantNums;
    private ArrayList<Plant> arrobjPlants = new ArrayList<Plant>();





    /* ----- ----- ----- Plant Constructor ----- ----- ----- */

    public Shop () {

        intPlantNums = 4;

        arrobjPlants.add(new Plant("Turnip", 0, 2, 1, 2, 0, 1, 1, 2, 5, 6, 5f));
        arrobjPlants.add(new Plant("Carrot", 0, 3, 1, 2, 0, 1, 1, 2, 10,9, 7.5f));
        arrobjPlants.add(new Plant("Rose", 1, 1, 1, 2, 0, 1, 1, 1, 5, 5, 2.5f));
        arrobjPlants.add(new Plant("Tulip", 1, 2, 2, 3, 0, 1, 1, 1,10, 9, 5f));
    }





    /* ----- ----- ----- Shop Methods ----- ----- ----- */

    public void updateShop (FarmerTitle objFarmerTitle) {

        for (int i = 0; i < intPlantNums; i++) {

            arrobjPlants.get(i).updateDiscountedSeedCost(objFarmerTitle.getFltSeedDiscount());
        }
    }



    public float getCheapestSeedPrice () {

        float fltCheapestSeedPrice = arrobjPlants.get(0).getFltDiscountedSeedCost();

        for (int i = 1; i < intPlantNums; i++) {

            if (fltCheapestSeedPrice > arrobjPlants.get(i).getFltDiscountedSeedCost()) {

                fltCheapestSeedPrice = arrobjPlants.get(i).getFltDiscountedSeedCost();
            }
        }

        return fltCheapestSeedPrice;
    }






    /* ----- ----- ----- Shop Getters and Setters ----- ----- ----- */

    public int getIntPlantNums() {return intPlantNums;}
    public void setIntPlantNums(int intPlantNums) {this.intPlantNums = intPlantNums;}

    public ArrayList<Plant> getArrobjPlants() {return arrobjPlants;}
    public void setArrobjPlants(ArrayList<Plant> arrobjPlants) {this.arrobjPlants = arrobjPlants;}

    public Plant getPlant(int intPlantIndex) {return arrobjPlants.get(intPlantIndex);}
    public void setPlant(int intPlantIndex, Plant objPlant) {arrobjPlants.set(intPlantIndex, objPlant);}

    public void addPlant(Plant objPlant) {arrobjPlants.add(objPlant);}
    public void removePlant(int intPlantIndex) {arrobjPlants.remove(intPlantIndex);}
}
