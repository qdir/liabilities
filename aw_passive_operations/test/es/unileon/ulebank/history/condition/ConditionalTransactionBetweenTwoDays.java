/* Application developed for AW subject, belonging to passive operations
 group.*/
package es.unileon.ulebank.history.condition;

import es.unileon.ulebank.history.conditions.ConditionTransactionBetweenTwoDates;
import es.unileon.ulebank.history.GenericTransaction;
import es.unileon.ulebank.history.Transaction;
import es.unileon.ulebank.history.TransactionType;
import java.util.Date;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author runix
 */
public class ConditionalTransactionBetweenTwoDays {

    private static final long DAY_TIMESTAMP = 1000 * 24 * 60 * 60;

    private ConditionTransactionBetweenTwoDates<Transaction> conditionBetween;
    private ConditionTransactionBetweenTwoDates<Transaction> conditionBetweenExclusive;

    private Date low;
    private Date high;

    @Before
    public void setup() {
        this.low = new Date(DAY_TIMESTAMP * 10 - DAY_TIMESTAMP / 2);
        this.high = new Date(DAY_TIMESTAMP * 20 + DAY_TIMESTAMP / 2);
        this.conditionBetween = new ConditionTransactionBetweenTwoDates<>(low, high, true);
        this.conditionBetweenExclusive = new ConditionTransactionBetweenTwoDates<>(low, high, false);
    }

    @Test
    public void testConditionBetweenOK() {
        assertTrue(this.conditionBetween.test(this.getTransaction(new Date(this.low.getTime() + (this.high.getTime() - this.low.getTime())))));
        assertTrue(this.conditionBetween.test(this.getTransaction(new Date(this.low.getTime()))));
        assertTrue(this.conditionBetween.test(this.getTransaction(new Date(this.high.getTime()))));
        assertFalse(this.conditionBetween.isExclusive());
    }

    @Test
    public void testConditionBetweenNoOK() {
        assertFalse(this.conditionBetween.test(this.getTransaction(new Date(this.low.getTime() - 1))));
        assertFalse(this.conditionBetween.test(this.getTransaction(new Date(this.high.getTime() + 1))));
        assertFalse(this.conditionBetween.isExclusive());
    }

    @Test
    public void testConditionBetweenOKExclusive() {
        assertTrue(this.conditionBetweenExclusive.test(this.getTransaction(new Date(this.low.getTime() - 1))));
        assertTrue(this.conditionBetweenExclusive.test(this.getTransaction(new Date(this.high.getTime() + 1))));
        assertTrue(this.conditionBetweenExclusive.isExclusive());
    }

    @Test
    public void testConditionBetweenNoOKExclusive() {
        assertFalse(this.conditionBetweenExclusive.test(this.getTransaction(new Date(this.low.getTime() + (this.high.getTime() - this.low.getTime())))));
        assertFalse(this.conditionBetweenExclusive.test(this.getTransaction(new Date(this.low.getTime()))));
        assertFalse(this.conditionBetweenExclusive.test(this.getTransaction(new Date(this.high.getTime()))));
        assertTrue(this.conditionBetweenExclusive.isExclusive());
    }

    public final Transaction getTransaction(Date date) {
        Transaction t = new GenericTransaction(0, date, "", TransactionType.CHARGE);
        t.setEffectiveDate(date);
        return t;
    }
}
