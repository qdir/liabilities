package es.unileon.ulebank.command;

import es.unileon.ulebank.handler.Handler;
import java.util.Date;
import es.unileon.ulebank.account.Account;
import es.unileon.ulebank.bank.Bank;
import es.unileon.ulebank.handler.MalformedHandlerException;
import es.unileon.ulebank.office.Office;

/**
 * **SIN ACABAR***
 */
/**
 *
 * @author Paula
 */
public class CreateAccountCommand implements Command {

    private final Office office;
    private final Bank bank;
    private final Handler commandID;
    private final Date effectiveDate;

    public CreateAccountCommand(Office office, Bank bank, Date effectiveDate, Handler commandId) {
        this.bank = bank;
        this.office = office;
        this.effectiveDate = effectiveDate;
        this.commandID = commandId;
    }

    @Override
    public void execute() throws MalformedHandlerException {
        Account account = null;
        account = new Account(this.office, this.bank, this.office.getNewAccountNumber());
        this.office.addAccount(account);

    }

    @Override
    public Date getEffectiveDate() {
        return this.effectiveDate;
    }

    @Override
    public Handler getID() {
        return this.commandID;
    }

    @Override
    public void undo() {
        //TODO remove account
//        this.office.
    }

    @Override
    public void redo() {
        //TODO add account
    }

}
