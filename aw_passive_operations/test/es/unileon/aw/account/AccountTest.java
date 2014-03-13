/* Application developed for AW subject, belonging to passive operations
 group.*/

package es.unileon.aw.account;

import es.unileon.aw.bank.Bank;
import es.unileon.aw.handler.MalformedHandlerException;
import es.unileon.aw.office.Office;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Revellado
 */
public class AccountTest {
    
    private Account account;
    
    @Before
    public void setUp() {
        
        try{
            
            account = new Account(new Office(), new Bank(), "0000000000");
        }catch(MalformedHandlerException ex){
            
            ex.getMessage();
            ex.printStackTrace();
        }
    }

    /**
     * Test of getBalance method, of class Account.
     */
    @Test
    public void testGetBalance() {
        
        System.out.println("getBalance");
        float expResult = 0.0F;
        float result = this.account.getBalance();
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
        this.account.addBalance(balance);
        assertEquals(expResult, this.account.getBalance(), 2.0F);
    }

    /**
     * Test of getID method, of class Account.
     */
    @Test
    public void testGetID() {
        
        System.out.println("getID");
        assertTrue(this.account.getID() != null);
    }
    
}
