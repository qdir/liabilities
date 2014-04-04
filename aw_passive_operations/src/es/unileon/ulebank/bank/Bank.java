/* Application developed for AW subject, belonging to passive operations
 group.*/
package es.unileon.ulebank.bank;

import es.unileon.ulebank.account.Account;
import es.unileon.ulebank.account.exception.TransactionException;
import es.unileon.ulebank.account.handler.AccountHandler;
import es.unileon.ulebank.bank.handler.BankHandler;
import es.unileon.ulebank.handler.Handler;
import es.unileon.ulebank.handler.MalformedHandlerException;
import es.unileon.ulebank.history.Transaction;
import es.unileon.ulebank.office.Office;
import es.unileon.ulebank.transacionManager.TransactionManager;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

/**
 *
 * @author runix
 */
public class Bank {

    private final List<Office> offices;
    private Handler bankID;
    private final TransactionManager manager;
    private static final Logger LOG = Logger.getLogger(Account.class.getName());

    public Bank(TransactionManager manager, Handler bankID) throws MalformedHandlerException {
        this.bankID = new BankHandler(bankID.toString());
        this.offices = new ArrayList<>();
        this.manager = manager;
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
        boolean removed = false;
        if (office != null) {
            for (int i = 0; i < offices.size() && !removed; ++i) {
                if (offices.get(i).getID().compareTo(office) == 0) {
                    this.offices.remove(i);
                    removed = true;
                }
            }
        }
        return removed;
    }

    public void doTransaction(Transaction t) throws MalformedHandlerException, TransactionException {
        StringBuilder error = new StringBuilder();
        if (t != null && t.getDestination() != null) {
            AccountHandler handler = new AccountHandler(t.getDestination());
            Handler bank = handler.getBankHandler();
            if (this.bankID.compareTo(bank) == 0) {
                Handler office = handler.getOfficeHandler();
                boolean found = false;
                for (int i = 0; i < this.offices.size() && !found; i++) {
                    if (this.offices.get(i).getID().compareTo(office) == 0) {
                        found = true;
                        this.offices.get(i).doTransaction(t);
                    }
                }
                if (!found) {
                    error.append("Error, office not found\n");
                }
            } else {
                this.manager.doTransaction(t);
            }
        } else {
            error.append(("The transaction cannot be null or destination be null"));
        }

        if (error.length() > 0) {
            LOG.error("Bank id " + this.bankID + " error : " + error.toString());
            throw new TransactionException(error.toString());
        }
    }
}
