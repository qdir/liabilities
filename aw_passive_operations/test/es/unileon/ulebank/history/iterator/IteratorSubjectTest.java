/* Application developed for AW subject, belonging to passive operations
 group.*/
package es.unileon.ulebank.history.iterator;

import es.unileon.ulebank.account.DetailedInformation;
import es.unileon.ulebank.history.GenericTransaction;
import es.unileon.ulebank.history.Transaction;
import es.unileon.ulebank.history.TransactionHandlerProvider;
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
public class IteratorSubjectTest {

    private Iterator<Transaction> iteratorFromList;
    private Iterator<Transaction> iteratorFromIterator;
    private Iterator<Transaction> iteratorFromListNegate;
    private Iterator<Transaction> iteratorFromIteratorNegate;
    private List<Transaction> elements;
    private List<Transaction> correctElements;
    private List<Transaction> invalidElements;
    private String word;

    @Before
    public void setup() {
        this.elements = new ArrayList<>();
        this.correctElements = new ArrayList<>();
        this.invalidElements = new ArrayList<>();
        this.word = "this is a test";
        for (int i = 0; i < 10; i++) {
            this.invalidElements.add(this.getTransaction("handler->" + TransactionHandlerProvider.getTransactionHandler().toString()));
        }

        for (int i = 10; i < 10; i++) {
            this.correctElements.add(this.getTransaction(TransactionHandlerProvider.getTransactionHandler().toString() + this.word + "ajsdas"));
        }
        this.elements.addAll(this.invalidElements);
        this.elements.addAll(this.correctElements);
        this.iteratorFromList = new IteratorSubject<>(this.elements, word, true);
        this.iteratorFromListNegate = new IteratorSubject<>(this.elements, word, false);

        this.iteratorFromIterator = new IteratorSubject<>(this.elements.iterator(), word, true);
        this.iteratorFromIteratorNegate = new IteratorSubject<>(this.elements.iterator(), word, false);
    }

    @Test
    public void testWithElements() {
        Iterator<Transaction> it = this.correctElements.iterator();
        int count = 0;
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

    @Test
    public void testNoValidElements() {
        this.elements.removeAll(this.correctElements);
        this.iteratorFromIterator = new IteratorSubject<>(this.elements.iterator(), word, true);
        this.iteratorFromList = new IteratorSubject<>(this.elements, word, true);
        assertFalse(this.iteratorFromIterator.hasNext());
        assertFalse(this.iteratorFromList.hasNext());
        assertEquals(this.iteratorFromIterator.next(), null);
        assertEquals(this.iteratorFromList.next(), null);

        this.elements.clear();
        this.elements.addAll(this.correctElements);
        this.iteratorFromIteratorNegate = new IteratorSubject<>(this.elements.iterator(), word, false);
        this.iteratorFromListNegate = new IteratorSubject<>(this.elements, word, false);
        assertFalse(this.iteratorFromIteratorNegate.hasNext());
        assertFalse(this.iteratorFromListNegate.hasNext());
        assertEquals(this.iteratorFromIteratorNegate.next(), null);
        assertEquals(this.iteratorFromListNegate.next(), null);
    }

    @Test
    public void testNoElements() {
        this.elements.clear();
        this.iteratorFromIteratorNegate = new IteratorSubject<>(this.elements.iterator(), word, false);
        this.iteratorFromListNegate = new IteratorSubject<>(this.elements, word, false);
        this.iteratorFromIterator = new IteratorSubject<>(this.elements.iterator(), word, true);
        this.iteratorFromList = new IteratorSubject<>(this.elements, word, true);
        assertFalse(this.iteratorFromIterator.hasNext());
        assertFalse(this.iteratorFromList.hasNext());
        assertEquals(this.iteratorFromIterator.next(), null);
        assertEquals(this.iteratorFromList.next(), null);
        assertFalse(this.iteratorFromIteratorNegate.hasNext());
        assertFalse(this.iteratorFromListNegate.hasNext());
        assertEquals(this.iteratorFromIteratorNegate.next(), null);
        assertEquals(this.iteratorFromListNegate.next(), null);
    }

    public Transaction getTransaction(String subject) {
        return new GenericTransaction(0, new Date(), subject, new DetailedInformation());
    }
}
