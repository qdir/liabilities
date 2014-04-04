/* Application developed for AW subject, belonging to passive operations
 group.*/
package es.unileon.aw.account.types;

import es.unileon.ulebank.account.types.CommercialAccount;
import es.unileon.ulebank.account.Account;
import es.unileon.ulebank.account.exception.TransactionException;
import es.unileon.ulebank.account.handler.AccountHandler;
import es.unileon.ulebank.account.history.AccountEntry;
import es.unileon.ulebank.account.history.AccountHistory;
import es.unileon.ulebank.bank.Bank;
import es.unileon.ulebank.client.Client;
import es.unileon.ulebank.handler.GenericHandler;
import es.unileon.ulebank.handler.Handler;
import es.unileon.ulebank.handler.MalformedHandlerException;
import es.unileon.ulebank.history.GenericTransaction;
import es.unileon.ulebank.history.Transaction;
import es.unileon.ulebank.history.TransactionType;
import es.unileon.ulebank.office.Office;
import es.unileon.ulebank.transacionManager.TransactionManager;
import java.util.Date;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class CommercialAccountTest {

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
    private static final double EPSILON = 0.00001;

    private TransactionManager manager;

    private String accountNumber = "0000000000";

    @Before
    public void setUp() throws MalformedHandlerException {
        this.manager = new TransactionManager();
        this.bank = new Bank(manager, new GenericHandler("1234"));
        this.office = new Office(new GenericHandler("1234"), this.bank);
        this.commercialAccount = new CommercialAccount(this.office, this.bank, accountNumber);
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

    /**
     * Test of expected MalformedHandlerException throw for all cases.
     *
     * @throws es.unileon.aw.handler.MalformedHandlerException
     */
    @Test(expected = MalformedHandlerException.class)
    public void testMoreAccountnumberLength() throws MalformedHandlerException {
        this.commercialAccount = new CommercialAccount(this.office, this.bank, "000000000000");
    }

    @Test(expected = MalformedHandlerException.class)
    public void testLessAccountnumberLength() throws MalformedHandlerException {
        this.commercialAccount = new CommercialAccount(this.office, this.bank, "000000");
    }

    @Test(expected = MalformedHandlerException.class)
    public void testCorrectAccountnumberLengthInterspersedLetters() throws MalformedHandlerException {
        this.commercialAccount = new CommercialAccount(this.office, this.bank, "00aa00aa00");
    }

    @Test(expected = MalformedHandlerException.class)
    public void testCorrectLengthWithLetterIn1Character() throws MalformedHandlerException {
        new CommercialAccount(this.office, this.bank, "a000000000");
    }

    @Test(expected = MalformedHandlerException.class)
    public void testCorrectLengthWithLetterIn2Character() throws MalformedHandlerException {
        new CommercialAccount(this.office, this.bank, "0a00000000");
    }

    @Test(expected = MalformedHandlerException.class)
    public void testCorrectLengthWithLetterIn3Character() throws MalformedHandlerException {
        new CommercialAccount(this.office, this.bank, "00a0000000");
    }

    @Test(expected = MalformedHandlerException.class)
    public void testCorrectLengthWithLetterIn4Character() throws MalformedHandlerException {
        new CommercialAccount(this.office, this.bank, "000a000000");
    }

    @Test(expected = MalformedHandlerException.class)
    public void testCorrectLengthWithLetterIn5Character() throws MalformedHandlerException {
        new CommercialAccount(this.office, this.bank, "0000a00000");
    }

    @Test(expected = MalformedHandlerException.class)
    public void testCorrectLengthWithLetterIn6Character() throws MalformedHandlerException {
        new CommercialAccount(this.office, this.bank, "00000a0000");
    }

    @Test(expected = MalformedHandlerException.class)
    public void testCorrectLengthWithLetterIn7Character() throws MalformedHandlerException {
        new CommercialAccount(this.office, this.bank, "000000a000");
    }

    @Test(expected = MalformedHandlerException.class)
    public void testCorrectLengthWithLetterIn8Character() throws MalformedHandlerException {
        new CommercialAccount(this.office, this.bank, "0000000a00");
    }

    @Test(expected = MalformedHandlerException.class)
    public void testCorrectLengthWithLetterIn9Character() throws MalformedHandlerException {
        new CommercialAccount(this.office, this.bank, "00000000a0");
    }

    @Test(expected = MalformedHandlerException.class)
    public void testCorrectLengthWithLetterIn10Character() throws MalformedHandlerException {
        new CommercialAccount(this.office, this.bank, "000000000a");
    }

    @Test(expected = MalformedHandlerException.class)
    public void testMoreLengthWithLetterIn1Character() throws MalformedHandlerException {
        new CommercialAccount(this.office, this.bank, "a0000000000");
    }

    @Test(expected = MalformedHandlerException.class)
    public void testMoreLengthWithLetterIn2Character() throws MalformedHandlerException {
        new CommercialAccount(this.office, this.bank, "0a000000000");
    }

    @Test(expected = MalformedHandlerException.class)
    public void testMoreLengthWithLetterIn3Character() throws MalformedHandlerException {
        new CommercialAccount(this.office, this.bank, "00a00000000");
    }

    @Test(expected = MalformedHandlerException.class)
    public void testMoreLengthWithLetterIn4Character() throws MalformedHandlerException {
        new CommercialAccount(this.office, this.bank, "000a0000000");
    }

    @Test(expected = MalformedHandlerException.class)
    public void testMoreLengthWithLetterIn5Character() throws MalformedHandlerException {
        new CommercialAccount(this.office, this.bank, "0000a000000");
    }

    @Test(expected = MalformedHandlerException.class)
    public void testMoreLengthWithLetterIn6Character() throws MalformedHandlerException {
        new CommercialAccount(this.office, this.bank, "00000a00000");
    }

    @Test(expected = MalformedHandlerException.class)
    public void testMoreLengthWithLetterIn7Character() throws MalformedHandlerException {
        new CommercialAccount(this.office, this.bank, "000000a0000");
    }

    @Test(expected = MalformedHandlerException.class)
    public void testMoreLengthWithLetterIn8Character() throws MalformedHandlerException {
        new CommercialAccount(this.office, this.bank, "0000000a000");
    }

    @Test(expected = MalformedHandlerException.class)
    public void testMoreLengthWithLetterIn9Character() throws MalformedHandlerException {
        new CommercialAccount(this.office, this.bank, "00000000a00");
    }

    @Test(expected = MalformedHandlerException.class)
    public void testMoreLengthWithLetterIn10Character() throws MalformedHandlerException {
        new CommercialAccount(this.office, this.bank, "000000000a0");
    }

    @Test(expected = MalformedHandlerException.class)
    public void testMoreLengthWithLetterIn11Character() throws MalformedHandlerException {
        new CommercialAccount(this.office, this.bank, "0000000000a");
    }

    @Test(expected = MalformedHandlerException.class)
    public void testLessLengthWithLetterIn2Character() throws MalformedHandlerException {
        new CommercialAccount(this.office, this.bank, "a00000000");
    }

    @Test(expected = MalformedHandlerException.class)
    public void testLessLengthWithLetterIn3Character() throws MalformedHandlerException {
        new CommercialAccount(this.office, this.bank, "0a0000000");
    }

    @Test(expected = MalformedHandlerException.class)
    public void testLessLengthWithLetterIn4Character() throws MalformedHandlerException {
        new CommercialAccount(this.office, this.bank, "00a000000");
    }

    @Test(expected = MalformedHandlerException.class)
    public void testLessLengthWithLetterIn5Character() throws MalformedHandlerException {
        new CommercialAccount(this.office, this.bank, "000a00000");
    }

    @Test(expected = MalformedHandlerException.class)
    public void testLessLengthWithLetterIn6Character() throws MalformedHandlerException {
        new CommercialAccount(this.office, this.bank, "0000a0000");
    }

    @Test(expected = MalformedHandlerException.class)
    public void testLessLengthWithLetterIn7Character() throws MalformedHandlerException {
        new CommercialAccount(this.office, this.bank, "00000a000");
    }

    @Test(expected = MalformedHandlerException.class)
    public void testLessLengthWithLetterIn8Character() throws MalformedHandlerException {
        new CommercialAccount(this.office, this.bank, "000000a00");
    }

    @Test(expected = MalformedHandlerException.class)
    public void testLessLengthWithLetterIn9Character() throws MalformedHandlerException {
        new CommercialAccount(this.office, this.bank, "0000000a0");
    }

    @Test(expected = MalformedHandlerException.class)
    public void testLessLengthWithLetterIn10Character() throws MalformedHandlerException {
        new CommercialAccount(this.office, this.bank, "00000000a");
    }

    /**
     * Test of getBalance method, of class CommercialAccount.
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
        Transaction t = new GenericTransaction(this.titularHandler1, -1.0, new Date(), "Subject", TransactionType.CHARGE, titularHandler1);
        this.commercialAccount.doWithdrawal(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoWithdrawalNegativeAmountBadType() throws TransactionException {
        Transaction t = new GenericTransaction(this.titularHandler1, -1.0, new Date(), "Subject", TransactionType.PAYMENT, titularHandler1);
        this.commercialAccount.doWithdrawal(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoWithdrawalIDNull() throws TransactionException {
        Transaction t = new GenericTransaction(null, 0.0, new Date(), "Subject", TransactionType.CHARGE, titularHandler1);
        this.commercialAccount.doWithdrawal(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoWithdrawalSubjectNull() throws TransactionException {
        Transaction t = new GenericTransaction(titularHandler1, 0.0, new Date(), null, TransactionType.CHARGE, titularHandler1);
        this.commercialAccount.doWithdrawal(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoWithdrawalCreationDateNull() throws TransactionException {
        Transaction t = new GenericTransaction(titularHandler1, 0.0, null, "subject", TransactionType.CHARGE, titularHandler1);
        this.commercialAccount.doWithdrawal(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoWithdrawalDestineNull() throws TransactionException {
        Transaction t = new GenericTransaction(titularHandler1, 0.0, new Date(), "subject", TransactionType.CHARGE, null);
        this.commercialAccount.doWithdrawal(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoWithdrawalIDSubjectNull() throws TransactionException {
        Transaction t = new GenericTransaction(null, 0.0, new Date(), null, TransactionType.CHARGE, titularHandler1);
        this.commercialAccount.doWithdrawal(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoWithdrawalIDSubjectCreationDateNull() throws TransactionException {
        Transaction t = new GenericTransaction(null, 0.0, null, null, TransactionType.CHARGE, titularHandler1);
        this.commercialAccount.doWithdrawal(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoWithdrawalIDSubjectCreationDateDestineNull() throws TransactionException {
        Transaction t = new GenericTransaction(null, 0.0, null, null, TransactionType.CHARGE, null);
        this.commercialAccount.doWithdrawal(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoWithdrawalCreationDateSubjectNull() throws TransactionException {
        Transaction t = new GenericTransaction(this.authorizedHandler1, 0.0, null, null, TransactionType.CHARGE, titularHandler1);
        this.commercialAccount.doWithdrawal(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoWithdrawalCreationDateSubjectDestineNull() throws TransactionException {
        Transaction t = new GenericTransaction(this.authorizedHandler1, 0.0, null, null, TransactionType.CHARGE, null);
        this.commercialAccount.doWithdrawal(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoWithdrawalSubjectDestineNull() throws TransactionException {
        Transaction t = new GenericTransaction(this.authorizedHandler1, 0.0, new Date(), null, TransactionType.CHARGE, null);
        this.commercialAccount.doWithdrawal(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoWithdrawalNegativeAmountIDNull() throws TransactionException {
        Transaction t = new GenericTransaction(null, -1.0, new Date(), "Subject", TransactionType.CHARGE, titularHandler1);
        this.commercialAccount.doWithdrawal(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoWithdrawalNegativeAmountSubjectNull() throws TransactionException {
        Transaction t = new GenericTransaction(titularHandler1, -1.0, new Date(), null, TransactionType.CHARGE, titularHandler1);
        this.commercialAccount.doWithdrawal(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoWithdrawalNegativeAmountCreationDateNull() throws TransactionException {
        Transaction t = new GenericTransaction(titularHandler1, -1.0, null, "subject", TransactionType.CHARGE, titularHandler1);
        this.commercialAccount.doWithdrawal(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoWithdrawalNegativeAmountDestineNull() throws TransactionException {
        Transaction t = new GenericTransaction(titularHandler1, -1.0, new Date(), "subject", TransactionType.CHARGE, null);
        this.commercialAccount.doWithdrawal(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoWithdrawalNegativeAmountIDSubjectNull() throws TransactionException {
        Transaction t = new GenericTransaction(null, -1.0, new Date(), null, TransactionType.CHARGE, titularHandler1);
        this.commercialAccount.doWithdrawal(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoWithdrawalNegativeAmountIDSubjectCreationDateNull() throws TransactionException {
        Transaction t = new GenericTransaction(null, -1.0, null, null, TransactionType.CHARGE, titularHandler1);
        this.commercialAccount.doWithdrawal(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoWithdrawalNegativeAmountIDSubjectCreationDateDestineNull() throws TransactionException {
        Transaction t = new GenericTransaction(null, -1.0, null, null, TransactionType.CHARGE, null);
        this.commercialAccount.doWithdrawal(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoWithdrawalNegativeAmountCreationDateSubjectNull() throws TransactionException {
        Transaction t = new GenericTransaction(this.authorizedHandler1, -1.0, null, null, TransactionType.CHARGE, titularHandler1);
        this.commercialAccount.doWithdrawal(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoWithdrawalNegativeAmountCreationDateSubjectDestineNull() throws TransactionException {
        Transaction t = new GenericTransaction(this.authorizedHandler1, -1.0, null, null, TransactionType.CHARGE, null);
        this.commercialAccount.doWithdrawal(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoWithdrawalNegativeAmountSubjectDestineNull() throws TransactionException {
        Transaction t = new GenericTransaction(this.authorizedHandler1, -1.0, new Date(), null, TransactionType.CHARGE, null);
        this.commercialAccount.doWithdrawal(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoWithdrawalPositiveAmountIDNull() throws TransactionException {
        Transaction t = new GenericTransaction(null, 1.0, new Date(), "Subject", TransactionType.CHARGE, titularHandler1);
        this.commercialAccount.doWithdrawal(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoWithdrawalPositiveAmountSubjectNull() throws TransactionException {
        Transaction t = new GenericTransaction(titularHandler1, 1.0, new Date(), null, TransactionType.CHARGE, titularHandler1);
        this.commercialAccount.doWithdrawal(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoWithdrawalPositiveAmountCreationDateNull() throws TransactionException {
        Transaction t = new GenericTransaction(titularHandler1, 1.0, null, "subject", TransactionType.CHARGE, titularHandler1);
        this.commercialAccount.doWithdrawal(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoWithdrawalPositiveAmountDestineNull() throws TransactionException {
        Transaction t = new GenericTransaction(titularHandler1, 1.0, new Date(), "subject", TransactionType.CHARGE, null);
        this.commercialAccount.doWithdrawal(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoWithdrawalPositiveAmountIDSubjectNull() throws TransactionException {
        Transaction t = new GenericTransaction(null, 1.0, new Date(), null, TransactionType.CHARGE, titularHandler1);
        this.commercialAccount.doWithdrawal(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoWithdrawalPositiveAmountIDSubjectCreationDateNull() throws TransactionException {
        Transaction t = new GenericTransaction(null, 1.0, null, null, TransactionType.CHARGE, titularHandler1);
        this.commercialAccount.doWithdrawal(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoWithdrawalPositiveAmountIDSubjectCreationDateDestineNull() throws TransactionException {
        Transaction t = new GenericTransaction(null, 1.0, null, null, TransactionType.CHARGE, null);
        this.commercialAccount.doWithdrawal(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoWithdrawalPositiveAmountCreationDateSubjectNull() throws TransactionException {
        Transaction t = new GenericTransaction(this.authorizedHandler1, 1.0, null, null, TransactionType.CHARGE, titularHandler1);
        this.commercialAccount.doWithdrawal(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoWithdrawalPositiveAmountCreationDateSubjectDestineNull() throws TransactionException {
        Transaction t = new GenericTransaction(this.authorizedHandler1, 1.0, null, null, TransactionType.CHARGE, null);
        this.commercialAccount.doWithdrawal(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoWithdrawalPositiveAmountSubjectDestineNull() throws TransactionException {
        Transaction t = new GenericTransaction(this.authorizedHandler1, 1.0, new Date(), null, TransactionType.CHARGE, null);
        this.commercialAccount.doWithdrawal(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoWithdrawalBadTypeIDNull() throws TransactionException {
        Transaction t = new GenericTransaction(null, 0.0, new Date(), "Subject", TransactionType.PAYMENT, titularHandler1);
        this.commercialAccount.doWithdrawal(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoWithdrawalBadTypeSubjectNull() throws TransactionException {
        Transaction t = new GenericTransaction(titularHandler1, 0.0, new Date(), null, TransactionType.PAYMENT, titularHandler1);
        this.commercialAccount.doWithdrawal(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoWithdrawalBadTypeCreationDateNull() throws TransactionException {
        Transaction t = new GenericTransaction(titularHandler1, 0.0, null, "subject", TransactionType.PAYMENT, titularHandler1);
        this.commercialAccount.doWithdrawal(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoWithdrawalBadTypeDestineNull() throws TransactionException {
        Transaction t = new GenericTransaction(titularHandler1, 0.0, new Date(), "subject", TransactionType.PAYMENT, null);
        this.commercialAccount.doWithdrawal(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoWithdrawalBadTypeIDSubjectNull() throws TransactionException {
        Transaction t = new GenericTransaction(null, 0.0, new Date(), null, TransactionType.PAYMENT, titularHandler1);
        this.commercialAccount.doWithdrawal(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoWithdrawalBadTypeIDSubjectCreationDateNull() throws TransactionException {
        Transaction t = new GenericTransaction(null, 0.0, null, null, TransactionType.PAYMENT, titularHandler1);
        this.commercialAccount.doWithdrawal(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoWithdrawalBadTypeIDSubjectCreationDateDestineNull() throws TransactionException {
        Transaction t = new GenericTransaction(null, 0.0, null, null, TransactionType.PAYMENT, null);
        this.commercialAccount.doWithdrawal(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoWithdrawalBadTypeCreationDateSubjectNull() throws TransactionException {
        Transaction t = new GenericTransaction(this.authorizedHandler1, 0.0, null, null, TransactionType.PAYMENT, titularHandler1);
        this.commercialAccount.doWithdrawal(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoWithdrawalBadTypeCreationDateSubjectDestineNull() throws TransactionException {
        Transaction t = new GenericTransaction(this.authorizedHandler1, 0.0, null, null, TransactionType.PAYMENT, null);
        this.commercialAccount.doWithdrawal(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoWithdrawalBadTypeSubjectDestineNull() throws TransactionException {
        Transaction t = new GenericTransaction(this.authorizedHandler1, 0.0, new Date(), null, TransactionType.PAYMENT, null);
        this.commercialAccount.doWithdrawal(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoWithdrawalBadTypeNegativeAmountIDNull() throws TransactionException {
        Transaction t = new GenericTransaction(null, -1.0, new Date(), "Subject", TransactionType.PAYMENT, titularHandler1);
        this.commercialAccount.doWithdrawal(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoWithdrawalBadTypeNegativeAmountSubjectNull() throws TransactionException {
        Transaction t = new GenericTransaction(titularHandler1, -1.0, new Date(), null, TransactionType.PAYMENT, titularHandler1);
        this.commercialAccount.doWithdrawal(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoWithdrawalBadTypeNegativeAmountCreationDateNull() throws TransactionException {
        Transaction t = new GenericTransaction(titularHandler1, -1.0, null, "subject", TransactionType.PAYMENT, titularHandler1);
        this.commercialAccount.doWithdrawal(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoWithdrawalBadTypeNegativeAmountDestineNull() throws TransactionException {
        Transaction t = new GenericTransaction(titularHandler1, -1.0, new Date(), "subject", TransactionType.PAYMENT, null);
        this.commercialAccount.doWithdrawal(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoWithdrawalBadTypeNegativeAmountIDSubjectNull() throws TransactionException {
        Transaction t = new GenericTransaction(null, -1.0, new Date(), null, TransactionType.PAYMENT, titularHandler1);
        this.commercialAccount.doWithdrawal(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoWithdrawalBadTypeNegativeAmountIDSubjectCreationDateNull() throws TransactionException {
        Transaction t = new GenericTransaction(null, -1.0, null, null, TransactionType.PAYMENT, titularHandler1);
        this.commercialAccount.doWithdrawal(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoWithdrawalBadTypeNegativeAmountIDSubjectCreationDateDestineNull() throws TransactionException {
        Transaction t = new GenericTransaction(null, -1.0, null, null, TransactionType.PAYMENT, null);
        this.commercialAccount.doWithdrawal(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoWithdrawalBadTypeNegativeAmountCreationDateSubjectNull() throws TransactionException {
        Transaction t = new GenericTransaction(this.authorizedHandler1, -1.0, null, null, TransactionType.PAYMENT, titularHandler1);
        this.commercialAccount.doWithdrawal(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoWithdrawalBadTypeNegativeAmountCreationDateSubjectDestineNull() throws TransactionException {
        Transaction t = new GenericTransaction(this.authorizedHandler1, -1.0, null, null, TransactionType.PAYMENT, null);
        this.commercialAccount.doWithdrawal(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoWithdrawalBadTypeNegativeAmountSubjectDestineNull() throws TransactionException {
        Transaction t = new GenericTransaction(this.authorizedHandler1, -1.0, new Date(), null, TransactionType.PAYMENT, null);
        this.commercialAccount.doWithdrawal(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoWithdrawalBadTypePositiveAmountIDNull() throws TransactionException {
        Transaction t = new GenericTransaction(null, 1.0, new Date(), "Subject", TransactionType.PAYMENT, titularHandler1);
        this.commercialAccount.doWithdrawal(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoWithdrawalBadTypePositiveAmountSubjectNull() throws TransactionException {
        Transaction t = new GenericTransaction(titularHandler1, 1.0, new Date(), null, TransactionType.PAYMENT, titularHandler1);
        this.commercialAccount.doWithdrawal(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoWithdrawalBadTypePositiveAmountCreationDateNull() throws TransactionException {
        Transaction t = new GenericTransaction(titularHandler1, 1.0, null, "subject", TransactionType.PAYMENT, titularHandler1);
        this.commercialAccount.doWithdrawal(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoWithdrawalBadTypePositiveAmountDestineNull() throws TransactionException {
        Transaction t = new GenericTransaction(titularHandler1, 1.0, new Date(), "subject", TransactionType.PAYMENT, null);
        this.commercialAccount.doWithdrawal(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoWithdrawalBadTypePositiveAmountIDSubjectNull() throws TransactionException {
        Transaction t = new GenericTransaction(null, 1.0, new Date(), null, TransactionType.PAYMENT, titularHandler1);
        this.commercialAccount.doWithdrawal(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoWithdrawalBadTypePositiveAmountIDSubjectCreationDateNull() throws TransactionException {
        Transaction t = new GenericTransaction(null, 1.0, null, null, TransactionType.PAYMENT, titularHandler1);
        this.commercialAccount.doWithdrawal(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoWithdrawalBadTypePositiveAmountIDSubjectCreationDateDestineNull() throws TransactionException {
        Transaction t = new GenericTransaction(null, 1.0, null, null, TransactionType.PAYMENT, null);
        this.commercialAccount.doWithdrawal(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoWithdrawalBadTypePositiveAmountCreationDateSubjectNull() throws TransactionException {
        Transaction t = new GenericTransaction(this.authorizedHandler1, 1.0, null, null, TransactionType.PAYMENT, titularHandler1);
        this.commercialAccount.doWithdrawal(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoWithdrawalBadTypePositiveAmountCreationDateSubjectDestineNull() throws TransactionException {
        Transaction t = new GenericTransaction(this.authorizedHandler1, 1.0, null, null, TransactionType.PAYMENT, null);
        this.commercialAccount.doWithdrawal(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoWithdrawalBadTypePositiveAmountSubjectDestineNull() throws TransactionException {
        Transaction t = new GenericTransaction(this.authorizedHandler1, 1.0, new Date(), null, TransactionType.PAYMENT, null);
        this.commercialAccount.doWithdrawal(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoDepositIDNull() throws TransactionException {
        Transaction t = new GenericTransaction(null, 0.0, new Date(), "Subject", TransactionType.PAYMENT, titularHandler1);
        this.commercialAccount.doDeposit(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoDepositSubjectNull() throws TransactionException {
        Transaction t = new GenericTransaction(titularHandler1, 0.0, new Date(), null, TransactionType.PAYMENT, titularHandler1);
        this.commercialAccount.doDeposit(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoDepositCreationDateNull() throws TransactionException {
        Transaction t = new GenericTransaction(titularHandler1, 0.0, null, "subject", TransactionType.PAYMENT, titularHandler1);
        this.commercialAccount.doDeposit(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoDepositDestineNull() throws TransactionException {
        Transaction t = new GenericTransaction(titularHandler1, 0.0, new Date(), "subject", TransactionType.PAYMENT, null);
        this.commercialAccount.doDeposit(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoDepositIDSubjectNull() throws TransactionException {
        Transaction t = new GenericTransaction(null, 0.0, new Date(), null, TransactionType.PAYMENT, titularHandler1);
        this.commercialAccount.doDeposit(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoDepositIDSubjectCreationDateNull() throws TransactionException {
        Transaction t = new GenericTransaction(null, 0.0, null, null, TransactionType.PAYMENT, titularHandler1);
        this.commercialAccount.doDeposit(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoDepositIDSubjectCreationDateDestineNull() throws TransactionException {
        Transaction t = new GenericTransaction(null, 0.0, null, null, TransactionType.PAYMENT, null);
        this.commercialAccount.doDeposit(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoDepositCreationDateSubjectNull() throws TransactionException {
        Transaction t = new GenericTransaction(this.authorizedHandler1, 0.0, null, null, TransactionType.PAYMENT, titularHandler1);
        this.commercialAccount.doDeposit(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoDepositCreationDateSubjectDestineNull() throws TransactionException {
        Transaction t = new GenericTransaction(this.authorizedHandler1, 0.0, null, null, TransactionType.PAYMENT, null);
        this.commercialAccount.doDeposit(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoDepositSubjectDestineNull() throws TransactionException {
        Transaction t = new GenericTransaction(this.authorizedHandler1, 0.0, new Date(), null, TransactionType.PAYMENT, null);
        this.commercialAccount.doDeposit(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoDepositNegativeAmountIDNull() throws TransactionException {
        Transaction t = new GenericTransaction(null, -1.0, new Date(), "Subject", TransactionType.PAYMENT, titularHandler1);
        this.commercialAccount.doDeposit(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoDepositNegativeAmountSubjectNull() throws TransactionException {
        Transaction t = new GenericTransaction(titularHandler1, -1.0, new Date(), null, TransactionType.PAYMENT, titularHandler1);
        this.commercialAccount.doDeposit(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoDepositNegativeAmountCreationDateNull() throws TransactionException {
        Transaction t = new GenericTransaction(titularHandler1, -1.0, null, "subject", TransactionType.PAYMENT, titularHandler1);
        this.commercialAccount.doDeposit(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoDepositNegativeAmountDestineNull() throws TransactionException {
        Transaction t = new GenericTransaction(titularHandler1, -1.0, new Date(), "subject", TransactionType.PAYMENT, null);
        this.commercialAccount.doDeposit(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoDepositNegativeAmountIDSubjectNull() throws TransactionException {
        Transaction t = new GenericTransaction(null, -1.0, new Date(), null, TransactionType.PAYMENT, titularHandler1);
        this.commercialAccount.doDeposit(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoDepositNegativeAmountIDSubjectCreationDateNull() throws TransactionException {
        Transaction t = new GenericTransaction(null, -1.0, null, null, TransactionType.PAYMENT, titularHandler1);
        this.commercialAccount.doDeposit(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoDepositNegativeAmountIDSubjectCreationDateDestineNull() throws TransactionException {
        Transaction t = new GenericTransaction(null, -1.0, null, null, TransactionType.PAYMENT, null);
        this.commercialAccount.doDeposit(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoDepositNegativeAmountCreationDateSubjectNull() throws TransactionException {
        Transaction t = new GenericTransaction(this.authorizedHandler1, -1.0, null, null, TransactionType.PAYMENT, titularHandler1);
        this.commercialAccount.doDeposit(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoDepositNegativeAmountCreationDateSubjectDestineNull() throws TransactionException {
        Transaction t = new GenericTransaction(this.authorizedHandler1, -1.0, null, null, TransactionType.PAYMENT, null);
        this.commercialAccount.doDeposit(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoDepositNegativeAmountSubjectDestineNull() throws TransactionException {
        Transaction t = new GenericTransaction(this.authorizedHandler1, -1.0, new Date(), null, TransactionType.PAYMENT, null);
        this.commercialAccount.doDeposit(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoDepositPositiveAmountIDNull() throws TransactionException {
        Transaction t = new GenericTransaction(null, 1.0, new Date(), "Subject", TransactionType.PAYMENT, titularHandler1);
        this.commercialAccount.doDeposit(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoDepositPositiveAmountSubjectNull() throws TransactionException {
        Transaction t = new GenericTransaction(titularHandler1, 1.0, new Date(), null, TransactionType.PAYMENT, titularHandler1);
        this.commercialAccount.doDeposit(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoDepositPositiveAmountCreationDateNull() throws TransactionException {
        Transaction t = new GenericTransaction(titularHandler1, 1.0, null, "subject", TransactionType.PAYMENT, titularHandler1);
        this.commercialAccount.doDeposit(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoDepositPositiveAmountDestineNull() throws TransactionException {
        Transaction t = new GenericTransaction(titularHandler1, 1.0, new Date(), "subject", TransactionType.PAYMENT, null);
        this.commercialAccount.doDeposit(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoDepositPositiveAmountIDSubjectNull() throws TransactionException {
        Transaction t = new GenericTransaction(null, 1.0, new Date(), null, TransactionType.PAYMENT, titularHandler1);
        this.commercialAccount.doDeposit(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoDepositPositiveAmountIDSubjectCreationDateNull() throws TransactionException {
        Transaction t = new GenericTransaction(null, 1.0, null, null, TransactionType.PAYMENT, titularHandler1);
        this.commercialAccount.doDeposit(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoDepositPositiveAmountIDSubjectCreationDateDestineNull() throws TransactionException {
        Transaction t = new GenericTransaction(null, 1.0, null, null, TransactionType.PAYMENT, null);
        this.commercialAccount.doDeposit(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoDepositPositiveAmountCreationDateSubjectNull() throws TransactionException {
        Transaction t = new GenericTransaction(this.authorizedHandler1, 1.0, null, null, TransactionType.PAYMENT, titularHandler1);
        this.commercialAccount.doDeposit(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoDepositPositiveAmountCreationDateSubjectDestineNull() throws TransactionException {
        Transaction t = new GenericTransaction(this.authorizedHandler1, 1.0, null, null, TransactionType.PAYMENT, null);
        this.commercialAccount.doDeposit(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoDepositPositiveAmountSubjectDestineNull() throws TransactionException {
        Transaction t = new GenericTransaction(this.authorizedHandler1, 1.0, new Date(), null, TransactionType.PAYMENT, null);
        this.commercialAccount.doDeposit(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoDepositBadTypeIDNull() throws TransactionException {
        Transaction t = new GenericTransaction(null, 0.0, new Date(), "Subject", TransactionType.CHARGE, titularHandler1);
        this.commercialAccount.doDeposit(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoDepositBadTypeSubjectNull() throws TransactionException {
        Transaction t = new GenericTransaction(titularHandler1, 0.0, new Date(), null, TransactionType.CHARGE, titularHandler1);
        this.commercialAccount.doDeposit(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoDepositBadTypeCreationDateNull() throws TransactionException {
        Transaction t = new GenericTransaction(titularHandler1, 0.0, null, "subject", TransactionType.CHARGE, titularHandler1);
        this.commercialAccount.doDeposit(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoDepositBadTypeDestineNull() throws TransactionException {
        Transaction t = new GenericTransaction(titularHandler1, 0.0, new Date(), "subject", TransactionType.CHARGE, null);
        this.commercialAccount.doDeposit(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoDepositBadTypeIDSubjectNull() throws TransactionException {
        Transaction t = new GenericTransaction(null, 0.0, new Date(), null, TransactionType.CHARGE, titularHandler1);
        this.commercialAccount.doDeposit(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoDepositBadTypeIDSubjectCreationDateNull() throws TransactionException {
        Transaction t = new GenericTransaction(null, 0.0, null, null, TransactionType.CHARGE, titularHandler1);
        this.commercialAccount.doDeposit(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoDepositBadTypeIDSubjectCreationDateDestineNull() throws TransactionException {
        Transaction t = new GenericTransaction(null, 0.0, null, null, TransactionType.CHARGE, null);
        this.commercialAccount.doDeposit(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoDepositBadTypeCreationDateSubjectNull() throws TransactionException {
        Transaction t = new GenericTransaction(this.authorizedHandler1, 0.0, null, null, TransactionType.CHARGE, titularHandler1);
        this.commercialAccount.doDeposit(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoDepositBadTypeCreationDateSubjectDestineNull() throws TransactionException {
        Transaction t = new GenericTransaction(this.authorizedHandler1, 0.0, null, null, TransactionType.CHARGE, null);
        this.commercialAccount.doDeposit(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoDepositBadTypeSubjectDestineNull() throws TransactionException {
        Transaction t = new GenericTransaction(this.authorizedHandler1, 0.0, new Date(), null, TransactionType.CHARGE, null);
        this.commercialAccount.doDeposit(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoDepositBadTypeNegativeAmountIDNull() throws TransactionException {
        Transaction t = new GenericTransaction(null, -1.0, new Date(), "Subject", TransactionType.CHARGE, titularHandler1);
        this.commercialAccount.doDeposit(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoDepositBadTypeNegativeAmountSubjectNull() throws TransactionException {
        Transaction t = new GenericTransaction(titularHandler1, -1.0, new Date(), null, TransactionType.CHARGE, titularHandler1);
        this.commercialAccount.doDeposit(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoDepositBadTypeNegativeAmountCreationDateNull() throws TransactionException {
        Transaction t = new GenericTransaction(titularHandler1, -1.0, null, "subject", TransactionType.CHARGE, titularHandler1);
        this.commercialAccount.doDeposit(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoDepositBadTypeNegativeAmountDestineNull() throws TransactionException {
        Transaction t = new GenericTransaction(titularHandler1, -1.0, new Date(), "subject", TransactionType.CHARGE, null);
        this.commercialAccount.doDeposit(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoDepositBadTypeNegativeAmountIDSubjectNull() throws TransactionException {
        Transaction t = new GenericTransaction(null, -1.0, new Date(), null, TransactionType.CHARGE, titularHandler1);
        this.commercialAccount.doDeposit(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoDepositBadTypeNegativeAmountIDSubjectCreationDateNull() throws TransactionException {
        Transaction t = new GenericTransaction(null, -1.0, null, null, TransactionType.CHARGE, titularHandler1);
        this.commercialAccount.doDeposit(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoDepositBadTypeNegativeAmountIDSubjectCreationDateDestineNull() throws TransactionException {
        Transaction t = new GenericTransaction(null, -1.0, null, null, TransactionType.CHARGE, null);
        this.commercialAccount.doDeposit(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoDepositBadTypeNegativeAmountCreationDateSubjectNull() throws TransactionException {
        Transaction t = new GenericTransaction(this.authorizedHandler1, -1.0, null, null, TransactionType.CHARGE, titularHandler1);
        this.commercialAccount.doDeposit(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoDepositBadTypeNegativeAmountCreationDateSubjectDestineNull() throws TransactionException {
        Transaction t = new GenericTransaction(this.authorizedHandler1, -1.0, null, null, TransactionType.CHARGE, null);
        this.commercialAccount.doDeposit(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoDepositBadTypeNegativeAmountSubjectDestineNull() throws TransactionException {
        Transaction t = new GenericTransaction(this.authorizedHandler1, -1.0, new Date(), null, TransactionType.CHARGE, null);
        this.commercialAccount.doDeposit(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoDepositBadTypePositiveAmountIDNull() throws TransactionException {
        Transaction t = new GenericTransaction(null, 1.0, new Date(), "Subject", TransactionType.CHARGE, titularHandler1);
        this.commercialAccount.doDeposit(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoDepositBadTypePositiveAmountSubjectNull() throws TransactionException {
        Transaction t = new GenericTransaction(titularHandler1, 1.0, new Date(), null, TransactionType.CHARGE, titularHandler1);
        this.commercialAccount.doDeposit(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoDepositBadTypePositiveAmountCreationDateNull() throws TransactionException {
        Transaction t = new GenericTransaction(titularHandler1, 1.0, null, "subject", TransactionType.CHARGE, titularHandler1);
        this.commercialAccount.doDeposit(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoDepositBadTypePositiveAmountDestineNull() throws TransactionException {
        Transaction t = new GenericTransaction(titularHandler1, 1.0, new Date(), "subject", TransactionType.CHARGE, null);
        this.commercialAccount.doDeposit(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoDepositBadTypePositiveAmountIDSubjectNull() throws TransactionException {
        Transaction t = new GenericTransaction(null, 1.0, new Date(), null, TransactionType.CHARGE, titularHandler1);
        this.commercialAccount.doDeposit(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoDepositBadTypePositiveAmountIDSubjectCreationDateNull() throws TransactionException {
        Transaction t = new GenericTransaction(null, 1.0, null, null, TransactionType.CHARGE, titularHandler1);
        this.commercialAccount.doDeposit(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoDepositBadTypePositiveAmountIDSubjectCreationDateDestineNull() throws TransactionException {
        Transaction t = new GenericTransaction(null, 1.0, null, null, TransactionType.CHARGE, null);
        this.commercialAccount.doDeposit(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoDepositBadTypePositiveAmountCreationDateSubjectNull() throws TransactionException {
        Transaction t = new GenericTransaction(this.authorizedHandler1, 1.0, null, null, TransactionType.CHARGE, titularHandler1);
        this.commercialAccount.doDeposit(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoDepositBadTypePositiveAmountCreationDateSubjectDestineNull() throws TransactionException {
        Transaction t = new GenericTransaction(this.authorizedHandler1, 1.0, null, null, TransactionType.CHARGE, null);
        this.commercialAccount.doDeposit(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoDepositBadTypePositiveAmountSubjectDestineNull() throws TransactionException {
        Transaction t = new GenericTransaction(this.authorizedHandler1, 1.0, new Date(), null, TransactionType.CHARGE, null);
        this.commercialAccount.doDeposit(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoDepositNegativeAmount() throws TransactionException {
        Transaction t = new GenericTransaction(this.titularHandler1, -1.0, new Date(), "Subject", TransactionType.CHARGE, titularHandler1);
        this.commercialAccount.doDeposit(t);
    }

    @Test(expected = TransactionException.class)
    public void testDoDepositNegativeAmountBadType() throws TransactionException {
        Transaction t = new GenericTransaction(this.titularHandler1, -1.0, new Date(), "Subject", TransactionType.PAYMENT, titularHandler1);
        this.commercialAccount.doDeposit(t);
    }

    @Test
    public void testDoDeposit() throws TransactionException {
        double amount = 10.0;
        Transaction t = new GenericTransaction(new GenericHandler("1234"), amount, new Date(), "Salary", TransactionType.PAYMENT, this.commercialAccount.getID());
        this.commercialAccount.doDeposit(t);
        assertEquals(amount, this.commercialAccount.getBalance(), EPSILON);

        t = new GenericTransaction(new GenericHandler("1234"), amount, new Date(), "Salary", TransactionType.PAYMENT, this.commercialAccount.getID());
        this.commercialAccount.doDeposit(t);
        assertEquals(2 * amount, this.commercialAccount.getBalance(), EPSILON);
    }

    @Test
    public void testDoWithdrawal() throws TransactionException {
        double amount = 10.0;
        Transaction t = new GenericTransaction(new GenericHandler("1234"), amount, new Date(), "Salary", TransactionType.CHARGE, this.commercialAccount.getID());
        this.commercialAccount.doWithdrawal(t);
        assertEquals(-amount, this.commercialAccount.getBalance(), EPSILON);

        t = new GenericTransaction(new GenericHandler("1234"), amount, new Date(), "Salary", TransactionType.CHARGE, this.commercialAccount.getID());
        this.commercialAccount.doWithdrawal(t);
        assertEquals(-2 * amount, this.commercialAccount.getBalance(), EPSILON);
    }

    @Test
    public void testGetID() throws MalformedHandlerException {
        Handler accountNumber = new AccountHandler(office.getID(), bank.getID(), this.accountNumber);
        assertTrue(accountNumber.compareTo(this.commercialAccount.getID()) == 0);
    }

    @Test
    public void testAccountHistory() throws TransactionException {
        double amount = 10.0;
        Transaction t = new GenericTransaction(new GenericHandler("1234"), amount, new Date(), "Salary", TransactionType.CHARGE, this.commercialAccount.getID());
        this.commercialAccount.doWithdrawal(t);
        assertEquals(-amount, this.commercialAccount.getBalance(), EPSILON);

        Transaction t2 = new GenericTransaction(new GenericHandler("1234"), amount, new Date(), "Salary", TransactionType.PAYMENT, this.commercialAccount.getID());
        this.commercialAccount.doDeposit(t2);
        assertEquals(0.0, this.commercialAccount.getBalance(), EPSILON);

        AccountHistory history = this.commercialAccount.getHistory();
        List<AccountEntry> entries = history.getHistory();
        this.compareEntryAndTransactionsWithAsserts(t, entries.get(0));
        this.compareEntryAndTransactionsWithAsserts(t2, entries.get(1));
    }

    public void compareEntryAndTransactionsWithAsserts(Transaction t, AccountEntry entry) {
        assertTrue(t.getSubject().equals(entry.getSubject()));
        assertTrue(t.getId().compareTo(entry.getMovementID()) == 0);
        assertEquals(t.getAmount(), entry.getAmount(), EPSILON);
        assertTrue(t.getType() == entry.getType());
        assertTrue(t.getDate().compareTo(entry.getCreationDate()) == 0);
        assertTrue(t.getEffectiveDate().compareTo(entry.getEffectiveDate()) == 0);
    }
}
