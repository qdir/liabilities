/* Application developed for AW subject, belonging to passive operations
 group.*/

package es.unileon.ulebank.GUI.client;

import java.awt.Color;
import java.awt.event.KeyEvent;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 *
 * @author Eva
 */
public class GUIOperations extends JFrame{
   /*
    Comprobar si los campos estan vacios
    */
    public boolean validate(JTextField text){
        boolean validate = false;
        if(text.getText().trim().length()==0){
            text.setBorder(BorderFactory.createLineBorder(Color.RED));
        }else{
            validate=true;
            text.setBorder(BorderFactory.createLineBorder(null));
        }
        return validate;
    }
    
    /*
    Vaciar los campos
    */
    public void deleteFields(JTextField t){
        t.setText("");
    }
    
    /*
    Comprobar si son solo numeros
    */
    public void onlyNumbers(KeyEvent e){
    char caracter = e.getKeyChar();

      // Verificar si la tecla pulsada no es un digito
      if(((caracter < '0') ||
         (caracter > '9')) &&
         (caracter != '\b'))
      {
         e.consume();  // ignorar el evento de teclado
      }}
        
    public int removeLetter(String DNIText) {
        int dni=0;
        try {
            //Quitamos la letra al DNI. Obtenemos solo el numero
            dni = Integer.parseInt(DNIText.substring(0, DNIText.length() - 2));
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
        }
       
        return dni;
    }
   
    public static void main(String[] args) {
       findClientGUI findClient = new findClientGUI();
       ClientsGUI cgui = new ClientsGUI();
       //AccountGUI gui = new AccountGUI();
    } 
}
