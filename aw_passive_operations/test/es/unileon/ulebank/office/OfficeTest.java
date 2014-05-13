/* Application developed for AW subject, belonging to passive operations
 group.*/
package es.unileon.ulebank.office;

import es.unileon.ulebank.account.Account;
import es.unileon.ulebank.exceptions.TransactionException;
import es.unileon.ulebank.bank.Bank;
import es.unileon.ulebank.handler.GenericHandler;
import es.unileon.ulebank.handler.Handler;
import es.unileon.ulebank.handler.MalformedHandlerException;
import es.unileon.ulebank.history.GenericTransaction;
import es.unileon.ulebank.history.Transaction;

import es.unileon.ulebank.transacionManager.TransactionManager;
import java.util.Date;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Revellado
 */
public class OfficeTest {

    private Office office;
    private Bank bank;
    private Account account;
    private TransactionManager manager;

    @Before
    public void setUp() throws MalformedHandlerException {

        this.manager = new TransactionManager();
        this.bank = new Bank(this.manager, new GenericHandler("1234"));
        this.office = new Office(new GenericHandler("1234"), this.bank);
        this.account = new Account(office, bank, "1234567890");
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

    /**
     * Test of doTransaction method, of class Office.
     *
     * @throws es.unileon.ulebank.handler.MalformedHandlerException
     */
    @Test
    public void testDoTransaction() throws TransactionException, MalformedHandlerException {

        this.office.addAccount(account);

        Transaction transaction = new GenericTransaction(2.0, new Date(), "Salary");

        transaction.setEffectiveDate(new Date());

        this.office.doTransaction(transaction, this.account.getID());

        assertEquals(this.account.getBalance(), 2.0, 2.0);
    }

    /**
     * Test throw of TransactionException in doTransaction method, of class
     * Office.
     *
     * @throws es.unileon.ulebank.handler.MalformedHandlerException
     */
    @Test(expected = TransactionException.class)
    public void testDoTransactionNullTransactionNullDestination() throws TransactionException, MalformedHandlerException {
        this.office.doTransaction(null, null);
    }

    @Test(expected = TransactionException.class)
    public void testDoTransactionNullDestination() throws TransactionException, MalformedHandlerException {
        Transaction transaction = new GenericTransaction(2.0, new Date(), "Salary");
        transaction.setEffectiveDate(new Date());
        this.office.doTransaction(transaction, null);
    }

    /**
     * Test throw of TransactionException in doTransaction method, of class
     * Office.
     *
     * @throws es.unileon.ulebank.handler.MalformedHandlerException
     */
    @Test(expected = TransactionException.class)
    public void testDoTransactionNullTransaction() throws TransactionException, MalformedHandlerException {

        this.office.doTransaction(null, this.account.getID());
    }

    @Test
    public void testLastNumberAccount() throws TransactionException, MalformedHandlerException {

        this.office.addAccount(account);

        assertEquals(this.office.getNewAccountNumber(), "1234567891", "1234567891");
    }
}
