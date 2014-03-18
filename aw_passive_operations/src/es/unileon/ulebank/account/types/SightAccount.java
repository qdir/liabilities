/* Application developed for AW subject, belonging to passive operations
 group.*/
package es.unileon.ulebank.account.types;

import es.unileon.ulebank.account.Account;
import es.unileon.ulebank.account.AccountTypes;
import es.unileon.ulebank.account.exception.BalanceException;
import es.unileon.ulebank.bank.Bank;
import es.unileon.ulebank.handler.MalformedHandlerException;
import es.unileon.ulebank.office.Office;

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
