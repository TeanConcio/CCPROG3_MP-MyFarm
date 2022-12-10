package Controllers;

import Models.Board;
import Models.Model;
import Visuals.FarmGUI;

public class Driver {

    public static void main(String[] args) {

            Model objModel = new Model();

            FarmGUI objGUI = new FarmGUI(Board.ROW, Board.COLUMN);

            Controller objController = new FarmController(objModel, objGUI);
    }
}
