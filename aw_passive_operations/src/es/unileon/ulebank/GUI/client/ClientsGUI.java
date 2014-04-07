package es.unileon.ulebank.GUI.client;

import es.unileon.ulebank.GUI.account.AccountGUI;
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
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class ClientsGUI extends GUIOperations {
    /*
     Creation of the button panel and the buttons
     */
    private PersonPanel personPanel;
    private EnterprisePanel enterprisePanel;
    private JPanel buttonPanel;
    private JButton continueButton;
    private JButton cancelButton;
    private JButton deleteField;
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
       this.setTitle("ULE BANK: Cliente");
       createWindow(client, option, null,null);
    }
     public ClientsGUI(Client client, int option, JTextField other,AccountGUI accountWindow) {
       this.setTitle("ULE BANK: Cliente");
       createWindow(client, option, other,accountWindow);
    }
    
    
     private void createWindow(Client client, int option, final JTextField otherClient, final AccountGUI accountWindow){
        //TODO
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
        //this.setResizable(false);
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
 System.out.println("estamos en la ventana del dni");
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
                        //String birthdate = jdateChooser.getDateFormatString();
                        //System.out.println("su nacimientos es: "+birthdate);
                        if (Character.isLetter(caracter)) {
                            System.out.println("Es una letra");
                            //Address finalAddress = new Address(personPanel.getAddressText().getText(), Integer.parseInt(personPanel.getPortalText().getText()), Integer.parseInt(personPanel.getNumberText().getText()), personPanel.getLetterText().getText().charAt(0), personPanel.getLocalityText().getText(), personPanel.getCityText().getText(), Integer.parseInt(personPanel.getPostalCodeText().getText()));
                            Person person = null;
                            
                            try {
                                person = new Person(personPanel.getNameText().getText(),personPanel.getSurnameText().getText(), null, personPanel.getMaritalStatusText().getText(), Integer.parseInt(personPanel.getPhoneText1().getText()), phone2, null, dni, caracter, personPanel.getJdateChooser().getDate());
                            
                            } catch (MalformedHandlerException ex) {
                                Logger.getLogger(ClientsGUI.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            System.out.println("Hemos creado al cliente con dni " + dni);
                            try {
                                //Test
                                clientT = new TemporaryClients();
                            } catch (MalformedHandlerException ex) {
                                Logger.getLogger(ClientsGUI.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (ParseException ex) {
                                Logger.getLogger(ClientsGUI.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            clientT.addClient(person);

                        }

                        if(otherClient!=null){
                            //System.out.println(person.getName());
                            //otherClient.setText(personPanel.getName());
                          //accountWindow.getHolderText1().setText(personPanel.getNameText().getText());
                          accountWindow.repaint();
                        }
                    //Obtener fecha(PRUEBAS)
                        
                        //System.out.println("La fecha elegida es: " + date);
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
             deleteFields(personPanel.getNameText());
             deleteFields(personPanel.getSurnameText());
             deleteFields(personPanel.getAddressText());
             deleteFields(personPanel.getPortalText());
             deleteFields(personPanel.getNumberText());
             deleteFields(personPanel.getPostalCodeText());
             deleteFields(personPanel.getDNIText());
             //deleteFields(birthdateText);
             deleteFields(personPanel.getMaritalStatusText());
             deleteFields(personPanel.getPhoneText1());
             deleteFields(personPanel.getPhoneText2());
             deleteFields(personPanel.getLocalityText());
             deleteFields(personPanel.getCityText());
             }
             });

        //Accion al cerrar la ventana
            //this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        }else if (option== 1){
            enterprisePanel = new EnterprisePanel();
            this.add(enterprisePanel, BorderLayout.CENTER);
            JScrollPane scroll = new JScrollPane(enterprisePanel);
            this.getContentPane().add(scroll);
        }
         
        this.setVisible(true);
        }
}
