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
import es.unileon.ulebank.history.TransactionType;
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
        
        System.out.println("addBank");
           
        assertTrue(this.manager.addBank(bank));
    }

    /**
     * Test of addBank method, of class TransactionManager.
     */
    @Test
    public void testAddBankRepeatedBank() {
        
        System.out.println("addBankRepeatedBank");
        
        this.manager.addBank(bank);
        assertFalse(this.manager.addBank(bank));
    }
    
    /**
     * Test of addBank method, of class TransactionManager.
     */
    @Test
    public void testAddBankNullBank() {
        
        System.out.println("addBankNullBank");
        
        assertFalse(this.manager.addBank(null));
    }
    
    /**
     * Test of deleteBank method, of class TransactionManager.
     */
    @Test
    public void testDeleteBank() {
        
        System.out.println("deleteBank");
        
        this.manager.addBank(bank);
        assertTrue(this.manager.deleteBank(bank.getID()));
    }

    /**
     * Test of deleteBank method, of class TransactionManager.
     */
    @Test
    public void testDeleteBankNullBank() {
        
        System.out.println("deleteBankNullBank");
        
        assertFalse(this.manager.deleteBank(null));
    }
    
     /**
     * Test of deleteBank method, of class TransactionManager.
     * @throws es.unileon.ulebank.handler.MalformedHandlerException
     */
    @Test
    public void testDeleteBankNotFoundBank() throws MalformedHandlerException {
        
        System.out.println("deleteBankNotFoundBank");
        
        Bank bank = new Bank(this.manager, new GenericHandler("5678"));
        
        assertFalse(this.manager.deleteBank(bank.getID()));
    }
    
    
    /**
     * Test of doTransaction method, of class TransactionManager.
     * @throws java.lang.Exception
     */
    @Test
    public void testDoTransaction() throws Exception {
        
        System.out.println("doTransaction");
        
        this.manager.addBank(this.bank);
        
        Office office = new Office(new GenericHandler("2345"), this.bank);
        this.bank.addOffice(office);
        
        Account account = new Account(office, this.bank, "1234567890");
        office.addAccount(account);
        
        Transaction transaction = new GenericTransaction( 2.0, new Date(), "Salary", TransactionType.PAYMENT);
        transaction.setEffectiveDate(new Date());
        
        this.manager.doTransaction(transaction,account.getID());
        
        assertEquals(account.getBalance(), 2.0, 2.0);
    }
    
    /**
    * Test throw of TransactionException in doTransaction method, of class TransactionManager.
     * @throws es.unileon.ulebank.handler.MalformedHandlerException
    */
    @Test (expected = TransactionException.class)
    public void testDoTransactionNullTransaction() throws TransactionException, MalformedHandlerException {
        
        System.out.println("doTransactionNullTransaction");
  
        this.manager.doTransaction(null,null);
    }
    
    /**
    * Test throw of TransactionException in doTransaction method, of class TransactionManager.
     * @throws es.unileon.ulebank.handler.MalformedHandlerException
    */
    @Test (expected = TransactionException.class)
    public void testDoTransactionBankNotFound() throws TransactionException, MalformedHandlerException {
        
        System.out.println("doTransactionNotFoundBank");
        
        Office office = new Office(new GenericHandler("2345"), this.bank);
        
        Account account = new Account(office, this.bank, "1234567890");
        
        Transaction transaction = new GenericTransaction( 2.0, new Date(), "Salary", TransactionType.PAYMENT);
        
        this.manager.doTransaction(transaction, account.getID());
    }
    
    @Test(expected = TransactionException.class)
    public void testDoTransactionNegativeAmount() throws TransactionException, MalformedHandlerException {
        Office office = new Office(new GenericHandler("2345"), this.bank);
        Account account = new Account(office, this.bank, "1234567890");
        Transaction transaction = new GenericTransaction(-1.0, new Date(), "Subject", TransactionType.CHARGE);
        this.manager.doTransaction(transaction, account.getID());
    }

    @Test(expected = TransactionException.class)
    public void testDoWithdrawalNegativeAmountBadType() throws TransactionException, MalformedHandlerException{
        Office office = new Office(new GenericHandler("2345"), this.bank);
        Account account = new Account(office, this.bank, "1234567890");
        Transaction transaction = new GenericTransaction(-1.0, new Date(), "Subject", TransactionType.PAYMENT);
        this.manager.doTransaction(transaction, account.getID());
    }

    @Test(expected = TransactionException.class)
    public void testDoTransactionSubjectNull() throws TransactionException, MalformedHandlerException{
        Office office = new Office(new GenericHandler("2345"), this.bank);
        Account account = new Account(office, this.bank, "1234567890");
        Transaction transaction = new GenericTransaction(0.0, new Date(), null, TransactionType.CHARGE);
        this.manager.doTransaction(transaction, account.getID());
    }

    @Test(expected = TransactionException.class)
    public void testDoTransactionCreationDateNull() throws TransactionException, MalformedHandlerException {
        Office office = new Office(new GenericHandler("2345"), this.bank);
        Account account = new Account(office, this.bank, "1234567890");
        Transaction transaction = new GenericTransaction(0.0, null, "subject", TransactionType.CHARGE);
        this.manager.doTransaction(transaction, account.getID());
    }

    @Test(expected = TransactionException.class)
    public void testDoTransactionCreationDateSubjectNull() throws TransactionException, MalformedHandlerException {
        Office office = new Office(new GenericHandler("2345"), this.bank);
        Account account = new Account(office, this.bank, "1234567890");
        Transaction transaction = new GenericTransaction(0.0, null, null, TransactionType.CHARGE);
        this.manager.doTransaction(transaction, account.getID());
    }

    @Test(expected = TransactionException.class)
    public void testDoTransactionNegativeAmountSubjectNull() throws TransactionException, MalformedHandlerException {
        Office office = new Office(new GenericHandler("2345"), this.bank);
        Account account = new Account(office, this.bank, "1234567890");
        Transaction transaction = new GenericTransaction(-1.0, new Date(), null, TransactionType.CHARGE);
        this.manager.doTransaction(transaction, account.getID());
    }

    @Test(expected = TransactionException.class)
    public void testDoTransactionNegativeAmountCreationDateNull() throws TransactionException, MalformedHandlerException {
        Office office = new Office(new GenericHandler("2345"), this.bank);
        Account account = new Account(office, this.bank, "1234567890");
        Transaction transaction = new GenericTransaction(-1.0, null, "subject", TransactionType.CHARGE);
        this.manager.doTransaction(transaction, account.getID());
    }

    @Test(expected = TransactionException.class)
    public void testDoTransactionNegativeAmountCreationDateSubjectNull() throws TransactionException, MalformedHandlerException {
        Office office = new Office(new GenericHandler("2345"), this.bank);
        Account account = new Account(office, this.bank, "1234567890");
        Transaction transaction = new GenericTransaction(-1.0, null, null, TransactionType.CHARGE);
        this.manager.doTransaction(transaction, account.getID());
    }

    @Test(expected = TransactionException.class)
    public void testDoTransactionPositiveAmountSubjectNull() throws TransactionException, MalformedHandlerException {
        Office office = new Office(new GenericHandler("2345"), this.bank);
        Account account = new Account(office, this.bank, "1234567890");
        Transaction transaction = new GenericTransaction(1.0, new Date(), null, TransactionType.CHARGE);
        this.manager.doTransaction(transaction, account.getID());
    }

    @Test(expected = TransactionException.class)
    public void testDoTransactionPositiveAmountCreationDateNull() throws TransactionException, MalformedHandlerException {
        Office office = new Office(new GenericHandler("2345"), this.bank);
        Account account = new Account(office, this.bank, "1234567890");
        Transaction transaction = new GenericTransaction(1.0, null, "subject", TransactionType.CHARGE);
        this.manager.doTransaction(transaction, account.getID());
    }

    @Test(expected = TransactionException.class)
    public void testDoTransactionPositiveAmountCreationDateSubjectNull() throws TransactionException, MalformedHandlerException {
        Office office = new Office(new GenericHandler("2345"), this.bank);
        Account account = new Account(office, this.bank, "1234567890");
        Transaction transaction = new GenericTransaction(1.0, null, null, TransactionType.CHARGE);
        this.manager.doTransaction(transaction, account.getID());
    }

    @Test(expected = TransactionException.class)
    public void testDoTransactionBadTypeSubjectNull() throws TransactionException, MalformedHandlerException {
        Office office = new Office(new GenericHandler("2345"), this.bank);
        Account account = new Account(office, this.bank, "1234567890");
        Transaction transaction = new GenericTransaction(0.0, new Date(), null, TransactionType.PAYMENT);
        this.manager.doTransaction(transaction, account.getID());
    }

    @Test(expected = TransactionException.class)
    public void testDoTransactionBadTypeCreationDateNull() throws TransactionException, MalformedHandlerException {
        Office office = new Office(new GenericHandler("2345"), this.bank);
        Account account = new Account(office, this.bank, "1234567890");
        Transaction transaction = new GenericTransaction(0.0, null, "subject", TransactionType.PAYMENT);
        this.manager.doTransaction(transaction, account.getID());
    }

    @Test(expected = TransactionException.class)
    public void testDoTransactionBadTypeCreationDateSubjectNull() throws TransactionException, MalformedHandlerException {
        Office office = new Office(new GenericHandler("2345"), this.bank);
        Account account = new Account(office, this.bank, "1234567890");
        Transaction transaction = new GenericTransaction(0.0, null, null, TransactionType.PAYMENT);
        this.manager.doTransaction(transaction, account.getID());
    }

    @Test(expected = TransactionException.class)
    public void testDoTransactionBadTypeNegativeAmountSubjectNull() throws TransactionException, MalformedHandlerException {
        Office office = new Office(new GenericHandler("2345"), this.bank);
        Account account = new Account(office, this.bank, "1234567890");
        Transaction transaction = new GenericTransaction(-1.0, new Date(), null, TransactionType.PAYMENT);
        this.manager.doTransaction(transaction, account.getID());
    }

    @Test(expected = TransactionException.class)
    public void testDoTransactionBadTypeNegativeAmountCreationDateNull() throws TransactionException, MalformedHandlerException {
        Office office = new Office(new GenericHandler("2345"), this.bank);
        Account account = new Account(office, this.bank, "1234567890");
        Transaction transaction = new GenericTransaction(-1.0, null, "subject", TransactionType.PAYMENT);
        this.manager.doTransaction(transaction, account.getID());
    }

    @Test(expected = TransactionException.class)
    public void testDoTransactionBadTypeNegativeAmountCreationDateSubjectNull() throws TransactionException, MalformedHandlerException {
        Office office = new Office(new GenericHandler("2345"), this.bank);
        Account account = new Account(office, this.bank, "1234567890");
        Transaction transaction = new GenericTransaction(-1.0, null, null, TransactionType.PAYMENT);
        this.manager.doTransaction(transaction, account.getID());
    }

    @Test(expected = TransactionException.class)
    public void testDoTransactionBadTypePositiveAmountSubjectNull() throws TransactionException, MalformedHandlerException {
        Office office = new Office(new GenericHandler("2345"), this.bank);
        Account account = new Account(office, this.bank, "1234567890");
        Transaction transaction = new GenericTransaction(1.0, new Date(), null, TransactionType.PAYMENT);
        this.manager.doTransaction(transaction, account.getID());
    }

    @Test(expected = TransactionException.class)
    public void testDoTransactionBadTypePositiveAmountCreationDateNull() throws TransactionException, MalformedHandlerException {
        Office office = new Office(new GenericHandler("2345"), this.bank);
        Account account = new Account(office, this.bank, "1234567890");
        Transaction transaction = new GenericTransaction(1.0, null, "subject", TransactionType.PAYMENT);
        this.manager.doTransaction(transaction, account.getID());
    }

    @Test(expected = TransactionException.class)
    public void testDoTransactionBadTypePositiveAmountCreationDateSubjectNull() throws TransactionException, MalformedHandlerException {
        Office office = new Office(new GenericHandler("2345"), this.bank);
        Account account = new Account(office, this.bank, "1234567890");
        Transaction transaction = new GenericTransaction(1.0, null, null, TransactionType.PAYMENT);
        this.manager.doTransaction(transaction, account.getID());
    }

    @Test(expected = TransactionException.class)
    public void testDoTransactionNegativeAmountBadType() throws TransactionException, MalformedHandlerException {
        Office office = new Office(new GenericHandler("2345"), this.bank);
        Account account = new Account(office, this.bank, "1234567890");
        Transaction transaction = new GenericTransaction(-1.0, new Date(), "Subject", TransactionType.PAYMENT);
        this.manager.doTransaction(transaction, account.getID());
    }
}
