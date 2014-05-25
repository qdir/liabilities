/* Application developed for AW subject, belonging to passive operations
 group.*/
package es.unileon.ulebank.history.condition;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import es.unileon.ulebank.exceptions.TransactionException;
import es.unileon.ulebank.history.GenericTransaction;
import es.unileon.ulebank.history.Transaction;
import es.unileon.ulebank.history.conditions.ConditionTransactionBetweenTwoDates;

/**
 *
 * @author runix
 */
public class ConditionalTransactionBetweenTwoDays {

	private static final long DAY_TIMESTAMP = 1000 * 24 * 60 * 60;

	private ConditionTransactionBetweenTwoDates<Transaction> conditionBetween;

	private Date min;
	private Date max;

	@Before
	public void setup() throws Exception {
		this.min = new Date(DAY_TIMESTAMP * 10 - DAY_TIMESTAMP / 2);
		this.max = new Date(DAY_TIMESTAMP * 20 + DAY_TIMESTAMP / 2);
		this.conditionBetween = new ConditionTransactionBetweenTwoDates<Transaction>(
				min, max);
	}

	@Test
	public void testConditionBetweenOK() throws TransactionException {
		assertTrue(this.conditionBetween.test(this
				.getTransaction(new Date(this.min.getTime()
						+ (this.max.getTime() - this.min.getTime())))));
		assertTrue(this.conditionBetween.test(this.getTransaction(new Date(
				this.min.getTime()))));
		assertTrue(this.conditionBetween.test(this.getTransaction(new Date(
				this.max.getTime()))));

	}

	@Test
	public void testConditionBetweenNoOK() throws TransactionException {
		assertFalse(this.conditionBetween.test(this.getTransaction(new Date(
				this.min.getTime() - 1))));
		assertFalse(this.conditionBetween.test(this.getTransaction(new Date(
				this.max.getTime() + 1))));

	}

	public final Transaction getTransaction(Date date)
			throws TransactionException {
		Transaction t = new GenericTransaction(0, date, "subject");
		t.setEffectiveDate(date);
		return t;
	}
}
