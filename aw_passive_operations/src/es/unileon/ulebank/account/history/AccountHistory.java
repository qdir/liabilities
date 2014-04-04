/* Application developed for AW subject, belonging to passive operations
 group.*/
package es.unileon.ulebank.account.history;

import es.unileon.ulebank.handler.Handler;
import es.unileon.ulebank.history.History;
import es.unileon.ulebank.history.Transaction;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author runix
 */
public class AccountHistory {

    private List<AccountEntry> entries;

    public AccountHistory() {
        this.entries = new ArrayList<>();
    }

    public boolean appendEntry(AccountEntry entry) {
        return this.entries.add(entry);
    }

    public boolean deleteEntry(Handler id) {
        boolean remove = false;
        for (int i = 0; i < entries.size() && !remove; i++) {
            if (entries.get(i).getMovementID().equals(id)) {
                this.entries.remove(i);
                remove = true;
            }
        }
        return remove;
    }

    public List<AccountEntry> getTransactionsFrom(Date beginning) {
        List<AccountEntry> transactions = new ArrayList<>();
        if (beginning != null) {
            for (AccountEntry actual : this.entries) {
                if (beginning.before(actual.getEffectiveDate())) {
                    transactions.add(actual);
                }
            }
        }
        return transactions;
    }

    public List<AccountEntry> getTransactionsBetween(Date beginning, Date end) {
        List<AccountEntry> transactions = new ArrayList<>();
        if (beginning != null) {
            for (AccountEntry actual : this.entries) {
                if (beginning.before(actual.getEffectiveDate()) && end.after(actual.getEffectiveDate())) {
                    transactions.add(actual);
                }
            }
        }
        return transactions;
    }

    public List<AccountEntry> getHistory() {
        return new ArrayList<>(this.entries);
    }
}
