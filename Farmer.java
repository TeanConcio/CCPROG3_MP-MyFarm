import java.util.Scanner;

public class Farmer {
    private int intFarmerLevel;
    private int intExperience;
    private int intObjectCoins;
    private String strFarmerTitle;

    private Tool objWateringCan;
    private Tool objPlow;
    private Tool objShovel;
    private Tool objPickaxe;
    private Tool objFertilizer;
    private int intFertilizerNum;

    private Plant objTurnip;
    private Plant objCarrot;
    private Plant objRose;
    private Plant objStargazer;
    private int intTurnipSeedNum;
    private int intCarrotSeedNum;
    private int intRoseSeedNum;
    private int intStargazerSeedNum;

    public Farmer() {
         intFarmerLevel = 0;
         intExperience = 0;
         intObjectCoins = 100;
         strFarmerTitle = "Peasant";

         objWateringCan = new Tool("Watering Can", 0, 0);
         objPlow = new Tool("Plow", 0, 0);
         objShovel = new Tool("Shovel", 0, 0);
         objPickaxe = new Tool ("Pickaxe", 0, 0);
         objFertilizer = new Tool ("Fertilizer", 0, 0);
         intFertilizerNum = 5;

         objTurnip = new Plant("Turnip", 0, 2, 1, 2, 0, 1, 10, 1, 1, 5, 6);
         objCarrot = new Plant("Carrot", 0, 3, 1, 2, 0, 1, 10, 1, 2,10, 9);
         objRose = new Plant("Rose", 1, 2, 1, 2, 0, 1, 10, 2, 1, 5, 5);
         objStargazer = new Plant("Stargazer", 1, 5, 2, 3, 0, 1, 10, 2, 1, 10, 9);
         intTurnipSeedNum = 0;
         intCarrotSeedNum = 0;
         intRoseSeedNum = 0;
         intStargazerSeedNum = 0;
    }

    public void buySeed (String strSeedName) {
        Scanner strInput = new Scanner (System.in);
        System.out.print("Buy seed? ");
        strSeedName = strInput.nextLine();

        switch (strSeedName){
            case "Turnip":
                intTurnipSeedNum++;
                intObjectCoins -= objTurnip.getIntSeedCost();
                break;
            case "Carrot":
                intCarrotSeedNum++;
                intObjectCoins -= objCarrot.getIntSeedCost();
                break;
            case "Rose":
                intRoseSeedNum++;
                intObjectCoins -= objRose.getIntSeedCost();
                break;
            case "Stargazer":
                intStargazerSeedNum++;
                intObjectCoins -= objStargazer.getIntSeedCost();
                break;
        }

        System.out.println("Seed: " + strSeedName);
        System.out.println(intTurnipSeedNum + " " + intCarrotSeedNum + " " + intRoseSeedNum + " " + intStargazerSeedNum);
    }

    public void plantSeed (String strSeedName, Tile objTile) {
        System.out.println("Turnip Seeds: " + intTurnipSeedNum);
        System.out.println("Carrot Seeds: " + intCarrotSeedNum);
        System.out.println("Rose Seeds: " + intRoseSeedNum);
        System.out.println("Stargazer Seeds: " + intStargazerSeedNum);

        Scanner strInput = new Scanner (System.in);
        System.out.print("\nPlant seed? ");
        strSeedName = strInput.nextLine();

        int intSeedNum = 0;

        switch (strSeedName) {
            case "Turnip":
                intSeedNum = intTurnipSeedNum;
                break;
            case "Carrot":
                intSeedNum = intCarrotSeedNum;
                break;
            case "Rose":
                intSeedNum = intRoseSeedNum;
                break;
            case "Stargazer":
                intSeedNum = intStargazerSeedNum;
                break;
        }

        if (intSeedNum > 0) {
            switch (strSeedName) {
                case "Turnip":
                    intTurnipSeedNum--;
                    objTile.setObjPlant(objTurnip);
                    break;
                case "Carrot":
                    intCarrotSeedNum--;
                    objTile.setObjPlant(objCarrot);
                    break;
                case "Rose":
                    intRoseSeedNum--;
                    objTile.setObjPlant(objRose);
                    break;
                case "Stargazer":
                    intStargazerSeedNum--;
                    objTile.setObjPlant(objStargazer);
                    break;
            }
            objTile.setIntStatus(Tile.OCCUPIED);
        }

        System.out.println("Turnip Seeds: " + intTurnipSeedNum);
        System.out.println("Carrot Seeds: " + intCarrotSeedNum);
        System.out.println("Rose Seeds: " + intRoseSeedNum);
        System.out.println("Stargazer Seeds: " + intStargazerSeedNum);
    }

