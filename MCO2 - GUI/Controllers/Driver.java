package Controllers;

import Models.Model;
import Visuals.FarmGUI;

public class Driver {

    public static void main(String[] args) {

            FarmGUI objGUI = new FarmGUI(10, 5);

            Model objModel = new Model();

            Controller objController = new Controller(objGUI, objModel);
    }
}
