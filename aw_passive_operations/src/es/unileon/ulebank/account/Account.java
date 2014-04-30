package es.unileon.ulebank.account;

import es.unileon.ulebank.bank.Bank;
import es.unileon.ulebank.client.Client;
import es.unileon.ulebank.handler.Handler;
import es.unileon.ulebank.handler.MalformedHandlerException;
import es.unileon.ulebank.history.Transaction;
import es.unileon.ulebank.history.TransactionType;
import es.unileon.ulebank.office.Office;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.log4j.Logger;

/**
 *
 * @author runix
 */
public class Account {

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
    private final List<Client> titulars;
    /**
     * The account authorizeds
     */
    private final List<Client> authorizeds;
    /**
     * The history of the account
     */
    private final AccountHistory history;
    /**
     * The last liquidation
     */
    private Date lastLiquidation;
    /**
     * The liquidation frequency in months
     */
    private int liquidationFrecuency;

    private List<LiquidationStrategy> liquidationStrategies;

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
        this.authorizeds = new ArrayList<>();
        this.lastLiquidation = new Date(System.currentTimeMillis());
        this.liquidationFrecuency = DEFAULT_LIQUIDATION_FREQUENCY;
        this.liquidationStrategies = new ArrayList<>();
        LOG.info("Create a new account with number " + accountnumber + " office " + office.getID().toString() + " bank " + bank.getID());
    }

    /**
     * Set the liquidation frecuency in months
     *
     * ( Default {
     *
     * @see DEFAULT_LIQUIDATION_FREQUENCY} )
     *
     * @param liquidationFrecuency ( new liquidation frecuency )
     *
     * @return (true if success, false if the param is negative or zero)
     */
    public boolean setLiquidationFrecuency(int liquidationFrecuency) {
        if (liquidationFrecuency >= 1) {
            LOG.info("Change liquidation frecuency to " + liquidationFrecuency);
            this.liquidationFrecuency = liquidationFrecuency;
            return true;
        }
        return false;
    }

    /**
     *
     * Add a new titular. The client cannot be repeated, that is, two titulars
     * cannot have the same id, because its id is unique. If we try to add a
     * person that is already added the method return false.
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
     * Delete a titular. If the titular hadn't been added, the method return
     * false.
     *
     * @see es.unileon.ulebank.handler.Handler}.
     *
     * @param id ( The client id )
     *
     * @return ( true if success, false otherwise )
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
     *
     * Add a new authorized. The authorized cannot be repeated, that is, two
     * titulars cannot have the same id, because its id is unique.If we try to
     * add a person that is already added the method return false.
     *
     *
     * @param authorized ( authorized to add)
     *
     * @return ( true if success, else false )
     */
    public boolean addAuthorized(Client authorized) {
        for (int i = 0; i < this.authorizeds.size(); i++) {
            if (this.authorizeds.get(i).getId().compareTo(authorized.getId()) == 0) {
                LOG.error("Cannot add the authorized " + authorized.getId().toString() + " , the authorized already exists");
                return false;
            }
        }
        LOG.info(("Add new titular " + authorized.getId()));
        return this.authorizeds.add(authorized);
    }

    /**
     *
     * Delete a authorized. If the authorized hadn't been added, the method
     * return false.
     *
     * @see es.unileon.ulebank.handler.Handler}.
     *
     * @param id ( The authorized id )
     *
     * @return ( true if success, else false )
     */
    public boolean deleteAuthorized(Handler id) {
        for (int i = 0; i < this.authorizeds.size(); i++) {
            if (this.authorizeds.get(i).getId().compareTo(id) == 0) {
                LOG.info("Delete " + id.toString() + " authorized");
                this.authorizeds.remove(i);
                return true;
            }
        }
        LOG.error("Cannot remove the authorized " + id.toString() + " because it doesn't exist");
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
     * Get the authorizeds
     *
     * @return ( the authorizeds )
     */
    public List<Client> getAuthorizeds() {
        return new ArrayList<>(this.authorizeds);
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
     * Withdraw money from the account.
     *
     * @param transaction ( transaction to do )
     *
     * @throws es.unileon.ulebank.account.exception.TransactionException (if
     * there are some null fields in the transaction)
     */
    public synchronized void doWithdrawal(Transaction transaction) throws TransactionException {
        StringBuilder err = new StringBuilder();
        if (transaction.getSubject() == null) {
            err.append("The subject cannot be null \n");
        } else {
            if (transaction.getSubject().length() == 0) {
                err.append("Transaction length cannot be 0 \n");
            }
        }

        if (transaction.getType() != TransactionType.CHARGE && transaction.getType() != TransactionType.SALARY) {
            err = err.append("Withdrawal operations must be ").append(TransactionType.CHARGE).append(" type\n");
        }

        if (transaction.getId() == null) {
            err.append(("The id cannot be null \n"));
        } else {
            if (transaction.getId().toString().length() == 0) {
                err.append(("The id size cannot be 0 \n"));
            }
        }
        if (transaction.getDate() == null) {
            err.append("The date cannot be null \n");
        }

        if (transaction.getAmount() < 0) {
            err.append("Fail, the amount of money cannot be less than zero\n");
        }

        if (transaction.getEffectiveDate() == null) {
            err.append("The effective date cannot be null \n");
        }
        if (err.length() > 0) {
            LOG.error(err.toString());
            throw new TransactionException(err.toString());
        }
        boolean success = this.history.addTransaction(transaction);
        if (success) {
            this.balance -= transaction.getAmount();
        } else {
            String error = "Cannot store the transaction\n";
            LOG.error(error);
            throw new TransactionException(error);
        }

    }

    /**
     * Deposit money in the account
     *
     * @param transaction ( transaction to do )
     *
     * @throws TransactionException (if there are some null fields in the
     * transaction)
     */
    public synchronized void doDeposit(Transaction transaction) throws TransactionException {
        StringBuilder err = new StringBuilder();
        if (transaction.getSubject() == null) {
            err.append("The subject cannot be null \n");
        } else {
            if (transaction.getSubject().length() == 0) {
                err.append("Transaction length cannot be 0 \n");
            }
        }

        if (transaction.getType() != TransactionType.PAYMENT && transaction.getType() != TransactionType.PAYROLL) {
            err = err.append("Deposit operations must be").append(TransactionType.PAYMENT).append(" type\n");
        }

        if (transaction.getId() == null) {
            err.append(("The id cannot be null \n"));
        } else {
            if (transaction.getId().toString().length() == 0) {
                err.append(("The id size cannot be 0 \n"));
            }
        }

        if (transaction.getDate() == null) {
            err.append("The date cannot be null \n");
        }

        if (transaction.getAmount() < 0) {
            err.append("Fail, the amount of money cannot be less than zero\n");
        }

        if (transaction.getEffectiveDate() == null) {
            err.append("The effective date cannot be null \n");
        }
        if (err.length() > 0) {
            LOG.error(err.toString());
            throw new TransactionException(err.toString());
        }

        boolean success = this.history.addTransaction(transaction);
        if (success) {
            this.balance += transaction.getAmount();
        } else {
            String error = "Cannot store the transaction\n";
            LOG.error(error);
            throw new TransactionException(error);
        }
    }

    public boolean addLiquidationStrategy(LiquidationStrategy strategy) {
        int i = 0;
        boolean found = false;
        while (i < this.liquidationStrategies.size() && !found) {
            if (this.liquidationStrategies.get(i).getID().compareTo(strategy.getID()) == 0) {
                found = true;
            }
        }
        if (!found) {
            this.liquidationStrategies.add(strategy);
        }
        return !found;
    }

    public boolean deleteLiquidationStrategy(Handler id) {
        int i = 0;
        boolean found = false;
        while (i < this.liquidationStrategies.size() && !found) {
            if (this.liquidationStrategies.get(i).getID().compareTo(id) == 0) {
                this.liquidationStrategies.remove(i);
                found = true;
            }
        }
        return found;
    }

    public void doLiquidation(Office office) {
        StringBuilder err = new StringBuilder();
        try {
            AccountHandler ah = new AccountHandler(this.id);
            if (office.getID().compareTo(ah) == 0) {

            } else {
                err.append("Wrong office\n");
            }
        } catch (MalformedHandlerException e) {
            err.append("Error while parsing handler\n");
        }
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
