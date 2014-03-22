/* Application developed for AW subject, belonging to passive operations
 group.*/
package es.unileon.ulebank.GUI.client;

//import es.unileon.ulebank.temporary.TemporaryClients;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * At the start of the application is necessary to introduce a DNI.
 *
 * @author Eva
 */
public class findClientGUI extends GUIOperations {

    private final JPanel buttonPanel;
    private final JTextField dniFinder;
    private final JLabel dniLabel;
    private final JButton find;
    //private TemporaryClients temporalC;

    /**
     * Constructor of the class. In that we create the window
     */
    public findClientGUI() {
        //Variables
        dniFinder = new JTextField("Introduce el DNI del cliente", 20);
        dniLabel = new JLabel("DNI", JLabel.CENTER);

        buttonPanel = new JPanel();
        find = new JButton("CONTINUAR");

        this.setBounds(0, 0, 300, 200);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        this.setLayout(new GridBagLayout());
        GridBagConstraints cstr = new GridBagConstraints();

        //DNI label
        cstr.fill = GridBagConstraints.HORIZONTAL;
        cstr.insets = new Insets(0, 0, 10, 0);
        cstr.gridwidth = GridBagConstraints.REMAINDER;
        this.add(dniLabel, cstr);
        //DNI field
        this.add(dniFinder, cstr);
        //Buttons
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(find);

        cstr.anchor = GridBagConstraints.SOUTH;
        cstr.insets = new Insets(15, 0, 0, 0);
        add(buttonPanel, cstr);

        dniFinder.addActionListener(new ActionListener() {
            //TODO revisar, no funciona
            @Override
            public void actionPerformed(ActionEvent e) {
                options(dniFinder);
            }
        });

        //temporalC = new TemporaryClients();
        find.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (dniFinder.getText().compareToIgnoreCase("Introduce el DNI del cliente") == 0) {
                    System.out.println("No has introducido ningun DNI");
                } else {
                    System.out.println("El dni introducido es: " + dniFinder.getText());
                    //Sacamos la letra
                    Character caracter = dniFinder.getText().charAt(dniFinder.getText().length() - 1);
                    System.out.println("La letra es: "+ caracter);
                    //temporalC.findClient(removeLetter(dniFinder.getText()), caracter);
                }
            }
        });
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
}
