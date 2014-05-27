package es.unileon.ulebank.iterator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import es.unileon.ulebank.exceptions.TransactionException;
import es.unileon.ulebank.history.GenericTransaction;
import es.unileon.ulebank.history.Transaction;
import es.unileon.ulebank.history.TransactionHandlerProvider;
import es.unileon.ulebank.history.conditions.ConditionSubject;
import es.unileon.ulebank.history.conditions.ConditionTransactionBetweenTwoDates;
import es.unileon.ulebank.history.conditions.WrongArgsException;

public class ConditionalIteratorTest {

	private List<Transaction> valid;
	private List<Transaction> inValid;
	private ConditionalIterator<Transaction> it;
	private ConditionalIterator<Transaction> itNoConditions;
	private String wordValid;
	private Date min;
	private Date max;

	@Before
	public void setUp() throws TransactionException, WrongArgsException {
		valid = new ArrayList<Transaction>();
		inValid = new ArrayList<Transaction>();
		min = new Date(System.currentTimeMillis());
		max = new Date(System.currentTimeMillis() + 100000);
		wordValid = "test";
		for (int i = 0; i < 10; i++) {
			valid.add(getTransaction(
					wordValid
							+ TransactionHandlerProvider
									.getTransactionHandler(),
					new Date(min.getTime() + i)));
		}

		for (int i = 0; i < 10; i++) {
			inValid.add(getTransaction(
					"adasd"
							+ TransactionHandlerProvider
									.getTransactionHandler(),
					new Date(max.getTime() + i)));
		}
		List<Condition<Transaction>> conditions = new ArrayList<Condition<Transaction>>();
		conditions.add(new ConditionTransactionBetweenTwoDates<Transaction>(
				min, max));
		conditions.add(new ConditionSubject<Transaction>(true, wordValid));
		List<Transaction> all = new ArrayList<Transaction>();
		all.addAll(valid);
		all.addAll(inValid);
		this.it = new ConditionalIterator<Transaction>(conditions,
				all.iterator());
		this.itNoConditions = new ConditionalIterator<Transaction>(valid);
	}

	@Test
	public void testEquals() {
		while (it.hasNext() && itNoConditions.hasNext()) {
			assertTrue(valid.contains(it.next()));
			assertTrue(valid.contains(itNoConditions.next()));
		}

		assertFalse(it.hasNext());
		assertFalse(itNoConditions.hasNext());
	}

	@Test(expected = UnsupportedOperationException.class)
	public void testRemove() {
		this.it.remove();
	}

	private Transaction getTransaction(String subject, Date date)
			throws TransactionException {
		Transaction t = new GenericTransaction(10, date, subject);
		t.setEffectiveDate(date);
		return t;
	}

}
