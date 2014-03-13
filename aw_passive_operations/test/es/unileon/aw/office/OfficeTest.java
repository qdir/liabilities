/* Application developed for AW subject, belonging to passive operations
 group.*/

package es.unileon.aw.office;

import es.unileon.aw.handler.GenericHandler;
import es.unileon.aw.handler.Handler;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Revellado
 */
public class OfficeTest {
    
    private Office office;
    
    @Before
    public void setUp() {
        
        office = new Office();
    }

    /**
     * Test of getID method, of class Office.
     */
    @Test
    public void testGetID() {
        
        System.out.println("getID");

        Handler expResult = new GenericHandler("1234");

        assertEquals(office.getID().compareTo(expResult),0);
        
    }
    
}
