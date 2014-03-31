/* Application developed for AW subject, belonging to passive operations
 group.*/
package es.unileon.ulebank.GUI.client;

import com.toedter.calendar.JDateChooser;
import es.unileon.ulebank.client.Client;
import es.unileon.ulebank.client.types.Person;
import es.unileon.ulebank.temporary.TemporaryClients;
import java.awt.Choice;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Date;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Eva
 */
public class PersonPanel extends JPanel {
    /*
     Variable declaration of the labels in the graphical interface
     */

    private final JLabel name;
    private final JLabel surname;
    //Address
    private final JLabel address;
    private final JLabel number;
    private final JLabel portal;
    private final JLabel locality;
    private final JLabel postalCode;
    private final JLabel city;
    private final JLabel letter;
    //
    private final JLabel DNI;
    private final JLabel birthdate;
    private final JLabel maritalStatus;
    private final JLabel phone;
    private final JLabel phone2;
    private final JLabel accountType;
    private final JLabel profession;

    /*
     Variable declaration of the edit text in the graphical interface
     */
    private JTextField nameText;
    private JTextField surnameText;
    //Address
    private JTextField addressText;
    private JTextField numberText;
    private JTextField portalText;
    private JTextField localityText;
    private JTextField postalCodeText;
    private JTextField cityText;
    private JTextField letterText;
    private JTextField professionText;
    private JTextField DNIText;
    //private JTextField birthdateText;
    private JTextField maritalStatusText;
    private JTextField phoneText1;
    private JTextField phoneText2;
    /*
     Creation of the menu in that we could select the type of the account
     */
    private final Choice accountTypeSeleccion;

    /*
     Creation of the button panel and the buttons
     */
    private final JPanel calendarPanel;

    /*
     Other variables
     */
    private int dni;
    private TemporaryClients clientT;
    private Person person;

    private com.toedter.calendar.JDateChooser jdateChooser;
    private final Date actualDate;

