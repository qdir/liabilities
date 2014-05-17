/* Application developed for AW subject, belonging to passive operations
 group.*/
package es.unileon.ulebank.account;

import es.unileon.ulebank.exceptions.TransactionException;
import es.unileon.ulebank.bank.Bank;
import es.unileon.ulebank.client.Client;
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
    private Handler titularHandler1;
    private Handler titularHandler2;
    private Handler authorizedHandler1;
    private Handler authorizedHandler2;

    private String accountNumber = "0000000000";

    @Before
    public void setUp() throws MalformedHandlerException, WrongArgsException {
        this.bank = new Bank(new GenericHandler("1234"));
        this.office = new Office(new GenericHandler("1234"), this.bank);
        this.titularHandler1 = new GenericHandler("Paco");
        this.titularHandler2 = new GenericHandler("Manuel");
        this.authorizedHandler1 = new GenericHandler("Miguel");
        this.authorizedHandler2 = new GenericHandler("Jorge");
        this.titular1 = new Client(titularHandler1);
        this.commercialAccount = new Account(this.office, this.bank, accountNumber, titular1);
        this.titular2 = new Client(titularHandler2);
        this.authorized1 = new Client(authorizedHandler1);
        this.authorized2 = new Client(authorizedHandler2);
        this.commercialAccount.addTitular(this.titular2);
        this.commercialAccount.addAuthorized(this.authorized1);
        this.commercialAccount.addAuthorized(this.authorized2);

    }

    @Test(expected = MalformedHandlerException.class)
    public void testMoreAccountnumberLengthNullClient() throws MalformedHandlerException, WrongArgsException {
        this.commercialAccount = new Account(this.office, this.bank, "000000000000", null);
    }

    @Test(expected = MalformedHandlerException.class)
    public void testLessAccountnumberLengthNullClient() throws MalformedHandlerException, WrongArgsException {
        this.commercialAccount = new Account(this.office, this.bank, "000000", null);
    }

    @Test(expected = MalformedHandlerException.class)
    public void testCorrectAccountnumberLengthInterspersedLettersNullClient() throws MalformedHandlerException, WrongArgsException {
        this.commercialAccount = new Account(this.office, this.bank, "00aa00aa00", null);
    }

    @Test(expected = MalformedHandlerException.class)
    public void testCorrectLengthWithLetterIn1CharacterNullClient() throws MalformedHandlerException, WrongArgsException {
        new Account(this.office, this.bank, "a000000000", null);
    }

    @Test(expected = MalformedHandlerException.class)
    public void testCorrectLengthWithLetterIn2CharacterNullClient() throws MalformedHandlerException, WrongArgsException {
        new Account(this.office, this.bank, "0a00000000", null);
    }

    @Test(expected = MalformedHandlerException.class)
    public void testCorrectLengthWithLetterIn3CharacterNullClient() throws MalformedHandlerException, WrongArgsException {
        new Account(this.office, this.bank, "00a0000000", null);
    }

    @Test(expected = MalformedHandlerException.class)
    public void testCorrectLengthWithLetterIn4CharacterNullClient() throws MalformedHandlerException, WrongArgsException {
        new Account(this.office, this.bank, "000a000000", null);
    }

    @Test(expected = MalformedHandlerException.class)
    public void testCorrectLengthWithLetterIn5CharacterNullClient() throws MalformedHandlerException, WrongArgsException {
        new Account(this.office, this.bank, "0000a00000", null);
    }

    @Test(expected = MalformedHandlerException.class)
    public void testCorrectLengthWithLetterIn6CharacterNullClient() throws MalformedHandlerException, WrongArgsException {
        new Account(this.office, this.bank, "00000a0000", null);
    }

    @Test(expected = MalformedHandlerException.class)
    public void testCorrectLengthWithLetterIn7CharacterNullClient() throws MalformedHandlerException, WrongArgsException {
        new Account(this.office, this.bank, "000000a000", null);
    }

    @Test(expected = MalformedHandlerException.class)
    public void testCorrectLengthWithLetterIn8CharacterNullClient() throws MalformedHandlerException, WrongArgsException {
        new Account(this.office, this.bank, "0000000a00", null);
    }

    @Test(expected = MalformedHandlerException.class)
    public void testCorrectLengthWithLetterIn9CharacterNullClient() throws MalformedHandlerException, WrongArgsException {
        new Account(this.office, this.bank, "00000000a0", null);
    }

    @Test(expected = MalformedHandlerException.class)
    public void testCorrectLengthWithLetterIn10CharacterNullClient() throws MalformedHandlerException, WrongArgsException {
        new Account(this.office, this.bank, "000000000a", null);
    }

    @Test(expected = MalformedHandlerException.class)
    public void testMoreLengthWithLetterIn1CharacterNullClient() throws MalformedHandlerException, WrongArgsException {
        new Account(this.office, this.bank, "a0000000000", null);
    }

    @Test(expected = MalformedHandlerException.class)
    public void testMoreLengthWithLetterIn2CharacterNullClient() throws MalformedHandlerException, WrongArgsException {
        new Account(this.office, this.bank, "0a000000000", null);
    }

    @Test(expected = MalformedHandlerException.class)
    public void testMoreLengthWithLetterIn3CharacterNullClient() throws MalformedHandlerException, WrongArgsException {
        new Account(this.office, this.bank, "00a00000000", null);
    }

    @Test(expected = MalformedHandlerException.class)
    public void testMoreLengthWithLetterIn4CharacterNullClient() throws MalformedHandlerException, WrongArgsException {
        new Account(this.office, this.bank, "000a0000000", null);
    }

    @Test(expected = MalformedHandlerException.class)
    public void testMoreLengthWithLetterIn5CharacterNullClient() throws MalformedHandlerException, WrongArgsException {
        new Account(this.office, this.bank, "0000a000000", null);
    }

    @Test(expected = MalformedHandlerException.class)
    public void testMoreLengthWithLetterIn6CharacterNullClient() throws MalformedHandlerException, WrongArgsException {
        new Account(this.office, this.bank, "00000a00000", null);
    }

    @Test(expected = MalformedHandlerException.class)
    public void testMoreLengthWithLetterIn7CharacterNullClient() throws MalformedHandlerException, WrongArgsException {
        new Account(this.office, this.bank, "000000a0000", null);
    }

    @Test(expected = MalformedHandlerException.class)
    public void testMoreLengthWithLetterIn8CharacterNullClient() throws MalformedHandlerException, WrongArgsException {
        new Account(this.office, this.bank, "0000000a000", null);
    }

    @Test(expected = MalformedHandlerException.class)
    public void testMoreLengthWithLetterIn9CharacterNullClient() throws MalformedHandlerException, WrongArgsException {
        new Account(this.office, this.bank, "00000000a00", null);
    }

    @Test(expected = MalformedHandlerException.class)
    public void testMoreLengthWithLetterIn10CharacterNullClient() throws MalformedHandlerException, WrongArgsException {
        new Account(this.office, this.bank, "000000000a0", null);
    }

    @Test(expected = MalformedHandlerException.class)
    public void testMoreLengthWithLetterIn11CharacterNullClient() throws MalformedHandlerException, WrongArgsException {
        new Account(this.office, this.bank, "0000000000a", null);
    }

    @Test(expected = MalformedHandlerException.class)
    public void testLessLengthWithLetterIn2CharacterNullClient() throws MalformedHandlerException, WrongArgsException {
        new Account(this.office, this.bank, "a00000000", null);
    }

    @Test(expected = MalformedHandlerException.class)
    public void testLessLengthWithLetterIn3CharacterNullClient() throws MalformedHandlerException, WrongArgsException {
        new Account(this.office, this.bank, "0a0000000", null);
    }

    @Test(expected = MalformedHandlerException.class)
    public void testLessLengthWithLetterIn4CharacterNullClient() throws MalformedHandlerException, WrongArgsException {
        new Account(this.office, this.bank, "00a000000", null);
    }

    @Test(expected = MalformedHandlerException.class)
    public void testLessLengthWithLetterIn5CharacterNullClient() throws MalformedHandlerException, WrongArgsException {
        new Account(this.office, this.bank, "000a00000", null);
    }

    @Test(expected = MalformedHandlerException.class)
    public void testLessLengthWithLetterIn6CharacterNullClient() throws MalformedHandlerException, WrongArgsException {
        new Account(this.office, this.bank, "0000a0000", null);
    }

    @Test(expected = MalformedHandlerException.class)
    public void testLessLengthWithLetterIn7CharacterNullClient() throws MalformedHandlerException, WrongArgsException {
        new Account(this.office, this.bank, "00000a000", null);
    }

    @Test(expected = MalformedHandlerException.class)
    public void testLessLengthWithLetterIn8CharacterNullClient() throws MalformedHandlerException, WrongArgsException {
        new Account(this.office, this.bank, "000000a00", null);
    }

    @Test(expected = MalformedHandlerException.class)
    public void testLessLengthWithLetterIn9CharacterNullClient() throws MalformedHandlerException, WrongArgsException {
        new Account(this.office, this.bank, "0000000a0", null);
    }

    @Test(expected = MalformedHandlerException.class)
    public void testLessLengthWithLetterIn10CharacterNullClient() throws MalformedHandlerException, WrongArgsException {
        new Account(this.office, this.bank, "00000000a", null);
    }

    @Test(expected = WrongArgsException.class)
    public void testNullClient() throws MalformedHandlerException, WrongArgsException {
        new Account(this.office, this.bank, this.accountNumber, null);
    }

    @Test(expected = MalformedHandlerException.class)
    public void testMoreAccountnumberLength() throws MalformedHandlerException, WrongArgsException {
        this.commercialAccount = new Account(this.office, this.bank, "000000000000", this.titular1);
    }

    @Test(expected = MalformedHandlerException.class)
    public void testLessAccountnumberLength() throws MalformedHandlerException, WrongArgsException {
        this.commercialAccount = new Account(this.office, this.bank, "000000", this.titular1);
    }

    @Test(expected = MalformedHandlerException.class)
    public void testCorrectAccountnumberLengthInterspersedLetters() throws MalformedHandlerException, WrongArgsException {
        this.commercialAccount = new Account(this.office, this.bank, "00aa00aa00", this.titular1);
    }

    @Test(expected = MalformedHandlerException.class)
    public void testCorrectLengthWithLetterIn1Character() throws MalformedHandlerException, WrongArgsException {
        new Account(this.office, this.bank, "a000000000", this.titular1);
    }

    @Test(expected = MalformedHandlerException.class)
    public void testCorrectLengthWithLetterIn2Character() throws MalformedHandlerException, WrongArgsException {
        new Account(this.office, this.bank, "0a00000000", this.titular1);
    }

    @Test(expected = MalformedHandlerException.class)
    public void testCorrectLengthWithLetterIn3Character() throws MalformedHandlerException, WrongArgsException {
        new Account(this.office, this.bank, "00a0000000", this.titular1);
    }

    @Test(expected = MalformedHandlerException.class)
    public void testCorrectLengthWithLetterIn4Character() throws MalformedHandlerException, WrongArgsException {
        new Account(this.office, this.bank, "000a000000", this.titular1);
    }

    @Test(expected = MalformedHandlerException.class)
    public void testCorrectLengthWithLetterIn5Character() throws MalformedHandlerException, WrongArgsException {
        new Account(this.office, this.bank, "0000a00000", this.titular1);
    }

    @Test(expected = MalformedHandlerException.class)
    public void testCorrectLengthWithLetterIn6Character() throws MalformedHandlerException, WrongArgsException {
        new Account(this.office, this.bank, "00000a0000", this.titular1);
    }

    @Test(expected = MalformedHandlerException.class)
    public void testCorrectLengthWithLetterIn7Character() throws MalformedHandlerException, WrongArgsException {
        new Account(this.office, this.bank, "000000a000", this.titular1);
    }

    @Test(expected = MalformedHandlerException.class)
    public void testCorrectLengthWithLetterIn8Character() throws MalformedHandlerException, WrongArgsException {
        new Account(this.office, this.bank, "0000000a00", this.titular1);
    }

    @Test(expected = MalformedHandlerException.class)
    public void testCorrectLengthWithLetterIn9Character() throws MalformedHandlerException, WrongArgsException {
        new Account(this.office, this.bank, "00000000a0", this.titular1);
    }

    @Test(expected = MalformedHandlerException.class)
    public void testCorrectLengthWithLetterIn10Character() throws MalformedHandlerException, WrongArgsException {
        new Account(this.office, this.bank, "000000000a", this.titular1);
    }

    @Test(expected = MalformedHandlerException.class)
    public void testMoreLengthWithLetterIn1Character() throws MalformedHandlerException, WrongArgsException {
        new Account(this.office, this.bank, "a0000000000", this.titular1);
    }

    @Test(expected = MalformedHandlerException.class)
    public void testMoreLengthWithLetterIn2Character() throws MalformedHandlerException, WrongArgsException {
        new Account(this.office, this.bank, "0a000000000", this.titular1);
    }

    @Test(expected = MalformedHandlerException.class)
    public void testMoreLengthWithLetterIn3Character() throws MalformedHandlerException, WrongArgsException {
        new Account(this.office, this.bank, "00a00000000", this.titular1);
    }

    @Test(expected = MalformedHandlerException.class)
    public void testMoreLengthWithLetterIn4Character() throws MalformedHandlerException, WrongArgsException {
        new Account(this.office, this.bank, "000a0000000", this.titular1);
    }

    @Test(expected = MalformedHandlerException.class)
    public void testMoreLengthWithLetterIn5Character() throws MalformedHandlerException, WrongArgsException {
        new Account(this.office, this.bank, "0000a000000", this.titular1);
    }

    @Test(expected = MalformedHandlerException.class)
    public void testMoreLengthWithLetterIn6Character() throws MalformedHandlerException, WrongArgsException {
        new Account(this.office, this.bank, "00000a00000", this.titular1);
    }

    @Test(expected = MalformedHandlerException.class)
    public void testMoreLengthWithLetterIn7Character() throws MalformedHandlerException, WrongArgsException {
        new Account(this.office, this.bank, "000000a0000", this.titular1);
    }

    @Test(expected = MalformedHandlerException.class)
    public void testMoreLengthWithLetterIn8Character() throws MalformedHandlerException, WrongArgsException {
        new Account(this.office, this.bank, "0000000a000", this.titular1);
    }

    @Test(expected = MalformedHandlerException.class)
    public void testMoreLengthWithLetterIn9Character() throws MalformedHandlerException, WrongArgsException {
        new Account(this.office, this.bank, "00000000a00", this.titular1);
    }

    @Test(expected = MalformedHandlerException.class)
    public void testMoreLengthWithLetterIn10Character() throws MalformedHandlerException, WrongArgsException {
        new Account(this.office, this.bank, "000000000a0", this.titular1);
    }

    @Test(expected = MalformedHandlerException.class)
    public void testMoreLengthWithLetterIn11Character() throws MalformedHandlerException, WrongArgsException {
        new Account(this.office, this.bank, "0000000000a", this.titular1);
    }

    @Test(expected = MalformedHandlerException.class)
    public void testLessLengthWithLetterIn2Character() throws MalformedHandlerException, WrongArgsException {
        new Account(this.office, this.bank, "a00000000", this.titular1);
    }

    @Test(expected = MalformedHandlerException.class)
    public void testLessLengthWithLetterIn3Character() throws MalformedHandlerException, WrongArgsException {
        new Account(this.office, this.bank, "0a0000000", this.titular1);
    }

    @Test(expected = MalformedHandlerException.class)
    public void testLessLengthWithLetterIn4Character() throws MalformedHandlerException, WrongArgsException {
        new Account(this.office, this.bank, "00a000000", this.titular1);
    }

    @Test(expected = MalformedHandlerException.class)
    public void testLessLengthWithLetterIn5Character() throws MalformedHandlerException, WrongArgsException {
        new Account(this.office, this.bank, "000a00000", this.titular1);
    }

    @Test(expected = MalformedHandlerException.class)
    public void testLessLengthWithLetterIn6Character() throws MalformedHandlerException, WrongArgsException {
        new Account(this.office, this.bank, "0000a0000", this.titular1);
    }

    @Test(expected = MalformedHandlerException.class)
    public void testLessLengthWithLetterIn7Character() throws MalformedHandlerException, WrongArgsException {
        new Account(this.office, this.bank, "00000a000", this.titular1);
    }

    @Test(expected = MalformedHandlerException.class)
    public void testLessLengthWithLetterIn8Character() throws MalformedHandlerException, WrongArgsException {
        new Account(this.office, this.bank, "000000a00", this.titular1);
    }

    @Test(expected = MalformedHandlerException.class)
    public void testLessLengthWithLetterIn9Character() throws MalformedHandlerException, WrongArgsException {
        new Account(this.office, this.bank, "0000000a0", this.titular1);
    }

    @Test(expected = MalformedHandlerException.class)
    public void testLessLengthWithLetterIn10Character() throws MalformedHandlerException, WrongArgsException {
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
    public void testAuthorizeds() {
        List<Client> clients = this.commercialAccount.getAuthorizeds();
        assertEquals(clients.size(), 2);
        assertTrue(clients.contains(this.authorized1));
        assertTrue(clients.contains(this.authorized2));
    }

    @Test
    public void testGetID() throws MalformedHandlerException, WrongArgsException {
        Handler accountNumber = new AccountHandler(office.getIdOffice(), bank.getID(), this.accountNumber);
        assertTrue(accountNumber.compareTo(this.commercialAccount.getID()) == 0);
        accountNumber = new AccountHandler(office.getIdOffice(), bank.getID(), "1299567899");
        assertFalse(accountNumber.compareTo(this.commercialAccount.getID()) == 0);
        accountNumber = new AccountHandler(office.getIdOffice(), new GenericHandler("9999"), this.accountNumber);
        assertFalse(accountNumber.compareTo(this.commercialAccount.getID()) == 0);
        accountNumber = new AccountHandler(new GenericHandler("9999"), office.getIdOffice(), this.accountNumber);
        assertFalse(accountNumber.compareTo(this.commercialAccount.getID()) == 0);
    }

    @Test
    public void testDoTransaction() throws TransactionException {
        double amount = 10.0;
        GenericTransaction t2 = new GenericTransaction(amount, new Date(), "Salary");
        t2.setEffectiveDate(new Date(System.currentTimeMillis()));
        this.commercialAccount.doTransaction(t2);
        assertEquals(amount, this.commercialAccount.getBalance(), EPSILON);

        GenericTransaction t = new GenericTransaction(-amount, new Date(), "Salary");
        t.setEffectiveDate(new Date(System.currentTimeMillis()));
        this.commercialAccount.doTransaction(t);
        assertEquals(0.0, this.commercialAccount.getBalance(), EPSILON);

        GenericTransaction t3 = new GenericTransaction(amount, new Date(), "Salary");
        t.setEffectiveDate(new Date(System.currentTimeMillis()));
        this.commercialAccount.doTransaction(t3);
        assertEquals(amount, this.commercialAccount.getBalance(), EPSILON);

        GenericTransaction t4 = new GenericTransaction(amount, new Date(), "Salary");
        t.setEffectiveDate(new Date(System.currentTimeMillis()));
        this.commercialAccount.doTransaction(t4);
        assertEquals(2 * amount, this.commercialAccount.getBalance(), EPSILON);
    }

    @Test
    public void testGetterAndSetterMaxOverdraft() {
        assertEquals(this.commercialAccount.getMaxOverdraft(), 0.0, EPSILON);
        double maxOverdraft = 1;
        assertTrue(this.commercialAccount.setMaxOverdraft(maxOverdraft));
        assertEquals(this.commercialAccount.getMaxOverdraft(), maxOverdraft, EPSILON);
        assertFalse(this.commercialAccount.setMaxOverdraft(-maxOverdraft));
        assertEquals(this.commercialAccount.getMaxOverdraft(), maxOverdraft, EPSILON);
        maxOverdraft = 10000.0d;
        assertTrue(this.commercialAccount.setMaxOverdraft(maxOverdraft));
        assertEquals(this.commercialAccount.getMaxOverdraft(), maxOverdraft, EPSILON);
    }

    @Test
    public void testGetterAndSetterLiquidationFrecuency() {
        int frecuency = 1;
        assertEquals(this.commercialAccount.getLiquidationFrecuency(), Account.DEFAULT_LIQUIDATION_FREQUENCY);
        assertTrue(this.commercialAccount.setLiquidationFrecuency(frecuency));
        assertEquals(this.commercialAccount.getLiquidationFrecuency(), frecuency);
        assertFalse(this.commercialAccount.setLiquidationFrecuency(0));
        assertEquals(this.commercialAccount.getLiquidationFrecuency(), frecuency);
        assertFalse(this.commercialAccount.setLiquidationFrecuency(-1));
        assertEquals(this.commercialAccount.getLiquidationFrecuency(), frecuency);

    }

    @Test(expected = TransactionException.class)
    public void testDoTransactionNotEnoughOverdraftZero() throws TransactionException {
        double amount = -10.0;
        GenericTransaction t2 = new GenericTransaction(amount, new Date(), "Salary");
        t2.setEffectiveDate(new Date(System.currentTimeMillis()));
        this.commercialAccount.doTransaction(t2);
    }

    @Test(expected = TransactionException.class)
    public void testDoTransactionNotEnoughOverdraft() throws TransactionException {
        double amount = -10.0;
        this.commercialAccount.setMaxOverdraft(-1.0d * ((double) amount / 2));
        GenericTransaction t2 = new GenericTransaction(amount, new Date(), "Salary");
        t2.setEffectiveDate(new Date(System.currentTimeMillis()));
        this.commercialAccount.doTransaction(t2);
    }

    @Test
    public void testAccountHistory() throws TransactionException {
        double amount = 10.0;
        GenericTransaction t2 = new GenericTransaction(amount, new Date(), "Salary");
        t2.setEffectiveDate(new Date(System.currentTimeMillis()));
        this.commercialAccount.doTransaction(t2);

        GenericTransaction t = new GenericTransaction(-amount, new Date(), "Salary");
        t.setEffectiveDate(new Date(System.currentTimeMillis()));
        this.commercialAccount.doTransaction(t);

        History history = this.commercialAccount.getHistory();;
        Iterator<Transaction> it = history.getIterator();
        this.compareEntryAndTransactionsWithAsserts(t2, it.next());
        this.compareEntryAndTransactionsWithAsserts(t, it.next());
    }

    @Test
    public void testDirectDebitHistory() throws TransactionException {
        double amount = 10;
        DirectDebitTransaction ddt = new DirectDebitTransaction(amount, new Date(), "nothing", new GenericHandler("1234"));
        ddt.setEffectiveDate(new Date());
        this.commercialAccount.doDirectDebit(ddt);
        assertEquals(this.commercialAccount.getBalance(), amount, EPSILON);
        DirectDebitTransaction ddt2 = new DirectDebitTransaction(amount, new Date(), "nothing", new GenericHandler("1224"));
        ddt2.setEffectiveDate(new Date());
        this.commercialAccount.doDirectDebit(ddt2);
        assertEquals(this.commercialAccount.getBalance(), 2 * amount, EPSILON);
        DirectDebitTransaction ddt3 = new DirectDebitTransaction(amount, new Date(), "nothing", new GenericHandler("1334"));
        ddt3.setEffectiveDate(new Date());
        this.commercialAccount.doDirectDebit(ddt3);
        assertEquals(this.commercialAccount.getBalance(), 3 * amount, EPSILON);
        Iterator<DirectDebitTransaction> it = this.commercialAccount.getDirectDebitHistory().getIterator();
        this.compareEntryAndDirectDebitTransactionWithAsserts(ddt, it.next());
        this.compareEntryAndDirectDebitTransactionWithAsserts(ddt2, it.next());
        this.compareEntryAndDirectDebitTransactionWithAsserts(ddt3, it.next());

    }

    public void compareEntryAndDirectDebitTransactionWithAsserts(DirectDebitTransaction t, DirectDebitTransaction entry) {
        assertTrue(t.getSubject().equals(entry.getSubject()));
        assertTrue(t.getId().compareTo(entry.getId()) == 0);
        assertEquals(t.getAmount(), entry.getAmount(), EPSILON);
        assertTrue(t.getDate().compareTo(entry.getDate()) == 0);
        assertTrue(t.getEffectiveDate().compareTo(entry.getEffectiveDate()) == 0);
        assertTrue(t.getDirectDebitId().compareTo(entry.getDirectDebitId()) == 0);
    }

    public void compareEntryAndTransactionsWithAsserts(Transaction t, Transaction entry) {
        assertTrue(t.getSubject().equals(entry.getSubject()));
        assertTrue(t.getId().compareTo(entry.getId()) == 0);
        assertEquals(t.getAmount(), entry.getAmount(), EPSILON);
        assertTrue(t.getDate().compareTo(entry.getDate()) == 0);
        assertTrue(t.getEffectiveDate().compareTo(entry.getEffectiveDate()) == 0);
    }

    /**
     * Test of setLiquidationFrecuency method, of class Account.
     */
    @Test
    public void testSetLiquidationFrecuency() {
        int liquidationFrecuency = 0;
        Account instance = null;
        boolean expResult = false;
        boolean result = instance.setLiquidationFrecuency(liquidationFrecuency);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLiquidationFrecuency method, of class Account.
     */
    @Test
    public void testGetLiquidationFrecuency() {
        Account instance = null;
        int expResult = 0;
        int result = instance.getLiquidationFrecuency();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMaxOverdraft method, of class Account.
     */
    @Test
    public void testSetMaxOverdraft() {
        double maxOverdraft = 0.0;
        Account instance = null;
        boolean expResult = false;
        boolean result = instance.setMaxOverdraft(maxOverdraft);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addTitular method, of class Account.
     */
    @Test
    public void testAddTitular() {
        Client client = null;
        Account instance = null;
        boolean expResult = false;
        boolean result = instance.addTitular(client);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteTitular method, of class Account.
     */
    @Test
    public void testDeleteTitular() {
        Handler id = null;
        Account instance = null;
        boolean expResult = false;
        boolean result = instance.deleteTitular(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addAuthorized method, of class Account.
     */
    @Test
    public void testAddAuthorized() {
        Client authorized = null;
        Account instance = null;
        boolean expResult = false;
        boolean result = instance.addAuthorized(authorized);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteAuthorized method, of class Account.
     */
    @Test
    public void testDeleteAuthorized() {
        Handler id = null;
        Account instance = null;
        boolean expResult = false;
        boolean result = instance.deleteAuthorized(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAuthorizeds method, of class Account.
     */
    @Test
    public void testGetAuthorizeds() {
        Account instance = null;
        List<Client> expResult = null;
        List<Client> result = instance.getAuthorizeds();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMaxOverdraft method, of class Account.
     */
    @Test
    public void testGetMaxOverdraft() {
        Account instance = null;
        double expResult = 0.0;
        double result = instance.getMaxOverdraft();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of doDirectDebit method, of class Account.
     */
    @Test
    public void testDoDirectDebit() throws Exception {
        DirectDebitTransaction transaction = null;
        Account instance = null;
        instance.doDirectDebit(transaction);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addLiquidationStrategy method, of class Account.
     */
    @Test
    public void testAddLiquidationStrategy() {
        LiquidationStrategy strategy = null;
        Account instance = null;
        boolean expResult = false;
        boolean result = instance.addLiquidationStrategy(strategy);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteLiquidationStrategy method, of class Account.
     */
    @Test
    public void testDeleteLiquidationStrategy() {
        Handler id = null;
        Account instance = null;
        boolean expResult = false;
        boolean result = instance.deleteLiquidationStrategy(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of doLiquidation method, of class Account.
     */
    @Test
    public void testDoLiquidation() {
        Office office = null;
        Account instance = null;
        instance.doLiquidation(office);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHistory method, of class Account.
     */
    @Test
    public void testGetHistory() {
        Account instance = null;
        History expResult = null;
        History result = instance.getHistory();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDirectDebitHistory method, of class Account.
     */
    @Test
    public void testGetDirectDebitHistory() {
        Account instance = null;
        History<DirectDebitTransaction> expResult = null;
        History<DirectDebitTransaction> result = instance.getDirectDebitHistory();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getExemptLiquidationStrategy method, of class Account.
     */
    @Test
    public void testGetExemptLiquidationStrategy() {
        Account instance = null;
        ExemptLiquidationStrategy<Transaction> expResult = null;
        ExemptLiquidationStrategy<Transaction> result = instance.getExemptLiquidationStrategy();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setExemptLiquidationStrategy method, of class Account.
     */
    @Test
    public void testSetExemptLiquidationStrategy() {
        ExemptLiquidationStrategy<Transaction> exemptLiquidationStrategy = null;
        Account instance = null;
        instance.setExemptLiquidationStrategy(exemptLiquidationStrategy);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
