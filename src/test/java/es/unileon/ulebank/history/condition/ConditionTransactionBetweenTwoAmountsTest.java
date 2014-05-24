/* Application developed for AW subject, belonging to passive operations
 group.*/
package es.unileon.ulebank.history.condition;

import java.util.Date;

import es.unileon.ulebank.exceptions.TransactionException;
import es.unileon.ulebank.history.GenericTransaction;
import es.unileon.ulebank.history.Transaction;
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
	public void testBetweenOk() throws WrongArgsException, TransactionException {
		ConditionTransactionBetweenTwoAmounts condition = new ConditionTransactionBetweenTwoAmounts<Transaction>(
				100, 100);
		assertTrue(condition.test(this.getTransaction(100)));
		condition = new ConditionTransactionBetweenTwoAmounts<Transaction>(100,
				125);
		assertTrue(condition.test(this.getTransaction(100)));
		assertTrue(condition.test(this.getTransaction(125)));
		assertTrue(condition.test(this.getTransaction(115)));

	}

	@Test
	public void testBetweenNotOk() throws WrongArgsException,
			TransactionException {
		ConditionTransactionBetweenTwoAmounts condition = new ConditionTransactionBetweenTwoAmounts<Transaction>(
				100, 100);
		assertFalse(condition.test(this.getTransaction(101)));
		condition = new ConditionTransactionBetweenTwoAmounts<Transaction>(100,
				125);
		assertFalse(condition.test(this.getTransaction(99)));
		assertFalse(condition.test(this.getTransaction(126)));

	}

	public final Transaction getTransaction(double amount)
			throws TransactionException {
		Transaction t = new GenericTransaction(amount, new Date(), "subject");
		return t;
	}
}
