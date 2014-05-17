/* Application developed for AW subject, belonging to passive operations
 group.*/
package es.unileon.ulebank.history;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Revellado
 */
public class HistoryTest {

    private History<Transaction> accountHistory;

    @Before
    public void setUp() {

        this.accountHistory = new History<Transaction>();
    }

    /**
     * Test of add method, of class AccountHistory.
     */
    @Test
    public void testAddGenericTransaction() {
        Transaction transaction = new GenericTransaction(10.5d, new Date(), "Imposicion");
        assertTrue(this.accountHistory.add(transaction));
    }

    /**
     * Test of getTransactions method, of class AccountHistory.
     */
    @Test
    public void testGetTransactions() throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
        Date date1 = sdf.parse("01/01/2014");
        Date date2 = sdf.parse("01/02/2014");
        Date date3 = sdf.parse("01/03/2014");

        Transaction transaction1 = new GenericTransaction(10.5d, date1, "Imposicion");
        Transaction transaction2 = new GenericTransaction(10.5d, date2, "Imposicion");
        Transaction transaction3 = new GenericTransaction(10.5d, date3, "Imposicion");
        List<Transaction> added = new ArrayList<Transaction>();
        added.add(transaction1);
        added.add(transaction2);
        added.add(transaction3);

        this.accountHistory.add(transaction1);
        this.accountHistory.add(transaction2);
        this.accountHistory.add(transaction3);

        Iterator<Transaction> itHistory = this.accountHistory.getIterator();
        Iterator<Transaction> it = added.iterator();
        while (it.hasNext() && itHistory.hasNext()) {
            assertEquals(it.next(), itHistory.next());
        }
        assertFalse(it.hasNext());
        assertFalse(itHistory.hasNext());
    }

}
