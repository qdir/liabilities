/* Application developed for AW subject, belonging to passive operations
 group.*/
package es.unileon.ulebank.command;

import es.unileon.ulebank.account.DetailedInformation;
import es.unileon.ulebank.exceptions.TransactionException;
import es.unileon.ulebank.handler.GenericHandler;
import es.unileon.ulebank.handler.Handler;
import es.unileon.ulebank.history.GenericTransaction;
import es.unileon.ulebank.history.Transaction;
import es.unileon.ulebank.history.conditions.WrongArgsException;
import es.unileon.ulebank.history.iterator.IteratorBetweenTwoDates;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 *
 * @author runix
 */
public class CommandFilterTransactionByDatesTest {

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
	public void setup() throws WrongArgsException, TransactionException {
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
		this.commandId = new GenericHandler("1234");
		this.commandFromIterator = new CommandFilterTransactionByDates(
				new Date(min), new Date(max), this.elements.iterator(),
				commandId);
		this.commandFromList = new CommandFilterTransactionByDates(
				new Date(min), new Date(max), this.elements, commandId);
		this.commandFromIterator.execute();
		this.commandFromList.execute();
		this.iteratorFromIterator = this.commandFromIterator.getList()
				.iterator();
		this.iteratorFromList = this.commandFromList.getList().iterator();

	}

	@Test
	public void testNoElements() throws WrongArgsException {
		this.elements.clear();
		this.commandFromList = new CommandFilterTransactionByDates(
				new Date(min), new Date(max), this.elements, commandId);
		this.commandFromIterator = new CommandFilterTransactionByDates(
				new Date(min), new Date(max), this.elements.iterator(),
				commandId);
		this.commandFromIterator.execute();
		this.commandFromList.execute();
		this.iteratorFromIterator = this.commandFromIterator.getList()
				.iterator();
		this.iteratorFromList = this.commandFromList.getList().iterator();
		assertFalse(this.iteratorFromIterator.hasNext());
		assertFalse(this.iteratorFromList.hasNext());
	}

	@Test
	public void testNoValidElements() throws WrongArgsException {
		this.elements.removeAll(this.correctElements);
		this.commandFromList = new CommandFilterTransactionByDates(
				new Date(min), new Date(max), this.elements, commandId);
		this.commandFromIterator = new CommandFilterTransactionByDates(
				new Date(min), new Date(max), this.elements.iterator(),
				commandId);
		this.commandFromIterator.execute();
		this.commandFromList.execute();
		this.iteratorFromIterator = this.commandFromIterator.getList()
				.iterator();
		this.iteratorFromList = this.commandFromList.getList().iterator();
		assertFalse(this.iteratorFromIterator.hasNext());
		assertFalse(this.iteratorFromList.hasNext());
	}

	@Test(expected = WrongArgsException.class)
	public void testWrongArgumentsFromList() throws WrongArgsException {
		new CommandFilterTransactionByDates(new Date(100), new Date(0),
				this.elements, commandId);
	}

	@Test(expected = WrongArgsException.class)
	public void testWrongArgumentsFromIterator() throws WrongArgsException {
		new CommandFilterTransactionByDates(new Date(100), new Date(0),
				this.elements.iterator(), commandId);
	}

	@Test
	public void testWithElements() {
		Iterator<Transaction> it = this.correctElements.iterator();
		while (this.iteratorFromIterator.hasNext()
				&& this.iteratorFromList.hasNext() && it.hasNext()) {
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
	}

	public Transaction getTransaction(long timestamp)
			throws TransactionException {
		Transaction t = new GenericTransaction(0, new Date(), "subject",
				new DetailedInformation());
		t.setEffectiveDate(new Date(timestamp));
		return t;
	}

}
