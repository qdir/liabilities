package es.unileon.ulebank.GUI.contractForm;

import javax.swing.JComboBox;
import javax.swing.JPanel;

/**
 * Class which contains the JComboBox componets in the main window
 * @author Emanuel Iosif Relea
 */
public class JComboBoxes {
    
    /*
    * Class constructor
    * @param contentpanel panel where the JComboBox components are placed
    */
    public JComboBoxes(JPanel contentPanel){
        
        placeComboBoxes(contentPanel);
        
    }
    
    /**
     * Places the combo boxes in the corresponding panel
     * @param contentPanel contentpanel panel where the JComboBox components are placed
     */
    private void placeComboBoxes(JPanel contentPanel){
        
        String[] mod = {"La Cartilla+", "Empresa", "Cuenta Plus", "Cuenta Personal"};		
	String[] disp = { "Independiente", "Mancomunada", "Indistinta"};
        
        @SuppressWarnings({ "unchecked", "rawtypes" })
	JComboBox modality = new JComboBox(mod);
	modality.setBounds(579, 305, 147, 20);
	contentPanel.add(modality);
                
	@SuppressWarnings({ "rawtypes", "unchecked" })
	JComboBox disponibility = new JComboBox(disp);		
	disponibility.setBounds(579, 338, 147, 20);
	contentPanel.add(disponibility);
        
    }
    
}
