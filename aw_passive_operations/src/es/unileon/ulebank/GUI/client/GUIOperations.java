/* Application developed for AW subject, belonging to passive operations
 group.*/
package es.unileon.ulebank.GUI.client;

import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.event.KeyEvent;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 * All the operations that the clients interface could use.
 *
 * @author Eva
 */
public class GUIOperations extends JFrame {
    private final String startField = "Introduce el identificador del cliente";

    /**
     * Validate the fields. If isn´t complete a red border appears in the
     * correspondent field.
     *
     * @param text
     * @return boolean
     */
    public boolean validate(JTextField text) {
        boolean validate = false;
        if (text.getText().trim().length() == 0) {
            text.setBorder(BorderFactory.createLineBorder(Color.RED));
        } else {
            validate = true;
            text.setBorder(BorderFactory.createLineBorder(null));
        }
        return validate;
    }
    
    public boolean validateBirthDate(JDateChooser datechooser){
        boolean valid = false;
        if(datechooser.getDate()==null){
            valid =false;
            datechooser.setBorder(BorderFactory.createLineBorder(Color.RED));
        }else{
            valid = true;
            datechooser.setBorder(BorderFactory.createLineBorder(null));
        }
        return valid;
    }

    /**
     * Delete the fields to start again
     *
     * @param t
     */
    public void deleteFields(JTextField t) {
        t.setText("");
    }

    /**
     * Comprobate if the key is a number, we could only introduce numbers
     *
     * @param e
     */
    public void onlyNumbers(KeyEvent e) {
        char caracter = e.getKeyChar();

        // Verificar si la tecla pulsada no es un digito
        if (((caracter < '0')
                || (caracter > '9'))
                && (caracter != '\b')) {
            e.consume();  // ignorar el evento de teclado
        }
    }

    /**
     * Remove the letter of the DNI field
     *
     * @param DNIText
     * @return dni number
     */
    public int removeLetter(String DNIText) {
        int dni = 0;
        try {
            //Quitamos la letra al DNI. Obtenemos solo el numero
            //TODO con -2 no me pone el dni completo
            dni = Integer.parseInt(DNIText.substring(0, DNIText.length() - 1));
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
        }
        System.out.println("el dni sin letra es: " + dni);

        return dni;
    }

    /**
     * Get the DNI letter.
     *
     * @param DNIText
     * @return Dni letter
     */
    public Character getLetter(String DNIText) {
        Character caracter = DNIText.charAt(DNIText.length() - 1);
        return caracter;
    }

    /**
     * Method used to select the correct option when someone click on the text.
     * @param dniFinder 
     */
    public void findOptions(JTextField dniFinder) {

        if (dniFinder.getText().compareToIgnoreCase(startField) == 0 || dniFinder.getText().compareToIgnoreCase("") == 0) {
            dniFinder.setText(null);
        } else {
            System.out.println("No son iguales");
        }
    }

    public static void main(String[] args) {
        FindClientGUI fClients = new FindClientGUI();
        //AccountGUI gui = new AccountGUI();
        //ContractFormGUI contractGui = new ContractFormGUI();
    }
}
