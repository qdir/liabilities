/* Application developed for AW subject, belonging to passive operations
 group.*/

package es.unileon.ulebank.GUI.account;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author JesusNieto
 */
public class AuthorizedPanel extends JPanel {
    
    private JLabel authorized;
    private JLabel DNI;
    private JTextField authorizedText;
    private JTextField DNIText; 
    private JLabel blanco;
    private JButton delete;
    private JButton add;
    private AccountGUI accountPanel;
    private JPanel currentPanel;
    
    public AuthorizedPanel(AccountGUI accountPanelPass) {
        currentPanel=this;
        authorized = new JLabel("Nombre: ");
        authorizedText = new JTextField(20);
        DNI = new JLabel("NIF-CIF: ");
        DNIText = new JTextField(10);
        blanco = new JLabel("          ");
        delete = new JButton("Eliminar");
        add = new JButton("Anadir");
        
        this.setLayout(new GridBagLayout());

        GridBagConstraints constra = new GridBagConstraints();
        
        constra.gridx = 0; 
        constra.gridy = 0;  
        constra.gridwidth = 1; 
        constra.gridheight = 1;
        this.add(authorized, constra);
        
        constra.gridx = 1;
        this.add(authorizedText, constra);
        
        constra.gridx = 2;
        this.add(blanco, constra);
        
        constra.gridx = 3;
        this.add(DNI, constra);
        
        constra.gridx = 4;
        this.add(DNIText, constra);
        
        constra.gridx = 5;
        this.add(delete, constra);
        
        constra.gridy = 1;
        constra.gridx = 0;
        this.add(add, constra);
        
        
        delete.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                   accountPanel.deleteAuthorized();
                   delete.setVisible(false);
                   currentPanel.getParent().remove(currentPanel);
                }
        });
        
        add.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                   add.setVisible(false);
                }
        });
    }
    
    
}