    public void harvestCrop (Tile objTile) {
        intObjectCoins += objTile.getObjPlant().computeProducePrice(strFarmerTitle,
                                                                    intFarmerLevel,
                                                                    objTile.getIntWateredNum(),
                                                                    objTile.getIntFertilizedNum());
    }

    public int getIntObjectCoins() {return intObjectCoins;}
    public void setIntObjectCoins(int intObjectCoins) {this.intObjectCoins = intObjectCoins;}

    public int getIntFarmerLevel() {return intFarmerLevel;}
    public void setIntFarmerLevel(int intFarmerLevel) {this.intFarmerLevel = intFarmerLevel;}

    public int getIntExperience() {return intExperience;}
    public void setIntExperience(int intExperience) {this.intExperience = intExperience;}

    public String getStrFarmerTitle() {return strFarmerTitle;}
    public void setStrFarmerTitle(String strFarmerTitle) {this.strFarmerTitle = strFarmerTitle;}

    public Tool getObjWateringCan() {return objWateringCan;}
    public void setObjWateringCan(Tool objWateringCan) {this.objWateringCan = objWateringCan;}

    public Tool getObjPlow() {return objPlow;}
    public void setObjPlow(Tool objPlow) {this.objPlow = objPlow;}

    public Tool getObjShovel() {return objShovel;}
    public void setObjShovel(Tool objShovel) {this.objShovel = objShovel;}

    public Tool getObjPickaxe() {return objPickaxe;}
    public void setObjPickaxe(Tool objPickaxe) {this.objPickaxe = objPickaxe;}

    public Tool getObjFertilizer() {return objFertilizer;}
    public void setObjFertilizer(Tool objFertilizer) {this.objFertilizer = objFertilizer;}

    public int getIntFertilizerNum() {return intFertilizerNum;}
    public void setIntFertilizerNum(int intFertilizerNum) {this.intFertilizerNum = intFertilizerNum;}

    public Plant getObjTurnip() {return objTurnip;}
    public void setObjTurnip(Plant objTurnip) {this.objTurnip = objTurnip;}

    public Plant getObjCarrot() {return objCarrot;}
    public void setObjCarrot(Plant objCarrot) {this.objCarrot = objCarrot;}

    public Plant getObjRose() {return objRose;}
    public void setObjRose(Plant objRose) {this.objRose = objRose;}

    public Plant getObjStargazer() {return objStargazer;}
    public void setObjStargazer(Plant objStargazer) {this.objStargazer = objStargazer;}

    public int getIntTurnipSeedNum() {return intTurnipSeedNum;}
    public void setIntTurnipSeedNum(int intTurnipSeedNum) {this.intTurnipSeedNum = intTurnipSeedNum;}

    public int getIntCarrotSeedNum() {return intCarrotSeedNum;}
    public void setIntCarrotSeedNum(int intCarrotSeedNum) {this.intCarrotSeedNum = intCarrotSeedNum;}

    public int getIntRoseSeedNum() {return intRoseSeedNum;}
    public void setIntRoseSeedNum(int intRoseSeedNum) {this.intRoseSeedNum = intRoseSeedNum;}

    public int getIntStargazerSeedNum() {return intStargazerSeedNum;}
    public void setIntStargazerSeedNum(int intStargazerSeedNum) {this.intStargazerSeedNum = intStargazerSeedNum;}
}
