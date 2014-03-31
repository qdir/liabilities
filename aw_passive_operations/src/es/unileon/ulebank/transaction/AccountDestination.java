/* Application developed for AW subject, belonging to passive operations
 group.*/

package es.unileon.ulebank.transaction;

import es.unileon.ulebank.account.exception.TransactionException;
import es.unileon.ulebank.handler.MalformedHandlerException;
import es.unileon.ulebank.history.Transaction;

/**
 *
 * @author runix
 */
public class AccountDestination implements TransactionDestination {
    
    private TransactionManager manager;
    
    public AccountDestination(TransactionManager tm) {
        this.manager = tm;
    }
    
    @Override
    public void forwardTransaction(Transaction t) throws TransactionException, MalformedHandlerException {
        this.manager.forwardTransaction(t);
    }
}
