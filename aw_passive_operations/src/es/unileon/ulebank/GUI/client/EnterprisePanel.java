/* Application developed for AW subject, belonging to passive operations
 group.*/
package es.unileon.ulebank.GUI.client;

import java.awt.Choice;
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
public class EnterprisePanel extends JPanel {
    /*
     Variable declaration of the labels in the graphical interface
     */

    private final JLabel businessName; //Razon Social
    //Address Company
    private final JLabel companyAddress;
    private final JLabel contactCompanyAddress;
    
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
        companyAddress = new JLabel("DIRECCION DE LA EMPRESA", JLabel.CENTER);
        contactCompanyAddress = new JLabel("DIRECCION DE CONTACTO", JLabel.CENTER);
        
        
        businessName = new JLabel("*Razón social: "); //Razon Social
        //Address Company
        address = new JLabel("*Calle: ");
        number = new JLabel("Numero: ");
        portal = new JLabel("Portal: ");
        locality = new JLabel("*Localidad: ");
        postalCode = new JLabel("*Codigo Postal: ");
        city = new JLabel("*Provincia: ");
        door = new JLabel("Puerta: ");
        /////////////////////
        phone = new JLabel("*Telefono: ");
        fax = new JLabel("*Fax: ");
        //Address Contact
        contactAddress = new JLabel("Direccion de contacto: ");
        contactNumber = new JLabel("Numero: ");
        contactPortal = new JLabel("Portal: ");
        contactLocality = new JLabel("Localidad: ");
        contactPostalCode = new JLabel("Codigo Postal: ");
        contactCity = new JLabel("Provincia: ");
        contactDoor = new JLabel("Puerta: ");
        /////////////////////
        contactPerson = new JLabel();
        position = new JLabel();
        creationDate = new JLabel();
        CIF = new JLabel();
        CNAE = new JLabel();
        legalForm = new JLabel();//Desplegable opciones
        sector = new JLabel();
        email = new JLabel();

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
        contactPersonText = new JTextField();
        positionText = new JTextField();
        creationDateText = new JTextField();
        CIFText = new JTextField();
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
        constr.fill = GridBagConstraints.HORIZONTAL;
        constr.anchor = GridBagConstraints.WEST;
        constr.insets = new Insets(5, 0, 0, 0);
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
        constr.gridwidth = 1;
        this.add(contactLocality, constr);
        this.add(contactLocalityText, constr);
        //Address: city
        this.add(contactCity, constr);
        constr.gridwidth = GridBagConstraints.REMAINDER;
        constr.insets = new Insets(5, 0, 10, 0);
        this.add(contactCityText, constr);

        //Phone and Fax
        constr.insets = new Insets(5, 0, 0, 0);
        constr.gridwidth = 1;
        this.add(phone,constr);
        this.add(phoneText, constr);
        
        this.add(fax,constr);
        this.add(faxText, constr);
        
        this.setVisible(true);
    }

    
    public JTextField getBusinessNameText() {
        return businessNameText;
    }

    public void setBusinessNameText(JTextField businessNameText) {
        this.businessNameText = businessNameText;
    }

    public JTextField getEnterpriseAddressText() {
        return enterpriseAddressText;
    }

    public void setEnterpriseAddressText(JTextField enterpriseAddressText) {
        this.enterpriseAddressText = enterpriseAddressText;
    }

    public JTextField getNumberText() {
        return numberText;
    }

    public void setNumberText(JTextField numberText) {
        this.numberText = numberText;
    }

    public JTextField getPortalText() {
        return portalText;
    }

    public void setPortalText(JTextField portalText) {
        this.portalText = portalText;
    }

    public JTextField getLocalityText() {
        return localityText;
    }

    public void setLocalityText(JTextField localityText) {
        this.localityText = localityText;
    }

    public JTextField getPostalCodeText() {
        return postalCodeText;
    }

    public void setPostalCodeText(JTextField postalCodeText) {
        this.postalCodeText = postalCodeText;
    }

    public JTextField getCityText() {
        return cityText;
    }

    public void setCityText(JTextField cityText) {
        this.cityText = cityText;
    }

    public JTextField getDoorText() {
        return doorText;
    }

    public void setDoorText(JTextField doorText) {
        this.doorText = doorText;
    }

    public JTextField getPhoneText() {
        return phoneText;
    }

    public void setPhoneText(JTextField phoneText) {
        this.phoneText = phoneText;
    }

    public JTextField getFaxText() {
        return faxText;
    }

    public void setFaxText(JTextField faxText) {
        this.faxText = faxText;
    }

    public JTextField getContactAddressText() {
        return contactAddressText;
    }

    public void setContactAddressText(JTextField contactAddressText) {
        this.contactAddressText = contactAddressText;
    }

    public JTextField getContactNumberText() {
        return contactNumberText;
    }

    public void setContactNumberText(JTextField contactNumberText) {
        this.contactNumberText = contactNumberText;
    }

    public JTextField getContactPortalText() {
        return contactPortalText;
    }

    public void setContactPortalText(JTextField contactPortalText) {
        this.contactPortalText = contactPortalText;
    }

    public JTextField getContactLocalityText() {
        return contactLocalityText;
    }

    public void setContactLocalityText(JTextField contactLocalityText) {
        this.contactLocalityText = contactLocalityText;
    }

    public JTextField getContactPostalCodeText() {
        return contactPostalCodeText;
    }

    public void setContactPostalCodeText(JTextField contactPostalCodeText) {
        this.contactPostalCodeText = contactPostalCodeText;
    }

    public JTextField getContactCityText() {
        return contactCityText;
    }

    public void setContactCityText(JTextField contactCityText) {
        this.contactCityText = contactCityText;
    }

    public JTextField getContactDoorText() {
        return contactDoorText;
    }

    public void setContactDoorText(JTextField contactDoorText) {
        this.contactDoorText = contactDoorText;
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
    
    public static void main(String[] args) {
       EnterprisePanel epanel = new EnterprisePanel();
    }
    
    
}
