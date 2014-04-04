/* Application developed for AW subject, belonging to passive operations
 group.*/
package es.unileon.ulebank.transacionManager;

import es.unileon.ulebank.account.exception.TransactionException;
import es.unileon.ulebank.account.handler.AccountHandler;
import es.unileon.ulebank.bank.Bank;
import es.unileon.ulebank.handler.Handler;
import es.unileon.ulebank.handler.MalformedHandlerException;
import es.unileon.ulebank.history.Transaction;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author runix
 */
public class TransactionManager {

    private final List<Bank> banks;

    public TransactionManager() {
        this.banks = new ArrayList<>();
    }

    public boolean addBank(Bank bank) {
        boolean repeated = false;
        for (int i = 0; i < banks.size() && !repeated; i++) {
            if (this.banks.get(i).getID().compareTo(bank.getID()) == 0) {
                repeated = true;
            }
        }
        return !repeated && this.banks.add(bank);
    }

    public boolean deleteBank(Handler id) {
        boolean deleted = false;
        for (int i = 0; i < banks.size() && !deleted; i++) {
            if (banks.get(i).getID().compareTo(id) == 0) {
                banks.remove(i);
                deleted = true;
            }
        }
        return deleted;
    }

    public void doTransaction(Transaction t) throws MalformedHandlerException, TransactionException {
        Handler destination = new AccountHandler(t.getDestination()).getBankHandler();
        boolean found = false;
        for (int i = 0; i < banks.size() && !found; i++) {
            if (banks.get(i).getID().compareTo(destination) == 0) {
                banks.get(i).doTransaction(t);
                found = true;
            }
        }
        if (!found) {
            throw new TransactionException("Cannot found the bank " + destination.toString() + " \n");
        }
    }
}
