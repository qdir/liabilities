/* Application developed for AW subject, belonging to passive operations
 group.*/

package es.unileon.ulebank.transacionManager;

import es.unileon.ulebank.account.exception.TransactionException;
import es.unileon.ulebank.account.types.CommercialAccount;
import es.unileon.ulebank.bank.Bank;
import es.unileon.ulebank.handler.GenericHandler;
import es.unileon.ulebank.handler.MalformedHandlerException;
import es.unileon.ulebank.history.GenericTransaction;
import es.unileon.ulebank.history.Transaction;
import es.unileon.ulebank.history.TransactionType;
import es.unileon.ulebank.office.Office;
import java.util.Date;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

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
     */
    @Test
    public void testDeleteBankNotFoundBank() throws MalformedHandlerException {
        
        System.out.println("deleteBankNotFoundBank");
        
        Bank bank = new Bank(this.manager, new GenericHandler("5678"));
        
        assertFalse(this.manager.deleteBank(bank.getID()));
    }
    
    
    /**
     * Test of doTransaction method, of class TransactionManager.
     */
    @Test
    public void testDoTransaction() throws Exception {
        
        System.out.println("doTransaction");
        
        this.manager.addBank(this.bank);
        
        Office office = new Office(new GenericHandler("2345"), this.bank);
        this.bank.addOffice(office);
        
        CommercialAccount account = new CommercialAccount(office, this.bank, "1234567890");
        office.addAccount(account);
        
        Transaction transaction = new GenericTransaction( 2.0, new Date(), "Salary", TransactionType.PAYMENT);
        
        this.manager.doTransaction(transaction,account.getID());
        
        assertEquals(account.getBalance(), 2.0, 2.0);
    }
    
    /**
    * Test throw of TransactionException in doTransaction method, of class TransactionManager.
    */
    @Test (expected = TransactionException.class)
    public void testDoTransactionNullTransaction() throws TransactionException, MalformedHandlerException {
        
        System.out.println("doTransactionNullTransaction");
  
        this.manager.doTransaction(null,null);
    }
    
    /**
    * Test throw of TransactionException in doTransaction method, of class TransactionManager.
    */
    @Test (expected = TransactionException.class)
    public void testDoTransactionNotFoundBank() throws TransactionException, MalformedHandlerException {
        
        System.out.println("doTransactionNotFoundBank");
        
        Office office = new Office(new GenericHandler("2345"), this.bank);
        
        CommercialAccount account = new CommercialAccount(office, this.bank, "1234567890");
        
        Transaction transaction = new GenericTransaction( 2.0, new Date(), "Salary", TransactionType.PAYMENT);
        
        this.manager.doTransaction(transaction, account.getID());
    }
}
