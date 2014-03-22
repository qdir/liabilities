/* Application developed for AW subject, belonging to passive operations
 group.*/

package es.unileon.aw.account.types;

import es.unileon.ulebank.account.types.SightAccount;
import es.unileon.ulebank.account.Account;
import es.unileon.ulebank.account.AccountTypes;
import es.unileon.ulebank.account.exception.BalanceException;
import es.unileon.ulebank.account.exception.TransactionException;
import es.unileon.ulebank.bank.Bank;
import es.unileon.ulebank.handler.GenericHandler;
import es.unileon.ulebank.handler.MalformedHandlerException;
import es.unileon.ulebank.history.GenericTransaction;
import es.unileon.ulebank.history.Transaction;
import es.unileon.ulebank.history.TransactionType;
import es.unileon.ulebank.office.Office;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Revellado
 */
public class SightAccountTest {
    
    private Account sightAccount;
    
    @Before
    public void setUp() throws MalformedHandlerException {
        this.sightAccount = new SightAccount(new Office(), new Bank(), "0000000000");
    }
    /**
     * Test of throw of BalaceException in addBalance method, of class SightAccount.
     * @throws es.unileon.aw.handler.MalformedHandlerException
     */
    @Test (expected=MalformedHandlerException.class)
    public void testMoreAccountnumberLength() throws MalformedHandlerException {
        this.sightAccount = new SightAccount(new Office(), new Bank(), "000000000000");
    }
    
    @Test (expected=MalformedHandlerException.class)
    public void testLessAccountnumberLength() throws MalformedHandlerException {
        this.sightAccount = new SightAccount(new Office(), new Bank(), "000000");
    }
    
    @Test (expected=MalformedHandlerException.class)
    public void testCorrectAccountnumberLengthInterspersedLetters () throws MalformedHandlerException {
        this.sightAccount = new SightAccount(new Office(), new Bank(), "00aa00aa00");
    }
    
    @Test (expected=MalformedHandlerException.class)
    public void testMoreAccountnumberLengthInterspersedLetters () throws MalformedHandlerException {
        this.sightAccount = new SightAccount(new Office(), new Bank(), "0000aa00aa0000");
    }
    
    @Test (expected=MalformedHandlerException.class)
    public void testLessAccountnumberLengthInterspersedLetters () throws MalformedHandlerException {
        this.sightAccount = new SightAccount(new Office(), new Bank(), "aa00aa");
    }
    
