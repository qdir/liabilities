package es.unileon.ulebank.account;

import es.unileon.ulebank.account.exception.TransactionException;
import es.unileon.ulebank.account.handler.AccountHandler;
import es.unileon.ulebank.account.history.AccountHistory;
import es.unileon.ulebank.account.liquidation.LiquidationStrategy;
import es.unileon.ulebank.bank.Bank;
import es.unileon.ulebank.client.Client;
import es.unileon.ulebank.handler.Handler;
import es.unileon.ulebank.handler.MalformedHandlerException;
import es.unileon.ulebank.history.History;
import es.unileon.ulebank.history.Transaction;
import es.unileon.ulebank.office.Office;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.apache.log4j.Logger;

/**
 *
 * @author runix
 */
public abstract class Account {

    //TODO, need to add liquidation frequency
    //and a method to perform the liquidation 
    /**
     * The logger of the class
     */
    private static final Logger LOG = Logger.getLogger(Account.class.getName());
    /**
     * The account identifier
     */
    private Handler id;

    /**
     * The account balance
     */
    private double balance;
    /**
     * The account titulars
     */
    private List<Client> titulars;
    /**
     * The history of the account
     */
    private final History<Transaction> history;
    /**
     * The strategy to liquidate the account
     */
    private LiquidationStrategy strategy;
    /**
     * The last liquidation
     */
    private Date lastLiquidation;
    /**
     * The liquidation frequency in months
     */
    private int liquidationFrecuency;

    /**
     * The default liquidation frecuency
     */
    private static final int DEFAULT_LIQUIDATION_FREQUENCY = 6;

    /**
     * Create a new account
     *
     * @param office (The office of the account)
     *
     * @param bank ( The bank of the office )
     *
     * @param accountnumber (the accountNumber)
     *
     * @throws es.unileon.ulebank.handler.MalformedHandlerException
     *
     */
    public Account(Office office, Bank bank, String accountnumber) throws MalformedHandlerException {
        this.id = new AccountHandler(office.getID(), bank.getID(), accountnumber);
        this.history = new AccountHistory();
        this.balance = 0.0d;
        this.titulars = new ArrayList<>();
        this.lastLiquidation = new Date(System.currentTimeMillis());
        this.liquidationFrecuency = DEFAULT_LIQUIDATION_FREQUENCY;
        LOG.info("Create a new account with number " + accountnumber + " office " + office.getID().toString() + " bank " + bank.getID());
    }

    /**
     * Set the liquidation frecuency in months
     *
     * ( Default {
     *
     *
     * @see DEFAULT_LIQUIDATION_FREQUENCY} )
     *
     * @param liquidationFrecuency ( new liquidation frecuency )
     *
     * @return (true if success, false if the param is negative or zero)
     */
    public boolean setLiquidationFrecuency(int liquidationFrecuency) {
        LOG.info("Change liquidation frecuency to " + liquidationFrecuency);
        if (liquidationFrecuency >= 1) {
            this.liquidationFrecuency = liquidationFrecuency;
            return true;
        }
        return false;
    }

    /**
     *
     * Add a new titular
     *
     * @param client ( client to add)
     *
     * @return ( true if success, else false )
     */
    public boolean addTitular(Client client) {
        for (int i = 0; i < this.titulars.size(); i++) {
            if (this.titulars.get(i).getId().compareTo(client.getId()) == 0) {
                LOG.error("Cannot add the titular " + client.getId().toString() + " , the titular already exists");
                return false;
            }
        }
        LOG.info(("Add new titular " + client.getId()));
        this.titulars.add(client);
        return true;
    }

    /**
     *
     * Delete a titular
     *
     * @param id ( The client id )
     *
     * @return ( true if success, else false )
     */
    public boolean deleteTitular(Handler id) {
        for (int i = 0; i < this.titulars.size(); i++) {
            if (this.titulars.get(i).getId().compareTo(id) == 0) {
                LOG.info("Delete " + id.toString() + " titular");
                this.titulars.remove(i);
                return true;
            }
        }
        LOG.error("Cannot remove the titular " + id.toString() + " because it doesn't exist");
        return false;
    }

    /**
     * Get the account titulars
     *
     * @return ( The titulars )
     */
    public List<Client> getTitulars() {
        return new ArrayList<>(this.titulars);
    }

    /**
     * Get the account balance
     *
     * @return (the balance)
     *
     * @author runix
     */
    public final double getBalance() {
        return this.balance;
    }

    /**
     * Check if there are incosistences. If the program crash when a transaction
     * was being doing maybe the account balance not be the same as the sum of
     * all transactions. So, if the method return false imply that the last
     * transaction hadn't been finished.
     *
     * @return ( True if the account is consistent, and false otherwise)
     */
    public boolean checkInconsistences() {
        Collection<Transaction> trans = this.getTransactions();
        Iterator<Transaction> iterator = trans.iterator();
        double balance = 0.0d;
        while (iterator.hasNext()) {
            balance += iterator.next().getAmount();
        }
        return balance == this.balance;
    }

    /**
     * Do a transaction. A transaction is a movement of money, that is, do a
     * transaction is the only way to take out or take money money into an
     * account.
     *
     * @param transaction ( Transaction to do)
     *
     * @throws TransactionException (if the subject or id is null or empty)
     */
    public synchronized void doTransaction(Transaction transaction) throws TransactionException {
        StringBuilder err = new StringBuilder();
        if (transaction.getSubject() == null) {
            err.append("The subject cannot be null \n");
        }

        if (transaction.getSubject().length() == 0) {
            err.append("Transaction length cannot be 0 \n");
        }

        if (transaction.getId() == null) {
            err.append(("The id cannot be null \n"));
        }

        if (transaction.getId().toString().length() == 0) {
            err.append(("The id size cannot be 0 \n"));
        }

        if (transaction.getDate() == null) {
            err.append("The date cannot be null");
        }

        if (transaction.getEffectiveDate() == null) {
            err.append("The effective date cannot be null");
        }
        if (err.length() > 0) {
            LOG.error(err.toString());
            throw new TransactionException(err.toString());
        }
        boolean success = this.history.addTransaction(transaction);
        if (success) {
            this.balance += transaction.getAmount();
            LOG.info("Did transaction with id : " + transaction.getId());
        } else {
            String error = "Cannot store the transaction\n";
            LOG.error(error);
            throw new TransactionException(error);
        }
    }

    /**
     * Set the strategy to liquidate the account
     *
     * @param strategy ( The strategy )
     */
    public void setLiquidationStrategy(LiquidationStrategy strategy) {
        this.strategy = strategy;
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
     * Get the account ID
     *
     * @return (the account id)
     * @author runix
     */
    public final Handler getID() {
        return this.id;
    }
}
