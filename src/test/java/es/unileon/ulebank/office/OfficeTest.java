/* Application developed for AW subject, belonging to passive operations
 group.*/
package es.unileon.ulebank.office;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import es.unileon.ulebank.account.Account;
import es.unileon.ulebank.bank.Bank;
import es.unileon.ulebank.client.Client;
import es.unileon.ulebank.client.Person;
import es.unileon.ulebank.exceptions.TransactionException;
import es.unileon.ulebank.handler.GenericHandler;
import es.unileon.ulebank.handler.Handler;
import es.unileon.ulebank.handler.MalformedHandlerException;
import es.unileon.ulebank.history.GenericTransaction;
import es.unileon.ulebank.history.Transaction;
import es.unileon.ulebank.history.conditions.WrongArgsException;

/**
 *
 * @author Revellado
 */
public class OfficeTest {

	private Office office;
	private Bank bank;
	private Account account;
	private Client titular;

	@Before
	public void setUp() throws MalformedHandlerException, WrongArgsException {
		this.bank = new Bank(new GenericHandler("1234"));
		this.office = new Office(new GenericHandler("1234"), this.bank);
		this.titular = new Person(71525252, 'J');
		this.account = new Account(office, bank, "1234567890", titular);
	}

	/**
	 * Test of addAccount method, of class Office.
	 */
	@Test
	public void testAddAccount() {
		int numberOfAccounts = this.office.getAccounts().size();
		assertTrue(this.office.addAccount(account));
		assertEquals(this.office.getAccounts().size(), numberOfAccounts + 1);
		assertFalse(this.office.addAccount(account));
		assertEquals(this.office.getAccounts().size(), numberOfAccounts + 1);
	}

	@Test
	public void testAddClient() {
		int numberOfAccounts = this.office.getAccounts().size();
		assertTrue(this.office.addClient(titular));
		assertFalse(this.office.addClient(titular));
		assertEquals(this.office.getClients().size(), numberOfAccounts + 1);
	}

	@Test
	public void testDeleteClient() throws MalformedHandlerException {
		int numberOfAccounts = this.office.getAccounts().size();
		Client c = new Person(89051755, 'X');
		assertFalse(this.office.deleteClient(new GenericHandler("..")));
		assertTrue(this.office.addClient(titular));
		assertTrue(this.office.addClient(c));
		assertEquals(this.office.getClients().size(), numberOfAccounts + 2);
		assertTrue(this.office.deleteClient(c.getId()));
		assertFalse(this.office.deleteClient(new GenericHandler("..")));
	}

	/**
	 * Test of addAccount method, of class Office.
	 */
	@Test
	public void testAddAccountNullAccount() {
		assertFalse(this.office.addAccount(null));
	}

	/**
	 * Test of getID method, of class Office.
	 */
	@Test
	public void testGetID() {
		Handler expResult = new GenericHandler("1234");
		assertEquals(this.office.getIdOffice().compareTo(expResult), 0);
	}

	@Test
	public void testDeleteAccount() throws MalformedHandlerException,
			WrongArgsException {
		Account newAccount = new Account(office, bank,
				this.office.getNewAccountNumber(), titular);
		assertFalse(this.office.deleteAccount(new GenericHandler("!123123123")));
		assertTrue(this.office.addAccount(newAccount));
		assertTrue(this.office.deleteAccount(newAccount.getID()));
		assertTrue(this.office.searchAccount(newAccount.getID()) == null);
		assertFalse(this.office.deleteAccount(new GenericHandler("!123123123")));
	}

	@Test
	public void testSearchAccount() throws MalformedHandlerException,
			WrongArgsException {
		this.office.addAccount(account);
		Account newAccount = new Account(office, bank,
				this.office.getNewAccountNumber(), titular);
		this.office.addAccount(newAccount);
		assertEquals(newAccount, this.office.searchAccount(newAccount.getID()));
		assertEquals(null,
				this.office.searchAccount(new GenericHandler("123123123")));
	}

	@Test
	public void testSearchClinet() throws MalformedHandlerException,
			WrongArgsException {
		this.office.addClient(titular);
		Client c = new Person(89051755, 'X');
		this.office.addClient(c);
		assertEquals(c, this.office.searchClient(c.getId()));
		assertEquals(null,
				this.office.searchClient(new GenericHandler("123123123")));
	}

	@Test
	public void testGetNextAccountNumber() {
		// for (long i = 0; i < 1000000000L - 1; i++) {
		// assertEquals(String.format("%010d", i),
		// this.office.getNewAccountNumber());
		// }
		// assertEquals(this.office.getNewAccountNumber(), "");
	}
}
