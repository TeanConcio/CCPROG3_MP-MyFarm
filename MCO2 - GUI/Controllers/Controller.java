package Controllers;



import Visuals.FarmGUI;
import Models.Model;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



/* ----- ----- ----- Controller ----- ----- ----- */

public class Controller implements ActionListener, DocumentListener {



    /* ----- ----- Controller Attributes ----- ----- */

    private FarmGUI objGUI;
    private Model objModel;





    /* ----- ----- Controller Constructor ----- ----- */
    // Takes the Visual and Model as parameters

    public Controller (FarmGUI objGUI, Model objModel) {

        // Initialize Visual and Model from parameters
        this.objGUI = objGUI;
        this.objModel = objModel;


        // Update the Visual with the Model
        this.updateView();


        // Add ActionListeners to the buttons
        // objGUI.setActionListener(this);

        // Add DocumentListeners to the text fields
        // objGUI.setDocumentListener(this);
    }





    /* ----- ----- Controller Method ----- ----- */
    public void updateView() {

    }





    /* ----- ----- Method Overrides ----- ----- */



    /* ----- ActionListener Methods ----- */

    @Override
    public void actionPerformed(ActionEvent e) {

    }



    /* ----- ----- DocumentListener Methods ----- ----- */

    @Override
    public void insertUpdate(DocumentEvent e) {

    }

    @Override
    public void removeUpdate(DocumentEvent e) {

    }

    @Override
    public void changedUpdate(DocumentEvent e) {

    }
}
