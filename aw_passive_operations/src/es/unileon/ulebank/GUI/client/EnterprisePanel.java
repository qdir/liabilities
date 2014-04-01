/* Application developed for AW subject, belonging to passive operations
 group.*/
package es.unileon.ulebank.GUI.client;

import java.awt.Choice;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/**
 *
 * @author Eva
 */
public class EnterprisePanel extends JPanel {
    /*
     Variable declaration of the labels in the graphical interface
     */
   
    private final JLabel businessName; //Razon Social
    //Address Company
    private final JLabel companyAddress;
    private final JLabel contactCompanyAddress;
    private final JLabel otherInformation;
    
   
    private final JLabel address;
    private final JLabel number;
    private final JLabel portal;
    private final JLabel locality;
    private final JLabel postalCode;
    private final JLabel city;
    private final JLabel door;
    //
    private final JLabel phone;
    private final JLabel fax;
    //Address Contact
    private final JLabel contactAddress;
    private final JLabel contactNumber;
    private final JLabel contactPortal;
    private final JLabel contactLocality;
    private final JLabel contactPostalCode;
    private final JLabel contactCity;
    private final JLabel contactDoor;
    //
    private final JLabel contactPerson;
    private final JLabel position;
    private final JLabel creationDate;
    private final JLabel CIF;
    private final JLabel CNAE;
    private final JLabel legalForm;//Desplegable opciones
    private final JLabel sector;
    private final JLabel email;

    /*
     Variable declaration of the edit text in the graphical interface
     */
    private JTextField businessNameText; //Razon Social
    //Address Company
    private JTextField enterpriseAddressText;
    private JTextField numberText;
    private JTextField portalText;
    private JTextField localityText;
    private JTextField postalCodeText;
    private JTextField cityText;
    private JTextField doorText;
    //
    private JTextField phoneText;
    private JTextField faxText;
    //Address Contact
    private JTextField contactAddressText;
    private JTextField contactNumberText;
    private JTextField contactPortalText;
    private JTextField contactLocalityText;
    private JTextField contactPostalCodeText;
    private JTextField contactCityText;
    private JTextField contactDoorText;
    //
    private JTextField contactPersonText;
    private JTextField positionText;
    private JTextField creationDateText;
    private JTextField CIFText;
    private JTextField CNAEText;
    private Choice legalFormSelection;//Desplegable opciones
    private JTextField sectorText;
    private JTextField emailText;

