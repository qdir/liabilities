/* Application developed for AW subject, belonging to passive operations
 group.*/
package es.unileon.ulebank.GUI.client;

import com.toedter.calendar.JDateChooser;
import es.unileon.ulebank.account.history.AccountHistory;
import es.unileon.ulebank.history.Transaction;
import es.unileon.ulebank.temporary.TemporaryAccountHistory;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

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

    public static int getSelectedOption(String field){
        Character firstChar = null;
        int result = -1;
        firstChar = field.charAt(0);
        System.out.println("Lo primero es: " + firstChar );
        if(firstChar.isLetter(firstChar)){
        //Puede ser DNI Extranjero o CIF
            if(firstChar.equals('X') ||firstChar.equals('Y')||firstChar.equals('Z') ){
                //DNI extranjero
                 System.out.println("Es un DNI extranjero: "+field );
                 result = 1;
            }else{
                //CIF
                System.out.println("Es un CIF: "+field );
                result = 2;
            }
        }else{
        //Es DNI
            result = 0;
        }
        return result ;
    }
    
    public static JTable createTable(Object[][] data) {
        DefaultTableModel tableModel;
        String[] columnNames = {"Fecha operación",
            "Fecha valor",
            "Tipo",
            "concepto",
            "Importe",
            "Saldo"};

        JTable resultTable = new JTable(data, columnNames);
        tableModel = new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        resultTable.setModel(tableModel);

        return resultTable;
    }
    
   
    public static Object[][] getData(AccountHistory history, Date startDate, Date endDate, int option ){
        Double amount = 1000.000;
        Object[][] transactionData = null;
        Collection<Transaction> tr = null;
        switch (option){
            case 1:
                //Falta metodo para elegir las de una fecha determinada
                tr = history.getTransactions();
                break;
            case 2:
                tr = history.getTransactionsBetween(startDate, endDate);
                break;
            case 3:
                tr = history.getTransactionsFrom(startDate);
                break;
            default:
                tr = history.getTransactions();
                break;
                
        }
        
        transactionData = new Object [tr.size()][6];
        Iterator<Transaction> iterator=tr.iterator();
        int i = 0;
        while(iterator.hasNext()){
            Transaction t = iterator.next();
            transactionData[i][0] = t.getDate();
            transactionData[i][1] =t.getEffectiveDate();
            transactionData[i][2] =t.getType();
            transactionData[i][3] =t.getSubject();
            transactionData[i][4] =t.getAmount();
            transactionData[i][5] = (amount-t.getAmount());
            i++;
        }
       
    return transactionData;    
    }
   
    public static void main(String[] args) throws ParseException {
        //HistoricalOperations ho = new HistoricalOperations();
        //FindClientGUI fClients = new FindClientGUI();
        //AccountGUI gui = new AccountGUI();
        //ContractFormGUI contractGui = new ContractFormGUI();
        TemporaryAccountHistory temporal = new TemporaryAccountHistory();
    }
}
