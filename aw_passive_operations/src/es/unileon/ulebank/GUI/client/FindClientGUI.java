/* Application developed for AW subject, belonging to passive operations
 group.*/
package es.unileon.ulebank.GUI.client;

import es.unileon.ulebank.client.Client;
import es.unileon.ulebank.handler.MalformedHandlerException;
import es.unileon.ulebank.temporary.TemporaryClients;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 * At the start of the application is necessary to introduce a DNI.
 *
 * @author Eva
 */
public class FindClientGUI extends GUIOperations {

    private final JPanel buttonPanel;
    private final JTextField dniFinder;
    private final JLabel label;
    private final JButton find;
    private TemporaryClients temporalC;
    private final String startField ="Introduce el identificador del cliente";

    /**
     * Constructor of the class. In that we create the window
     */
    public FindClientGUI()  {
        this.setTitle("ULE BANK");
        //Variables
        dniFinder = new JTextField(startField, 20);
        dniFinder.setEditable(true);
        
        
        
        this.setBounds(0, 0, 300, 200);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        this.setLayout(new GridBagLayout());
        GridBagConstraints cstr = new GridBagConstraints();

        label = new JLabel("INTRODUCE EL IDENTIFICADOR DEL CLIENTE", JLabel.CENTER);
        
        //Creation of the selection for DNI or CIF
        

        buttonPanel = new JPanel();
        find = new JButton("CONTINUAR");

        //DNI-CIF panel
        cstr.fill = GridBagConstraints.HORIZONTAL;
        cstr.insets = new Insets(0, 0, 25, 0);
        cstr.gridwidth = GridBagConstraints.REMAINDER;

        this.add(label, cstr);
        
         cstr.insets = new Insets(0, 0, 10, 0);
        //DNI field
        this.add(dniFinder, cstr);
        //Buttons
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(find);

        cstr.anchor = GridBagConstraints.SOUTH;
        cstr.insets = new Insets(15, 0, 0, 0);
        add(buttonPanel, cstr);
        dniFinder.addFocusListener(new FocusListener() {

            //Methods to clean the field
            @Override
            public void focusGained(FocusEvent e) {
                if (dniFinder.isEditable()) {
                    findOptions(dniFinder);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (dniFinder.getText().compareTo("") == 0) {
                    dniFinder.setText(startField);
                }
            }
        });
        try {
            temporalC = new TemporaryClients();
        } catch (MalformedHandlerException ex) {
            Logger.getLogger(FindClientGUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(FindClientGUI.class.getName()).log(Level.SEVERE, null, ex);
        }

        find.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int option = -1;
                int selection = -1;
                if (dniFinder.getText().compareToIgnoreCase(startField) == 0) {
                    System.out.println("No has introducido ningun DNI");
                } else {
                    selection = getSelectedOption(dniFinder.getText());
                    if (selection == 0) {
                        try {
                            //DNI
                            option = 0;
                            System.out.println(option);
                            System.out.println("El dni introducido es: " + dniFinder.getText());
                            //Sacamos la letra
                            Character caracter = dniFinder.getText().charAt(dniFinder.getText().length() - 1);
                            Client client = temporalC.findClient(removeLetter(dniFinder.getText()), caracter);
                            ClientsGUI cgui = new ClientsGUI(client, option);
                        } catch (MalformedHandlerException ex) {
                            Logger.getLogger(FindClientGUI.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    } else if (selection == 1) {
                        try {
                            //DNI Extranjero
                            option = 0;
                            System.out.println(option);
                            System.out.println("El dni introducido es: " + dniFinder.getText());
                            //Sacamos la letra
                            Character caracter = dniFinder.getText().charAt(dniFinder.getText().length() - 1);
                            Client client = temporalC.findClient(removeLetter(dniFinder.getText()), caracter);
                            ClientsGUI cgui = new ClientsGUI(client, option);
                        } catch (MalformedHandlerException ex) {
                            Logger.getLogger(FindClientGUI.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else if (selection == 2) {
                        //CIF
                        option = 1;
                        ClientsGUI egui = new ClientsGUI(null, option);
                        System.out.println("Es una empresa");
                    }
                }
            }
        });

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

}
