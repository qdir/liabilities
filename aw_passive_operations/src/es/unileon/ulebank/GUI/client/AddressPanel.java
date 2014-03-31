/* Application developed for AW subject, belonging to passive operations
 group.*/

package es.unileon.ulebank.GUI.client;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Eva
 */
public class AddressPanel extends JPanel {
    private final JLabel address;
    private final JLabel number;
    private final JLabel portal;
    private final JLabel locality;
    private final JLabel postalCode;
    private final JLabel city;
    private final JLabel door;
    
    private JTextField enterpriseAddressText;
    private JTextField numberText;
    private JTextField portalText;
    private JTextField localityText;
    private JTextField postalCodeText;
    private JTextField cityText;
    private JTextField doorText;
    
    public AddressPanel(){
    
        address = new JLabel("*Calle: ", JLabel.RIGHT);
        number = new JLabel("Numero: ", JLabel.RIGHT);
        portal = new JLabel("Portal: ", JLabel.RIGHT);
        locality = new JLabel("*Localidad: ", JLabel.RIGHT);
        postalCode = new JLabel("*Codigo Postal: ", JLabel.RIGHT);
        city = new JLabel("*Provincia: ", JLabel.RIGHT);
        door = new JLabel("Puerta: ", JLabel.RIGHT);
        
        enterpriseAddressText = new JTextField(20);
        numberText = new JTextField(4);
        portalText = new JTextField(4);
        localityText = new JTextField(4);
        postalCodeText = new JTextField(4);
        cityText = new JTextField(4);
        doorText = new JTextField(4);
       
        this.setLayout(new GridBagLayout());
        GridBagConstraints constr = new GridBagConstraints();
        
         //Company Address: Street    
        constr.insets = new Insets(5, 0, 5, 0);
        constr.gridwidth = 1;//Ocupa solo una fila
        this.add(address, constr);
        constr.gridwidth = GridBagConstraints.REMAINDER; //salto de linea
        this.add(enterpriseAddressText, constr);
        //Address: Portal
        constr.gridwidth = 1;
        this.add(portal, constr);
        this.add(portalText, constr);
        //Address: number
        this.add(number, constr);
        this.add(numberText, constr);
        //Address: letra
        this.add(door, constr);
        this.add(doorText, constr);
        //Address: zity code
        this.add(postalCode, constr);
        constr.gridwidth = GridBagConstraints.REMAINDER; //Si quitamos esto, nos pondrá toodo en la misma fila
        this.add(postalCodeText, constr);
        //Address: locality
        constr.gridwidth = 1;
        this.add(locality, constr);
        this.add(localityText, constr);
        //Address: city
        this.add(city, constr);
        constr.gridwidth = GridBagConstraints.REMAINDER;
        this.add(cityText, constr);
        
    }
}