    public EnterprisePanel() {
        super();        
        
        /*
        Declaration of labels
        */
        companyAddress = new JLabel("<html><u><bold><b1>DIRECCION DE LA EMPRESA</u></bold></b1></html>", JLabel.CENTER);
        contactCompanyAddress = new JLabel("<html><u><bold><b1>DIRECCION DE CONTACTO</u></bold></b1></html>", JLabel.CENTER);
        otherInformation = new JLabel("<html><u><bold><b1>OTROS DATOS</u></bold></b1></html>", JLabel.CENTER);
        
        businessName = new JLabel("*Razón social: ", JLabel.RIGHT); //Razon Social
        //Address Company
        address = new JLabel("*Calle: ", JLabel.RIGHT);
        number = new JLabel("Numero: ", JLabel.RIGHT);
        portal = new JLabel("Portal: ", JLabel.RIGHT);
        locality = new JLabel("*Localidad: ", JLabel.RIGHT);
        postalCode = new JLabel("*Codigo Postal: ", JLabel.RIGHT);
        city = new JLabel("*Provincia: ", JLabel.RIGHT);
        door = new JLabel("Puerta: ", JLabel.RIGHT);
        /////////////////////
        phone = new JLabel("*Telefono: ", JLabel.RIGHT);
        fax = new JLabel("*Fax: ", JLabel.RIGHT);
        //Address Contact
        contactAddress = new JLabel("*Calle: ", JLabel.RIGHT);
        contactNumber = new JLabel("Numero: ", JLabel.RIGHT);
        contactPortal = new JLabel("Portal: ", JLabel.RIGHT);
        contactLocality = new JLabel("*Localidad: ", JLabel.RIGHT);
        contactPostalCode = new JLabel("*Codigo Postal: ", JLabel.RIGHT);
        contactCity = new JLabel("*Provincia: ", JLabel.RIGHT);
        contactDoor = new JLabel("Puerta: ", JLabel.RIGHT);
        /////////////////////
        contactPerson = new JLabel("*Persona de contacto: ", JLabel.RIGHT);
        position = new JLabel("*cargo: ", JLabel.RIGHT);
        creationDate = new JLabel("*Fecha de constitucion: ", JLabel.RIGHT);
        CIF = new JLabel("*CIF: ", JLabel.RIGHT);
        CNAE = new JLabel("*CNAE: ", JLabel.RIGHT);
        legalForm = new JLabel("*Forma jurídica: ", JLabel.RIGHT);//Desplegable opciones
        sector = new JLabel("*Sector: ", JLabel.RIGHT);
        email = new JLabel("*E-mail: ", JLabel.RIGHT);

        /*
        Declaration of fields
        */
        businessNameText = new JTextField(10); //Razon Social
        //Address Company
        enterpriseAddressText = new JTextField(20);
        numberText = new JTextField(4);
        portalText = new JTextField(4);
        localityText = new JTextField(4);
        postalCodeText = new JTextField(4);
        cityText = new JTextField(4);
        doorText = new JTextField(4);
        //
        phoneText = new JTextField(10);
        faxText = new JTextField(10);
        //Address Contact
        contactAddressText = new JTextField();
        contactNumberText = new JTextField();
        contactPortalText = new JTextField();
        contactLocalityText = new JTextField();
        contactPostalCodeText = new JTextField();
        contactCityText = new JTextField();
        contactDoorText = new JTextField();
        //
        contactPersonText = new JTextField(10);
        positionText = new JTextField(10);
        creationDateText = new JTextField(10);
        CIFText = new JTextField(10);
        CNAEText = new JTextField();
        legalFormSelection = new Choice();//Desplegable opciones
        sectorText = new JTextField();
        emailText = new JTextField();
        
        legalFormSelection.addItem("Tipo1");
        legalFormSelection.addItem("Tipo2");
        legalFormSelection.addItem("Tipo3");
        legalFormSelection.addItem("Tipo4");
        legalFormSelection.addItem("Tipo5");
        legalFormSelection.addItem("Tipo6");
        legalFormSelection.addItem("Tipo7");
        legalFormSelection.addItem("Tipo8");
        legalFormSelection.addItem("Tipo9");
        legalFormSelection.addItem("Tipo10");
        
        this.setLayout(new GridBagLayout());
        GridBagConstraints constr = new GridBagConstraints();
        
        //Bussines Name
        constr.insets = new Insets(50, 0, 0, 0);
        constr.fill = GridBagConstraints.HORIZONTAL;
        constr.anchor = GridBagConstraints.WEST;
        
        constr.gridwidth = 1;
        this.add(businessName, constr); //Añadimos el elemento y sus propiedades para que se situe donde queremos
        constr.gridwidth = GridBagConstraints.REMAINDER;
        add(businessNameText, constr);
        
        //Company Address: Street    
        constr.insets = new Insets(20, 0, 10, 0);
        constr.gridwidth = GridBagConstraints.REMAINDER;
        this.add(companyAddress, constr);
        constr.insets = new Insets(5, 0, 0, 0);
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
        
        //Contact Address: Street
        constr.gridwidth = GridBagConstraints.REMAINDER;
        constr.insets = new Insets(20, 0, 10, 0);
        this.add(contactCompanyAddress, constr);
        
        constr.insets = new Insets(5, 0, 0, 0);
        constr.gridwidth = 1;//Ocupa solo una fila
        this.add(contactAddress, constr);
        
        constr.gridwidth = GridBagConstraints.REMAINDER; //salto de linea
        this.add(contactAddressText, constr);
        //Address: Portal
        constr.gridwidth = 1;
        this.add(contactPortal, constr);
        this.add(contactPortalText, constr);
        //Address: number
        this.add(contactNumber, constr);
        this.add(contactNumberText, constr);
        //Address: letra
        this.add(contactDoor, constr);
        this.add(contactDoorText, constr);
        //Address: zity code
        this.add(contactPostalCode, constr);
        constr.gridwidth = GridBagConstraints.REMAINDER; //Si quitamos esto, nos pondrá toodo en la misma fila
        this.add(contactPostalCodeText, constr);
        //Address: locality
        constr.insets = new Insets(5, 0, 20, 0);
        constr.gridwidth = 1;
        this.add(contactLocality, constr);
        this.add(contactLocalityText, constr);
        //Address: city
        this.add(contactCity, constr);
        constr.gridwidth = GridBagConstraints.REMAINDER;
        this.add(contactCityText, constr);

        //Other information
        constr.insets = new Insets(20, 0, 10, 0);
        constr.gridwidth = GridBagConstraints.REMAINDER;
        this.add(otherInformation, constr);
        //Phone and Fax
        constr.insets = new Insets(5, 0, 0, 0);
        constr.gridwidth = 1;
        this.add(phone,constr);
        this.add(phoneText, constr);
        this.add(fax,constr);
        constr.gridwidth = GridBagConstraints.REMAINDER;
        this.add(faxText, constr);
        //Contact person and his position
        constr.gridwidth = 1;
        this.add(contactPerson,constr);
        this.add(contactPersonText,constr);
        this.add(position,constr);
        constr.gridwidth = GridBagConstraints.REMAINDER;
        this.add(positionText,constr);
        //Creation date
        constr.gridwidth = 1;
        this.add(creationDate, constr);
        constr.gridwidth = GridBagConstraints.REMAINDER;
        this.add(creationDateText, constr);
        //CIF - CNAE
        constr.gridwidth = 1;
        this.add(CIF,constr);
        this.add(CIFText, constr);
        this.add(CNAE,constr);
        constr.gridwidth = GridBagConstraints.REMAINDER;
        this.add(CNAEText,constr);
        //Forma juridica
         constr.gridwidth = 1;
        this.add(legalForm,constr);
        constr.gridwidth = GridBagConstraints.REMAINDER;
        this.add(legalFormSelection,constr);
        //Sector
        constr.insets = new Insets(5, 0, 50, 0);
        constr.gridwidth = 1;
        this.add(sector, constr);
        this.add(sectorText,constr);
        //Email
        this.add(email,constr);
        constr.gridwidth = GridBagConstraints.REMAINDER;
        this.add(emailText,constr);
        
        
        this.setVisible(true);
    }

    
    public JTextField getBusinessNameText() {
        return businessNameText;
    }

