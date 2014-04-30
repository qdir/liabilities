/* Application developed for AW subject, belonging to passive operations
 group.*/

package es.unileon.ulebank.office;

import es.unileon.ulebank.account.TransactionException;
import es.unileon.ulebank.account.AccountHandler;
import es.unileon.ulebank.account.types.CommercialAccount;
import es.unileon.ulebank.bank.Bank;
import es.unileon.ulebank.office.Office;
import es.unileon.ulebank.handler.GenericHandler;
import es.unileon.ulebank.handler.Handler;
import es.unileon.ulebank.handler.MalformedHandlerException;
import es.unileon.ulebank.history.GenericTransaction;
import es.unileon.ulebank.history.Transaction;
import es.unileon.ulebank.history.TransactionType;
import es.unileon.ulebank.transacionManager.TransactionManager;
import java.util.Date;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Revellado
 */
public class OfficeTest {
    
    private Office office;
    private Bank bank;
    private CommercialAccount account;
    private TransactionManager manager;
    
    @Before
    public void setUp() throws MalformedHandlerException {
        
        this.manager = new TransactionManager();
        this.bank = new Bank(this.manager, new GenericHandler("1234"));
        this.office = new Office(new GenericHandler("1234"), this.bank);
        this.account = new CommercialAccount(office, bank, "1234567890");
    }

     /**
     * Test of addAccount method, of class Office.
     */
    @Test
    public void testAddAccount() {
        
        System.out.println("addAccount");

        assertTrue(this.office.addAccount(account));
    }
    
     /**
     * Test of addAccount method, of class Office.
     */
    @Test
    public void testAddAccountNullAccount() {
        
        System.out.println("addAccountNullAccount");

        assertFalse(this.office.addAccount(null));
    }
    
    /**
     * Test of getID method, of class Office.
     */
    @Test
    public void testGetID() {
        
        System.out.println("getID");

        Handler expResult = new GenericHandler("1234");

        assertEquals(this.office.getID().compareTo(expResult),0);
        
    }
    
        /**
     * Test of doTransaction method, of class Office.
     */
    @Test
    public void testDoTransaction() throws TransactionException, MalformedHandlerException {
        
        System.out.println("doTransaction");
        
        this.office.addAccount(account);
        
        Transaction transaction = new GenericTransaction(2.0, new Date(), "Salary", TransactionType.PAYMENT);
        
        transaction.setEffectiveDate(new Date());
        
        this.office.doTransaction(transaction,this.account.getID());
        
        assertEquals(this.account.getBalance(), 2.0, 2.0);
    }
    
    /**
    * Test throw of TransactionException in doTransaction method, of class Office.
    */
    @Test (expected = TransactionException.class)
    public void testDoTransactionNullTransactionNullDestination() throws TransactionException, MalformedHandlerException {
        
        System.out.println("doTransactionNullTransaction");
  
        this.office.doTransaction(null,null);
    }
    
    /**
    * Test throw of TransactionException in doTransaction method, of class Office.
    */
    @Test (expected = TransactionException.class)
    public void testDoTransactionNullTransaction() throws TransactionException, MalformedHandlerException {
        
        System.out.println("doTransactionNullTransaction");
  
        this.office.doTransaction(null, this.account.getID());
    }
        
    /**
     * Test throw of TransactionException in doTransaction method, of class Office.
     */
    @Test (expected = TransactionException.class)
    public void testDoTransactionNullType() throws TransactionException, MalformedHandlerException {
        
        System.out.println("doTransactionNullType");
        
        this.office.addAccount(account);
        
        Transaction transaction = new GenericTransaction(2.0, new Date(), "Salary", null);
        
        this.office.doTransaction(transaction, this.account.getID());
    }
    
    @Test(expected = TransactionException.class)
    public void testDoTransactionNegativeAmount() throws TransactionException, MalformedHandlerException {
        this.office.addAccount(account);
        Transaction transaction = new GenericTransaction(-1.0, new Date(), "Subject", TransactionType.CHARGE);
        this.office.doTransaction(transaction, this.account.getID());
    }

    @Test(expected = TransactionException.class)
    public void testDoWithdrawalNegativeAmountBadType() throws TransactionException, MalformedHandlerException{
        this.office.addAccount(account);
        Transaction transaction = new GenericTransaction(-1.0, new Date(), "Subject", TransactionType.PAYMENT);
        this.office.doTransaction(transaction, this.account.getID());
    }

    @Test(expected = TransactionException.class)
    public void testDoTransactionSubjectNull() throws TransactionException, MalformedHandlerException{
        this.office.addAccount(account);
        Transaction transaction = new GenericTransaction(0.0, new Date(), null, TransactionType.CHARGE);
        this.office.doTransaction(transaction, this.account.getID());
    }

    @Test(expected = TransactionException.class)
    public void testDoTransactionCreationDateNull() throws TransactionException, MalformedHandlerException {
        this.office.addAccount(account);
        Transaction transaction = new GenericTransaction(0.0, null, "subject", TransactionType.CHARGE);
        this.office.doTransaction(transaction, this.account.getID());
    }

    @Test(expected = TransactionException.class)
    public void testDoTransactionCreationDateSubjectNull() throws TransactionException, MalformedHandlerException {
        this.office.addAccount(account);
        Transaction transaction = new GenericTransaction(0.0, null, null, TransactionType.CHARGE);
        this.office.doTransaction(transaction, this.account.getID());
    }

    @Test(expected = TransactionException.class)
    public void testDoTransactionNegativeAmountSubjectNull() throws TransactionException, MalformedHandlerException {
        this.office.addAccount(account);
        Transaction transaction = new GenericTransaction(-1.0, new Date(), null, TransactionType.CHARGE);
        this.office.doTransaction(transaction, this.account.getID());
    }

