package es.unileon.ulebank.account;

import es.unileon.ulebank.account.exception.BalanceException;
import es.unileon.ulebank.account.handler.AccountHandler;
import es.unileon.ulebank.account.history.AccountHistory;
import es.unileon.ulebank.bank.Bank;
import es.unileon.ulebank.client.Client;
import es.unileon.ulebank.office.Office;
import es.unileon.ulebank.handler.Handler;
import es.unileon.ulebank.handler.MalformedHandlerException;
import es.unileon.ulebank.history.History;
import es.unileon.ulebank.history.Transaction;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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
        this.titulars = new ArrayList<>();
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
                return false;
            }
        }
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
                this.titulars.remove(i);
                return true;
            }
        }
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
