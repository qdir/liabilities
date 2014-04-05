/* Application developed for AW subject, belonging to passive operations
 group.*/
package es.unileon.ulebank.office;

import es.unileon.ulebank.account.Account;
import es.unileon.ulebank.account.exception.TransactionException;
import es.unileon.ulebank.account.handler.AccountHandler;
import es.unileon.ulebank.bank.Bank;
import es.unileon.ulebank.handler.GenericHandler;
import es.unileon.ulebank.handler.Handler;
import es.unileon.ulebank.handler.MalformedHandlerException;
import es.unileon.ulebank.history.Transaction;
import es.unileon.ulebank.history.TransactionType;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

/**
 *
 * @author runix
 */
public class Office {

    private final List<Account> accounts;
    private Handler id;
    private final Bank bank;
    private static final Logger LOG = Logger.getLogger(Account.class.getName());

    public Office(Handler id, Bank bank) {
        this.accounts = new ArrayList<>();
        this.id = id;
        this.bank = bank;
    }

    public boolean addAccount(Account account) {
        return this.accounts.add(account);
    }

    public Handler getID() {
        return this.id;
    }

    public void doTransaction(Transaction t) throws TransactionException, MalformedHandlerException {
        boolean finish = false;
        StringBuilder error = new StringBuilder();
        if (t != null && t.getDestination() != null) {
            AccountHandler handler = new AccountHandler(t.getDestination());
            if (handler.getBankHandler().compareTo(this.bank.getID()) == 0 && handler.getOfficeHandler().compareTo(this.id) == 0) {
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
            } else {
                this.bank.doTransaction(t);
            }
        } else {
            error.append(("The transaction cannot be null or destination be null"));
        }

        if (error.length() > 0) {
            LOG.error("Office id " + this.id + " error : " + error.toString());
            throw new TransactionException(error.toString());
        }
    }
}
