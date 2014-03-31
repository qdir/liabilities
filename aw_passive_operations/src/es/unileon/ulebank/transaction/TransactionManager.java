/* Application developed for AW subject, belonging to passive operations
 group.*/
package es.unileon.ulebank.transaction;

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

    private List<Bank> banks;
    private AccountDestination accountDestination;

    public TransactionManager() {
        this.banks = new ArrayList<>();
        this.accountDestination = new AccountDestination(this);
    }

    public boolean addBank(Bank bank) {
        if (bank != null) {
            for (int i = 0; i < banks.size(); ++i) {
                if (banks.get(i).getID().compareTo(bank.getID()) == 0) {
                    return false;
                }
            }
            return this.banks.add(bank);
        }
        return false;
    }

    public boolean removeBank(Handler bankID) {
        if (bankID != null) {
            for (int i = 0; i < banks.size(); ++i) {
                if (banks.get(i).getID().compareTo(bankID) == 0) {
                    return this.banks.remove(banks.get(i));
                }
            }
        }
        return false;
    }

    public void forwardTransaction(Transaction transaction) throws MalformedHandlerException, TransactionException {
        if (transaction != null && transaction.getDestination() != null) {
            Handler bankHandler = new AccountHandler(transaction.getDestination()).getBankHandler();
            boolean finish = false;
            for (int i = 0; i < banks.size() && !finish; i++) {
                if (banks.get(i).getID().compareTo(bankHandler) == 0) {
                    finish = true;
                    if (transaction.getAmount() < 0) {
                        banks.get(i).doWithDrawal(transaction, this.accountDestination);
                    } else {
                        banks.get(i).doDeposit(transaction);
                    }
                }
            }
        }
    }

}
