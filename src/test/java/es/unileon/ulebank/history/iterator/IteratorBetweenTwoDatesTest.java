

/* Application developed for AW subject, belonging to passive operations
 group.*/
package es.unileon.ulebank.history.iterator;

import es.unileon.ulebank.account.DetailedInformation;
import es.unileon.ulebank.command.CommandFilterTransactionByDates;
import es.unileon.ulebank.handler.Handler;
import es.unileon.ulebank.history.GenericTransaction;
import es.unileon.ulebank.history.Transaction;

import es.unileon.ulebank.history.conditions.WrongArgsException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author runix
 */
public class IteratorBetweenTwoDatesTest {

    private Iterator<Transaction> iteratorFromList;
    private Iterator<Transaction> iteratorFromIterator;
    private List<Transaction> elements;
    private List<Transaction> correctElements;
    private long min;
    private long max;
    private Handler commandId;
    private CommandFilterTransactionByDates commandFromList;
    private CommandFilterTransactionByDates commandFromIterator;

    @Before
    public void setup() throws WrongArgsException {
        this.min = 100;
        this.max = 2000;
        this.elements = new ArrayList<Transaction>();
        this.correctElements = new ArrayList<Transaction>();
        for (int i = 1; i < 10; i++) {
            this.elements.add(getTransaction(this.max + 10 * i));
            this.elements.add(getTransaction(i));
        }
        long actual = this.min;
        while (actual < this.max) {
            Transaction t = getTransaction(actual);
            this.correctElements.add(t);
            this.elements.add(t);
            actual += 100;
        }
        
        this.iteratorFromIterator = new IteratorBetweenTwoDates<Transaction>(this.elements.iterator(), this.min, this.max);
        this.iteratorFromList = new IteratorBetweenTwoDates<Transaction>(this.elements, this.min, this.max);
    }

    @Test
    public void testNoElements() throws WrongArgsException {
        this.elements.clear();
        this.iteratorFromIterator = new IteratorBetweenTwoDates<Transaction>(this.elements.iterator(), this.min, this.max);
        this.iteratorFromList = new IteratorBetweenTwoDates<Transaction>(this.elements, this.min, this.max);
        assertFalse(this.iteratorFromIterator.hasNext());
        assertFalse(this.iteratorFromList.hasNext());
        assertEquals(this.iteratorFromIterator.next(), null);
        assertEquals(this.iteratorFromList.next(), null);
    }

    @Test
    public void testNoValidElements() throws WrongArgsException {
        this.elements.removeAll(this.correctElements);
        this.iteratorFromIterator = new IteratorBetweenTwoDates<Transaction>(this.elements.iterator(), this.min, this.max);
        this.iteratorFromList = new IteratorBetweenTwoDates<Transaction>(this.elements, this.min, this.max);
        assertFalse(this.iteratorFromIterator.hasNext());
        assertFalse(this.iteratorFromList.hasNext());
        assertEquals(this.iteratorFromIterator.next(), null);
        assertEquals(this.iteratorFromList.next(), null);
    }

    @Test(expected = WrongArgsException.class)
    public void testWrongArgumentsFromList() throws WrongArgsException {
        new IteratorBetweenTwoDates<Transaction>(this.elements, 100, 0);
    }

    @Test(expected = WrongArgsException.class)
    public void testWrongArgumentsFromIterator() throws WrongArgsException {
        new IteratorBetweenTwoDates<Transaction>(this.elements.iterator(), 100, 0);
    }

    @Test
    public void testWithElements() {
        Iterator<Transaction> it = this.correctElements.iterator();
        while (this.iteratorFromIterator.hasNext() && this.iteratorFromList.hasNext() && it.hasNext()) {
            Transaction nextFromIterator, nextFromList, correct;
            nextFromIterator = this.iteratorFromIterator.next();
            nextFromList = this.iteratorFromList.next();
            correct = it.next();
            assertEquals(nextFromIterator, correct);
            assertEquals(nextFromList, correct);
        }
        assertFalse(it.hasNext());
        assertFalse(this.iteratorFromIterator.hasNext());
        assertFalse(this.iteratorFromList.hasNext());
        assertEquals(this.iteratorFromIterator.next(), null);
        assertEquals(this.iteratorFromList.next(), null);
    }

    public Transaction getTransaction(long timestamp) {
        Transaction t = new GenericTransaction(0, new Date(), "", new DetailedInformation());
        t.setEffectiveDate(new Date(timestamp));
        return t;
    }
}
