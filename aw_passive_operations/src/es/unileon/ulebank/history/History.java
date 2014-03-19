package es.unileon.ulebank.history;

import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author roobre
 */
public class History<T extends Transaction> {

    private final Collection<T> transactions;

    public History() {
        this.transactions = new ArrayList();
    }

    
    public Collection<T> getTransactions() {
        return this.transactions;
    }
}
