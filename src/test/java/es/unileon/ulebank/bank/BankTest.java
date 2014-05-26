/* Application developed for AW subject, belonging to passive operations
 group.*/
package es.unileon.ulebank.bank;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import es.unileon.ulebank.account.Account;
import es.unileon.ulebank.client.Client;
import es.unileon.ulebank.client.Person;
import es.unileon.ulebank.exceptions.TransactionException;
import es.unileon.ulebank.handler.GenericHandler;
import es.unileon.ulebank.handler.Handler;
import es.unileon.ulebank.handler.MalformedHandlerException;
import es.unileon.ulebank.history.GenericTransaction;
import es.unileon.ulebank.history.Transaction;
import es.unileon.ulebank.history.conditions.WrongArgsException;
import es.unileon.ulebank.office.Office;

/**
 *
 * @author Revellado
 */
public class BankTest {

	private Bank bank;
	private Office office;
	private Office office2;
	private Account account;
	private Account account1;

	@Before
	public void setUp() throws MalformedHandlerException, WrongArgsException {
		this.bank = new Bank(new GenericHandler("1234"));
		this.office = new Office(new GenericHandler("1234"), this.bank);
		this.office2 = new Office(new GenericHandler("1235"), this.bank);
		this.bank.addOffice(office);
		this.bank.addOffice(office2);
	}

	/**
	 * Test of getID method, of class Bank.
	 */
	@Test
	public void testGetID() {

		Handler expResult = new GenericHandler("1234");
		assertNotNull(bank.getID());
		assertEquals(bank.getID().compareTo(expResult), 0);
	}

	/**
	 * Test of addOffice method, of class Bank.
	 */
	@Test
	public void testAddOffice() {

		assertTrue(this.bank.addOffice(new Office(new GenericHandler("2234"),
				this.bank)));
	}

	/**
	 * Test of addOffice method, of class Bank.
	 */
	@Test
	public void testAddOfficeNullOffice() {

		assertFalse(this.bank.addOffice(null));
	}

	/**
	 * Test of addOffice method, of class Bank.
	 */
	@Test
	public void testAddOfficeSameOffice() {

		this.bank.addOffice(office);

		assertFalse(this.bank.addOffice(office));
	}

	/**
	 * Test of removeOffice method, of class Bank.
	 */
	@Test
	public void testRemoveOffice() {

		this.bank.addOffice(office);
		assertTrue(this.bank.removeOffice(office.getIdOffice()));
	}

	/**
	 * Test of removeOffice method, of class Bank.
	 */
	@Test
	public void testRemoveOfficeNullOffice() {

		assertFalse(this.bank.removeOffice(null));
	}

	/**
	 * Test of removeOffice method, of class Bank.
	 */
	@Test
	public void testRemoveOfficeNotBelongsTheBank() {

		assertFalse(this.bank.removeOffice(new GenericHandler("6666")));
	}

	@Test
	public void testSearchOffice() {
		assertEquals(office2, this.bank.searchOffice(office2.getIdOffice()));
		assertEquals(office, this.bank.searchOffice(office.getIdOffice()));
		assertEquals(null, this.bank.searchOffice(new GenericHandler("9292")));
	}

}
