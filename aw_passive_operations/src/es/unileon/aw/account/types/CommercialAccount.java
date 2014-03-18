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
public class CommercialAccount extends Account {

    public CommercialAccount(Office office, Bank bank, String accountnumber) throws MalformedHandlerException {
        super(office, bank, accountnumber);
    }

    @Override
    public void addBalance(float balance) throws BalanceException {
            super.addBalance(balance);
    }
    
    @Override
    public AccountTypes getType() {
        return AccountTypes.COMMERCIAL_ACCOUNT;
    }

}
