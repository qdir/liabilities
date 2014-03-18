/* Application developed for AW subject, belonging to passive operations
 group.*/

package es.unileon.aw.handler;

import es.unileon.ulebank.handler.GenericHandler;
import es.unileon.ulebank.handler.MalformedHandlerException;
import es.unileon.ulebank.handler.Handler;
import es.unileon.ulebank.account.handler.AccountHandler;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Revellado
 */
public class HandlerTest {
    
    private Handler genericHandler1, genericHandler2, accountHandler;
    
    @Before
    public void setUp() {
        
        genericHandler1 = new GenericHandler("0000");
        genericHandler2 = new GenericHandler("0001");
        
        try{
            
             accountHandler = new AccountHandler(genericHandler1, genericHandler2, "0000000000");
        }catch (MalformedHandlerException ex){
            
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
            
       
    }

    /**
     * Test of compareTo method, of interface Handler.
     */
    @Test
    public void testCompareTo() {
        
        System.out.println("compareTo");
        
        assertEquals(genericHandler1.compareTo(genericHandler1), 0);
        assertTrue(genericHandler1.toString().compareTo(genericHandler2.toString()) != 0);
        assertEquals(accountHandler.compareTo(accountHandler), 0);
        assertTrue(accountHandler.toString().compareTo(genericHandler1.toString()) != 0);
    }
    
}
