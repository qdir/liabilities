package es.unileon.ulebank.GUI.contractForm;

import es.unileon.ulebank.GUI.tools.JPicture;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JPanel;

/**
 * Class which contains most of the JPicture components used in the main window
 * @author Emanuel Iosif Relea
 */
public class JPictures {
    
    public JPictures(JPanel contentPanel){
        
        /**
         * Class constructor
         * @param contentPanel panel where the pictures are placed
         */
        placePictures(contentPanel);
        
    }
    
    /**
     * Places all the JPicture components
     * @param contentPanel panel where the pictures are placed
     */
    private void placePictures(JPanel contentPanel){
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        
        JPicture uleBankLogo = new JPicture("resources/es/unileon/aw/GUI/contractForm/UleBankLogo.png");
	uleBankLogo.setBounds(572, 0, 349, 110);
	contentPanel.add(uleBankLogo);
        
        JPicture uleBankLogo2 = new JPicture("resources/es/unileon/aw/GUI/contractForm/UleBankLogo.png");
	uleBankLogo2.setBounds(572, 3500, 349, 110);
	contentPanel.add(uleBankLogo2);
        
        JPicture table4 = new JPicture("resources/es/unileon/aw/GUI/contractForm/table4.png");
	table4.setBounds(39, 6382, 851, 787);
	contentPanel.add(table4);
	table4.setLayout(null);
                                                  
    }
    
}
