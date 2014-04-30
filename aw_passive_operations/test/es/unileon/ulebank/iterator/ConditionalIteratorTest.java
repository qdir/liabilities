/* Application developed for AW subject, belonging to passive operations
 group.*/
package es.unileon.ulebank.iterator;

import es.unileon.ulebank.history.GenericTransaction;
import es.unileon.ulebank.history.Transaction;
import es.unileon.ulebank.history.TransactionType;
import es.unileon.ulebank.history.conditions.ConditionTransactionBetweenTwoDates;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author runix
 */
public class ConditionalIteratorTest {

    private Iterator<Integer> iterator;
    private List<Condition<Integer>> conditions;
    private List<Integer> elemsList;

    @Before
    public void setup() {
        this.elemsList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            this.elemsList.add(i + 1);
        }
        this.conditions = new ArrayList<>();
        this.iterator = new ConditionalIterator<>(conditions, elemsList);
    }

    @Test
    public void testWithoutConditions() {
        int i = 0;
        while (this.iterator.hasNext() && i < this.elemsList.size()) {
            assertTrue(this.iterator.next() == (i + 1));
            i++;
        }
        assertFalse(this.iterator.hasNext());
        assertEquals(this.iterator.next(), null);
        assertEquals(i, this.elemsList.size());
    }

    @Test
    public void testConditionNoElems() {
        this.conditions.add(new FakeCondition<Integer>(false, false));
        this.iterator = new ConditionalIterator<>(conditions, elemsList);
        assertFalse(this.iterator.hasNext());
        assertEquals(this.iterator.next(), null);

        this.conditions.add(new FakeCondition<Integer>(false, true));
        this.iterator = new ConditionalIterator<>(conditions, elemsList);
        assertFalse(this.iterator.hasNext());
        assertEquals(this.iterator.next(), null);
    }

    @Test
    public void testOneExclusiveTestFalse() {
        this.conditions.add(new FakeCondition<Integer>(true, false));
        this.conditions.add(new FakeCondition<Integer>(false, false));
        this.iterator = new ConditionalIterator<>(conditions, elemsList);
        int i = 0;
        while (this.iterator.hasNext() && i < this.elemsList.size()) {
            assertTrue(this.iterator.next() == (i + 1));
            i++;
        }
        assertFalse(this.iterator.hasNext());
        assertEquals(this.iterator.next(), null);
        assertEquals(i, this.elemsList.size());
    }

    @Test
    public void testOneExclusiveTestTrue() {
        this.conditions.add(new FakeCondition<Integer>(true, false));
        this.conditions.add(new FakeCondition<Integer>(false, true));
        this.iterator = new ConditionalIterator<>(conditions, elemsList);
        assertFalse(this.iterator.hasNext());
        assertEquals(this.iterator.next(), null);
    }

    @Test
    public void testAllExclusiveTestTrue() {
        this.conditions.add(new FakeCondition<Integer>(true, true));
        this.conditions.add(new FakeCondition<Integer>(true, true));
        this.iterator = new ConditionalIterator<>(conditions, elemsList);
        int i = 0;
        while (this.iterator.hasNext() && i < this.elemsList.size()) {
            assertTrue(this.iterator.next() == (i + 1));
            i++;
        }
        assertFalse(this.iterator.hasNext());
        assertEquals(this.iterator.next(), null);
        assertEquals(i, this.elemsList.size());
    }

    @Test
    public void testAllExclusiveTestFalse() {
        this.conditions.add(new FakeCondition<Integer>(false, true));
        this.conditions.add(new FakeCondition<Integer>(false, true));
        this.iterator = new ConditionalIterator<>(conditions, elemsList);
        assertFalse(this.iterator.hasNext());
        assertEquals(this.iterator.next(), null);
    }

    @Test
    public void testWithRealConditions() {
        Iterator<Transaction> it;
        List<Condition<Transaction>> conditions = new ArrayList<>();
        Date low = new Date(1);
        Date high = new Date(5);
        conditions.add(new ConditionTransactionBetweenTwoDates<Transaction>(low, high, true));
        List<Transaction> elements = new ArrayList<>();
        elements.add(getTransaction(new Date(0)));
        elements.add(getTransaction(new Date(4)));
        elements.add(getTransaction(new Date(6)));
        it = new ConditionalIterator<>(conditions, elements);
        assertTrue(it.hasNext());
        assertEquals(elements.get(1), it.next());
        assertFalse(it.hasNext());
        assertEquals(it.next(), null);
    }

    public final Transaction getTransaction(Date date) {
        Transaction t = new GenericTransaction(0, date, "", TransactionType.CHARGE);
        t.setEffectiveDate(date);
        return t;
    }
}
