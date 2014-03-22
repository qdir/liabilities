package es.unileon.ulebank.GUI.client;
//prueba
import es.unileon.ulebank.client.types.Person;
import es.unileon.ulebank.temporary.TemporaryClients;
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
    private final JLabel city;
    private final JLabel postalCode;
    private final JLabel country;
    //
    private final JLabel DNI;
    private final JLabel birthdate;
    private final JLabel maritalStatus;
    private final JLabel phone;
    private final JLabel phone2;
    private final JLabel accountType;

    /*
     Variable declaration of the edit text in the graphical interface
     */
    private JTextField nameText;
    private JTextField surnameText;
    //Address
    private JTextField addressText;
    private JTextField numberText;
    private JTextField portalText;
    private JTextField cityText;
    private JTextField postalCodeText;
    private JTextField countryText;
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
    private final JButton continueButton;
    private final JButton cancelButton;
    private final JButton deleteField;

    /*
     Other variables
     */
    private int dni;
    private TemporaryClients clientT;

    /*
     Constructor of the interface
     */
    public ClientsGUI() {
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

        number = new JLabel("Portal: ", JLabel.RIGHT);
        numberText = new JTextField(4);

        portal = new JLabel("Piso: ", JLabel.RIGHT);
        portalText = new JTextField(4);

        postalCode = new JLabel("*CP: ", JLabel.RIGHT);
        postalCodeText = new JTextField();

        city = new JLabel("Ciudad: ", JLabel.RIGHT);
        cityText = new JTextField();

        country = new JLabel("Pais: ", JLabel.RIGHT);
        countryText = new JTextField();
        //////////////////////////////////////

        maritalStatus = new JLabel("*Estado civil: ", JLabel.RIGHT);
        maritalStatusText = new JTextField();

        phone = new JLabel("*Telefono: ", JLabel.RIGHT);
        phoneText1 = new JTextField(10);

        phone2 = new JLabel("Telefono: ", JLabel.RIGHT);
        phoneText2 = new JTextField(10);

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
        //Address: postal code
        add(postalCode, constr);
        constr.gridwidth = GridBagConstraints.REMAINDER; //Si quitamos esto, nos pondrá toodo en la misma fila
        add(postalCodeText, constr);
        //Address: city
        constr.gridwidth = 1;
        add(city, constr);
        add(cityText, constr);
        //Address: country
        add(country, constr);
        constr.gridwidth = GridBagConstraints.REMAINDER;
        add(countryText, constr);

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
        add(birthdateText, constr);

        //Marital Status
        constr.gridwidth = 1;
        add(maritalStatus, constr);
        constr.gridwidth = GridBagConstraints.REMAINDER;
        add(maritalStatusText, constr);

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

                        Person person = new Person(nameText.getText(), surnameText.getText(), null, maritalStatusText.getText(), Integer.parseInt(phoneText1.getText()), phone2, null, dni, caracter);
                        System.out.println("Hemos creado al cliente con dni "+dni);
                        

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
                deleteFields(cityText);
                deleteFields(countryText);
            }
        });
        
        
        //Accion al cerrar la ventana
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
