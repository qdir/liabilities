/* Application developed for AW subject, belonging to passive operations
 group.*/
package es.unileon.ulebank.history;

import es.unileon.ulebank.handler.Handler;
import java.util.Date;

/**
 * Generic transaction
 *
 * @author runix
 */
public class GenericTransaction extends Transaction {

    /**
     * Create a new generic transaction
     *
     * @param amount ( Transaction amount )
     * @param date ( Transaction date )
     * @param subject ( Transaction subject )
     * @param type (Transaction type)
     */
    public GenericTransaction(double amount, Date date, String subject, TransactionType type) {
        super(amount, date, subject, type);
    }
}
