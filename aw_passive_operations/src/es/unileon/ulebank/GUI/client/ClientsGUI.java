package es.unileon.ulebank.GUI.client;

import es.unileon.ulebank.client.Client;
import es.unileon.ulebank.client.types.Person;
import es.unileon.ulebank.client.types.data.Address;
import es.unileon.ulebank.handler.MalformedHandlerException;
import es.unileon.ulebank.temporary.TemporaryClients;
import java.util.Date;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class ClientsGUI extends GUIOperations {
    /*
     Creation of the button panel and the buttons
     */

    private PersonPanel personPanel;
    private EnterprisePanel enterprisePanel;
    private final JPanel buttonPanel;
    private final JButton continueButton;
    private final JButton cancelButton;
    private final JButton deleteField;

    /*
     Other variables
     */
    private int dni;
    private TemporaryClients clientT;
    private Person person;

    private com.toedter.calendar.JDateChooser jdateChooser;
    //private final Date actualDate;
    /*
     Constructor of the interface
     */

    /**
     *
     * @param client
     * @param option
     */
    public ClientsGUI(Client client, int option) {
        person = (Person) client;

        buttonPanel = new JPanel();
        continueButton = new JButton("CONTINUAR");
        cancelButton = new JButton("CANCELAR");
        deleteField = new JButton("RESET");

        //Asignamos a la ventana principal el layout GridBagLayout
        this.setLayout(new BorderLayout());
        //tamaño de la ventana
        this.setSize(700, 400);
        //No se podra modificar el tamaño
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        //Continue, reset and cancel buttons,used FlowLayout(izq a dcha)
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(cancelButton);
        buttonPanel.add(deleteField);
        buttonPanel.add(continueButton);
        add(buttonPanel, BorderLayout.SOUTH);

        if (option == 0) {
            personPanel = new PersonPanel(person);
            this.add(personPanel, BorderLayout.CENTER);

            if (person != null) {
                personPanel.getNameText().setText(person.getName());
                personPanel.getSurnameText().setText(person.getSurnames());
                personPanel.getMaritalStatusText().setText(person.getCivilState());
                personPanel.getDNIText().setText(person.getId().toString());
                personPanel.getPhoneText1().setText(Integer.toString(person.getPhoneNumber(0)));
                personPanel.getPhoneText2().setText(Integer.toString(person.getPhoneNumber(1)));
                personPanel.getProfessionText().setText(person.getProfession());
                Address addressRcv = person.getAddress();
                personPanel.getLetterText().setText(Character.toString(addressRcv.getDoor()));
                personPanel.getPortalText().setText(Integer.toString(addressRcv.getBlockNumber()));
                personPanel.getNumberText().setText(Integer.toString(addressRcv.getFloor()));
                personPanel.getPostalCodeText().setText(Integer.toString(addressRcv.getZipCode()));
                personPanel.getAddressText().setText(addressRcv.getStreet());
                personPanel.getCityText().setText(addressRcv.getProvince());
                personPanel.getLocalityText().setText(addressRcv.getLocality());
                personPanel.getJdateChooser().setDate(person.getBirthDate());

            }
            /*
             The fields that only accepts numbers or digits
             */
            personPanel.getPhoneText1().addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    onlyNumbers(e);
                }
            });
            personPanel.getPhoneText2().addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    onlyNumbers(e);
                }
            });
            personPanel.getPostalCodeText().addKeyListener(new KeyAdapter() {
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
                    validate(personPanel.getNameText());
                    validate(personPanel.getSurnameText());
                    validate(personPanel.getAddressText());
                    validate(personPanel.getPostalCodeText());
                    validate(personPanel.getDNIText());
                    validateBirthDate(personPanel.getJdateChooser());
                    validate(personPanel.getMaritalStatusText());
                    validate(personPanel.getPhoneText1());

                    if (validate(personPanel.getNameText())
                            && validate(personPanel.getSurnameText())
                            && validate(personPanel.getAddressText())
                            && validate(personPanel.getPostalCodeText())
                            && validate(personPanel.getDNIText())
                            && validateBirthDate(personPanel.getJdateChooser())
                            && validate(personPanel.getMaritalStatusText())
                            && validate(personPanel.getPhoneText1())) {

                        /*
                         When all the obligatory elements are completed, we proceded to create the clients:
                         FIRST: Comprobate if the second number(not obligatory) is a number
                         SECOND: Get the Passport without letter and get the letter alone.
                         THIRD: Create the client.
                         */
                        //FIRST
                        int phone2;
                        if (personPanel.getPhoneText2().getText().compareTo("") == 0) {
                            phone2 = 0;
                        } else {
                            phone2 = Integer.parseInt(personPanel.getPhoneText2().getText());
                        }

                        //SECOND
                        Character caracter = personPanel.getDNIText().getText().charAt(personPanel.getDNIText().getText().length() - 1);
                        try {
                            //Quitamos la letra al DNI
                            dni = Integer.parseInt(personPanel.getDNIText().getText().substring(0, personPanel.getDNIText().getText().length() - 1));
                        } catch (NumberFormatException ex) {
                            ex.printStackTrace();
                        }
                        //THIRD
                        if (Character.isLetter(caracter)) {
                            System.out.println("Es una letra");
                            Address finalAddress = new Address(personPanel.getAddressText().getText(), Integer.parseInt(personPanel.getPortalText().getText()), Integer.parseInt(personPanel.getNumberText().getText()), (char) 0, personPanel.getLocalityText().getText(), personPanel.getCityText().getText(), Integer.parseInt(personPanel.getPostalCodeText().getText()));
                            Person person = null;
                            try {
                                person = new Person(personPanel.getNameText().getText(), personPanel.getSurnameText().getText(), null, personPanel.getMaritalStatusText().getText(), Integer.parseInt(personPanel.getPhoneText1().getText()), phone2, null, dni, caracter, jdateChooser.getDate());
                            } catch (MalformedHandlerException ex) {
                                Logger.getLogger(ClientsGUI.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            System.out.println("Hemos creado al cliente con dni " + dni);
                            try {
                                //Test
                                clientT = new TemporaryClients();
                            } catch (MalformedHandlerException ex) {
                                Logger.getLogger(ClientsGUI.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            clientT.addClient(person);

                        }

                    //Obtener fecha(PRUEBAS)
                        Date date = jdateChooser.getDate();
                        System.out.println("La fecha elegida es: " + date);
                        /*Aqui se pasa a la ventana de los autorizados
                         pasandole: person y el tipo del seleccionable
                         */
                        //System.out.println(person.getId().toString());
                    } else {
                        System.out.println("No validado");
                    }
                }
            });
            /*deleteField.addActionListener(new ActionListener() {

             @Override
             public void actionPerformed(ActionEvent e) {
             deleteFields(nameText);
             deleteFields(surnameText);
             deleteFields(addressText);
             deleteFields(portalText);
             deleteFields(numberText);
             deleteFields(postalCodeText);
             deleteFields(DNIText);
             //deleteFields(birthdateText);
             deleteFields(maritalStatusText);
             deleteFields(phoneText1);
             deleteFields(phoneText2);
             deleteFields(localityText);
             deleteFields(cityText);
             }
             });*/

        //Accion al cerrar la ventana
            //this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        }else if (option== 1){
            enterprisePanel = new EnterprisePanel();
            this.add(enterprisePanel, BorderLayout.CENTER);
        }
            
            this.setVisible(true);
        
   
    }
}
