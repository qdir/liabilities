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
    public void testFakeConditionAllTrue() {
        FakeCondition f = new FakeCondition(true, true);
        assertTrue(f.test(null));
        assertTrue(f.isExclusive());
    }

    @Test
    public void testFakeConditionAllNeg() {
        FakeCondition f = new FakeCondition(false, false);
        assertFalse(f.test(null));
        assertFalse(f.isExclusive());
    }

    @Test
    public void testFakeConditionTestTrue() {
        FakeCondition f = new FakeCondition(true, false);
        assertTrue(f.test(null));
        assertFalse(f.isExclusive());
    }

    @Test
    public void testFakeConditionExclusiveTrue() {
        FakeCondition f = new FakeCondition(false, true);
        assertFalse(f.test(null));
        assertTrue(f.isExclusive());
    }

}
