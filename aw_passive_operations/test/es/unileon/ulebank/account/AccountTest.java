/* Application developed for AW subject, belonging to passive operations
 group.*/
package es.unileon.ulebank.account;

import es.unileon.ulebank.exceptions.TransactionException;
import es.unileon.ulebank.bank.Bank;
import es.unileon.ulebank.client.Client;
import es.unileon.ulebank.handler.GenericHandler;
import es.unileon.ulebank.handler.Handler;
import es.unileon.ulebank.handler.MalformedHandlerException;
import es.unileon.ulebank.history.GenericTransaction;
import es.unileon.ulebank.history.TransactionType;
import es.unileon.ulebank.office.Office;
import es.unileon.ulebank.transacionManager.TransactionManager;
import es.unileon.ulebank.history.History;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
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

    private TransactionManager manager;

    private String accountNumber = "0000000000";

    @Before
    public void setUp() throws MalformedHandlerException {
        this.manager = new TransactionManager();
        this.bank = new Bank(manager, new GenericHandler("1234"));
        this.office = new Office(new GenericHandler("1234"), this.bank);
        this.commercialAccount = new Account(this.office, this.bank, accountNumber);
        this.titularHandler1 = new GenericHandler("Paco");
        this.titularHandler2 = new GenericHandler("Manuel");
        this.authorizedHandler1 = new GenericHandler("Miguel");
        this.authorizedHandler2 = new GenericHandler("Jorge");
        this.titular1 = new Client(titularHandler1);
        this.titular2 = new Client(titularHandler2);
        this.authorized1 = new Client(authorizedHandler1);
        this.authorized2 = new Client(authorizedHandler2);
        this.commercialAccount.addTitular(this.titular1);
        this.commercialAccount.addTitular(this.titular2);
        this.commercialAccount.addAuthorized(this.authorized1);
        this.commercialAccount.addAuthorized(this.authorized2);

    }

    @Test(expected = MalformedHandlerException.class)
    public void testMoreAccountnumberLength() throws MalformedHandlerException {
        this.commercialAccount = new Account(this.office, this.bank, "000000000000");
    }

    @Test(expected = MalformedHandlerException.class)
    public void testLessAccountnumberLength() throws MalformedHandlerException {
        this.commercialAccount = new Account(this.office, this.bank, "000000");
    }

    @Test(expected = MalformedHandlerException.class)
    public void testCorrectAccountnumberLengthInterspersedLetters() throws MalformedHandlerException {
        this.commercialAccount = new Account(this.office, this.bank, "00aa00aa00");
    }

    @Test(expected = MalformedHandlerException.class)
    public void testCorrectLengthWithLetterIn1Character() throws MalformedHandlerException {
        new Account(this.office, this.bank, "a000000000");
    }

    @Test(expected = MalformedHandlerException.class)
    public void testCorrectLengthWithLetterIn2Character() throws MalformedHandlerException {
        new Account(this.office, this.bank, "0a00000000");
    }

    @Test(expected = MalformedHandlerException.class)
    public void testCorrectLengthWithLetterIn3Character() throws MalformedHandlerException {
        new Account(this.office, this.bank, "00a0000000");
    }

    @Test(expected = MalformedHandlerException.class)
    public void testCorrectLengthWithLetterIn4Character() throws MalformedHandlerException {
        new Account(this.office, this.bank, "000a000000");
    }

    @Test(expected = MalformedHandlerException.class)
    public void testCorrectLengthWithLetterIn5Character() throws MalformedHandlerException {
        new Account(this.office, this.bank, "0000a00000");
    }

    @Test(expected = MalformedHandlerException.class)
    public void testCorrectLengthWithLetterIn6Character() throws MalformedHandlerException {
        new Account(this.office, this.bank, "00000a0000");
    }

    @Test(expected = MalformedHandlerException.class)
    public void testCorrectLengthWithLetterIn7Character() throws MalformedHandlerException {
        new Account(this.office, this.bank, "000000a000");
    }

    @Test(expected = MalformedHandlerException.class)
    public void testCorrectLengthWithLetterIn8Character() throws MalformedHandlerException {
        new Account(this.office, this.bank, "0000000a00");
    }

    @Test(expected = MalformedHandlerException.class)
    public void testCorrectLengthWithLetterIn9Character() throws MalformedHandlerException {
        new Account(this.office, this.bank, "00000000a0");
    }

    @Test(expected = MalformedHandlerException.class)
    public void testCorrectLengthWithLetterIn10Character() throws MalformedHandlerException {
        new Account(this.office, this.bank, "000000000a");
    }

    @Test(expected = MalformedHandlerException.class)
    public void testMoreLengthWithLetterIn1Character() throws MalformedHandlerException {
        new Account(this.office, this.bank, "a0000000000");
    }

    @Test(expected = MalformedHandlerException.class)
    public void testMoreLengthWithLetterIn2Character() throws MalformedHandlerException {
        new Account(this.office, this.bank, "0a000000000");
    }

    @Test(expected = MalformedHandlerException.class)
    public void testMoreLengthWithLetterIn3Character() throws MalformedHandlerException {
        new Account(this.office, this.bank, "00a00000000");
    }

    @Test(expected = MalformedHandlerException.class)
    public void testMoreLengthWithLetterIn4Character() throws MalformedHandlerException {
        new Account(this.office, this.bank, "000a0000000");
    }

    @Test(expected = MalformedHandlerException.class)
    public void testMoreLengthWithLetterIn5Character() throws MalformedHandlerException {
        new Account(this.office, this.bank, "0000a000000");
    }

    @Test(expected = MalformedHandlerException.class)
    public void testMoreLengthWithLetterIn6Character() throws MalformedHandlerException {
        new Account(this.office, this.bank, "00000a00000");
    }

    @Test(expected = MalformedHandlerException.class)
    public void testMoreLengthWithLetterIn7Character() throws MalformedHandlerException {
        new Account(this.office, this.bank, "000000a0000");
    }

    @Test(expected = MalformedHandlerException.class)
    public void testMoreLengthWithLetterIn8Character() throws MalformedHandlerException {
        new Account(this.office, this.bank, "0000000a000");
    }

    @Test(expected = MalformedHandlerException.class)
    public void testMoreLengthWithLetterIn9Character() throws MalformedHandlerException {
        new Account(this.office, this.bank, "00000000a00");
    }

    @Test(expected = MalformedHandlerException.class)
    public void testMoreLengthWithLetterIn10Character() throws MalformedHandlerException {
        new Account(this.office, this.bank, "000000000a0");
    }

    @Test(expected = MalformedHandlerException.class)
    public void testMoreLengthWithLetterIn11Character() throws MalformedHandlerException {
        new Account(this.office, this.bank, "0000000000a");
    }

    @Test(expected = MalformedHandlerException.class)
    public void testLessLengthWithLetterIn2Character() throws MalformedHandlerException {
        new Account(this.office, this.bank, "a00000000");
    }

    @Test(expected = MalformedHandlerException.class)
    public void testLessLengthWithLetterIn3Character() throws MalformedHandlerException {
        new Account(this.office, this.bank, "0a0000000");
    }

    @Test(expected = MalformedHandlerException.class)
    public void testLessLengthWithLetterIn4Character() throws MalformedHandlerException {
        new Account(this.office, this.bank, "00a000000");
    }

    @Test(expected = MalformedHandlerException.class)
    public void testLessLengthWithLetterIn5Character() throws MalformedHandlerException {
        new Account(this.office, this.bank, "000a00000");
    }

    @Test(expected = MalformedHandlerException.class)
    public void testLessLengthWithLetterIn6Character() throws MalformedHandlerException {
        new Account(this.office, this.bank, "0000a0000");
    }

    @Test(expected = MalformedHandlerException.class)
    public void testLessLengthWithLetterIn7Character() throws MalformedHandlerException {
        new Account(this.office, this.bank, "00000a000");
    }

    @Test(expected = MalformedHandlerException.class)
    public void testLessLengthWithLetterIn8Character() throws MalformedHandlerException {
        new Account(this.office, this.bank, "000000a00");
    }

    @Test(expected = MalformedHandlerException.class)
    public void testLessLengthWithLetterIn9Character() throws MalformedHandlerException {
        new Account(this.office, this.bank, "0000000a0");
    }

    @Test(expected = MalformedHandlerException.class)
    public void testLessLengthWithLetterIn10Character() throws MalformedHandlerException {
        new Account(this.office, this.bank, "00000000a");
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

    @Test(expected = TransactionException.class)
    public void testDoWithdrawalNegativeAmount() throws TransactionException {
        GenericTransaction t = new GenericTransaction(-1.0, new Date(), "Subject", TransactionType.CHARGE);
        this.commercialAccount.doWithdrawal(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoWithdrawalNegativeAmountBadType() throws TransactionException {
        GenericTransaction t = new GenericTransaction(-1.0, new Date(), "Subject", TransactionType.PAYMENT);
        this.commercialAccount.doWithdrawal(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoWithdrawalSubjectNull() throws TransactionException {
        GenericTransaction t = new GenericTransaction(0.0, new Date(), null, TransactionType.CHARGE);
        this.commercialAccount.doWithdrawal(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoWithdrawalCreationDateNull() throws TransactionException {
        GenericTransaction t = new GenericTransaction(0.0, null, "subject", TransactionType.CHARGE);
        this.commercialAccount.doWithdrawal(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoWithdrawalCreationDateSubjectNull() throws TransactionException {
        GenericTransaction t = new GenericTransaction(0.0, null, null, TransactionType.CHARGE);
        this.commercialAccount.doWithdrawal(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoWithdrawalNegativeAmountSubjectNull() throws TransactionException {
        GenericTransaction t = new GenericTransaction(-1.0, new Date(), null, TransactionType.CHARGE);
        this.commercialAccount.doWithdrawal(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoWithdrawalNegativeAmountCreationDateNull() throws TransactionException {
        GenericTransaction t = new GenericTransaction(-1.0, null, "subject", TransactionType.CHARGE);
        this.commercialAccount.doWithdrawal(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoWithdrawalNegativeAmountCreationDateSubjectNull() throws TransactionException {
        GenericTransaction t = new GenericTransaction(-1.0, null, null, TransactionType.CHARGE);
        this.commercialAccount.doWithdrawal(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoWithdrawalPositiveAmountSubjectNull() throws TransactionException {
        GenericTransaction t = new GenericTransaction(1.0, new Date(), null, TransactionType.CHARGE);
        this.commercialAccount.doWithdrawal(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoWithdrawalPositiveAmountCreationDateNull() throws TransactionException {
        GenericTransaction t = new GenericTransaction(1.0, null, "subject", TransactionType.CHARGE);
        this.commercialAccount.doWithdrawal(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoWithdrawalPositiveAmountCreationDateSubjectNull() throws TransactionException {
        GenericTransaction t = new GenericTransaction(1.0, null, null, TransactionType.CHARGE);
        this.commercialAccount.doWithdrawal(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoWithdrawalBadTypeSubjectNull() throws TransactionException {
        GenericTransaction t = new GenericTransaction(0.0, new Date(), null, TransactionType.PAYMENT);
        this.commercialAccount.doWithdrawal(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoWithdrawalBadTypeCreationDateNull() throws TransactionException {
        GenericTransaction t = new GenericTransaction(0.0, null, "subject", TransactionType.PAYMENT);
        this.commercialAccount.doWithdrawal(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoWithdrawalBadTypeCreationDateSubjectNull() throws TransactionException {
        GenericTransaction t = new GenericTransaction(0.0, null, null, TransactionType.PAYMENT);
        this.commercialAccount.doWithdrawal(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoWithdrawalBadTypeNegativeAmountSubjectNull() throws TransactionException {
        GenericTransaction t = new GenericTransaction(-1.0, new Date(), null, TransactionType.PAYMENT);
        this.commercialAccount.doWithdrawal(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoWithdrawalBadTypeNegativeAmountCreationDateNull() throws TransactionException {
        GenericTransaction t = new GenericTransaction(-1.0, null, "subject", TransactionType.PAYMENT);
        this.commercialAccount.doWithdrawal(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoWithdrawalBadTypeNegativeAmountCreationDateSubjectNull() throws TransactionException {
        GenericTransaction t = new GenericTransaction(-1.0, null, null, TransactionType.PAYMENT);
        this.commercialAccount.doWithdrawal(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoWithdrawalBadTypePositiveAmountSubjectNull() throws TransactionException {
        GenericTransaction t = new GenericTransaction(1.0, new Date(), null, TransactionType.PAYMENT);
        this.commercialAccount.doWithdrawal(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoWithdrawalBadTypePositiveAmountCreationDateNull() throws TransactionException {
        GenericTransaction t = new GenericTransaction(1.0, null, "subject", TransactionType.PAYMENT);
        this.commercialAccount.doWithdrawal(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoWithdrawalBadTypePositiveAmountCreationDateSubjectNull() throws TransactionException {
        GenericTransaction t = new GenericTransaction(1.0, null, null, TransactionType.PAYMENT);
        this.commercialAccount.doWithdrawal(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoDepositSubjectNull() throws TransactionException {
        GenericTransaction t = new GenericTransaction(0.0, new Date(), null, TransactionType.PAYMENT);
        this.commercialAccount.doDeposit(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoDepositCreationDateNull() throws TransactionException {
        GenericTransaction t = new GenericTransaction(0.0, null, "subject", TransactionType.PAYMENT);
        this.commercialAccount.doDeposit(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoDepositCreationDateSubjectNull() throws TransactionException {
        GenericTransaction t = new GenericTransaction(0.0, null, null, TransactionType.PAYMENT);
        this.commercialAccount.doDeposit(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoDepositNegativeAmountSubjectNull() throws TransactionException {
        GenericTransaction t = new GenericTransaction(-1.0, new Date(), null, TransactionType.PAYMENT);
        this.commercialAccount.doDeposit(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoDepositNegativeAmountCreationDateNull() throws TransactionException {
        GenericTransaction t = new GenericTransaction(-1.0, null, "subject", TransactionType.PAYMENT);
        this.commercialAccount.doDeposit(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoDepositNegativeAmountCreationDateSubjectNull() throws TransactionException {
        GenericTransaction t = new GenericTransaction(-1.0, null, null, TransactionType.PAYMENT);
        this.commercialAccount.doDeposit(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoDepositPositiveAmountSubjectNull() throws TransactionException {
        GenericTransaction t = new GenericTransaction(1.0, new Date(), null, TransactionType.PAYMENT);
        this.commercialAccount.doDeposit(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoDepositPositiveAmountCreationDateNull() throws TransactionException {
        GenericTransaction t = new GenericTransaction(1.0, null, "subject", TransactionType.PAYMENT);
        this.commercialAccount.doDeposit(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoDepositPositiveAmountCreationDateSubjectNull() throws TransactionException {
        GenericTransaction t = new GenericTransaction(1.0, null, null, TransactionType.PAYMENT);
        this.commercialAccount.doDeposit(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoDepositBadTypeSubjectNull() throws TransactionException {
        GenericTransaction t = new GenericTransaction(0.0, new Date(), null, TransactionType.CHARGE);
        this.commercialAccount.doDeposit(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoDepositBadTypeCreationDateNull() throws TransactionException {
        GenericTransaction t = new GenericTransaction(0.0, null, "subject", TransactionType.CHARGE);
        this.commercialAccount.doDeposit(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoDepositBadTypeCreationDateSubjectNull() throws TransactionException {
        GenericTransaction t = new GenericTransaction(0.0, null, null, TransactionType.CHARGE);
        this.commercialAccount.doDeposit(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoDepositBadTypeNegativeAmountSubjectNull() throws TransactionException {
        GenericTransaction t = new GenericTransaction(-1.0, new Date(), null, TransactionType.CHARGE);
        this.commercialAccount.doDeposit(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoDepositBadTypeNegativeAmountCreationDateNull() throws TransactionException {
        GenericTransaction t = new GenericTransaction(-1.0, null, "subject", TransactionType.CHARGE);
        this.commercialAccount.doDeposit(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoDepositBadTypeNegativeAmountCreationDateSubjectNull() throws TransactionException {
        GenericTransaction t = new GenericTransaction(-1.0, null, null, TransactionType.CHARGE);
        this.commercialAccount.doDeposit(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoDepositBadTypePositiveAmountSubjectNull() throws TransactionException {
        GenericTransaction t = new GenericTransaction(1.0, new Date(), null, TransactionType.CHARGE);
        this.commercialAccount.doDeposit(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoDepositBadTypePositiveAmountCreationDateNull() throws TransactionException {
        GenericTransaction t = new GenericTransaction(1.0, null, "subject", TransactionType.CHARGE);
        this.commercialAccount.doDeposit(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoDepositBadTypePositiveAmountCreationDateSubjectNull() throws TransactionException {
        GenericTransaction t = new GenericTransaction(1.0, null, null, TransactionType.CHARGE);
        this.commercialAccount.doDeposit(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoDepositNegativeAmount() throws TransactionException {
        GenericTransaction t = new GenericTransaction(-1.0, new Date(), "Subject", TransactionType.CHARGE);
        this.commercialAccount.doDeposit(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoDepositNegativeAmountBadType() throws TransactionException {
        GenericTransaction t = new GenericTransaction(-1.0, new Date(), "Subject", TransactionType.PAYMENT);
        this.commercialAccount.doDeposit(t);
    }

    @Test
    public void testDoDeposit() throws TransactionException {
        double amount = 10.0;
        GenericTransaction t = new GenericTransaction(amount, new Date(), "Salary", TransactionType.PAYMENT);
        t.setEffectiveDate(new Date(System.currentTimeMillis()));
        this.commercialAccount.doDeposit(t);
        assertEquals(amount, this.commercialAccount.getBalance(), EPSILON);
        t = new GenericTransaction(amount, new Date(), "Salary", TransactionType.PAYMENT);
        t.setEffectiveDate(new Date(System.currentTimeMillis()));
        this.commercialAccount.doDeposit(t);
        assertEquals(2 * amount, this.commercialAccount.getBalance(), EPSILON);
    }

    @Test
    public void testDoWithdrawal() throws TransactionException {
        double amountAdded = 100.0;
        GenericTransaction t = new GenericTransaction(amountAdded, new Date(), "Salary", TransactionType.PAYMENT);
        t.setEffectiveDate(new Date(System.currentTimeMillis()));
        this.commercialAccount.doDeposit(t);

        double amount = 10;
        t = new GenericTransaction(amount, new Date(), "Salary", TransactionType.CHARGE);
        t.setEffectiveDate(new Date(System.currentTimeMillis()));
        this.commercialAccount.doWithdrawal(t);
        assertEquals(-amount + amountAdded, this.commercialAccount.getBalance(), EPSILON);
        t = new GenericTransaction(amount, new Date(), "Salary", TransactionType.CHARGE);
        t.setEffectiveDate(new Date(System.currentTimeMillis()));
        this.commercialAccount.doWithdrawal(t);
        assertEquals(-2 * amount + amountAdded, this.commercialAccount.getBalance(), EPSILON);
    }

    @Test
    public void testGetID() throws MalformedHandlerException {
        Handler accountNumber = new AccountHandler(office.getIdOffice(), bank.getID(), this.accountNumber);
        assertTrue(accountNumber.compareTo(this.commercialAccount.getID()) == 0);
    }

    @Test
    public void testAccountHistory() throws TransactionException {
        double amount = 10.0;

        GenericTransaction t2 = new GenericTransaction(amount, new Date(), "Salary", TransactionType.PAYMENT);
        t2.setEffectiveDate(new Date(System.currentTimeMillis()));
        this.commercialAccount.doDeposit(t2);
        assertEquals(amount, this.commercialAccount.getBalance(), EPSILON);

        GenericTransaction t = new GenericTransaction(amount, new Date(), "Salary", TransactionType.CHARGE);
        t.setEffectiveDate(new Date(System.currentTimeMillis()));
        this.commercialAccount.doWithdrawal(t);
        assertEquals(0.0, this.commercialAccount.getBalance(), EPSILON);

        History history = this.commercialAccount.getHistory();;
        Iterator<GenericTransaction> it = history.getIterator(null);
        this.compareEntryAndGenericTransactionsWithAsserts(t2, it.next());
        this.compareEntryAndGenericTransactionsWithAsserts(t, it.next());

    }

    public void compareEntryAndGenericTransactionsWithAsserts(GenericTransaction t, GenericTransaction entry) {
        assertTrue(t.getSubject().equals(entry.getSubject()));
        assertTrue(t.getId().compareTo(entry.getId()) == 0);
        assertEquals(t.getAmount(), entry.getAmount(), EPSILON);
        assertTrue(t.getType() == entry.getType());
        assertTrue(t.getDate().compareTo(entry.getDate()) == 0);
        assertTrue(t.getEffectiveDate().compareTo(entry.getEffectiveDate()) == 0);
    }
}
