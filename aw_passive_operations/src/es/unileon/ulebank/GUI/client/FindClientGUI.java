/* Application developed for AW subject, belonging to passive operations
 group.*/
package es.unileon.ulebank.GUI.client;

import es.unileon.ulebank.client.Client;
import es.unileon.ulebank.temporary.TemporaryClients;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.*;
import javax.swing.plaf.basic.BasicBorders;

/**
 * At the start of the application is necessary to introduce a DNI.
 *
 * @author Eva
 */
public class FindClientGUI extends GUIOperations {

    private final JPanel buttonPanel;
    private final JPanel selectionPanel;
    private final ButtonGroup buttonSelection;
    private final JRadioButton DNIButton;
    private final JRadioButton CIFButton;
    private final JTextField dniFinder;
    private final JButton find;
    private TemporaryClients temporalC;

    /**
     * Constructor of the class. In that we create the window
     */
    public FindClientGUI() {
        //Variables
        dniFinder = new JTextField("Introduce el DNI del cliente", 20);
        dniFinder.setEditable(false);
        selectionPanel = new JPanel();

        this.setBounds(0, 0, 300, 200);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        this.setLayout(new GridBagLayout());
        GridBagConstraints cstr = new GridBagConstraints();

        //Creation of the selection for DNI or CIF
        DNIButton = new JRadioButton("DNI", false);
        CIFButton = new JRadioButton("CIF", false);
        buttonSelection = new ButtonGroup();
        buttonSelection.add(DNIButton);
        buttonSelection.add(CIFButton);
        selectionPanel.setLayout(new FlowLayout());
        selectionPanel.add(DNIButton);
        selectionPanel.add(CIFButton);

        buttonPanel = new JPanel();
        find = new JButton("CONTINUAR");

        //DNI-CIF panel
        cstr.fill = GridBagConstraints.HORIZONTAL;
        cstr.insets = new Insets(0, 0, 10, 0);
        cstr.gridwidth = GridBagConstraints.REMAINDER;
        this.add(selectionPanel, cstr);

        DNIButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                dniFinder.setEditable(true);
            }
        });

        CIFButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                dniFinder.setEditable(true);
            }
        });

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
                    dniFinder.setText("Introduce el DNI del cliente");
                }
            }
        });

        /*dniFinder.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
         findOptions(dniFinder);
         }
         });*/
        temporalC = new TemporaryClients();

        find.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (dniFinder.getText().compareToIgnoreCase("Introduce el DNI del cliente") == 0) {
                    System.out.println("No has introducido ningun DNI");
                } else {
                    System.out.println("El dni introducido es: " + dniFinder.getText());
                    //Sacamos la letra
                    Character caracter = dniFinder.getText().charAt(dniFinder.getText().length() - 1);
                    System.out.println("La letra es: " + caracter);
                    Client client = temporalC.findClient(removeLetter(dniFinder.getText()), caracter);
                    ClientsGUI cgui = new ClientsGUI(client);
                }
            }

        });

        find.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent event) {
                if (DNIButton.isSelected()) {
                    System.out.println("la eleccion es DNI");
                } else if (CIFButton.isSelected()) {
                    System.out.println("la eleccion es CIF");
                }
            }
        });
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

}
