/* Application developed for AW subject, belonging to passive operations
 group.*/
package es.unileon.ulebank.office;

import es.unileon.ulebank.account.Account;
import es.unileon.ulebank.account.TransactionException;
import es.unileon.ulebank.account.AccountHandler;
import es.unileon.ulebank.bank.Bank;
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
    private long nextAccountNumber;
    public static final long MAX_ACCOUNT_NUMBER = 1000000000l - 1;

    public Office(Handler id, Bank bank) {
        this.accounts = new ArrayList<>();
        this.id = id;
        this.bank = bank;
        this.nextAccountNumber = 0;
    }

    public boolean addAccount(Account account) {
        return this.accounts.add(account);
    }

    public Handler getID() {
        return this.id;
    }

    public void doTransaction(Transaction t, Handler destine) throws TransactionException, MalformedHandlerException {
        boolean finish = false;
        StringBuilder error = new StringBuilder();
        if (t != null && destine != null) {
            AccountHandler handler = new AccountHandler(destine);
            if (handler.getBankHandler().compareTo(this.bank.getID()) == 0 && handler.getOfficeHandler().compareTo(this.id) == 0) {
                for (int i = 0; i < accounts.size() && !finish; i++) {
                    if (accounts.get(i).getID().compareTo(destine) == 0) {
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
                this.bank.doTransaction(t, destine);
            }
        } else {
            error.append(("The transaction cannot be null or destination be null"));
        }

        if (error.length() > 0) {
            LOG.error("Office id " + this.id + " error : " + error.toString());
            throw new TransactionException(error.toString());
        }
    }

    public synchronized String getNewAccountNumber() {
        String accountNumber;
        if (this.nextAccountNumber == MAX_ACCOUNT_NUMBER) {
            accountNumber = "";
        } else {
            accountNumber = String.format("%010d", this.nextAccountNumber++);
        }
        return accountNumber;
    }

    public List<Account> getAccounts() {
        return this.accounts;
    }
}
