/* Application developed for AW subject, belonging to passive operations
 group.*/

package es.unileon.aw.account.types;

import es.unileon.ulebank.account.types.CommercialAccount;
import es.unileon.ulebank.account.Account;
import es.unileon.ulebank.account.exception.TransactionException;
import es.unileon.ulebank.bank.Bank;
import es.unileon.ulebank.client.Client;
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
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Revellado
 */
public class CommercialAccountTest {

    private Account commercialAccount;
    
    @Before
    public void setUp() throws MalformedHandlerException {
         this.commercialAccount = new CommercialAccount(new Office(), new Bank(), "0000000000");
    }
    
    /**
     * Test of expected MalformedHandlerException throw for all cases.
     * @throws es.unileon.aw.handler.MalformedHandlerException
     */
    @Test (expected=MalformedHandlerException.class)
    public void testMoreAccountnumberLength() throws MalformedHandlerException {
        
        System.out.println("moreAccountnumberLength");
        
        this.commercialAccount = new CommercialAccount(new Office(), new Bank(), "000000000000");
    }
    
    @Test (expected=MalformedHandlerException.class)
    public void testLessAccountnumberLength() throws MalformedHandlerException {
        
        System.out.println("lessAccountnumberLength");
        
        this.commercialAccount = new CommercialAccount(new Office(), new Bank(), "000000");
    }
    
    @Test (expected=MalformedHandlerException.class)
    public void testCorrectAccountnumberLengthInterspersedLetters () throws MalformedHandlerException {
        
        System.out.println("correctAccountnumberLengthInterspersedLetters");
        
        this.commercialAccount = new CommercialAccount(new Office(), new Bank(), "00aa00aa00");
    }
    
    @Test (expected=MalformedHandlerException.class)
    public void testMoreAccountnumberLengthInterspersedLetters () throws MalformedHandlerException {
        
        System.out.println("moreAccountnumberLengthInterspersedLetters");
        
        this.commercialAccount = new CommercialAccount(new Office(), new Bank(), "0000aa00aa0000");
    }
    
    @Test (expected=MalformedHandlerException.class)
    public void testLessAccountnumberLengthInterspersedLetters () throws MalformedHandlerException {
        
        System.out.println("lessAccountnumberLengthInterspersedLetters");
        
        this.commercialAccount = new CommercialAccount(new Office(), new Bank(), "aa00aa");
    }
    
