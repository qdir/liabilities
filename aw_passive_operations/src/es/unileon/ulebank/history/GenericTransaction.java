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
     * @param id ( Transaction id )
     * @param amount ( Transaction amount )
     * @param date ( Transaction date )
     * @param effectiveData ( Transaction effective date )
     * @param subject ( Transaction subject )
     * @param type (Transaction type)
     */
    public GenericTransaction(Handler id, double amount, Date date, Date effectiveData, String subject, TransactionType type) {
        this.id = id;
        this.amount = amount;
        this.date = date;
        this.effectiveDate = effectiveData;
        this.subject = subject;
        this.type = type;
    }
}
