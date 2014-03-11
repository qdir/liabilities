/* Application developed for AW subject, belonging to passive operations
 group.*/

package es.unileon.aw.account.types;

import es.unileon.aw.account.Account;
import es.unileon.aw.bank.Bank;
import es.unileon.aw.handler.MalformedHandlerException;
import es.unileon.aw.office.Office;

/**
 *
 * @author runix
 */
public class CommercialAccount extends Account {

    public CommercialAccount(Office office, Bank bank, int accountnumber) throws MalformedHandlerException {
        super(office, bank, accountnumber);
    }
    
}
