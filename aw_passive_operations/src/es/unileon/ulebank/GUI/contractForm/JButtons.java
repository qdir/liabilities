package es.unileon.ulebank.GUI.contractForm;

import es.unileon.ulebank.GUI.tools.JPicture;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * Contains all the JButtons used in the main window
 * @author Emanuel Iosif Relea
 */
public class JButtons {
    
    /**
     * The frame of the main window
     */
    JFrame mainFrame;
    
    /**
     * Class constructor
     * @param mainFrame frame of the main window
     * @param customTitleBar custom title bar for the window
     * @param contentPanel panel where the JButtons are placed
     * @param picture background image for the main window
     */
    public JButtons(JFrame mainFrame, JPicture customTitleBar, JPanel contentPanel, JPicture picture){
        
        this.mainFrame = mainFrame;
        placeButtons(customTitleBar, contentPanel, picture);
        
    }
    
    /**
     * Places the JButtons in the window and assigns actions to each one
     * @param customTitleBar custom title bar for the window
     * @param contentPanel panel where the JButtons are placed
     * @param picture background image for the main window
     */
    private void placeButtons(JPicture customTitleBar, JPanel contentPanel, JPicture picture){
        
        Icon closeIcon = new ImageIcon("resources/es/unileon/ulebank/GUI/contractForm/closeButton.jpg");
		Icon minimizeIcon = new ImageIcon("resources/es/unileon/ulebank/GUI/contractForm/minimizeButton.jpg");
		
		JButton closeButton = new JButton(closeIcon);
		closeButton.setBounds(972, 8, 23, 23);
		customTitleBar.add(closeButton);		
		closeButton.setOpaque(false);
		closeButton.setContentAreaFilled(false);
		closeButton.setBorderPainted(false);
		closeButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		closeButton.setFocusPainted(false);
		
		closeButtonAction(closeButton);
		
		JButton minimizeButton = new JButton(minimizeIcon);
		minimizeButton.setBounds(948, 8, 23, 23);
		customTitleBar.add(minimizeButton);
		minimizeButton.setOpaque(false);
		minimizeButton.setContentAreaFilled(false);
		minimizeButton.setBorderPainted(false);
		minimizeButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		minimizeButton.setFocusPainted(false);
                
                minimizeButtonAction(minimizeButton);
                
                Icon addIcon = new ImageIcon("resources/es/unileon/ulebank/GUI/contractForm/AddButton.png");
		
		JButton addOwner = new JButton(addIcon);
		addOwner.setBounds(193, 403, 23, 23);
		contentPanel.add(addOwner);
		addOwner.setOpaque(false);
		addOwner.setContentAreaFilled(false);
		addOwner.setBorderPainted(false);
		addOwner.setCursor(new Cursor(Cursor.HAND_CURSOR));
		addOwner.setFocusPainted(false);
		
		JButton addAuthorized = new JButton(addIcon);
		addAuthorized.setBounds(193, 594, 23, 23);
		contentPanel.add(addAuthorized);
		addAuthorized.setOpaque(false);
		addAuthorized.setContentAreaFilled(false);
		addAuthorized.setBorderPainted(false);
		addAuthorized.setCursor(new Cursor(Cursor.HAND_CURSOR));
		addAuthorized.setFocusPainted(false);
                               
		Icon acceptIcon = new ImageIcon("resources/es/unileon/ulebank/GUI/contractForm/AcceptButton.jpg");
		Icon denyIcon = new ImageIcon("resources/es/unileon/ulebank/GUI/contractForm/DenyButton.jpg");               						
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                               
		JButton denyButton = new JButton(denyIcon);
		denyButton.setBounds(918, (int)screenSize.getHeight()-130, 41, 41);
		picture.add(denyButton);
		denyButton.setOpaque(false);
		denyButton.setContentAreaFilled(false);
		denyButton.setBorderPainted(false);
		denyButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		denyButton.setFocusPainted(false);		
                denyButton.setToolTipText("Reject Contract");                		
		
                denyButtonAction(denyButton);
                
		JButton acceptButton = new JButton(acceptIcon);
		acceptButton.setBounds(854, (int)screenSize.getHeight()-130, 41, 41);
		picture.add(acceptButton);
		acceptButton.setOpaque(false);
		acceptButton.setContentAreaFilled(false);
		acceptButton.setBorderPainted(false);
		acceptButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		acceptButton.setFocusPainted(false);
		acceptButton.setToolTipText("Accept Contract");

                acceptButtonAction(acceptButton);
        
    }
    
    /**
     * Action performed when the close button is pressed
     * @param closeButton button used for closing the main window
     */
    private void closeButtonAction(JButton closeButton){
        
        closeButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {

                        mainFrame.dispose();

                }
        });
        
    }
    
    /**
     * Action performed when the minimize button is pressed
     * @param minimizeButton button used for minimizing the main window
     */
    private void minimizeButtonAction(JButton minimizeButton){
        
        minimizeButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {

                        mainFrame.setExtendedState(JFrame.ICONIFIED);

                }
        });
        
    }
    
    /**
     * Action performed when the deny button is pressed
     * @param denyButton button used for rejecting the contract
     */
    private void denyButtonAction(JButton denyButton){
        
        denyButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {

                        Toolkit.getDefaultToolkit().beep();
                        JOptionPane.showMessageDialog(mainFrame,
                            "Operation Canceled!",
                            "Operation Canceled!",
                            JOptionPane.ERROR_MESSAGE);

                        mainFrame.dispose();

                }
        });
        
    }
    
    /**
     * Action performed when the accept button is pressed
     * @param acceptButton button used for accepting a contract
     */
    private void acceptButtonAction(JButton acceptButton){
        
        acceptButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {

                        new SignatureFrame();

                }
        });
        
    }
    
}
