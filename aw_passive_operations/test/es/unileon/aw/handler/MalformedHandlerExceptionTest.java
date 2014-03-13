/* Application developed for AW subject, belonging to passive operations
 group.*/

package es.unileon.aw.handler;

import es.unileon.aw.account.Account;
import es.unileon.aw.bank.Bank;
import es.unileon.aw.office.Office;
import org.junit.Test;

/**
 *
 * @author Revellado
 */
public class MalformedHandlerExceptionTest {
    
    private Account account;

    @Test(expected=MalformedHandlerException.class)
    public void checkExpectedException() throws MalformedHandlerException {
        account = new Account(new Office(), new Bank(), "a000000000");
    }
    
}
