package es.unileon.ulebank.history;

import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author roobre
 */
public abstract class History<T extends Transaction> {

    private final Collection<T> transactions;

    public History() {
        this.transactions = new ArrayList();
    }
    
    public boolean addTransaction(T transaction) {
        return this.transactions.add(transaction);
    }
    
    public Collection<T> getTransactions() {
        return new ArrayList<T>(this.transactions);
    }
}
