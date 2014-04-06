/* Application developed for AW subject, belonging to passive operations
 group.*/

package es.unileon.ulebank.GUI.account;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
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
public class HolderPanel extends JPanel {
    
    private JLabel holder;
    private JLabel DNI;
    private JTextField holderText;
    private JTextField DNIText; 
    private JLabel blanco;
    private JButton delete;
    
    public HolderPanel() {
        
        super();
        
        holder = new JLabel("Nombre: ");
        holderText = new JTextField(20);
        DNI = new JLabel("NIF-CIF: ");
        DNIText = new JTextField(10);
        blanco = new JLabel("          ");
        delete = new JButton("Eliminar");
        
        this.setLayout(new GridBagLayout());

        GridBagConstraints constra = new GridBagConstraints();
        
        constra.gridx = 0; 
        constra.gridy = 0;  
        constra.gridwidth = 1; 
        constra.gridheight = 1;
        this.add(holder, constra);
        
        constra.gridx = 1;
        this.add(holderText, constra);
        
        constra.gridx = 2;
        this.add(blanco, constra);
        
        constra.gridx = 3;
        this.add(DNI, constra);
        
        constra.gridx = 4;
        this.add(DNIText, constra);
        
        constra.gridx = 5;
        this.add(delete, constra);
        
        delete.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    
                }
        });
    }
    
    public JTextField getHolderText() {
        return holderText;
    }

    public void setHolderText(JTextField holderText) {
        this.holderText = holderText;
    }
    
    public JTextField getDNIText() {
        return DNIText;
    }

    public void setDNIText(JTextField DNIText) {
        this.DNIText = DNIText;
    }
}
