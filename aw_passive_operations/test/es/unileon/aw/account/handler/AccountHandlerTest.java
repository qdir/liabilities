/* Application developed for AW subject, belonging to passive operations
 group.*/

package es.unileon.aw.account.handler;

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
public class AccountHandlerTest {
    
    private AccountHandler accountHandler1,accountHandler2;

    @Before
    public void setUp() {
        
        Bank bank = new Bank();
        Office office = new Office();
        
        try{
            
            accountHandler1 = new AccountHandler(office.getID(), bank.getID(), "0000000000");
            accountHandler1 = new AccountHandler(office.getID(), bank.getID(), "0000000000");
            accountHandler2 = new AccountHandler(office.getID(), bank.getID(), "0000000001");
        }catch (MalformedHandlerException ex){
            
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }

    /**
     * Test of compareTo method, of class AccountHandler.
     */
    @Test
    public void testCompareTo() {
        
        System.out.println("compareTo");

        assertEquals(accountHandler1.compareTo(accountHandler1),0);
        assertTrue(accountHandler1.compareTo(accountHandler2) != 01);
    }

    /**
     * Test of toString method, of class AccountHandler.
     */
    @Test
    public void testToString() {
        
        System.out.println("toString");
        
        String expResult = accountHandler1.toString();
        assertEquals(accountHandler1.toString(), expResult);
    }
    
}
