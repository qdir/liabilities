/* Application developed for AW subject, belonging to passive operations
 group.*/
package es.unileon.ulebank.command;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import es.unileon.ulebank.account.DetailedInformation;
import es.unileon.ulebank.exceptions.TransactionException;
import es.unileon.ulebank.handler.GenericHandler;
import es.unileon.ulebank.handler.Handler;
import es.unileon.ulebank.history.GenericTransaction;
import es.unileon.ulebank.history.Transaction;
import es.unileon.ulebank.history.TransactionHandlerProvider;

/**
 *
 * @author runix
 */
public class CommandFilterTransactionBySubjectTest {

	private Iterator<Transaction> iteratorFromList;
	private Iterator<Transaction> iteratorFromIterator;
	private Iterator<Transaction> iteratorFromListNegate;
	private Iterator<Transaction> iteratorFromIteratorNegate;
	private List<Transaction> elements;
	private List<Transaction> correctElements;
	private List<Transaction> invalidElements;
	private String word;
	private Handler commandId;
	private CommandFilterTransactionBySubject commandFromList;
	private CommandFilterTransactionBySubject commandFromIterator;
	private CommandFilterTransactionBySubject commandFromListNegate;
	private CommandFilterTransactionBySubject commandFromIteratorNegate;

	@Before
	public void setup() throws TransactionException {
		this.elements = new ArrayList<Transaction>();
		this.correctElements = new ArrayList<Transaction>();
		this.invalidElements = new ArrayList<Transaction>();
		this.commandId = new GenericHandler("test");
		this.word = "this is a test";
		for (int i = 0; i < 10; i++) {
			this.invalidElements.add(this.getTransaction("handler->"
					+ TransactionHandlerProvider.getTransactionHandler()
							.toString()));
		}

		for (int i = 10; i < 10; i++) {
			this.correctElements.add(this
					.getTransaction(TransactionHandlerProvider
							.getTransactionHandler().toString()
							+ this.word
							+ "ajsdas"));
		}
		this.elements.addAll(this.invalidElements);
		this.elements.addAll(this.correctElements);

		this.commandFromIterator = new CommandFilterTransactionBySubject(
				this.elements.iterator(), this.commandId, this.word, true);
		this.commandFromList = new CommandFilterTransactionBySubject(
				this.elements, commandId, word, true);

		this.commandFromIteratorNegate = new CommandFilterTransactionBySubject(
				this.elements.iterator(), commandId, word, false);
		this.commandFromListNegate = new CommandFilterTransactionBySubject(
				this.elements, commandId, word, false);

		this.commandFromIterator.execute();
		this.commandFromList.execute();
		this.commandFromIteratorNegate.execute();
		this.commandFromListNegate.execute();

		this.iteratorFromList = this.commandFromList.getList().iterator();
		this.iteratorFromListNegate = this.commandFromListNegate.getList()
				.iterator();

		this.iteratorFromIterator = this.commandFromIterator.getList()
				.iterator();
		this.iteratorFromIteratorNegate = this.commandFromIteratorNegate
				.getList().iterator();
	}

	@Test
	public void testWithElements() {
		Iterator<Transaction> it = this.correctElements.iterator();
		int count = 0;
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

	@Test
	public void testNoValidElements() {
		this.elements.removeAll(this.correctElements);
		this.commandFromIterator = new CommandFilterTransactionBySubject(
				this.elements.iterator(), commandId, word, true);
		this.commandFromIterator.execute();
		this.iteratorFromIterator = this.commandFromIterator.getList()
				.iterator();

		this.commandFromList = new CommandFilterTransactionBySubject(
				this.elements, commandId, word, true);
		this.commandFromList.execute();
		;
		this.iteratorFromList = this.commandFromList.getList().iterator();
		assertFalse(this.iteratorFromIterator.hasNext());
		assertFalse(this.iteratorFromList.hasNext());

		this.elements.clear();
		this.elements.addAll(this.correctElements);
		this.commandFromIteratorNegate = new CommandFilterTransactionBySubject(
				this.elements.iterator(), commandId, word, false);
		this.commandFromIteratorNegate.execute();
		this.iteratorFromIteratorNegate = this.commandFromIteratorNegate
				.getList().iterator();

		this.commandFromListNegate = new CommandFilterTransactionBySubject(
				this.elements, commandId, word, false);
		this.commandFromListNegate.execute();
		;
		this.iteratorFromListNegate = this.commandFromListNegate.getList()
				.iterator();

		assertFalse(this.iteratorFromIteratorNegate.hasNext());
		assertFalse(this.iteratorFromListNegate.hasNext());
	}

	@Test
	public void testNoElements() {
		this.elements.clear();
		this.commandFromIterator = new CommandFilterTransactionBySubject(
				this.elements.iterator(), commandId, word, true);
		this.commandFromList = new CommandFilterTransactionBySubject(
				this.elements, commandId, word, true);

		this.commandFromIteratorNegate = new CommandFilterTransactionBySubject(
				this.elements.iterator(), commandId, word, false);
		this.commandFromListNegate = new CommandFilterTransactionBySubject(
				this.elements, commandId, word, false);

		this.commandFromIterator.execute();
		this.commandFromList.execute();
		this.commandFromIteratorNegate.execute();
		this.commandFromListNegate.execute();

		this.iteratorFromList = this.commandFromList.getList().iterator();
		this.iteratorFromListNegate = this.commandFromListNegate.getList()
				.iterator();

		this.iteratorFromIterator = this.commandFromIterator.getList()
				.iterator();
		this.iteratorFromIteratorNegate = this.commandFromIteratorNegate
				.getList().iterator();
		assertFalse(this.iteratorFromIterator.hasNext());
		assertFalse(this.iteratorFromList.hasNext());
		assertFalse(this.iteratorFromIteratorNegate.hasNext());
		assertFalse(this.iteratorFromListNegate.hasNext());
	}

	public Transaction getTransaction(String subject)
			throws TransactionException {
		return new GenericTransaction(0, new Date(), subject,
				new DetailedInformation());
	}

	/**
	 * Test of getID method, of class CommandFilterTransactionBySubject.
	 */
	@Test
	public void testGetID() {
		assertEquals(this.commandFromIterator.getID().compareTo(commandId), 0);
		assertEquals(this.commandFromList.getID().compareTo(commandId), 0);
	}

	/**
	 * Test of undo method, of class CommandFilterTransactionBySubject.
	 */
	@Test
	public void testUndo() {
		// Nothing to do
	}

	/**
	 * Test of redo method, of class CommandFilterTransactionBySubject.
	 */
	@Test
	public void testRedo() {
		// Nothing to do
	}

}
