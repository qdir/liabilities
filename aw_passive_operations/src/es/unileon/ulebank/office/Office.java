/* Application developed for AW subject, belonging to passive operations
 group.*/
package es.unileon.ulebank.office;

import es.unileon.ulebank.account.Account;
import es.unileon.ulebank.account.exception.TransactionException;
import es.unileon.ulebank.account.handler.AccountHandler;
import es.unileon.ulebank.handler.GenericHandler;
import es.unileon.ulebank.handler.Handler;
import es.unileon.ulebank.history.Transaction;
import es.unileon.ulebank.transaction.AccountDestination;
import es.unileon.ulebank.transaction.TransactionDestination;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author runix
 */
public class Office {
    
    private final List<Account> accounts;
    
    public Office(Handler id) {
        this.accounts = new ArrayList<>();
        
    }
    
    public boolean addAccount(Account account) {
        return this.accounts.add(account);
    }
    
    public Handler getID() {
        return new GenericHandler("1234");
    }
    
    public void doWithdrawal(Transaction t, TransactionDestination destination) throws TransactionException {
        boolean finish = false;
        for (int i = 0; i < accounts.size() && !finish; i++) {
            if (accounts.get(i).getID().compareTo(t.getDestination()) == 0) {
                accounts.get(i).doWithdrawal(t, destination);
                finish = true;
            }
        }
    }
    
    public void doDeposit(Transaction t) throws TransactionException {
        boolean finish = false;
        for (int i = 0; i < accounts.size() && !finish; i++) {
            if (accounts.get(i).getID().compareTo(t.getDestination()) == 0) {
                accounts.get(i).doDeposit(t);
                finish = true;
            }
        }
    }
}
