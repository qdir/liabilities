/* Application developed for AW subject, belonging to passive operations
 group.*/

package es.unileon.aw.bank;

import es.unileon.ulebank.bank.Bank;
import es.unileon.ulebank.handler.GenericHandler;
import es.unileon.ulebank.handler.Handler;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Revellado
 */
public class BankTest {
    
    private Bank bank;
    
    @Before
    public void setUp() {
        
        bank = new Bank();
    }

    /**
     * Test of getID method, of class Bank.
     */
    @Test
    public void testGetID() {
        
        System.out.println("getID");
        
        Handler expResult = new GenericHandler("1234");
        assertNotNull(bank.getID());
        assertEquals(bank.getID().compareTo(expResult),0);
    }
}
