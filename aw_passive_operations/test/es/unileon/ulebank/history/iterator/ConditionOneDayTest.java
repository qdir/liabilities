/* Application developed for AW subject, belonging to passive operations
 group.*/
package es.unileon.ulebank.history.iterator;

import es.unileon.ulebank.history.GenericTransaction;
import es.unileon.ulebank.history.Transaction;
import es.unileon.ulebank.history.TransactionType;
import java.util.Date;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author runix
 */
public class ConditionOneDayTest {

    private ConditionOneDay<Transaction> oneDay;

    private ConditionOneDay<Transaction> oneDayExclusive;

    private Date date;

    private static final long DAY_TIMESTAMP = 1000 * 24 * 60 * 60;

    @Before
    public void setup() {
        this.date = new Date(DAY_TIMESTAMP * 4 - DAY_TIMESTAMP / 2);
        this.oneDay = new ConditionOneDay<>(date, true);
        this.oneDayExclusive = new ConditionOneDay<>(date, false);
    }

    @Test
    public void testOneDayOk() {
        assertTrue(this.oneDay.test(this.getTransaction(this.date)));
        assertTrue(this.oneDay.test(this.getTransaction(new Date(this.date.getTime() - DAY_TIMESTAMP / 4))));
        assertTrue(this.oneDay.test(this.getTransaction(new Date(this.date.getTime() + DAY_TIMESTAMP / 4))));
        assertTrue(!this.oneDay.isExclusive());
    }

    @Test
    public void testOneDayNotOk() {
        assertTrue(!this.oneDay.test(this.getTransaction(new Date(this.date.getTime() - DAY_TIMESTAMP - 1))));
        assertTrue(!this.oneDay.test(this.getTransaction(new Date(this.date.getTime() + DAY_TIMESTAMP + 1))));
        assertTrue(!this.oneDay.isExclusive());
    }

    @Test
    public void testOneDayOkExclusive() {
        assertTrue(this.oneDayExclusive.test(this.getTransaction(new Date(this.date.getTime() - DAY_TIMESTAMP - 1))));
        assertTrue(this.oneDayExclusive.test(this.getTransaction(new Date(this.date.getTime() + DAY_TIMESTAMP + 1))));
        assertTrue(this.oneDayExclusive.isExclusive());
    }

    @Test
    public void testOneDayNotOkExclusive() {
        assertTrue(!this.oneDayExclusive.test(this.getTransaction(this.date)));
        assertTrue(!this.oneDayExclusive.test(this.getTransaction(new Date(this.date.getTime() - DAY_TIMESTAMP / 4))));
        assertTrue(!this.oneDayExclusive.test(this.getTransaction(new Date(this.date.getTime() + DAY_TIMESTAMP / 4))));
        assertTrue(this.oneDayExclusive.isExclusive());
    }

    public final Transaction getTransaction(Date date) {
        Transaction t = new GenericTransaction(0, date, "", TransactionType.CHARGE);
        t.setEffectiveDate(date);
        return t;
    }
}
