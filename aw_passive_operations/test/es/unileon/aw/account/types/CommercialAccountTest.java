/* Application developed for AW subject, belonging to passive operations
 group.*/

package es.unileon.aw.account.types;

import es.unileon.aw.bank.Bank;
import es.unileon.aw.handler.MalformedHandlerException;
import es.unileon.aw.office.Office;
import org.junit.Test;

/**
 *
 * @author Revellado
 */
public class CommercialAccountTest {

    private CommercialAccount commercialAccount;
    
    /**
     * Test of expected MalformedHandlerException throw
     */
    @Test (expected=MalformedHandlerException.class)
    public void checkExpectedException() throws MalformedHandlerException {
        commercialAccount = new CommercialAccount(new Office(), new Bank(), "a000000000");
    }
    
}
