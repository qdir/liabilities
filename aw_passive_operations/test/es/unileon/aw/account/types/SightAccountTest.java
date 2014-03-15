/* Application developed for AW subject, belonging to passive operations
 group.*/

package es.unileon.aw.account.types;

import es.unileon.aw.account.Account;
import es.unileon.aw.bank.Bank;
import es.unileon.aw.handler.MalformedHandlerException;
import es.unileon.aw.office.Office;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Revellado
 */
public class SightAccountTest {
    
    private Account sightAccount;
    
    @Before
    public void setUp() throws MalformedHandlerException {
        this.sightAccount = new SightAccount(new Office(), new Bank(), "0000000000");
    }
    /**
     * Test of expected MalformedHandlerException throw
     */
    @Test (expected=MalformedHandlerException.class)
    public void checkExpectedException() throws MalformedHandlerException {
        sightAccount = new SightAccount(new Office(), new Bank(), "00000000000");
    }
    
       /**
     * Test of getBalance method, of class Account.
     */
    @Test
    public void testGetBalance() {
        
        System.out.println("getBalance");
        float expResult = 0.0F;
        float result = this.sightAccount.getBalance();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of addBalance method, of class Account.
     */
    @Test
    public void testAddBalance() throws Exception {
        
        System.out.println("addBalance");
        float balance = 2.0F;
        float expResult = 2.0F;
        this.sightAccount.addBalance(balance);
        assertEquals(expResult, this.sightAccount.getBalance(), 2.0F);
    }
}