    /**
     * Constructor of the interface
     *
     * @param client
     */
    public PersonPanel(Client client) {
        super();

        person = (Person) client;
        /*
         Creation of the label and the field
         */
        name = new JLabel("*Nombre: ", JLabel.RIGHT);
        nameText = new JTextField(23);

        surname = new JLabel("*Apellidos:", JLabel.RIGHT);
        surnameText = new JTextField(23);

        DNI = new JLabel("*DNI: ", JLabel.RIGHT);
        DNIText = new JTextField(23);

        birthdate = new JLabel("*Fecha de nacimiento(dd/mm/aaaa): ", JLabel.RIGHT);

        address = new JLabel("*Calle ", JLabel.RIGHT);
        addressText = new JTextField();

        number = new JLabel("Numero: ", JLabel.RIGHT);
        numberText = new JTextField(4);

        letter = new JLabel("Letra: ", JLabel.RIGHT);
        letterText = new JTextField(4);

        portal = new JLabel("Portal: ", JLabel.RIGHT);
        portalText = new JTextField(4);

        postalCode = new JLabel("*CP: ", JLabel.RIGHT);
        postalCodeText = new JTextField(4);

        locality = new JLabel("Localidad: ", JLabel.RIGHT);
        localityText = new JTextField();

        city = new JLabel("Provincia: ", JLabel.RIGHT);
        cityText = new JTextField();
        //////////////////////////////////////

        maritalStatus = new JLabel("*Estado civil: ", JLabel.RIGHT);
        maritalStatusText = new JTextField(15);

        profession = new JLabel("*Profesion: ", JLabel.RIGHT);
        professionText = new JTextField(15);

        phone = new JLabel("*Telefono: ", JLabel.RIGHT);
        phoneText1 = new JTextField(10);

        phone2 = new JLabel("Telefono: ", JLabel.RIGHT);
        phoneText2 = new JTextField(10);

        calendarPanel = new JPanel();
        calendarPanel.setLayout(new BoxLayout(calendarPanel, BoxLayout.X_AXIS));
        jdateChooser = new JDateChooser();
        actualDate = new Date();
        jdateChooser.setMaxSelectableDate(actualDate);

        //jDateChooser.setSize(95,20);
        calendarPanel.add(jdateChooser);
        /*
         Creation of the elements in the menu
         */
        accountType = new JLabel("Tipo de cuenta: ", JLabel.RIGHT);
        accountTypeSeleccion = new Choice();
        accountTypeSeleccion.addItem("Cuenta a la vista");
        accountTypeSeleccion.addItem("Cuenta comercial");
        accountTypeSeleccion.addItem("Cuenta corriente");

        //Asignamos a la ventana principal el layout GridBagLayout
        this.setLayout(new GridBagLayout());

        //We create the settings for the layout. It determine the position of the elements
        GridBagConstraints constr = new GridBagConstraints();
        /*Fill: indica cuanto se estira un componente.
         anchor: Indica la posicion
         insets: margenes respecto a los otros componentes
         gridwidth: ancho del componente (numero de filas que ocupa)
         gridheight: alto del componente
         http://www.chuidiang.com/java/layout/GridBagLayout/GridBagLayout.php
         */

        //Name
        constr.fill = GridBagConstraints.HORIZONTAL;
        constr.anchor = GridBagConstraints.WEST;
        constr.insets = new Insets(5, 0, 0, 0);
        constr.gridwidth = 1;
        this.add(name, constr); //Añadimos el elemento y sus propiedades para que se situe donde queremos
        constr.gridwidth = GridBagConstraints.REMAINDER;
        add(nameText, constr);

        //Surname
        constr.fill = GridBagConstraints.HORIZONTAL;
        constr.gridwidth = 1;
        this.add(surname, constr);
        constr.gridwidth = GridBagConstraints.REMAINDER;
        this.add(surnameText, constr);

        //Address: Street
        constr.gridwidth = 1;//Ocupa solo una fila
        this.add(address, constr);
        constr.gridwidth = GridBagConstraints.REMAINDER; //salto de linea
        this.add(addressText, constr);
        //Address: Portal
        constr.gridwidth = 1;
        this.add(portal, constr);
        this.add(portalText, constr);
        //Address: number
        this.add(number, constr);
        this.add(numberText, constr);
        //Address: letra
        this.add(letter, constr);
        this.add(letterText, constr);
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

        //DNI
        constr.fill = GridBagConstraints.HORIZONTAL;
        constr.anchor = GridBagConstraints.EAST;
        constr.gridwidth = 1;
        this.add(DNI, constr);
        constr.gridwidth = GridBagConstraints.REMAINDER;
        this.add(DNIText, constr);

        //Birthdate
        constr.fill = GridBagConstraints.HORIZONTAL;
        constr.anchor = GridBagConstraints.WEST;
        constr.gridwidth = 1;
        this.add(birthdate, constr);
        constr.gridwidth = GridBagConstraints.REMAINDER;
        this.add(calendarPanel, constr);
        //add(birthdateText, constr);

        //Marital Status
        constr.gridwidth = 1;
        this.add(maritalStatus, constr);
        constr.gridwidth = GridBagConstraints.REMAINDER;
        this.add(maritalStatusText, constr);

        //Profession
        constr.gridwidth = 1;
        this.add(profession, constr);
        constr.gridwidth = GridBagConstraints.REMAINDER;
        this.add(professionText, constr);

        //Phones
        constr.gridwidth = 1;
        this.add(phone, constr);
        this.add(phoneText1, constr);
        this.add(phone2, constr);
        constr.gridwidth = GridBagConstraints.REMAINDER;
        this.add(phoneText2, constr);

        //type of account
        constr.gridwidth = 1;
        this.add(accountType, constr);
        constr.gridwidth = GridBagConstraints.REMAINDER;
        this.add(accountTypeSeleccion, constr);

    }

    public JTextField getNameText() {
        return nameText;
    }

    public void setNameText(JTextField nameText) {
        this.nameText = nameText;
    }

    public JTextField getSurnameText() {
        return surnameText;
    }

    public void setSurnameText(JTextField surnameText) {
        this.surnameText = surnameText;
    }

    public JTextField getAddressText() {
        return addressText;
    }

    public void setAddressText(JTextField addressText) {
        this.addressText = addressText;
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

    public JTextField getDNIText() {
        return DNIText;
    }

    public void setDNIText(JTextField DNIText) {
        this.DNIText = DNIText;
    }

    public JTextField getMaritalStatusText() {
        return maritalStatusText;
    }

    public void setMaritalStatusText(JTextField maritalStatusText) {
        this.maritalStatusText = maritalStatusText;
    }

    public JTextField getPhoneText1() {
        return phoneText1;
    }

    public void setPhoneText1(JTextField phoneText1) {
        this.phoneText1 = phoneText1;
    }

    public JTextField getPhoneText2() {
        return phoneText2;
    }

    public void setPhoneText2(JTextField phoneText2) {
        this.phoneText2 = phoneText2;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public TemporaryClients getClientT() {
        return clientT;
    }

    public void setClientT(TemporaryClients clientT) {
        this.clientT = clientT;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public JDateChooser getJdateChooser() {
        return jdateChooser;
    }

    public void setJdateChooser(JDateChooser jdateChooser) {
        this.jdateChooser = jdateChooser;
    }

    public JTextField getLetterText() {
        return letterText;
    }

    public void setLetterText(JTextField letterText) {
        this.letterText = letterText;
    }

    public JTextField getProfessionText() {
        return professionText;
    }

    public void setProfessionText(JTextField professionText) {
        this.professionText = professionText;
    }
}//End of the class
