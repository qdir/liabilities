package es.unileon.ulebank.history;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 *
 * @author roobre
 * @param <T>
 */
public abstract class History<T extends Transaction> {

    private final Collection<T> transactions;

    public History() {
        this.transactions = new ArrayList();
    }

    public boolean addTransaction(T transaction) {
        return this.transactions.add(transaction);
    }

    public Collection<T> getTransactionsFrom(Date beginning) {
        Collection<T> transactions = new ArrayList<>();
        if (beginning != null) {
            for (T actual : this.transactions) {
                if (beginning.before(actual.getDate())) {
                    transactions.add(actual);
                }
            }
        }
        return transactions;
    }

    public Collection<T> getTransactionsBetween(Date beginning, Date end) {
        Collection<T> transactions = new ArrayList<>();
        if (beginning != null) {
            for (T actual : this.transactions) {
                if (beginning.before(actual.getDate()) && end.after(actual.getDate())) {
                    transactions.add(actual);
                }
            }
        }
        return transactions;
    }

    public Collection<T> getTransactions() {
        return new ArrayList<>(this.transactions);
    }
}