    public void setBusinessNameText(JTextField businessNameText) {
        this.businessNameText = businessNameText;
    }

    public JTextField getContactPersonText() {
        return contactPersonText;
    }

    public void setContactPersonText(JTextField contactPersonText) {
        this.contactPersonText = contactPersonText;
    }

    public JTextField getPositionText() {
        return positionText;
    }

    public void setPositionText(JTextField positionText) {
        this.positionText = positionText;
    }

    public JTextField getCreationDateText() {
        return creationDateText;
    }

    public void setCreationDateText(JTextField creationDateText) {
        this.creationDateText = creationDateText;
    }

    public JTextField getCIFText() {
        return CIFText;
    }

    public void setCIFText(JTextField CIFText) {
        this.CIFText = CIFText;
    }

    public JTextField getCNAEText() {
        return CNAEText;
    }

    public void setCNAEText(JTextField CNAEText) {
        this.CNAEText = CNAEText;
    }

    public Choice getLegalFormSelection() {
        return legalFormSelection;
    }

    public void setLegalFormSelection(Choice legalFormSelection) {
        this.legalFormSelection = legalFormSelection;
    }

    public JTextField getSectorText() {
        return sectorText;
    }

    public void setSectorText(JTextField sectorText) {
        this.sectorText = sectorText;
    }

    public JTextField getEmailText() {
        return emailText;
    }

    public void setEmailText(JTextField emailText) {
        this.emailText = emailText;
    }
           
}
