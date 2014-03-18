/* Application developed for AW subject, belonging to passive operations
 group.*/
package es.unileon.aw.account.types;

import es.unileon.aw.account.Account;
import es.unileon.aw.account.AccountTypes;
import es.unileon.aw.account.exception.BalanceException;
import es.unileon.aw.bank.Bank;
import es.unileon.aw.handler.MalformedHandlerException;
import es.unileon.aw.office.Office;

/**
 *
 * @author runix
 */
public class SightAccount extends Account {

    public SightAccount(Office office, Bank bank, String accountnumber) throws MalformedHandlerException {
        super(office, bank, accountnumber);
    }

    @Override
    public void addBalance(float balance) throws BalanceException {
            throw new BalanceException("The account balance cannot be negative");
    }

    @Override
    public AccountTypes getType() {
        return AccountTypes.SIGH_ACCOUNT;
    }

}
