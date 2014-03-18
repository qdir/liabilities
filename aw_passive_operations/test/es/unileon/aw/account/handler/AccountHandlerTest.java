/* Application developed for AW subject, belonging to passive operations
 group.*/

package es.unileon.aw.account.handler;

import es.unileon.ulebank.account.handler.AccountHandler;
import es.unileon.ulebank.bank.Bank;
import es.unileon.ulebank.handler.GenericHandler;
import es.unileon.ulebank.handler.MalformedHandlerException;
import es.unileon.ulebank.office.Office;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Revellado
 */
public class AccountHandlerTest {
    
    private AccountHandler accountHandler1,accountHandler2,accountHandler3, testExceptionAccountHandler;
    private Bank bank;
    private Office office;
    
    @Before
    public void setUp() {
        
        this.bank = new Bank();
        this.office = new Office();
        
        try{
            
            this.accountHandler1 = new AccountHandler(office.getID(), bank.getID(), "0000000000");
        }catch (MalformedHandlerException ex){
            
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }
    
     /**
     * Test of expected MalformedHandlerException throw for all cases.
     * @throws es.unileon.aw.handler.MalformedHandlerException
     */
    @Test (expected=MalformedHandlerException.class)
    public void testMoreBankHandlerLength() throws MalformedHandlerException {
        this.testExceptionAccountHandler = new AccountHandler(new GenericHandler("000000"), new GenericHandler("0000"), "000000000000");
    }
    
    @Test (expected=MalformedHandlerException.class)
    public void testLessBankHandlerLength() throws MalformedHandlerException {
        this.testExceptionAccountHandler = new AccountHandler(new GenericHandler("00"), new GenericHandler("0000"), "000000000000");
    }
    
    @Test (expected=MalformedHandlerException.class)
    public void testCorrectBankHandlerLengthInterspersedLetters() throws MalformedHandlerException {
        this.testExceptionAccountHandler = new AccountHandler(new GenericHandler("0aa0"), new GenericHandler("0000"), "000000000000");
    }
    
    @Test (expected=MalformedHandlerException.class)
    public void testMoreBankHandlerLengthInterspersedLetters() throws MalformedHandlerException {
        this.testExceptionAccountHandler = new AccountHandler(new GenericHandler("00aa00"), new GenericHandler("0000"), "000000000000");
    }
    
    @Test (expected=MalformedHandlerException.class)
    public void testLessBankHandlerLengthInterspersedLetters() throws MalformedHandlerException {
        this.testExceptionAccountHandler = new AccountHandler(new GenericHandler("0a0"), new GenericHandler("0000"), "000000000000");
    }
    
    @Test (expected=MalformedHandlerException.class)
    public void testMoreOfficeHandlerLength() throws MalformedHandlerException {
        this.testExceptionAccountHandler = new AccountHandler(new GenericHandler("0000"), new GenericHandler("000000"), "000000000000");
    }
    
    @Test (expected=MalformedHandlerException.class)
    public void testLessOfficeHandlerLength() throws MalformedHandlerException {
        this.testExceptionAccountHandler = new AccountHandler(new GenericHandler("0000"), new GenericHandler("00"), "000000000000");
    }

    @Test (expected=MalformedHandlerException.class)
    public void testCorrectOfficeHandlerLengthInterspersedLetters() throws MalformedHandlerException {
        this.testExceptionAccountHandler = new AccountHandler(new GenericHandler("0000"), new GenericHandler("0aa0"), "000000000000");
    }
    
    @Test (expected=MalformedHandlerException.class)
    public void testMoreOfficeHandlerLengthInterspersedLetters() throws MalformedHandlerException {
        this.testExceptionAccountHandler = new AccountHandler(new GenericHandler("0000"), new GenericHandler("00aa00"), "000000000000");
    }
    
    @Test (expected=MalformedHandlerException.class)
    public void testLessOfficeHandlerLengthInterspersedLetters() throws MalformedHandlerException {
        this.testExceptionAccountHandler = new AccountHandler(new GenericHandler("0000"), new GenericHandler("0a0"), "000000000000");
    }
    
        @Test (expected=MalformedHandlerException.class)
    public void testMoreAccountnumberHandlerLength() throws MalformedHandlerException {
        this.testExceptionAccountHandler = new AccountHandler(new GenericHandler("0000"), new GenericHandler("0000"), "000000000000");
    }
    
    @Test (expected=MalformedHandlerException.class)
    public void testLessAccountnumberHandlerLength() throws MalformedHandlerException {
        this.testExceptionAccountHandler = new AccountHandler(new GenericHandler("0000"), new GenericHandler("0000"), "000000");
    }
    
    @Test (expected=MalformedHandlerException.class)
    public void testCorrectAccountnumberHandlerLengthInterspersedLetters () throws MalformedHandlerException {
        this.testExceptionAccountHandler = new AccountHandler(new GenericHandler("0000"), new GenericHandler("0000"), "00aa00aa00");
    }
    
    @Test (expected=MalformedHandlerException.class)
    public void testMoreAccountnumberHandlerLengthInterspersedLetters () throws MalformedHandlerException {
        this.testExceptionAccountHandler = new AccountHandler(new GenericHandler("0000"), new GenericHandler("0000"), "0000aa00aa0000");
    }
    
    @Test (expected=MalformedHandlerException.class)
    public void testLessAccountnumberHandlerLengthInterspersedLetters () throws MalformedHandlerException {
        this.testExceptionAccountHandler = new AccountHandler(new GenericHandler("0000"), new GenericHandler("0000"), "aa00aa");
    }
    
    /**
     * Test of compareTo method, of class AccountHandler.
     */
    @Test
    public void testCorrectCompareTo() throws MalformedHandlerException {
        
        System.out.println("compareTo");

        GenericHandler genericHandler = new GenericHandler(accountHandler1.toString());
        accountHandler2 = new AccountHandler(this.office.getID(), this.bank.getID(), "0000000000");
        
        assertEquals(accountHandler1.compareTo(genericHandler),0);
        assertEquals(accountHandler1.compareTo(accountHandler2),0);
    }
    
    @Test
    public void testIncorrectCompareTo() throws MalformedHandlerException {
        
        System.out.println("compareTo");
        
        accountHandler3 = new AccountHandler(this.office.getID(), this.bank.getID(), "0000000001");
       
        assertTrue(accountHandler1.compareTo(accountHandler3) != 0);
    }

    // FALTA TO STRING
    /**
     * Test of toString method, of class AccountHandler.
     */
    @Test
    public void testToString() {
        
        System.out.println("toString");
        
        String expResult = accountHandler1.toString();
        assertEquals(accountHandler1.toString(), expResult);
    }
    
}
