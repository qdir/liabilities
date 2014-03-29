package es.unileon.ulebank.GUI.client;
//prueba

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import es.unileon.ulebank.client.Client;
import es.unileon.ulebank.client.types.Person;
import es.unileon.ulebank.client.types.data.Address;
import es.unileon.ulebank.temporary.TemporaryClients;
import java.util.Calendar;
import java.util.Date;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;

public class ClientsGUI extends GUIOperations {

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
    private final JTextField letterText;
    private final JTextField professionText;

    
    //
    private JTextField DNIText;
    private JTextField birthdateText;
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
    private final JPanel buttonPanel;
    private final JPanel calendarPanel;
    private final JButton continueButton;
    private final JButton cancelButton;
    private final JButton deleteField;

    /*
     Other variables
     */
    private int dni;
    private TemporaryClients clientT;
    private Person person;
    
   private com.toedter.calendar.JDateChooser jDateChooser;
    /*
     Constructor of the interface
     */
    public ClientsGUI(Client client) {
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

        birthdate = new JLabel("*Fecha de nacimiento(dd/mm/aa): ", JLabel.RIGHT);
        birthdateText = new JTextField(23);
        /////////////////////////////////////
        address = new JLabel("*Calle ", JLabel.RIGHT);
        addressText = new JTextField();

        number = new JLabel("Numero: ", JLabel.RIGHT);
        numberText = new JTextField(4);
        
        letter = new JLabel("Letra: ", JLabel.RIGHT);
        letterText = new JTextField(4);

        portal = new JLabel("Portal: ", JLabel.RIGHT);
        portalText = new JTextField(4);

        postalCode = new JLabel("*CP: ", JLabel.RIGHT);
        postalCodeText = new JTextField();

        locality = new JLabel("Localidad: ", JLabel.RIGHT);
        localityText = new JTextField();

        city = new JLabel("Ciudad: ", JLabel.RIGHT);
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
        jDateChooser = new JDateChooser();
        //jDateChooser.setSize(95,20);
        calendarPanel.add(jDateChooser);
        /*
         Creation of the elements in the menu
         */
        accountType = new JLabel("Tipo de cuenta: ", JLabel.RIGHT);
        accountTypeSeleccion = new Choice();
        accountTypeSeleccion.addItem("Cuenta a la vista");
        accountTypeSeleccion.addItem("Cuenta comercial");
        accountTypeSeleccion.addItem("Cuenta corriente");

        buttonPanel = new JPanel();
        continueButton = new JButton("CONTINUAR");
        cancelButton = new JButton("CANCELAR");
        deleteField = new JButton("RESET");

        //Asignamos a la ventana principal el layout GridBagLayout
        this.setLayout(new GridBagLayout());
        //tamaño de la ventana
        this.setSize(700, 400);
        //No se podra modificar el tamaño
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        
        

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
        add(surname, constr);
        constr.gridwidth = GridBagConstraints.REMAINDER;
        add(surnameText, constr);

        //Address: Street
        constr.gridwidth = 1;//Ocupa solo una fila
        add(address, constr);
        constr.gridwidth = GridBagConstraints.REMAINDER; //salto de linea
        add(addressText, constr);
        //Address: Portal
        constr.gridwidth = 1;
        add(portal, constr);
        add(portalText, constr);
        //Address: number
        add(number, constr);
        add(numberText, constr);
        //Address: letra
        add(letter, constr);
        add(letterText, constr);
        //Address: zity code
        add(postalCode, constr);
        constr.gridwidth = GridBagConstraints.REMAINDER; //Si quitamos esto, nos pondrá toodo en la misma fila
        add(postalCodeText, constr);
        //Address: locality
        constr.gridwidth = 1;
        add(locality, constr);
        add(localityText, constr);
        //Address: city
        add(city, constr);
        constr.gridwidth = GridBagConstraints.REMAINDER;
        add(cityText, constr);

        //DNI
        constr.fill = GridBagConstraints.HORIZONTAL;
        constr.anchor = GridBagConstraints.EAST;
        constr.gridwidth = 1;
        add(DNI, constr);
        constr.gridwidth = GridBagConstraints.REMAINDER;
        add(DNIText, constr);

        //Birthdate
        constr.fill = GridBagConstraints.HORIZONTAL;
        constr.anchor = GridBagConstraints.WEST;
        constr.gridwidth = 1;
        add(birthdate, constr);
        constr.gridwidth = GridBagConstraints.REMAINDER;
        add(calendarPanel, constr);
        //add(birthdateText, constr);

        //Marital Status
        constr.gridwidth = 1;
        add(maritalStatus, constr);
        constr.gridwidth = GridBagConstraints.REMAINDER;
        add(maritalStatusText, constr);

        //Profession
        constr.gridwidth = 1;
        add(profession, constr);
        constr.gridwidth = GridBagConstraints.REMAINDER;
        add(professionText, constr);
        
        //Phones
        constr.gridwidth = 1;
        add(phone, constr);
        add(phoneText1, constr);
        add(phone2, constr);
        constr.gridwidth = GridBagConstraints.REMAINDER;
        add(phoneText2, constr);

        //type of account
        constr.gridwidth = 1;
        add(accountType, constr);
        constr.gridwidth = GridBagConstraints.REMAINDER;
        add(accountTypeSeleccion, constr);

        //Continue, reset and cancel buttons,used FlowLayout(izq a dcha)
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(cancelButton);
        buttonPanel.add(deleteField);
        buttonPanel.add(continueButton);

        constr.anchor = GridBagConstraints.SOUTH;
        constr.insets = new Insets(25, 0, 0, 0);
        add(buttonPanel, constr);

        if (person != null) {
            nameText.setText(person.getName());
            surnameText.setText(person.getSurnames());
            maritalStatusText.setText(person.getCivilState());
            DNIText.setText(person.getId().toString());
            phoneText1.setText(Integer.toString(person.getPhoneNumber(0)));
            phoneText2.setText(Integer.toString(person.getPhoneNumber(1)));
            professionText.setText(person.getProfession());
            Address addressRcv = person.getAddress();
            letterText.setText(Character.toString(addressRcv.getDoor()));
            portalText.setText(Integer.toString(addressRcv.getBlockNumber()));
            numberText.setText(Integer.toString(addressRcv.getFloor()));
            postalCodeText.setText(Integer.toString(addressRcv.getZipCode()));
            addressText.setText(addressRcv.getStreet());
            cityText.setText(addressRcv.getProvince());
            localityText.setText(addressRcv.getLocality());
            
        }
        /*
         The fields that only accepts numbers or digits
         */
        phoneText1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                onlyNumbers(e);
            }
        });
        phoneText2.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                onlyNumbers(e);
            }
        });
        postalCodeText.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                onlyNumbers(e);
            }
        });

        /*
         The accions when someone select one button
         */
        continueButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                validate(nameText);
                validate(surnameText);
                validate(addressText);
                validate(postalCodeText);
                validate(DNIText);
                validate(birthdateText);
                validate(maritalStatusText);
                validate(phoneText1);

                if (validate(nameText)
                        && validate(surnameText)
                        && validate(addressText)
                        && validate(postalCodeText)
                        && validate(DNIText)
                        && validate(birthdateText)
                        && validate(maritalStatusText)
                        && validate(phoneText1)) {

                    /*
                     When all the obligatory elements are completed, we proceded to create the clients:
                     FIRST: Comprobate if the second number(not obligatory) is a number
                     SECOND: Get the Passport without letter and get the letter alone.
                     THIRD: Create the client.
                     */
                    //FIRST
                    int phone2;
                    if (phoneText2.getText().compareTo("") == 0) {
                        phone2 = 0;
                    } else {
                        phone2 = Integer.parseInt(phoneText2.getText());
                    }

                    //SECOND
                    Character caracter = DNIText.getText().charAt(DNIText.getText().length() - 1);
                    try {
                        //Quitamos la letra al DNI
                        dni = Integer.parseInt(DNIText.getText().substring(0, DNIText.getText().length() - 1));
                    } catch (NumberFormatException ex) {
                        ex.printStackTrace();
                    }
                    //THIRD
                    if (Character.isLetter(caracter)) {
                        System.out.println("Es una letra");
                        Address finalAddress = new Address(addressText.getText(), Integer.parseInt(portalText.getText()), Integer.parseInt(numberText.getText()), (char) 0, localityText.getText(), cityText.getText(), Integer.parseInt(postalCodeText.getText()));
                        Person person = new Person(nameText.getText(), surnameText.getText(), null, maritalStatusText.getText(), Integer.parseInt(phoneText1.getText()), phone2, null, dni, caracter);
                        System.out.println("Hemos creado al cliente con dni " + dni);

                        //Test
                        clientT = new TemporaryClients();
                        clientT.addClient(person);

                    }
                    /*Aqui se pasa a la ventana de los autorizados
                     pasandole: person y el tipo del seleccionable
                     */
                    //System.out.println(person.getId().toString());
                } else {
                    System.out.println("No validado");
                }
            }
        });
        deleteField.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                deleteFields(nameText);
                deleteFields(surnameText);
                deleteFields(addressText);
                deleteFields(portalText);
                deleteFields(numberText);
                deleteFields(postalCodeText);
                deleteFields(DNIText);
                deleteFields(birthdateText);
                deleteFields(maritalStatusText);
                deleteFields(phoneText1);
                deleteFields(phoneText2);
                deleteFields(localityText);
                deleteFields(cityText);
            }
        });

        //Accion al cerrar la ventana
        //this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
