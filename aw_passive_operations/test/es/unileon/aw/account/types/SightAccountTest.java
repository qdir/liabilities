/* Application developed for AW subject, belonging to passive operations
 group.*/

package es.unileon.aw.account.types;

import es.unileon.aw.account.Account;
import es.unileon.aw.account.AccountTypes;
import es.unileon.aw.account.exception.BalanceException;
import es.unileon.aw.bank.Bank;
import es.unileon.aw.handler.MalformedHandlerException;
import es.unileon.aw.office.Office;
import static org.junit.Assert.assertEquals;
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
        
        float expResult = 0.0F;
        float result = this.sightAccount.getBalance();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of addBalance method, of class SightAccount.
     */
    @Test
    public void testAddBalance() throws Exception {
        
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
        float expResult = 2.0F;
        this.sightAccount.addBalance(balance);
        assertEquals(expResult, this.sightAccount.getBalance(), 2.0F);
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
}
