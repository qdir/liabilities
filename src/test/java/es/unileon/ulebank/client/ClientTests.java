package es.unileon.ulebank.client;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import es.unileon.ulebank.account.Account;
import es.unileon.ulebank.bank.Bank;
import es.unileon.ulebank.handler.GenericHandler;
import es.unileon.ulebank.office.Office;

public class ClientTests {

	private Client client;
	private Account account;
	private Office office;
	private Bank bank;
	
	@Before
	public void setUp() throws Exception {
		
		client = new Client(new GenericHandler("1234"));
		bank = new Bank(new GenericHandler("1234"));
		office = new Office(new GenericHandler("1234"), bank);
		
		account = new Account(office, bank, "0000000000", client);
	}

	@Test
	public void testAdd() {
		
		client.add(account);
		assertTrue(client.existsAccount(account.getID()));
	}
	
	@Test
	public void testAddSameAccount() {
		
		client.add(account);
		assertTrue(client.existsAccount(account.getID()));
	}

	@Test
	public void testRemoveAccount() {
		
		client.add(account);
		assertTrue(client.existsAccount(account.getID()));
		client.removeAccount(account.getID());
		assertFalse(client.existsAccount(account.getID()));
	}

	@Test
	public void testExistsAccount() {
		
		client.add(account);
		assertTrue(client.existsAccount(account.getID()));
	}

	@Test
	public void testGetId() {
		
		assertEquals(0, client.getId().compareTo(new GenericHandler("1234")), 0);
	}

}
