package es.unileon.ulebank.GUI.contractForm;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

/**
 * Class which contains the JComboBox components in the main window
 * @author Emanuel Iosif Relea
 */
public class JComboBoxes implements Runnable{
    
    /**
     * Combo box which contains the owner availability
     */
    private JComboBox<Object> availability;
    
    /**
     * Combo box which contains the account modality
     */
    private JComboBox<Object> modality;
    
    /**
     * Add owner button
     */
    private JButton add;
    
    /**
     * An instance of all the buttons in the window
     */
    private JButtons buttons;
    
    /**
    * Class constructor
    * @param contentpanel panel where the JComboBox components are placed
    */
    public JComboBoxes(JPanel contentPanel, JButton addUserButton, JButtons allButtons){
        
        add = addUserButton;
        buttons = allButtons;
        placeComboBoxes(contentPanel, addUserButton, buttons);
        
    }
    
    /**
     * Places the combo boxes in the corresponding panel
     * @param contentPanel contentPanel panel where the JComboBox components are placed
     */
    private void placeComboBoxes(JPanel contentPanel, JButton addUserButton, JButtons buttons){
        
    String[] mod = {"La Cartilla+", "Empresa", "Cuenta Plus", "Cuenta Personal"};		
	String[] disp = { "Independiente", "Mancomunada", "Indistinta"};
        
	modality = new JComboBox<Object>(mod);
	modality.setBounds(579, 305, 147, 20);
	contentPanel.add(modality);
                
	availability = new JComboBox<Object>(disp);		
	availability.setBounds(579, 338, 147, 20);
	contentPanel.add(availability);        
        
    }
    
    
    /**
     * Method which checks constantly the item selected in the availability combo box
     * and it hides/shows the add owner button based on that particular item
     */
    
    @Override
    public void run(){
        
        while(true){
            if (!availability.getSelectedItem().toString().equals("Independiente")){
                add.setVisible(true);
            }
            else{
                add.setVisible(false);
            }
            if(buttons.getTerminateThread())
                return;
        }
        
    }
    
    
}
