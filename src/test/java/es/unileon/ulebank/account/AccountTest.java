/* Application developed for AW subject, belonging to passive operations
 group.*/
package es.unileon.ulebank.account;

import es.unileon.ulebank.exceptions.TransactionException;
import es.unileon.ulebank.bank.Bank;
import es.unileon.ulebank.client.Client;
import es.unileon.ulebank.client.Person;
import es.unileon.ulebank.client.PersonHandler;
import es.unileon.ulebank.handler.GenericHandler;
import es.unileon.ulebank.handler.Handler;
import es.unileon.ulebank.handler.MalformedHandlerException;
import es.unileon.ulebank.history.DirectDebitTransaction;
import es.unileon.ulebank.history.GenericTransaction;
import es.unileon.ulebank.office.Office;
import es.unileon.ulebank.history.History;
import es.unileon.ulebank.history.Transaction;
import es.unileon.ulebank.history.conditions.WrongArgsException;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class AccountTest {

	private static final double EPSILON = 0.00001;

	private Account commercialAccount;
	private Office office;
	private Bank bank;
	private Client titular1;
	private Client titular2;
	private Client authorized1;
	private Client authorized2;

	private static int NIF1 = 98765432;
	private static int NIF2 = 87654321;
	private static int NIF3 = 76543210;
	private static int NIF4 = 12345678;

	private static char NIF_LETTER1 = 'M';
	private static char NIF_LETTER2 = 'X';
	private static char NIF_LETTER3 = 'S';
	private static char NIF_LETTER4 = 'Z';

	private String accountNumber = "0000000000";

	@Before
	public void setUp() throws MalformedHandlerException, WrongArgsException {
		this.bank = new Bank(new GenericHandler("1234"));
		this.office = new Office(new GenericHandler("1234"), this.bank);
		this.titular1 = new Person(NIF1, NIF_LETTER1);
		this.commercialAccount = new Account(this.office, this.bank,
				accountNumber, titular1);
		this.titular2 = new Person(NIF2, NIF_LETTER2);
		this.authorized1 = new Person(NIF3, NIF_LETTER3);
		this.authorized2 = new Person(NIF4, NIF_LETTER4);
		assertTrue(this.commercialAccount.addTitular(this.titular2));
		assertTrue(this.commercialAccount.addAuthorized(this.authorized1));
		assertTrue(this.commercialAccount.addAuthorized(this.authorized2));

	}

	@Test(expected = MalformedHandlerException.class)
	public void testMoreAccountnumberLengthNullClient()
			throws MalformedHandlerException, WrongArgsException {
		this.commercialAccount = new Account(this.office, this.bank,
				"000000000000", null);
	}

	@Test(expected = MalformedHandlerException.class)
	public void testLessAccountnumberLengthNullClient()
			throws MalformedHandlerException, WrongArgsException {
		this.commercialAccount = new Account(this.office, this.bank, "000000",
				null);
	}

	@Test(expected = MalformedHandlerException.class)
	public void testCorrectAccountnumberLengthInterspersedLettersNullClient()
			throws MalformedHandlerException, WrongArgsException {
		this.commercialAccount = new Account(this.office, this.bank,
				"00aa00aa00", null);
	}

	@Test(expected = MalformedHandlerException.class)
	public void testCorrectLengthWithLetterIn1CharacterNullClient()
			throws MalformedHandlerException, WrongArgsException {
		new Account(this.office, this.bank, "a000000000", null);
	}

	@Test(expected = MalformedHandlerException.class)
	public void testCorrectLengthWithLetterIn2CharacterNullClient()
			throws MalformedHandlerException, WrongArgsException {
		new Account(this.office, this.bank, "0a00000000", null);
	}

	@Test(expected = MalformedHandlerException.class)
	public void testCorrectLengthWithLetterIn3CharacterNullClient()
			throws MalformedHandlerException, WrongArgsException {
		new Account(this.office, this.bank, "00a0000000", null);
	}

	@Test(expected = MalformedHandlerException.class)
	public void testCorrectLengthWithLetterIn4CharacterNullClient()
			throws MalformedHandlerException, WrongArgsException {
		new Account(this.office, this.bank, "000a000000", null);
	}

	@Test(expected = MalformedHandlerException.class)
	public void testCorrectLengthWithLetterIn5CharacterNullClient()
			throws MalformedHandlerException, WrongArgsException {
		new Account(this.office, this.bank, "0000a00000", null);
	}

	@Test(expected = MalformedHandlerException.class)
	public void testCorrectLengthWithLetterIn6CharacterNullClient()
			throws MalformedHandlerException, WrongArgsException {
		new Account(this.office, this.bank, "00000a0000", null);
	}

	@Test(expected = MalformedHandlerException.class)
	public void testCorrectLengthWithLetterIn7CharacterNullClient()
			throws MalformedHandlerException, WrongArgsException {
		new Account(this.office, this.bank, "000000a000", null);
	}

	@Test(expected = MalformedHandlerException.class)
	public void testCorrectLengthWithLetterIn8CharacterNullClient()
			throws MalformedHandlerException, WrongArgsException {
		new Account(this.office, this.bank, "0000000a00", null);
	}

	@Test(expected = MalformedHandlerException.class)
	public void testCorrectLengthWithLetterIn9CharacterNullClient()
			throws MalformedHandlerException, WrongArgsException {
		new Account(this.office, this.bank, "00000000a0", null);
	}

	@Test(expected = MalformedHandlerException.class)
	public void testCorrectLengthWithLetterIn10CharacterNullClient()
			throws MalformedHandlerException, WrongArgsException {
		new Account(this.office, this.bank, "000000000a", null);
	}

	@Test(expected = MalformedHandlerException.class)
	public void testMoreLengthWithLetterIn1CharacterNullClient()
			throws MalformedHandlerException, WrongArgsException {
		new Account(this.office, this.bank, "a0000000000", null);
	}

	@Test(expected = MalformedHandlerException.class)
	public void testMoreLengthWithLetterIn2CharacterNullClient()
			throws MalformedHandlerException, WrongArgsException {
		new Account(this.office, this.bank, "0a000000000", null);
	}

	@Test(expected = MalformedHandlerException.class)
	public void testMoreLengthWithLetterIn3CharacterNullClient()
			throws MalformedHandlerException, WrongArgsException {
		new Account(this.office, this.bank, "00a00000000", null);
	}

	@Test(expected = MalformedHandlerException.class)
	public void testMoreLengthWithLetterIn4CharacterNullClient()
			throws MalformedHandlerException, WrongArgsException {
		new Account(this.office, this.bank, "000a0000000", null);
	}

	@Test(expected = MalformedHandlerException.class)
	public void testMoreLengthWithLetterIn5CharacterNullClient()
			throws MalformedHandlerException, WrongArgsException {
		new Account(this.office, this.bank, "0000a000000", null);
	}

	@Test(expected = MalformedHandlerException.class)
	public void testMoreLengthWithLetterIn6CharacterNullClient()
			throws MalformedHandlerException, WrongArgsException {
		new Account(this.office, this.bank, "00000a00000", null);
	}

	@Test(expected = MalformedHandlerException.class)
	public void testMoreLengthWithLetterIn7CharacterNullClient()
			throws MalformedHandlerException, WrongArgsException {
		new Account(this.office, this.bank, "000000a0000", null);
	}

	@Test(expected = MalformedHandlerException.class)
	public void testMoreLengthWithLetterIn8CharacterNullClient()
			throws MalformedHandlerException, WrongArgsException {
		new Account(this.office, this.bank, "0000000a000", null);
	}

	@Test(expected = MalformedHandlerException.class)
	public void testMoreLengthWithLetterIn9CharacterNullClient()
			throws MalformedHandlerException, WrongArgsException {
		new Account(this.office, this.bank, "00000000a00", null);
	}

	@Test(expected = MalformedHandlerException.class)
	public void testMoreLengthWithLetterIn10CharacterNullClient()
			throws MalformedHandlerException, WrongArgsException {
		new Account(this.office, this.bank, "000000000a0", null);
	}

	@Test(expected = MalformedHandlerException.class)
	public void testMoreLengthWithLetterIn11CharacterNullClient()
			throws MalformedHandlerException, WrongArgsException {
		new Account(this.office, this.bank, "0000000000a", null);
	}

	@Test(expected = MalformedHandlerException.class)
	public void testLessLengthWithLetterIn2CharacterNullClient()
			throws MalformedHandlerException, WrongArgsException {
		new Account(this.office, this.bank, "a00000000", null);
	}

	@Test(expected = MalformedHandlerException.class)
	public void testLessLengthWithLetterIn3CharacterNullClient()
			throws MalformedHandlerException, WrongArgsException {
		new Account(this.office, this.bank, "0a0000000", null);
	}

	@Test(expected = MalformedHandlerException.class)
	public void testLessLengthWithLetterIn4CharacterNullClient()
			throws MalformedHandlerException, WrongArgsException {
		new Account(this.office, this.bank, "00a000000", null);
	}

	@Test(expected = MalformedHandlerException.class)
	public void testLessLengthWithLetterIn5CharacterNullClient()
			throws MalformedHandlerException, WrongArgsException {
		new Account(this.office, this.bank, "000a00000", null);
	}

	@Test(expected = MalformedHandlerException.class)
	public void testLessLengthWithLetterIn6CharacterNullClient()
			throws MalformedHandlerException, WrongArgsException {
		new Account(this.office, this.bank, "0000a0000", null);
	}

	@Test(expected = MalformedHandlerException.class)
	public void testLessLengthWithLetterIn7CharacterNullClient()
			throws MalformedHandlerException, WrongArgsException {
		new Account(this.office, this.bank, "00000a000", null);
	}

	@Test(expected = MalformedHandlerException.class)
	public void testLessLengthWithLetterIn8CharacterNullClient()
			throws MalformedHandlerException, WrongArgsException {
		new Account(this.office, this.bank, "000000a00", null);
	}

	@Test(expected = MalformedHandlerException.class)
	public void testLessLengthWithLetterIn9CharacterNullClient()
			throws MalformedHandlerException, WrongArgsException {
		new Account(this.office, this.bank, "0000000a0", null);
	}

	@Test(expected = MalformedHandlerException.class)
	public void testLessLengthWithLetterIn10CharacterNullClient()
			throws MalformedHandlerException, WrongArgsException {
		new Account(this.office, this.bank, "00000000a", null);
	}

	@Test(expected = WrongArgsException.class)
	public void testNullClient() throws MalformedHandlerException,
			WrongArgsException {
		new Account(this.office, this.bank, this.accountNumber, null);
	}

	@Test(expected = MalformedHandlerException.class)
	public void testMoreAccountnumberLength() throws MalformedHandlerException,
			WrongArgsException {
		this.commercialAccount = new Account(this.office, this.bank,
				"000000000000", this.titular1);
	}

	@Test(expected = MalformedHandlerException.class)
	public void testLessAccountnumberLength() throws MalformedHandlerException,
			WrongArgsException {
		this.commercialAccount = new Account(this.office, this.bank, "000000",
				this.titular1);
	}

	@Test(expected = MalformedHandlerException.class)
	public void testCorrectAccountnumberLengthInterspersedLetters()
			throws MalformedHandlerException, WrongArgsException {
		this.commercialAccount = new Account(this.office, this.bank,
				"00aa00aa00", this.titular1);
	}

	@Test(expected = MalformedHandlerException.class)
	public void testCorrectLengthWithLetterIn1Character()
			throws MalformedHandlerException, WrongArgsException {
		new Account(this.office, this.bank, "a000000000", this.titular1);
	}

	@Test(expected = MalformedHandlerException.class)
	public void testCorrectLengthWithLetterIn2Character()
			throws MalformedHandlerException, WrongArgsException {
		new Account(this.office, this.bank, "0a00000000", this.titular1);
	}

	@Test(expected = MalformedHandlerException.class)
	public void testCorrectLengthWithLetterIn3Character()
			throws MalformedHandlerException, WrongArgsException {
		new Account(this.office, this.bank, "00a0000000", this.titular1);
	}

	@Test(expected = MalformedHandlerException.class)
	public void testCorrectLengthWithLetterIn4Character()
			throws MalformedHandlerException, WrongArgsException {
		new Account(this.office, this.bank, "000a000000", this.titular1);
	}

	@Test(expected = MalformedHandlerException.class)
	public void testCorrectLengthWithLetterIn5Character()
			throws MalformedHandlerException, WrongArgsException {
		new Account(this.office, this.bank, "0000a00000", this.titular1);
	}

	@Test(expected = MalformedHandlerException.class)
	public void testCorrectLengthWithLetterIn6Character()
			throws MalformedHandlerException, WrongArgsException {
		new Account(this.office, this.bank, "00000a0000", this.titular1);
	}

	@Test(expected = MalformedHandlerException.class)
	public void testCorrectLengthWithLetterIn7Character()
			throws MalformedHandlerException, WrongArgsException {
		new Account(this.office, this.bank, "000000a000", this.titular1);
	}

	@Test(expected = MalformedHandlerException.class)
	public void testCorrectLengthWithLetterIn8Character()
			throws MalformedHandlerException, WrongArgsException {
		new Account(this.office, this.bank, "0000000a00", this.titular1);
	}

	@Test(expected = MalformedHandlerException.class)
	public void testCorrectLengthWithLetterIn9Character()
			throws MalformedHandlerException, WrongArgsException {
		new Account(this.office, this.bank, "00000000a0", this.titular1);
	}

	@Test(expected = MalformedHandlerException.class)
	public void testCorrectLengthWithLetterIn10Character()
			throws MalformedHandlerException, WrongArgsException {
		new Account(this.office, this.bank, "000000000a", this.titular1);
	}

	@Test(expected = MalformedHandlerException.class)
	public void testMoreLengthWithLetterIn1Character()
			throws MalformedHandlerException, WrongArgsException {
		new Account(this.office, this.bank, "a0000000000", this.titular1);
	}

	@Test(expected = MalformedHandlerException.class)
	public void testMoreLengthWithLetterIn2Character()
			throws MalformedHandlerException, WrongArgsException {
		new Account(this.office, this.bank, "0a000000000", this.titular1);
	}

	@Test(expected = MalformedHandlerException.class)
	public void testMoreLengthWithLetterIn3Character()
			throws MalformedHandlerException, WrongArgsException {
		new Account(this.office, this.bank, "00a00000000", this.titular1);
	}

	@Test(expected = MalformedHandlerException.class)
	public void testMoreLengthWithLetterIn4Character()
			throws MalformedHandlerException, WrongArgsException {
		new Account(this.office, this.bank, "000a0000000", this.titular1);
	}

	@Test(expected = MalformedHandlerException.class)
	public void testMoreLengthWithLetterIn5Character()
			throws MalformedHandlerException, WrongArgsException {
		new Account(this.office, this.bank, "0000a000000", this.titular1);
	}

	@Test(expected = MalformedHandlerException.class)
	public void testMoreLengthWithLetterIn6Character()
			throws MalformedHandlerException, WrongArgsException {
		new Account(this.office, this.bank, "00000a00000", this.titular1);
	}

	@Test(expected = MalformedHandlerException.class)
	public void testMoreLengthWithLetterIn7Character()
			throws MalformedHandlerException, WrongArgsException {
		new Account(this.office, this.bank, "000000a0000", this.titular1);
	}

	@Test(expected = MalformedHandlerException.class)
	public void testMoreLengthWithLetterIn8Character()
			throws MalformedHandlerException, WrongArgsException {
		new Account(this.office, this.bank, "0000000a000", this.titular1);
	}

	@Test(expected = MalformedHandlerException.class)
	public void testMoreLengthWithLetterIn9Character()
			throws MalformedHandlerException, WrongArgsException {
		new Account(this.office, this.bank, "00000000a00", this.titular1);
	}

	@Test(expected = MalformedHandlerException.class)
	public void testMoreLengthWithLetterIn10Character()
			throws MalformedHandlerException, WrongArgsException {
		new Account(this.office, this.bank, "000000000a0", this.titular1);
	}

	@Test(expected = MalformedHandlerException.class)
	public void testMoreLengthWithLetterIn11Character()
			throws MalformedHandlerException, WrongArgsException {
		new Account(this.office, this.bank, "0000000000a", this.titular1);
	}

	@Test(expected = MalformedHandlerException.class)
	public void testLessLengthWithLetterIn2Character()
			throws MalformedHandlerException, WrongArgsException {
		new Account(this.office, this.bank, "a00000000", this.titular1);
	}

	@Test(expected = MalformedHandlerException.class)
	public void testLessLengthWithLetterIn3Character()
			throws MalformedHandlerException, WrongArgsException {
		new Account(this.office, this.bank, "0a0000000", this.titular1);
	}

	@Test(expected = MalformedHandlerException.class)
	public void testLessLengthWithLetterIn4Character()
			throws MalformedHandlerException, WrongArgsException {
		new Account(this.office, this.bank, "00a000000", this.titular1);
	}

	@Test(expected = MalformedHandlerException.class)
	public void testLessLengthWithLetterIn5Character()
			throws MalformedHandlerException, WrongArgsException {
		new Account(this.office, this.bank, "000a00000", this.titular1);
	}

	@Test(expected = MalformedHandlerException.class)
	public void testLessLengthWithLetterIn6Character()
			throws MalformedHandlerException, WrongArgsException {
		new Account(this.office, this.bank, "0000a0000", this.titular1);
	}

	@Test(expected = MalformedHandlerException.class)
	public void testLessLengthWithLetterIn7Character()
			throws MalformedHandlerException, WrongArgsException {
		new Account(this.office, this.bank, "00000a000", this.titular1);
	}

	@Test(expected = MalformedHandlerException.class)
	public void testLessLengthWithLetterIn8Character()
			throws MalformedHandlerException, WrongArgsException {
		new Account(this.office, this.bank, "000000a00", this.titular1);
	}

	@Test(expected = MalformedHandlerException.class)
	public void testLessLengthWithLetterIn9Character()
			throws MalformedHandlerException, WrongArgsException {
		new Account(this.office, this.bank, "0000000a0", this.titular1);
	}

	@Test(expected = MalformedHandlerException.class)
	public void testLessLengthWithLetterIn10Character()
			throws MalformedHandlerException, WrongArgsException {
		new Account(this.office, this.bank, "00000000a", this.titular1);
	}

	/**
	 * Test of getBalance method, of class Account.
	 */
	@Test
	public void testGetBalance() {
		double expResult = 0.0d;
		double result = this.commercialAccount.getBalance();
		assertEquals(expResult, result, 0.0);
	}

	@Test
	public void testGetTitulars() {
		List<Client> clients = this.commercialAccount.getTitulars();
		assertEquals(clients.size(), 2);
		assertTrue(clients.contains(this.titular1));
		assertTrue(clients.contains(this.titular2));
	}

	@Test
	public void testGetAuthorizeds() {
		List<Client> clients = this.commercialAccount.getAuthorizeds();
		assertEquals(clients.size(), 2);
		assertTrue(clients.contains(this.authorized1));
		assertTrue(clients.contains(this.authorized2));
	}

	@Test
	public void testGetID() throws MalformedHandlerException,
			WrongArgsException {
		Handler accountNumber = new AccountHandler(office.getIdOffice(),
				bank.getID(), this.accountNumber);
		assertTrue(accountNumber.compareTo(this.commercialAccount.getID()) == 0);
		accountNumber = new AccountHandler(office.getIdOffice(), bank.getID(),
				"1299567899");
		assertFalse(accountNumber.compareTo(this.commercialAccount.getID()) == 0);
		accountNumber = new AccountHandler(office.getIdOffice(),
				new GenericHandler("9999"), this.accountNumber);
		assertFalse(accountNumber.compareTo(this.commercialAccount.getID()) == 0);
		accountNumber = new AccountHandler(new GenericHandler("9999"),
				office.getIdOffice(), this.accountNumber);
		assertFalse(accountNumber.compareTo(this.commercialAccount.getID()) == 0);
	}

	@Test
	public void testDoTransaction() throws TransactionException {
		double amount = 10.0;
		GenericTransaction t2 = new GenericTransaction(amount, new Date(),
				"Salary");
		t2.setEffectiveDate(new Date(System.currentTimeMillis()));
		this.commercialAccount.doTransaction(t2);
		assertEquals(amount, this.commercialAccount.getBalance(), EPSILON);

		GenericTransaction t = new GenericTransaction(-amount, new Date(),
				"Salary");
		t.setEffectiveDate(new Date(System.currentTimeMillis()));
		this.commercialAccount.doTransaction(t);
		assertEquals(0.0, this.commercialAccount.getBalance(), EPSILON);

		GenericTransaction t3 = new GenericTransaction(amount, new Date(),
				"Salary");
		t.setEffectiveDate(new Date(System.currentTimeMillis()));
		this.commercialAccount.doTransaction(t3);
		assertEquals(amount, this.commercialAccount.getBalance(), EPSILON);

		GenericTransaction t4 = new GenericTransaction(amount, new Date(),
				"Salary");
		t.setEffectiveDate(new Date(System.currentTimeMillis()));
		this.commercialAccount.doTransaction(t4);
		assertEquals(2 * amount, this.commercialAccount.getBalance(), EPSILON);
	}

	@Test
	public void testGetterAndSetterMaxOverdraft() {
		assertEquals(this.commercialAccount.getMaxOverdraft(), 0.0, EPSILON);
		double maxOverdraft = 1;
		assertTrue(this.commercialAccount.setMaxOverdraft(maxOverdraft));
		assertEquals(this.commercialAccount.getMaxOverdraft(), maxOverdraft,
				EPSILON);
		assertFalse(this.commercialAccount.setMaxOverdraft(-maxOverdraft));
		assertEquals(this.commercialAccount.getMaxOverdraft(), maxOverdraft,
				EPSILON);
		maxOverdraft = 10000.0d;
		assertTrue(this.commercialAccount.setMaxOverdraft(maxOverdraft));
		assertEquals(this.commercialAccount.getMaxOverdraft(), maxOverdraft,
				EPSILON);
	}

	@Test
	public void testGetterAndSetterLiquidationFrecuency() {
		int frecuency = 1;
		assertEquals(this.commercialAccount.getLiquidationFrecuency(),
				Account.DEFAULT_LIQUIDATION_FREQUENCY);
		assertTrue(this.commercialAccount.setLiquidationFrecuency(frecuency));
		assertEquals(this.commercialAccount.getLiquidationFrecuency(),
				frecuency);
		assertFalse(this.commercialAccount.setLiquidationFrecuency(0));
		assertEquals(this.commercialAccount.getLiquidationFrecuency(),
				frecuency);
		assertFalse(this.commercialAccount.setLiquidationFrecuency(-1));
		assertEquals(this.commercialAccount.getLiquidationFrecuency(),
				frecuency);

	}

	@Test(expected = TransactionException.class)
	public void testDoTransactionNotEnoughOverdraftZero()
			throws TransactionException {
		double amount = -10.0;
		GenericTransaction t2 = new GenericTransaction(amount, new Date(),
				"Salary");
		t2.setEffectiveDate(new Date(System.currentTimeMillis()));
		this.commercialAccount.doTransaction(t2);
	}

	@Test(expected = TransactionException.class)
	public void testDoTransactionNotEnoughOverdraft()
			throws TransactionException {
		double amount = -10.0;
		this.commercialAccount.setMaxOverdraft(-1.0d * ((double) amount / 2));
		GenericTransaction t2 = new GenericTransaction(amount, new Date(),
				"Salary");
		t2.setEffectiveDate(new Date(System.currentTimeMillis()));
		this.commercialAccount.doTransaction(t2);
	}

	@Test
	public void testAccountHistory() throws TransactionException {
		double amount = 10.0;
		GenericTransaction t2 = new GenericTransaction(amount, new Date(),
				"Salary");
		t2.setEffectiveDate(new Date(System.currentTimeMillis()));
		this.commercialAccount.doTransaction(t2);

		GenericTransaction t = new GenericTransaction(-amount, new Date(),
				"Salary");
		t.setEffectiveDate(new Date(System.currentTimeMillis()));
		this.commercialAccount.doTransaction(t);

		History history = this.commercialAccount.getHistory();
		;
		Iterator<Transaction> it = history.getIterator();
		this.compareEntryAndTransactionsWithAsserts(t2, it.next());
		this.compareEntryAndTransactionsWithAsserts(t, it.next());
	}

	@Test
	public void testDirectDebitHistory() throws TransactionException {
		double amount = 10;
		DirectDebitTransaction ddt = new DirectDebitTransaction(amount,
				new Date(), "nothing", new GenericHandler("1234"));
		ddt.setEffectiveDate(new Date());
		this.commercialAccount.doDirectDebit(ddt);
		assertEquals(this.commercialAccount.getBalance(), amount, EPSILON);
		DirectDebitTransaction ddt2 = new DirectDebitTransaction(amount,
				new Date(), "nothing", new GenericHandler("1224"));
		ddt2.setEffectiveDate(new Date());
		this.commercialAccount.doDirectDebit(ddt2);
		assertEquals(this.commercialAccount.getBalance(), 2 * amount, EPSILON);
		DirectDebitTransaction ddt3 = new DirectDebitTransaction(amount,
				new Date(), "nothing", new GenericHandler("1334"));
		ddt3.setEffectiveDate(new Date());
		this.commercialAccount.doDirectDebit(ddt3);
		assertEquals(this.commercialAccount.getBalance(), 3 * amount, EPSILON);
		Iterator<DirectDebitTransaction> it = this.commercialAccount
				.getDirectDebitHistory().getIterator();
		this.compareEntryAndDirectDebitTransactionWithAsserts(ddt, it.next());
		this.compareEntryAndDirectDebitTransactionWithAsserts(ddt2, it.next());
		this.compareEntryAndDirectDebitTransactionWithAsserts(ddt3, it.next());

	}

	public void compareEntryAndDirectDebitTransactionWithAsserts(
			DirectDebitTransaction t, DirectDebitTransaction entry) {
		assertTrue(t.getSubject().equals(entry.getSubject()));
		assertTrue(t.getId().compareTo(entry.getId()) == 0);
		assertEquals(t.getAmount(), entry.getAmount(), EPSILON);
		assertTrue(t.getDate().compareTo(entry.getDate()) == 0);
		assertTrue(t.getEffectiveDate().compareTo(entry.getEffectiveDate()) == 0);
		assertTrue(t.getDirectDebitId().compareTo(entry.getDirectDebitId()) == 0);
	}

	public void compareEntryAndTransactionsWithAsserts(Transaction t,
			Transaction entry) {
		assertTrue(t.getSubject().equals(entry.getSubject()));
		assertTrue(t.getId().compareTo(entry.getId()) == 0);
		assertEquals(t.getAmount(), entry.getAmount(), EPSILON);
		assertTrue(t.getDate().compareTo(entry.getDate()) == 0);
		assertTrue(t.getEffectiveDate().compareTo(entry.getEffectiveDate()) == 0);
	}

	/**
	 * Test of getLiquidationFrecuency method, of class Account.
	 */
	@Test
	public void testGetAndSetLiquidationFrecuency() {
		assertEquals(this.commercialAccount.getLiquidationFrecuency(),
				Account.DEFAULT_LIQUIDATION_FREQUENCY);
		int frecuency = 1;
		assertTrue(this.commercialAccount.setLiquidationFrecuency(frecuency));
		assertEquals(this.commercialAccount.getLiquidationFrecuency(),
				frecuency);
		assertFalse(this.commercialAccount.setLiquidationFrecuency(-frecuency));
		assertEquals(this.commercialAccount.getLiquidationFrecuency(),
				frecuency);

	}

	/**
	 * Test of setMaxOverdraft method, of class Account.
	 */
	@Test
	public void testSetAndGetMaxOverdraft() {
		assertEquals(this.commercialAccount.getMaxOverdraft(), 0.0, EPSILON);
		double valid = 100;
		assertTrue(this.commercialAccount.setMaxOverdraft(valid));
		assertEquals(this.commercialAccount.getMaxOverdraft(), valid, EPSILON);
		assertFalse(this.commercialAccount.setMaxOverdraft(-valid));
		assertEquals(this.commercialAccount.getMaxOverdraft(), valid, EPSILON);
	}

	/**
	 * Test of addTitular method, of class Account.
	 */
	@Test
	public void testAddTitular() {
		fail("The test case is a prototype.");
	}

	/**
	 * Test of deleteTitular method, of class Account.
	 * 
	 * @throws MalformedHandlerException
	 */
	@Test
	public void testDeleteTitular() throws MalformedHandlerException {
		assertEquals(this.commercialAccount.getTitulars().size(), 2);
		assertTrue(this.commercialAccount.deleteTitular(new PersonHandler(NIF1,
				NIF_LETTER1)));
		assertEquals(this.commercialAccount.getTitulars().size(), 1);
		assertFalse(this.commercialAccount.deleteTitular(new PersonHandler(
				NIF2, NIF_LETTER2)));
		assertEquals(this.commercialAccount.getTitulars().size(), 1);
	}

	/**
	 * Test of addAuthorized method, of class Account.
	 */
	@Test
	public void testAddAuthorized() {
		fail("The test case is a prototype.");
	}

	/**
	 * Test of deleteAuthorized method, of class Account.
	 * 
	 * @throws MalformedHandlerException
	 */
	@Test
	public void testDeleteAuthorized() throws MalformedHandlerException {
		assertEquals(this.commercialAccount.getAuthorizeds().size(), 2);
		assertTrue(this.commercialAccount.deleteAuthorized(new PersonHandler(
				NIF3, NIF_LETTER3)));
		assertEquals(this.commercialAccount.getAuthorizeds().size(), 1);
		assertTrue(this.commercialAccount.deleteAuthorized(new PersonHandler(
				NIF4, NIF_LETTER4)));
		assertEquals(this.commercialAccount.getAuthorizeds().size(), 0);
	}

	/**
	 * Test of doDirectDebit method, of class Account.
	 */
	@Test
	public void testDoDirectDebit() throws Exception {
		fail("The test case is a prototype.");
	}

	/**
	 * Test of doLiquidation method, of class Account.
	 */
	@Test
	public void testDoLiquidation() {
		fail("The test case is a prototype.");
	}
}