    /**
     * Test of getBalance method, of class SightAccount.
     */
    @Test
    public void testGetBalance() {
        
        System.out.println("getBalance");
        
        double expResult = 0.0d;
        double result = this.sightAccount.getBalance();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of addBalance method, of class SightAccount.
     * @throws es.unileon.aw.account.exception.BalanceException
     */
    @Test (expected=BalanceException.class)
    public void testAddBalance() throws BalanceException {
        
        System.out.println("addBalance");
        
        float balance = 2.0F;
        float expResult = 2.0F;
        this.sightAccount.addBalance(balance);
        assertEquals(expResult, this.sightAccount.getBalance(), 2.0F);
    }
    
     /**
     * Test of throw of BalaceException in addBalance method, of class SightAccount.
     * @throws es.unileon.aw.account.exception.BalanceException
     */
    @Test (expected=BalanceException.class)
    public void testNegativeBalance() throws BalanceException {
        
        System.out.println("negativeBalance");
        
        float balance = -2.0F;
        this.sightAccount.addBalance(balance);
    }
    
     /**
     * Test of getType method, of class CommercialAccount.
     */
    @Test
    public void testGetType() {
        
        System.out.println("getType");

        AccountTypes expResult = AccountTypes.SIGH_ACCOUNT;
        assertEquals(expResult, this.sightAccount.getType());
    }
    
    /**
     * Test of doTransaction method, of class SightAccount.
     * @throws es.unileon.aw.account.exception.TransactionException
     */
    @Test
    public void testDoTransaction() throws TransactionException{
        
        System.out.println("doTransaction");
        
        Transaction transaction = new GenericTransaction(new GenericHandler("1234"), 10.5d, new Date(), new Date(), "Imposicion", TransactionType.CHARGE);
        
        assertEquals(this.sightAccount.getBalance(), 0.0d, 0.0d);
        this.sightAccount.doTransaction(transaction);
        assertEquals(this.sightAccount.getBalance(), 10.5d, 10.5d);
        
        assertTrue(this.sightAccount.checkInconsistences());
    }
    
      /**
     * Test of getTransactions method, of class SightAccount.
     * @throws es.unileon.aw.account.exception.TransactionException
     */
    @Test
    public void testGetTransactions() throws TransactionException{
        
        System.out.println("getTransactions");
        
        Collection<Transaction> doTransactions;
        Transaction transaction1 = new GenericTransaction(new GenericHandler("1234"), 10.5d, new Date(), new Date(), "Imposicion", TransactionType.CHARGE);
        Transaction transaction2 = new GenericTransaction(new GenericHandler("1234"), -2.5d, new Date(), new Date(), "Imposicion", TransactionType.PAYMENT);
        Transaction transaction3 = new GenericTransaction(new GenericHandler("1234"), +100.5d, new Date(), new Date(), "Imposicion", TransactionType.CHARGE);
        Collection<Transaction> transactions = new ArrayList<Transaction>();
        
        transactions.add(transaction1);
        transactions.add(transaction2);
        transactions.add(transaction3);
        
        this.sightAccount.doTransaction(transaction1);
        this.sightAccount.doTransaction(transaction2);
        this.sightAccount.doTransaction(transaction3);
        
        assertTrue(this.sightAccount.checkInconsistences());
        
        doTransactions = this.sightAccount.getTransactions();
        
        assertEquals(doTransactions.size(), 3, 3);
        
        Iterator<Transaction> doIterator = doTransactions.iterator(); 
        Iterator<Transaction> iterator =  transactions.iterator();
        
        while(doIterator.hasNext() && iterator.hasNext()){
            
            assertEquals(doIterator.next(),iterator.next());
        } 
    }
    
    /**
     * Test of throw of TransactionException in doTransaction method, of class SightAccount.
     * @throws es.unileon.aw.account.exception.TransactionException
     */
    @Test (expected=NullPointerException.class)
    public void testDoTransactionNullSubject() throws TransactionException {
        
        System.out.println("doTransactionNullSubject");
        
        Transaction transaction = new GenericTransaction(new GenericHandler("1234"), 10.5d, new Date(), new Date(), null, TransactionType.CHARGE);
        
        this.sightAccount.doTransaction(transaction);
    }
    
     /**
     * Test of throw of TransactionException in doTransaction method, of class SightAccount.
     * @throws es.unileon.aw.account.exception.TransactionException
     */
    @Test (expected=TransactionException.class)
    public void testDoTransactionEmptySubject() throws TransactionException {
        
        System.out.println("doTransactionEmptySubject");
        
        Transaction transaction = new GenericTransaction(new GenericHandler("1234"), 10.5d, new Date(), new Date(), "", TransactionType.CHARGE);
        
        this.sightAccount.doTransaction(transaction);
    }
    
     /**
     * Test of throw of TransactionException in doTransaction method, of class SightAccount.
     * @throws es.unileon.aw.account.exception.TransactionException
     */
    @Test (expected=NullPointerException.class)
    public void testDoTransactionNullId() throws TransactionException {
        
        System.out.println("doTransactionNullId");
        
        Transaction transaction = new GenericTransaction(null, 10.5d, new Date(), new Date(), "Imposicion", TransactionType.CHARGE);
        
        this.sightAccount.doTransaction(transaction);
    }
    
     /**
     * Test of throw of TransactionException in doTransaction method, of class SightAccount.
     * @throws es.unileon.aw.account.exception.TransactionException
     */
    @Test (expected=TransactionException.class)
    public void testDoTransactionEmptyId() throws TransactionException {
        
        System.out.println("doTransactionEmptyId");
        
        Transaction transaction = new GenericTransaction(new GenericHandler(""), 10.5d, new Date(), new Date(), "Imposicion", TransactionType.CHARGE);
        
        this.sightAccount.doTransaction(transaction);
    }
    
     /**
     * Test of throw of TransactionException in doTransaction method, of class SightAccount.
     * @throws es.unileon.aw.account.exception.TransactionException
     */
    @Test (expected=TransactionException.class)
    public void testDoTransactionNullDate() throws TransactionException {
        
        System.out.println("doTransactionNullDate");
        
        Transaction transaction = new GenericTransaction(new GenericHandler("1234"), 10.5d, null, new Date(), "Imposicion", TransactionType.CHARGE);
        
        this.sightAccount.doTransaction(transaction);
    }  
    
     /**
     * Test of throw of TransactionException in doTransaction method, of class SightAccount.
     * @throws es.unileon.aw.account.exception.TransactionException
     */
    @Test (expected=TransactionException.class)
    public void testDoTransactionNullEffectiveDate() throws TransactionException {
        
        System.out.println("doTransactionNullEffectiveDate");
        
        Transaction transaction = new GenericTransaction(new GenericHandler("1234"), 10.5d, new Date(), null, "Imposicion", TransactionType.CHARGE);
        
        this.sightAccount.doTransaction(transaction);
    }    
}