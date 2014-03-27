package es.unileon.ulebank.GUI.contractForm;

import es.unileon.ulebank.GUI.tools.*;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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
     * button which adds a new Owner
     */
    private JButton addOwner;
    
    /**
     * The thread which checks availability options
     */
    private Thread worker;
    
    /**
     * Dictates whether the a thread needs to stop or not
     */
    private boolean terminateThread = false;
    
    /**
     * Panel which hosts the components that will shift down when the addOwner button is pressed
     */
    private JPanel panelOwners;
    
    /**
     * Panel which hosts the components that will shift down when the addAuthorized button is pressed
     */
    private JPanel panelAuthorized;
    
    /**
     * Panel which holds most of the components in the main window.
     */
    private JPanel contentPanel;
    
    /**
     * Amount of pixeles needed for the owner and authorized panels
     */
    private final int PANELSIZEINCREMENT = 152;
    
    private int panelBaseLocationOwners = 152;
    private int panelBaseLocationAuthorized = 152;
    private final int CLIENTSTARTLOCATION = 575;
    private final int AUTHORIZEDSTARTLOCATION = 210;
    
    private ArrayList<JClientPanel> clientPanelList = new ArrayList<JClientPanel>();
    private ArrayList<JClientPanel> authorizedPanelList = new ArrayList<JClientPanel>();
    
    /**
     * Class constructor
     * @param mainFrame frame of the main window
     * @param customTitleBar custom title bar for the window
     * @param contentPanel panel where the JButtons are placed
     * @param picture background image for the main window
     */
    public JButtons(JFrame mainFrame, JPicture customTitleBar, JPanel contentPanel,
    					JPicture picture,JPanel panelOwners, JPanel panelAuthorized){
        
        this.mainFrame = mainFrame;
        this.panelOwners = panelOwners;
        this.panelAuthorized = panelAuthorized;
        this.contentPanel = contentPanel;
        placeButtons(customTitleBar, picture);
        
    }
    
    /**
     * Places the JButtons in the window and assigns actions to each one
     * @param customTitleBar custom title bar for the window
     * @param contentPanel panel where the JButtons are placed
     * @param picture background image for the main window
     */
    private void placeButtons(JPicture customTitleBar, JPicture picture){
        
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
		
		addOwner = new JButton(addIcon);
		addOwner.setBounds(193, 403, 23, 23);
		contentPanel.add(addOwner);
		addOwner.setOpaque(false);
		addOwner.setContentAreaFilled(false);
		addOwner.setBorderPainted(false);
		addOwner.setCursor(new Cursor(Cursor.HAND_CURSOR));
		addOwner.setFocusPainted(false);
		
		addOwnerButtonAction(addOwner);
		
		JButton addAuthorized = new JButton(addIcon);
		addAuthorized.setBounds(193, 34, 23, 23);
		panelOwners.add(addAuthorized);
		addAuthorized.setOpaque(false);
		addAuthorized.setContentAreaFilled(false);
		addAuthorized.setBorderPainted(false);
		addAuthorized.setCursor(new Cursor(Cursor.HAND_CURSOR));
		addAuthorized.setFocusPainted(false);
        
		addAuthorizedButtonAction(addAuthorized);
		
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
                        terminateThread = true;
                        worker.interrupt();

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
                        terminateThread = true;
                        worker.interrupt();

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
                        terminateThread = true;
                        worker.interrupt();

                }
        });
        
    }
    
    /**
     * Getter for the addOwner button
     * @return add owner button
     */
    public JButton getAddOwnerButton(){
        
        return addOwner;
        
    }
    
    /**
     * Setter for the worker attribute
     * @param worker
     */
    public void setWorker(Thread worker){
        
        this.worker = worker;
    }
    
    /**
     * Getter for the therminateThread boolean
     * @return
     */
    public boolean getTerminateThread(){
        
        return terminateThread;
    }
    
    private void addOwnerButtonAction(JButton addOwner){
    	
    	addOwner.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            	Dimension dimension = contentPanel.getSize();           	
            	contentPanel.setPreferredSize(new Dimension((int)dimension.getWidth(), (int)dimension.getHeight() + PANELSIZEINCREMENT));
            	
            	Point point = panelOwners.getLocation();
            	panelOwners.setLocation((int)point.getX(), (int)point.getY() + PANELSIZEINCREMENT);
	
            	contentPanel.revalidate();
            	
            	JClientPanel clientPanel = new JClientPanel();
            	contentPanel.add(clientPanel);
            	clientPanelList.add(clientPanel);           	
            	
            	if(clientPanelList.size() == 1){
            		            	
	            	clientPanel.setLocation(0, CLIENTSTARTLOCATION);
	            		            	
	            	contentPanel.repaint();
            	
            	}else{            		           			            	            		            		            		
            		
	            	clientPanel.setLocation(0, CLIENTSTARTLOCATION + panelBaseLocationOwners);
	            	
	            	panelBaseLocationOwners = panelBaseLocationOwners + PANELSIZEINCREMENT;
	            		            		           	            	
	            	contentPanel.repaint();
            		
            	}
            	
            }
    	});  	
    	
    }
    
    private void addAuthorizedButtonAction(JButton addAuthorized){
    	
    	addAuthorized.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            	Dimension dimension = contentPanel.getSize();           	
            	contentPanel.setPreferredSize(new Dimension((int)dimension.getWidth(), (int)dimension.getHeight() + PANELSIZEINCREMENT));
            	
            	dimension = panelOwners.getSize();
            	panelOwners.setSize((int)dimension.getWidth(), (int)dimension.getHeight() + PANELSIZEINCREMENT);
            	
            	Point point = panelAuthorized.getLocation();
            	panelAuthorized.setLocation((int)point.getX(), (int)point.getY() + PANELSIZEINCREMENT);
            	
            	contentPanel.revalidate();
            	
            	JClientPanel authorizedPanel = new JClientPanel();
            	panelOwners.add(authorizedPanel);
            	authorizedPanelList.add(authorizedPanel);
            	
            	if(authorizedPanelList.size() == 1){
	            	
	            	authorizedPanel.setLocation(0, AUTHORIZEDSTARTLOCATION);
	            		            	
	            	panelOwners.repaint();
            	
            	}else{            		           		
	            	                    		            		
	            	authorizedPanel.setLocation(0, AUTHORIZEDSTARTLOCATION + panelBaseLocationAuthorized);
	            	
	            	panelBaseLocationAuthorized = panelBaseLocationAuthorized + PANELSIZEINCREMENT;
	            		            	
	            	panelOwners.repaint();
            		
            	}
            	           	
            	
            }
    	}); 	
    	
    }
    
}
