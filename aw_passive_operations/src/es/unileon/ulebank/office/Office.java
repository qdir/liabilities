/* Application developed for AW subject, belonging to passive operations
 group.*/
package es.unileon.ulebank.office;

import es.unileon.ulebank.account.Account;
import es.unileon.ulebank.account.exception.TransactionException;
import es.unileon.ulebank.handler.GenericHandler;
import es.unileon.ulebank.handler.Handler;
import es.unileon.ulebank.history.Transaction;
import es.unileon.ulebank.history.TransactionType;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author runix
 */
public class Office {

    private final List<Account> accounts;
    private Handler id;

    public Office(Handler id) {
        this.accounts = new ArrayList<>();
        this.id = id;
    }

    public boolean addAccount(Account account) {
        return this.accounts.add(account);
    }

    public Handler getID() {
        return this.id;
    }

    public void doTransaction(Transaction t) throws TransactionException {
        boolean finish = false;
        StringBuilder error = new StringBuilder();
        for (int i = 0; i < accounts.size() && !finish; i++) {
            if (accounts.get(i).getID().compareTo(t.getDestination()) == 0) {
                if (t.getType() == TransactionType.CHARGE) {
                    accounts.get(i).doWithdrawal(t);
                } else if (t.getType() == TransactionType.PAYMENT) {
                    accounts.get(i).doDeposit(t);
                } else {
                    error.append("Error, transaction not supported ").append(t.getType()).append("\n");
                }
                finish = true;
            }
        }
        if (error.length() > 0) {
            throw new TransactionException(error.toString());
        }
    }
}
