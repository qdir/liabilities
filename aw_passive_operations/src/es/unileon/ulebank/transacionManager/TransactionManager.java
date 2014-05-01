/* Application developed for AW subject, belonging to passive operations
 group.*/
package es.unileon.ulebank.transacionManager;

import es.unileon.ulebank.account.AccountHandler;
import es.unileon.ulebank.account.TransactionException;
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

    /**
     *
     */
    public TransactionManager() {
        this.banks = new ArrayList<>();
    }

    /**
     *
     * @param bank
     * @return
     */
    public boolean addBank(Bank bank) {
        boolean repeated = false;
        if (bank != null) {
            for (int i = 0; i < banks.size() && !repeated; i++) {
                if (this.banks.get(i).getID().compareTo(bank.getID()) == 0) {
                    repeated = true;
                }
            }
        } else {
            repeated = true;
        }
        return !repeated && this.banks.add(bank);
    }

    /**
     *
     * @param id
     * @return
     */
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

    /**
     *
     * @param t
     * @param destine
     * @throws MalformedHandlerException
     * @throws TransactionException
     */
    public void doTransaction(Transaction t, Handler destine) throws MalformedHandlerException, TransactionException {
        StringBuilder error = new StringBuilder();
        if (t != null && destine != null) {
            Handler destination = new AccountHandler(destine).getBankHandler();
            boolean found = false;
            for (int i = 0; i < banks.size() && !found; i++) {
                if (banks.get(i).getID().compareTo(destination) == 0) {
                    banks.get(i).doTransaction(t, destine);
                    found = true;
                }
            }
            if (!found) {
                error.append("Cannot found the bank " + destination.toString() + " \n");
            }
        } else {
            error.append("The transaction or destine cannot be null");
        }
        if (error.length() > 0) {
            throw new TransactionException(error.toString());
        }
    }

}
