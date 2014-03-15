package es.unileon.aw.account;

import es.unileon.aw.account.exception.BalanceException;
import es.unileon.aw.account.handler.AccountHandler;
import es.unileon.aw.bank.Bank;
import es.unileon.aw.office.Office;
import es.unileon.aw.handler.Handler;
import es.unileon.aw.handler.MalformedHandlerException;

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
     * Create a new account
     *
     * @param office (The office of the account)
     *
     * @param bank
     *
     * @param accountnumber (the number of the account)
     * @author runix
     */
    public Account(Office office, Bank bank, String accountnumber) throws MalformedHandlerException {
        this.id = new AccountHandler(office.getID(), bank.getID(), accountnumber);
        this.balance = 0;
    }

    /**
     * Get the balance of the account
     *
     * @return (the amount of money)
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
     * @author runix
     */
    public void addBalance(float balance) throws BalanceException {
        this.balance += balance;
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
