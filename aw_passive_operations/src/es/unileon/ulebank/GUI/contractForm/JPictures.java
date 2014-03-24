package es.unileon.ulebank.GUI.contractForm;

import es.unileon.ulebank.GUI.tools.JPicture;
import javax.swing.JPanel;

/**
 * Class which contains most of the JPicture components used in the main window
 * @author Emanuel Iosif Relea
 */
public class JPictures {
    
    public JPictures(JPanel contentPanel, JPanel panelAuthorized){
        
        /**
         * Class constructor
         * @param contentPanel panel where the pictures are placed
         */
        placePictures(contentPanel, panelAuthorized);
        
    }
    
    /**
     * Places all the JPicture components
     * @param contentPanel panel where the pictures are placed
     */
    private void placePictures(JPanel contentPanel, JPanel panelAuthorized){
        
    JPicture uleBankLogo = new JPicture("resources/es/unileon/ulebank/GUI/contractForm/UleBankLogo.png");
	uleBankLogo.setBounds(572, 0, 349, 110);
	contentPanel.add(uleBankLogo);
        
    JPicture uleBankLogo2 = new JPicture("resources/es/unileon/ulebank/GUI/contractForm/UleBankLogo.png");
	uleBankLogo2.setBounds(572, 2750, 349, 110);
	panelAuthorized.add(uleBankLogo2);
        
    JPicture table4 = new JPicture("resources/es/unileon/ulebank/GUI/contractForm/table4.png");
	table4.setBounds(39, 5632, 851, 787);
	panelAuthorized.add(table4);
	table4.setLayout(null);
                                                  
    }
    
}
