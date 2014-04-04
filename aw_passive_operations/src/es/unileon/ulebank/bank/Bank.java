/* Application developed for AW subject, belonging to passive operations
 group.*/
package es.unileon.ulebank.bank;

import es.unileon.ulebank.account.exception.TransactionException;
import es.unileon.ulebank.account.handler.AccountHandler;
import es.unileon.ulebank.bank.handler.BankHandler;
import es.unileon.ulebank.handler.Handler;
import es.unileon.ulebank.handler.MalformedHandlerException;
import es.unileon.ulebank.history.Transaction;
import es.unileon.ulebank.office.Office;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author runix
 */
public class Bank {

    private List<Office> offices;
    private Handler bankID;

    public Bank(Handler bankID) throws MalformedHandlerException {
        this.bankID = new BankHandler(bankID.toString());
        this.offices = new ArrayList<>();
    }

    public Handler getID() {
        return this.bankID;
    }

    public boolean addOffice(Office office) {
        if (office != null) {
            for (int i = 0; i < offices.size(); ++i) {
                if (offices.get(i).getID().compareTo(office.getID()) == 0) {
                    return false;
                }
            }
            return this.offices.add(office);
        }
        return false;
    }

    public boolean removeBank(Handler office) {
        if (bankID != null) {
            for (int i = 0; i < offices.size(); ++i) {
                if (offices.get(i).getID().compareTo(office) == 0) {
                    return this.offices.remove(offices.get(i));
                }
            }
        }
        return false;
    }

    public void doTransaction(Transaction t) throws MalformedHandlerException, TransactionException {
        if (t != null && t.getDestination() != null) {
            Handler office = new AccountHandler(t.getDestination()).getOfficeHandler();
            boolean finish = false;
            for (int i = 0; i < this.offices.size() && !finish; i++) {
                if (this.offices.get(i).getID().compareTo(office) == 0) {
                    finish = true;
                    this.offices.get(i).doTransaction(t);
                }
            }
        } else {
            throw new TransactionException(("The transaction cannot be null or destination be null"));
        }
    }
}
