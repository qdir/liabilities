/* Application developed for AW subject, belonging to passive operations
 group.*/
package es.unileon.ulebank.account;

import es.unileon.ulebank.history.DirectDebitTransaction;
import es.unileon.ulebank.history.Transaction;
import java.util.Iterator;

/**
 *
 * @author runix
 * @param <T>
 */
public interface ExemptLiquidationStrategy<T extends Transaction> {

    /**
     * To know if the account is liquidation exempt.
     *
     * @param transactions ( All transactions )
     * 
     * @param directDebitTransactions ( DirectDebitTransactions )
     * 
     * @param accountDirectDebits ( Account's direct debits )
     * 
     * @return
     */
    boolean isExempt(Iterator<T> transactions, Iterator<DirectDebitTransaction> directDebitTransactions, AccountDirectDebits accountDirectDebits);

}
