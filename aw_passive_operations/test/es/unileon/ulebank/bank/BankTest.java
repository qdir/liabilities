/* Application developed for AW subject, belonging to passive operations
 group.*/
package es.unileon.ulebank.bank;

import es.unileon.ulebank.account.Account;
import es.unileon.ulebank.exceptions.TransactionException;
import es.unileon.ulebank.handler.GenericHandler;
import es.unileon.ulebank.handler.Handler;
import es.unileon.ulebank.handler.MalformedHandlerException;
import es.unileon.ulebank.history.GenericTransaction;
import es.unileon.ulebank.history.Transaction;
import es.unileon.ulebank.office.Office;
import es.unileon.ulebank.transacionManager.TransactionManager;
import java.util.Date;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Revellado
 */
public class BankTest {

    private Bank bank;
    private Office office;
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

        assertTrue(this.bank.addOffice(office));
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

        assertFalse(this.bank.removeOffice(office.getIdOffice()));
    }

    /**
     * Test of doTransaction method, of class Bank.
     *
     * @throws es.unileon.ulebank.handler.MalformedHandlerException
     */
    @Test
    public void testDoTransaction() throws TransactionException, MalformedHandlerException {

        this.bank.addOffice(office);
        this.office.addAccount(account);

        Transaction transaction = new GenericTransaction(2.0, new Date(), "Salary");

        transaction.setEffectiveDate(new Date());

        this.bank.doTransaction(transaction, this.account.getID());

        assertEquals(this.account.getBalance(), 2.0, 2.0);
    }

    /**
     * Test throw of TransactionException in doTransaction method, of class
     * Bank.
     *
     * @throws es.unileon.ulebank.handler.MalformedHandlerException
     */
    @Test(expected = TransactionException.class)
    public void testDoTransactionNullDestination() throws TransactionException, MalformedHandlerException {

        this.bank.addOffice(office);
        this.office.addAccount(account);

        Transaction transaction = new GenericTransaction(2.0, new Date(), "Salary");

        this.bank.doTransaction(transaction, null);
    }

    /**
     * Test throw of TransactionException in doTransaction method, of class
     * Bank.
     *
     * @throws es.unileon.ulebank.handler.MalformedHandlerException
     */
    @Test(expected = TransactionException.class)
    public void testDoTransactionNotFoundOffice() throws TransactionException, MalformedHandlerException {

        Transaction transaction = new GenericTransaction(2.0, new Date(), "Salary");

        this.bank.doTransaction(transaction, this.account.getID());
    }
}
