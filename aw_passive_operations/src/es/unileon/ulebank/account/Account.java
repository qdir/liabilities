package es.unileon.ulebank.account;

import es.unileon.ulebank.account.exception.BalanceException;
import es.unileon.ulebank.account.handler.AccountHandler;
import es.unileon.ulebank.account.history.AccountHistory;
import es.unileon.ulebank.bank.Bank;
import es.unileon.ulebank.office.Office;
import es.unileon.ulebank.handler.Handler;
import es.unileon.ulebank.handler.MalformedHandlerException;
import es.unileon.ulebank.history.History;
import es.unileon.ulebank.history.Transaction;
import java.util.Collection;

/**
 *
 * @author runix
 */
public abstract class Account {

    /**
     * The account identifier
     */
    private Handler id;
    /**
     * The amount of money of the account
     */
    private float balance;

    /**
     * The history of the account
     */
    private final History<Transaction> history;

    /**
     * Create a new account
     *
     * @param office (The office of the account)
     *
     * @param bank
     *
     * @param accountnumber (the number of the account)
     *
     * @throws es.unileon.ulebank.handler.MalformedHandlerException
     *
     */
    public Account(Office office, Bank bank, String accountnumber) throws MalformedHandlerException {
        this.id = new AccountHandler(office.getID(), bank.getID(), accountnumber);
        this.history = new AccountHistory();
        this.balance = 0.0f;
    }

    /**
     * Get the account balance
     *
     * @return (the balance)
     *
     * @author runix
     */
    public final float getBalance() {
        return this.balance;
    }

    /**
     * Change the account balance
     *
     * @param balance ( the balance to add/substract)
     *
     * @throws es.unileon.aw.account.exception.BalanceException ( If there are
     * inconsistencies with the new balance, for example, if its a debit account
     * the balance cannot be negative.
     *
     * @author runix
     */
    @Deprecated
    @SuppressWarnings("Migration to doTransaction")
    public void addBalance(float balance) throws BalanceException {
        this.balance += balance;
    }

    /**
     *
     * @param transaction
     *
     * @throws BalanceException (If there are inconsistencies with the new
     * balance, for example, if its a debit account the balance cannot be
     * negative.
     */
    public void doTransaction(Transaction transaction) throws BalanceException {
        this.history.addTransaction(transaction);
        this.balance += transaction.getAmount();
    }

    /**
     * Get the account transactions
     *
     * @return (The transactions)
     */
    public Collection<Transaction> getTransactions() {
        return this.history.getTransactions();
    }

    /**
     * Get the account type
     *
     * @return ( the type )
     *
     * @author runix
     */
    public abstract AccountTypes getType();

    /**
     * Get the account ID
     *
     * @return (the account id)
     * @author runix
     */
    public final Handler getID() {
        return this.id;
    }
}
