/* Application developed for AW subject, belonging to passive operations
 group.*/
package es.unileon.ulebank.history.condition;

import es.unileon.ulebank.history.GenericTransaction;
import es.unileon.ulebank.history.Transaction;
import es.unileon.ulebank.history.TransactionType;
import es.unileon.ulebank.history.conditions.ConditionTransactionBetweenTwoAmounts;
import es.unileon.ulebank.history.conditions.WrongArgsException;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author runix
 */
public class ConditionTransactionBetweenTwoAmountsTest {

    @Test
    public void testBetweenOk() throws WrongArgsException {
        ConditionTransactionBetweenTwoAmounts condition = new ConditionTransactionBetweenTwoAmounts<>(100, 100, true);
        assertTrue(condition.test(this.getTransaction(100)));
        condition = new ConditionTransactionBetweenTwoAmounts<>(100, 125, true);
        assertTrue(condition.test(this.getTransaction(100)));
        assertTrue(condition.test(this.getTransaction(125)));
        assertTrue(condition.test(this.getTransaction(115)));
        assertFalse(condition.isExclusive());
    }

    @Test
    public void testBetweenNotOk() throws WrongArgsException {
        ConditionTransactionBetweenTwoAmounts condition = new ConditionTransactionBetweenTwoAmounts<>(100, 100, true);
        assertFalse(condition.test(this.getTransaction(101)));
        condition = new ConditionTransactionBetweenTwoAmounts<>(100, 125, true);
        assertFalse(condition.test(this.getTransaction(99)));
        assertFalse(condition.test(this.getTransaction(126)));
        assertFalse(condition.isExclusive());
    }

    @Test
    public void testBetweenOkExclusive() throws WrongArgsException {
        ConditionTransactionBetweenTwoAmounts condition = new ConditionTransactionBetweenTwoAmounts<>(100, 100, false);
        assertTrue(condition.test(this.getTransaction(101)));
        condition = new ConditionTransactionBetweenTwoAmounts<>(100, 125, false);
        assertTrue(condition.test(this.getTransaction(99)));
        assertTrue(condition.test(this.getTransaction(126)));
        assertTrue(condition.isExclusive());
    }

    @Test
    public void testBetweenNotOkExclusive() throws WrongArgsException {
        ConditionTransactionBetweenTwoAmounts condition = new ConditionTransactionBetweenTwoAmounts<>(100, 100, false);
        assertFalse(condition.test(this.getTransaction(100)));
        condition = new ConditionTransactionBetweenTwoAmounts<>(100, 125, false);
        assertFalse(condition.test(this.getTransaction(100)));
        assertFalse(condition.test(this.getTransaction(125)));
        assertFalse(condition.test(this.getTransaction(115)));
        assertTrue(condition.isExclusive());
    }

    public final Transaction getTransaction(double amount) {
        Transaction t = new GenericTransaction(amount, null, "", TransactionType.CHARGE);
        return t;
    }
}
