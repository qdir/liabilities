/* Application developed for AW subject, belonging to passive operations
 group.*/
package es.unileon.ulebank.transacionManager;

import es.unileon.ulebank.account.Account;
import es.unileon.ulebank.exceptions.TransactionException;
import es.unileon.ulebank.bank.Bank;
import es.unileon.ulebank.handler.GenericHandler;
import es.unileon.ulebank.handler.MalformedHandlerException;
import es.unileon.ulebank.history.GenericTransaction;
import es.unileon.ulebank.history.Transaction;
import es.unileon.ulebank.office.Office;
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
public class TransactionManagerTest {

    private Bank bank;
    private TransactionManager manager;

    @Before
    public void setUp() throws MalformedHandlerException {

        this.manager = new TransactionManager();
        this.bank = new Bank(this.manager, new GenericHandler("1234"));
    }

    /**
     * Test of addBank method, of class TransactionManager.
     */
    @Test
    public void testAddBank() {

        assertTrue(this.manager.addBank(bank));
    }

    /**
     * Test of addBank method, of class TransactionManager.
     */
    @Test
    public void testAddBankRepeatedBank() {

        this.manager.addBank(bank);
        assertFalse(this.manager.addBank(bank));
    }

    /**
     * Test of addBank method, of class TransactionManager.
     */
    @Test
    public void testAddBankNullBank() {

        assertFalse(this.manager.addBank(null));
    }

    /**
     * Test of deleteBank method, of class TransactionManager.
     */
    @Test
    public void testDeleteBank() {

        this.manager.addBank(bank);
        assertTrue(this.manager.deleteBank(bank.getID()));
    }

    /**
     * Test of deleteBank method, of class TransactionManager.
     */
    @Test
    public void testDeleteBankNullBank() {

        assertFalse(this.manager.deleteBank(null));
    }

    /**
     * Test of deleteBank method, of class TransactionManager.
     *
     * @throws es.unileon.ulebank.handler.MalformedHandlerException
     */
    @Test
    public void testDeleteBankNotFoundBank() throws MalformedHandlerException {

        Bank bank = new Bank(this.manager, new GenericHandler("5678"));

        assertFalse(this.manager.deleteBank(bank.getID()));
    }

    /**
     * Test of doTransaction method, of class TransactionManager.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testDoTransaction() throws Exception {

        this.manager.addBank(this.bank);

        Office office = new Office(new GenericHandler("2345"), this.bank);
        this.bank.addOffice(office);

        Account account = new Account(office, this.bank, "1234567890");
        office.addAccount(account);

        Transaction transaction = new GenericTransaction(2.0, new Date(), "Salary");
        transaction.setEffectiveDate(new Date());

        this.manager.doTransaction(transaction, account.getID());

        assertEquals(account.getBalance(), 2.0, 2.0);
    }

    /**
     * Test throw of TransactionException in doTransaction method, of class
     * TransactionManager.
     *
     * @throws es.unileon.ulebank.handler.MalformedHandlerException
     */
    @Test(expected = TransactionException.class)
    public void testDoTransactionNullTransaction() throws TransactionException, MalformedHandlerException {
        Office office = new Office(new GenericHandler("2345"), this.bank);
        Account account = new Account(office, this.bank, "1234567890");
        this.manager.doTransaction(null, account.getID());
    }

    @Test(expected = TransactionException.class)
    public void testDoTransactionNullDestineNullTransaction() throws TransactionException, MalformedHandlerException {

        this.manager.doTransaction(null, null);
    }

    @Test(expected = TransactionException.class)
    public void testDoTransactionNullDestine() throws TransactionException, MalformedHandlerException {
        Transaction transaction = new GenericTransaction(2.0, new Date(), "Salary");
        this.manager.doTransaction(transaction, null);
    }

    /**
     * Test throw of TransactionException in doTransaction method, of class
     * TransactionManager.
     *
     * @throws es.unileon.ulebank.handler.MalformedHandlerException
     */
    @Test(expected = TransactionException.class)
    public void testDoTransactionBankNotFound() throws TransactionException, MalformedHandlerException {

        Office office = new Office(new GenericHandler("2345"), this.bank);

        Account account = new Account(office, this.bank, "1234567890");

        Transaction transaction = new GenericTransaction(2.0, new Date(), "Salary");

        this.manager.doTransaction(transaction, account.getID());
    }
}
