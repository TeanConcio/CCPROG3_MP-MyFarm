package Controllers;



import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



/* ----- ----- ----- Controller ----- ----- ----- */

public interface Controller extends ActionListener, DocumentListener {





    /* ----- ----- Farm GUI Controller Methods ----- ----- */

    public void updateView();



    public void updateLabels();



    public void updateEnabledButtons();





    /* ----- ----- Method Overrides ----- ----- */



    /* ----- ActionListener Methods ----- */

    @Override
    public void actionPerformed(ActionEvent e);



    /* ----- DocumentListener Methods ----- */

    @Override
    public void insertUpdate(DocumentEvent e);

    @Override
    public void removeUpdate(DocumentEvent e);

    @Override
    public void changedUpdate(DocumentEvent e);
}
