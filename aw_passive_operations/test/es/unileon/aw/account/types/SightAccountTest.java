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
public class SightAccountTest {
    
    private SightAccount sightAccount;
    
    /**
     * Test of expected MalformedHandlerException throw
     */
    @Test (expected=MalformedHandlerException.class)
    public void checkExpectedException() throws MalformedHandlerException {
        sightAccount = new SightAccount(new Office(), new Bank(), "00000000000");
    }
    
}
