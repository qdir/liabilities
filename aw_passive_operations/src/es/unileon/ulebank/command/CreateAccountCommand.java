package es.unileon.ulebank.command;

import es.unileon.ulebank.account.Account;
import es.unileon.ulebank.bank.Bank;
import es.unileon.ulebank.client.Client;
import es.unileon.ulebank.handler.Handler;
import es.unileon.ulebank.handler.MalformedHandlerException;
import es.unileon.ulebank.office.Office;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Paula
 */
public class CreateAccountCommand implements Command {

    private final Office office;
    private final Bank bank;
    private final Handler commandID;
    private Account account;
    private final Client titular;
    private final List<Client> authorizeds;
    private final List<Client> titulars;

    /**
     *
     * @param office
     * @param bank
     * @param effectiveDate
     * @param commandId
     * @param titular
     */
    public CreateAccountCommand(Office office, Bank bank, Date effectiveDate, Handler commandId, Client titular) {
        this(office, bank, commandId, titular, new ArrayList<Client>(), new ArrayList<Client>());
    }

    /**
     *
     * @param office
     * @param bank
     * @param commandId
     * @param titular
     * @param authorizeds
     */
    public CreateAccountCommand(Office office, Bank bank, Handler commandId, Client titular, List<Client> authorizeds) {
        this(office, bank, commandId, titular, authorizeds, new ArrayList<Client>());
    }

    /**
     *
     * @param office
     * @param bank
     * @param commandId
     * @param titular
     */
    public CreateAccountCommand(Office office, Bank bank, Handler commandId, Client titular, List<Client> authorizeds, List<Client> titulars) {
        this.bank = bank;
        this.office = office;
        this.titular = titular;
        this.commandID = commandId;
        this.authorizeds = authorizeds;
        this.titulars = titulars;
    }

    /**
     *
     */
    @Override
    public void execute() {
        try {
            if (this.account == null) {
                this.account = new Account(this.office, this.bank, this.office.getNewAccountNumber(), this.titular);
                for (Client c : this.titulars) {
                    this.account.addTitular(c);
                }
                for (Client c : this.authorizeds) {
                    this.account.addAuthorized(c);
                }
                this.office.addAccount(account);
            }
        } catch (MalformedHandlerException ex) {
            Logger.getLogger(CreateAccountCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     * @return
     */
    @Override
    public Handler getID() {
        return this.commandID;
    }

    /**
     *
     */
    @Override
    public void undo() {
        if (this.account != null) {
            this.office.deleteAccount(this.account.getID());
        }
    }

    /**
     *
     */
    @Override
    public void redo() {
        if (this.account != null) {
            this.office.addAccount(this.account);
        }
    }

}
