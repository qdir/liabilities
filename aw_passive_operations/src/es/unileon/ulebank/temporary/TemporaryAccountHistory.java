/* Application developed for AW subject, belonging to passive operations
 group.*/

package es.unileon.ulebank.temporary;

import es.unileon.ulebank.GUI.operations.HistoricalOperations;
import es.unileon.ulebank.account.history.AccountHistory;
import es.unileon.ulebank.history.GenericTransaction;
import static es.unileon.ulebank.history.TransactionType.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Eva
 */
public class TemporaryAccountHistory {
    public TemporaryAccountHistory() throws ParseException{
    AccountHistory history = new AccountHistory();
    SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
    
    Date date1 = sdf.parse("01/05/2014");
    Date edat1 = sdf.parse("05/05/2014");
    GenericTransaction tr1 = new GenericTransaction(20.0, date1, edat1,"prueba1", CHARGE) {
    };
    
    Date date2 = sdf.parse("10/05/2014");
    Date edat2 = sdf.parse("15/05/2014");
    GenericTransaction tr2 = new GenericTransaction(25.0, date2, edat2, "prueba1", PAYMENT) {
    };
    
    Date date3 = sdf.parse("01/04/2013");
    Date edat3 = sdf.parse("05/04/2013");
     GenericTransaction tr3 = new GenericTransaction(5.0, date3,edat3, "prueba1", CHARGE) {
    };
    
     Date date4 = sdf.parse("01/05/2009");
     Date edat4 = sdf.parse("05/05/2009");
    GenericTransaction tr4 = new GenericTransaction(10.0, date4,edat4, "prueba1", PAYMENT) {
    };
    
    history.addTransaction(tr1);
    System.out.println("Primera transaccion añadida"+tr1.toString());
    history.addTransaction(tr2);
    history.addTransaction(tr3);
    history.addTransaction(tr4);
    
    
    HistoricalOperations ho = new HistoricalOperations(history);
    }
}
