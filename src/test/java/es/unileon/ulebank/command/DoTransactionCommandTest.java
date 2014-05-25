package es.unileon.ulebank.command;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.Date;
import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

import es.unileon.ulebank.account.Account;
import es.unileon.ulebank.account.DetailedInformation;
import es.unileon.ulebank.bank.Bank;
import es.unileon.ulebank.client.Client;
import es.unileon.ulebank.client.Person;
import es.unileon.ulebank.handler.GenericHandler;
import es.unileon.ulebank.handler.Handler;
import es.unileon.ulebank.handler.MalformedHandlerException;
import es.unileon.ulebank.history.Transaction;
import es.unileon.ulebank.history.conditions.WrongArgsException;
import es.unileon.ulebank.office.Office;

public class DoTransactionCommandTest {

	private DoTransactionCommand command;
	private Bank bank;
	private double amount;
	private Office office;
	private Handler commandId;
	private Account account;
	private Client authorized;
	private String subject;
	private Date date;
	private DetailedInformation info;

	@Before
	public void setUp() throws MalformedHandlerException, WrongArgsException {
		this.bank = new Bank(new GenericHandler("1234"));
		this.office = new Office(new GenericHandler("1231"), bank);
		this.bank.addOffice(office);
		this.authorized = new Person(71524276, 'A');
		this.account = new Account(office, bank, office.getNewAccountNumber(),
				authorized);
		this.office.addAccount(account);
		this.date = new Date();
		this.subject = "subject";
		this.info = new DetailedInformation();
		command = new DoTransactionCommand(bank, amount, account.getID(), date,
				subject, info, commandId);
	}

	@Test
	public void testExecute() {
		command.execute();
		Transaction t = this.account.getHistory().getIterator().next();
		assertEquals(t.getAmount(), amount, Math.pow(10, -10));
		assertEquals(date, t.getDate());
		assertEquals(info, t.getDetailedInformation());
		assertEquals(subject, t.getSubject());
	}

	@Test
	public void testUndoFromExecute() {
		command.execute();
		command.undo();
		Transaction t = this.account.getHistory().getIterator().next();
		assertEquals(t.getAmount(), amount, Math.pow(10, -10));
		assertEquals(date, t.getDate());
		assertEquals(info, t.getDetailedInformation());
		assertEquals(subject, t.getSubject());
	}

	@Test
	public void testUndoFromRedo() {
		command.redo();
		command.undo();
		Iterator<Transaction> it = this.account.getHistory().getIterator();
		assertFalse(it.hasNext());
	}

	@Test
	public void testRedo() {
		command.execute();
		command.undo();
		command.redo();
		Transaction t = this.account.getHistory().getIterator().next();
		assertEquals(t.getAmount(), amount, Math.pow(10, -10));
		assertEquals(date, t.getDate());
		assertEquals(info, t.getDetailedInformation());
		assertEquals(subject, t.getSubject());
	}
}