    /**
     * Test of getBalance method, of class CommercialAccount.
     */
    @Test
    public void testGetBalance() {
        
        System.out.println("getBalance");
        
        double expResult = 0.0d;
        double result = this.commercialAccount.getBalance();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of addBalance method, of class CommercialAccount.
     * @throws es.unileon.aw.account.exception.BalanceException
     */
//    @Test
//    public void testAddBalance() throws BalanceException {
//        
//        System.out.println("addBalance");
//        
//        float balance = 2.0F;
//        float expResult = 2.0F;
//        this.commercialAccount.addBalance(balance);
//        assertEquals(expResult, this.commercialAccount.getBalance(), 2.0F);
//    }
    
    /**
     * Test of throw of BalaceException in addBalance method, of class CommercialAccount.
     * @throws es.unileon.aw.account.exception.BalanceException
     */
//    @Test
//    public void testNegativeBalance() throws BalanceException {
//        
//        System.out.println("negativeBalance");
//        
//        float balance = -2.0F;
//        float expResult = -2.0F;
//        this.commercialAccount.addBalance(balance);
//        assertEquals(expResult, this.commercialAccount.getBalance(), -2.0F);
//    }
    
     /**
     * Test of getType method, of class CommercialAccount.
     */
//    @Test
//    public void testGetType() {
//        
//        System.out.println("getType");
//
//        AccountTypes expResult = AccountTypes.COMMERCIAL_ACCOUNT;;
//        assertEquals(expResult, this.commercialAccount.getType());
//    }
    
    /**
     * Test of doTransaction method, of class CommercialAccount.
     * @throws es.unileon.aw.account.exception.TransactionException
     */
    @Test
    public void testDoTransaction() throws TransactionException{
        
        System.out.println("doTransaction");
        
        Transaction transaction = new GenericTransaction(new GenericHandler("1234"), 10.5d, new Date(), new Date(), "Imposicion", TransactionType.CHARGE);
        
        assertEquals(this.commercialAccount.getBalance(), 0.0d, 0.0d);
        this.commercialAccount.doTransaction(transaction);
        assertEquals(this.commercialAccount.getBalance(), 10.5d, 10.5d);
        
        assertTrue(this.commercialAccount.checkInconsistences());
    }
    
      /**
     * Test of getTransactions method, of class CommercialAccount.
     * @throws es.unileon.aw.account.exception.TransactionException
     */
    @Test
    public void testGetTransaction() throws TransactionException{
        
        System.out.println("getTransaction");
        
        Collection<Transaction> doTransactions;
        Transaction transaction;
        Transaction transaction1 = new GenericTransaction(new GenericHandler("1234"), 10.5d, new Date(), new Date(), "Imposicion", TransactionType.CHARGE);
        Transaction transaction2 = new GenericTransaction(new GenericHandler("1234"), -2.5d, new Date(), new Date(), "Imposicion", TransactionType.PAYMENT);
        Transaction transaction3 = new GenericTransaction(new GenericHandler("1234"), +100.5d, new Date(), new Date(), "Imposicion", TransactionType.CHARGE);
        Collection<Transaction> transactions = new ArrayList<Transaction>();
        
        transactions.add(transaction1);
        transactions.add(transaction2);
        transactions.add(transaction3);
        
        this.commercialAccount.doTransaction(transaction1);
        this.commercialAccount.doTransaction(transaction2);
        this.commercialAccount.doTransaction(transaction3);
        
        assertTrue(this.commercialAccount.checkInconsistences());
        
        doTransactions = this.commercialAccount.getTransactions();
        
        assertEquals(doTransactions.size(), 3, 3);
        
        Iterator<Transaction> doIterator = doTransactions.iterator(); 
        Iterator<Transaction> iterator =  transactions.iterator();
        
        while(doIterator.hasNext() && iterator.hasNext()){
            
            assertEquals(doIterator.next(),iterator.next());
        }
        
  
    }
    
     /**
     * Test of throw of TransactionException in doTransaction method, of class CommercialAccount.
     * @throws es.unileon.aw.account.exception.TransactionException
     */
    @Test (expected=NullPointerException.class)
    public void testDoTransactionNullSubject() throws TransactionException {
        
        System.out.println("doTransactionNullSubject");
        
        Transaction transaction = new GenericTransaction(new GenericHandler("1234"), 10.5d, new Date(), new Date(), null, TransactionType.CHARGE);
        
        this.commercialAccount.doTransaction(transaction);
    }
    
     /**
     * Test of throw of TransactionException in doTransaction method, of class CommercialAccount.
     * @throws es.unileon.aw.account.exception.TransactionException
     */
    @Test (expected=TransactionException.class)
    public void testDoTransactionEmptySubject() throws TransactionException {
        
        System.out.println("doTransactionEmptySubject");
        
        Transaction transaction = new GenericTransaction(new GenericHandler("1234"), 10.5d, new Date(), new Date(), "", TransactionType.CHARGE);
        
        this.commercialAccount.doTransaction(transaction);
    }
    
     /**
     * Test of throw of TransactionException in doTransaction method, of class CommercialAccount.
     * @throws es.unileon.aw.account.exception.TransactionException
     */
    @Test (expected=NullPointerException.class)
    public void testDoTransactionNullId() throws TransactionException {
        
        System.out.println("doTransactionNullId");
        
        Transaction transaction = new GenericTransaction(null, 10.5d, new Date(), new Date(), "Imposicion", TransactionType.CHARGE);
        
        this.commercialAccount.doTransaction(transaction);
    }
    
     /**
     * Test of throw of TransactionException in doTransaction method, of class CommercialAccount.
     * @throws es.unileon.aw.account.exception.TransactionException
     */
    @Test (expected=TransactionException.class)
    public void testDoTransactionEmptyId() throws TransactionException {
        
        System.out.println("doTransactionEmptyId");
        
        Transaction transaction = new GenericTransaction(new GenericHandler(""), 10.5d, new Date(), new Date(), "Imposicion", TransactionType.CHARGE);
        
        this.commercialAccount.doTransaction(transaction);
    }
    
     /**
     * Test of throw of TransactionException in doTransaction method, of class CommercialAccount.
     * @throws es.unileon.aw.account.exception.TransactionException
     */
    @Test (expected=TransactionException.class)
    public void testDoTransactionNullDate() throws TransactionException {
        
        System.out.println("doTransactionNullDate");
        
        Transaction transaction = new GenericTransaction(new GenericHandler("1234"), 10.5d, null, new Date(), "Imposicion", TransactionType.CHARGE);
        
        this.commercialAccount.doTransaction(transaction);
    }  
    
     /**
     * Test of throw of TransactionException in doTransaction method, of class CommercialAccount.
     * @throws es.unileon.aw.account.exception.TransactionException
     */
    @Test (expected=TransactionException.class)
    public void testDoTransactionNullEffectiveDate() throws TransactionException {
        
        System.out.println("doTransactionNullEffectiveDate");
        
        Transaction transaction = new GenericTransaction(new GenericHandler("1234"), 10.5d, new Date(), null, "Imposicion", TransactionType.CHARGE);
        
        this.commercialAccount.doTransaction(transaction);
    }  
    
     /**
     * Test of setLiquidationFrecuency method, of class CommercialAccount.
     */
    @Test
    public void testSetLiquidationFrecuencyMoreThanOne() {
        
        System.out.println("setLiquidationFrecuencyMoreThanOne");
        
        assertTrue(this.commercialAccount.setLiquidationFrecuency(2));
    }  
    
    /**
     * Test of setLiquidationFrecuency method, of class CommercialAccount.
     */
    @Test
    public void testSetLiquidationFrecuencyLessThanOne() {
        
        System.out.println("setLiquidationFrecuencyLessThanOne");
        
        assertFalse(this.commercialAccount.setLiquidationFrecuency(0));
    } 
    
     /**
     * Test of addTitular method, of class CommercialAccount.
     */
    @Test
    public void testAddTitular() {
        
        System.out.println("addTitular");
        
        Client client1 = new Client(new GenericHandler("1234"));
        Client client2 = new Client(new GenericHandler("1234"));
        
        assertTrue(this.commercialAccount.addTitular(client1));
        assertFalse(this.commercialAccount.addTitular(client2));
    } 
    
     /**
     * Test of deleteTitular method, of class CommercialAccount.
     */
    @Test
    public void testDeleteTitular() {
        
        System.out.println("deleteTitular");
        
        Client client1 = new Client(new GenericHandler("1234"));
        Client client2 = new Client(new GenericHandler("5678"));
        
        this.commercialAccount.addTitular(client1);
        
        assertTrue(this.commercialAccount.deleteTitular(client1.getId()));
        assertFalse(this.commercialAccount.deleteTitular(client2.getId()));
    } 
    
    /**
     * Test of getTitulars method, of class CommercialAccount.
     */
    @Test
    public void testGetTitulars() {
        
        System.out.println("getTitulars");
        
        Client client1 = new Client(new GenericHandler("1234"));
        Client client2 = new Client(new GenericHandler("5678"));
        
        this.commercialAccount.addTitular(client1);
        this.commercialAccount.addTitular(client2);
        
        assertEquals(this.commercialAccount.getTitulars().size(), 2);
    } 
    
    /**
     * Test of setLiquidationStrategy method, of class CommercialAccount.
     */
    @Test
    public void testSetLiquidationStrategy() {
        
        System.out.println("setLiquidationStrategy");

//        LiquidationStrategy liquidationStrategy = new ();
//        assertTrue(this.sightAccount.setLiquidationStrategy(liquidationStrategy));
    } 
}
