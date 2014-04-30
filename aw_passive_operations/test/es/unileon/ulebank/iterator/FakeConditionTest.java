/* Application developed for AW subject, belonging to passive operations
 group.*/
package es.unileon.ulebank.iterator;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

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
