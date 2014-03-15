/* Application developed for AW subject, belonging to passive operations
 group.*/

package es.unileon.aw.handler;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Revellado
 */
public class GenericHandlerTest {
    
    private GenericHandler genericHandler1, genericHandler2;
    
    @Before
    public void setUp() {
        
        genericHandler1 = new GenericHandler("0000");
        genericHandler2 = new GenericHandler("0001");
    }

    /**
     * Test of compareTo method, of class GenericHandler.
     */
    @Test
    public void testCompareTo() {
        
        System.out.println("compareTo");

        assertEquals(genericHandler1.compareTo(genericHandler1), 0);
        assertTrue(genericHandler1.toString().compareTo(genericHandler2.toString()) != 0);
    }

    /**
     * Test of toString method, of class GenericHandler.
     */
    @Test
    public void testToString() {
       
        System.out.println("toString");
        
        assertEquals(genericHandler1.toString(), "0000");
    }
}