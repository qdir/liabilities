package es.unileon.aw.account;


import es.unileon.aw.account.handler.AccountHandler;
import es.unileon.aw.bank.Bank;
import es.unileon.aw.office.Office;
import es.unileon.aw.handler.Handler;
import es.unileon.aw.handler.MalformedHandlerException;

/**
 *
 * @author runix
 */
public class Account {

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
     */
    public Account(Office office, Bank bank, int accountnumber) throws MalformedHandlerException {
        this.id = new AccountHandler(office.getID(), bank.getID(), accountnumber);
        this.balance = 0;
    }
    
    /**
     * Get the amount of money of the account
     * 
     * @return (the amount of money)
     */
    public final float getBalance() {
        return this.balance;
    }
    
    public void addBalance(float balance) {
        this.balance += balance;
    }
    
    /**
     * Get the account ID
     * @return (the account id)
     */
    public final Handler getID() {
        return this.id;
    }
}
