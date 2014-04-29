/* Application developed for AW subject, belonging to passive operations
 group.*/
package es.unileon.ulebank.account.history;

import es.unileon.ulebank.account.AccountHistory;
import es.unileon.ulebank.handler.GenericHandler;
import es.unileon.ulebank.history.GenericTransaction;
import es.unileon.ulebank.history.Transaction;
import es.unileon.ulebank.history.TransactionType;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Revellado
 */
public class AccountHistoryTest {

    private AccountHistory accountHistory;

    @Before
    public void setUp() {

        this.accountHistory = new AccountHistory();
    }

    /**
     * Test of addTransaction method, of class AccountHistory.
     */
    @Test
    public void testAddTransaction() {

        System.out.println("addTransaction");

        Transaction transaction = new GenericTransaction(10.5d, new Date(), "Imposicion", TransactionType.CHARGE);

        assertTrue(this.accountHistory.addTransaction(transaction));
    }

    /**
     * Test of getTransactionsFrom method, of class AccountHistory.
     */
    @Test
    public void testGetTransactionsFrom() throws ParseException {

        System.out.println("getTransactionsFrom");

        SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
        Date date1 = sdf.parse("01/01/2014");
        Date date2 = sdf.parse("01/02/2014");
        Date date3 = sdf.parse("01/03/2014");
        Date date4 = sdf.parse("20/01/2014");

        Transaction transaction1 = new GenericTransaction(10.5d, date1, "Imposicion", TransactionType.CHARGE);
        Transaction transaction2 = new GenericTransaction(10.5d, date2, "Imposicion", TransactionType.CHARGE);
        Transaction transaction3 = new GenericTransaction(10.5d, date3, "Imposicion", TransactionType.CHARGE);

        this.accountHistory.addTransaction(transaction1);
        this.accountHistory.addTransaction(transaction2);
        this.accountHistory.addTransaction(transaction3);

//        assertEquals(this.accountHistory.getTransactionsFrom(date4).size(), 2);
    }

    /**
     * Test of getTransactionsBetween method, of class AccountHistory.
     */
    @Test
    public void testGetTransactionsBetween() throws ParseException {

        System.out.println("getTransactionsBetween");

        SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
        Date date1 = sdf.parse("01/01/2014");
        Date date2 = sdf.parse("01/02/2014");
        Date date3 = sdf.parse("01/03/2014");
        Date date4 = sdf.parse("20/01/2014");
        Date date5 = sdf.parse("30/04/2014");

        Transaction transaction1 = new GenericTransaction(10.5d, date1, "Imposicion", TransactionType.CHARGE);
        Transaction transaction2 = new GenericTransaction(10.5d, date2, "Imposicion", TransactionType.CHARGE);
        Transaction transaction3 = new GenericTransaction(10.5d, date3, "Imposicion", TransactionType.CHARGE);

        this.accountHistory.addTransaction(transaction1);
        this.accountHistory.addTransaction(transaction2);
        this.accountHistory.addTransaction(transaction3);

//        assertEquals(this.accountHistory.getTransactionsBetween(date4, date5).size(), 2);
    }

    /**
     * Test of getTransactions method, of class AccountHistory.
     */
    @Test
    public void testGetTransactions() {

        System.out.println("getTransactions");

        Transaction transaction = new GenericTransaction( 10.5d, new Date(), "Imposicion", TransactionType.CHARGE);

        this.accountHistory.addTransaction(transaction);

        assertEquals(this.accountHistory.getTransactions().size(), 1);
    }

}