    @Test(expected = TransactionException.class)
    public void testDoTransactionNegativeAmountCreationDateNull() throws TransactionException, MalformedHandlerException {
        this.office.addAccount(account);
        Transaction transaction = new GenericTransaction(-1.0, null, "subject", TransactionType.CHARGE);
        this.office.doTransaction(transaction, this.account.getID());
    }

    @Test(expected = TransactionException.class)
    public void testDoTransactionNegativeAmountCreationDateSubjectNull() throws TransactionException, MalformedHandlerException {
        this.office.addAccount(account);
        Transaction transaction = new GenericTransaction(-1.0, null, null, TransactionType.CHARGE);
        this.office.doTransaction(transaction, this.account.getID());
    }

    @Test(expected = TransactionException.class)
    public void testDoTransactionPositiveAmountSubjectNull() throws TransactionException, MalformedHandlerException {
        this.office.addAccount(account);
        Transaction transaction = new GenericTransaction(1.0, new Date(), null, TransactionType.CHARGE);
        this.office.doTransaction(transaction, this.account.getID());
    }

    @Test(expected = TransactionException.class)
    public void testDoTransactionPositiveAmountCreationDateNull() throws TransactionException, MalformedHandlerException {
        this.office.addAccount(account);
        Transaction transaction = new GenericTransaction(1.0, null, "subject", TransactionType.CHARGE);
        this.office.doTransaction(transaction, this.account.getID());
    }

    @Test(expected = TransactionException.class)
    public void testDoTransactionPositiveAmountCreationDateSubjectNull() throws TransactionException, MalformedHandlerException {
        this.office.addAccount(account);
        Transaction transaction = new GenericTransaction(1.0, null, null, TransactionType.CHARGE);
        this.office.doTransaction(transaction, this.account.getID());
    }

    @Test(expected = TransactionException.class)
    public void testDoTransactionBadTypeSubjectNull() throws TransactionException, MalformedHandlerException {
        this.office.addAccount(account);
        Transaction transaction = new GenericTransaction(0.0, new Date(), null, TransactionType.PAYMENT);
        this.office.doTransaction(transaction, this.account.getID());
    }

    @Test(expected = TransactionException.class)
    public void testDoTransactionBadTypeCreationDateNull() throws TransactionException, MalformedHandlerException {
        this.office.addAccount(account);
        Transaction transaction = new GenericTransaction(0.0, null, "subject", TransactionType.PAYMENT);
        this.office.doTransaction(transaction, this.account.getID());
    }

    @Test(expected = TransactionException.class)
    public void testDoTransactionBadTypeCreationDateSubjectNull() throws TransactionException, MalformedHandlerException {
        this.office.addAccount(account);
        Transaction transaction = new GenericTransaction(0.0, null, null, TransactionType.PAYMENT);
        this.office.doTransaction(transaction, this.account.getID());
    }

    @Test(expected = TransactionException.class)
    public void testDoTransactionBadTypeNegativeAmountSubjectNull() throws TransactionException, MalformedHandlerException {
        this.office.addAccount(account);
        Transaction transaction = new GenericTransaction(-1.0, new Date(), null, TransactionType.PAYMENT);
        this.office.doTransaction(transaction, this.account.getID());
    }

    @Test(expected = TransactionException.class)
    public void testDoTransactionBadTypeNegativeAmountCreationDateNull() throws TransactionException, MalformedHandlerException {
        this.office.addAccount(account);
        Transaction transaction = new GenericTransaction(-1.0, null, "subject", TransactionType.PAYMENT);
        this.office.doTransaction(transaction, this.account.getID());
    }

    @Test(expected = TransactionException.class)
    public void testDoTransactionBadTypeNegativeAmountCreationDateSubjectNull() throws TransactionException, MalformedHandlerException {
        this.office.addAccount(account);
        Transaction transaction = new GenericTransaction(-1.0, null, null, TransactionType.PAYMENT);
        this.office.doTransaction(transaction, this.account.getID());
    }

    @Test(expected = TransactionException.class)
    public void testDoTransactionBadTypePositiveAmountSubjectNull() throws TransactionException, MalformedHandlerException {
        this.office.addAccount(account);
        Transaction transaction = new GenericTransaction(1.0, new Date(), null, TransactionType.PAYMENT);
        this.office.doTransaction(transaction, this.account.getID());
    }

    @Test(expected = TransactionException.class)
    public void testDoTransactionBadTypePositiveAmountCreationDateNull() throws TransactionException, MalformedHandlerException {
        this.office.addAccount(account);
        Transaction transaction = new GenericTransaction(1.0, null, "subject", TransactionType.PAYMENT);
        this.office.doTransaction(transaction, this.account.getID());
    }

    @Test(expected = TransactionException.class)
    public void testDoTransactionBadTypePositiveAmountCreationDateSubjectNull() throws TransactionException, MalformedHandlerException {
        this.office.addAccount(account);
        Transaction transaction = new GenericTransaction(1.0, null, null, TransactionType.PAYMENT);
        this.office.doTransaction(transaction, this.account.getID());
    }

    @Test(expected = TransactionException.class)
    public void testDoTransactionNegativeAmountBadType() throws TransactionException, MalformedHandlerException {
        this.office.addAccount(account);
        Transaction transaction = new GenericTransaction(-1.0, new Date(), "Subject", TransactionType.PAYMENT);
        this.office.doTransaction(transaction, this.account.getID());
    }
    
    @Test
    public void testLastNumberAccount() throws TransactionException, MalformedHandlerException {
        
        this.office.addAccount(account);
        
        assertEquals(this.office.getNewAccountNumber(),"1234567891","1234567891");
    }
}
