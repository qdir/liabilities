package es.unileon.ulebank.account;

import es.unileon.ulebank.account.exception.TransactionException;
import es.unileon.ulebank.account.handler.AccountHandler;
import es.unileon.ulebank.account.history.AccountEntry;
import es.unileon.ulebank.account.history.AccountHistory;
import es.unileon.ulebank.account.history.DetailedInformation;
import es.unileon.ulebank.account.liquidation.LiquidationStrategy;
import es.unileon.ulebank.bank.Bank;
import es.unileon.ulebank.client.Client;
import es.unileon.ulebank.handler.Handler;
import es.unileon.ulebank.handler.MalformedHandlerException;
import es.unileon.ulebank.history.GenericTransaction;
import es.unileon.ulebank.history.History;
import es.unileon.ulebank.history.Transaction;
import es.unileon.ulebank.history.TransactionType;
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
    private final AccountHistory history;
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
        Iterator<AccountEntry> iterator = this.getHistory().getHistory().iterator();
        double balance = 0.0d;
        while (iterator.hasNext()) {
            balance += iterator.next().getAmount();
        }
        return balance == this.balance;
    }

    /**
     * Withdraw money from the account and put into the destination.
     *
     * @param transaction
     * @throws es.unileon.ulebank.account.exception.TransactionException
     */
    public synchronized void doWithdrawal(Transaction transaction) throws TransactionException {
        StringBuilder err = new StringBuilder();
        if (transaction.getSubject() == null) {
            err.append("The subject cannot be null \n");
        }

        if (transaction.getSubject().length() == 0) {
            err.append("Transaction length cannot be 0 \n");
        }

        if (transaction.getType() != TransactionType.CHARGE) {
            err.append("Withdrawal operations must be " + TransactionType.CHARGE + " type\n");
        }

        if (transaction.getId() == null) {
            err.append(("The id cannot be null \n"));
        }

        if (transaction.getId().toString().length() == 0) {
            err.append(("The id size cannot be 0 \n"));
        }

        if (transaction.getDate() == null) {
            err.append("The date cannot be null \n");
        }

        if (transaction.getDestination() == null) {
            err.append("The destination account id cannot be null \n");
        }

        if (transaction.getAmount() < 0) {
            err.append("Fail, the amount of money cannot be less than zero\n");
        }
        if (err.length() > 0) {
            LOG.error(err.toString());
            throw new TransactionException(err.toString());
        }
        DetailedInformation extraInformation = new DetailedInformation();
        AccountEntry accountEntry = new AccountEntry(transaction.getType(), transaction.getAmount(), transaction.getSubject(), transaction.getId(), transaction.getDate(), transaction.getEffectiveDate(), extraInformation);
        boolean success = this.history.appendEntry(accountEntry);
        if (success) {
            this.balance -= transaction.getAmount();
            transaction.setEffectiveDate(new Date(System.currentTimeMillis()));
        } else {
            String error = "Cannot store the transaction\n";
            LOG.error(error);
            throw new TransactionException(error);
        }

    }

    /**
     *
     * @param transaction
     * @throws es.unileon.ulebank.account.exception.TransactionException
     */
    public synchronized void doDeposit(Transaction transaction) throws TransactionException {
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

        if (transaction.getType() != TransactionType.PAYMENT) {
            err.append("Deposit operations must be" + TransactionType.PAYMENT + " type\n");
        }

        if (transaction.getId().toString().length() == 0) {
            err.append(("The id size cannot be 0 \n"));
        }

        if (transaction.getDate() == null) {
            err.append("The date cannot be null \n");
        }

        if (transaction.getDestination() == null) {
            err.append("The destination account id cannot be null \n");
        }

        if (transaction.getDestination().compareTo(this.id) != 0) {
            err.append("Fail, wrong destination \n");
        }

        if (transaction.getAmount() < 0) {
            err.append("Fail, the amount of money cannot be less than zero\n");
        }

        if (err.length() > 0) {
            LOG.error(err.toString());
            throw new TransactionException(err.toString());
        }
        DetailedInformation extraInformation = new DetailedInformation();
        AccountEntry accountEntry = new AccountEntry(transaction.getType(), transaction.getAmount(), transaction.getSubject(), transaction.getId(), transaction.getDate(), transaction.getEffectiveDate(), extraInformation);
        boolean success = this.history.appendEntry(accountEntry);
        if (success) {
            this.balance += transaction.getAmount();
            transaction.setEffectiveDate(new Date(System.currentTimeMillis()));
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
    public AccountHistory getHistory() {
        return this.history;
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
