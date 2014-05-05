/* Application developed for AW subject, belonging to passive operations
 group.*/
package es.unileon.ulebank.iterator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author runix
 */
public class FakeConditionTest {

    @Test
    public void testTrue() {
        FakeCondition f = new FakeCondition(true);
        assertTrue(f.test(null));
    }

    @Test
    public void testFalse() {
        FakeCondition f = new FakeCondition(false);
        assertFalse(f.test(null));
    }
}
